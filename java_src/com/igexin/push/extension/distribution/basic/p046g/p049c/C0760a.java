package com.igexin.push.extension.distribution.basic.p046g.p049c;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import android.widget.Toast;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.p041b.C0714b;
import com.igexin.push.extension.distribution.basic.p042c.C0735a;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a;
import com.igexin.push.extension.distribution.basic.p046g.p047a.EnumC0756d;
import com.igexin.push.extension.distribution.basic.p046g.p048b.C0759b;
import com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a;
import com.igexin.push.extension.distribution.basic.p046g.p051e.C0764b;
import com.igexin.push.extension.distribution.basic.p046g.p052f.C0767a;
import com.wanmei.push.bean.AppState;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.g.c.a */
public class C0760a implements AbstractC0762a {

    /* renamed from: a */
    private Context f2120a = C0744j.f2042a;

    /* renamed from: b */
    private NotificationManager f2121b = ((NotificationManager) this.f2120a.getApplicationContext().getSystemService("notification"));

    /* renamed from: c */
    private C0764b f2122c = new C0764b(this.f2120a);

    /* renamed from: a */
    private int m3094a() {
        int identifier = C0618g.f1635f.getResources().getIdentifier("push_small", "drawable", C0618g.f1634e);
        return identifier == 0 ? C0618g.f1635f.getResources().getIdentifier("push_small", "mipmap", C0618g.f1634e) : identifier;
    }

    /* renamed from: a */
    private int m3095a(Context context, C0714b bVar) {
        int i;
        String substring;
        String str = null;
        if (bVar != null) {
            try {
                str = bVar.mo4791b();
            } catch (Throwable th) {
                return 17301651;
            }
        }
        if (str == null || "".equals(str)) {
            i = m3096a(context, "push", "drawable");
            if (i == 0) {
                i = 17301651;
            }
        } else {
            i = (!str.startsWith("file://") || (substring = str.substring(7, str.indexOf("."))) == null || substring.length() <= 0) ? 17301651 : m3096a(context, substring, "drawable");
        }
        if (i == 0) {
            return 17301651;
        }
        return i;
    }

