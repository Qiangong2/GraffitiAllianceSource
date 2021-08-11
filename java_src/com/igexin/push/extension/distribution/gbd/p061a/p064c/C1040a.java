package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import com.igexin.push.core.C0617f;
import com.igexin.push.extension.distribution.gbd.p066b.C1062e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import java.util.ArrayList;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.a */
public class C1040a {

    /* renamed from: b */
    private static String f2647b = "GBD_IBA";

    /* renamed from: a */
    protected EnumC1047h f2648a = EnumC1047h.SCAN_END;

    /* renamed from: c */
    private Context f2649c;

    /* renamed from: d */
    private BluetoothAdapter f2650d;

    /* renamed from: e */
    private BluetoothManager f2651e;

    /* renamed from: f */
    private ArrayList<C1062e> f2652f;

    /* renamed from: g */
    private C1045f f2653g;

    /* renamed from: h */
    private BluetoothAdapter.LeScanCallback f2654h;

    /* renamed from: i */
    private boolean f2655i = false;

    /* renamed from: j */
    private boolean f2656j = false;

    public C1040a(Context context) {
        try {
            this.f2649c = context;
            if (this.f2649c != null && m4209e()) {
                this.f2651e = (BluetoothManager) this.f2649c.getSystemService("bluetooth");
                if (this.f2651e != null) {
                    this.f2650d = this.f2651e.getAdapter();
                }
                mo5696b();
            }
            this.f2652f = new ArrayList<>();
        } catch (Throwable th) {
            C1115d.m4558a(th);
            this.f2655i = false;
        }
    }

    /* renamed from: a */
    private String m4201a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: e */
    private boolean m4209e() {
        try {
            Class.forName("android.bluetooth.BluetoothManager");
            Class.forName("android.bluetooth.BluetoothAdapter");
            if (Build.VERSION.SDK_INT < 18) {
                this.f2655i = false;
            } else if (!C1116e.m4570a(this.f2649c, "android.permission.BLUETOOTH") || !C1116e.m4570a(this.f2649c, "android.permission.BLUETOOTH_ADMIN")) {
                this.f2655i = false;
            } else {
                this.f2655i = true;
                C1115d.m4557a(f2647b, "check ibeacon permission success");
            }
            return this.f2655i;
        } catch (ClassNotFoundException e) {
            C1115d.m4558a(e);
            this.f2655i = false;
            return this.f2655i;
        }
    }

    /* renamed from: a */
    public void mo5694a() {
        if (this.f2655i && this.f2652f != null) {
            this.f2652f.clear();
            if (this.f2650d != null && this.f2650d.isEnabled() && !this.f2656j) {
                if (C0617f.m2395a().mo4619a(new C1041b(this, 5000))) {
                    C1115d.m4557a(f2647b, "start scan ibeacon");
                    this.f2650d.startLeScan(this.f2654h);
                    this.f2648a = EnumC1047h.SCAN_START;
                    this.f2656j = true;
                    return;
                }
                this.f2648a = EnumC1047h.SCAN_END;
            }
        }
    }

    /* renamed from: a */
    public void mo5695a(C1045f fVar) {
        this.f2653g = fVar;
    }

    /* renamed from: b */
    public void mo5696b() {
        this.f2654h = new C1042c(this);
    }

    /* renamed from: c */
    public ArrayList<C1062e> mo5697c() {
        return this.f2652f;
    }
}
