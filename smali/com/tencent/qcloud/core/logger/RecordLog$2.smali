.class Lcom/tencent/qcloud/core/logger/RecordLog$2;
.super Landroid/os/Handler;
.source "RecordLog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/qcloud/core/logger/RecordLog;-><init>(Landroid/content/Context;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/qcloud/core/logger/RecordLog;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/logger/RecordLog;Landroid/os/Looper;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/qcloud/core/logger/RecordLog;
    .param p2, "x0"    # Landroid/os/Looper;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/tencent/qcloud/core/logger/RecordLog$2;->this$0:Lcom/tencent/qcloud/core/logger/RecordLog;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 73
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 84
    :goto_0
    return-void

    .line 75
    :pswitch_0
    iget-object v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog$2;->this$0:Lcom/tencent/qcloud/core/logger/RecordLog;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/logger/RecordLog;->flush()V

    .line 76
    const/4 v0, 0x0

    const-wide/16 v2, 0x2710

    invoke-virtual {p0, v0, v2, v3}, Lcom/tencent/qcloud/core/logger/RecordLog$2;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    .line 79
    :pswitch_1
    iget-object v0, p0, Lcom/tencent/qcloud/core/logger/RecordLog$2;->this$0:Lcom/tencent/qcloud/core/logger/RecordLog;

    invoke-virtual {v0}, Lcom/tencent/qcloud/core/logger/RecordLog;->input()V

    goto :goto_0

    .line 73
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
