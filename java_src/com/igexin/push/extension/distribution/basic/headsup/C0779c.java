package com.igexin.push.extension.distribution.basic.headsup;

import android.animation.ObjectAnimator;
import android.app.PendingIntent;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.headsup.c */
public class C0779c extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ C0778b f2192a;

    C0779c(C0778b bVar) {
        this.f2192a = bVar;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return super.onDown(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f2192a.f2188w.mo5122b(motionEvent2.getRawX());
        this.f2192a.f2188w.mo5124c(motionEvent2.getRawY());
        if (this.f2192a.f2186u) {
            if (this.f2192a.f2188w.mo5121b() - this.f2192a.f2188w.mo5131g() > 0.0f) {
                if (this.f2192a.f2174i == null && this.f2192a.f2175j == null && this.f2192a.f2176k == null) {
                    this.f2192a.f2174i = this.f2192a.f2167a.getChildAt(0);
                    if (this.f2192a.f2183r == EnumC0785i.PICTURE) {
                        this.f2192a.f2175j = this.f2192a.f2174i.findViewById(this.f2192a.f2179n);
                    } else if (this.f2192a.f2183r == EnumC0785i.BANNER) {
                        this.f2192a.f2175j = this.f2192a.f2174i.findViewById(this.f2192a.f2178m);
                    } else if (this.f2192a.f2183r == EnumC0785i.TEXT) {
                        this.f2192a.f2175j = this.f2192a.f2174i.findViewById(this.f2192a.f2180o);
                    }
                    this.f2192a.f2176k = new WrapperView(this.f2192a.f2175j);
                }
                if (this.f2192a.f2183r != EnumC0785i.TEXT) {
                    if (this.f2192a.f2183r == EnumC0785i.BANNER) {
                        this.f2192a.f2172f.setVisibility(8);
                        this.f2192a.f2173g.setVisibility(0);
                    }
                    if (this.f2192a.f2175j.getHeight() < C0778b.m3228a(this.f2192a.f2182q, 192.0f)) {
                        ObjectAnimator.ofInt(this.f2192a.f2176k, "height", this.f2192a.f2175j.getHeight(), this.f2192a.f2175j.getHeight() + ((int) (this.f2192a.f2188w.mo5121b() - this.f2192a.f2188w.mo5125d()))).setDuration(0L).start();
                        this.f2192a.f2188w.mo5128e(this.f2192a.f2188w.mo5121b());
                    }
                } else if (this.f2192a.f2175j.getHeight() < this.f2192a.f2185t) {
                    ObjectAnimator.ofInt(this.f2192a.f2176k, "height", this.f2192a.f2175j.getHeight(), this.f2192a.f2175j.getHeight() + ((int) (this.f2192a.f2188w.mo5121b() - this.f2192a.f2188w.mo5125d()))).setDuration(0L).start();
                    this.f2192a.f2188w.mo5128e(this.f2192a.f2188w.mo5121b());
                }
            }
            if (this.f2192a.f2188w.mo5121b() - this.f2192a.f2188w.mo5125d() < 0.0f) {
                if (this.f2192a.f2183r == EnumC0785i.BANNER && this.f2192a.f2175j.getHeight() < C0778b.m3228a(this.f2192a.f2182q, 64.0f)) {
                    this.f2192a.f2172f.setVisibility(0);
                    this.f2192a.f2173g.setVisibility(8);
                    ObjectAnimator.ofInt(this.f2192a.f2176k, "height", 0, 0).setDuration(0L).start();
                }
                ObjectAnimator.ofInt(this.f2192a.f2176k, "height", this.f2192a.f2175j.getHeight(), this.f2192a.f2175j.getHeight() - ((int) (this.f2192a.f2188w.mo5125d() - this.f2192a.f2188w.mo5121b()))).setDuration(0L).start();
                this.f2192a.f2188w.mo5128e(this.f2192a.f2188w.mo5121b());
            }
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.f2192a.f2190y.mo5188k().contentIntent != null) {
            try {
                this.f2192a.f2190y.mo5188k().contentIntent.send();
                this.f2192a.mo5150a(false);
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
        return super.onSingleTapConfirmed(motionEvent);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return super.onSingleTapUp(motionEvent);
    }
}
