package com.wanmei.sdk.core.net;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import java.net.InetSocketAddress;

/* renamed from: com.wanmei.sdk.core.net.e */
public class C1775e {

    /* renamed from: b */
    private static volatile C1775e f4482b;

    /* renamed from: a */
    private final Context f4483a;

    private C1775e(Context context) {
        this.f4483a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C1775e m6536a(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        if (f4482b == null) {
            synchronized (C1775e.class) {
                if (f4482b == null) {
                    f4482b = new C1775e(context);
                }
            }
        }
        return f4482b;
    }

    /* renamed from: a */
    public int mo9582a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f4483a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: b */
    public InetSocketAddress mo9583b() {
        if (mo9582a() != 0) {
            return null;
        }
        Cursor query = this.f4483a.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
        if (query != null && query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("proxy"));
            String string2 = query.getString(query.getColumnIndex("port"));
            if (string != null && string.trim().length() > 0) {
                return new InetSocketAddress(string, Integer.getInteger(string2, 80).intValue());
            }
        }
        if (query == null) {
            return null;
        }
        query.close();
        return null;
    }
}
