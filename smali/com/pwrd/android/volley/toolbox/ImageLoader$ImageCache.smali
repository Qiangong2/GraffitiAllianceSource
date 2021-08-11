.class public interface abstract Lcom/pwrd/android/volley/toolbox/ImageLoader$ImageCache;
.super Ljava/lang/Object;
.source "ImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/toolbox/ImageLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ImageCache"
.end annotation


# virtual methods
.method public abstract addBitmapToCache(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;)V
.end method

.method public abstract addBitmapToMemCache(Ljava/lang/String;Landroid/graphics/Bitmap;)V
.end method

.method public abstract getBitmapFromDiskCache(Ljava/lang/String;II)Landroid/graphics/Bitmap;
.end method

.method public abstract getBitmapFromMemCache(Ljava/lang/String;)Landroid/graphics/Bitmap;
.end method

.method public abstract getCacheKey(Ljava/lang/String;)Ljava/lang/String;
.end method
