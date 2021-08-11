.class public Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;
.super Landroid/app/Service;


# static fields
.field private static c:[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;


# instance fields
.field public a:Landroid/content/BroadcastReceiver;

.field private b:Lcom/wanmei/sdk/core/ui/floatview/b;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService$1;

    invoke-direct {v0, p0}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService$1;-><init>(Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->a:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;)Lcom/wanmei/sdk/core/ui/floatview/b;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    return-object v0
.end method

.method public static a([Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V
    .locals 0

    sput-object p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->c:[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 2

    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    const-string v1, "android.intent.action.CONFIGURATION_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->a:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    return-void
.end method

.method public onDestroy()V
    .locals 1

    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->c()V

    :cond_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->a:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    const-string v0, "floatViewAction"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    const/4 v0, 0x3

    return v0

    :pswitch_0
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    if-nez v0, :cond_1

    new-instance v0, Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {p0}, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->getApplication()Landroid/app/Application;

    move-result-object v1

    const-string v2, "floatViewPlace"

    const/4 v3, 0x1

    invoke-virtual {p1, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v2

    sget-object v3, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->c:[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;

    invoke-direct {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/ui/floatview/b;-><init>(Landroid/content/Context;I[Lcom/wanmei/sdk/core/ui/floatview/FloatViewItem;)V

    iput-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    :cond_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->a()V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wanmei/sdk/core/ui/floatview/FloatViewService;->b:Lcom/wanmei/sdk/core/ui/floatview/b;

    invoke-virtual {v0}, Lcom/wanmei/sdk/core/ui/floatview/b;->b()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
