package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.n */
public class RunnableC1053n implements Runnable {

    /* renamed from: a */
    String f2704a;

    /* renamed from: b */
    final /* synthetic */ C1048i f2705b;

    public RunnableC1053n(C1048i iVar, String str) {
        this.f2705b = iVar;
        this.f2704a = str;
    }

    public void run() {
        try {
            InetAddress byName = InetAddress.getByName(this.f2704a);
            byte[] a = C1048i.m4254a(this.f2705b);
            C1048i.m4255b(this.f2705b).send(new DatagramPacket(a, a.length, byName, 137));
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }
}
