.class public final enum Lcom/j256/ormlite/field/DataType;
.super Ljava/lang/Enum;
.source "DataType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/j256/ormlite/field/DataType;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum BIG_DECIMAL:Lcom/j256/ormlite/field/DataType;

.field public static final enum BIG_DECIMAL_NUMERIC:Lcom/j256/ormlite/field/DataType;

.field public static final enum BIG_INTEGER:Lcom/j256/ormlite/field/DataType;

.field public static final enum BOOLEAN:Lcom/j256/ormlite/field/DataType;

.field public static final enum BOOLEAN_OBJ:Lcom/j256/ormlite/field/DataType;

.field public static final enum BYTE:Lcom/j256/ormlite/field/DataType;

.field public static final enum BYTE_ARRAY:Lcom/j256/ormlite/field/DataType;

.field public static final enum BYTE_OBJ:Lcom/j256/ormlite/field/DataType;

.field public static final enum CHAR:Lcom/j256/ormlite/field/DataType;

.field public static final enum CHAR_OBJ:Lcom/j256/ormlite/field/DataType;

.field public static final enum DATE:Lcom/j256/ormlite/field/DataType;

.field public static final enum DATE_LONG:Lcom/j256/ormlite/field/DataType;

.field public static final enum DATE_STRING:Lcom/j256/ormlite/field/DataType;

.field public static final enum DATE_TIME:Lcom/j256/ormlite/field/DataType;

.field public static final enum DOUBLE:Lcom/j256/ormlite/field/DataType;

.field public static final enum DOUBLE_OBJ:Lcom/j256/ormlite/field/DataType;

