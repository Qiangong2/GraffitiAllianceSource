package com.xiaomi.push.log;

import android.content.Context;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.misc.C1857b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* renamed from: com.xiaomi.push.log.f */
public class C1926f implements LoggerInterface {

    /* renamed from: a */
    private static final SimpleDateFormat f4962a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: b */
    private static C1857b f4963b = new C1857b(true);

    /* renamed from: c */
    private static String f4964c = "/MiPushLog";

    /* renamed from: f */
    private static List<Pair<String, Throwable>> f4965f = Collections.synchronizedList(new ArrayList());

    /* renamed from: d */
    private String f4966d;

    /* renamed from: e */
    private Context f4967e;

    public C1926f(Context context) {
        this.f4967e = context;
        if (context.getApplicationContext() != null) {
            this.f4967e = context.getApplicationContext();
        }
        this.f4966d = this.f4967e.getPackageName();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f7 A[SYNTHETIC, Splitter:B:42:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0107 A[SYNTHETIC, Splitter:B:50:0x0107] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x016c A[SYNTHETIC, Splitter:B:83:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x017c A[SYNTHETIC, Splitter:B:91:0x017c] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m7130b() {
        /*
        // Method dump skipped, instructions count: 519
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.C1926f.m7130b():void");
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str, Throwable th) {
        f4965f.add(new Pair<>(String.format("%1$s %2$s %3$s ", f4962a.format(new Date()), this.f4966d, str), th));
        f4963b.mo9927a(new C1927g(this));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f4966d = str;
    }
}
