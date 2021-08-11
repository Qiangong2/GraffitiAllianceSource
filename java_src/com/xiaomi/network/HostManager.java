package com.xiaomi.network;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.support.p007v4.p009os.EnvironmentCompat;
import android.text.TextUtils;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.file.C1851a;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.AbstractC1864c;
import com.xiaomi.channel.commonutils.network.C1862a;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.common.logger.thrift.mfs.C1876a;
import com.xiaomi.common.logger.thrift.mfs.C1878b;
import com.xiaomi.common.logger.thrift.mfs.C1882d;
import com.xiaomi.common.logger.thrift.mfs.C1884e;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.network.UploadHostStatHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HostManager {
    private static HostManagerFactory factory;
    protected static boolean hostLoaded = false;
    protected static Map<String, ArrayList<String>> mReservedHosts = new HashMap();
    private static String sAppName;
    private static String sAppVersion;
    private static HostManager sInstance;
    private final long MAX_REQUEST_FAILURE_CNT = 15;
    private String currentISP = "isp_prov_city_country_ip";
    private UploadHostStatHelper.HttpRecordCallback httpRecordCallback = new C1913a(this);
    private long lastRemoteRequestTimestamp = 0;
    protected Map<String, Fallbacks> mHostsMapping = new HashMap();
    private long remoteRequestFailureCount = 0;
    protected Context sAppContext;
    private HostFilter sHostFilter;
    protected HttpGet sHttpGetter;
    private String sUserId = "0";

    public interface HostManagerFactory {
        /* renamed from: a */
        HostManager mo10281a(Context context, HostFilter hostFilter, HttpGet httpGet, String str);
    }

    public interface HttpGet {
        /* renamed from: a */
        String mo10282a(String str);
    }

    protected HostManager(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        this.sAppContext = context.getApplicationContext();
        if (this.sAppContext == null) {
            this.sAppContext = context;
        }
        this.sHttpGetter = httpGet;
        if (hostFilter == null) {
            this.sHostFilter = new C1914b(this);
        } else {
            this.sHostFilter = hostFilter;
        }
        this.sUserId = str;
        sAppName = str2 == null ? context.getPackageName() : str2;
        sAppVersion = str3 == null ? getVersionName() : str3;
    }

    public static void addReservedHost(String str, String str2) {
        ArrayList<String> arrayList = mReservedHosts.get(str);
        synchronized (mReservedHosts) {
            if (arrayList == null) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(str2);
                mReservedHosts.put(str, arrayList2);
            } else if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
    }

    public static synchronized HostManager getInstance() {
        HostManager hostManager;
        synchronized (HostManager.class) {
            if (sInstance == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
            hostManager = sInstance;
        }
        return hostManager;
    }

    private String getVersionName() {
        try {
            PackageInfo packageInfo = this.sAppContext.getPackageManager().getPackageInfo(this.sAppContext.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (Exception e) {
        }
        return "0";
    }

    public static synchronized void init(Context context, HostFilter hostFilter, HttpGet httpGet, String str, String str2, String str3) {
        synchronized (HostManager.class) {
            if (sInstance == null) {
                if (factory == null) {
                    sInstance = new HostManager(context, hostFilter, httpGet, str, str2, str3);
                } else {
                    sInstance = factory.mo10281a(context, hostFilter, httpGet, str);
                }
                if (sInstance != null) {
                    if (UploadHostStatHelper.m7074a() == null) {
                        UploadHostStatHelper.m7077a(context);
                    }
                    UploadHostStatHelper.m7074a().mo10290a(sInstance.httpRecordCallback);
                }
            }
        }
    }

    public static <T> String join(Collection<T> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            sb.append((Object) it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(str);
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    private String processNetwork(String str) {
        return TextUtils.isEmpty(str) ? EnvironmentCompat.MEDIA_UNKNOWN : str.startsWith("WIFI") ? "WIFI" : str;
    }

    private ArrayList<Fallback> requestRemoteFallbacks(ArrayList<String> arrayList) {
        purge();
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            for (String str : this.mHostsMapping.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        synchronized (mReservedHosts) {
            for (String str2 : mReservedHosts.keySet()) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (!arrayList.contains(getHost())) {
            arrayList.add(getHost());
        }
        ArrayList<Fallback> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str3 = C1865d.m6763e(this.sAppContext) ? "wifi" : "wap";
            String remoteFallbackJSON = getRemoteFallbackJSON(arrayList, str3, this.sUserId);
            if (!TextUtils.isEmpty(remoteFallbackJSON)) {
                JSONObject jSONObject = new JSONObject(remoteFallbackJSON);
                if ("OK".equalsIgnoreCase(jSONObject.getString("S"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("R");
                    String string = jSONObject2.getString("province");
                    String string2 = jSONObject2.getString("city");
                    String string3 = jSONObject2.getString("isp");
                    String string4 = jSONObject2.getString("ip");
                    String string5 = jSONObject2.getString(C1447g.f3443G);
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(str3);
                    if (str3.equals("wap")) {
                        str3 = getActiveNetworkLabel();
                    }
                    AbstractC1855b.m6718a("get bucket: " + string5 + " " + string + " " + " isp:" + string3 + " " + str3 + " hosts:" + jSONObject3.toString());
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        String str4 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject3.optJSONArray(str4);
                        if (optJSONArray == null) {
                            AbstractC1855b.m6718a("no bucket found for " + str4);
                        } else {
                            Fallback fallback = new Fallback(str4);
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                String string6 = optJSONArray.getString(i3);
                                if (!TextUtils.isEmpty(string6)) {
                                    fallback.mo10230a(new C1917e(string6, optJSONArray.length() - i3));
                                }
                            }
                            arrayList2.set(i2, fallback);
                            fallback.f4899g = string5;
                            fallback.f4895c = string;
                            fallback.f4897e = string3;
                            fallback.f4898f = string4;
                            fallback.f4896d = string2;
                            if (jSONObject2.has("stat-percent")) {
                                fallback.mo10228a(jSONObject2.getDouble("stat-percent"));
                            }
                            if (jSONObject2.has("stat-domain")) {
                                fallback.mo10238b(jSONObject2.getString("stat-domain"));
                            }
                            if (jSONObject2.has("ttl")) {
                                fallback.mo10229a(((long) jSONObject2.getInt("ttl")) * 1000);
                            }
                            setCurrentISP(fallback.mo10244e());
                        }
                    }
                }
            }
        } catch (JSONException e) {
            AbstractC1855b.m6718a("failed to get bucket" + e.getMessage());
        } catch (IOException e2) {
            AbstractC1855b.m6718a("failed to get bucket" + e2.getMessage());
        } catch (Exception e3) {
            AbstractC1855b.m6718a("failed to get bucket" + e3.getMessage());
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Fallback fallback2 = arrayList2.get(i4);
            if (fallback2 != null) {
                updateFallbacks(arrayList.get(i4), fallback2);
            }
        }
        persist();
        return arrayList2;
    }

    public static synchronized void setHostManagerFactory(HostManagerFactory hostManagerFactory) {
        synchronized (HostManager.class) {
            factory = hostManagerFactory;
            if (!(UploadHostStatHelper.m7074a() == null || sInstance == null)) {
                UploadHostStatHelper.m7074a().mo10292b(sInstance.httpRecordCallback);
            }
            sInstance = null;
        }
    }

    /* access modifiers changed from: protected */
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
                    fromJSON(loadHosts);
                    AbstractC1855b.m6718a("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                AbstractC1855b.m6718a("load host exception " + th.getMessage());
            }
            return false;
        }
    }

    public void clear() {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void fromJSON(String str) {
        synchronized (this.mHostsMapping) {
            this.mHostsMapping.clear();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                Fallbacks fromJSON = new Fallbacks().fromJSON(jSONArray.getJSONObject(i));
                this.mHostsMapping.put(fromJSON.getHost(), fromJSON);
            }
        }
    }

    public ArrayList<C1878b> generateHostStats() {
        ArrayList<C1878b> arrayList;
        C1878b bVar;
        int i;
        int i2;
        int i3;
        synchronized (this.mHostsMapping) {
            HashMap hashMap = new HashMap();
            for (String str : this.mHostsMapping.keySet()) {
                Fallbacks fallbacks = this.mHostsMapping.get(str);
                if (fallbacks != null) {
                    Iterator<Fallback> it = fallbacks.getFallbacks().iterator();
                    while (it.hasNext()) {
                        Fallback next = it.next();
                        C1878b bVar2 = (C1878b) hashMap.get(next.mo10244e());
                        if (bVar2 == null) {
                            C1878b bVar3 = new C1878b();
                            bVar3.mo9974a("httpapi");
                            bVar3.mo9986e(next.f4898f);
                            bVar3.mo9984d(processNetwork(next.f4893a));
                            bVar3.mo9979b(this.sUserId);
                            bVar3.mo9981c(sAppVersion);
                            bVar3.mo9989f(sAppName);
                            bVar3.mo9992g(this.sAppContext.getPackageName());
                            bVar3.mo9993h(getVersionName());
                            C1884e eVar = new C1884e();
                            eVar.mo10048c(next.f4896d);
                            eVar.mo10042a(next.f4899g);
                            eVar.mo10046b(next.f4895c);
                            eVar.mo10051d(next.f4897e);
                            bVar3.mo9973a(eVar);
                            hashMap.put(next.mo10244e(), bVar3);
                            bVar = bVar3;
                        } else {
                            bVar = bVar2;
                        }
                        C1876a aVar = new C1876a();
                        aVar.mo9961a(next.f4894b);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<C1917e> it2 = next.mo10245f().iterator();
                        while (it2.hasNext()) {
                            C1917e next2 = it2.next();
                            ArrayList<AccessHistory> a = next2.mo10298a();
                            if (!a.isEmpty()) {
                                C1882d dVar = new C1882d();
                                dVar.mo10019a(next2.f4925a);
                                int i4 = 0;
                                int i5 = 0;
                                long j = 0;
                                int i6 = 0;
                                HashMap hashMap2 = new HashMap();
                                Iterator<AccessHistory> it3 = a.iterator();
                                while (it3.hasNext()) {
                                    AccessHistory next3 = it3.next();
                                    if (next3.mo10218a() >= 0) {
                                        j += next3.mo10220b();
                                        i2 = (int) (next3.mo10222d() + ((long) i6));
                                        i3 = i5;
                                        i = i4 + 1;
                                    } else {
                                        String e = next3.mo10223e();
                                        if (!TextUtils.isEmpty(e)) {
                                            hashMap2.put(e, Integer.valueOf(hashMap2.containsKey(e) ? hashMap2.get(e).intValue() + 1 : 1));
                                        }
                                        int i7 = i5 + 1;
                                        i = i4;
                                        i2 = i6;
                                        i3 = i7;
                                    }
                                    i4 = i;
                                    i5 = i3;
                                    i6 = i2;
                                }
                                dVar.mo10020a(hashMap2);
                                dVar.mo10025b(i4);
                                dVar.mo10017a(i5);
                                dVar.mo10018a(j);
                                dVar.mo10028c(i6);
                                arrayList2.add(dVar);
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            aVar.mo9962a(arrayList2);
                            bVar.mo9975a(aVar);
                        }
                    }
                }
            }
            arrayList = new ArrayList<>();
            for (C1878b bVar4 : hashMap.values()) {
                if (bVar4.mo9991g() > 0) {
                    arrayList.add(bVar4);
                }
            }
        }
        return arrayList;
    }

    public String getActiveNetworkLabel() {
        if (this.sAppContext == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.sAppContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (activeNetworkInfo.getType() != 1) {
                return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
            }
            WifiManager wifiManager = (WifiManager) this.sAppContext.getSystemService("wifi");
            if (!(wifiManager == null || wifiManager.getConnectionInfo() == null)) {
                return "WIFI-" + wifiManager.getConnectionInfo().getSSID();
            }
            return EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Exception e) {
        }
    }

    public Fallback getFallbacksByHost(String str) {
        return getFallbacksByHost(str, true);
    }

    public Fallback getFallbacksByHost(String str, boolean z) {
        Fallback requestRemoteFallback;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.sHostFilter.mo10260a(str)) {
            return null;
        } else {
            Fallback localFallback = getLocalFallback(str);
            return (localFallback == null || !localFallback.mo10241b()) ? (!z || !C1865d.m6762d(this.sAppContext) || (requestRemoteFallback = requestRemoteFallback(str)) == null) ? new C1915c(this, str, localFallback) : requestRemoteFallback : localFallback;
        }
    }

    public Fallback getFallbacksByURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            return getFallbacksByHost(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* access modifiers changed from: protected */
    public String getHost() {
        return "resolver.gslb.mi-idc.com";
    }

    /* access modifiers changed from: protected */
    public Fallback getLocalFallback(String str) {
        Fallbacks fallbacks;
        Fallback fallback;
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            fallbacks = this.mHostsMapping.get(str);
        }
        if (fallbacks == null || (fallback = fallbacks.getFallback()) == null) {
            return null;
        }
        return fallback;
    }

    /* access modifiers changed from: protected */
    public String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.sAppContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "com.xiaomi";
    }

    /* access modifiers changed from: protected */
    public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<AbstractC1864c> arrayList3 = new ArrayList();
        arrayList3.add(new C1862a("type", str));
        arrayList3.add(new C1862a("uuid", str2));
        arrayList3.add(new C1862a("list", join(arrayList, MiPushClient.ACCEPT_TIME_SEPARATOR)));
        Fallback localFallback = getLocalFallback("resolver.gslb.mi-idc.com");
        String format = String.format("http://%1$s/gslb/gslb/getbucket.asp?ver=3.0", "resolver.gslb.mi-idc.com");
        if (localFallback == null) {
            arrayList2.add(format);
        } else {
            arrayList2 = localFallback.mo10226a(format);
        }
        Iterator<String> it = arrayList2.iterator();
        IOException e = null;
        while (it.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it.next()).buildUpon();
            for (AbstractC1864c cVar : arrayList3) {
                buildUpon.appendQueryParameter(cVar.mo9936a(), cVar.mo9937b());
            }
            try {
                return this.sHttpGetter == null ? C1865d.m6752a(this.sAppContext, new URL(buildUpon.toString())) : this.sHttpGetter.mo10282a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    /* access modifiers changed from: protected */
    public String loadHosts() {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            File file = new File(this.sAppContext.getFilesDir(), getProcessName());
            if (file.isFile()) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            C1851a.m6705a(bufferedReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        AbstractC1855b.m6718a("load host exception " + th.getMessage());
                        C1851a.m6705a(bufferedReader);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        C1851a.m6705a(bufferedReader);
                        throw th;
                    }
                }
            } else {
                C1851a.m6705a((Reader) null);
                return null;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            C1851a.m6705a(bufferedReader);
            throw th;
        }
    }

    public void persist() {
        purge();
        synchronized (this.mHostsMapping) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.sAppContext.openFileOutput(getProcessName(), 0)));
                String jSONArray = toJSON().toString();
                if (!TextUtils.isEmpty(jSONArray)) {
                    bufferedWriter.write(jSONArray);
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public void purge() {
        synchronized (this.mHostsMapping) {
            for (Fallbacks fallbacks : this.mHostsMapping.values()) {
                fallbacks.purge(false);
            }
            boolean z = false;
            while (!z) {
                Iterator<String> it = this.mHostsMapping.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    String next = it.next();
                    if (this.mHostsMapping.get(next).getFallbacks().isEmpty()) {
                        this.mHostsMapping.remove(next);
                        z = false;
                        break;
                    }
                }
            }
        }
    }

    public void refreshFallbacks() {
        ArrayList<String> arrayList;
        synchronized (this.mHostsMapping) {
            checkHostMapping();
            arrayList = new ArrayList<>(this.mHostsMapping.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fallbacks fallbacks = this.mHostsMapping.get(arrayList.get(size));
                if (!(fallbacks == null || fallbacks.getFallback() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<Fallback> requestRemoteFallbacks = requestRemoteFallbacks(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (requestRemoteFallbacks.get(i) != null) {
                updateFallbacks(arrayList.get(i), requestRemoteFallbacks.get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public Fallback requestRemoteFallback(String str) {
        if (System.currentTimeMillis() - this.lastRemoteRequestTimestamp > this.remoteRequestFailureCount * 60 * 1000) {
            this.lastRemoteRequestTimestamp = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            Fallback fallback = requestRemoteFallbacks(arrayList).get(0);
            if (fallback != null) {
                this.remoteRequestFailureCount = 0;
                return fallback;
            } else if (this.remoteRequestFailureCount < 15) {
                this.remoteRequestFailureCount++;
            }
        }
        return null;
    }

    public void setCurrentISP(String str) {
        this.currentISP = str;
    }

    /* access modifiers changed from: protected */
    public JSONArray toJSON() {
        JSONArray jSONArray;
        synchronized (this.mHostsMapping) {
            jSONArray = new JSONArray();
            for (Fallbacks fallbacks : this.mHostsMapping.values()) {
                jSONArray.put(fallbacks.toJSON());
            }
        }
        return jSONArray;
    }

    public void updateFallbacks(String str, Fallback fallback) {
        if (TextUtils.isEmpty(str) || fallback == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + fallback);
        } else if (this.sHostFilter.mo10260a(str)) {
            synchronized (this.mHostsMapping) {
                checkHostMapping();
                if (this.mHostsMapping.containsKey(str)) {
                    this.mHostsMapping.get(str).addFallback(fallback);
                } else {
                    Fallbacks fallbacks = new Fallbacks(str);
                    fallbacks.addFallback(fallback);
                    this.mHostsMapping.put(str, fallbacks);
                }
            }
        }
    }
}
