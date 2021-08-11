.class public interface abstract Lcom/pwrd/android/volley/ResponseDelivery;
.super Ljava/lang/Object;
.source "ResponseDelivery.java"


# virtual methods
.method public abstract postError(Lcom/pwrd/android/volley/Request;Lcom/pwrd/android/volley/VolleyError;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;",
            "Lcom/pwrd/android/volley/VolleyError;",
            ")V"
        }
    .end annotation
.end method

.method public abstract postResponse(Lcom/pwrd/android/volley/Request;Lcom/pwrd/android/volley/Response;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;",
            "Lcom/pwrd/android/volley/Response",
            "<*>;)V"
        }
    .end annotation
.end method

.method public abstract postResponse(Lcom/pwrd/android/volley/Request;Lcom/pwrd/android/volley/Response;Ljava/lang/Runnable;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;",
            "Lcom/pwrd/android/volley/Response",
            "<*>;",
            "Ljava/lang/Runnable;",
            ")V"
        }
    .end annotation
.end method
