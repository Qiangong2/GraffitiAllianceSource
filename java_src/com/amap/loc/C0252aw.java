package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.loc.C0249av;
import com.amap.loc.C0256az;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Date;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* access modifiers changed from: package-private */
/* renamed from: com.amap.loc.aw */
/* compiled from: DynamicClassLoader */
public class C0252aw extends AbstractC0246as {

    /* renamed from: g */
    private PublicKey f330g = null;

    C0252aw(Context context, C0360q qVar, boolean z) throws Exception {
        super(context, qVar, z);
        String b = C0249av.m563b(context, qVar.mo3939a(), qVar.mo3941b());
        String a = C0249av.m552a(context);
        m579b(b, a);
        File file = new File(b);
        if (z) {
            mo3701a(b, a + File.separator + C0249av.m556a(file.getName()));
            m577b(context, b, a);
        }
    }

    /* renamed from: a */
    private void m571a(C0228ac acVar, File file) {
        C0256az a = C0249av.C0251a.m568a(acVar, file.getName());
        if (a != null) {
            this.f323f = a.mo3710d();
        }
    }

    /* renamed from: a */
    private void m572a(JarFile jarFile, JarEntry jarEntry) throws IOException {
        Closeable closeable = null;
        try {
            closeable = jarFile.getInputStream(jarEntry);
            do {
            } while (closeable.read(new byte[8192]) > 0);
        } catch (Throwable th) {
            C0263ba.m657a(th, "DyLoader", "loadJa");
        } finally {
            C0263ba.m656a(closeable);
        }
    }

    /* renamed from: a */
    private boolean m573a(C0228ac acVar, C0360q qVar, String str) {
        if (m575a(new File(str))) {
            return C0263ba.m660a(acVar, C0249av.m555a(this.f318a, qVar.mo3939a(), qVar.mo3941b()), str, qVar);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m574a(C0228ac acVar, String str, String str2) {
        String a = C0249av.m554a(this.f318a, str);
        if (C0263ba.m660a(acVar, str, a, this.f322e)) {
            return true;
        }
        if (C0249av.C0251a.m568a(acVar, str) != null) {
            return false;
        }
        if (!TextUtils.isEmpty(this.f323f)) {
            C0249av.C0251a.m570a(acVar, new C0256az.C0257a(str, C0356n.m1302a(a), this.f322e.mo3939a(), this.f322e.mo3941b(), str2).mo3712a("useod").mo3713a(), C0256az.m593b(str));
        }
        return true;
    }

    /* renamed from: a */
    private boolean m575a(File file) {
        JarFile jarFile;
        Throwable th;
        Throwable th2;
        try {
            m580c();
            jarFile = new JarFile(file);
            try {
                JarEntry jarEntry = jarFile.getJarEntry("classes.dex");
                if (jarEntry == null) {
                    C0263ba.m656a(jarFile);
                    return false;
                }
                m572a(jarFile, jarEntry);
                Certificate[] certificates = jarEntry.getCertificates();
                if (certificates == null) {
                    C0263ba.m656a(jarFile);
                    return false;
                }
                boolean a = m576a(file, certificates);
                C0263ba.m656a(jarFile);
                return a;
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    C0263ba.m657a(th2, "DyLoader", "verify");
                    C0263ba.m656a(jarFile);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    C0263ba.m656a(jarFile);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            jarFile = null;
            C0263ba.m656a(jarFile);
            throw th;
        }
    }

    /* renamed from: a */
    private boolean m576a(File file, Certificate[] certificateArr) {
        int length;
        try {
            if (certificateArr.length > 0 && certificateArr.length - 1 >= 0) {
                certificateArr[length].verify(this.f330g);
                return true;
            }
        } catch (Exception e) {
            C0263ba.m657a(e, "DyLoader", "check");
        }
        return false;
    }

    /* renamed from: b */
    private void m577b(final Context context, final String str, final String str2) {
        C0371w.m1393b().submit(new Runnable() {
            /* class com.amap.loc.C0252aw.RunnableC02531 */

            public void run() {
                try {
                    C0252aw.this.mo3700a(context, str, str2);
                } catch (Throwable th) {
                    C0263ba.m657a(th, "dLoader", "run()");
                }
            }
        });
    }

    /* renamed from: b */
    private void m578b(C0228ac acVar, File file) {
        this.f321d = false;
        C0249av.m558a(this.f318a, acVar, file.getName());
        String a = C0249av.m553a(this.f318a, acVar, this.f322e);
        if (!TextUtils.isEmpty(a)) {
            this.f323f = a;
            C0249av.m559a(this.f318a, this.f322e);
        }
    }

    /* renamed from: b */
    private void m579b(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new Exception("dexPath or dexOutputDir is null.");
        }
    }

    /* renamed from: c */
    private void m580c() {
        if (this.f330g == null) {
            this.f330g = C0263ba.m655a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3700a(Context context, String str, String str2) throws Exception {
        new Date().getTime();
        try {
            C0228ac acVar = new C0228ac(context, C0255ay.m585c());
            File file = new File(str);
            m571a(acVar, file);
            if (!m573a(acVar, this.f322e, file.getAbsolutePath())) {
                m578b(acVar, file);
            }
            if (file.exists()) {
                if (new File(str2 + File.separator + C0249av.m556a(file.getName())).exists() && !m574a(acVar, C0249av.m556a(file.getName()), this.f323f)) {
                    C0249av.m559a(this.f318a, this.f322e);
                }
                new Date().getTime();
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "dLoader", "verifyD()");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3701a(String str, String str2) throws Exception {
        try {
            if (this.f320c == null) {
                mo3694b();
                this.f320c = DexFile.loadDex(str, str2, 0);
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "dLoader", "loadFile");
            throw new Exception("load file fail");
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            if (this.f320c == null) {
                throw new ClassNotFoundException(str);
            }
            Class cls = (Class) this.f319b.get(str);
            if (cls == null) {
                cls = this.f320c.loadClass(str, this);
                if (cls == null) {
                    throw new ClassNotFoundException(str);
                }
                this.f319b.put(str, cls);
            }
            return cls;
        } catch (Throwable th) {
            C0263ba.m657a(th, "dLoader", "findCl");
            throw new ClassNotFoundException(str);
        }
    }
}