    /* renamed from: a */
    public static int m3096a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getApplicationInfo().packageName);
    }

    /* renamed from: a */
    private Bitmap m3097a(C0714b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            if (bVar.mo4794c() != null) {
                return BitmapFactory.decodeFile(bVar.mo4794c());
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: e */
    private Intent m3098e(C0753a aVar) {
        Uri fromFile = Uri.fromFile(new File(aVar.mo5076g()));
        Intent intent = new Intent("com.igexin.sdk.action.INSTALL", Uri.parse("package:"));
        Bundle bundle = new Bundle();
        bundle.putString("uri", fromFile.toString());
        PushTaskBean j = aVar.mo5080k().mo4811j();
        if (j != null) {
            bundle.putString(AppState.APP_ID, j.getAppid());
            bundle.putString("appKey", j.getAppKey());
            bundle.putString("messageId", j.getMessageId());
            bundle.putString("taskId", j.getTaskId());
            bundle.putString("msgAddress", j.getMsgAddress());
        }
        intent.putExtras(bundle);
        return intent;
    }

    /* renamed from: f */
    private void m3099f(C0753a aVar) {
        PushTaskBean j;
        C0714b k = aVar.mo5080k();
        if (k != null && (j = k.mo4811j()) != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("messageid", j.getMessageId());
            contentValues.put("taskid", j.getTaskId());
            contentValues.put("appid", j.getAppid());
            contentValues.put("key", "APPINSTALL_" + k.mo4812k());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("is_autostart", k.mo4805f());
                if (k.mo4816o() != null) {
                    jSONObject.put("notify_content", k.mo4816o());
                }
                if (k.mo4815n() != null) {
                    jSONObject.put("notify_ticker", k.mo4815n());
                }
                contentValues.put("info", C0476a.m1776b(jSONObject.toString().getBytes()));
            } catch (Exception e) {
            }
            Time time = new Time();
            time.setToNow();
            contentValues.put("createtime", time.format2445().substring(0, 8));
            C0741g.m3010a().mo5022d().mo5045a("message", contentValues);
        }
    }

    /* renamed from: g */
    private void m3100g(C0753a aVar) {
        Intent e = m3098e(aVar);
        if (e != null) {
            Message message = new Message();
            message.what = C0735a.f2012a;
            message.obj = e;
            C0741g.m3010a().mo5017a(message);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02a9  */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3101h(com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a r17) {
        /*
        // Method dump skipped, instructions count: 715
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p049c.C0760a.m3101h(com.igexin.push.extension.distribution.basic.g.a.a):void");
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a
    /* renamed from: a */
    public void mo5093a(C0753a aVar) {
        ActivityC0460a.m1698b("EXT-download-Listener|onFirstDownload");
        C0535e.m2034a().mo4368a(aVar.mo5080k().mo4811j(), "10050");
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a
    /* renamed from: a */
    public void mo5094a(C0753a aVar, EnumC0756d dVar) {
        try {
            ActivityC0460a.m1698b("EXT-download-Listener|onDownloadFailed:" + aVar.mo5062a() + " failed code:" + dVar.toString());
            ActivityC0460a.m1698b("EXT-download-Listener|onDownloadFailed failed time:" + aVar.mo5079j() + 1);
            aVar.mo5068b(aVar.mo5079j() + 1);
            C0759b.m3088a(this.f2120a).mo5091b(aVar);
            if (aVar.mo5079j() > 3) {
                if (!TextUtils.isEmpty(aVar.mo5076g())) {
                    File file = new File(aVar.mo5076g());
                    if (file.exists()) {
                        file.delete();
                    }
                }
                C0759b.m3088a(this.f2120a).mo5092c(aVar);
                ActivityC0460a.m1698b("EXT-download-Listener|failed time > MAX_FAIL_TIME");
            }
            C0714b k = aVar.mo5080k();
            if (k.mo4810i() && !k.mo4814m()) {
                this.f2122c.mo5104a(aVar.mo5067b()).mo5106b("下载失败").mo5101a((int) aVar.mo5071c(), (int) aVar.mo5073d(), false).mo5100a(17301633);
                if (m3094a() != 0) {
                    this.f2122c.mo5100a(m3094a());
                } else {
                    this.f2122c.mo5100a(m3095a(this.f2120a, k));
                }
                if (m3097a(k) != null) {
                    this.f2122c.mo5103a(m3097a(k));
                } else {
                    this.f2122c.mo5103a(BitmapFactory.decodeResource(this.f2120a.getResources(), m3095a(this.f2120a, k)));
                }
                this.f2121b.notify((int) aVar.mo5062a(), this.f2122c.mo5099a());
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a
    /* renamed from: b */
    public boolean mo5095b(C0753a aVar) {
        try {
            ActivityC0460a.m1698b("EXT-download-Listener|onDownloadStart:" + aVar.mo5062a());
            m3101h(aVar);
            C0714b k = aVar.mo5080k();
            if (k == null) {
                C0759b.m3088a(this.f2120a).mo5092c(aVar);
                ActivityC0460a.m1698b("EXT-download-Listener|appDownloadBean == null delete task");
                return false;
            } else if (aVar.mo5080k().mo4809h() && !C0767a.m3154a(this.f2120a)) {
                ActivityC0460a.m1698b("EXT-download-Listener|wifi download and no wifi connect");
                return false;
            } else if (k.mo4814m()) {
                return true;
            } else {
                if (!k.mo4810i()) {
                    Toast.makeText(C0744j.f2042a, "开始下载", 0).show();
                } else {
                    C0764b bVar = new C0764b(this.f2120a);
                    bVar.mo5104a(aVar.mo5067b()).mo5106b("正在下载...").mo5100a(17301633);
                    if (aVar.mo5071c() == 0) {
                        bVar.mo5101a(0, 0, true);
                    } else {
                        bVar.mo5101a((int) aVar.mo5071c(), (int) aVar.mo5073d(), false);
                    }
                    if (m3094a() != 0) {
                        bVar.mo5100a(m3094a());
                    } else {
                        bVar.mo5100a(m3095a(this.f2120a, k));
                    }
                    if (m3097a(k) != null) {
                        bVar.mo5103a(m3097a(k));
                    } else {
                        bVar.mo5103a(BitmapFactory.decodeResource(this.f2120a.getResources(), m3095a(this.f2120a, k)));
                    }
                    Notification a = bVar.mo5099a();
                    int ringerMode = ((AudioManager) this.f2120a.getSystemService("audio")).getRingerMode();
                    if (ringerMode == 1) {
                        a.sound = null;
                        a.defaults |= 2;
                    } else if (ringerMode == 2) {
                        a.defaults |= 2;
                        a.defaults |= 1;
                    }
                    this.f2121b.notify((int) aVar.mo5062a(), bVar.mo5099a());
                }
                return true;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a
    /* renamed from: c */
    public void mo5096c(C0753a aVar) {
        try {
            C0714b k = aVar.mo5080k();
            if (k.mo4810i() && !k.mo4814m()) {
                this.f2122c.mo5104a(aVar.mo5067b()).mo5106b("正在下载...").mo5100a(17301633);
                if (aVar.mo5071c() == 0) {
                    this.f2122c.mo5101a(0, 0, true);
                } else {
                    this.f2122c.mo5101a((int) aVar.mo5071c(), (int) aVar.mo5073d(), false);
                }
                if (m3094a() != 0) {
                    this.f2122c.mo5100a(m3094a());
                } else {
                    this.f2122c.mo5100a(m3095a(this.f2120a, k));
                }
                if (m3097a(k) != null) {
                    this.f2122c.mo5103a(m3097a(k));
                } else {
                    this.f2122c.mo5103a(BitmapFactory.decodeResource(this.f2120a.getResources(), m3095a(this.f2120a, k)));
                }
                this.f2121b.notify((int) aVar.mo5062a(), this.f2122c.mo5099a());
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a
    /* renamed from: d */
    public void mo5097d(C0753a aVar) {
        try {
            ActivityC0460a.m1698b("EXT-download-Listener|onDownloadCompleted:" + aVar.mo5062a());
            C0759b.m3088a(this.f2120a).mo5092c(aVar);
            C0714b k = aVar.mo5080k();
            C0535e.m2034a().mo4368a(k.mo4811j(), "10060");
            m3099f(aVar);
            if (k.mo4807g()) {
                m3100g(aVar);
                if (!k.mo4814m() && k.mo4810i()) {
                    this.f2121b.cancel((int) aVar.mo5062a());
                }
            } else if (!k.mo4814m() && k.mo4810i()) {
                try {
                    Thread.sleep(1000, 0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.f2122c.mo5104a(aVar.mo5067b()).mo5106b("下载成功,点击安装！").mo5107c("下载成功").mo5101a(0, 0, false);
                if (k.mo4815n() != null) {
                    this.f2122c.mo5107c(k.mo4815n());
                }
                if (k.mo4816o() != null) {
                    this.f2122c.mo5106b(k.mo4816o());
                }
                if (m3094a() != 0) {
                    this.f2122c.mo5100a(m3094a());
                } else {
                    this.f2122c.mo5100a(m3095a(this.f2120a, k));
                }
                if (m3097a(k) != null) {
                    this.f2122c.mo5103a(m3097a(k));
                } else {
                    this.f2122c.mo5103a(BitmapFactory.decodeResource(this.f2120a.getResources(), m3095a(this.f2120a, k)));
                }
                this.f2122c.mo5102a(PendingIntent.getBroadcast(this.f2120a, (int) aVar.mo5062a(), m3098e(aVar), 0));
                this.f2122c.mo5105a(true);
                this.f2121b.notify((int) aVar.mo5062a(), this.f2122c.mo5099a());
            }
        } catch (Throwable th) {
        }
    }
}
