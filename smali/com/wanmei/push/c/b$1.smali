.class final Lcom/wanmei/push/c/b$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/channel/commonutils/logger/LoggerInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/c/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/c/b;


# direct methods
.method constructor <init>(Lcom/wanmei/push/c/b;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/c/b$1;->a:Lcom/wanmei/push/c/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final log(Ljava/lang/String;)V
    .locals 1
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    const-string v0, "PERFECT_PUSH"

    invoke-static {v0, p1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final log(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    const-string v0, "PERFECT_PUSH"

    invoke-static {v0, p1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final setTag(Ljava/lang/String;)V
    .locals 0

    return-void
.end method
