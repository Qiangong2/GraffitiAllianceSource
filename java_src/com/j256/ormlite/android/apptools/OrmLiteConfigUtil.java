package com.j256.ormlite.android.apptools;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.p083db.SqliteAndroidDatabaseType;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrmLiteConfigUtil {
    protected static final String RAW_DIR_NAME = "raw";
    protected static final String RESOURCE_DIR_NAME = "res";
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    protected static int maxFindSourceLevel = 20;

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Main can take a single file-name argument.");
        }
        writeConfigFile(args[0]);
    }

    public static void writeConfigFile(String fileName) throws SQLException, IOException {
        List<Class<?>> classList = findAnnotatedClasses(new File("."), 0);
        writeConfigFile(fileName, (Class[]) classList.toArray(new Class[classList.size()]));
    }

    public static void writeConfigFile(String fileName, Class<?>[] clsArr) throws SQLException, IOException {
        File rawDir = findRawDir(new File("."));
        if (rawDir == null) {
            System.err.println("Could not find raw directory");
        } else {
            writeConfigFile(new File(rawDir, fileName), clsArr);
        }
    }

    public static void writeConfigFile(File configFile) throws SQLException, IOException {
        writeConfigFile(configFile, new File("."));
    }

    public static void writeConfigFile(File configFile, File searchDir) throws SQLException, IOException {
        List<Class<?>> classList = findAnnotatedClasses(searchDir, 0);
        writeConfigFile(configFile, (Class[]) classList.toArray(new Class[classList.size()]));
    }

    public static void writeConfigFile(File configFile, Class<?>[] clsArr) throws SQLException, IOException {
        System.out.println("Writing configurations to " + configFile.getAbsolutePath());
        writeConfigFile(new FileOutputStream(configFile), clsArr);
    }

    public static void writeConfigFile(OutputStream outputStream, File searchDir) throws SQLException, IOException {
        List<Class<?>> classList = findAnnotatedClasses(searchDir, 0);
        writeConfigFile(outputStream, (Class[]) classList.toArray(new Class[classList.size()]));
    }

    public static void writeConfigFile(OutputStream outputStream, Class<?>[] clsArr) throws SQLException, IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream), 4096);
        try {
            writeHeader(writer);
            for (Class<?> clazz : clsArr) {
                writeConfigForTable(writer, clazz);
            }
            System.out.println("Done.");
        } finally {
            writer.close();
        }
    }

    protected static File findRawDir(File dir) {
        int i = 0;
        while (dir != null && i < 20) {
            File rawDir = findResRawDir(dir);
            if (rawDir != null) {
                return rawDir;
            }
            dir = dir.getParentFile();
            i++;
        }
        return null;
    }

    private static void writeHeader(BufferedWriter writer) throws IOException {
        writer.append('#');
        writer.newLine();
        writer.append("# generated on ").append((CharSequence) new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
        writer.newLine();
        writer.append('#');
        writer.newLine();
    }

    private static List<Class<?>> findAnnotatedClasses(File dir, int level) throws SQLException, IOException {
        List<Class<?>> classList = new ArrayList<>();
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                if (level < maxFindSourceLevel) {
                    findAnnotatedClasses(file, level + 1);
                }
            } else if (file.getName().endsWith(".java")) {
                String packageName = getPackageOfClass(file);
                if (packageName == null) {
                    System.err.println("Could not find package name for: " + file);
                } else {
                    String name = file.getName();
                    try {
                        Class<?> clazz = Class.forName(String.valueOf(packageName) + "." + name.substring(0, name.length() - ".java".length()));
                        if (classHasAnnotations(clazz)) {
                            classList.add(clazz);
                        }
                        Class<?>[] declaredClasses = clazz.getDeclaredClasses();
                        for (Class<?> innerClazz : declaredClasses) {
                            if (classHasAnnotations(innerClazz)) {
                                classList.add(innerClazz);
                            }
                        }
                    } catch (Throwable t) {
                        System.err.println("Could not load class file for: " + file);
                        System.err.println("     " + t);
                    }
                }
            }
        }
        return classList;
    }

    private static void writeConfigForTable(BufferedWriter writer, Class<?> clazz) throws SQLException, IOException {
        String tableName = DatabaseTableConfig.extractTableName(clazz);
        List<DatabaseFieldConfig> fieldConfigs = new ArrayList<>();
        for (Class<?> working = clazz; working != null; working = working.getSuperclass()) {
            try {
                for (Field field : working.getDeclaredFields()) {
                    DatabaseFieldConfig fieldConfig = DatabaseFieldConfig.fromField(databaseType, tableName, field);
                    if (fieldConfig != null) {
                        fieldConfigs.add(fieldConfig);
                    }
                }
            } catch (Error e) {
                System.err.println("Skipping " + clazz + " because we got an error finding its definition: " + e.getMessage());
                return;
            }
        }
        if (fieldConfigs.isEmpty()) {
            System.out.println("Skipping " + clazz + " because no annotated fields found");
            return;
        }
        DatabaseTableConfigLoader.write(writer, new DatabaseTableConfig<>(clazz, tableName, fieldConfigs));
        writer.append("#################################");
        writer.newLine();
        System.out.println("Wrote config for " + clazz);
    }

    private static boolean classHasAnnotations(Class<?> clazz) {
        while (clazz != null) {
            if (clazz.getAnnotation(DatabaseTable.class) != null) {
                return true;
            }
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (!(field.getAnnotation(DatabaseField.class) == null && field.getAnnotation(ForeignCollectionField.class) == null)) {
                        return true;
                    }
                }
                try {
                    clazz = clazz.getSuperclass();
                } catch (Throwable t) {
                    System.err.println("Could not get super class for: " + clazz);
                    System.err.println("     " + t);
                    return false;
                }
            } catch (Throwable t2) {
                System.err.println("Could not load get delcared fields from: " + clazz);
                System.err.println("     " + t2);
                return false;
            }
        }
        return false;
    }

    private static String getPackageOfClass(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    reader.close();
                    return null;
                } else if (line.contains("package")) {
                    String[] parts = line.split("[ \t;]");
                    if (parts.length > 1 && parts[0].equals("package")) {
                        return parts[1];
                    }
                }
            } finally {
                reader.close();
            }
        }
    }

    private static File findResRawDir(File dir) {
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            if (file.getName().equals(RESOURCE_DIR_NAME) && file.isDirectory()) {
                File[] rawFiles = file.listFiles(new FileFilter() {
                    /* class com.j256.ormlite.android.apptools.OrmLiteConfigUtil.C11801 */

                    public boolean accept(File file) {
                        return file.getName().equals(OrmLiteConfigUtil.RAW_DIR_NAME) && file.isDirectory();
                    }
                });
                if (rawFiles.length == 1) {
                    return rawFiles[0];
                }
            }
        }
        return null;
    }
}
