.class final Lcom/wanmei/push/PushAgent$5$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/PushAgent$OnPushOpenCallBack;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/PushAgent$5;->a(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/PushAgent$5;


# direct methods
.method constructor <init>(Lcom/wanmei/push/PushAgent$5;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/PushAgent$5$1;->a:Lcom/wanmei/push/PushAgent$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final openFail(I)V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "xiaomi push openFailed"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final openSuccess()V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "xiaomi push openSuccess"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
