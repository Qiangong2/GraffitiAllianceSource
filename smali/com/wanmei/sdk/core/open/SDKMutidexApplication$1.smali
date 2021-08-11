.class Lcom/wanmei/sdk/core/open/SDKMutidexApplication$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/task/d$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->attachBaseContext(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/sdk/core/open/SDKMutidexApplication;


# direct methods
.method constructor <init>(Lcom/wanmei/sdk/core/open/SDKMutidexApplication;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication$1;->this$0:Lcom/wanmei/sdk/core/open/SDKMutidexApplication;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFail()V
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string v1, "LoadMultiDexTask onFail"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v0, 0x0

    sput-boolean v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->mHasLoadMutiDex:Z

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "loadMultiDex fail"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onSuccess()V
    .locals 2

    invoke-static {}, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->access$000()Ljava/lang/String;

    move-result-object v0

    const-string v1, "LoadMultiDexTask onSuccess"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const-class v1, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;

    monitor-enter v1

    const/4 v0, 0x1

    :try_start_0
    sput-boolean v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;->mHasLoadMutiDex:Z

    const-class v0, Lcom/wanmei/sdk/core/open/SDKMutidexApplication;

    invoke-virtual {v0}, Ljava/lang/Object;->notifyAll()V

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
