package com.xiaomi.channel.commonutils.file;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* renamed from: com.xiaomi.channel.commonutils.file.a */
public class C1851a {

    /* renamed from: a */
    public static final String[] f4599a = {"jpg", "png", "bmp", "gif", "webp"};

    /* renamed from: a */
    public static void m6702a(File file, File file2) {
        Throwable th;
        IOException e;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
            try {
                m6707a(zipOutputStream, file2, null, null);
                m6704a(zipOutputStream);
            } catch (FileNotFoundException e2) {
                m6704a(zipOutputStream);
            } catch (IOException e3) {
                zipOutputStream2 = zipOutputStream;
                e = e3;
                try {
                    AbstractC1855b.m6718a("zip file failure + " + e.getMessage());
                    m6704a(zipOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    m6704a(zipOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                zipOutputStream2 = zipOutputStream;
                th = th3;
                m6704a(zipOutputStream2);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            zipOutputStream = null;
            m6704a(zipOutputStream);
        } catch (IOException e5) {
            e = e5;
            AbstractC1855b.m6718a("zip file failure + " + e.getMessage());
            m6704a(zipOutputStream2);
        }
    }

    /* renamed from: a */
    public static void m6703a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m6704a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
            }
            try {
                outputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    /* renamed from: a */
    public static void m6705a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m6706a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m6707a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (str == null) {
            str = "";
        }
        try {
            if (file.isDirectory()) {
                File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                zipOutputStream.putNextEntry(new ZipEntry(str + File.separator));
                String str2 = TextUtils.isEmpty(str) ? "" : str + File.separator;
                for (int i = 0; i < listFiles.length; i++) {
                    m6707a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), null);
                }
                File[] listFiles2 = file.listFiles(new C1852b());
                if (listFiles2 != null) {
                    for (File file2 : listFiles2) {
                        m6707a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                    }
                }
                fileInputStream = null;
            } else {
                if (!TextUtils.isEmpty(str)) {
                    zipOutputStream.putNextEntry(new ZipEntry(str));
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + ".txt"));
                }
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    fileInputStream2 = fileInputStream;
                    e = e;
                    try {
                        AbstractC1855b.m6723d("zipFiction failed with exception:" + e.toString());
                        m6703a(fileInputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        m6703a(fileInputStream2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileInputStream2 = fileInputStream;
                    th = th3;
                    m6703a(fileInputStream2);
                    throw th;
                }
            }
            m6703a(fileInputStream);
        } catch (IOException e2) {
            e = e2;
            AbstractC1855b.m6723d("zipFiction failed with exception:" + e.toString());
            m6703a(fileInputStream2);
        }
    }
}
