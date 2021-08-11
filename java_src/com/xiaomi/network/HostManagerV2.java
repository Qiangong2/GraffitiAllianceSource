package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.AbstractC1864c;
import com.xiaomi.channel.commonutils.network.C1862a;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.network.HostManager;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManagerV2 extends HostManager {

    /* renamed from: a */
    private final int f4909a;

    /* renamed from: b */
    private final int f4910b;

    /* renamed from: c */
    private int f4911c;

    protected HostManagerV2(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
        this(context, hostFilter, httpGet, str, null, null);
    }

    protected HostManagerV2(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str, String str2, String str3) {
        super(context, hostFilter, httpGet, str, str2, str3);
        this.f4909a = 80;
        this.f4910b = 5222;
        this.f4911c = 80;
        addReservedHost("resolver.msg.xiaomi.net", "resolver.msg.xiaomi.net:5222");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo10283a() {
        JSONObject jSONObject;
        synchronized (this.mHostsMapping) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            jSONObject.put("data", toJSON());
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10284a(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            for (int i = 0; i < optJSONArray.length(); i++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(optJSONArray.getJSONObject(i));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.network.HostManager
    public boolean checkHostMapping() {
        synchronized (this.mHostsMapping) {
            if (hostLoaded) {
                return true;
            }
            hostLoaded = true;
            this.mHostsMapping.clear();
            try {
                String loadHosts = loadHosts();
                if (!TextUtils.isEmpty(loadHosts)) {
                    mo10284a(loadHosts);
                    AbstractC1855b.m6721b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                AbstractC1855b.m6718a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.network.HostManager
    public String getHost() {
        return "resolver.msg.xiaomi.net";
    }

    /* access modifiers changed from: protected */
    @Override // com.xiaomi.network.HostManager
    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        ArrayList<String> a;
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<AbstractC1864c> arrayList3 = new ArrayList();
        arrayList3.add(new C1862a("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new C1862a("connpt", C1865d.m6764f(this.sAppContext)));
        }
        arrayList3.add(new C1862a("uuid", str2));
        arrayList3.add(new C1862a("list", join(arrayList, MiPushClient.ACCEPT_TIME_SEPARATOR)));
        Fallback localFallback = getLocalFallback("resolver.msg.xiaomi.net");
        String format = String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", "resolver.msg.xiaomi.net:" + this.f4911c);
        if (localFallback == null) {
            arrayList2.add(format);
            synchronized (mReservedHosts) {
                Iterator it = ((ArrayList) mReservedHosts.get("resolver.msg.xiaomi.net")).iterator();
                while (it.hasNext()) {
                    arrayList2.add(String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", (String) it.next()));
                }
            }
            a = arrayList2;
        } else {
            a = localFallback.mo10226a(format);
        }
        Iterator<String> it2 = a.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (AbstractC1864c cVar : arrayList3) {
                buildUpon.appendQueryParameter(cVar.mo9936a(), cVar.mo9937b());
            }
            try {
                return this.sHttpGetter == null ? C1865d.m6752a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.mo10282a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            return super.getRemoteFallbackJSON(arrayList, str, str2);
        }
        return null;
    }

    @Override // com.xiaomi.network.HostManager
    public void persist() {
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                String jSONObject = mo10283a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                AbstractC1855b.m6718a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    @Override // com.xiaomi.network.HostManager
    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks fallbacks : this.mHostsMapping.values()) {
                fallbacks.purge(true);
            }
            boolean z = false;
            while (!z) {
                Iterator it = this.mHostsMapping.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String str = (String) it.next();
                    if (((Fallbacks) this.mHostsMapping.get(str)).getFallbacks().isEmpty()) {
                        this.mHostsMapping.remove(str);
                        z = false;
                        break;
                    }
                }
            }
        }
    }
}
