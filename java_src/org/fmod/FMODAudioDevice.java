package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice implements Runnable {

    /* renamed from: h */
    private static int f6236h = 0;

    /* renamed from: i */
    private static int f6237i = 1;

    /* renamed from: j */
    private static int f6238j = 2;

    /* renamed from: k */
    private static int f6239k = 3;

    /* renamed from: a */
    private volatile Thread f6240a = null;

    /* renamed from: b */
    private volatile boolean f6241b = false;

    /* renamed from: c */
    private AudioTrack f6242c = null;

    /* renamed from: d */
    private boolean f6243d = false;

    /* renamed from: e */
    private ByteBuffer f6244e = null;

    /* renamed from: f */
    private byte[] f6245f = null;

    /* renamed from: g */
    private volatile RunnableC2193a f6246g;

    private native int fmodGetInfo(int i);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        if (this.f6242c != null) {
            if (this.f6242c.getState() == 1) {
                this.f6242c.stop();
            }
            this.f6242c.release();
            this.f6242c = null;
        }
        this.f6244e = null;
        this.f6245f = null;
        this.f6243d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* access modifiers changed from: package-private */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i);

    public boolean isRunning() {
        return this.f6240a != null && this.f6240a.isAlive();
    }

    public void run() {
        int i;
        int i2 = 3;
        while (this.f6241b) {
            if (this.f6243d || i2 <= 0) {
                i = i2;
            } else {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(f6236h);
                int round = Math.round(((float) AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2)) * 1.1f) & -4;
                int fmodGetInfo2 = fmodGetInfo(f6237i);
                int fmodGetInfo3 = fmodGetInfo(f6238j);
                if (fmodGetInfo2 * fmodGetInfo3 * 4 > round) {
                    round = fmodGetInfo3 * fmodGetInfo2 * 4;
                }
                this.f6242c = new AudioTrack(3, fmodGetInfo, 3, 2, round, 1);
                this.f6243d = this.f6242c.getState() == 1;
                if (this.f6243d) {
                    this.f6244e = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.f6245f = new byte[this.f6244e.capacity()];
                    this.f6242c.play();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f6242c.getState() + ")");
                    releaseAudioTrack();
                    i = i2 - 1;
                }
            }
            if (!this.f6243d) {
                i2 = i;
            } else if (fmodGetInfo(f6239k) == 1) {
                fmodProcess(this.f6244e);
                this.f6244e.get(this.f6245f, 0, this.f6244e.capacity());
                this.f6242c.write(this.f6245f, 0, this.f6244e.capacity());
                this.f6244e.position(0);
                i2 = i;
            } else {
                releaseAudioTrack();
                i2 = i;
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f6240a != null) {
            stop();
        }
        this.f6240a = new Thread(this, "FMODAudioDevice");
        this.f6240a.setPriority(10);
        this.f6241b = true;
        this.f6240a.start();
        if (this.f6246g != null) {
            this.f6246g.mo12188b();
        }
    }

    public synchronized int startAudioRecord(int i, int i2, int i3) {
        if (this.f6246g == null) {
            this.f6246g = new RunnableC2193a(this, i, i2);
            this.f6246g.mo12188b();
        }
        return this.f6246g.mo12187a();
    }

    public synchronized void stop() {
        while (this.f6240a != null) {
            this.f6241b = false;
            try {
                this.f6240a.join();
                this.f6240a = null;
            } catch (InterruptedException e) {
            }
        }
        if (this.f6246g != null) {
            this.f6246g.mo12189c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f6246g != null) {
            this.f6246g.mo12189c();
            this.f6246g = null;
        }
    }
}
