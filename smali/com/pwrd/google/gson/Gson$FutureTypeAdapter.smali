.class Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;
.super Lcom/pwrd/google/gson/TypeAdapter;
.source "Gson.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/Gson;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "FutureTypeAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/pwrd/google/gson/TypeAdapter",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private delegate:Lcom/pwrd/google/gson/TypeAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 882
    .local p0, "this":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    invoke-direct {p0}, Lcom/pwrd/google/gson/TypeAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;
    .locals 1
    .param p1, "in"    # Lcom/pwrd/google/gson/stream/JsonReader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/stream/JsonReader;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 893
    .local p0, "this":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    iget-object v0, p0, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    if-nez v0, :cond_0

    .line 894
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 896
    :cond_0
    iget-object v0, p0, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-virtual {v0, p1}, Lcom/pwrd/google/gson/TypeAdapter;->read(Lcom/pwrd/google/gson/stream/JsonReader;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public setDelegate(Lcom/pwrd/google/gson/TypeAdapter;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/TypeAdapter",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 886
    .local p0, "this":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    .local p1, "typeAdapter":Lcom/pwrd/google/gson/TypeAdapter;, "Lcom/pwrd/google/gson/TypeAdapter<TT;>;"
    iget-object v0, p0, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    if-eqz v0, :cond_0

    .line 887
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 889
    :cond_0
    iput-object p1, p0, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    .line 890
    return-void
.end method

.method public write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    .locals 1
    .param p1, "out"    # Lcom/pwrd/google/gson/stream/JsonWriter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/google/gson/stream/JsonWriter;",
            "TT;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 900
    .local p0, "this":Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;, "Lcom/pwrd/google/gson/Gson$FutureTypeAdapter<TT;>;"
    .local p2, "value":Ljava/lang/Object;, "TT;"
    iget-object v0, p0, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    if-nez v0, :cond_0

    .line 901
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 903
    :cond_0
    iget-object v0, p0, Lcom/pwrd/google/gson/Gson$FutureTypeAdapter;->delegate:Lcom/pwrd/google/gson/TypeAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/pwrd/google/gson/TypeAdapter;->write(Lcom/pwrd/google/gson/stream/JsonWriter;Ljava/lang/Object;)V

    .line 904
    return-void
.end method
