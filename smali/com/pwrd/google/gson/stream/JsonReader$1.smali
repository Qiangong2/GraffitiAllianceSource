.class Lcom/pwrd/google/gson/stream/JsonReader$1;
.super Lcom/pwrd/google/gson/internal/JsonReaderInternalAccess;
.source "JsonReader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/stream/JsonReader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 1601
    invoke-direct {p0}, Lcom/pwrd/google/gson/internal/JsonReaderInternalAccess;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public promoteNameToValue(Lcom/pwrd/google/gson/stream/JsonReader;)V
    .locals 4
    .param p1, "reader"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1603
    instance-of v1, p1, Lcom/pwrd/google/gson/internal/bind/JsonTreeReader;

    if-eqz v1, :cond_0

    .line 1604
    check-cast p1, Lcom/pwrd/google/gson/internal/bind/JsonTreeReader;

    .end local p1    # "reader":Lcom/pwrd/google/gson/stream/JsonReader;
    invoke-virtual {p1}, Lcom/pwrd/google/gson/internal/bind/JsonTreeReader;->promoteNameToValue()V

    .line 1622
    :goto_0
    return-void

    .line 1607
    .restart local p1    # "reader":Lcom/pwrd/google/gson/stream/JsonReader;
    :cond_0
    invoke-static {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->access$0(Lcom/pwrd/google/gson/stream/JsonReader;)I

    move-result v0

    .line 1608
    .local v0, "p":I
    if-nez v0, :cond_1

    .line 1609
    invoke-static {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->access$1(Lcom/pwrd/google/gson/stream/JsonReader;)I

    move-result v0

    .line 1611
    :cond_1
    const/16 v1, 0xd

    if-ne v0, v1, :cond_2

    .line 1612
    const/16 v1, 0x9

    invoke-static {p1, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->access$2(Lcom/pwrd/google/gson/stream/JsonReader;I)V

    goto :goto_0

    .line 1613
    :cond_2
    const/16 v1, 0xc

    if-ne v0, v1, :cond_3

    .line 1614
    const/16 v1, 0x8

    invoke-static {p1, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->access$2(Lcom/pwrd/google/gson/stream/JsonReader;I)V

    goto :goto_0

    .line 1615
    :cond_3
    const/16 v1, 0xe

    if-ne v0, v1, :cond_4

    .line 1616
    const/16 v1, 0xa

    invoke-static {p1, v1}, Lcom/pwrd/google/gson/stream/JsonReader;->access$2(Lcom/pwrd/google/gson/stream/JsonReader;I)V

    goto :goto_0

    .line 1618
    :cond_4
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Expected a name but was "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->peek()Lcom/pwrd/google/gson/stream/JsonToken;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 1619
    const-string v3, " at line "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->access$3(Lcom/pwrd/google/gson/stream/JsonReader;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " column "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->access$4(Lcom/pwrd/google/gson/stream/JsonReader;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 1620
    const-string v3, " path "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/pwrd/google/gson/stream/JsonReader;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1618
    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
