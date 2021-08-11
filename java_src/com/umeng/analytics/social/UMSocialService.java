package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import org.json.JSONObject;

public abstract class UMSocialService {

    /* renamed from: com.umeng.analytics.social.UMSocialService$b */
    public interface AbstractC1567b {
        /* renamed from: a */
        void mo8960a();

        /* renamed from: a */
        void mo8961a(C1570c cVar, UMPlatformData... uMPlatformDataArr);
    }

    /* renamed from: a */
    private static void m6008a(Context context, AbstractC1567b bVar, String str, UMPlatformData... uMPlatformDataArr) {
        if (uMPlatformDataArr != null) {
            try {
                for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
                    if (!uMPlatformData.isValid()) {
                        throw new C1568a("parameter is not valid.");
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
        new AsyncTaskC1566a(AbstractC1572e.m6027a(context, str, uMPlatformDataArr), bVar, uMPlatformDataArr).execute(new Void[0]);
    }

    public static void share(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        m6008a(context, null, str, uMPlatformDataArr);
    }

    public static void share(Context context, UMPlatformData... uMPlatformDataArr) {
        m6008a(context, null, null, uMPlatformDataArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.social.UMSocialService$a */
    public static class AsyncTaskC1566a extends AsyncTask<Void, Void, C1570c> {

        /* renamed from: a */
        String f3972a;

        /* renamed from: b */
        String f3973b;

        /* renamed from: c */
        AbstractC1567b f3974c;

        /* renamed from: d */
        UMPlatformData[] f3975d;

        public AsyncTaskC1566a(String[] strArr, AbstractC1567b bVar, UMPlatformData[] uMPlatformDataArr) {
            this.f3972a = strArr[0];
            this.f3973b = strArr[1];
            this.f3974c = bVar;
            this.f3975d = uMPlatformDataArr;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (this.f3974c != null) {
                this.f3974c.mo8960a();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C1570c doInBackground(Void... voidArr) {
            String a;
            int i;
            if (TextUtils.isEmpty(this.f3973b)) {
                a = AbstractC1569b.m6015a(this.f3972a);
            } else {
                a = AbstractC1569b.m6016a(this.f3972a, this.f3973b);
            }
            try {
                JSONObject jSONObject = new JSONObject(a);
                int optInt = jSONObject.optInt("st");
                if (optInt == 0) {
                    i = -404;
                } else {
                    i = optInt;
                }
                C1570c cVar = new C1570c(i);
                String optString = jSONObject.optString("msg");
                if (!TextUtils.isEmpty(optString)) {
                    cVar.mo8966a(optString);
                }
                String optString2 = jSONObject.optString("data");
                if (TextUtils.isEmpty(optString2)) {
                    return cVar;
                }
                cVar.mo8968b(optString2);
                return cVar;
            } catch (Exception e) {
                return new C1570c(-99, e);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(C1570c cVar) {
            if (this.f3974c != null) {
                this.f3974c.mo8961a(cVar, this.f3975d);
            }
        }
    }
}
