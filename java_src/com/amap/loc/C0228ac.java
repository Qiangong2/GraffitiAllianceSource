package com.amap.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import com.amap.loc.C0233ah;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.loc.ac */
/* compiled from: DBOperation */
public class C0228ac {

    /* renamed from: d */
    private static Map<Class<? extends AbstractC0227ab>, AbstractC0227ab> f282d = new HashMap();

    /* renamed from: a */
    private C0233ah f283a;

    /* renamed from: b */
    private SQLiteDatabase f284b;

    /* renamed from: c */
    private AbstractC0227ab f285c;

    public C0228ac(Context context, AbstractC0227ab abVar) {
        try {
            this.f283a = new C0233ah(context.getApplicationContext(), abVar.mo3639a(), null, abVar.mo3642b(), abVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f285c = abVar;
    }

    public C0228ac(Context context, AbstractC0227ab abVar, String str) {
        try {
            this.f283a = new C0233ah((TextUtils.isEmpty(str) || !"mounted".equals(Environment.getExternalStorageState())) ? context : new C0233ah.C0234a(context.getApplicationContext(), str), abVar.mo3639a(), null, abVar.mo3642b(), abVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f285c = abVar;
    }

    /* renamed from: a */
    private ContentValues m463a(Object obj, AbstractC0229ad adVar) {
        ContentValues contentValues = new ContentValues();
        Field[] a = m472a(obj.getClass(), adVar.mo3652b());
        for (Field field : a) {
            field.setAccessible(true);
            m470a(obj, field, contentValues);
        }
        return contentValues;
    }

    /* renamed from: a */
    private SQLiteDatabase m464a(boolean z) {
        try {
            if (this.f284b == null) {
                this.f284b = this.f283a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                C0365t.m1372a(th, "DBOperation", "getReadAbleDataBase");
            } else {
                th.printStackTrace();
            }
        }
        return this.f284b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.Map<java.lang.Class<? extends com.amap.loc.ab>, com.amap.loc.ab> */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static synchronized AbstractC0227ab m465a(Class<? extends AbstractC0227ab> cls) throws IllegalAccessException, InstantiationException {
        AbstractC0227ab abVar;
        synchronized (C0228ac.class) {
            if (f282d.get(cls) == null) {
                f282d.put(cls, cls.newInstance());
            }
            abVar = f282d.get(cls);
        }
        return abVar;
    }

    /* renamed from: a */
    private <T> T m466a(Cursor cursor, Class<T> cls, AbstractC0229ad adVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a = m472a((Class<?>) cls, adVar.mo3652b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(AbstractC0230ae.class);
            if (annotation != null) {
                AbstractC0230ae aeVar = (AbstractC0230ae) annotation;
                int b = aeVar.mo3654b();
                int columnIndex = cursor.getColumnIndex(aeVar.mo3653a());
                switch (b) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    /* renamed from: a */
    private <T> String m467a(AbstractC0229ad adVar) {
        if (adVar == null) {
            return null;
        }
        return adVar.mo3651a();
    }

    /* renamed from: a */
    public static String m468a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            if (z) {
                sb.append(str).append(" = '").append(map.get(str)).append("'");
                z = false;
            } else {
                sb.append(" and ").append(str).append(" = '").append(map.get(str)).append("'");
                z = z;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private <T> void m469a(SQLiteDatabase sQLiteDatabase, T t) {
        ContentValues a;
        AbstractC0229ad b = m474b(t.getClass());
        String a2 = m467a(b);
        if (!TextUtils.isEmpty(a2) && t != null && sQLiteDatabase != null && (a = m463a((Object) t, b)) != null) {
            sQLiteDatabase.insert(a2, null, a);
        }
    }

    /* renamed from: a */
    private void m470a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(AbstractC0230ae.class);
        if (annotation != null) {
            AbstractC0230ae aeVar = (AbstractC0230ae) annotation;
            switch (aeVar.mo3654b()) {
                case 1:
                    try {
                        contentValues.put(aeVar.mo3653a(), Short.valueOf(field.getShort(obj)));
                        return;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    }
                case 2:
                    contentValues.put(aeVar.mo3653a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(aeVar.mo3653a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(aeVar.mo3653a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(aeVar.mo3653a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(aeVar.mo3653a(), (String) field.get(obj));
                    return;
                case 7:
                    contentValues.put(aeVar.mo3653a(), (byte[]) field.get(obj));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    private boolean m471a(Annotation annotation) {
        return annotation != null;
    }

    /* renamed from: a */
    private Field[] m472a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    /* renamed from: b */
    private SQLiteDatabase m473b(boolean z) {
        try {
            if (this.f284b == null || this.f284b.isReadOnly()) {
                if (this.f284b != null) {
                    this.f284b.close();
                }
                this.f284b = this.f283a.getWritableDatabase();
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "DBOperation", "getWriteDatabase");
        }
        return this.f284b;
    }

    /* renamed from: b */
    private <T> AbstractC0229ad m474b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(AbstractC0229ad.class);
        if (!m471a(annotation)) {
            return null;
        }
        return (AbstractC0229ad) annotation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e A[SYNTHETIC, Splitter:B:36:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075 A[Catch:{ Throwable -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084 A[SYNTHETIC, Splitter:B:47:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008b A[Catch:{ Throwable -> 0x00a2 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.util.List<T> mo3643a(java.lang.String r13, java.lang.Class<T> r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 266
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0228ac.mo3643a(java.lang.String, java.lang.Class, boolean):java.util.List");
    }

    /* renamed from: a */
    public <T> void mo3644a(T t) {
        mo3646a((Object) t, false);
    }

    /* renamed from: a */
    public void mo3645a(Object obj, String str) {
        synchronized (this.f285c) {
            List b = mo3650b(str, obj.getClass());
            if (b == null || b.size() == 0) {
                mo3644a(obj);
            } else {
                mo3648a(str, obj);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public <T> void mo3646a(T t, boolean z) {
        synchronized (this.f285c) {
            this.f284b = m473b(z);
            if (this.f284b != null) {
                try {
                    m469a(this.f284b, (Object) t);
                    if (this.f284b != null) {
                        this.f284b.close();
                        this.f284b = null;
                    }
                } catch (Throwable th) {
                    if (this.f284b != null) {
                        this.f284b.close();
                        this.f284b = null;
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public <T> void mo3647a(String str, Class<T> cls) {
        synchronized (this.f285c) {
            String a = m467a(m474b(cls));
            if (!TextUtils.isEmpty(a)) {
                this.f284b = m473b(false);
                if (this.f284b != null) {
                    try {
                        this.f284b.delete(a, str, null);
                        if (this.f284b != null) {
                            this.f284b.close();
                            this.f284b = null;
                        }
                    } catch (Throwable th) {
                        if (this.f284b != null) {
                            this.f284b.close();
                            this.f284b = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public <T> void mo3648a(String str, Object obj) {
        mo3649a(str, obj, false);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public <T> void mo3649a(String str, Object obj, boolean z) {
        synchronized (this.f285c) {
            if (obj != null) {
                AbstractC0229ad b = m474b(obj.getClass());
                String a = m467a(b);
                if (!TextUtils.isEmpty(a)) {
                    ContentValues a2 = m463a(obj, b);
                    if (a2 != null) {
                        this.f284b = m473b(z);
                        if (this.f284b != null) {
                            try {
                                this.f284b.update(a, a2, str, null);
                                if (this.f284b != null) {
                                    this.f284b.close();
                                    this.f284b = null;
                                }
                            } catch (Throwable th) {
                                if (this.f284b != null) {
                                    this.f284b.close();
                                    this.f284b = null;
                                }
                                throw th;
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public <T> List<T> mo3650b(String str, Class<T> cls) {
        return mo3643a(str, (Class) cls, false);
    }
}
