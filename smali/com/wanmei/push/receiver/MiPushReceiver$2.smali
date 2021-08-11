.class Lcom/wanmei/push/receiver/MiPushReceiver$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/receiver/MiPushReceiver;->onReceiveRegisterResult(Landroid/content/Context;Lcom/xiaomi/mipush/sdk/MiPushCommandMessage;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/push/receiver/MiPushReceiver;


# direct methods
.method constructor <init>(Lcom/wanmei/push/receiver/MiPushReceiver;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/receiver/MiPushReceiver$2;->this$0:Lcom/wanmei/push/receiver/MiPushReceiver;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public openFail(I)V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "xiaomi push openFailed"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public openSuccess()V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "xiaomi push openSuccess"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
