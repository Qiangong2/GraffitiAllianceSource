package com.wanmei.push.p101db;

import android.text.TextUtils;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.wanmei.push.bean.AppState;
import java.sql.SQLException;
import java.util.List;

/* renamed from: com.wanmei.push.db.a */
public final class C1683a {

    /* renamed from: c */
    private static C1683a f4278c;

    /* renamed from: a */
    protected RuntimeExceptionDao<AppState, Long> f4279a;

    /* renamed from: b */
    protected NoticeDBHelper f4280b;

    private C1683a(NoticeDBHelper noticeDBHelper) {
        this.f4280b = noticeDBHelper;
        if (this.f4279a == null) {
            this.f4279a = this.f4280b.getRuntimeExceptionDao(AppState.class);
        }
    }

    /* renamed from: a */
    public static C1683a m6306a(NoticeDBHelper noticeDBHelper) {
        if (f4278c == null) {
            f4278c = new C1683a(noticeDBHelper);
        }
        return f4278c;
    }

    /* renamed from: a */
    public final int mo9328a(AppState appState) {
        return this.f4279a.create(appState);
    }

    /* renamed from: a */
    public final int mo9329a(String str, String str2) throws SQLException {
        DeleteBuilder<AppState, Long> deleteBuilder = this.f4279a.deleteBuilder();
        deleteBuilder.where().mo6812eq(AppState.APP_ID, str).and().mo6812eq("apiADDR", str2);
        return deleteBuilder.delete();
    }

    /* renamed from: b */
    public final List<AppState> mo9330b(String str, String str2) throws SQLException {
        QueryBuilder<AppState, Long> queryBuilder = this.f4279a.queryBuilder();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            queryBuilder.where().mo6812eq(AppState.APP_ID, str).and().mo6812eq("apiADDR", str2);
        }
        return queryBuilder.query();
    }
}
