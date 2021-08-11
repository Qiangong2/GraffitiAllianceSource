package com.j256.ormlite.stmt.query;

import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

/* access modifiers changed from: package-private */
public interface Comparison extends Clause {
    void appendOperation(StringBuilder sb);

    void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException;

    String getColumnName();
}
