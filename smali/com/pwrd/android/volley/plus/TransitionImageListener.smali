.class public Lcom/pwrd/android/volley/plus/TransitionImageListener;
.super Ljava/lang/Object;
.source "TransitionImageListener.java"

# interfaces
.implements Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageListener;


# static fields
.field private static final FADE_IN_TIME:I = 0xc8

.field private static final MAX_POOL_SIZE:I = 0x32

.field private static sPool:Lcom/pwrd/android/volley/plus/TransitionImageListener;

.field private static sPoolSize:I

.field private static final sPoolSync:Ljava/lang/Object;


# instance fields
.field private defaultImageResId:I

.field private errorImageResId:I

.field next:Lcom/pwrd/android/volley/plus/TransitionImageListener;

.field private view:Landroid/widget/ImageView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSync:Ljava/lang/Object;

    .line 31
    const/4 v0, 0x0

    sput v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSize:I

    .line 33
    return-void
.end method

.method private constructor <init>(Landroid/widget/ImageView;II)V
    .locals 0
    .param p1, "view"    # Landroid/widget/ImageView;
    .param p2, "defaultImageResId"    # I
    .param p3, "errorImageResId"    # I

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    .line 77
    iput p2, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    .line 78
    iput p3, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->errorImageResId:I

    .line 79
    return-void
.end method

.method public static obtain(Landroid/widget/ImageView;II)Lcom/pwrd/android/volley/plus/TransitionImageListener;
    .locals 3
    .param p0, "view"    # Landroid/widget/ImageView;
    .param p1, "defaultImageResId"    # I
    .param p2, "errorImageResId"    # I

    .prologue
    .line 37
    sget-object v2, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSync:Ljava/lang/Object;

    monitor-enter v2

    .line 38
    :try_start_0
    sget-object v1, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPool:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    if-eqz v1, :cond_0

    .line 39
    sget-object v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPool:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    .line 40
    .local v0, "listener":Lcom/pwrd/android/volley/plus/TransitionImageListener;
    iget-object v1, v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->next:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    sput-object v1, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPool:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    .line 41
    const/4 v1, 0x0

    iput-object v1, v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->next:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    .line 42
    sget v1, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSize:I

    add-int/lit8 v1, v1, -0x1

    sput v1, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSize:I

    .line 43
    iput-object p0, v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    .line 44
    iput p1, v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    .line 45
    iput p2, v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->errorImageResId:I

    .line 46
    monitor-exit v2

    .line 49
    .end local v0    # "listener":Lcom/pwrd/android/volley/plus/TransitionImageListener;
    :goto_0
    return-object v0

    .line 37
    :cond_0
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 49
    new-instance v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;

    invoke-direct {v0, p0, p1, p2}, Lcom/pwrd/android/volley/plus/TransitionImageListener;-><init>(Landroid/widget/ImageView;II)V

    goto :goto_0

    .line 37
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method private showNow(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 104
    return-void
.end method

.method private transitBitmap(Landroid/graphics/Bitmap;)V
    .locals 6
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v5, -0x1

    .line 109
    new-instance v0, Landroid/graphics/drawable/TransitionDrawable;

    const/4 v1, 0x2

    new-array v1, v1, [Landroid/graphics/drawable/Drawable;

    const/4 v2, 0x0

    .line 110
    new-instance v3, Landroid/graphics/drawable/ColorDrawable;

    const v4, 0x106000d

    invoke-direct {v3, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    aput-object v3, v1, v2

    const/4 v2, 0x1

    .line 111
    new-instance v3, Landroid/graphics/drawable/BitmapDrawable;

    iget-object v4, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    invoke-virtual {v4}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-direct {v3, v4, p1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    aput-object v3, v1, v2

    .line 109
    invoke-direct {v0, v1}, Landroid/graphics/drawable/TransitionDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 114
    .local v0, "td":Landroid/graphics/drawable/TransitionDrawable;
    iget v1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    if-eqz v1, :cond_0

    iget v1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    if-eq v1, v5, :cond_0

    .line 115
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    iget v2, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 119
    :goto_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 120
    const/16 v1, 0xc8

    invoke-virtual {v0, v1}, Landroid/graphics/drawable/TransitionDrawable;->startTransition(I)V

    .line 121
    return-void

    .line 117
    :cond_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v2, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method


# virtual methods
.method clearForRecycle()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 69
    iput v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    .line 70
    iput v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->errorImageResId:I

    .line 71
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    .line 72
    return-void
.end method

.method public onErrorResponse(Lcom/pwrd/android/volley/VolleyError;)V
    .locals 2
    .param p1, "error"    # Lcom/pwrd/android/volley/VolleyError;

    .prologue
    .line 83
    iget v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->errorImageResId:I

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    iget v1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->errorImageResId:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 86
    :cond_0
    return-void
.end method

.method public onResponse(Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;Z)V
    .locals 2
    .param p1, "response"    # Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;
    .param p2, "isImmediate"    # Z

    .prologue
    .line 90
    invoke-virtual {p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 91
    if-eqz p2, :cond_1

    .line 92
    invoke-virtual {p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/pwrd/android/volley/plus/TransitionImageListener;->showNow(Landroid/graphics/Bitmap;)V

    .line 96
    :goto_0
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/TransitionImageListener;->recycle()V

    .line 100
    :cond_0
    :goto_1
    return-void

    .line 94
    :cond_1
    invoke-virtual {p1}, Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageContainer;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/pwrd/android/volley/plus/TransitionImageListener;->transitBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 97
    :cond_2
    iget v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 98
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->view:Landroid/widget/ImageView;

    iget v1, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->defaultImageResId:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1
.end method

.method public recycle()V
    .locals 3

    .prologue
    .line 58
    invoke-virtual {p0}, Lcom/pwrd/android/volley/plus/TransitionImageListener;->clearForRecycle()V

    .line 59
    sget-object v1, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSync:Ljava/lang/Object;

    monitor-enter v1

    .line 60
    :try_start_0
    sget v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSize:I

    const/16 v2, 0x32

    if-ge v0, v2, :cond_0

    .line 61
    sget-object v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPool:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->next:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    .line 62
    sput-object p0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPool:Lcom/pwrd/android/volley/plus/TransitionImageListener;

    .line 63
    sget v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSize:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/pwrd/android/volley/plus/TransitionImageListener;->sPoolSize:I

    .line 59
    :cond_0
    monitor-exit v1

    .line 66
    return-void

    .line 59
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
