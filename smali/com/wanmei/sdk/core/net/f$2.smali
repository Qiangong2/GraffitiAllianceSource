.class Lcom/wanmei/sdk/core/net/f$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljavax/net/ssl/HostnameVerifier;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/sdk/core/net/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/sdk/core/net/f;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/net/f;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/sdk/core/net/f$2;->a:Lcom/wanmei/sdk/core/net/f;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z
    .locals 1
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "sslSession"    # Ljavax/net/ssl/SSLSession;

    .prologue
    const/4 v0, 0x1

    return v0
.end method
