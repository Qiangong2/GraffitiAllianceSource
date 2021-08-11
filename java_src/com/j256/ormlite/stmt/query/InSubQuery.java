package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

public class InSubQuery extends BaseComparison {

    /* renamed from: in */
    private final boolean f3088in;
    private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;

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

    public InSubQuery(String columnName, FieldType fieldType, QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder2, boolean in) throws SQLException {
        super(columnName, fieldType, null, true);
        this.subQueryBuilder = subQueryBuilder2;
        this.f3088in = in;
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public void appendOperation(StringBuilder sb) {
        if (this.f3088in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    @Override // com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.BaseComparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> argList) throws SQLException {
        sb.append('(');
        this.subQueryBuilder.appendStatementString(sb, argList);
        FieldType[] resultFieldTypes = this.subQueryBuilder.getResultFieldTypes();
        if (resultFieldTypes.length != 1) {
            throw new SQLException("There must be only 1 result column in sub-query but we found " + resultFieldTypes.length);
        } else if (this.fieldType.getSqlType() != resultFieldTypes[0].getSqlType()) {
            throw new SQLException("Outer column " + this.fieldType + " is not the same type as inner column " + resultFieldTypes[0]);
        } else {
            sb.append(") ");
        }
    }
}
