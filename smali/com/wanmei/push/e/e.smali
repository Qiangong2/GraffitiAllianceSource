.class public final Lcom/wanmei/push/e/e;
.super Ljava/lang/Object;


# direct methods
.method public static a(Ljava/lang/String;Lcom/pwrd/google/gson/reflect/TypeToken;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/pwrd/google/gson/reflect/TypeToken",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    new-instance v0, Lcom/pwrd/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/pwrd/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/pwrd/google/gson/GsonBuilder;->excludeFieldsWithoutExposeAnnotation()Lcom/pwrd/google/gson/GsonBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/pwrd/google/gson/GsonBuilder;->create()Lcom/pwrd/google/gson/Gson;

    move-result-object v0

    invoke-virtual {p1}, Lcom/pwrd/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Lcom/pwrd/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
