.class public Lcom/wanmei/sdk/core/net/a;
.super Ljava/lang/Object;


# direct methods
.method public static a(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    new-instance v0, Lcom/pwrd/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/pwrd/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/pwrd/google/gson/GsonBuilder;->excludeFieldsWithoutExposeAnnotation()Lcom/pwrd/google/gson/GsonBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/pwrd/google/gson/GsonBuilder;->create()Lcom/pwrd/google/gson/Gson;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/pwrd/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/InstantiationException;->printStackTrace()V

    goto :goto_0

    :catch_1
    move-exception v1

    invoke-virtual {v1}, Ljava/lang/IllegalAccessException;->printStackTrace()V

    goto :goto_0
.end method
