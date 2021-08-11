package com.igexin.p012b.p013a.p015b;

import android.support.p007v4.media.TransportMediator;
import android.support.p007v4.widget.ExploreByTouchHelper;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.b.a.b.f */
public final class C0459f {
    /* renamed from: a */
    public static int m1675a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        return 4;
    }

    /* renamed from: a */
    public static int m1676a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) ((j >> 56) & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 7] = (byte) ((int) (255 & j));
        return 8;
    }

    /* renamed from: a */
    public static int m1677a(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    /* renamed from: a */
    public static int m1678a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        System.arraycopy(bArr, i, bArr2, i2, i3);
        return i3;
    }

    /* renamed from: a */
    public static String m1679a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (!strArr[0].equals("")) {
            sb.append(strArr[0]).append("://");
        }
        if (!strArr[1].equals("")) {
            sb.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            sb.append(':').append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            sb.append(strArr[3]);
            if (!strArr[3].equals(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            }
        }
        if (!strArr[4].equals("")) {
            sb.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            sb.append('?').append(strArr[5]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m1680a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m1681a(InputStream inputStream, OutputStream outputStream, int i) {
        C0436a aVar = new C0436a(outputStream, i);
        m1680a(inputStream, aVar);
        aVar.mo4123a();
    }

    /* renamed from: a */
    public static byte[] m1682a(int i) {
        int i2 = 0;
        int i3 = 0;
        do {
            int i4 = ((i & TransportMediator.KEYCODE_MEDIA_PAUSE) << 24) | i2;
            i >>>= 7;
            i3++;
            if (i > 0) {
                i2 = (i4 >>> 8) | ExploreByTouchHelper.INVALID_ID;
                continue;
            } else {
                i2 = i4;
                continue;
            }
        } while (i > 0);
        byte[] bArr = new byte[i3];
        int i5 = 24;
        for (int i6 = 0; i6 < i3; i6++) {
            bArr[i6] = (byte) (i2 >>> i5);
            i5 -= 8;
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m1683a(byte[] bArr) {
        return m1691c(bArr);
    }

    /* renamed from: a */
    public static String[] m1684a(String str) {
        StringBuilder sb = new StringBuilder(str.toLowerCase());
        String[] strArr = new String[6];
        for (int i = 0; i < 6; i++) {
            strArr[i] = "";
        }
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            strArr[0] = str.substring(0, indexOf);
            sb.delete(0, indexOf + 1);
        } else if (indexOf == 0) {
            throw new IllegalArgumentException("url format error - protocol");
        }
        if (sb.length() >= 2 && sb.charAt(0) == '/' && sb.charAt(1) == '/') {
            sb.delete(0, 2);
            int indexOf2 = sb.toString().indexOf(47);
            if (indexOf2 < 0) {
                indexOf2 = sb.length();
            }
            if (indexOf2 != 0) {
                int indexOf3 = sb.toString().indexOf(58);
                if (indexOf3 < 0) {
                    indexOf3 = indexOf2;
                } else if (indexOf3 > indexOf2) {
                    throw new IllegalArgumentException("url format error - port");
                } else {
                    strArr[2] = sb.toString().substring(indexOf3 + 1, indexOf2);
                }
                strArr[1] = sb.toString().substring(0, indexOf3);
                sb.delete(0, indexOf2);
            }
        }
        if (sb.length() > 0) {
            String sb2 = sb.toString();
            int lastIndexOf = sb2.lastIndexOf(47);
            if (lastIndexOf > 0) {
                strArr[3] = sb2.substring(0, lastIndexOf);
            } else if (lastIndexOf == 0) {
                if (sb2.indexOf(63) > 0) {
                    throw new IllegalArgumentException("url format error - path");
                }
                strArr[3] = sb2;
                return strArr;
            }
            if (lastIndexOf < sb2.length() - 1) {
                String substring = sb2.substring(lastIndexOf + 1, sb2.length());
                int indexOf4 = substring.indexOf(63);
                if (indexOf4 >= 0) {
                    strArr[4] = substring.substring(0, indexOf4);
                    strArr[5] = substring.substring(indexOf4 + 1);
                } else {
                    strArr[4] = substring;
                }
            }
        } else {
            strArr[3] = MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        return strArr;
    }

    /* renamed from: b */
    public static int m1685b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        return 2;
    }

    /* renamed from: b */
    public static short m1686b(byte[] bArr, int i) {
        return (short) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
    }

    /* renamed from: b */
    public static byte[] m1687b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    /* renamed from: b */
    public static byte[] m1688b(byte[] bArr) {
        return m1693d(bArr);
    }

    /* renamed from: c */
    public static int m1689c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        return 1;
    }

    /* renamed from: c */
    public static int m1690c(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022 A[SYNTHETIC, Splitter:B:14:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031 A[SYNTHETIC, Splitter:B:22:0x0031] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m1691c(byte[] r5) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch:{ Throwable -> 0x001e, all -> 0x002b }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x001e, all -> 0x002b }
            r1.write(r5)     // Catch:{ Throwable -> 0x0044, all -> 0x0042 }
            r1.finish()     // Catch:{ Throwable -> 0x0044, all -> 0x0042 }
            byte[] r0 = r2.toByteArray()     // Catch:{ Throwable -> 0x0044, all -> 0x0042 }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ Exception -> 0x0038 }
        L_0x001a:
            r2.close()     // Catch:{ Exception -> 0x003a }
        L_0x001d:
            return r0
        L_0x001e:
            r1 = move-exception
            r1 = r0
        L_0x0020:
            if (r1 == 0) goto L_0x0025
            r1.close()     // Catch:{ Exception -> 0x003c }
        L_0x0025:
            r2.close()     // Catch:{ Exception -> 0x0029 }
            goto L_0x001d
        L_0x0029:
            r1 = move-exception
            goto L_0x001d
        L_0x002b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ Exception -> 0x003e }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0037:
            throw r0
        L_0x0038:
            r1 = move-exception
            goto L_0x001a
        L_0x003a:
            r1 = move-exception
            goto L_0x001d
        L_0x003c:
            r1 = move-exception
            goto L_0x0025
        L_0x003e:
            r1 = move-exception
            goto L_0x0034
        L_0x0040:
            r1 = move-exception
            goto L_0x0037
        L_0x0042:
            r0 = move-exception
            goto L_0x002f
        L_0x0044:
            r3 = move-exception
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.p012b.p013a.p015b.C0459f.m1691c(byte[]):byte[]");
    }

    /* renamed from: d */
    public static int m1692d(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e A[SYNTHETIC, Splitter:B:11:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0023 A[SYNTHETIC, Splitter:B:14:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0045 A[SYNTHETIC, Splitter:B:32:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004a A[SYNTHETIC, Splitter:B:35:0x004a] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m1693d(byte[] r7) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.p012b.p013a.p015b.C0459f.m1693d(byte[]):byte[]");
    }

    /* renamed from: e */
    public static long m1694e(byte[] bArr, int i) {
        return ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8) | (((long) bArr[i + 7]) & 255);
    }

    /* renamed from: f */
    public static byte[] m1695f(byte[] bArr, int i) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m1681a(byteArrayInputStream, byteArrayOutputStream, i);
            try {
                byteArrayInputStream.close();
            } catch (Throwable th) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th4) {
            }
            byteArrayOutputStream.close();
            throw th3;
        }
    }
}
