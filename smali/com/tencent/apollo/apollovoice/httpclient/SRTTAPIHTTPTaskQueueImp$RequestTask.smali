.class Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;
.super Ljava/lang/Object;
.source "SRTTAPIHTTPTaskQueueImp.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "RequestTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;


# direct methods
.method constructor <init>(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;)V
    .locals 0

    .prologue
    .line 354
    iput-object p1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;->this$0:Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 361
    :goto_0
    iget-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;->this$0:Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;

    invoke-static {v0}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->access$000(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;)Ljava/util/LinkedList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 363
    const-wide/16 v0, 0x3e8

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 364
    :catch_0
    move-exception v0

    .line 365
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 369
    :cond_0
    iget-object v0, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;->this$0:Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;

    invoke-static {v0}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->access$000(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;)Ljava/util/LinkedList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/LinkedList;->remove()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;

    .line 370
    iget v1, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->type:I

    packed-switch v1, :pswitch_data_0

    .line 381
    invoke-static {}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->access$400()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "[SRTTAPIHTTPTaskQueueImp]Unknown type:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v0, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->type:I

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 372
    :pswitch_0
    iget-object v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;->this$0:Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;

    iget v0, v0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;->session:I

    invoke-static {v1, v0}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->access$100(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;I)V

    goto :goto_0

    .line 375
    :pswitch_1
    iget-object v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;->this$0:Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;

    invoke-static {v1, v0}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->access$200(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V

    goto :goto_0

    .line 378
    :pswitch_2
    iget-object v1, p0, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp$RequestTask;->this$0:Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;

    invoke-static {v1, v0}, Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;->access$300(Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTaskQueueImp;Lcom/tencent/apollo/apollovoice/httpclient/SRTTAPIHTTPTask;)V

    goto :goto_0

    .line 370
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
