package com.umeng.analytics.p086a.p087a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p086a.p087a.C1376d;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p089c.C1391b;
import com.umeng.analytics.p086a.p089c.C1393d;
import com.umeng.analytics.p086a.p090d.C1412b;
import com.umeng.p085a.C1346h;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.umeng.analytics.a.a.a */
/* compiled from: CCSQLManager */
public class C1371a {
    /* renamed from: a */
    public static boolean m5080a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("drop table if exists " + str);
            return true;
        } catch (SQLException e) {
            C1346h.m5009e("delete table faild!");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m5085b(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            if (m5086c(sQLiteDatabase, str) >= 0) {
                sQLiteDatabase.execSQL("delete from " + str);
            }
            return true;
        } catch (SQLException e) {
            C1346h.m5009e("cleanTableData faild!" + e.toString());
            return false;
        }
    }

    /* renamed from: c */
    public static int m5086c(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = sQLiteDatabase.rawQuery("select * from " + str, null);
            i = cursor.getCount();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C1346h.m5009e("count error " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m5081a(SQLiteDatabase sQLiteDatabase, Collection<C1391b> collection) {
        try {
            sQLiteDatabase.beginTransaction();
            if (m5086c(sQLiteDatabase, C1376d.C1377a.f3250b) > 0) {
                m5085b(sQLiteDatabase, C1376d.C1377a.f3250b);
            }
            for (C1391b bVar : collection) {
                sQLiteDatabase.insert(C1376d.C1377a.f3250b, null, m5072a(bVar));
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLException e) {
            C1346h.m5009e("insert to Aggregated cache table faild!");
            sQLiteDatabase.endTransaction();
            return false;
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m5082a(C1387a aVar, SQLiteDatabase sQLiteDatabase, Collection<C1391b> collection) {
        try {
            sQLiteDatabase.beginTransaction();
            for (C1391b bVar : collection) {
                sQLiteDatabase.insert(C1376d.C1377a.f3249a, null, m5072a(bVar));
            }
            sQLiteDatabase.setTransactionSuccessful();
            m5085b(sQLiteDatabase, C1376d.C1377a.f3250b);
            aVar.mo8391a("success", false);
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLException e) {
            C1346h.m5009e("insert to Aggregated cache table faild!");
            sQLiteDatabase.endTransaction();
            return false;
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m5079a(SQLiteDatabase sQLiteDatabase, C1387a aVar) {
        try {
            sQLiteDatabase.beginTransaction();
            if (m5086c(sQLiteDatabase, C1376d.C1377a.f3250b) <= 0) {
                aVar.mo8391a("faild", false);
                return false;
            }
            sQLiteDatabase.execSQL("insert into aggregated(key, count, value, totalTimestamp, timeWindowNum, label) select key, count, value, totalTimestamp, timeWindowNum, label from aggregated_cache");
            sQLiteDatabase.setTransactionSuccessful();
            m5085b(sQLiteDatabase, C1376d.C1377a.f3250b);
            aVar.mo8391a("success", false);
            sQLiteDatabase.endTransaction();
            return true;
        } catch (SQLException e) {
            aVar.mo8391a(false, false);
            C1346h.m5009e("cacheToAggregatedTable happen " + e.toString());
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    private static ContentValues m5072a(C1391b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", bVar.mo8429a());
        contentValues.put("label", bVar.mo8439c());
        contentValues.put("count", Long.valueOf(bVar.mo8444g()));
        contentValues.put("value", Long.valueOf(bVar.mo8443f()));
        contentValues.put(C1376d.C1377a.C1378a.f3252b, Long.valueOf(bVar.mo8442e()));
        contentValues.put(C1376d.C1377a.C1378a.f3256f, bVar.mo8445h());
        return contentValues;
    }

    /* renamed from: b */
    public static boolean m5084b(SQLiteDatabase sQLiteDatabase, C1387a aVar) {
        Cursor cursor = null;
        try {
            HashMap hashMap = new HashMap();
            Cursor rawQuery = sQLiteDatabase.rawQuery("select * from aggregated_cache", null);
            while (rawQuery.moveToNext()) {
                C1391b bVar = new C1391b();
                bVar.mo8434a(C1376d.m5105b(rawQuery.getString(rawQuery.getColumnIndex("key"))));
                bVar.mo8438b(C1376d.m5105b(rawQuery.getString(rawQuery.getColumnIndex("label"))));
                bVar.mo8440c((long) rawQuery.getInt(rawQuery.getColumnIndex("count")));
                bVar.mo8436b((long) rawQuery.getInt(rawQuery.getColumnIndex("value")));
                bVar.mo8437b(rawQuery.getString(rawQuery.getColumnIndex(C1376d.C1377a.C1378a.f3256f)));
                bVar.mo8430a(Long.parseLong(rawQuery.getString(rawQuery.getColumnIndex(C1376d.C1377a.C1378a.f3252b))));
                hashMap.put(C1376d.m5105b(rawQuery.getString(rawQuery.getColumnIndex("key"))), bVar);
            }
            if (hashMap.size() > 0) {
                aVar.mo8391a(hashMap, false);
            } else {
                aVar.mo8391a("faild", false);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (SQLException e) {
            aVar.mo8391a(false, false);
            C1346h.m5009e("cacheToMemory happen " + e.toString());
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        return false;
    }

    /* renamed from: a */
    public static void m5077a(SQLiteDatabase sQLiteDatabase, boolean z, C1387a aVar) {
        m5085b(sQLiteDatabase, C1376d.C1383c.f3266a);
        m5085b(sQLiteDatabase, C1376d.C1377a.f3249a);
        if (!z) {
            m5085b(sQLiteDatabase, C1376d.C1380b.f3263a);
            aVar.mo8391a("success", false);
        }
    }

    /* renamed from: a */
    public static void m5075a(SQLiteDatabase sQLiteDatabase, String str, long j, long j2) {
        try {
            int c = m5086c(sQLiteDatabase, C1376d.C1383c.f3266a);
            int c2 = C1412b.m5211a().mo8477c();
            if (c < c2) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", str);
                contentValues.put(C1376d.C1383c.C1384a.f3268b, Long.valueOf(j2));
                contentValues.put("count", Long.valueOf(j));
                sQLiteDatabase.insert(C1376d.C1383c.f3266a, null, contentValues);
            } else if (c == c2) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("key", C1370a.f3232x);
                contentValues2.put(C1376d.C1383c.C1384a.f3268b, Long.valueOf(System.currentTimeMillis()));
                contentValues2.put("count", (Integer) 1);
                sQLiteDatabase.insert(C1376d.C1383c.f3266a, null, contentValues2);
            } else {
                m5088d(sQLiteDatabase, C1370a.f3232x);
            }
        } catch (SQLException e) {
        }
    }

    /* renamed from: d */
    private static void m5088d(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("update system set count=count+1 where key like '" + str + "'");
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static void m5078a(C1387a aVar, SQLiteDatabase sQLiteDatabase, List<String> list) {
        try {
            sQLiteDatabase.beginTransaction();
            if (m5086c(sQLiteDatabase, C1376d.C1380b.f3263a) > 0) {
                m5085b(sQLiteDatabase, C1376d.C1380b.f3263a);
            }
            for (String str : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(C1376d.C1380b.C1381a.f3264a, str);
                sQLiteDatabase.insert(C1376d.C1380b.f3263a, null, contentValues);
            }
            sQLiteDatabase.setTransactionSuccessful();
            aVar.mo8391a("success", false);
        } catch (SQLException e) {
            C1346h.m5009e("insertToLimitCKTable error " + e.toString());
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    public static void m5076a(SQLiteDatabase sQLiteDatabase, Map<String, C1393d> map, C1387a aVar) {
        int i = 0;
        Cursor cursor = null;
        try {
            C1393d dVar = map.get(C1370a.f3229u);
            if (dVar != null) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from " + "system where key=\"__ag_of\"", null);
                rawQuery.moveToFirst();
                long j = 0;
                while (!rawQuery.isAfterLast()) {
                    if (rawQuery.getCount() > 0) {
                        i = rawQuery.getInt(rawQuery.getColumnIndex("count"));
                        j = rawQuery.getLong(rawQuery.getColumnIndex(C1376d.C1383c.C1384a.f3268b));
                        sQLiteDatabase.execSQL("delete from " + "system where key=\"__ag_of\"");
                    }
                    rawQuery.moveToNext();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", dVar.mo8452c());
                contentValues.put("count", Long.valueOf(i == 0 ? dVar.mo8454e() : ((long) i) + dVar.mo8454e()));
                if (j == 0) {
                    j = dVar.mo8453d();
                }
                contentValues.put(C1376d.C1383c.C1384a.f3268b, Long.valueOf(j));
                sQLiteDatabase.insert(C1376d.C1383c.f3266a, null, contentValues);
                aVar.mo8391a("success", false);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (0 != 0) {
                cursor.close();
            }
        } catch (SQLException e) {
            C1346h.m5009e("save to system table error " + e.toString());
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

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m5073a(android.database.sqlite.SQLiteDatabase r6) {
        /*
        // Method dump skipped, instructions count: 123
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p086a.p087a.C1371a.m5073a(android.database.sqlite.SQLiteDatabase):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cb  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject m5083b(android.database.sqlite.SQLiteDatabase r10) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p086a.p087a.C1371a.m5083b(android.database.sqlite.SQLiteDatabase):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject m5074a(com.umeng.analytics.p086a.p088b.C1387a r11, android.database.sqlite.SQLiteDatabase r12) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p086a.p087a.C1371a.m5074a(com.umeng.analytics.a.b.a, android.database.sqlite.SQLiteDatabase):org.json.JSONObject");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.String> m5087c(android.database.sqlite.SQLiteDatabase r5) {
        /*
            r1 = 0
            java.lang.String r0 = "limitedck"
            int r0 = m5086c(r5, r0)     // Catch:{ SQLException -> 0x0061, all -> 0x0057 }
            if (r0 <= 0) goto L_0x0051
            java.lang.String r0 = "select * from limitedck"
            r2 = 0
            android.database.Cursor r2 = r5.rawQuery(r0, r2)     // Catch:{ SQLException -> 0x0061, all -> 0x0057 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLException -> 0x0029 }
            r0.<init>()     // Catch:{ SQLException -> 0x0029 }
        L_0x0015:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLException -> 0x0029 }
            if (r3 == 0) goto L_0x004b
            java.lang.String r3 = "ck"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ SQLException -> 0x0029 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ SQLException -> 0x0029 }
            r0.add(r3)     // Catch:{ SQLException -> 0x0029 }
            goto L_0x0015
        L_0x0029:
            r0 = move-exception
        L_0x002a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r3.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "loadLimitCKFromDB error "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005f }
            com.umeng.p085a.C1346h.m5009e(r0)     // Catch:{ all -> 0x005f }
            if (r2 == 0) goto L_0x0049
            r2.close()
        L_0x0049:
            r0 = r1
        L_0x004a:
            return r0
        L_0x004b:
            if (r2 == 0) goto L_0x004a
            r2.close()
            goto L_0x004a
        L_0x0051:
            if (r1 == 0) goto L_0x0049
            r1.close()
            goto L_0x0049
        L_0x0057:
            r0 = move-exception
            r2 = r1
        L_0x0059:
            if (r2 == 0) goto L_0x005e
            r2.close()
        L_0x005e:
            throw r0
        L_0x005f:
            r0 = move-exception
            goto L_0x0059
        L_0x0061:
            r0 = move-exception
            r2 = r1
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p086a.p087a.C1371a.m5087c(android.database.sqlite.SQLiteDatabase):java.util.List");
    }
}
