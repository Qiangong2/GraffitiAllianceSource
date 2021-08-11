.class Lcom/amap/loc/b$a;
.super Ljava/lang/Object;
.source "APSServiceCore.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amap/loc/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation


# instance fields
.field a:D

.field b:D

.field final synthetic c:Lcom/amap/loc/b;


# direct methods
.method constructor <init>(Lcom/amap/loc/b;)V
    .locals 2

    const-wide/16 v0, 0x0

    iput-object p1, p0, Lcom/amap/loc/b$a;->c:Lcom/amap/loc/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-wide v0, p0, Lcom/amap/loc/b$a;->a:D

    iput-wide v0, p0, Lcom/amap/loc/b$a;->b:D

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    :try_start_0
    iget-object v0, p0, Lcom/amap/loc/b$a;->c:Lcom/amap/loc/b;

    invoke-static {v0}, Lcom/amap/loc/b;->c(Lcom/amap/loc/b;)V

    iget-object v0, p0, Lcom/amap/loc/b$a;->c:Lcom/amap/loc/b;

    iget-wide v2, p0, Lcom/amap/loc/b$a;->a:D

    iget-wide v4, p0, Lcom/amap/loc/b$a;->b:D

    invoke-static {v0, v2, v3, v4, v5}, Lcom/amap/loc/b;->a(Lcom/amap/loc/b;DD)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    const-string v1, "APSServiceCore"

    const-string v2, "GeoTask run"

    invoke-static {v0, v1, v2}, Lcom/amap/loc/c;->a(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
