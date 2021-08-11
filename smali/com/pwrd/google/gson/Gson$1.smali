.class Lcom/pwrd/google/gson/Gson$1;
.super Ljava/lang/Object;
.source "Gson.java"

# interfaces
.implements Lcom/pwrd/google/gson/JsonDeserializationContext;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/Gson;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/pwrd/google/gson/Gson;


# direct methods
.method constructor <init>(Lcom/pwrd/google/gson/Gson;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/google/gson/Gson$1;->this$0:Lcom/pwrd/google/gson/Gson;

    .line 126
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public deserialize(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    .locals 1
    .param p1, "json"    # Lcom/pwrd/google/gson/JsonElement;
    .param p2, "typeOfT"    # Ljava/lang/reflect/Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/pwrd/google/gson/JsonElement;",
            "Ljava/lang/reflect/Type;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/google/gson/JsonParseException;
        }
    .end annotation

    .prologue
    .line 129
    iget-object v0, p0, Lcom/pwrd/google/gson/Gson$1;->this$0:Lcom/pwrd/google/gson/Gson;

    invoke-virtual {v0, p1, p2}, Lcom/pwrd/google/gson/Gson;->fromJson(Lcom/pwrd/google/gson/JsonElement;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
