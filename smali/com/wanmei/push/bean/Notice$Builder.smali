.class public Lcom/wanmei/push/bean/Notice$Builder;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wanmei/push/bean/Notice;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private apiAddr:Ljava/lang/String;

.field private isOffline:Ljava/lang/String;

.field private msgId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "msgId"    # Ljava/lang/String;
    .param p2, "apiAddr"    # Ljava/lang/String;

    .prologue
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-string v0, "0"

    iput-object v0, p0, Lcom/wanmei/push/bean/Notice$Builder;->isOffline:Ljava/lang/String;

    iput-object p1, p0, Lcom/wanmei/push/bean/Notice$Builder;->msgId:Ljava/lang/String;

    iput-object p2, p0, Lcom/wanmei/push/bean/Notice$Builder;->apiAddr:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Lcom/wanmei/push/bean/Notice$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/push/bean/Notice$Builder;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/bean/Notice$Builder;->msgId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/wanmei/push/bean/Notice$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/push/bean/Notice$Builder;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/bean/Notice$Builder;->apiAddr:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/wanmei/push/bean/Notice$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/wanmei/push/bean/Notice$Builder;

    .prologue
    iget-object v0, p0, Lcom/wanmei/push/bean/Notice$Builder;->isOffline:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/wanmei/push/bean/Notice;
    .locals 2

    new-instance v0, Lcom/wanmei/push/bean/Notice;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/wanmei/push/bean/Notice;-><init>(Lcom/wanmei/push/bean/Notice$Builder;Lcom/wanmei/push/bean/Notice$1;)V

    return-object v0
.end method

.method public isoffline(Ljava/lang/String;)Lcom/wanmei/push/bean/Notice$Builder;
    .locals 0
    .param p1, "val"    # Ljava/lang/String;

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/bean/Notice$Builder;->isOffline:Ljava/lang/String;

    return-object p0
.end method
