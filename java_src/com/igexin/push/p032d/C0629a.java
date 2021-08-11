package com.igexin.push.p032d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.igexin.p012b.p013a.p015b.AbstractC0455b;
import com.igexin.p012b.p013a.p015b.AbstractC0458e;
import com.igexin.p012b.p013a.p015b.p016a.p017a.C0451k;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0462a;

/* renamed from: com.igexin.push.d.a */
public class C0629a implements AbstractC0462a<String, Integer, AbstractC0455b, AbstractC0458e> {

    /* renamed from: a */
    public ConnectivityManager f1678a;

    /* renamed from: b */
    public Context f1679b;

    public C0629a(Context context, ConnectivityManager connectivityManager) {
        this.f1678a = connectivityManager;
        this.f1679b = context;
    }

    /* renamed from: a */
    public AbstractC0458e mo4176a(String str, Integer num, AbstractC0455b bVar) {
        NetworkInfo activeNetworkInfo;
        if (!str.startsWith("socket") || this.f1678a == null || (activeNetworkInfo = this.f1678a.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        return new C0451k(str, bVar);
    }
}
