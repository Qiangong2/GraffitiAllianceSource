package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.j256.ormlite.stmt.query.In */
public class C1192In extends BaseComparison {

    /* renamed from: in */
    private final boolean f3087in;
    private Iterable<?> objects;

    @Override // com.j256.ormlite.stmt.query.Clause, com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public C1192In(String columnName, FieldType fieldType, Iterable<?> objects2, boolean in) throws SQLException {
        super(columnName, fieldType, null, true);
        this.objects = objects2;
        this.f3087in = in;
    }

    public C1192In(String columnName, FieldType fieldType, Object[] objects2, boolean in) throws SQLException {
        super(columnName, fieldType, null, true);
        this.objects = Arrays.asList(objects2);
        this.f3087in = in;
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public void appendOperation(StringBuilder sb) {
        if (this.f3087in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> columnArgList) throws SQLException {
        sb.append('(');
        boolean first = true;
        for (Object value : this.objects) {
            if (value == null) {
                throw new IllegalArgumentException("one of the IN values for '" + this.columnName + "' is null");
            }
            if (first) {
                first = false;
            } else {
                sb.append(',');
            }
            super.appendArgOrValue(databaseType, this.fieldType, sb, columnArgList, value);
        }
        sb.append(") ");
    }
}
