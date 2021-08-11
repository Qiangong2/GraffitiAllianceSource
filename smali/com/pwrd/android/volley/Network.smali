.class public interface abstract Lcom/pwrd/android/volley/Network;
.super Ljava/lang/Object;
.source "Network.java"


# virtual methods
.method public abstract performRequest(Lcom/pwrd/android/volley/Request;)Lcom/pwrd/android/volley/NetworkResponse;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;)",
            "Lcom/pwrd/android/volley/NetworkResponse;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/pwrd/android/volley/VolleyError;
        }
    .end annotation
.end method
