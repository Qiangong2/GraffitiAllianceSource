package com.wanmei.push.p101db;

import android.text.TextUtils;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.wanmei.push.bean.Notice;
import java.sql.SQLException;
import java.util.List;

/* renamed from: com.wanmei.push.db.b */
public final class C1684b {

    /* renamed from: c */
    private static C1684b f4281c;

    /* renamed from: a */
    protected RuntimeExceptionDao<Notice, Long> f4282a;

    /* renamed from: b */
    protected NoticeDBHelper f4283b;

    private C1684b(NoticeDBHelper noticeDBHelper) {
        this.f4283b = noticeDBHelper;
        if (this.f4282a == null) {
            this.f4282a = this.f4283b.getRuntimeExceptionDao(Notice.class);
        }
    }

    /* renamed from: a */
    public static C1684b m6310a(NoticeDBHelper noticeDBHelper) {
        if (f4281c == null) {
            f4281c = new C1684b(noticeDBHelper);
        }
        return f4281c;
    }

    /* renamed from: a */
    public final int mo9331a(Notice notice) {
        return this.f4282a.create(notice);
    }

    /* renamed from: a */
    public final int mo9332a(String str, String str2) throws SQLException {
        DeleteBuilder<Notice, Long> deleteBuilder = this.f4282a.deleteBuilder();
        deleteBuilder.where().mo6812eq(Notice.MSG_ID, str).and().mo6812eq("apiADDR", str2);
        return deleteBuilder.delete();
    }

    /* renamed from: b */
    public final List<Notice> mo9333b(String str, String str2) throws SQLException {
        QueryBuilder<Notice, Long> queryBuilder = this.f4282a.queryBuilder();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            queryBuilder.where().mo6812eq(Notice.MSG_ID, str).and().mo6812eq("apiADDR", str2);
        }
        return queryBuilder.query();
    }
}
