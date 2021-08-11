package com.unity3d.player;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.unity3d.player.n */
public final class SurfaceHolder$CallbackC1629n extends FrameLayout implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback, MediaController.MediaPlayerControl {

    /* renamed from: a */
    private static boolean f4174a = false;

    /* renamed from: b */
    private final Context f4175b;

    /* renamed from: c */
    private final SurfaceView f4176c;

    /* renamed from: d */
    private final SurfaceHolder f4177d;

    /* renamed from: e */
    private final String f4178e;

    /* renamed from: f */
    private final int f4179f;

    /* renamed from: g */
    private final int f4180g;

    /* renamed from: h */
    private final boolean f4181h;

    /* renamed from: i */
    private final long f4182i;

    /* renamed from: j */
    private final long f4183j;

    /* renamed from: k */
    private final FrameLayout f4184k;

    /* renamed from: l */
    private final Display f4185l;

    /* renamed from: m */
    private int f4186m;

    /* renamed from: n */
    private int f4187n;

    /* renamed from: o */
    private int f4188o;

    /* renamed from: p */
    private int f4189p;

    /* renamed from: q */
    private MediaPlayer f4190q;

    /* renamed from: r */
    private MediaController f4191r;

    /* renamed from: s */
    private boolean f4192s = false;

    /* renamed from: t */
    private boolean f4193t = false;

    /* renamed from: u */
    private int f4194u = 0;

    /* renamed from: v */
    private boolean f4195v = false;

    /* renamed from: w */
    private boolean f4196w = false;

    /* renamed from: x */
    private AbstractC1630a f4197x;

    /* renamed from: y */
    private RunnableC1631b f4198y;

    /* renamed from: z */
    private volatile int f4199z = 0;

    /* renamed from: com.unity3d.player.n$a */
    public interface AbstractC1630a {
        /* renamed from: a */
        void mo9023a(int i);
    }

    /* renamed from: com.unity3d.player.n$b */
    public class RunnableC1631b implements Runnable {

        /* renamed from: b */
        private SurfaceHolder$CallbackC1629n f4201b;

        /* renamed from: c */
        private boolean f4202c = false;

        public RunnableC1631b(SurfaceHolder$CallbackC1629n nVar) {
            this.f4201b = nVar;
        }

        /* renamed from: a */
        public final void mo9149a() {
            this.f4202c = true;
        }

