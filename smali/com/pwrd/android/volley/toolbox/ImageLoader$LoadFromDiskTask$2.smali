.class Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$2;
.super Ljava/lang/Object;
.source "ImageLoader.java"

# interfaces
.implements Lcom/pwrd/android/volley/Response$ErrorListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->tryAddRequest()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/pwrd/android/volley/Response$ErrorListener;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;


# direct methods
.method constructor <init>(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$2;->this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    .line 511
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onErrorResponse(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 2
    .param p1, "error"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .line 514
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$2;->this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->access$5(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Lcom/pwrd/android/volley/toolbox/ImageLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$2;->this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$5(Lcom/pwrd/android/volley/toolbox/ImageLoader;Ljava/lang/String;Lcom/pwrd/android/volley/VolleyError;)V

    .line 515
    invoke-static {}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->access$6()Ljava/util/HashSet;

    move-result-object v0

    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask$2;->this$1:Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;

    invoke-static {v1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;->access$3(Lcom/pwrd/android/volley/toolbox/ImageLoader$LoadFromDiskTask;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 516
    return-void
.end method
