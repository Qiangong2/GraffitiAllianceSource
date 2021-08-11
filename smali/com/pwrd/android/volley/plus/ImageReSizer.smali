.class public Lcom/pwrd/android/volley/plus/ImageReSizer;
.super Ljava/lang/Object;
.source "ImageReSizer.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "ImageResizer"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I
    .locals 8
    .param p0, "options"    # Landroid/graphics/BitmapFactory$Options;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I

    .prologue
    .line 149
    iget v0, p0, Landroid/graphics/BitmapFactory$Options;->outHeight:I

    .line 150
    .local v0, "height":I
    iget v5, p0, Landroid/graphics/BitmapFactory$Options;->outWidth:I

    .line 151
    .local v5, "width":I
    const/4 v1, 0x1

    .line 152
    .local v1, "inSampleSize":I
    if-lez p1, :cond_0

    if-gtz p2, :cond_1

    :cond_0
    move v2, v1

    .line 179
    .end local v1    # "inSampleSize":I
    .local v2, "inSampleSize":I
    :goto_0
    return v2

    .line 155
    .end local v2    # "inSampleSize":I
    .restart local v1    # "inSampleSize":I
    :cond_1
    if-gt v0, p2, :cond_2

    if-le v5, p1, :cond_3

    .line 156
    :cond_2
    if-le v5, v0, :cond_4

    .line 157
    int-to-float v6, v0

    int-to-float v7, p2

    div-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 169
    :goto_1
    mul-int v6, v5, v0

    int-to-float v3, v6

    .line 173
    .local v3, "totalPixels":F
    mul-int v6, p1, p2

    mul-int/lit8 v6, v6, 0x2

    int-to-float v4, v6

    .line 175
    .local v4, "totalReqPixelsCap":F
    :goto_2
    mul-int v6, v1, v1

    int-to-float v6, v6

    div-float v6, v3, v6

    cmpl-float v6, v6, v4

    if-gtz v6, :cond_5

    .end local v3    # "totalPixels":F
    .end local v4    # "totalReqPixelsCap":F
    :cond_3
    move v2, v1

    .line 179
    .end local v1    # "inSampleSize":I
    .restart local v2    # "inSampleSize":I
    goto :goto_0

    .line 159
    .end local v2    # "inSampleSize":I
    .restart local v1    # "inSampleSize":I
    :cond_4
    int-to-float v6, v5

    int-to-float v7, p1

    div-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v1

    goto :goto_1

    .line 176
    .restart local v3    # "totalPixels":F
    .restart local v4    # "totalReqPixelsCap":F
    :cond_5
    add-int/lit8 v1, v1, 0x1

    goto :goto_2
.end method

.method public static decodeSampledBitmapFromDescriptor(Ljava/io/FileDescriptor;II)Landroid/graphics/Bitmap;
    .locals 3
    .param p0, "fileDescriptor"    # Ljava/io/FileDescriptor;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I

    .prologue
    const/4 v2, 0x0

    .line 106
    invoke-static {p1, p2}, Lcom/pwrd/android/volley/plus/ImageReSizer;->widthHeightCheck(II)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p0}, Landroid/graphics/BitmapFactory;->decodeFileDescriptor(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 118
    :goto_0
    return-object v1

    .line 109
    :cond_0
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 110
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 111
    invoke-static {p0, v2, v0}, Landroid/graphics/BitmapFactory;->decodeFileDescriptor(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 114
    invoke-static {v0, p1, p2}, Lcom/pwrd/android/volley/plus/ImageReSizer;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v1

    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 117
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 118
    invoke-static {p0, v2, v0}, Landroid/graphics/BitmapFactory;->decodeFileDescriptor(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_0
.end method

.method public static decodeSampledBitmapFromFile(Ljava/lang/String;II)Landroid/graphics/Bitmap;
    .locals 2
    .param p0, "filename"    # Ljava/lang/String;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I

    .prologue
    .line 59
    invoke-static {p1, p2}, Lcom/pwrd/android/volley/plus/ImageReSizer;->widthHeightCheck(II)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 70
    :goto_0
    return-object v1

    .line 61
    :cond_0
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 62
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 63
    invoke-static {p0, v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 66
    invoke-static {v0, p1, p2}, Lcom/pwrd/android/volley/plus/ImageReSizer;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v1

    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 69
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 70
    invoke-static {p0, v0}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_0
.end method

.method public static decodeSampledBitmapFromResource(Landroid/content/res/Resources;III)Landroid/graphics/Bitmap;
    .locals 2
    .param p0, "res"    # Landroid/content/res/Resources;
    .param p1, "resId"    # I
    .param p2, "reqWidth"    # I
    .param p3, "reqHeight"    # I

    .prologue
    .line 34
    invoke-static {p2, p3}, Lcom/pwrd/android/volley/plus/ImageReSizer;->widthHeightCheck(II)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p0, p1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 45
    :goto_0
    return-object v1

    .line 36
    :cond_0
    new-instance v0, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v0}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 37
    .local v0, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v1, 0x1

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 38
    invoke-static {p0, p1, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 41
    invoke-static {v0, p2, p3}, Lcom/pwrd/android/volley/plus/ImageReSizer;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v1

    iput v1, v0, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 44
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 45
    invoke-static {p0, p1, v0}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v1

    goto :goto_0
.end method

.method public static decodeSampledBitmapFromStream(Ljava/io/InputStream;II)Landroid/graphics/Bitmap;
    .locals 5
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "reqWidth"    # I
    .param p2, "reqHeight"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v4, -0x1

    .line 75
    invoke-static {p1, p2}, Lcom/pwrd/android/volley/plus/ImageReSizer;->widthHeightCheck(II)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {p0}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 91
    :goto_0
    return-object v3

    .line 77
    :cond_0
    instance-of v3, p0, Ljava/io/BufferedInputStream;

    if-nez v3, :cond_1

    .line 78
    new-instance v0, Ljava/io/BufferedInputStream;

    invoke-direct {v0, p0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .end local p0    # "inputStream":Ljava/io/InputStream;
    .local v0, "inputStream":Ljava/io/InputStream;
    move-object p0, v0

    .line 80
    .end local v0    # "inputStream":Ljava/io/InputStream;
    .restart local p0    # "inputStream":Ljava/io/InputStream;
    :cond_1
    new-instance v1, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v1}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 81
    .local v1, "options":Landroid/graphics/BitmapFactory$Options;
    const/4 v3, 0x1

    iput-boolean v3, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 82
    new-instance v2, Landroid/graphics/Rect;

    invoke-direct {v2, v4, v4, v4, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 83
    .local v2, "rect":Landroid/graphics/Rect;
    invoke-static {p0, v2, v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    .line 86
    invoke-static {v1, p1, p2}, Lcom/pwrd/android/volley/plus/ImageReSizer;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v3

    iput v3, v1, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 89
    const/4 v3, 0x0

    iput-boolean v3, v1, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 90
    invoke-virtual {p0}, Ljava/io/InputStream;->reset()V

    .line 91
    invoke-static {p0, v2, v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    goto :goto_0
.end method

.method private static widthHeightCheck(II)Z
    .locals 1
    .param p0, "reqWidth"    # I
    .param p1, "reqHeight"    # I

    .prologue
    .line 129
    if-lez p0, :cond_0

    if-lez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