.field private static final synthetic ENUM$VALUES:[Lcom/j256/ormlite/field/DataType;

.field public static final enum ENUM_INTEGER:Lcom/j256/ormlite/field/DataType;

.field public static final enum ENUM_STRING:Lcom/j256/ormlite/field/DataType;

.field public static final enum FLOAT:Lcom/j256/ormlite/field/DataType;

.field public static final enum FLOAT_OBJ:Lcom/j256/ormlite/field/DataType;

.field public static final enum INTEGER:Lcom/j256/ormlite/field/DataType;

.field public static final enum INTEGER_OBJ:Lcom/j256/ormlite/field/DataType;

.field public static final enum LONG:Lcom/j256/ormlite/field/DataType;

.field public static final enum LONG_OBJ:Lcom/j256/ormlite/field/DataType;

.field public static final enum LONG_STRING:Lcom/j256/ormlite/field/DataType;

.field public static final enum SERIALIZABLE:Lcom/j256/ormlite/field/DataType;

.field public static final enum SHORT:Lcom/j256/ormlite/field/DataType;

.field public static final enum SHORT_OBJ:Lcom/j256/ormlite/field/DataType;

.field public static final enum SQL_DATE:Lcom/j256/ormlite/field/DataType;

.field public static final enum STRING:Lcom/j256/ormlite/field/DataType;

.field public static final enum STRING_BYTES:Lcom/j256/ormlite/field/DataType;

.field public static final enum TIME_STAMP:Lcom/j256/ormlite/field/DataType;

.field public static final enum UNKNOWN:Lcom/j256/ormlite/field/DataType;

.field public static final enum UUID:Lcom/j256/ormlite/field/DataType;


# instance fields
.field private final dataPersister:Lcom/j256/ormlite/field/DataPersister;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 47
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "STRING"

    .line 50
    invoke-static {}, Lcom/j256/ormlite/field/types/StringType;->getSingleton()Lcom/j256/ormlite/field/types/StringType;

    move-result-object v2

    invoke-direct {v0, v1, v4, v2}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->STRING:Lcom/j256/ormlite/field/DataType;

    .line 51
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "LONG_STRING"

    .line 54
    invoke-static {}, Lcom/j256/ormlite/field/types/LongStringType;->getSingleton()Lcom/j256/ormlite/field/types/LongStringType;

    move-result-object v2

    invoke-direct {v0, v1, v5, v2}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->LONG_STRING:Lcom/j256/ormlite/field/DataType;

    .line 55
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "STRING_BYTES"

    .line 59
    invoke-static {}, Lcom/j256/ormlite/field/types/StringBytesType;->getSingleton()Lcom/j256/ormlite/field/types/StringBytesType;

    move-result-object v2

    invoke-direct {v0, v1, v6, v2}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->STRING_BYTES:Lcom/j256/ormlite/field/DataType;

    .line 60
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BOOLEAN"

    .line 63
    invoke-static {}, Lcom/j256/ormlite/field/types/BooleanType;->getSingleton()Lcom/j256/ormlite/field/types/BooleanType;

    move-result-object v2

    invoke-direct {v0, v1, v7, v2}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BOOLEAN:Lcom/j256/ormlite/field/DataType;

    .line 64
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BOOLEAN_OBJ"

    .line 67
    invoke-static {}, Lcom/j256/ormlite/field/types/BooleanObjectType;->getSingleton()Lcom/j256/ormlite/field/types/BooleanObjectType;

    move-result-object v2

    invoke-direct {v0, v1, v8, v2}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BOOLEAN_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 68
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "DATE"

    const/4 v2, 0x5

    .line 75
    invoke-static {}, Lcom/j256/ormlite/field/types/DateType;->getSingleton()Lcom/j256/ormlite/field/types/DateType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->DATE:Lcom/j256/ormlite/field/DataType;

    .line 77
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "DATE_LONG"

    const/4 v2, 0x6

    .line 85
    invoke-static {}, Lcom/j256/ormlite/field/types/DateLongType;->getSingleton()Lcom/j256/ormlite/field/types/DateLongType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->DATE_LONG:Lcom/j256/ormlite/field/DataType;

    .line 86
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "DATE_STRING"

    const/4 v2, 0x7

    .line 99
    invoke-static {}, Lcom/j256/ormlite/field/types/DateStringType;->getSingleton()Lcom/j256/ormlite/field/types/DateStringType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->DATE_STRING:Lcom/j256/ormlite/field/DataType;

    .line 100
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "CHAR"

    const/16 v2, 0x8

    .line 103
    invoke-static {}, Lcom/j256/ormlite/field/types/CharType;->getSingleton()Lcom/j256/ormlite/field/types/CharType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->CHAR:Lcom/j256/ormlite/field/DataType;

    .line 104
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "CHAR_OBJ"

    const/16 v2, 0x9

    .line 107
    invoke-static {}, Lcom/j256/ormlite/field/types/CharacterObjectType;->getSingleton()Lcom/j256/ormlite/field/types/CharacterObjectType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->CHAR_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 108
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BYTE"

    const/16 v2, 0xa

    .line 111
    invoke-static {}, Lcom/j256/ormlite/field/types/ByteType;->getSingleton()Lcom/j256/ormlite/field/types/ByteType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BYTE:Lcom/j256/ormlite/field/DataType;

    .line 112
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BYTE_ARRAY"

    const/16 v2, 0xb

    .line 116
    invoke-static {}, Lcom/j256/ormlite/field/types/ByteArrayType;->getSingleton()Lcom/j256/ormlite/field/types/ByteArrayType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BYTE_ARRAY:Lcom/j256/ormlite/field/DataType;

    .line 117
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BYTE_OBJ"

    const/16 v2, 0xc

    .line 120
    invoke-static {}, Lcom/j256/ormlite/field/types/ByteObjectType;->getSingleton()Lcom/j256/ormlite/field/types/ByteObjectType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BYTE_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 121
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "SHORT"

    const/16 v2, 0xd

    .line 124
    invoke-static {}, Lcom/j256/ormlite/field/types/ShortType;->getSingleton()Lcom/j256/ormlite/field/types/ShortType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->SHORT:Lcom/j256/ormlite/field/DataType;

    .line 125
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "SHORT_OBJ"

    const/16 v2, 0xe

    .line 128
    invoke-static {}, Lcom/j256/ormlite/field/types/ShortObjectType;->getSingleton()Lcom/j256/ormlite/field/types/ShortObjectType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->SHORT_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 129
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "INTEGER"

    const/16 v2, 0xf

    .line 132
    invoke-static {}, Lcom/j256/ormlite/field/types/IntType;->getSingleton()Lcom/j256/ormlite/field/types/IntType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->INTEGER:Lcom/j256/ormlite/field/DataType;

    .line 133
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "INTEGER_OBJ"

    const/16 v2, 0x10

    .line 136
    invoke-static {}, Lcom/j256/ormlite/field/types/IntegerObjectType;->getSingleton()Lcom/j256/ormlite/field/types/IntegerObjectType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->INTEGER_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 137
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "LONG"

    const/16 v2, 0x11

    .line 140
    invoke-static {}, Lcom/j256/ormlite/field/types/LongType;->getSingleton()Lcom/j256/ormlite/field/types/LongType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->LONG:Lcom/j256/ormlite/field/DataType;

    .line 141
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "LONG_OBJ"

    const/16 v2, 0x12

    .line 144
    invoke-static {}, Lcom/j256/ormlite/field/types/LongObjectType;->getSingleton()Lcom/j256/ormlite/field/types/LongObjectType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->LONG_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 145
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "FLOAT"

    const/16 v2, 0x13

    .line 148
    invoke-static {}, Lcom/j256/ormlite/field/types/FloatType;->getSingleton()Lcom/j256/ormlite/field/types/FloatType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->FLOAT:Lcom/j256/ormlite/field/DataType;

    .line 149
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "FLOAT_OBJ"

    const/16 v2, 0x14

    .line 152
    invoke-static {}, Lcom/j256/ormlite/field/types/FloatObjectType;->getSingleton()Lcom/j256/ormlite/field/types/FloatObjectType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->FLOAT_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 153
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "DOUBLE"

    const/16 v2, 0x15

    .line 156
    invoke-static {}, Lcom/j256/ormlite/field/types/DoubleType;->getSingleton()Lcom/j256/ormlite/field/types/DoubleType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->DOUBLE:Lcom/j256/ormlite/field/DataType;

    .line 157
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "DOUBLE_OBJ"

    const/16 v2, 0x16

    .line 160
    invoke-static {}, Lcom/j256/ormlite/field/types/DoubleObjectType;->getSingleton()Lcom/j256/ormlite/field/types/DoubleObjectType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->DOUBLE_OBJ:Lcom/j256/ormlite/field/DataType;

    .line 161
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "SERIALIZABLE"

    const/16 v2, 0x17

    .line 166
    invoke-static {}, Lcom/j256/ormlite/field/types/SerializableType;->getSingleton()Lcom/j256/ormlite/field/types/SerializableType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->SERIALIZABLE:Lcom/j256/ormlite/field/DataType;

    .line 167
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "ENUM_STRING"

    const/16 v2, 0x18

    .line 170
    invoke-static {}, Lcom/j256/ormlite/field/types/EnumStringType;->getSingleton()Lcom/j256/ormlite/field/types/EnumStringType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->ENUM_STRING:Lcom/j256/ormlite/field/DataType;

    .line 171
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "ENUM_INTEGER"

    const/16 v2, 0x19

    .line 175
    invoke-static {}, Lcom/j256/ormlite/field/types/EnumIntegerType;->getSingleton()Lcom/j256/ormlite/field/types/EnumIntegerType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->ENUM_INTEGER:Lcom/j256/ormlite/field/DataType;

    .line 176
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "UUID"

    const/16 v2, 0x1a

    .line 179
    invoke-static {}, Lcom/j256/ormlite/field/types/UuidType;->getSingleton()Lcom/j256/ormlite/field/types/UuidType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->UUID:Lcom/j256/ormlite/field/DataType;

    .line 180
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BIG_INTEGER"

    const/16 v2, 0x1b

    .line 183
    invoke-static {}, Lcom/j256/ormlite/field/types/BigIntegerType;->getSingleton()Lcom/j256/ormlite/field/types/BigIntegerType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BIG_INTEGER:Lcom/j256/ormlite/field/DataType;

    .line 184
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BIG_DECIMAL"

    const/16 v2, 0x1c

    .line 187
    invoke-static {}, Lcom/j256/ormlite/field/types/BigDecimalStringType;->getSingleton()Lcom/j256/ormlite/field/types/BigDecimalStringType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BIG_DECIMAL:Lcom/j256/ormlite/field/DataType;

    .line 188
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "BIG_DECIMAL_NUMERIC"

    const/16 v2, 0x1d

    .line 191
    invoke-static {}, Lcom/j256/ormlite/field/types/BigDecimalNumericType;->getSingleton()Lcom/j256/ormlite/field/types/BigDecimalNumericType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->BIG_DECIMAL_NUMERIC:Lcom/j256/ormlite/field/DataType;

    .line 192
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "DATE_TIME"

    const/16 v2, 0x1e

    .line 197
    invoke-static {}, Lcom/j256/ormlite/field/types/DateTimeType;->getSingleton()Lcom/j256/ormlite/field/types/DateTimeType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->DATE_TIME:Lcom/j256/ormlite/field/DataType;

    .line 198
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "SQL_DATE"

    const/16 v2, 0x1f

    .line 205
    invoke-static {}, Lcom/j256/ormlite/field/types/SqlDateType;->getSingleton()Lcom/j256/ormlite/field/types/SqlDateType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->SQL_DATE:Lcom/j256/ormlite/field/DataType;

    .line 206
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "TIME_STAMP"

    const/16 v2, 0x20

    .line 209
    invoke-static {}, Lcom/j256/ormlite/field/types/TimeStampType;->getSingleton()Lcom/j256/ormlite/field/types/TimeStampType;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->TIME_STAMP:Lcom/j256/ormlite/field/DataType;

    .line 210
    new-instance v0, Lcom/j256/ormlite/field/DataType;

    const-string v1, "UNKNOWN"

    const/16 v2, 0x21

    .line 213
    const/4 v3, 0x0

    invoke-direct {v0, v1, v2, v3}, Lcom/j256/ormlite/field/DataType;-><init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V

    sput-object v0, Lcom/j256/ormlite/field/DataType;->UNKNOWN:Lcom/j256/ormlite/field/DataType;

    .line 45
    const/16 v0, 0x22

    new-array v0, v0, [Lcom/j256/ormlite/field/DataType;

    sget-object v1, Lcom/j256/ormlite/field/DataType;->STRING:Lcom/j256/ormlite/field/DataType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/j256/ormlite/field/DataType;->LONG_STRING:Lcom/j256/ormlite/field/DataType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/j256/ormlite/field/DataType;->STRING_BYTES:Lcom/j256/ormlite/field/DataType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/j256/ormlite/field/DataType;->BOOLEAN:Lcom/j256/ormlite/field/DataType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/j256/ormlite/field/DataType;->BOOLEAN_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/j256/ormlite/field/DataType;->DATE:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/j256/ormlite/field/DataType;->DATE_LONG:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/j256/ormlite/field/DataType;->DATE_STRING:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/j256/ormlite/field/DataType;->CHAR:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/j256/ormlite/field/DataType;->CHAR_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/j256/ormlite/field/DataType;->BYTE:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/j256/ormlite/field/DataType;->BYTE_ARRAY:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/j256/ormlite/field/DataType;->BYTE_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/j256/ormlite/field/DataType;->SHORT:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/j256/ormlite/field/DataType;->SHORT_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/j256/ormlite/field/DataType;->INTEGER:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/j256/ormlite/field/DataType;->INTEGER_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/j256/ormlite/field/DataType;->LONG:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/j256/ormlite/field/DataType;->LONG_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/j256/ormlite/field/DataType;->FLOAT:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/j256/ormlite/field/DataType;->FLOAT_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/j256/ormlite/field/DataType;->DOUBLE:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/j256/ormlite/field/DataType;->DOUBLE_OBJ:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/j256/ormlite/field/DataType;->SERIALIZABLE:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/j256/ormlite/field/DataType;->ENUM_STRING:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/j256/ormlite/field/DataType;->ENUM_INTEGER:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/j256/ormlite/field/DataType;->UUID:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/j256/ormlite/field/DataType;->BIG_INTEGER:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/j256/ormlite/field/DataType;->BIG_DECIMAL:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/j256/ormlite/field/DataType;->BIG_DECIMAL_NUMERIC:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/j256/ormlite/field/DataType;->DATE_TIME:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/j256/ormlite/field/DataType;->SQL_DATE:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/j256/ormlite/field/DataType;->TIME_STAMP:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/j256/ormlite/field/DataType;->UNKNOWN:Lcom/j256/ormlite/field/DataType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/j256/ormlite/field/DataType;->ENUM$VALUES:[Lcom/j256/ormlite/field/DataType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILcom/j256/ormlite/field/DataPersister;)V
    .locals 0
    .param p3, "dataPersister"    # Lcom/j256/ormlite/field/DataPersister;

    .prologue
    .line 219
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 220
    iput-object p3, p0, Lcom/j256/ormlite/field/DataType;->dataPersister:Lcom/j256/ormlite/field/DataPersister;

    .line 221
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/j256/ormlite/field/DataType;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/j256/ormlite/field/DataType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/j256/ormlite/field/DataType;

    return-object v0
.end method

.method public static values()[Lcom/j256/ormlite/field/DataType;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/j256/ormlite/field/DataType;->ENUM$VALUES:[Lcom/j256/ormlite/field/DataType;

    array-length v1, v0

    new-array v2, v1, [Lcom/j256/ormlite/field/DataType;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method


# virtual methods
.method public getDataPersister()Lcom/j256/ormlite/field/DataPersister;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/j256/ormlite/field/DataType;->dataPersister:Lcom/j256/ormlite/field/DataPersister;

    return-object v0
.end method
