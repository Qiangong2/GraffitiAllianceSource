.class public final Lcom/pwrd/google/gson/JsonNull;
.super Lcom/pwrd/google/gson/JsonElement;
.source "JsonNull.java"


# static fields
.field public static final INSTANCE:Lcom/pwrd/google/gson/JsonNull;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    new-instance v0, Lcom/pwrd/google/gson/JsonNull;

    invoke-direct {v0}, Lcom/pwrd/google/gson/JsonNull;-><init>()V

    sput-object v0, Lcom/pwrd/google/gson/JsonNull;->INSTANCE:Lcom/pwrd/google/gson/JsonNull;

    return-void
.end method

.method public constructor <init>()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/pwrd/google/gson/JsonElement;-><init>()V

    .line 41
    return-void
.end method


# virtual methods
.method bridge synthetic deepCopy()Lcom/pwrd/google/gson/JsonElement;
    .locals 1

    .prologue
    .line 1
    invoke-virtual {p0}, Lcom/pwrd/google/gson/JsonNull;->deepCopy()Lcom/pwrd/google/gson/JsonNull;

    move-result-object v0

    return-object v0
.end method

.method deepCopy()Lcom/pwrd/google/gson/JsonNull;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Lcom/pwrd/google/gson/JsonNull;->INSTANCE:Lcom/pwrd/google/gson/JsonNull;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "other"    # Ljava/lang/Object;

    .prologue
    .line 61
    if-eq p0, p1, :cond_0

    instance-of v0, p1, Lcom/pwrd/google/gson/JsonNull;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 53
    const-class v0, Lcom/pwrd/google/gson/JsonNull;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method