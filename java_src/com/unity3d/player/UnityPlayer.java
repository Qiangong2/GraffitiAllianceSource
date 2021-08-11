package com.unity3d.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.unity3d.player.C1622j;
import com.unity3d.player.SurfaceHolder$CallbackC1629n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UnityPlayer extends FrameLayout implements AbstractC1613d {
    public static Activity currentActivity = null;

    /* renamed from: n */
    private static boolean f4013n;

    /* renamed from: a */
    C1602c f4014a = new C1602c(this, (byte) 0);

    /* renamed from: b */
    DialogC1618i f4015b = null;

    /* renamed from: c */
    private boolean f4016c = false;

    /* renamed from: d */
    private boolean f4017d = true;

    /* renamed from: e */
    private C1626l f4018e = new C1626l();

    /* renamed from: f */
    private final ConcurrentLinkedQueue f4019f = new ConcurrentLinkedQueue();

    /* renamed from: g */
    private BroadcastReceiver f4020g = null;

    /* renamed from: h */
    private boolean f4021h = false;

    /* renamed from: i */
    private C1600a f4022i = new C1600a(this, (byte) 0);

    /* renamed from: j */
    private TelephonyManager f4023j;

    /* renamed from: k */
    private C1622j f4024k;

    /* renamed from: l */
    private ContextWrapper f4025l;

    /* renamed from: m */
    private SurfaceView f4026m;

    /* renamed from: o */
    private boolean f4027o;

    /* renamed from: p */
    private Bundle f4028p = new Bundle();

    /* renamed from: q */
    private SurfaceHolder$CallbackC1629n f4029q;

    /* renamed from: r */
    private boolean f4030r = false;

    /* renamed from: s */
    private ProgressBar f4031s = null;

    /* renamed from: t */
    private Runnable f4032t = new Runnable() {
        /* class com.unity3d.player.UnityPlayer.RunnableC15955 */

        public final void run() {
            int nativeActivityIndicatorStyle = UnityPlayer.this.nativeActivityIndicatorStyle();
            if (nativeActivityIndicatorStyle >= 0) {
                if (UnityPlayer.this.f4031s == null) {
                    UnityPlayer.this.f4031s = new ProgressBar(UnityPlayer.this.f4025l, null, new int[]{16842874, 16843401, 16842873, 16843400}[nativeActivityIndicatorStyle]);
                    UnityPlayer.this.f4031s.setIndeterminate(true);
                    UnityPlayer.this.f4031s.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 51));
                    UnityPlayer.this.addView(UnityPlayer.this.f4031s);
                }
                UnityPlayer.this.f4031s.setVisibility(0);
                UnityPlayer.this.bringChildToFront(UnityPlayer.this.f4031s);
            }
        }
    };

    /* renamed from: u */
    private Runnable f4033u = new Runnable() {
        /* class com.unity3d.player.UnityPlayer.RunnableC15966 */

        public final void run() {
            if (UnityPlayer.this.f4031s != null) {
                UnityPlayer.this.f4031s.setVisibility(8);
                UnityPlayer.this.removeView(UnityPlayer.this.f4031s);
                UnityPlayer.this.f4031s = null;
            }
        }
    };

    /* renamed from: v */
    private C1607b f4034v = new C1607b(this);

    /* renamed from: com.unity3d.player.UnityPlayer$3 */
    class C15933 extends BroadcastReceiver {

        /* renamed from: a */
        final /* synthetic */ UnityPlayer f4069a;

        public void onReceive(Context context, Intent intent) {
            this.f4069a.m6059d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.unity3d.player.UnityPlayer$a */
    public class C1600a extends PhoneStateListener {
        private C1600a() {
        }

        /* synthetic */ C1600a(UnityPlayer unityPlayer, byte b) {
            this();
        }

        public final void onCallStateChanged(int i, String str) {
            boolean z = true;
            UnityPlayer unityPlayer = UnityPlayer.this;
            if (i != 1) {
                z = false;
            }
            unityPlayer.nativeMuteMasterAudio(z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.unity3d.player.UnityPlayer$b */
    public enum EnumC1601b {
        PAUSE,
        RESUME,
        QUIT,
        FOCUS_GAINED,
        FOCUS_LOST,
        NEXT_FRAME
    }

    /* access modifiers changed from: private */
    /* renamed from: com.unity3d.player.UnityPlayer$c */
    public class C1602c extends Thread {

        /* renamed from: a */
        Handler f4094a;

        /* renamed from: b */
        boolean f4095b;

        /* renamed from: c */
        int f4096c;

        private C1602c() {
            this.f4095b = false;
            this.f4096c = 5;
        }

        /* synthetic */ C1602c(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        private void m6091a(EnumC1601b bVar) {
            Message.obtain(this.f4094a, 2269, bVar).sendToTarget();
        }

        /* renamed from: a */
        public final void mo9042a() {
            m6091a(EnumC1601b.QUIT);
        }

        /* renamed from: a */
        public final void mo9043a(boolean z) {
            m6091a(z ? EnumC1601b.FOCUS_GAINED : EnumC1601b.FOCUS_LOST);
        }

        /* renamed from: b */
        public final void mo9044b() {
            m6091a(EnumC1601b.RESUME);
        }

        /* renamed from: c */
        public final void mo9045c() {
            m6091a(EnumC1601b.PAUSE);
        }

        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f4094a = new Handler(new Handler.Callback() {
                /* class com.unity3d.player.UnityPlayer.C1602c.C16031 */

                public final boolean handleMessage(Message message) {
                    if (message.what != 2269) {
                        return false;
                    }
                    EnumC1601b bVar = (EnumC1601b) message.obj;
                    if (bVar == EnumC1601b.QUIT) {
                        Looper.myLooper().quit();
                    } else if (bVar == EnumC1601b.RESUME) {
                        C1602c.this.f4095b = true;
                    } else if (bVar == EnumC1601b.PAUSE) {
                        C1602c.this.f4095b = false;
                        UnityPlayer.this.executeGLThreadJobs();
                    } else if (bVar == EnumC1601b.FOCUS_LOST) {
                        if (!C1602c.this.f4095b) {
                            UnityPlayer.this.executeGLThreadJobs();
                        }
                    } else if (bVar == EnumC1601b.NEXT_FRAME) {
                        if (C1602c.this.f4096c >= 0) {
                            if (C1602c.this.f4096c == 0 && UnityPlayer.this.f4028p.getBoolean("showSplash")) {
                                UnityPlayer.this.m6042a();
                            }
                            C1602c cVar = C1602c.this;
                            cVar.f4096c--;
                        }
                        UnityPlayer.this.executeGLThreadJobs();
                        if (!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                            UnityPlayer.this.m6059d();
                        }
                    }
                    if (C1602c.this.f4095b) {
                        Message.obtain(C1602c.this.f4094a, 2269, EnumC1601b.NEXT_FRAME).sendToTarget();
                    }
                    return true;
                }
            });
            Looper.loop();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.unity3d.player.UnityPlayer$d */
    public abstract class AbstractRunnableC1604d implements Runnable {
        private AbstractRunnableC1604d() {
        }

        /* synthetic */ AbstractRunnableC1604d(UnityPlayer unityPlayer, byte b) {
            this();
        }

        /* renamed from: a */
        public abstract void mo9018a();

        public final void run() {
            if (!UnityPlayer.this.isFinishing()) {
                mo9018a();
            }
        }
    }

    static {
        new C1625k().mo9113a();
        f4013n = false;
        f4013n = loadLibraryStatic("main");
    }

    public UnityPlayer(ContextWrapper contextWrapper) {
        super(contextWrapper);
        if (contextWrapper instanceof Activity) {
            currentActivity = (Activity) contextWrapper;
        }
        m6044a(currentActivity);
        this.f4025l = contextWrapper;
        m6057c();
        if (currentActivity != null && this.f4028p.getBoolean("showSplash")) {
            this.f4024k = new C1622j(this.f4025l, C1622j.EnumC1624a.m6133a()[getSplashMode()]);
            addView(this.f4024k);
        }
        if (C1617h.f4142c) {
            if (currentActivity != null) {
                C1617h.f4143d.mo9097a(currentActivity, new Runnable() {
                    /* class com.unity3d.player.UnityPlayer.RunnableC15751 */

                    public final void run() {
                        UnityPlayer.this.mo8976a(new Runnable() {
                            /* class com.unity3d.player.UnityPlayer.RunnableC15751.RunnableC15761 */

                            public final void run() {
                                UnityPlayer.this.f4018e.mo9118d();
                                UnityPlayer.this.m6066g();
                            }
                        });
                    }
                });
            } else {
                this.f4018e.mo9118d();
            }
        }
        m6045a(this.f4025l.getApplicationInfo());
        if (!C1626l.m6137c()) {
            AlertDialog create = new AlertDialog.Builder(this.f4025l).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                /* class com.unity3d.player.UnityPlayer.DialogInterface$OnClickListenerC158013 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.m6059d();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(contextWrapper);
        nativeFile(this.f4025l.getPackageCodePath());
        m6069i();
        this.f4026m = m6052b();
        addView(this.f4026m);
        bringChildToFront(this.f4024k);
        this.f4027o = false;
        if (currentActivity != null) {
            this.f4034v.mo9086a(currentActivity.getIntent());
        }
        nativeInitWWW(WWW.class);
        nativeInitWebRequest(UnityWebRequest.class);
        m6072j();
        this.f4023j = (TelephonyManager) this.f4025l.getSystemService("phone");
        this.f4014a.start();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (!C1626l.m6137c()) {
            C1614e.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
        } else {
            nativeUnitySendMessage(str, str2, str3);
        }
    }

    /* renamed from: a */
    private static String m6041a(String str) {
        byte[] bArr;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(str);
            long length = new File(str).length();
            fileInputStream.skip(length - Math.min(length, 65558L));
            byte[] bArr2 = new byte[1024];
            for (int i = 0; i != -1; i = fileInputStream.read(bArr2)) {
                instance.update(bArr2, 0, i);
            }
            bArr = instance.digest();
        } catch (FileNotFoundException e) {
            bArr = null;
        } catch (IOException e2) {
            bArr = null;
        } catch (NoSuchAlgorithmException e3) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m6042a() {
        mo8976a(new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC158618 */

            public final void run() {
                UnityPlayer.this.removeView(UnityPlayer.this.f4024k);
                UnityPlayer.this.f4024k = null;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m6043a(int i, Surface surface) {
        if (!this.f4016c) {
            m6056b(0, surface);
        }
    }

    /* renamed from: a */
    private static void m6044a(Activity activity) {
        View decorView;
        if (activity != null && activity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false) && activity.getWindow() != null && (decorView = activity.getWindow().getDecorView()) != null) {
            decorView.setSystemUiVisibility(7);
        }
    }

    /* renamed from: a */
    private static void m6045a(ApplicationInfo applicationInfo) {
        if (f4013n && NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            C1626l.m6135a();
        }
    }

    /* renamed from: a */
    private void m6046a(View view, View view2) {
        boolean z;
        if (!this.f4018e.mo9119e()) {
            pause();
            z = true;
        } else {
            z = false;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof UnityPlayer) || ((UnityPlayer) parent) != this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
                bringChildToFront(view);
                view.setVisibility(0);
            }
        }
        if (view2 != null && view2.getParent() == this) {
            view2.setVisibility(8);
            removeView(view2);
        }
        if (z) {
            resume();
        }
    }

    /* renamed from: a */
    private void m6047a(AbstractRunnableC1604d dVar) {
        if (!isFinishing()) {
            m6055b(dVar);
        }
    }

    /* renamed from: a */
    private static String[] m6051a(Context context) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        try {
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android/obb/" + packageName);
                if (file.exists()) {
                    if (i > 0) {
                        String str = file + File.separator + "main." + i + "." + packageName + ".obb";
                        if (new File(str).isFile()) {
                            vector.add(str);
                        }
                    }
                    if (i > 0) {
                        String str2 = file + File.separator + "patch." + i + "." + packageName + ".obb";
                        if (new File(str2).isFile()) {
                            vector.add(str2);
                        }
                    }
                }
            }
            String[] strArr = new String[vector.size()];
            vector.toArray(strArr);
            return strArr;
        } catch (PackageManager.NameNotFoundException e) {
            return new String[0];
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private SurfaceView m6052b() {
        SurfaceView surfaceView = new SurfaceView(this.f4025l);
        surfaceView.getHolder().setFormat(2);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            /* class com.unity3d.player.UnityPlayer.SurfaceHolder$CallbackC158719 */

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.m6043a((UnityPlayer) 0, surfaceHolder.getSurface());
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m6043a((UnityPlayer) 0, surfaceHolder.getSurface());
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.m6043a((UnityPlayer) 0, (Surface) null);
            }
        });
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        return surfaceView;
    }

    /* renamed from: b */
    private void m6055b(Runnable runnable) {
        if (C1626l.m6137c()) {
            if (Thread.currentThread() == this.f4014a) {
                runnable.run();
            } else {
                this.f4019f.add(runnable);
            }
        }
    }

    /* renamed from: b */
    private boolean m6056b(int i, Surface surface) {
        if (!C1626l.m6137c()) {
            return false;
        }
        nativeRecreateGfxState(i, surface);
        return true;
    }

    /* renamed from: c */
    private void m6057c() {
        try {
            File file = new File(this.f4025l.getPackageCodePath(), "assets/bin/Data/settings.xml");
            InputStream fileInputStream = file.exists() ? new FileInputStream(file) : this.f4025l.getAssets().open("bin/Data/settings.xml");
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(fileInputStream, null);
            String str = null;
            String str2 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    str2 = newPullParser.getName();
                    String str3 = str;
                    for (int i = 0; i < newPullParser.getAttributeCount(); i++) {
                        if (newPullParser.getAttributeName(i).equalsIgnoreCase("name")) {
                            str3 = newPullParser.getAttributeValue(i);
                        }
                    }
                    str = str3;
                } else if (eventType == 3) {
                    str2 = null;
                } else if (eventType == 4 && str != null) {
                    if (str2.equalsIgnoreCase("integer")) {
                        this.f4028p.putInt(str, Integer.parseInt(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("string")) {
                        this.f4028p.putString(str, newPullParser.getText());
                    } else if (str2.equalsIgnoreCase("bool")) {
                        this.f4028p.putBoolean(str, Boolean.parseBoolean(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("float")) {
                        this.f4028p.putFloat(str, Float.parseFloat(newPullParser.getText()));
                    }
                    str = null;
                }
            }
        } catch (Exception e) {
            C1614e.Log(6, "Unable to locate player settings. " + e.getLocalizedMessage());
            m6059d();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: d */
    private void m6059d() {
        if ((this.f4025l instanceof Activity) && !((Activity) this.f4025l).isFinishing()) {
            ((Activity) this.f4025l).finish();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: e */
    private void m6062e() {
        reportSoftInputStr(null, 1, true);
        if (this.f4018e.mo9121g()) {
            if (C1626l.m6137c()) {
                final Semaphore semaphore = new Semaphore(0);
                if (isFinishing()) {
                    m6055b(new Runnable() {
                        /* class com.unity3d.player.UnityPlayer.RunnableC159021 */

                        public final void run() {
                            UnityPlayer.this.m6063f();
                            semaphore.release();
                        }
                    });
                } else {
                    m6055b(new Runnable() {
                        /* class com.unity3d.player.UnityPlayer.RunnableC159122 */

                        public final void run() {
                            if (UnityPlayer.this.nativePause()) {
                                UnityPlayer.this.f4027o = true;
                                UnityPlayer.this.m6063f();
                                semaphore.release(2);
                                return;
                            }
                            semaphore.release();
                        }
                    });
                }
                try {
                    if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                        C1614e.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException e) {
                    C1614e.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    quit();
                }
            }
            this.f4018e.mo9117c(false);
            this.f4018e.mo9116b(true);
            if (this.f4021h) {
                this.f4023j.listen(this.f4022i, 0);
            }
            this.f4014a.mo9045c();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f */
    private void m6063f() {
        nativeDone();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: g */
    private void m6066g() {
        if (this.f4018e.mo9120f()) {
            this.f4018e.mo9117c(true);
            if (C1626l.m6137c()) {
                m6069i();
            }
            m6055b(new Runnable() {
                /* class com.unity3d.player.UnityPlayer.RunnableC15882 */

                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f4014a.mo9044b();
        }
    }

    /* renamed from: h */
    private static void m6068h() {
        if (C1626l.m6137c()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            C1626l.m6136b();
        }
    }

    /* renamed from: i */
    private void m6069i() {
        if (this.f4028p.getBoolean("useObb")) {
            String[] a = m6051a(this.f4025l);
            for (String str : a) {
                String a2 = m6041a(str);
                if (this.f4028p.getBoolean(a2)) {
                    nativeFile(str);
                }
                this.f4028p.remove(a2);
            }
        }
    }

    private final native void initJni(Context context);

    private final native boolean isQuiting();

    /* renamed from: j */
    private void m6072j() {
        if (this.f4025l instanceof Activity) {
            ((Activity) this.f4025l).getWindow().setFlags(1024, 1024);
        }
    }

    protected static boolean loadLibraryStatic(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            C1614e.Log(6, "Unable to find " + str);
            return false;
        } catch (Exception e2) {
            C1614e.Log(6, "Unknown error " + e2);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native int nativeActivityIndicatorStyle();

    private final native void nativeDone();

    private final native void nativeFile(String str);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void nativeFocusChanged(boolean z);

    private final native void nativeInitWWW(Class cls);

    private final native void nativeInitWebRequest(Class cls);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void nativeLowMemory();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void nativeMuteMasterAudio(boolean z);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native boolean nativePause();

    private final native void nativeRecreateGfxState(int i, Surface surface);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native boolean nativeRender();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void nativeResume();

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void nativeSetInputCanceled(boolean z);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void nativeSetInputString(String str);

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final native void nativeSoftInputClosed();

    private static native void nativeUnitySendMessage(String str, String str2, String str3);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo8976a(Runnable runnable) {
        if (this.f4025l instanceof Activity) {
            ((Activity) this.f4025l).runOnUiThread(runnable);
        } else {
            C1614e.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    /* access modifiers changed from: protected */
    public void addPhoneCallListener() {
        this.f4021h = true;
        this.f4023j.listen(this.f4022i, 32);
    }

    @Override // com.unity3d.player.AbstractC1613d
    public boolean addViewToPlayer(View view, boolean z) {
        boolean z2 = true;
        m6046a(view, z ? this.f4026m : null);
        boolean z3 = view.getParent() == this;
        boolean z4 = z && this.f4026m.getParent() == null;
        boolean z5 = this.f4026m.getParent() == this;
        if (!z3 || (!z4 && !z5)) {
            z2 = false;
        }
        if (!z2) {
            if (!z3) {
                C1614e.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if (!z4 && !z5) {
                C1614e.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return z2;
    }

    public void configurationChanged(Configuration configuration) {
        if (this.f4026m instanceof SurfaceView) {
            this.f4026m.getHolder().setSizeFromLayout();
        }
        if (this.f4029q != null) {
            this.f4029q.updateVideoLayout();
        }
        if (this.f4034v != null) {
            this.f4034v.mo9092e();
        }
    }

    /* access modifiers changed from: protected */
    public void disableLogger() {
        C1614e.f4138a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f4016c = surface != null;
            mo8976a(new Runnable() {
                /* class com.unity3d.player.UnityPlayer.RunnableC158920 */

                public final void run() {
                    if (UnityPlayer.this.f4016c) {
                        UnityPlayer.this.removeView(UnityPlayer.this.f4026m);
                    } else {
                        UnityPlayer.this.addView(UnityPlayer.this.f4026m);
                    }
                }
            });
        }
        return m6056b(i, surface);
    }

    /* access modifiers changed from: protected */
    public void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f4019f.poll();
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    public Bundle getSettings() {
        return this.f4028p;
    }

    /* access modifiers changed from: protected */
    public int getSplashMode() {
        return this.f4028p.getInt("splash_mode", 0);
    }

    public View getView() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void hideSoftInput() {
        final RunnableC15988 r0 = new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC15988 */

            public final void run() {
                if (UnityPlayer.this.f4015b != null) {
                    UnityPlayer.this.f4015b.dismiss();
                    UnityPlayer.this.f4015b = null;
                }
            }
        };
        if (C1617h.f4141b) {
            m6047a((AbstractRunnableC1604d) new AbstractRunnableC1604d() {
                /* class com.unity3d.player.UnityPlayer.C15999 */

                @Override // com.unity3d.player.UnityPlayer.AbstractRunnableC1604d
                /* renamed from: a */
                public final void mo9018a() {
                    UnityPlayer.this.mo8976a(r0);
                }
            });
        } else {
            mo8976a(r0);
        }
    }

    public void init(int i, boolean z) {
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return nativeInjectEvent(inputEvent);
    }

    @Override // com.unity3d.player.AbstractC1613d
    public boolean isAppQuiting() {
        return isQuiting();
    }

    /* access modifiers changed from: protected */
    public boolean isFinishing() {
        if (!this.f4027o) {
            boolean z = (this.f4025l instanceof Activity) && ((Activity) this.f4025l).isFinishing();
            this.f4027o = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void kill() {
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: protected */
    public long loadGoogleVR(boolean z, boolean z2, boolean z3) {
        final Semaphore semaphore = new Semaphore(0);
        mo8976a(new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC157912 */

            public final void run() {
                if (!UnityPlayer.this.f4034v.mo9088a(UnityPlayer.currentActivity, UnityPlayer.this.f4025l, UnityPlayer.this.m6052b())) {
                    C1614e.Log(6, "Unable to initialize Google VR subsystem.");
                }
                semaphore.release();
            }
        });
        try {
            if (!semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                C1614e.Log(5, "Timeout while trying to initialize Google VR.");
                return 0;
            }
            RunnableC158114 r2 = new Runnable() {
                /* class com.unity3d.player.UnityPlayer.RunnableC158114 */

                public final void run() {
                    UnityPlayer.this.injectEvent(new KeyEvent(0, 4));
                    UnityPlayer.this.injectEvent(new KeyEvent(1, 4));
                }
            };
            if (this.f4034v.mo9090c()) {
                return this.f4034v.mo9084a(z, z2, z3, r2);
            }
            return 0;
        } catch (InterruptedException e) {
            C1614e.Log(5, "UI thread was interrupted while initializing Google VR. " + e.getLocalizedMessage());
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    public void lowMemory() {
        m6055b(new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC159223 */

            public final void run() {
                UnityPlayer.this.nativeLowMemory();
            }
        });
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        if (this.f4029q != null) {
            this.f4030r = this.f4029q.mo9126a();
            if (!this.f4030r) {
                this.f4029q.pause();
                return;
            }
            return;
        }
        this.f4034v.mo9085a();
        m6062e();
    }

    public void quit() {
        this.f4027o = true;
        if (!this.f4018e.mo9119e()) {
            pause();
        }
        unloadGoogleVR();
        this.f4014a.mo9042a();
        try {
            this.f4014a.join(4000);
        } catch (InterruptedException e) {
            this.f4014a.interrupt();
        }
        if (this.f4020g != null) {
            this.f4025l.unregisterReceiver(this.f4020g);
        }
        this.f4020g = null;
        if (C1626l.m6137c()) {
            removeAllViews();
        }
        kill();
        m6068h();
    }

    @Override // com.unity3d.player.AbstractC1613d
    public void removeViewFromPlayer(View view) {
        boolean z = true;
        m6046a(this.f4026m, view);
        boolean z2 = view.getParent() == null;
        boolean z3 = this.f4026m.getParent() == this;
        if (!z2 || !z3) {
            z = false;
        }
        if (!z) {
            if (!z2) {
                C1614e.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
            }
            if (!z3) {
                C1614e.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
            }
        }
    }

    @Override // com.unity3d.player.AbstractC1613d
    public void reportError(String str, String str2) {
        C1614e.Log(6, str + ": " + str2);
    }

    /* access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        m6047a((AbstractRunnableC1604d) new AbstractRunnableC1604d() {
            /* class com.unity3d.player.UnityPlayer.C157811 */

            @Override // com.unity3d.player.UnityPlayer.AbstractRunnableC1604d
            /* renamed from: a */
            public final void mo9018a() {
                if (z) {
                    UnityPlayer.this.nativeSetInputCanceled(true);
                } else if (str != null) {
                    UnityPlayer.this.nativeSetInputString(str);
                }
                if (i == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    public void resume() {
        this.f4018e.mo9116b(false);
        if (this.f4029q == null) {
            m6066g();
            this.f4034v.mo9089b();
        } else if (!this.f4030r) {
            this.f4029q.start();
        }
    }

    /* access modifiers changed from: protected */
    public void setGoogleVREnabled(boolean z) {
        this.f4034v.mo9087a(z);
    }

    /* access modifiers changed from: protected */
    public void setSoftInputStr(final String str) {
        mo8976a(new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC157710 */

            public final void run() {
                if (UnityPlayer.this.f4015b != null && str != null) {
                    UnityPlayer.this.f4015b.mo9100a(str);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void showSoftInput(final String str, final int i, final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str2) {
        mo8976a(new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC15977 */

            public final void run() {
                UnityPlayer.this.f4015b = new DialogC1618i(UnityPlayer.this.f4025l, this, str, i, z, z2, z3, str2);
                UnityPlayer.this.f4015b.show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean showVideoPlayer(final String str, final int i, final int i2, final int i3, final boolean z, final int i4, final int i5) {
        final Semaphore semaphore = new Semaphore(0);
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        mo8976a(new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC158215 */

            public final void run() {
                if (UnityPlayer.this.f4029q != null) {
                    C1614e.Log(5, "Video already playing");
                    atomicInteger.set(2);
                    semaphore.release();
                    return;
                }
                UnityPlayer.this.f4029q = new SurfaceHolder$CallbackC1629n(UnityPlayer.this.f4025l, str, i, i2, i3, z, (long) i4, (long) i5, new SurfaceHolder$CallbackC1629n.AbstractC1630a() {
                    /* class com.unity3d.player.UnityPlayer.RunnableC158215.C15831 */

                    @Override // com.unity3d.player.SurfaceHolder$CallbackC1629n.AbstractC1630a
                    /* renamed from: a */
                    public final void mo9023a(int i) {
                        atomicInteger.set(i);
                        if (i == 3) {
                            if (UnityPlayer.this.f4026m.getParent() == null) {
                                UnityPlayer.this.addView(UnityPlayer.this.f4026m);
                            }
                            if (UnityPlayer.this.f4029q != null) {
                                UnityPlayer.this.f4029q.destroyPlayer();
                                UnityPlayer.this.removeView(UnityPlayer.this.f4029q);
                                UnityPlayer.this.f4029q = null;
                            }
                            UnityPlayer.this.resume();
                        }
                        if (i != 0) {
                            semaphore.release();
                        }
                    }
                });
                UnityPlayer.this.addView(UnityPlayer.this.f4029q);
            }
        });
        boolean z2 = false;
        try {
            semaphore.acquire();
            z2 = atomicInteger.get() != 2;
        } catch (InterruptedException e) {
        }
        if (z2) {
            if (this.f4029q != null) {
                mo8976a(new Runnable() {
                    /* class com.unity3d.player.UnityPlayer.RunnableC158416 */

                    public final void run() {
                        if (UnityPlayer.this.f4029q != null) {
                            UnityPlayer.this.m6062e();
                            UnityPlayer.this.f4029q.requestFocus();
                            UnityPlayer.this.removeView(UnityPlayer.this.f4026m);
                        }
                    }
                });
            }
        } else if (this.f4029q != null) {
            mo8976a(new Runnable() {
                /* class com.unity3d.player.UnityPlayer.RunnableC158517 */

                public final void run() {
                    if (UnityPlayer.this.f4026m.getParent() == null) {
                        UnityPlayer.this.addView(UnityPlayer.this.f4026m);
                    }
                    if (UnityPlayer.this.f4029q != null) {
                        UnityPlayer.this.f4029q.destroyPlayer();
                        UnityPlayer.this.removeView(UnityPlayer.this.f4029q);
                        UnityPlayer.this.f4029q = null;
                    }
                    UnityPlayer.this.resume();
                }
            });
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public void startActivityIndicator() {
        mo8976a(this.f4032t);
    }

    /* access modifiers changed from: protected */
    public void stopActivityIndicator() {
        mo8976a(this.f4033u);
    }

    /* access modifiers changed from: protected */
    public void unloadGoogleVR() {
        this.f4034v.mo9091d();
    }

    public void windowFocusChanged(final boolean z) {
        this.f4018e.mo9115a(z);
        if (z && this.f4015b != null) {
            reportSoftInputStr(null, 1, false);
        }
        m6055b(new Runnable() {
            /* class com.unity3d.player.UnityPlayer.RunnableC15944 */

            public final void run() {
                UnityPlayer.this.nativeFocusChanged(z);
            }
        });
        this.f4014a.mo9043a(z);
        m6066g();
    }
}
