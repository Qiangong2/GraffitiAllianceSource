.class Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;
.super Ljava/lang/Object;
.source "ImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "BatchedImageRequest"
.end annotation


# instance fields
.field private final mContainers:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;",
            ">;"
        }
    .end annotation
.end field

.field private mError:Lcom/pwrd/android/volley/VolleyError;

.field private final mRequest:Lcom/pwrd/android/volley/Request;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/pwrd/android/volley/Request",
            "<*>;"
        }
    .end annotation
.end field

.field private mResponseBitmap:Landroid/graphics/Bitmap;

.field final synthetic this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;


# direct methods
.method public constructor <init>(Lcom/pwrd/android/volley/toolbox/ImageLoader;Lcom/pwrd/android/volley/Request;Ljava/util/HashSet;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/pwrd/android/volley/Request",
            "<*>;",
            "Ljava/util/HashSet",
            "<",
            "Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 571
    .local p2, "request":Lcom/pwrd/android/volley/Request;, "Lcom/pwrd/android/volley/Request<*>;"
    .local p3, "container":Ljava/util/HashSet;, "Ljava/util/HashSet<Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;>;"
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->this$0:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 563
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mContainers:Ljava/util/HashSet;

    .line 572
    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mRequest:Lcom/pwrd/android/volley/Request;

    .line 573
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v0, p3}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 574
    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)Ljava/util/HashSet;
    .locals 1

    .prologue
    .line 563
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mContainers:Ljava/util/HashSet;

    return-object v0
.end method

.method static synthetic access$1(Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;Landroid/graphics/Bitmap;)V
    .locals 0

    .prologue
    .line 553
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mResponseBitmap:Landroid/graphics/Bitmap;

    return-void
.end method

.method static synthetic access$2(Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;)Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 553
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mResponseBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method


# virtual methods
.method public addContainer(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)V
    .locals 1
    .param p1, "container"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .prologue
    .line 595
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 596
    return-void
.end method

.method public addContainers(Ljava/util/HashSet;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashSet",
            "<",
            "Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 615
    .local p1, "containers":Ljava/util/HashSet;, "Ljava/util/HashSet<Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;>;"
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z

    .line 616
    return-void
.end method

.method public getError()Lcom/pwrd/android/volley/VolleyError;
    .locals 1

    .prologue
    .line 587
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mError:Lcom/pwrd/android/volley/VolleyError;

    return-object v0
.end method

.method public removeContainerAndCancelIfNecessary(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;)Z
    .locals 1
    .param p1, "container"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .prologue
    .line 606
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v0, p1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 607
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mContainers:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/util/HashSet;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 608
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mRequest:Lcom/pwrd/android/volley/Request;

    invoke-virtual {v0}, Lcom/pwrd/android/volley/Request;->cancel()V

    .line 609
    const/4 v0, 0x1

    .line 611
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setError(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 0
    .param p1, "error"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .line 580
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$BatchedImageRequest;->mError:Lcom/pwrd/android/volley/VolleyError;

    .line 581
    return-void
.end method
