package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.C1192In;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Where<T, ID> {
    private static final int START_CLAUSE_SIZE = 4;
    private Clause[] clauseStack = new Clause[4];
    private int clauseStackLevel = 0;
    private final DatabaseType databaseType;
    private final String idColumnName;
    private final FieldType idFieldType;
    private NeedsFutureClause needsFuture = null;
    private final StatementBuilder<T, ID> statementBuilder;
    private final TableInfo<T, ID> tableInfo;

    Where(TableInfo<T, ID> tableInfo2, StatementBuilder<T, ID> statementBuilder2, DatabaseType databaseType2) {
        this.tableInfo = tableInfo2;
        this.statementBuilder = statementBuilder2;
        this.idFieldType = tableInfo2.getIdField();
        if (this.idFieldType == null) {
            this.idColumnName = null;
        } else {
            this.idColumnName = this.idFieldType.getColumnName();
        }
        this.databaseType = databaseType2;
    }

    public Where<T, ID> and() {
        addNeedsFuture(new ManyClause(pop(ManyClause.AND_OPERATION), ManyClause.AND_OPERATION));
        return this;
    }

    public Where<T, ID> and(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] clauses = buildClauseArray(whereArr, ManyClause.AND_OPERATION);
        addClause(new ManyClause(pop(ManyClause.AND_OPERATION), pop(ManyClause.AND_OPERATION), clauses, ManyClause.AND_OPERATION));
        return this;
    }

    public Where<T, ID> and(int numClauses) {
        if (numClauses == 0) {
            throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
        }
        Clause[] clauses = new Clause[numClauses];
        for (int i = numClauses - 1; i >= 0; i--) {
            clauses[i] = pop(ManyClause.AND_OPERATION);
        }
        addClause(new ManyClause(clauses, ManyClause.AND_OPERATION));
        return this;
    }

    public Where<T, ID> between(String columnName, Object low, Object high) throws SQLException {
        addClause(new Between(columnName, findColumnFieldType(columnName), low, high));
        return this;
    }

    /* renamed from: eq */
    public Where<T, ID> mo6812eq(String columnName, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, SimpleComparison.EQUAL_TO_OPERATION));
        return this;
    }

    /* renamed from: ge */
    public Where<T, ID> mo6814ge(String columnName, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    /* renamed from: gt */
    public Where<T, ID> mo6816gt(String columnName, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, SimpleComparison.GREATER_THAN_OPERATION));
        return this;
    }

    /* renamed from: in */
    public Where<T, ID> mo6820in(String columnName, Iterable<?> objects) throws SQLException {
        addClause(new C1192In(columnName, findColumnFieldType(columnName), objects, true));
        return this;
    }

    public Where<T, ID> notIn(String columnName, Iterable<?> objects) throws SQLException {
        addClause(new C1192In(columnName, findColumnFieldType(columnName), objects, false));
        return this;
    }

    /* renamed from: in */
    public Where<T, ID> mo6821in(String columnName, Object... objects) throws SQLException {
        return m4834in(true, columnName, objects);
    }

    public Where<T, ID> notIn(String columnName, Object... objects) throws SQLException {
        return m4834in(false, columnName, objects);
    }

    /* renamed from: in */
    public Where<T, ID> mo6819in(String columnName, QueryBuilder<?, ?> subQueryBuilder) throws SQLException {
        return m4833in(true, columnName, subQueryBuilder);
    }

    public Where<T, ID> notIn(String columnName, QueryBuilder<?, ?> subQueryBuilder) throws SQLException {
        return m4833in(false, columnName, subQueryBuilder);
    }

    public Where<T, ID> exists(QueryBuilder<?, ?> subQueryBuilder) {
        subQueryBuilder.enableInnerQuery();
        addClause(new Exists(new QueryBuilder.InternalQueryBuilderWrapper(subQueryBuilder)));
        return this;
    }

    public Where<T, ID> isNull(String columnName) throws SQLException {
        addClause(new IsNull(columnName, findColumnFieldType(columnName)));
        return this;
    }

    public Where<T, ID> isNotNull(String columnName) throws SQLException {
        addClause(new IsNotNull(columnName, findColumnFieldType(columnName)));
        return this;
    }

    /* renamed from: le */
    public Where<T, ID> mo6825le(String columnName, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    /* renamed from: lt */
    public Where<T, ID> mo6827lt(String columnName, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, SimpleComparison.LESS_THAN_OPERATION));
        return this;
    }

    public Where<T, ID> like(String columnName, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, SimpleComparison.LIKE_OPERATION));
        return this;
    }

    /* renamed from: ne */
    public Where<T, ID> mo6828ne(String columnName, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, SimpleComparison.NOT_EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> not() {
        addNeedsFuture(new Not());
        return this;
    }

    public Where<T, ID> not(Where<T, ID> where) {
        addClause(new Not(pop("NOT")));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> mo6834or() {
        addNeedsFuture(new ManyClause(pop(ManyClause.OR_OPERATION), ManyClause.OR_OPERATION));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> mo6836or(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] clauses = buildClauseArray(whereArr, ManyClause.OR_OPERATION);
        addClause(new ManyClause(pop(ManyClause.OR_OPERATION), pop(ManyClause.OR_OPERATION), clauses, ManyClause.OR_OPERATION));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> mo6835or(int numClauses) {
        if (numClauses == 0) {
            throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
        }
        Clause[] clauses = new Clause[numClauses];
        for (int i = numClauses - 1; i >= 0; i--) {
            clauses[i] = pop(ManyClause.OR_OPERATION);
        }
        addClause(new ManyClause(clauses, ManyClause.OR_OPERATION));
        return this;
    }

    public Where<T, ID> idEq(ID id) throws SQLException {
        if (this.idColumnName == null) {
            throw new SQLException("Object has no id column specified");
        }
        addClause(new SimpleComparison(this.idColumnName, this.idFieldType, id, SimpleComparison.EQUAL_TO_OPERATION));
        return this;
    }

    public <OD> Where<T, ID> idEq(Dao<OD, ?> dataDao, OD data) throws SQLException {
        if (this.idColumnName == null) {
            throw new SQLException("Object has no id column specified");
        }
        addClause(new SimpleComparison(this.idColumnName, this.idFieldType, dataDao.extractId(data), SimpleComparison.EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> raw(String rawStatement, ArgumentHolder... args) {
        for (ArgumentHolder arg : args) {
            String columnName = arg.getColumnName();
            if (columnName != null) {
                arg.setMetaInfo(findColumnFieldType(columnName));
            } else if (arg.getSqlType() == null) {
                throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument");
            }
        }
        addClause(new Raw(rawStatement, args));
        return this;
    }

    public Where<T, ID> rawComparison(String columnName, String rawOperator, Object value) throws SQLException {
        addClause(new SimpleComparison(columnName, findColumnFieldType(columnName), value, rawOperator));
        return this;
    }

    public PreparedQuery<T> prepare() throws SQLException {
        return this.statementBuilder.prepareStatement(null);
    }

    public List<T> query() throws SQLException {
        return checkQueryBuilderMethod("query()").query();
    }

    public GenericRawResults<String[]> queryRaw() throws SQLException {
        return checkQueryBuilderMethod("queryRaw()").queryRaw();
    }

    public T queryForFirst() throws SQLException {
        return checkQueryBuilderMethod("queryForFirst()").queryForFirst();
    }

    public String[] queryRawFirst() throws SQLException {
        return checkQueryBuilderMethod("queryRawFirst()").queryRawFirst();
    }

    public long countOf() throws SQLException {
        return checkQueryBuilderMethod("countOf()").countOf();
    }

    public CloseableIterator<T> iterator() throws SQLException {
        return checkQueryBuilderMethod("iterator()").iterator();
    }

    public Where<T, ID> clear() {
        for (int i = 0; i < this.clauseStackLevel; i++) {
            this.clauseStack[i] = null;
        }
        this.clauseStackLevel = 0;
        return this;
    }

    public String getStatement() throws SQLException {
        StringBuilder sb = new StringBuilder();
        appendSql(null, sb, new ArrayList());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void appendSql(String tableName, StringBuilder sb, List<ArgumentHolder> columnArgList) throws SQLException {
        if (this.clauseStackLevel == 0) {
            throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
        } else if (this.clauseStackLevel != 1) {
            throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
        } else {
            peek().appendSql(this.databaseType, tableName, sb, columnArgList);
        }
    }

    public String toString() {
        if (this.clauseStackLevel == 0) {
            return "empty where clause";
        }
        return "where clause: " + peek();
    }

    private QueryBuilder<T, ID> checkQueryBuilderMethod(String methodName) throws SQLException {
        if (this.statementBuilder instanceof QueryBuilder) {
            return (QueryBuilder) this.statementBuilder;
        }
        throw new SQLException("Cannot call " + methodName + " on a statement of type " + this.statementBuilder.getType());
    }

    /* renamed from: in */
    private Where<T, ID> m4834in(boolean in, String columnName, Object... objects) throws SQLException {
        if (objects.length == 1) {
            if (objects[0].getClass().isArray()) {
                throw new IllegalArgumentException("Object argument to " + (in ? "IN" : "notId") + " seems to be an array within an array");
            } else if (objects[0] instanceof Where) {
                throw new IllegalArgumentException("Object argument to " + (in ? "IN" : "notId") + " seems to be a Where object, did you mean the QueryBuilder?");
            } else if (objects[0] instanceof PreparedStmt) {
                throw new IllegalArgumentException("Object argument to " + (in ? "IN" : "notId") + " seems to be a prepared statement, did you mean the QueryBuilder?");
            }
        }
        addClause(new C1192In(columnName, findColumnFieldType(columnName), objects, in));
        return this;
    }

    /* renamed from: in */
    private Where<T, ID> m4833in(boolean in, String columnName, QueryBuilder<?, ?> subQueryBuilder) throws SQLException {
        if (subQueryBuilder.getSelectColumnCount() != 1) {
            throw new SQLException("Inner query must have only 1 select column specified instead of " + subQueryBuilder.getSelectColumnCount() + ": " + Arrays.toString(subQueryBuilder.getSelectColumns().toArray(new String[0])));
        }
        subQueryBuilder.enableInnerQuery();
        addClause(new InSubQuery(columnName, findColumnFieldType(columnName), new QueryBuilder.InternalQueryBuilderWrapper(subQueryBuilder), in));
        return this;
    }

    private Clause[] buildClauseArray(Where<T, ID>[] whereArr, String label) {
        if (whereArr.length == 0) {
            return null;
        }
        Clause[] clauses = new Clause[whereArr.length];
        for (int i = whereArr.length - 1; i >= 0; i--) {
            clauses[i] = pop(label);
        }
        return clauses;
    }

    private void addNeedsFuture(NeedsFutureClause clause) {
        if (this.needsFuture != null) {
            throw new IllegalStateException(this.needsFuture + " is already waiting for a future clause, can't add: " + clause);
        }
        this.needsFuture = clause;
        push(clause);
    }

    private void addClause(Clause clause) {
        if (this.needsFuture == null) {
            push(clause);
            return;
        }
        this.needsFuture.setMissingClause(clause);
        this.needsFuture = null;
    }

    private FieldType findColumnFieldType(String columnName) {
        return this.tableInfo.getFieldTypeByColumnName(columnName);
    }

    private void push(Clause clause) {
        if (this.clauseStackLevel == this.clauseStack.length) {
            Clause[] newStack = new Clause[(this.clauseStackLevel * 2)];
            for (int i = 0; i < this.clauseStackLevel; i++) {
                newStack[i] = this.clauseStack[i];
                this.clauseStack[i] = null;
            }
            this.clauseStack = newStack;
        }
        Clause[] clauseArr = this.clauseStack;
        int i2 = this.clauseStackLevel;
        this.clauseStackLevel = i2 + 1;
        clauseArr[i2] = clause;
    }

    private Clause pop(String label) {
        if (this.clauseStackLevel == 0) {
            throw new IllegalStateException("Expecting there to be a clause already defined for '" + label + "' operation");
        }
        Clause[] clauseArr = this.clauseStack;
        int i = this.clauseStackLevel - 1;
        this.clauseStackLevel = i;
        Clause clause = clauseArr[i];
        this.clauseStack[this.clauseStackLevel] = null;
        return clause;
    }

    private Clause peek() {
        return this.clauseStack[this.clauseStackLevel - 1];
    }
}
