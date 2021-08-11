package com.igexin.push.extension.distribution.gbd.p069e.p070a;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p066b.C1061d;
import com.igexin.push.extension.distribution.gbd.p066b.C1064g;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1092c;
import com.igexin.push.extension.distribution.gbd.p071f.C1085a;
import com.igexin.push.extension.distribution.gbd.p071f.p072a.C1090e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.push.extension.distribution.gbd.p076i.C1124m;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.e.a.b */
public class C1080b {

    /* renamed from: a */
    private static C1080b f2930a;

    /* renamed from: d */
    private static final Object f2931d = new Object();

    /* renamed from: b */
    private List<C1064g> f2932b = new ArrayList();

    /* renamed from: c */
    private boolean f2933c = false;

    /* renamed from: e */
    private Comparator<C1064g> f2934e = new C1081c(this);

    /* renamed from: f */
    private AbstractC1092c f2935f = new C1082d(this);

    /* renamed from: a */
    public static C1080b m4391a() {
        if (f2930a == null) {
            f2930a = new C1080b();
        }
        return f2930a;
    }

    /* renamed from: a */
    private List<C1064g> m4392a(List<C1064g> list, int i) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        Iterator<C1064g> it = list.iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return arrayList;
            }
            C1064g next = it.next();
            if (i3 < 10 && next.mo5771b() == i) {
                arrayList.add(next);
                i3++;
            }
            i2 = i3;
        }
    }

    /* renamed from: a */
    private void m4393a(int i, StringBuilder sb, List<C1064g> list) {
        try {
            C1090e eVar = new C1090e(sb.toString().getBytes("UTF-8"), i, list);
            eVar.mo5845a(this.f2935f);
            if (!C0456c.m1661b().mo4216a(new C1085a(eVar), false, true)) {
                this.f2933c = false;
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
            this.f2933c = false;
        }
    }

    /* renamed from: a */
    private void m4395a(HashMap<String, C1061d> hashMap, int i, int i2, int i3) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (C0618g.f1647r != null) {
            if (hashMap != null) {
                str = "";
                str2 = "";
                str3 = "";
                str4 = "";
                for (String str9 : hashMap.keySet()) {
                    C1061d dVar = hashMap.get(str9);
                    String str10 = C1069c.f2837n.get(str9);
                    if (TextUtils.isEmpty(str10)) {
                        C1115d.m4557a("GBD_RALDataManager", "package name is empty");
                    } else {
                        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str)) {
                            String str11 = str2 + MqttTopic.MULTI_LEVEL_WILDCARD + str10;
                            String str12 = str3 + MiPushClient.ACCEPT_TIME_SEPARATOR + dVar.mo5747b();
                            str5 = str + MiPushClient.ACCEPT_TIME_SEPARATOR + dVar.mo5749c();
                            str6 = str4 + MiPushClient.ACCEPT_TIME_SEPARATOR + dVar.mo5745a();
                            str7 = str12;
                            str8 = str11;
                        } else {
                            String str13 = dVar.mo5747b() + "";
                            String str14 = dVar.mo5745a() + "";
                            String str15 = dVar.mo5749c() + "";
                            str6 = str14;
                            str7 = str13;
                            str8 = str10;
                            str5 = str15;
                        }
                        str = str5;
                        str2 = str8;
                        str3 = str7;
                        str4 = str6;
                    }
                }
            } else {
                str = "";
                str2 = "";
                str3 = "";
                str4 = "";
            }
            if (i != 0 || i2 != 0 || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str)) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k()));
                StringBuilder sb = new StringBuilder();
                sb.append(format);
                sb.append("|");
                sb.append(C0618g.f1647r);
                sb.append("|");
                sb.append(C0618g.f1602a);
                sb.append("|");
                sb.append(i3);
                sb.append("|");
                sb.append(str2);
                sb.append("|");
                sb.append(C0618g.f1649t);
                if (i3 != 1) {
                    sb.append("|");
                    sb.append(i2);
                    sb.append("|");
                    sb.append(i);
                    sb.append("|");
                    sb.append(str3);
                    sb.append("|");
                    sb.append(str4);
                    sb.append("|");
                    sb.append(str);
                    sb.append("|");
                    sb.append(C0618g.f1653x);
                    sb.append("|");
                    if (str2.contains("com.sina.weibo")) {
                        sb.append(C1124m.m4616a().mo5887b());
                    }
                } else {
                    sb.append("|");
                    sb.append(str4);
                    sb.append("|");
                    sb.append("|");
                    sb.append(str3);
                    sb.append("|");
                    sb.append("|");
                    sb.append(str);
                    sb.append("|");
                    sb.append(C0618g.f1653x);
                    sb.append("|");
                }
                mo5812a(sb.toString(), 19);
            }
        }
    }

    /* renamed from: a */
    private void m4396a(List<C1064g> list) {
        synchronized (f2931d) {
            if (list != null) {
                String[] strArr = new String[list.size()];
                int i = 0;
                for (C1064g gVar : list) {
                    strArr[i] = String.valueOf(gVar.mo5767a());
                    this.f2932b.remove(gVar);
                    i++;
                }
                C1069c.f2825b.mo5803a("ral", new String[]{"id"}, strArr);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4397a(List<C1064g> list, boolean z) {
        if (list != null) {
            try {
                int b = list.get(0).mo5771b();
                if (z) {
                    int size = list.size();
                    m4396a(list);
                    if (size < 10 && b == 6) {
                        m4399b(11);
                    } else if (size < 10 && b == 11) {
                        m4399b(14);
                    } else if (size < 10 && b == 14) {
                        m4399b(19);
                    } else if (size < 10 && b == 19) {
                        m4399b(24);
                    } else if (size < 10 && b == 24) {
                        m4399b(27);
                    } else if (size < 10 && b == 27) {
                        m4399b(28);
                    } else if (size < 10 && b == 28) {
                        m4399b(31);
                    } else if (size < 10 && b == 31) {
                        m4399b(34);
                    } else if (size >= 10 || b != 34) {
                        m4399b(b);
                    } else {
                        this.f2933c = false;
                    }
                } else if (b == 6) {
                    m4399b(11);
                } else if (b == 11) {
                    m4399b(14);
                } else if (b == 14) {
                    m4399b(19);
                } else if (b == 19) {
                    m4399b(24);
                } else if (b == 24) {
                    m4399b(27);
                } else if (b == 27) {
                    m4399b(28);
                } else if (b == 28) {
                    m4399b(31);
                } else if (b == 31) {
                    m4399b(34);
                } else if (b == 34) {
                    this.f2933c = false;
                }
            } catch (Exception e) {
                C1115d.m4558a(e);
            }
        } else {
            this.f2933c = false;
        }
    }

    /* renamed from: b */
    private int m4398b(String str, int i) {
        Cursor cursor = null;
        int i2 = 0;
        try {
            Cursor a = C1069c.f2825b.mo5800a("select count(value) c from look where t < '" + str + "' and " + "status" + " = " + 4 + " and " + "type" + " = " + i, (String[]) null);
            if (a != null && a.getCount() > 0 && a.moveToFirst()) {
                i2 = a.getInt(0);
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        return i2;
    }

    /* renamed from: b */
    private void m4399b(int i) {
        try {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            List<C1064g> a = m4392a(this.f2932b, i);
            if (!a.isEmpty()) {
                for (int i2 = 0; i2 < a.size(); i2++) {
                    C1064g gVar = a.get(i2);
                    if (i2 < a.size() - 1) {
                        sb.append(gVar.mo5773c());
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    } else {
                        sb.append(gVar.mo5773c());
                    }
                    arrayList.add(gVar);
                }
                m4393a(i, sb, arrayList);
            } else if (i == 6) {
                m4399b(11);
            } else if (i == 11) {
                m4399b(14);
            } else if (i == 14) {
                m4399b(19);
            } else if (i == 19) {
                m4399b(24);
            } else if (i == 24) {
                m4399b(27);
            } else if (i == 27) {
                m4399b(28);
            } else if (i == 28) {
                m4399b(31);
            } else if (i == 31) {
                m4399b(34);
            } else if (i == 34) {
                this.f2933c = false;
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* renamed from: c */
    private int m4400c(String str, int i) {
        Cursor cursor = null;
        try {
            Cursor a = C1069c.f2825b.mo5800a("select count(value) c from look where  t < '" + str + "' and " + "status" + " = " + 3 + " and type = " + i, (String[]) null);
            int i2 = (a == null || !a.moveToFirst()) ? 0 : a.getInt(0);
            C1115d.m4557a("GBD_RALDataManager", "screen notes count = " + i2);
            if (a == null) {
                return i2;
            }
            a.close();
            return i2;
        } catch (Exception e) {
            C1115d.m4558a(e);
            if (0 != 0) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00dc  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.HashMap<java.lang.String, com.igexin.push.extension.distribution.gbd.p066b.C1061d> m4401d(java.lang.String r9, int r10) {
        /*
        // Method dump skipped, instructions count: 249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b.m4401d(java.lang.String, int):java.util.HashMap");
    }

    /* renamed from: a */
    public void mo5811a(int i) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        try {
            m4395a(m4401d(format, i), m4398b(format, i), m4400c(format, i), i);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
        C1069c.f2825b.mo5801a("look", "t<'" + format + "' and " + "type" + " = " + i);
    }

    /* renamed from: a */
    public void mo5812a(String str, int i) {
        Cursor cursor = null;
        C1115d.m4557a("GBD_RALDataManager", "save type = " + i + " value = " + str);
        synchronized (f2931d) {
            if (this.f2932b.size() >= C1067a.f2804o) {
                Collections.sort(this.f2932b, this.f2934e);
                List<C1064g> arrayList = new ArrayList<>();
                arrayList.add(this.f2932b.get(0));
                m4396a(arrayList);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", Integer.valueOf(i));
            contentValues.put("value", C0476a.m1776b(str.getBytes()));
            contentValues.put("t", Long.valueOf(currentTimeMillis));
            if (C1069c.f2825b.mo5799a("ral", contentValues) != -1) {
                try {
                    Cursor a = C1069c.f2825b.mo5800a("select last_insert_rowid() from ral", (String[]) null);
                    if (a != null && a.moveToFirst()) {
                        int i2 = a.getInt(0);
                        C1064g gVar = new C1064g();
                        gVar.mo5768a(i2);
                        gVar.mo5772b(i);
                        gVar.mo5770a(str);
                        gVar.mo5769a(currentTimeMillis);
                        this.f2932b.add(gVar);
                    }
                    if (a != null) {
                        a.close();
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
    }

    /* renamed from: b */
    public void mo5813b() {
        Cursor cursor = null;
        try {
            Cursor a = C1069c.f2825b.mo5800a("select id, key, value, t from ral order by id", (String[]) null);
            if (a != null) {
                while (a.moveToNext()) {
                    int i = a.getInt(0);
                    int i2 = a.getInt(1);
                    byte[] c = C0476a.m1777c(a.getBlob(2));
                    long j = a.getLong(3);
                    C1064g gVar = new C1064g();
                    gVar.mo5768a(i);
                    gVar.mo5772b(i2);
                    gVar.mo5770a(new String(c));
                    gVar.mo5769a(j);
                    this.f2932b.add(gVar);
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    public void mo5814c() {
        if (!this.f2933c) {
            this.f2933c = true;
            m4399b(6);
        }
    }
}
