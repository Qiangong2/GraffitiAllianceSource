package com.tencent.cos.xml.utils;

import android.util.Log;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public static String tempCache(InputStream inputStream) throws CosXmlClientException {
        Throwable th;
        if (inputStream == null) {
            return null;
        }
        FileOutputStream fileOutputStream = null;
        try {
            String tempPath = CosXmlSimpleService.appCachePath + File.separator + "temp.tmp";
            Log.d("UnitTest", tempPath);
            File tempFile = new File(tempPath);
            if (tempFile.exists()) {
                tempFile.delete();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(tempFile);
            try {
                byte[] buffer = new byte[65536];
                while (true) {
                    int receiveLen = inputStream.read(buffer, 0, buffer.length);
                    if (receiveLen > 0) {
                        fileOutputStream2.write(buffer, 0, receiveLen);
                    } else {
                        fileOutputStream2.flush();
                        CloseUtil.closeQuietly(fileOutputStream2);
                        CloseUtil.closeQuietly(inputStream);
                        return tempPath;
                    }
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    throw new CosXmlClientException(e);
                } catch (Throwable th2) {
                    th = th2;
                    CloseUtil.closeQuietly(fileOutputStream);
                    CloseUtil.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                CloseUtil.closeQuietly(fileOutputStream);
                CloseUtil.closeQuietly(inputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            throw new CosXmlClientException(e);
        }
    }
}
