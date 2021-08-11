package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.igexin.push.extension.distribution.gbd.p066b.C1062e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.c */
public class C1042c implements BluetoothAdapter.LeScanCallback {

    /* renamed from: a */
    final /* synthetic */ C1040a f2658a;

    C1042c(C1040a aVar) {
        this.f2658a = aVar;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        boolean z = false;
        int i2 = 2;
        while (true) {
            if (i2 > 5) {
                break;
            }
            try {
                if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                    z = true;
                    break;
                }
                i2++;
            } catch (Throwable th) {
                C1115d.m4558a(th);
                return;
            }
        }
        if (z) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, i2 + 4, bArr2, 0, 16);
            String str = this.f2658a.m4201a(bArr2);
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, 8));
            sb.append("-");
            sb.append(str.substring(8, 12));
            sb.append("-");
            sb.append(str.substring(12, 16));
            sb.append("-");
            sb.append(str.substring(16, 20));
            sb.append("-");
            sb.append(str.substring(20, 32));
            int i3 = ((bArr[i2 + 20] & 255) * 256) + (bArr[i2 + 21] & 255);
            int i4 = ((bArr[i2 + 22] & 255) * 256) + (bArr[i2 + 23] & 255);
            C1062e eVar = new C1062e();
            eVar.mo5753a(sb.toString());
            eVar.mo5752a(i3);
            eVar.mo5755b(i4);
            eVar.mo5757c(Math.abs((int) bArr[i2 + 24]));
            eVar.mo5759d(Math.abs(i));
            if (!this.f2658a.f2652f.contains(eVar)) {
                this.f2658a.f2652f.add(eVar);
            }
            C1115d.m4557a(C1040a.f2647b, "parser ibeacon info uudi = " + sb.toString());
        }
    }
}
