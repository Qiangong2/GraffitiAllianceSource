package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;

public class SerializableType extends BaseDataType {
    private static final SerializableType singleTon = new SerializableType();

    public static SerializableType getSingleton() {
        return singleTon;
    }

    private SerializableType() {
        super(SqlType.SERIALIZABLE, new Class[0]);
    }

    protected SerializableType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String defaultStr) throws SQLException {
        throw new SQLException("Default values for serializable types are not supported");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
        return results.getBytes(columnPos);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0045 A[SYNTHETIC, Splitter:B:15:0x0045] */
    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sqlArgToJava(com.j256.ormlite.field.FieldType r7, java.lang.Object r8, int r9) throws java.sql.SQLException {
        /*
            r6 = this;
            r0 = r8
            byte[] r0 = (byte[]) r0
            r2 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x0018 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0018 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0018 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0018 }
            java.lang.Object r4 = r3.readObject()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            if (r3 == 0) goto L_0x0017
            r3.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0017:
            return r4
        L_0x0018:
            r1 = move-exception
        L_0x0019:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = "Could not read serialized object from byte array: "
            r4.<init>(r5)     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = java.util.Arrays.toString(r0)     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = "(len "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0042 }
            int r5 = r0.length     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0042 }
            java.lang.String r5 = ")"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0042 }
            java.sql.SQLException r4 = com.j256.ormlite.misc.SqlExceptionUtil.create(r4, r1)     // Catch:{ all -> 0x0042 }
            throw r4     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r4 = move-exception
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ IOException -> 0x004b }
        L_0x0048:
            throw r4
        L_0x0049:
            r5 = move-exception
            goto L_0x0017
        L_0x004b:
            r5 = move-exception
            goto L_0x0048
        L_0x004d:
            r4 = move-exception
            r2 = r3
            goto L_0x0043
        L_0x0050:
            r1 = move-exception
            r2 = r3
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.types.SerializableType.sqlArgToJava(com.j256.ormlite.field.FieldType, java.lang.Object, int):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034 A[SYNTHETIC, Splitter:B:16:0x0034] */
    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object javaToSqlArg(com.j256.ormlite.field.FieldType r7, java.lang.Object r8) throws java.sql.SQLException {
        /*
            r6 = this;
            r1 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x001c }
            r3.<init>()     // Catch:{ Exception -> 0x001c }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x001c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x001c }
            r2.writeObject(r8)     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r2.close()     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r1 = 0
            byte[] r4 = r3.toByteArray()
            if (r1 == 0) goto L_0x001b
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x001b:
            return r4
        L_0x001c:
            r0 = move-exception
        L_0x001d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = "Could not write serialized object to byte array: "
            r4.<init>(r5)     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0031 }
            java.sql.SQLException r4 = com.j256.ormlite.misc.SqlExceptionUtil.create(r4, r0)     // Catch:{ all -> 0x0031 }
            throw r4     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r4 = move-exception
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r1.close()     // Catch:{ IOException -> 0x003a }
        L_0x0037:
            throw r4
        L_0x0038:
            r5 = move-exception
            goto L_0x001b
        L_0x003a:
            r5 = move-exception
            goto L_0x0037
        L_0x003c:
            r4 = move-exception
            r1 = r2
            goto L_0x0032
        L_0x003f:
            r0 = move-exception
            r1 = r2
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.types.SerializableType.javaToSqlArg(com.j256.ormlite.field.FieldType, java.lang.Object):java.lang.Object");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String stringValue, int columnPos) throws SQLException {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Serializable.class;
    }
}
