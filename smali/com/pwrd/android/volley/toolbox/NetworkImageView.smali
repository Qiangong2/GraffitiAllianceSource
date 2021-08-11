.class public Lcom/pwrd/android/volley/toolbox/NetworkImageView;
.super Landroid/widget/ImageView;
.source "NetworkImageView.java"


# static fields
.field private static final FADE_IN_TIME:I = 0xc8


# instance fields
.field private mDefaultImageId:I

.field private mErrorImageId:I

.field private mFadeInBitmap:Z

.field private mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

.field private mImageLoader:Lcom/pwrd/android/volley/toolbox/ImageLoader;

.field private mUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 61
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 62
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 65
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 66
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 69
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 57
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mFadeInBitmap:Z

    .line 70
    return-void
.end method

.method private loadImageIfNecessary(Z)V
    .locals 7
    .param p1, "isInLayoutPass"    # Z

    .prologue
    const/4 v4, -0x2

    const/4 v5, 0x0

    .line 113
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->getWidth()I

    move-result v2

    .line 114
    .local v2, "width":I
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->getHeight()I

    move-result v0

    .line 116
    .local v0, "height":I
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 117
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iget v3, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    if-ne v3, v4, :cond_1

    .line 118
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iget v3, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    if-ne v3, v4, :cond_1

    .line 116
    const/4 v1, 0x1

    .line 121
    .local v1, "isFullyWrapContent":Z
    :goto_0
    if-nez v2, :cond_2

    if-nez v0, :cond_2

    if-nez v1, :cond_2

    .line 149
    :cond_0
    :goto_1
    return-void

    .line 116
    .end local v1    # "isFullyWrapContent":Z
    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    .line 127
    .restart local v1    # "isFullyWrapContent":Z
    :cond_2
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mUrl:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 128
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    if-eqz v3, :cond_3

    .line 129
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    invoke-virtual {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->cancelRequest()V

    .line 130
    iput-object v5, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .line 132
    :cond_3
    invoke-virtual {p0, v5}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_1

    .line 137
    :cond_4
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    invoke-virtual {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->getRequestUrl()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_5

    .line 138
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    invoke-virtual {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->getRequestUrl()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 143
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    invoke-virtual {v3}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->cancelRequest()V

    .line 144
    invoke-virtual {p0, v5}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 148
    :cond_5
    iget-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageLoader:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    iget-object v4, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mUrl:Ljava/lang/String;

    iget v5, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mDefaultImageId:I

    iget v6, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mErrorImageId:I

    invoke-static {p0, v5, v6}, Lcom/pwrd/android/volley/plus/TransitionImageListener;->obtain(Landroid/widget/ImageView;II)Lcom/pwrd/android/volley/plus/TransitionImageListener;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/pwrd/android/volley/toolbox/ImageLoader;->get(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;)Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    move-result-object v3

    iput-object v3, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    goto :goto_1
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 0

    .prologue
    .line 172
    invoke-super {p0}, Landroid/widget/ImageView;->drawableStateChanged()V

    .line 173
    invoke-virtual {p0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->invalidate()V

    .line 174
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 159
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    if-eqz v0, :cond_0

    .line 162
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    invoke-virtual {v0}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->cancelRequest()V

    .line 163
    invoke-virtual {p0, v1}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 165
    iput-object v1, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageContainer:Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;

    .line 167
    :cond_0
    invoke-super {p0}, Landroid/widget/ImageView;->onDetachedFromWindow()V

    .line 168
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 1
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 153
    invoke-super/range {p0 .. p5}, Landroid/widget/ImageView;->onLayout(ZIIII)V

    .line 154
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->loadImageIfNecessary(Z)V

    .line 155
    return-void
.end method

.method public setDefaultImageResId(I)V
    .locals 0
    .param p1, "defaultImage"    # I

    .prologue
    .line 96
    iput p1, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mDefaultImageId:I

    .line 97
    return-void
.end method

.method public setErrorImageResId(I)V
    .locals 0
    .param p1, "errorImage"    # I

    .prologue
    .line 104
    iput p1, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mErrorImageId:I

    .line 105
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;Lcom/pwrd/android/volley/toolbox/ImageLoader;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "imageLoader"    # Lcom/pwrd/android/volley/toolbox/ImageLoader;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mUrl:Ljava/lang/String;

    .line 86
    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->mImageLoader:Lcom/pwrd/android/volley/toolbox/ImageLoader;

    .line 88
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/pwrd/android/volley/toolbox/NetworkImageView;->loadImageIfNecessary(Z)V

    .line 89
    return-void
.end method