        public final void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (!this.f4202c) {
                if (SurfaceHolder$CallbackC1629n.f4174a) {
                    SurfaceHolder$CallbackC1629n.m6150b("Stopping the video player due to timeout.");
                }
                this.f4201b.CancelOnPrepare();
            }
        }
    }

    protected SurfaceHolder$CallbackC1629n(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, AbstractC1630a aVar) {
        super(context);
        this.f4197x = aVar;
        this.f4175b = context;
        this.f4184k = this;
        this.f4176c = new SurfaceView(context);
        this.f4177d = this.f4176c.getHolder();
        this.f4177d.addCallback(this);
        this.f4177d.setType(3);
        this.f4184k.setBackgroundColor(i);
        this.f4184k.addView(this.f4176c);
        this.f4185l = ((WindowManager) this.f4175b.getSystemService("window")).getDefaultDisplay();
        this.f4178e = str;
        this.f4179f = i2;
        this.f4180g = i3;
        this.f4181h = z;
        this.f4182i = j;
        this.f4183j = j2;
        if (f4174a) {
            m6150b("fileName: " + this.f4178e);
        }
        if (f4174a) {
            m6150b("backgroundColor: " + i);
        }
        if (f4174a) {
            m6150b("controlMode: " + this.f4179f);
        }
        if (f4174a) {
            m6150b("scalingMode: " + this.f4180g);
        }
        if (f4174a) {
            m6150b("isURL: " + this.f4181h);
        }
        if (f4174a) {
            m6150b("videoOffset: " + this.f4182i);
        }
        if (f4174a) {
            m6150b("videoLength: " + this.f4183j);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    /* renamed from: a */
    private void m6148a(int i) {
        this.f4199z = i;
        if (this.f4197x != null) {
            this.f4197x.mo9023a(this.f4199z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m6150b(String str) {
        Log.i("Video", "VideoPlayer: " + str);
    }

    /* renamed from: c */
    private void m6152c() {
        if (this.f4190q != null) {
            this.f4190q.setDisplay(this.f4177d);
            if (!this.f4195v) {
                if (f4174a) {
                    m6150b("Resuming playback");
                }
                this.f4190q.start();
                return;
            }
            return;
        }
        m6148a(0);
        doCleanUp();
        try {
            this.f4190q = new MediaPlayer();
            if (this.f4181h) {
                this.f4190q.setDataSource(this.f4175b, Uri.parse(this.f4178e));
            } else if (this.f4183j != 0) {
                FileInputStream fileInputStream = new FileInputStream(this.f4178e);
                this.f4190q.setDataSource(fileInputStream.getFD(), this.f4182i, this.f4183j);
                fileInputStream.close();
            } else {
                try {
                    AssetFileDescriptor openFd = getResources().getAssets().openFd(this.f4178e);
                    this.f4190q.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                } catch (IOException e) {
                    FileInputStream fileInputStream2 = new FileInputStream(this.f4178e);
                    this.f4190q.setDataSource(fileInputStream2.getFD());
                    fileInputStream2.close();
                }
            }
            this.f4190q.setDisplay(this.f4177d);
            this.f4190q.setScreenOnWhilePlaying(true);
            this.f4190q.setOnBufferingUpdateListener(this);
            this.f4190q.setOnCompletionListener(this);
            this.f4190q.setOnPreparedListener(this);
            this.f4190q.setOnVideoSizeChangedListener(this);
            this.f4190q.setAudioStreamType(3);
            this.f4190q.prepareAsync();
            this.f4198y = new RunnableC1631b(this);
            new Thread(this.f4198y).start();
        } catch (Exception e2) {
            if (f4174a) {
                m6150b("error: " + e2.getMessage() + e2);
            }
            m6148a(2);
        }
    }

    /* renamed from: d */
    private void m6153d() {
        if (!isPlaying()) {
            m6148a(1);
            if (f4174a) {
                m6150b("startVideoPlayback");
            }
            updateVideoLayout();
            if (!this.f4195v) {
                start();
            }
        }
    }

    public final void CancelOnPrepare() {
        m6148a(2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo9126a() {
        return this.f4195v;
    }

    public final boolean canPause() {
        return true;
    }

    public final boolean canSeekBackward() {
        return true;
    }

    public final boolean canSeekForward() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void destroyPlayer() {
        if (f4174a) {
            m6150b("destroyPlayer");
        }
        if (!this.f4195v) {
            pause();
        }
        doCleanUp();
    }

    /* access modifiers changed from: protected */
    public final void doCleanUp() {
        if (this.f4198y != null) {
            this.f4198y.mo9149a();
            this.f4198y = null;
        }
        if (this.f4190q != null) {
            this.f4190q.release();
            this.f4190q = null;
        }
        this.f4188o = 0;
        this.f4189p = 0;
        this.f4193t = false;
        this.f4192s = false;
    }

    public final int getBufferPercentage() {
        if (this.f4181h) {
            return this.f4194u;
        }
        return 100;
    }

    public final int getCurrentPosition() {
        if (this.f4190q == null) {
            return 0;
        }
        return this.f4190q.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.f4190q == null) {
            return 0;
        }
        return this.f4190q.getDuration();
    }

    public final boolean isPlaying() {
        boolean z = this.f4193t && this.f4192s;
        return this.f4190q == null ? !z : this.f4190q.isPlaying() || !z;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (f4174a) {
            m6150b("onBufferingUpdate percent:" + i);
        }
        this.f4194u = i;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (f4174a) {
            m6150b("onCompletion called");
        }
        destroyPlayer();
        m6148a(3);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 && (this.f4179f != 2 || i == 0 || keyEvent.isSystem())) {
            return this.f4191r != null ? this.f4191r.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
        }
        destroyPlayer();
        m6148a(3);
        return true;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (f4174a) {
            m6150b("onPrepared called");
        }
        if (this.f4198y != null) {
            this.f4198y.mo9149a();
            this.f4198y = null;
        }
        if (this.f4179f == 0 || this.f4179f == 1) {
            this.f4191r = new MediaController(this.f4175b);
            this.f4191r.setMediaPlayer(this);
            this.f4191r.setAnchorView(this);
            this.f4191r.setEnabled(true);
            this.f4191r.show();
        }
        this.f4193t = true;
        if (this.f4193t && this.f4192s) {
            m6153d();
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f4179f != 2 || action != 0) {
            return this.f4191r != null ? this.f4191r.onTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
        }
        destroyPlayer();
        m6148a(3);
        return true;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (f4174a) {
            m6150b("onVideoSizeChanged called " + i + "x" + i2);
        }
        if (i != 0 && i2 != 0) {
            this.f4192s = true;
            this.f4188o = i;
            this.f4189p = i2;
            if (this.f4193t && this.f4192s) {
                m6153d();
            }
        } else if (f4174a) {
            m6150b("invalid video width(" + i + ") or height(" + i2 + ")");
        }
    }

    public final void pause() {
        if (this.f4190q != null) {
            if (this.f4196w) {
                this.f4190q.pause();
            }
            this.f4195v = true;
        }
    }

    public final void seekTo(int i) {
        if (this.f4190q != null) {
            this.f4190q.seekTo(i);
        }
    }

    public final void start() {
        if (f4174a) {
            m6150b("Start");
        }
        if (this.f4190q != null) {
            if (this.f4196w) {
                this.f4190q.start();
            }
            this.f4195v = false;
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (f4174a) {
            m6150b("surfaceChanged called " + i + " " + i2 + "x" + i3);
        }
        if (this.f4186m != i2 || this.f4187n != i3) {
            this.f4186m = i2;
            this.f4187n = i3;
            if (this.f4196w) {
                updateVideoLayout();
            }
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (f4174a) {
            m6150b("surfaceCreated called");
        }
        this.f4196w = true;
        m6152c();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (f4174a) {
            m6150b("surfaceDestroyed called");
        }
        this.f4196w = false;
    }

    /* access modifiers changed from: protected */
    public final void updateVideoLayout() {
        if (f4174a) {
            m6150b("updateVideoLayout");
        }
        if (this.f4190q != null) {
            if (this.f4186m == 0 || this.f4187n == 0) {
                WindowManager windowManager = (WindowManager) this.f4175b.getSystemService("window");
                this.f4186m = windowManager.getDefaultDisplay().getWidth();
                this.f4187n = windowManager.getDefaultDisplay().getHeight();
            }
            int i = this.f4186m;
            int i2 = this.f4187n;
            float f = ((float) this.f4188o) / ((float) this.f4189p);
            float f2 = ((float) this.f4186m) / ((float) this.f4187n);
            if (this.f4180g == 1) {
                if (f2 <= f) {
                    i2 = (int) (((float) this.f4186m) / f);
                } else {
                    i = (int) (((float) this.f4187n) * f);
                }
            } else if (this.f4180g == 2) {
                if (f2 >= f) {
                    i2 = (int) (((float) this.f4186m) / f);
                } else {
                    i = (int) (((float) this.f4187n) * f);
                }
            } else if (this.f4180g == 0) {
                i = this.f4188o;
                i2 = this.f4189p;
            }
            if (f4174a) {
                m6150b("frameWidth = " + i + "; frameHeight = " + i2);
            }
            this.f4184k.updateViewLayout(this.f4176c, new FrameLayout.LayoutParams(i, i2, 17));
        }
    }
}
