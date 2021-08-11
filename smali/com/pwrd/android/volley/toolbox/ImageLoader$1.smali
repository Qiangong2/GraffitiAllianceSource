.class Lcom/pwrd/android/volley/toolbox/ImageLoader$1;
.super Ljava/lang/Object;
.source "ImageLoader.java"

# interfaces
.implements Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader;->getImageListener(Landroid/widget/ImageView;II)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$defaultImageResId:I

.field private final synthetic val$errorImageResId:I

.field private final synthetic val$imageView:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(ILandroid/widget/ImageView;I)V
    .locals 0

    .prologue
    .line 1
    iput p1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$errorImageResId:I

    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$imageView:Landroid/widget/ImageView;

    iput p3, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$defaultImageResId:I

    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onErrorResponse(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 2
    .param p1, "error"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .line 147
    iget v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$errorImageResId:I

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$imageView:Landroid/widget/ImageView;

    iget v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$errorImageResId:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 150
    :cond_0
    return-void
.end method

.method public onResponse(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Z)V
    .locals 2
    .param p1, "response"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    .param p2, "isImmediate"    # Z

    .prologue
    .line 154
    invoke-virtual {p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 155
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$imageView:Landroid/widget/ImageView;

    invoke-virtual {p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 159
    :cond_0
    :goto_0
    return-void

    .line 156
    :cond_1
    iget v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$defaultImageResId:I

    if-eqz v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$imageView:Landroid/widget/ImageView;

    iget v1, p0, Lcom/pwrd/android/volley/toolbox/ImageLoader$1;->val$defaultImageResId:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method
