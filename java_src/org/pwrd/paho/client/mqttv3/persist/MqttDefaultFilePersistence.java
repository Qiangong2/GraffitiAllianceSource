package org.pwrd.paho.client.mqttv3.persist;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import org.pwrd.paho.client.mqttv3.MqttClientPersistence;
import org.pwrd.paho.client.mqttv3.MqttPersistable;
import org.pwrd.paho.client.mqttv3.MqttPersistenceException;
import org.pwrd.paho.client.mqttv3.internal.FileLock;
import org.pwrd.paho.client.mqttv3.internal.MqttPersistentData;

public class MqttDefaultFilePersistence implements MqttClientPersistence {
    private static final FilenameFilter FILE_FILTER = new FilenameFilter() {
        /* class org.pwrd.paho.client.mqttv3.persist.MqttDefaultFilePersistence.C21941 */

        public boolean accept(File dir, String name) {
            return name.endsWith(MqttDefaultFilePersistence.MESSAGE_FILE_EXTENSION);
        }
    };
    private static final String LOCK_FILENAME = ".lck";
    private static final String MESSAGE_BACKUP_FILE_EXTENSION = ".bup";
    private static final String MESSAGE_FILE_EXTENSION = ".msg";
    private File clientDir;
    private File dataDir;
    private FileLock fileLock;

    public MqttDefaultFilePersistence() {
        this(System.getProperty("user.dir"));
    }

    public MqttDefaultFilePersistence(String directory) {
        this.clientDir = null;
        this.fileLock = null;
        this.dataDir = new File(directory);
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void open(String clientId, String theConnection) throws MqttPersistenceException {
        if (this.dataDir.exists() && !this.dataDir.isDirectory()) {
            throw new MqttPersistenceException();
        } else if (!this.dataDir.exists() && !this.dataDir.mkdirs()) {
            throw new MqttPersistenceException();
        } else if (!this.dataDir.canWrite()) {
            throw new MqttPersistenceException();
        } else {
            StringBuffer keyBuffer = new StringBuffer();
            for (int i = 0; i < clientId.length(); i++) {
                char c = clientId.charAt(i);
                if (isSafeChar(c)) {
                    keyBuffer.append(c);
                }
            }
            keyBuffer.append("-");
            for (int i2 = 0; i2 < theConnection.length(); i2++) {
                char c2 = theConnection.charAt(i2);
                if (isSafeChar(c2)) {
                    keyBuffer.append(c2);
                }
            }
            synchronized (this) {
                if (this.clientDir == null) {
                    this.clientDir = new File(this.dataDir, keyBuffer.toString());
                    if (!this.clientDir.exists()) {
                        this.clientDir.mkdir();
                    }
                }
                try {
                    this.fileLock = new FileLock(this.clientDir, LOCK_FILENAME);
                    restoreBackups(this.clientDir);
                } catch (Exception e) {
                    throw new MqttPersistenceException(32200);
                }
            }
        }
    }

    private void checkIsOpen() throws MqttPersistenceException {
        if (this.clientDir == null) {
            throw new MqttPersistenceException();
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void close() throws MqttPersistenceException {
        synchronized (this) {
            if (this.fileLock != null) {
                this.fileLock.release();
            }
            if (getFiles().length == 0) {
                this.clientDir.delete();
            }
            this.clientDir = null;
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void put(String key, MqttPersistable message) throws MqttPersistenceException {
        checkIsOpen();
        File file = new File(this.clientDir, String.valueOf(key) + MESSAGE_FILE_EXTENSION);
        File backupFile = new File(this.clientDir, String.valueOf(key) + MESSAGE_FILE_EXTENSION + MESSAGE_BACKUP_FILE_EXTENSION);
        if (file.exists() && !file.renameTo(backupFile)) {
            backupFile.delete();
            file.renameTo(backupFile);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(message.getHeaderBytes(), message.getHeaderOffset(), message.getHeaderLength());
            if (message.getPayloadBytes() != null) {
                fos.write(message.getPayloadBytes(), message.getPayloadOffset(), message.getPayloadLength());
            }
            fos.getFD().sync();
            fos.close();
            if (backupFile.exists()) {
                backupFile.delete();
            }
            if (backupFile.exists() && !backupFile.renameTo(file)) {
                file.delete();
                backupFile.renameTo(file);
            }
        } catch (IOException ex) {
            throw new MqttPersistenceException(ex);
        } catch (Throwable th) {
            if (backupFile.exists() && !backupFile.renameTo(file)) {
                file.delete();
                backupFile.renameTo(file);
            }
            throw th;
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public MqttPersistable get(String key) throws MqttPersistenceException {
        checkIsOpen();
        try {
            FileInputStream fis = new FileInputStream(new File(this.clientDir, String.valueOf(key) + MESSAGE_FILE_EXTENSION));
            int size = fis.available();
            byte[] data = new byte[size];
            for (int read = 0; read < size; read += fis.read(data, read, size - read)) {
            }
            fis.close();
            return new MqttPersistentData(key, data, 0, data.length, null, 0, 0);
        } catch (IOException ex) {
            throw new MqttPersistenceException(ex);
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void remove(String key) throws MqttPersistenceException {
        checkIsOpen();
        File file = new File(this.clientDir, String.valueOf(key) + MESSAGE_FILE_EXTENSION);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public Enumeration keys() throws MqttPersistenceException {
        checkIsOpen();
        File[] files = getFiles();
        Vector result = new Vector(files.length);
        for (File file : files) {
            String filename = file.getName();
            result.addElement(filename.substring(0, filename.length() - MESSAGE_FILE_EXTENSION.length()));
        }
        return result.elements();
    }

    private File[] getFiles() throws MqttPersistenceException {
        checkIsOpen();
        File[] files = this.clientDir.listFiles(FILE_FILTER);
        if (files != null) {
            return files;
        }
        throw new MqttPersistenceException();
    }

    private boolean isSafeChar(char c) {
        return Character.isJavaIdentifierPart(c) || c == '-';
    }

    private void restoreBackups(File dir) throws MqttPersistenceException {
        File[] files = dir.listFiles(new FileFilter() {
            /* class org.pwrd.paho.client.mqttv3.persist.MqttDefaultFilePersistence.C21952 */

            public boolean accept(File f) {
                return f.getName().endsWith(MqttDefaultFilePersistence.MESSAGE_BACKUP_FILE_EXTENSION);
            }
        });
        if (files == null) {
            throw new MqttPersistenceException();
        }
        for (int i = 0; i < files.length; i++) {
            File originalFile = new File(dir, files[i].getName().substring(0, files[i].getName().length() - MESSAGE_BACKUP_FILE_EXTENSION.length()));
            if (!files[i].renameTo(originalFile)) {
                originalFile.delete();
                files[i].renameTo(originalFile);
            }
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public boolean containsKey(String key) throws MqttPersistenceException {
        checkIsOpen();
        return new File(this.clientDir, String.valueOf(key) + MESSAGE_FILE_EXTENSION).exists();
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttClientPersistence
    public void clear() throws MqttPersistenceException {
        File[] files;
        checkIsOpen();
        for (File file : getFiles()) {
            file.delete();
        }
    }
}
