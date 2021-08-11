package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class SetExpression extends BaseComparison {
    @Override // com.j256.ormlite.stmt.query.Clause, com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ void appendValue(DatabaseType databaseType, StringBuilder sb, List list) throws SQLException {
        super.appendValue(databaseType, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public SetExpression(String columnName, FieldType fieldType, String string) throws SQLException {
        super(columnName, fieldType, string, true);
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public void appendOperation(StringBuilder sb) {
        sb.append("= ");
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public void appendArgOrValue(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, List<ArgumentHolder> list, Object argOrValue) {
        sb.append(argOrValue).append(' ');
    }
}
