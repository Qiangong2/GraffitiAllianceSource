package com.igexin.push.extension.distribution.basic.p053h;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.extension.distribution.basic.p041b.C0714b;
import com.igexin.push.extension.distribution.basic.p041b.C0725m;
import com.igexin.push.extension.distribution.basic.p041b.C0726n;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import java.io.File;
import java.io.FileOutputStream;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.basic.h.d */
public class C0771d extends AbstractC0773f {

    /* renamed from: a */
    private String f2135a;

    /* renamed from: h */
    private BaseAction f2136h;

    /* renamed from: i */
    private int f2137i;

    /* renamed from: j */
    private AbstractC0774g f2138j;

    /* renamed from: k */
    private String f2139k;

    public C0771d(String str, String str2, String str3, BaseAction baseAction, int i, AbstractC0774g gVar) {
        super(str);
        this.f2136h = baseAction;
        this.f2135a = str3;
        this.f2137i = i;
        this.f2138j = gVar;
        this.f2139k = str2;
    }

    /* renamed from: a */
    private void m3179a(String str) {
        File file = new File(C0744j.f2059r);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(C0744j.f2059r + str + MqttTopic.TOPIC_LEVEL_SEPARATOR);
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    /* renamed from: b */
    private void m3180b(String str) {
        switch (this.f2137i) {
            case 1:
                ((C0726n) this.f2136h).mo4963e(str);
                return;
            case 2:
                ((C0725m) this.f2136h).mo4928j(str);
                return;
            case 3:
                ((C0725m) this.f2136h).mo4931k(str);
                return;
            case 4:
                ((C0714b) this.f2136h).mo4795c(str);
                return;
            case 5:
            default:
                return;
            case 6:
                ((C0725m) this.f2136h).mo4934m(str);
                return;
            case 7:
                ((C0726n) this.f2136h).mo4965f(str);
                return;
            case 8:
                ((C0725m) this.f2136h).mo4903c(str);
                return;
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f
    /* renamed from: a */
    public void mo5108a(Exception exc) {
        if (this.f2138j != null) {
            this.f2138j.mo4770a(exc);
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f
    /* renamed from: a */
    public void mo4764a(byte[] bArr) {
        this.f2145g = false;
        int parseInt = Integer.parseInt(this.f2136h.getActionId());
        m3179a(this.f2135a);
        String str = C0744j.f2059r + this.f2135a + MqttTopic.TOPIC_LEVEL_SEPARATOR + parseInt + "_" + this.f2137i + ".bin";
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (decodeByteArray != null) {
            decodeByteArray.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.close();
            decodeByteArray.recycle();
            m3180b(str);
            this.f2145g = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("imageurl", this.f2139k);
            contentValues.put("imagesrc", str);
            contentValues.put("taskid", this.f2135a);
            contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
            C0741g.m3010a().mo5022d().mo5045a("image", contentValues);
        } else {
            fileOutputStream.close();
            this.f2145g = false;
        }
        if (this.f2138j == null) {
            return;
        }
        if (this.f2145g) {
            this.f2138j.mo4769a(this.f2136h);
        } else {
            this.f2138j.mo4770a(new Exception("no target existed or downloading bitmap failed!"));
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return 65557;
    }
}
