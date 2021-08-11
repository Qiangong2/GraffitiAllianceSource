package com.xiaomi.network;

import android.content.Context;
import com.xiaomi.channel.commonutils.network.AbstractC1864c;
import java.util.List;

public abstract class HttpProcessor {

    /* renamed from: a */
    private int f4912a;

    public HttpProcessor(int i) {
        this.f4912a = i;
    }

    /* renamed from: a */
    public int mo10286a() {
        return this.f4912a;
    }

    /* renamed from: a */
    public boolean mo10287a(Context context, String str, List<AbstractC1864c> list) {
        return true;
    }

    /* renamed from: b */
    public abstract String mo10288b(Context context, String str, List<AbstractC1864c> list);
}
