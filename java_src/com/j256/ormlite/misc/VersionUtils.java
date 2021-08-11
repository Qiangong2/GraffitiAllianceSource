package com.j256.ormlite.misc;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class VersionUtils {
    private static final String ANDROID_VERSION_FILE = "/com/j256/ormlite/android/VERSION.txt";
    private static final String CORE_VERSION_FILE = "/com/j256/ormlite/core/VERSION.txt";
    private static final String JDBC_VERSION_FILE = "/com/j256/ormlite/jdbc/VERSION.txt";
    private static String androidVersionFile = ANDROID_VERSION_FILE;
    private static String coreVersionFile = CORE_VERSION_FILE;
    private static String jdbcVersionFile = JDBC_VERSION_FILE;
    private static Logger logger;
    private static boolean thrownOnErrors = false;

    private VersionUtils() {
    }

    public static final void checkCoreVersusJdbcVersions() {
        logVersionErrors("core", readCoreVersion(), "jdbc", readJdbcVersion());
    }

    public static final void checkCoreVersusAndroidVersions() {
        logVersionErrors("core", readCoreVersion(), "android", readAndroidVersion());
    }

    static void setCoreVersionFile(String coreVersionFile2) {
        coreVersionFile = coreVersionFile2;
    }

    static void setJdbcVersionFile(String jdbcVersionFile2) {
        jdbcVersionFile = jdbcVersionFile2;
    }

    static void setAndroidVersionFile(String androidVersionFile2) {
        androidVersionFile = androidVersionFile2;
    }

    static void setThrownOnErrors(boolean thrownOnErrors2) {
        thrownOnErrors = thrownOnErrors2;
    }

    private static void logVersionErrors(String label1, String version1, String label2, String version2) {
        if (version1 == null) {
            if (version2 != null) {
                error(null, "Unknown version for {}, version for {} is '{}'", label1, label2, version2);
            }
        } else if (version2 == null) {
            error(null, "Unknown version for {}, version for {} is '{}'", label2, label1, version1);
        } else if (!version1.equals(version2)) {
            error(null, "Mismatched versions: {} is '{}', while {} is '{}'", new Object[]{label1, version1, label2, version2});
        }
    }

    private static String readCoreVersion() {
        return getVersionFromFile(coreVersionFile);
    }

    private static String readJdbcVersion() {
        return getVersionFromFile(jdbcVersionFile);
    }

    private static String readAndroidVersion() {
        return getVersionFromFile(androidVersionFile);
    }

    private static String getVersionFromFile(String file) {
        InputStream inputStream = VersionUtils.class.getResourceAsStream(file);
        if (inputStream == null) {
            error(null, "Could not find version file {}", file, null, null);
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String version = reader.readLine();
            try {
                reader.close();
            } catch (IOException e) {
            }
            if (version != null) {
                return version;
            }
            error(null, "No version specified in {}", file, null, null);
            return version;
        } catch (IOException e2) {
            error(e2, "Could not read version from {}", file, null, null);
            try {
                reader.close();
            } catch (IOException e3) {
            }
            return null;
        } catch (Throwable th) {
            try {
                reader.close();
            } catch (IOException e4) {
            }
            throw th;
        }
    }

    private static void error(Throwable th, String msg, Object arg0, Object arg1, Object arg2) {
        getLogger().error(th, msg, arg0, arg1, arg2);
        if (thrownOnErrors) {
            throw new IllegalStateException("See error log for details: " + msg);
        }
    }

    private static void error(Throwable th, String msg, Object[] args) {
        getLogger().error(th, msg, args);
        if (thrownOnErrors) {
            throw new IllegalStateException("See error log for details:" + msg);
        }
    }

    private static Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(VersionUtils.class);
        }
        return logger;
    }
}
