.class public Lcom/j256/ormlite/field/types/ByteType;
.super Lcom/j256/ormlite/field/types/ByteObjectType;
.source "ByteType.java"


# static fields
.field private static final singleTon:Lcom/j256/ormlite/field/types/ByteType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    new-instance v0, Lcom/j256/ormlite/field/types/ByteType;

    invoke-direct {v0}, Lcom/j256/ormlite/field/types/ByteType;-><init>()V

    sput-object v0, Lcom/j256/ormlite/field/types/ByteType;->singleTon:Lcom/j256/ormlite/field/types/ByteType;

    return-void
.end method

.method private constructor <init>()V
    .locals 4

    .prologue
    .line 19
    sget-object v0, Lcom/j256/ormlite/field/SqlType;->BYTE:Lcom/j256/ormlite/field/SqlType;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Class;

    const/4 v2, 0x0

    sget-object v3, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    aput-object v3, v1, v2

    invoke-direct {p0, v0, v1}, Lcom/j256/ormlite/field/types/ByteObjectType;-><init>(Lcom/j256/ormlite/field/SqlType;[Ljava/lang/Class;)V

    .line 20
    return-void
.end method

.method protected constructor <init>(Lcom/j256/ormlite/field/SqlType;[Ljava/lang/Class;)V
    .locals 0
    .param p1, "sqlType"    # Lcom/j256/ormlite/field/SqlType;
    .param p2, "classes"    # [Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/j256/ormlite/field/SqlType;",
            "[",
            "Ljava/lang/Class",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Lcom/j256/ormlite/field/types/ByteObjectType;-><init>(Lcom/j256/ormlite/field/SqlType;[Ljava/lang/Class;)V

    .line 27
    return-void
.end method

.method public static bridge synthetic getSingleton()Lcom/j256/ormlite/field/types/ByteObjectType;
    .locals 1

    .prologue
    .line 1
    invoke-static {}, Lcom/j256/ormlite/field/types/ByteType;->getSingleton()Lcom/j256/ormlite/field/types/ByteType;

    move-result-object v0

    return-object v0
.end method

.method public static getSingleton()Lcom/j256/ormlite/field/types/ByteType;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/j256/ormlite/field/types/ByteType;->singleTon:Lcom/j256/ormlite/field/types/ByteType;

    return-object v0
.end method


# virtual methods
.method public isPrimitive()Z
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x1

    return v0
.end method
