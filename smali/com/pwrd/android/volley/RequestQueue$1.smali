.class Lcom/pwrd/android/volley/RequestQueue$1;
.super Ljava/lang/Object;
.source "RequestQueue.java"

# interfaces
.implements Lcom/pwrd/android/volley/RequestQueue$RequestFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/android/volley/RequestQueue;->cancelAll(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/pwrd/android/volley/RequestQueue;

.field private final synthetic val$tag:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/pwrd/android/volley/RequestQueue;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/android/volley/RequestQueue$1;->this$0:Lcom/pwrd/android/volley/RequestQueue;

    iput-object p2, p0, Lcom/pwrd/android/volley/RequestQueue$1;->val$tag:Ljava/lang/Object;

    .line 204
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public apply(Lcom/pwrd/android/volley/Request;)Z
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;)Z"
        }
    .end annotation

    .prologue
    .line 207
    .local p1, "request":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    invoke-virtual {p1}, Lcom/pwrd/android/volley/Request;->getTag()Ljava/lang/Object;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/android/volley/RequestQueue$1;->val$tag:Ljava/lang/Object;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method