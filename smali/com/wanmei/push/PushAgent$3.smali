.class final Lcom/wanmei/push/PushAgent$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/push/b$h;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/PushAgent;->uploadDeviceInfo()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/wanmei/push/PushAgent;


# direct methods
.method constructor <init>(Lcom/wanmei/push/PushAgent;)V
    .locals 0

    iput-object p1, p0, Lcom/wanmei/push/PushAgent$3;->a:Lcom/wanmei/push/PushAgent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "Upload DeviceInfo Success"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public final b()V
    .locals 2

    const-string v0, "PERFECT_PUSH"

    const-string v1, "Upload DeviceInfo Fail"

    invoke-static {v0, v1}, Lcom/wanmei/push/g/f;->b(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
