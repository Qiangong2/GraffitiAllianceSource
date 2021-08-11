package com.tencent.cos.xml.utils;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DigestUtils {
    public static String getMD5(String filePath) throws CosXmlClientException {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        if (filePath == null) {
            throw new CosXmlClientException("file Path is null");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new CosXmlClientException("file Path is not exist");
        }
        FileInputStream fileInputStream = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] buffer = new byte[32768];
                while (true) {
                    int len = fileInputStream2.read(buffer);
                    if (len != -1) {
                        messageDigest.update(buffer, 0, len);
                    } else {
                        String md5 = StringUtils.toHexString(messageDigest.digest());
                        CloseUtil.closeQuietly(fileInputStream2);
                        return md5;
                    }
                }
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                fileInputStream = fileInputStream2;
                try {
                    throw new CosXmlClientException(e);
                } catch (Throwable th2) {
                    th = th2;
                    CloseUtil.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e2 = e4;
                throw new CosXmlClientException(e2);
            } catch (IOException e5) {
                e = e5;
                throw new CosXmlClientException(e);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                CloseUtil.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            throw new CosXmlClientException(e);
        } catch (FileNotFoundException e7) {
            e2 = e7;
            throw new CosXmlClientException(e2);
        } catch (IOException e8) {
            e = e8;
            throw new CosXmlClientException(e);
        }
    }

    public static String getSha1(String content) throws CosXmlClientException {
        try {
            return StringUtils.toHexString(MessageDigest.getInstance("SHA-1").digest(content.getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            throw new CosXmlClientException(e);
        }
    }

    public static String getSHA1FromPath(String filePath) throws CosXmlClientException {
        NoSuchAlgorithmException e;
        IOException e2;
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(filePath);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                byte[] buffer = new byte[65536];
                while (true) {
                    int len = fileInputStream2.read(buffer, 0, buffer.length);
                    if (len != -1) {
                        messageDigest.update(buffer, 0, len);
                    } else {
                        String sha1 = StringUtils.toHexString(messageDigest.digest());
                        CloseUtil.closeQuietly(fileInputStream2);
                        return sha1;
                    }
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream = fileInputStream2;
                try {
                    throw new CosXmlClientException(e);
                } catch (Throwable th2) {
                    th = th2;
                    CloseUtil.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (IOException e4) {
                e2 = e4;
                throw new CosXmlClientException(e2);
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                throw new CosXmlClientException(e);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                CloseUtil.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            throw new CosXmlClientException(e);
        } catch (IOException e7) {
            e2 = e7;
            throw new CosXmlClientException(e2);
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            throw new CosXmlClientException(e);
        }
    }

    public static String getSHA1FromBytes(byte[] data, int offset, int len) throws CosXmlClientException {
        if (data == null || len <= 0 || offset < 0) {
            throw new CosXmlClientException("data == null | len <= 0 |offset < 0 |offset >= len");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(data, offset, len);
            return StringUtils.toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new CosXmlClientException(e);
        } catch (OutOfMemoryError e2) {
            throw new CosXmlClientException(e2);
        }
    }

    public static String getHmacSha1(String content, String key) throws CosXmlClientException {
        try {
            SecretKey hmacKey = new SecretKeySpec(key.getBytes(Charset.forName("UTF-8")), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(hmacKey);
            return StringUtils.toHexString(mac.doFinal(content.getBytes(Charset.forName("UTF-8"))));
        } catch (NoSuchAlgorithmException e) {
            throw new CosXmlClientException(e);
        } catch (InvalidKeyException e2) {
            throw new CosXmlClientException(e2);
        }
    }
}
