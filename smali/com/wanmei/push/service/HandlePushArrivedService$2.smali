.class final Lcom/wanmei/push/service/HandlePushArrivedService$2;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/service/HandlePushArrivedService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/bean/PushMessage;

.field final synthetic b:Lcom/wanmei/push/service/HandlePushArrivedService;


# direct methods
.method constructor <init>(Lcom/wanmei/push/service/HandlePushArrivedService;Lcom/wanmei/push/bean/PushMessage;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/service/HandlePushArrivedService$2;->b:Lcom/wanmei/push/service/HandlePushArrivedService;

    iput-object p2, p0, Lcom/wanmei/push/service/HandlePushArrivedService$2;->a:Lcom/wanmei/push/bean/PushMessage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/push/service/HandlePushArrivedService$2;->b:Lcom/wanmei/push/service/HandlePushArrivedService;

    iget-object v1, p0, Lcom/wanmei/push/service/HandlePushArrivedService$2;->a:Lcom/wanmei/push/bean/PushMessage;

    invoke-static {v0, v1}, Lcom/wanmei/push/service/HandlePushArrivedService;->a(Lcom/wanmei/push/service/HandlePushArrivedService;Lcom/wanmei/push/bean/PushMessage;)V

    return-void
.end method
