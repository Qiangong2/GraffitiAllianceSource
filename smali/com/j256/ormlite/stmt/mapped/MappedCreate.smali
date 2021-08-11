.class public Lcom/j256/ormlite/stmt/mapped/MappedCreate;
.super Lcom/j256/ormlite/stmt/mapped/BaseMappedStatement;
.source "MappedCreate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "ID:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/j256/ormlite/stmt/mapped/BaseMappedStatement",
        "<TT;TID;>;"
    }
.end annotation


# instance fields
.field private dataClassName:Ljava/lang/String;

.field private final queryNextSequenceStmt:Ljava/lang/String;

.field private versionFieldTypeIndex:I


# direct methods
.method private constructor <init>(Lcom/j256/ormlite/table/TableInfo;Ljava/lang/String;[Lcom/j256/ormlite/field/FieldType;Ljava/lang/String;I)V
    .locals 1
    .param p2, "statement"    # Ljava/lang/String;
    .param p3, "argFieldTypes"    # [Lcom/j256/ormlite/field/FieldType;
    .param p4, "queryNextSequenceStmt"    # Ljava/lang/String;
    .param p5, "versionFieldTypeIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/j256/ormlite/table/TableInfo",
            "<TT;TID;>;",
            "Ljava/lang/String;",
            "[",
            "Lcom/j256/ormlite/field/FieldType;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p0, "this":Lcom/j256/ormlite/stmt/mapped/MappedCreate;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate<TT;TID;>;"
    .local p1, "tableInfo":Lcom/j256/ormlite/table/TableInfo;, "Lcom/j256/ormlite/table/TableInfo<TT;TID;>;"
    invoke-direct {p0, p1, p2, p3}, Lcom/j256/ormlite/stmt/mapped/BaseMappedStatement;-><init>(Lcom/j256/ormlite/table/TableInfo;Ljava/lang/String;[Lcom/j256/ormlite/field/FieldType;)V

    .line 28
    invoke-virtual {p1}, Lcom/j256/ormlite/table/TableInfo;->getDataClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->dataClassName:Ljava/lang/String;

    .line 29
    iput-object p4, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->queryNextSequenceStmt:Ljava/lang/String;

    .line 30
    iput p5, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->versionFieldTypeIndex:I

    .line 31
    return-void
.end method

.method private assignIdValue(Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/String;Lcom/j256/ormlite/dao/ObjectCache;)V
    .locals 5
    .param p2, "val"    # Ljava/lang/Number;
    .param p3, "label"    # Ljava/lang/String;
    .param p4, "objectCache"    # Lcom/j256/ormlite/dao/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Ljava/lang/Number;",
            "Ljava/lang/String;",
            "Lcom/j256/ormlite/dao/ObjectCache;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/sql/SQLException;
        }
    .end annotation

    .prologue
    .line 230
    .local p0, "this":Lcom/j256/ormlite/stmt/mapped/MappedCreate;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate<TT;TID;>;"
    .local p1, "data":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    invoke-virtual {v0, p1, p2, p4}, Lcom/j256/ormlite/field/FieldType;->assignIdValue(Ljava/lang/Object;Ljava/lang/Number;Lcom/j256/ormlite/dao/ObjectCache;)Ljava/lang/Object;

    .line 231
    sget-object v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->logger:Lcom/j256/ormlite/logger/Logger;

    sget-object v1, Lcom/j256/ormlite/logger/Log$Level;->DEBUG:Lcom/j256/ormlite/logger/Log$Level;

    invoke-virtual {v0, v1}, Lcom/j256/ormlite/logger/Logger;->isLevelEnabled(Lcom/j256/ormlite/logger/Log$Level;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 232
    sget-object v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->logger:Lcom/j256/ormlite/logger/Logger;

    const-string v1, "assigned id \'{}\' from {} to \'{}\' in {} object"

    .line 233
    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    const/4 v3, 0x1

    aput-object p3, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    invoke-virtual {v4}, Lcom/j256/ormlite/field/FieldType;->getFieldName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    iget-object v4, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->dataClassName:Ljava/lang/String;

    aput-object v4, v2, v3

    .line 232
    invoke-virtual {v0, v1, v2}, Lcom/j256/ormlite/logger/Logger;->debug(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 235
    :cond_0
    return-void
.end method

.method private assignSequenceId(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/lang/Object;Lcom/j256/ormlite/dao/ObjectCache;)V
    .locals 6
    .param p1, "databaseConnection"    # Lcom/j256/ormlite/support/DatabaseConnection;
    .param p3, "objectCache"    # Lcom/j256/ormlite/dao/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/j256/ormlite/support/DatabaseConnection;",
            "TT;",
            "Lcom/j256/ormlite/dao/ObjectCache;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/sql/SQLException;
        }
    .end annotation

    .prologue
    .line 219
    .local p0, "this":Lcom/j256/ormlite/stmt/mapped/MappedCreate;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate<TT;TID;>;"
    .local p2, "data":Ljava/lang/Object;, "TT;"
    iget-object v2, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->queryNextSequenceStmt:Ljava/lang/String;

    invoke-interface {p1, v2}, Lcom/j256/ormlite/support/DatabaseConnection;->queryForLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 220
    .local v0, "seqVal":J
    sget-object v2, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->logger:Lcom/j256/ormlite/logger/Logger;

    const-string v3, "queried for sequence {} using stmt: {}"

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iget-object v5, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->queryNextSequenceStmt:Ljava/lang/String;

    invoke-virtual {v2, v3, v4, v5}, Lcom/j256/ormlite/logger/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 221
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    .line 223
    new-instance v2, Ljava/sql/SQLException;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Should not have returned 0 for stmt: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->queryNextSequenceStmt:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/sql/SQLException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 225
    :cond_0
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    const-string v3, "sequence"

    invoke-direct {p0, p2, v2, v3, p3}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->assignIdValue(Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/String;Lcom/j256/ormlite/dao/ObjectCache;)V

    .line 226
    return-void
.end method

.method public static build(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/table/TableInfo;)Lcom/j256/ormlite/stmt/mapped/MappedCreate;
    .locals 14
    .param p0, "databaseType"    # Lcom/j256/ormlite/db/DatabaseType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            "ID:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/j256/ormlite/db/DatabaseType;",
            "Lcom/j256/ormlite/table/TableInfo",
            "<TT;TID;>;)",
            "Lcom/j256/ormlite/stmt/mapped/MappedCreate",
            "<TT;TID;>;"
        }
    .end annotation

    .prologue
    .local p1, "tableInfo":Lcom/j256/ormlite/table/TableInfo;, "Lcom/j256/ormlite/table/TableInfo<TT;TID;>;"
    const/4 v0, 0x0

    .line 129
    new-instance v11, Ljava/lang/StringBuilder;

    const/16 v1, 0x80

    invoke-direct {v11, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 130
    .local v11, "sb":Ljava/lang/StringBuilder;
    const-string v1, "INSERT INTO "

    invoke-virtual {p1}, Lcom/j256/ormlite/table/TableInfo;->getTableName()Ljava/lang/String;

    move-result-object v2

    invoke-static {p0, v11, v1, v2}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->appendTableName(Lcom/j256/ormlite/db/DatabaseType;Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 131
    const/16 v1, 0x28

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 132
    const/4 v6, 0x0

    .line 133
    .local v6, "argFieldC":I
    const/4 v5, -0x1

    .line 135
    .local v5, "versionFieldTypeIndex":I
    invoke-virtual {p1}, Lcom/j256/ormlite/table/TableInfo;->getFieldTypes()[Lcom/j256/ormlite/field/FieldType;

    move-result-object v2

    array-length v12, v2

    move v1, v0

    :goto_0
    if-lt v1, v12, :cond_0

    .line 143
    new-array v3, v6, [Lcom/j256/ormlite/field/FieldType;

    .line 144
    .local v3, "argFieldTypes":[Lcom/j256/ormlite/field/FieldType;
    const/4 v6, 0x0

    .line 145
    const/4 v9, 0x1

    .line 146
    .local v9, "first":Z
    invoke-virtual {p1}, Lcom/j256/ormlite/table/TableInfo;->getFieldTypes()[Lcom/j256/ormlite/field/FieldType;

    move-result-object v2

    array-length v12, v2

    move v1, v0

    move v7, v6

    .end local v6    # "argFieldC":I
    .local v7, "argFieldC":I
    :goto_1
    if-lt v1, v12, :cond_3

    .line 158
    const-string v1, ") VALUES ("

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 159
    const/4 v9, 0x1

    .line 160
    invoke-virtual {p1}, Lcom/j256/ormlite/table/TableInfo;->getFieldTypes()[Lcom/j256/ormlite/field/FieldType;

    move-result-object v1

    array-length v2, v1

    :goto_2
    if-lt v0, v2, :cond_6

    .line 171
    const-string v0, ")"

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 172
    invoke-virtual {p1}, Lcom/j256/ormlite/table/TableInfo;->getIdField()Lcom/j256/ormlite/field/FieldType;

    move-result-object v10

    .line 173
    .local v10, "idField":Lcom/j256/ormlite/field/FieldType;
    invoke-static {p0, v10}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->buildQueryNextSequence(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/field/FieldType;)Ljava/lang/String;

    move-result-object v4

    .line 174
    .local v4, "queryNext":Ljava/lang/String;
    new-instance v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object v1, p1

    invoke-direct/range {v0 .. v5}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;-><init>(Lcom/j256/ormlite/table/TableInfo;Ljava/lang/String;[Lcom/j256/ormlite/field/FieldType;Ljava/lang/String;I)V

    return-object v0

    .line 135
    .end local v3    # "argFieldTypes":[Lcom/j256/ormlite/field/FieldType;
    .end local v4    # "queryNext":Ljava/lang/String;
    .end local v7    # "argFieldC":I
    .end local v9    # "first":Z
    .end local v10    # "idField":Lcom/j256/ormlite/field/FieldType;
    .restart local v6    # "argFieldC":I
    :cond_0
    aget-object v8, v2, v1

    .line 136
    .local v8, "fieldType":Lcom/j256/ormlite/field/FieldType;
    invoke-static {p0, v8}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->isFieldCreatable(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/field/FieldType;)Z

    move-result v13

    if-eqz v13, :cond_2

    .line 137
    invoke-virtual {v8}, Lcom/j256/ormlite/field/FieldType;->isVersion()Z

    move-result v13

    if-eqz v13, :cond_1

    .line 138
    move v5, v6

    .line 140
    :cond_1
    add-int/lit8 v6, v6, 0x1

    .line 135
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 146
    .end local v6    # "argFieldC":I
    .end local v8    # "fieldType":Lcom/j256/ormlite/field/FieldType;
    .restart local v3    # "argFieldTypes":[Lcom/j256/ormlite/field/FieldType;
    .restart local v7    # "argFieldC":I
    .restart local v9    # "first":Z
    :cond_3
    aget-object v8, v2, v1

    .line 147
    .restart local v8    # "fieldType":Lcom/j256/ormlite/field/FieldType;
    invoke-static {p0, v8}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->isFieldCreatable(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/field/FieldType;)Z

    move-result v13

    if-nez v13, :cond_4

    move v6, v7

    .line 146
    .end local v7    # "argFieldC":I
    .restart local v6    # "argFieldC":I
    :goto_3
    add-int/lit8 v1, v1, 0x1

    move v7, v6

    .end local v6    # "argFieldC":I
    .restart local v7    # "argFieldC":I
    goto :goto_1

    .line 150
    :cond_4
    if-eqz v9, :cond_5

    .line 151
    const/4 v9, 0x0

    .line 155
    :goto_4
    const/4 v13, 0x0

    invoke-static {p0, v11, v8, v13}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->appendFieldColumnName(Lcom/j256/ormlite/db/DatabaseType;Ljava/lang/StringBuilder;Lcom/j256/ormlite/field/FieldType;Ljava/util/List;)V

    .line 156
    add-int/lit8 v6, v7, 0x1

    .end local v7    # "argFieldC":I
    .restart local v6    # "argFieldC":I
    aput-object v8, v3, v7

    goto :goto_3

    .line 153
    .end local v6    # "argFieldC":I
    .restart local v7    # "argFieldC":I
    :cond_5
    const-string v13, ","

    invoke-virtual {v11, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 160
    .end local v8    # "fieldType":Lcom/j256/ormlite/field/FieldType;
    :cond_6
    aget-object v8, v1, v0

    .line 161
    .restart local v8    # "fieldType":Lcom/j256/ormlite/field/FieldType;
    invoke-static {p0, v8}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->isFieldCreatable(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/field/FieldType;)Z

    move-result v12

    if-nez v12, :cond_7

    .line 160
    :goto_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 164
    :cond_7
    if-eqz v9, :cond_8

    .line 165
    const/4 v9, 0x0

    .line 169
    :goto_6
    const-string v12, "?"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_5

    .line 167
    :cond_8
    const-string v12, ","

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_6
.end method

.method private static buildQueryNextSequence(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/field/FieldType;)Ljava/lang/String;
    .locals 3
    .param p0, "databaseType"    # Lcom/j256/ormlite/db/DatabaseType;
    .param p1, "idField"    # Lcom/j256/ormlite/field/FieldType;

    .prologue
    const/4 v2, 0x0

    .line 203
    if-nez p1, :cond_1

    .line 212
    :cond_0
    :goto_0
    return-object v2

    .line 206
    :cond_1
    invoke-virtual {p1}, Lcom/j256/ormlite/field/FieldType;->getGeneratedIdSequence()Ljava/lang/String;

    move-result-object v1

    .line 207
    .local v1, "seqName":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 210
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v2, 0x40

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 211
    .local v0, "sb":Ljava/lang/StringBuilder;
    invoke-interface {p0, v0, v1}, Lcom/j256/ormlite/db/DatabaseType;->appendSelectNextValFromSequence(Ljava/lang/StringBuilder;Ljava/lang/String;)V

    .line 212
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method private foreignCollectionsAreAssigned([Lcom/j256/ormlite/field/FieldType;Ljava/lang/Object;)Z
    .locals 5
    .param p1, "foreignCollections"    # [Lcom/j256/ormlite/field/FieldType;
    .param p2, "data"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/sql/SQLException;
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/j256/ormlite/stmt/mapped/MappedCreate;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate<TT;TID;>;"
    const/4 v1, 0x0

    .line 178
    array-length v3, p1

    move v2, v1

    :goto_0
    if-lt v2, v3, :cond_1

    .line 183
    const/4 v1, 0x1

    :cond_0
    return v1

    .line 178
    :cond_1
    aget-object v0, p1, v2

    .line 179
    .local v0, "fieldType":Lcom/j256/ormlite/field/FieldType;
    invoke-virtual {v0, p2}, Lcom/j256/ormlite/field/FieldType;->extractJavaFieldValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 178
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private static isFieldCreatable(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/field/FieldType;)Z
    .locals 3
    .param p0, "databaseType"    # Lcom/j256/ormlite/db/DatabaseType;
    .param p1, "fieldType"    # Lcom/j256/ormlite/field/FieldType;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 188
    invoke-virtual {p1}, Lcom/j256/ormlite/field/FieldType;->isForeignCollection()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 198
    :cond_0
    :goto_0
    return v0

    .line 191
    :cond_1
    invoke-interface {p0}, Lcom/j256/ormlite/db/DatabaseType;->isIdSequenceNeeded()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {p0}, Lcom/j256/ormlite/db/DatabaseType;->isSelectSequenceBeforeInsert()Z

    move-result v2

    if-eqz v2, :cond_2

    move v0, v1

    .line 193
    goto :goto_0

    .line 194
    :cond_2
    invoke-virtual {p1}, Lcom/j256/ormlite/field/FieldType;->isGeneratedId()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {p1}, Lcom/j256/ormlite/field/FieldType;->isSelfGeneratedId()Z

    move-result v2

    if-nez v2, :cond_3

    invoke-virtual {p1}, Lcom/j256/ormlite/field/FieldType;->isAllowGeneratedIdInsert()Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_3
    move v0, v1

    .line 198
    goto :goto_0
.end method


# virtual methods
.method public insert(Lcom/j256/ormlite/db/DatabaseType;Lcom/j256/ormlite/support/DatabaseConnection;Ljava/lang/Object;Lcom/j256/ormlite/dao/ObjectCache;)I
    .locals 20
    .param p1, "databaseType"    # Lcom/j256/ormlite/db/DatabaseType;
    .param p2, "databaseConnection"    # Lcom/j256/ormlite/support/DatabaseConnection;
    .param p4, "objectCache"    # Lcom/j256/ormlite/dao/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/j256/ormlite/db/DatabaseType;",
            "Lcom/j256/ormlite/support/DatabaseConnection;",
            "TT;",
            "Lcom/j256/ormlite/dao/ObjectCache;",
            ")I"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/sql/SQLException;
        }
    .end annotation

    .prologue
    .line 38
    .local p0, "this":Lcom/j256/ormlite/stmt/mapped/MappedCreate;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate<TT;TID;>;"
    .local p3, "data":Ljava/lang/Object;, "TT;"
    const/4 v11, 0x0

    .line 39
    .local v11, "keyHolder":Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;"
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    if-eqz v15, :cond_0

    .line 41
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    invoke-virtual {v15}, Lcom/j256/ormlite/field/FieldType;->isAllowGeneratedIdInsert()Z

    move-result v15

    if-eqz v15, :cond_5

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    move-object/from16 v0, p3

    invoke-virtual {v15, v0}, Lcom/j256/ormlite/field/FieldType;->isObjectsFieldValueDefault(Ljava/lang/Object;)Z

    move-result v15

    if-nez v15, :cond_5

    .line 42
    const/4 v5, 0x0

    .line 46
    .local v5, "assignId":Z
    :goto_0
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    invoke-virtual {v15}, Lcom/j256/ormlite/field/FieldType;->isSelfGeneratedId()Z

    move-result v15

    if-eqz v15, :cond_6

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    invoke-virtual {v15}, Lcom/j256/ormlite/field/FieldType;->isGeneratedId()Z

    move-result v15

    if-eqz v15, :cond_6

    .line 47
    if-eqz v5, :cond_0

    .line 48
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/j256/ormlite/field/FieldType;->generateId()Ljava/lang/Object;

    move-result-object v16

    const/16 v17, 0x0

    move-object/from16 v0, p3

    move-object/from16 v1, v16

    move/from16 v2, v17

    move-object/from16 v3, p4

    invoke-virtual {v15, v0, v1, v2, v3}, Lcom/j256/ormlite/field/FieldType;->assignField(Ljava/lang/Object;Ljava/lang/Object;ZLcom/j256/ormlite/dao/ObjectCache;)V

    .line 66
    .end local v5    # "assignId":Z
    :cond_0
    :goto_1
    :try_start_0
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->tableInfo:Lcom/j256/ormlite/table/TableInfo;

    invoke-virtual {v15}, Lcom/j256/ormlite/table/TableInfo;->isForeignAutoCreate()Z

    move-result v15

    if-eqz v15, :cond_1

    .line 67
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->tableInfo:Lcom/j256/ormlite/table/TableInfo;

    invoke-virtual {v15}, Lcom/j256/ormlite/table/TableInfo;->getFieldTypes()[Lcom/j256/ormlite/field/FieldType;

    move-result-object v16

    move-object/from16 v0, v16

    array-length v0, v0

    move/from16 v17, v0

    const/4 v15, 0x0

    :goto_2
    move/from16 v0, v17

    if-lt v15, v0, :cond_8

    .line 79
    :cond_1
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-virtual {v0, v1}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->getFieldObjects(Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    .line 80
    .local v4, "args":[Ljava/lang/Object;
    const/4 v13, 0x0

    .line 82
    .local v13, "versionDefaultValue":Ljava/lang/Object;
    move-object/from16 v0, p0

    iget v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->versionFieldTypeIndex:I

    if-ltz v15, :cond_2

    move-object/from16 v0, p0

    iget v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->versionFieldTypeIndex:I

    aget-object v15, v4, v15

    if-nez v15, :cond_2

    .line 84
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->argFieldTypes:[Lcom/j256/ormlite/field/FieldType;

    move-object/from16 v0, p0

    iget v0, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->versionFieldTypeIndex:I

    move/from16 v16, v0

    aget-object v14, v15, v16

    .line 85
    .local v14, "versionFieldType":Lcom/j256/ormlite/field/FieldType;
    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Lcom/j256/ormlite/field/FieldType;->moveToNextValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    .line 86
    move-object/from16 v0, p0

    iget v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->versionFieldTypeIndex:I

    invoke-virtual {v14, v13}, Lcom/j256/ormlite/field/FieldType;->convertJavaFieldToSqlArgValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    aput-object v16, v4, v15

    .line 89
    .end local v13    # "versionDefaultValue":Ljava/lang/Object;
    .end local v14    # "versionFieldType":Lcom/j256/ormlite/field/FieldType;
    :cond_2
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->statement:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->argFieldTypes:[Lcom/j256/ormlite/field/FieldType;

    move-object/from16 v16, v0

    move-object/from16 v0, p2

    move-object/from16 v1, v16

    invoke-interface {v0, v15, v4, v1, v11}, Lcom/j256/ormlite/support/DatabaseConnection;->insert(Ljava/lang/String;[Ljava/lang/Object;[Lcom/j256/ormlite/field/FieldType;Lcom/j256/ormlite/support/GeneratedKeyHolder;)I

    move-result v12

    .line 90
    .local v12, "rowC":I
    sget-object v15, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->logger:Lcom/j256/ormlite/logger/Logger;

    const-string v16, "insert data with statement \'{}\' and {} args, changed {} rows"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->statement:Ljava/lang/String;

    move-object/from16 v17, v0

    array-length v0, v4

    move/from16 v18, v0

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v19

    invoke-virtual/range {v15 .. v19}, Lcom/j256/ormlite/logger/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 91
    array-length v15, v4

    if-lez v15, :cond_3

    .line 93
    sget-object v15, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->logger:Lcom/j256/ormlite/logger/Logger;

    const-string v16, "insert arguments: {}"

    move-object/from16 v0, v16

    invoke-virtual {v15, v0, v4}, Lcom/j256/ormlite/logger/Logger;->trace(Ljava/lang/String;Ljava/lang/Object;)V

    .line 95
    :cond_3
    if-lez v12, :cond_e

    .line 96
    if-eqz v13, :cond_4

    .line 97
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->argFieldTypes:[Lcom/j256/ormlite/field/FieldType;

    move-object/from16 v0, p0

    iget v0, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->versionFieldTypeIndex:I

    move/from16 v16, v0

    aget-object v15, v15, v16

    const/16 v16, 0x0

    const/16 v17, 0x0

    move-object/from16 v0, p3

    move/from16 v1, v16

    move-object/from16 v2, v17

    invoke-virtual {v15, v0, v13, v1, v2}, Lcom/j256/ormlite/field/FieldType;->assignField(Ljava/lang/Object;Ljava/lang/Object;ZLcom/j256/ormlite/dao/ObjectCache;)V

    .line 99
    :cond_4
    if-eqz v11, :cond_d

    .line 101
    invoke-virtual {v11}, Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;->getKey()Ljava/lang/Number;

    move-result-object v10

    .line 102
    .local v10, "key":Ljava/lang/Number;
    if-nez v10, :cond_b

    .line 104
    new-instance v15, Ljava/sql/SQLException;

    const-string v16, "generated-id key was not set by the update call"

    invoke-direct/range {v15 .. v16}, Ljava/sql/SQLException;-><init>(Ljava/lang/String;)V

    throw v15
    :try_end_0
    .catch Ljava/sql/SQLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 123
    .end local v4    # "args":[Ljava/lang/Object;
    .end local v10    # "key":Ljava/lang/Number;
    .end local v12    # "rowC":I
    :catch_0
    move-exception v6

    .line 124
    .local v6, "e":Ljava/sql/SQLException;
    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "Unable to run insert stmt on object "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p3

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, ": "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->statement:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15, v6}, Lcom/j256/ormlite/misc/SqlExceptionUtil;->create(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/sql/SQLException;

    move-result-object v15

    throw v15

    .line 44
    .end local v6    # "e":Ljava/sql/SQLException;
    :cond_5
    const/4 v5, 0x1

    .restart local v5    # "assignId":Z
    goto/16 :goto_0

    .line 50
    :cond_6
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    invoke-virtual {v15}, Lcom/j256/ormlite/field/FieldType;->isGeneratedIdSequence()Z

    move-result v15

    if-eqz v15, :cond_7

    invoke-interface/range {p1 .. p1}, Lcom/j256/ormlite/db/DatabaseType;->isSelectSequenceBeforeInsert()Z

    move-result v15

    if-eqz v15, :cond_7

    .line 51
    if-eqz v5, :cond_0

    .line 52
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->assignSequenceId(Lcom/j256/ormlite/support/DatabaseConnection;Ljava/lang/Object;Lcom/j256/ormlite/dao/ObjectCache;)V

    goto/16 :goto_1

    .line 54
    :cond_7
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    invoke-virtual {v15}, Lcom/j256/ormlite/field/FieldType;->isGeneratedId()Z

    move-result v15

    if-eqz v15, :cond_0

    .line 55
    if-eqz v5, :cond_0

    .line 57
    new-instance v11, Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;

    .end local v11    # "keyHolder":Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;"
    const/4 v15, 0x0

    invoke-direct {v11, v15}, Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;-><init>(Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;)V

    .restart local v11    # "keyHolder":Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;, "Lcom/j256/ormlite/stmt/mapped/MappedCreate$KeyHolder;"
    goto/16 :goto_1

    .line 67
    .end local v5    # "assignId":Z
    :cond_8
    :try_start_1
    aget-object v7, v16, v15

    .line 68
    .local v7, "fieldType":Lcom/j256/ormlite/field/FieldType;
    invoke-virtual {v7}, Lcom/j256/ormlite/field/FieldType;->isForeignAutoCreate()Z

    move-result v18

    if-nez v18, :cond_a

    .line 67
    :cond_9
    :goto_3
    add-int/lit8 v15, v15, 0x1

    goto/16 :goto_2

    .line 72
    :cond_a
    move-object/from16 v0, p3

    invoke-virtual {v7, v0}, Lcom/j256/ormlite/field/FieldType;->extractRawJavaFieldValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .line 73
    .local v8, "foreignObj":Ljava/lang/Object;
    if-eqz v8, :cond_9

    invoke-virtual {v7}, Lcom/j256/ormlite/field/FieldType;->getForeignIdField()Lcom/j256/ormlite/field/FieldType;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Lcom/j256/ormlite/field/FieldType;->isObjectsFieldValueDefault(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_9

    .line 74
    invoke-virtual {v7, v8}, Lcom/j256/ormlite/field/FieldType;->createWithForeignDao(Ljava/lang/Object;)I

    goto :goto_3

    .line 106
    .end local v7    # "fieldType":Lcom/j256/ormlite/field/FieldType;
    .end local v8    # "foreignObj":Ljava/lang/Object;
    .restart local v4    # "args":[Ljava/lang/Object;
    .restart local v10    # "key":Ljava/lang/Number;
    .restart local v12    # "rowC":I
    :cond_b
    invoke-virtual {v10}, Ljava/lang/Number;->longValue()J

    move-result-wide v16

    const-wide/16 v18, 0x0

    cmp-long v15, v16, v18

    if-nez v15, :cond_c

    .line 108
    new-instance v15, Ljava/sql/SQLException;

    const-string v16, "generated-id key must not be 0 value"

    invoke-direct/range {v15 .. v16}, Ljava/sql/SQLException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 110
    :cond_c
    const-string v15, "keyholder"

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    invoke-direct {v0, v1, v10, v15, v2}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->assignIdValue(Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/String;Lcom/j256/ormlite/dao/ObjectCache;)V

    .line 116
    .end local v10    # "key":Ljava/lang/Number;
    :cond_d
    if-eqz p4, :cond_e

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->tableInfo:Lcom/j256/ormlite/table/TableInfo;

    invoke-virtual {v15}, Lcom/j256/ormlite/table/TableInfo;->getForeignCollections()[Lcom/j256/ormlite/field/FieldType;

    move-result-object v15

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v15, v1}, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->foreignCollectionsAreAssigned([Lcom/j256/ormlite/field/FieldType;Ljava/lang/Object;)Z

    move-result v15

    if-eqz v15, :cond_e

    .line 117
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->idField:Lcom/j256/ormlite/field/FieldType;

    move-object/from16 v0, p3

    invoke-virtual {v15, v0}, Lcom/j256/ormlite/field/FieldType;->extractJavaFieldValue(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    .line 118
    .local v9, "id":Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/j256/ormlite/stmt/mapped/MappedCreate;->clazz:Ljava/lang/Class;

    move-object/from16 v0, p4

    move-object/from16 v1, p3

    invoke-interface {v0, v15, v9, v1}, Lcom/j256/ormlite/dao/ObjectCache;->put(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/sql/SQLException; {:try_start_1 .. :try_end_1} :catch_0

    .line 122
    .end local v9    # "id":Ljava/lang/Object;
    :cond_e
    return v12
.end method
