package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* access modifiers changed from: package-private */
/* renamed from: org.fmod.a */
public final class RunnableC2193a implements Runnable {

    /* renamed from: a */
    private final FMODAudioDevice f6247a;

    /* renamed from: b */
    private final ByteBuffer f6248b;

    /* renamed from: c */
    private final int f6249c;

    /* renamed from: d */
    private final int f6250d;

    /* renamed from: e */
    private final int f6251e = 2;

    /* renamed from: f */
    private volatile Thread f6252f;

    /* renamed from: g */
    private volatile boolean f6253g;

    /* renamed from: h */
    private AudioRecord f6254h;

    /* renamed from: i */
    private boolean f6255i;

    RunnableC2193a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f6247a = fMODAudioDevice;
        this.f6249c = i;
        this.f6250d = i2;
        this.f6248b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    /* renamed from: d */
    private void m8367d() {
        if (this.f6254h != null) {
            if (this.f6254h.getState() == 1) {
                this.f6254h.stop();
            }
            this.f6254h.release();
            this.f6254h = null;
        }
        this.f6248b.position(0);
        this.f6255i = false;
    }

    /* renamed from: a */
    public final int mo12187a() {
        return this.f6248b.capacity();
    }

    /* renamed from: b */
    public final void mo12188b() {
        if (this.f6252f != null) {
            mo12189c();
        }
        this.f6253g = true;
        this.f6252f = new Thread(this);
        this.f6252f.start();
    }

    /* renamed from: c */
    public final void mo12189c() {
        while (this.f6252f != null) {
            this.f6253g = false;
            try {
                this.f6252f.join();
                this.f6252f = null;
            } catch (InterruptedException e) {
            }
        }
    }

    public final void run() {
        int i;
        int i2 = 3;
        while (this.f6253g) {
            if (!this.f6255i && i2 > 0) {
                m8367d();
                this.f6254h = new AudioRecord(1, this.f6249c, this.f6250d, this.f6251e, this.f6248b.capacity());
                this.f6255i = this.f6254h.getState() == 1;
                if (this.f6255i) {
                    this.f6248b.position(0);
                    this.f6254h.startRecording();
                    i = 3;
                    if (this.f6255i || this.f6254h.getRecordingState() != 3) {
                        i2 = i;
                    } else {
                        this.f6247a.fmodProcessMicData(this.f6248b, this.f6254h.read(this.f6248b, this.f6248b.capacity()));
                        this.f6248b.position(0);
                        i2 = i;
                    }
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.f6254h.getState() + ")");
                    i2--;
                    m8367d();
                }
            }
            i = i2;
            if (this.f6255i) {
            }
            i2 = i;
        }
        m8367d();
    }
}
