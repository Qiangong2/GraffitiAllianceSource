package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.network.c */
class C1915c extends Fallback {

    /* renamed from: i */
    Fallback f4921i = this.f4922j;

    /* renamed from: j */
    final /* synthetic */ Fallback f4922j;

    /* renamed from: k */
    final /* synthetic */ HostManager f4923k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1915c(HostManager hostManager, String str, Fallback fallback) {
        super(str);
        this.f4923k = hostManager;
        this.f4922j = fallback;
        this.f4894b = this.f4894b;
        if (this.f4922j != null) {
            this.f4898f = this.f4922j.f4898f;
        }
    }

    @Override // com.xiaomi.network.Fallback
    /* renamed from: a */
    public synchronized ArrayList<String> mo10227a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        if (this.f4921i != null) {
            arrayList.addAll(this.f4921i.mo10227a(true));
        }
        synchronized (HostManager.mReservedHosts) {
            ArrayList<String> arrayList2 = HostManager.mReservedHosts.get(this.f4894b);
            if (arrayList2 != null) {
                ArrayList<String> a = this.f4921i != null ? this.f4921i.mo10227a(false) : arrayList;
                Iterator<String> it = arrayList2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (a.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(this.f4894b);
                arrayList.add(this.f4894b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.network.Fallback
    /* renamed from: a */
    public synchronized void mo10234a(String str, AccessHistory accessHistory) {
        if (this.f4921i != null) {
            this.f4921i.mo10234a(str, accessHistory);
        }
    }

    @Override // com.xiaomi.network.Fallback
    /* renamed from: b */
    public boolean mo10241b() {
        return false;
    }
}
