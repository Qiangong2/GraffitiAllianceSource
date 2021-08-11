package com.wanmei.push.p101db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.wanmei.push.bean.AppState;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.p104g.C1714f;
import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.List;

/* renamed from: com.wanmei.push.db.d */
public final class C1686d {

    /* renamed from: f */
    private static C1686d f4285f;

    /* renamed from: a */
    protected Context f4286a;

    /* renamed from: b */
    protected SQLiteDatabase f4287b;

    /* renamed from: c */
    protected C1684b f4288c;

    /* renamed from: d */
    protected C1683a f4289d;

    /* renamed from: e */
    protected WeakReference<NoticeDBHelper> f4290e;

    /* renamed from: a */
    public static synchronized C1686d m6314a(Context context) {
        C1686d dVar;
        synchronized (C1686d.class) {
            if (f4285f == null) {
                f4285f = new C1686d();
            }
            f4285f.f4286a = context.getApplicationContext();
            dVar = f4285f;
        }
        return dVar;
    }

    /* renamed from: c */
    private synchronized void m6315c() throws SQLException {
        if (this.f4290e == null) {
            this.f4290e = new WeakReference<>(new NoticeDBHelper(this.f4286a));
        }
        NoticeDBHelper noticeDBHelper = this.f4290e.get();
        if (noticeDBHelper != null) {
            this.f4287b = noticeDBHelper.getWritableDatabase();
            this.f4288c = C1684b.m6310a(noticeDBHelper);
            this.f4289d = C1683a.m6306a(noticeDBHelper);
        }
    }

    /* renamed from: d */
    private synchronized void m6316d() {
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public final synchronized List<Notice> mo9334a() {
        List<Notice> list;
        try {
            m6315c();
            C1684b bVar = this.f4288c;
            Context context = this.f4286a;
            list = bVar.mo9333b("", "");
            m6316d();
        } catch (Exception e) {
            C1714f.m6382b("noticeDBManager", "error when getAccountList : " + e.getMessage());
            m6316d();
            list = null;
        } catch (Throwable th) {
            m6316d();
            throw th;
        }
        return list;
    }

    /* renamed from: a */
    public final <T> boolean mo9335a(T t) {
        if (t == null) {
            return false;
        }
        try {
            m6315c();
            this.f4287b.beginTransaction();
            if (t instanceof Notice) {
                T t2 = t;
                C1684b bVar = this.f4288c;
                Context context = this.f4286a;
                if (bVar.mo9333b(t2.getMsgId(), t2.getApiAddr()).isEmpty()) {
                    if (this.f4288c.mo9331a(t2) > 0) {
                        this.f4287b.setTransactionSuccessful();
                        try {
                            if (this.f4287b != null) {
                                this.f4287b.endTransaction();
                            }
                            m6316d();
                        } catch (Exception e) {
                            C1714f.m6382b("noticeDBManager", "error when updateNotice : " + e.getMessage());
                        }
                        return true;
                    }
                }
            }
            if (t instanceof AppState) {
                T t3 = t;
                C1683a aVar = this.f4289d;
                Context context2 = this.f4286a;
                if (aVar.mo9330b(t3.getAppId(), t3.getApiAddr()).isEmpty()) {
                    if (this.f4289d.mo9328a(t3) > 0) {
                        this.f4287b.setTransactionSuccessful();
                        try {
                            if (this.f4287b != null) {
                                this.f4287b.endTransaction();
                            }
                            m6316d();
                        } catch (Exception e2) {
                            C1714f.m6382b("noticeDBManager", "error when updateNotice : " + e2.getMessage());
                        }
                        return true;
                    }
                }
            }
            try {
                if (this.f4287b != null) {
                    this.f4287b.endTransaction();
                }
                m6316d();
            } catch (Exception e3) {
                C1714f.m6382b("noticeDBManager", "error when updateNotice : " + e3.getMessage());
            }
        } catch (Exception e4) {
            C1714f.m6382b("noticeDBManager", "error when updateNotice : " + e4.getMessage());
            try {
                if (this.f4287b != null) {
                    this.f4287b.endTransaction();
                }
                m6316d();
            } catch (Exception e5) {
                C1714f.m6382b("noticeDBManager", "error when updateNotice : " + e5.getMessage());
            }
        } catch (Throwable th) {
            try {
                if (this.f4287b != null) {
                    this.f4287b.endTransaction();
                }
                m6316d();
            } catch (Exception e6) {
                C1714f.m6382b("noticeDBManager", "error when updateNotice : " + e6.getMessage());
            }
            throw th;
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo9336a(String str, String str2) {
        boolean z = false;
        try {
            m6315c();
            if (this.f4288c.mo9332a(str, str2) > 0 || this.f4289d.mo9329a(str, str2) > 0) {
                z = true;
            }
        } catch (Exception e) {
            C1714f.m6382b("noticeDBManager", "error when deleteNotice : " + e.getMessage());
        } finally {
            m6316d();
        }
        return z;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public final synchronized List<AppState> mo9337b() {
        List<AppState> list;
        try {
            m6315c();
            C1683a aVar = this.f4289d;
            Context context = this.f4286a;
            list = aVar.mo9330b("", "");
            m6316d();
        } catch (Exception e) {
            C1714f.m6382b("noticeDBManager", "error when getAccountList : " + e.getMessage());
            m6316d();
            list = null;
        } catch (Throwable th) {
            m6316d();
            throw th;
        }
        return list;
    }
}
