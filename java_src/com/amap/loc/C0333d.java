package com.amap.loc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.fence.Fence;
import com.amap.api.location.AMapLocation;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.loc.d */
/* compiled from: FenceManager */
public class C0333d {

    /* renamed from: a */
    Context f795a;

    /* renamed from: b */
    private Hashtable<PendingIntent, ArrayList<Fence>> f796b = new Hashtable<>();

    public C0333d(Context context) {
        this.f795a = context;
    }

    /* renamed from: a */
    private void m1200a(PendingIntent pendingIntent, Fence fence, int i) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("fenceid", fence.f157b);
        bundle.putInt("event", i);
        intent.putExtras(bundle);
        try {
            pendingIntent.send(this.f795a, 0, intent);
        } catch (Throwable th) {
            C0310c.m956a(th, "FenceManager", "fcIntent");
        }
    }

    /* renamed from: a */
    private boolean m1201a(PendingIntent pendingIntent, List<String> list) {
        boolean z;
        boolean z2 = false;
        if (!m1203b() && list != null && !list.isEmpty() && this.f796b.containsKey(pendingIntent)) {
            Iterator<Fence> it = this.f796b.get(pendingIntent).iterator();
            while (it != null && it.hasNext()) {
                Fence next = it.next();
                if (list.contains(next.f157b) || m1202a(next)) {
                    it.remove();
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        return z2;
    }

    /* renamed from: a */
    private boolean m1202a(Fence fence) {
        return fence.mo3482b() != -1 && fence.mo3482b() <= C0331cr.m1170b();
    }

    /* renamed from: b */
    private boolean m1203b() {
        return this.f796b.isEmpty();
    }

    /* renamed from: a */
    public void mo3913a() {
        this.f796b.clear();
    }

    /* renamed from: a */
    public void mo3914a(PendingIntent pendingIntent) {
        if (pendingIntent != null && this.f796b.containsKey(pendingIntent)) {
            this.f796b.remove(pendingIntent);
        }
    }

    /* renamed from: a */
    public void mo3915a(AMapLocation aMapLocation) {
        if (!m1203b()) {
            Iterator<Map.Entry<PendingIntent, ArrayList<Fence>>> it = this.f796b.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Map.Entry<PendingIntent, ArrayList<Fence>> next = it.next();
                Iterator<Fence> it2 = next.getValue().iterator();
                while (it2.hasNext()) {
                    Fence next2 = it2.next();
                    if (!m1202a(next2)) {
                        float a = C0331cr.m1151a(new double[]{next2.f159d, next2.f158c, aMapLocation.getLatitude(), aMapLocation.getLongitude()});
                        float accuracy = aMapLocation.getAccuracy();
                        float f = accuracy >= 500.0f ? a - (next2.f160e + 500.0f) : a - (accuracy + next2.f160e);
                        boolean z = false;
                        if (f > 0.0f) {
                            if (next2.f161f != 0) {
                                z = true;
                            }
                            next2.f161f = 0;
                        } else {
                            if (next2.f161f != 1) {
                                z = true;
                            }
                            next2.f161f = 1;
                        }
                        if (z) {
                            switch (next2.f161f) {
                                case 0:
                                    next2.f162g = -1;
                                    if ((next2.mo3480a() & 2) != 2) {
                                        break;
                                    } else {
                                        m1200a(next.getKey(), next2, 2);
                                        break;
                                    }
                                case 1:
                                    next2.f162g = C0331cr.m1170b();
                                    if ((next2.mo3480a() & 1) != 1) {
                                        break;
                                    } else {
                                        m1200a(next.getKey(), next2, 1);
                                        break;
                                    }
                            }
                        } else if ((next2.mo3480a() & 4) == 4 && next2.f162g > 0 && C0331cr.m1170b() - next2.f162g > next2.mo3483c()) {
                            next2.f162g = C0331cr.m1170b();
                            m1200a(next.getKey(), next2, 4);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo3916a(PendingIntent pendingIntent, String str) {
        if (pendingIntent == null || !this.f796b.containsKey(pendingIntent) || TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return m1201a(pendingIntent, arrayList);
    }

    /* renamed from: a */
    public boolean mo3917a(Fence fence, PendingIntent pendingIntent) {
        if (pendingIntent == null || fence == null) {
            return false;
        }
        if (TextUtils.isEmpty(fence.f157b)) {
            return false;
        }
        if (fence.f160e < 100.0f) {
            return false;
        }
        if (fence.f160e > 10000.0f) {
            return false;
        }
        if (!m1203b() && !this.f796b.containsKey(pendingIntent)) {
            return false;
        }
        if (fence.mo3480a() == 0) {
            return false;
        }
        if (fence.mo3480a() > 7) {
            return false;
        }
        Iterator<Map.Entry<PendingIntent, ArrayList<Fence>>> it = this.f796b.entrySet().iterator();
        int i = 0;
        while (it != null && it.hasNext()) {
            i = it.next().getValue().size() + i;
        }
        if (i > 20) {
            return false;
        }
        fence.f161f = -1;
        if (!m1203b()) {
            ArrayList<Fence> arrayList = this.f796b.get(pendingIntent);
            Fence fence2 = null;
            Iterator<Fence> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Fence next = it2.next();
                if (!next.f157b.equals(fence.f157b)) {
                    next = fence2;
                }
                fence2 = next;
            }
            if (fence2 != null) {
                arrayList.remove(fence2);
            }
            arrayList.add(fence);
            this.f796b.put(pendingIntent, arrayList);
        } else {
            ArrayList<Fence> arrayList2 = new ArrayList<>();
            arrayList2.add(fence);
            this.f796b.put(pendingIntent, arrayList2);
        }
        return true;
    }
}
