package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.loc.C0256az;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/* renamed from: com.amap.loc.av */
/* compiled from: DexFileManager */
public class C0249av {

    /* renamed from: com.amap.loc.av$a */
    /* compiled from: DexFileManager */
    public static class C0251a {
        /* renamed from: a */
        public static C0256az m568a(C0228ac acVar, String str) {
            List b = acVar.mo3650b(C0256az.m593b(str), C0256az.class);
            if (b == null || b.size() <= 0) {
                return null;
            }
            return (C0256az) b.get(0);
        }

        /* renamed from: a */
        public static List<C0256az> m569a(C0228ac acVar, String str, String str2) {
            return acVar.mo3650b(C0256az.m594b(str, str2), C0256az.class);
        }

        /* renamed from: a */
        public static void m570a(C0228ac acVar, C0256az azVar, String str) {
            acVar.mo3645a(azVar, str);
        }
    }

    /* renamed from: a */
    static String m552a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    /* renamed from: a */
    static String m553a(Context context, C0228ac acVar, C0360q qVar) {
        List b = acVar.mo3650b(C0256az.m594b(qVar.mo3939a(), "copy"), C0256az.class);
        if (b == null || b.size() == 0) {
            return null;
        }
        C0263ba.m658a(b);
        for (int i = 0; i < b.size(); i++) {
            C0256az azVar = (C0256az) b.get(i);
            if (C0263ba.m659a(context, acVar, azVar.mo3706a(), qVar)) {
                try {
                    m557a(context, acVar, qVar, m554a(context, azVar.mo3706a()), azVar.mo3710d());
                    return azVar.mo3710d();
                } catch (Throwable th) {
                    C0263ba.m657a(th, "FileManager", "loadAvailableD");
                }
            } else {
                m566c(context, acVar, azVar.mo3706a());
            }
        }
        return null;
    }

    /* renamed from: a */
    static String m554a(Context context, String str) {
        return m552a(context) + File.separator + str;
    }

    /* renamed from: a */
    static String m555a(Context context, String str, String str2) {
        return C0356n.m1305b(str + str2 + C0353l.m1284q(context)) + ".png";
    }

    /* renamed from: a */
    static String m556a(String str) {
        return str + ".o";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    static void m557a(Context context, C0228ac acVar, C0360q qVar, String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        try {
            String a = qVar.mo3939a();
            String a2 = m555a(context, a, qVar.mo3941b());
            m558a(context, acVar, a2);
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                fileInputStream2.read(new byte[32]);
                File file = new File(m563b(context, a, qVar.mo3941b()));
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            C0256az a3 = new C0256az.C0257a(a2, C0356n.m1302a(file.getAbsolutePath()), a, qVar.mo3941b(), str2).mo3712a("used").mo3713a();
                            C0251a.m570a(acVar, a3, C0256az.m593b(a3.mo3706a()));
                            C0263ba.m656a(fileInputStream2);
                            C0263ba.m656a(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream3 = fileOutputStream;
                    C0263ba.m656a(fileInputStream2);
                    C0263ba.m656a(fileInputStream3);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C0263ba.m656a(fileInputStream2);
                C0263ba.m656a(fileInputStream3);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            C0263ba.m656a(fileInputStream2);
            C0263ba.m656a(fileInputStream3);
            throw th;
        }
    }

    /* renamed from: a */
    static void m558a(Context context, C0228ac acVar, String str) {
        m566c(context, acVar, str);
        m566c(context, acVar, m556a(str));
    }

    /* renamed from: a */
    static void m559a(Context context, C0360q qVar) {
        try {
            String b = m563b(context, qVar.mo3939a(), qVar.mo3941b());
            if (!TextUtils.isEmpty(b)) {
                File file = new File(b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String a = m554a(context, m556a(file.getName()));
                    DexFile loadDex = DexFile.loadDex(b, a, 0);
                    if (loadDex != null) {
                        loadDex.close();
                        m561a(context, file, a, qVar);
                    }
                } else if (parentFile != null && parentFile.exists()) {
                    m567c(context, qVar.mo3939a(), qVar.mo3941b());
                }
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "BaseClassLoader", "getInstanceByThread()");
        }
    }

    /* renamed from: a */
    static void m560a(Context context, File file, C0360q qVar) {
        File parentFile = file.getParentFile();
        if (!file.exists() && parentFile != null && parentFile.exists()) {
            m567c(context, qVar.mo3939a(), qVar.mo3941b());
        }
    }

    /* renamed from: a */
    private static void m561a(Context context, File file, String str, C0360q qVar) {
        String str2 = null;
        C0228ac acVar = new C0228ac(context, C0255ay.m585c());
        C0256az a = C0251a.m568a(acVar, file.getName());
        if (a != null) {
            str2 = a.mo3710d();
        }
        File file2 = new File(str);
        if (!TextUtils.isEmpty(str2) && file2.exists()) {
            String a2 = C0356n.m1302a(str);
            String name = file2.getName();
            C0251a.m570a(acVar, new C0256az.C0257a(name, a2, qVar.mo3939a(), qVar.mo3941b(), str2).mo3712a("useod").mo3713a(), C0256az.m593b(name));
        }
    }

    /* renamed from: a */
    static void m562a(C0228ac acVar, Context context, String str) {
        List<C0256az> a = C0251a.m569a(acVar, str, "used");
        if (a != null && a.size() > 0) {
            for (C0256az azVar : a) {
                if (azVar != null) {
                    m558a(context, acVar, azVar.mo3706a());
                    List b = acVar.mo3650b(C0256az.m591a(str, azVar.mo3710d()), C0256az.class);
                    if (b != null && b.size() > 0) {
                        C0256az azVar2 = (C0256az) b.get(0);
                        azVar2.mo3709c("errorstatus");
                        C0251a.m570a(acVar, azVar2, C0256az.m593b(azVar2.mo3706a()));
                        File file = new File(m554a(context, azVar2.mo3706a()));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    static String m563b(Context context, String str, String str2) {
        return m554a(context, m555a(context, str, str2));
    }

    /* renamed from: b */
    static void m565b(Context context, String str) {
        C0228ac acVar = new C0228ac(context, C0255ay.m585c());
        List<C0256az> a = C0251a.m569a(acVar, str, "copy");
        C0263ba.m658a(a);
        if (a != null && a.size() > 1) {
            int size = a.size();
            for (int i = 1; i < size; i++) {
                m566c(context, acVar, a.get(i).mo3706a());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m566c(Context context, C0228ac acVar, String str) {
        File file = new File(m554a(context, str));
        if (file.exists()) {
            file.delete();
        }
        acVar.mo3647a(C0256az.m593b(str), C0256az.class);
    }

    /* renamed from: c */
    static void m567c(final Context context, final String str, final String str2) {
        C0371w.m1393b().submit(new Runnable() {
            /* class com.amap.loc.C0249av.RunnableC02501 */

            public void run() {
                try {
                    C0228ac acVar = new C0228ac(context, C0255ay.m585c());
                    List<C0256az> b = acVar.mo3650b(C0256az.m590a(str), C0256az.class);
                    if (b != null && b.size() > 0) {
                        for (C0256az azVar : b) {
                            if (!str2.equalsIgnoreCase(azVar.mo3708c())) {
                                C0249av.m566c(context, acVar, azVar.mo3706a());
                            }
                        }
                    }
                } catch (Throwable th) {
                    C0263ba.m657a(th, "FileManager", "clearUnSuitableV");
                }
            }
        });
    }
}
