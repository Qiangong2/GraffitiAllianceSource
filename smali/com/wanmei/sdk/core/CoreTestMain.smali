.class public Lcom/wanmei/sdk/core/CoreTestMain;
.super Landroid/app/Activity;


# instance fields
.field private final a:Landroid/content/Context;

.field private b:Landroid/app/Activity;

.field private c:Landroid/widget/Button;

.field private d:Landroid/widget/Button;

.field private e:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    iput-object p0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->a:Landroid/content/Context;

    iput-object p0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->b:Landroid/app/Activity;

    return-void
.end method

.method private a()V
    .locals 4

    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    const/16 v1, 0x3e9

    const-string v2, "d44aad69bb50d9bb321fa1298c1cdeed"

    new-instance v3, Lcom/wanmei/sdk/core/CoreTestMain$9;

    invoke-direct {v3, p0}, Lcom/wanmei/sdk/core/CoreTestMain$9;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/wanmei/sdk/core/open/SDKBase;->init(ILjava/lang/String;Lcom/wanmei/sdk/core/open/SDKInterface$InitCallBack;)V

    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/CoreTestMain$10;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/CoreTestMain$10;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->setLogoutCallBack(Lcom/wanmei/sdk/core/open/SDKInterface$LogoutCallBack;)V

    return-void
.end method

.method static synthetic a(Lcom/wanmei/sdk/core/CoreTestMain;)V
    .locals 0

    invoke-direct {p0}, Lcom/wanmei/sdk/core/CoreTestMain;->a()V

    return-void
.end method

.method static synthetic b(Lcom/wanmei/sdk/core/CoreTestMain;)V
    .locals 2

    iget-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->b:Landroid/app/Activity;

    invoke-static {v0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v0

    new-instance v1, Lcom/wanmei/sdk/core/CoreTestMain$2;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/CoreTestMain$2;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKBase;->doLogin(Lcom/wanmei/sdk/core/open/SDKInterface$LoginCallBack;)V

    return-void
.end method

.method static synthetic c(Lcom/wanmei/sdk/core/CoreTestMain;)Landroid/app/Activity;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->b:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic d(Lcom/wanmei/sdk/core/CoreTestMain;)Landroid/widget/EditText;
    .locals 1

    iget-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->e:Landroid/widget/EditText;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    sget v0, Lcom/wanmei/sdk/core/R$layout;->activity_main:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->setContentView(I)V

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->getInstance()Lcom/wanmei/sdk/core/open/SDKCoreFacade;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wanmei/sdk/core/open/SDKCoreFacade;->setDebug(Z)V

    sget v0, Lcom/wanmei/sdk/core/R$id;->initBtn:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcom/wanmei/sdk/core/CoreTestMain$1;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/CoreTestMain$1;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    sget v0, Lcom/wanmei/sdk/core/R$id;->loginBtn:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcom/wanmei/sdk/core/CoreTestMain$3;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/CoreTestMain$3;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    sget v0, Lcom/wanmei/sdk/core/R$id;->customServiceBtn:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    new-instance v1, Lcom/wanmei/sdk/core/CoreTestMain$4;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/CoreTestMain$4;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {p0}, Lcom/wanmei/sdk/core/open/SDKBase;->getInstance(Landroid/app/Activity;)Lcom/wanmei/sdk/core/open/SDKBase;

    move-result-object v2

    const/16 v3, 0x68

    new-instance v4, Lcom/wanmei/sdk/core/CoreTestMain$5;

    invoke-direct {v4, p0, v0, v1}, Lcom/wanmei/sdk/core/CoreTestMain$5;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;J)V

    invoke-virtual {v2, v3, v4}, Lcom/wanmei/sdk/core/open/SDKBase;->getChannelConfig(ILcom/wanmei/sdk/core/open/SDKInterface$ReadChannelCallBack;)V

    sget v0, Lcom/wanmei/sdk/core/R$id;->add_log_btn:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->c:Landroid/widget/Button;

    sget v0, Lcom/wanmei/sdk/core/R$id;->crash_btn:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->d:Landroid/widget/Button;

    sget v0, Lcom/wanmei/sdk/core/R$id;->edit_text:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/wanmei/sdk/core/CoreTestMain;->e:Landroid/widget/EditText;

    sget v0, Lcom/wanmei/sdk/core/R$id;->upload_btn:I

    invoke-virtual {p0, v0}, Lcom/wanmei/sdk/core/CoreTestMain;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iget-object v1, p0, Lcom/wanmei/sdk/core/CoreTestMain;->c:Landroid/widget/Button;

    new-instance v2, Lcom/wanmei/sdk/core/CoreTestMain$6;

    invoke-direct {v2, p0}, Lcom/wanmei/sdk/core/CoreTestMain$6;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v1, p0, Lcom/wanmei/sdk/core/CoreTestMain;->d:Landroid/widget/Button;

    new-instance v2, Lcom/wanmei/sdk/core/CoreTestMain$7;

    invoke-direct {v2, p0}, Lcom/wanmei/sdk/core/CoreTestMain$7;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    new-instance v1, Lcom/wanmei/sdk/core/CoreTestMain$8;

    invoke-direct {v1, p0}, Lcom/wanmei/sdk/core/CoreTestMain$8;-><init>(Lcom/wanmei/sdk/core/CoreTestMain;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-direct {p0}, Lcom/wanmei/sdk/core/CoreTestMain;->a()V

    return-void
.end method
