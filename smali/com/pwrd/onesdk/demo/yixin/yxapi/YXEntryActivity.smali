.class public Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;
.super Lim/yixin/gamesdk/api/BaseYXGameEntryActivity;
.source "YXEntryActivity.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Lim/yixin/gamesdk/api/BaseYXGameEntryActivity;-><init>()V

    return-void
.end method

.method static synthetic access$0()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private getToken(Ljava/lang/String;)V
    .locals 3
    .param p1, "code"    # Ljava/lang/String;

    .prologue
    .line 129
    new-instance v0, Landroid/app/ProgressDialog;

    invoke-direct {v0, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    .line 130
    .local v0, "progressDialog":Landroid/app/ProgressDialog;
    const-string v1, "\u767b\u5f55\u4e2d..."

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 131
    invoke-virtual {p0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->getIYXGameApi()Lim/yixin/gamesdk/api/YXGameApi;

    move-result-object v1

    .line 132
    new-instance v2, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;

    invoke-direct {v2, p0, v0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$2;-><init>(Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;Landroid/app/ProgressDialog;)V

    .line 131
    invoke-interface {v1, p0, p1, v2}, Lim/yixin/gamesdk/api/YXGameApi;->fetchToken(Landroid/app/Activity;Ljava/lang/String;Lim/yixin/gamesdk/api/YXGameCallbackListener;)V

    .line 149
    return-void
.end method


# virtual methods
.method public onReq(Lim/yixin/sdk/api/BaseReq;)V
    .locals 10
    .param p1, "req"    # Lim/yixin/sdk/api/BaseReq;

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 87
    const-string v3, "YXEntryActivity"

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "onReq called: transaction="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p1, Lim/yixin/sdk/api/BaseReq;->transaction:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    invoke-virtual {p1}, Lim/yixin/sdk/api/BaseReq;->getType()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 117
    :goto_0
    :pswitch_0
    return-void

    :pswitch_1
    move-object v1, p1

    .line 90
    check-cast v1, Lim/yixin/sdk/api/SendMessageToYX$Req;

    .line 91
    .local v1, "req1":Lim/yixin/sdk/api/SendMessageToYX$Req;
    const-string v3, "\u56de\u8c03-SendMessageToYX.Req"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "title="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, v1, Lim/yixin/sdk/api/SendMessageToYX$Req;->message:Lim/yixin/sdk/api/YXMessage;

    iget-object v6, v6, Lim/yixin/sdk/api/YXMessage;->title:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    .line 92
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "desc="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, v1, Lim/yixin/sdk/api/SendMessageToYX$Req;->message:Lim/yixin/sdk/api/YXMessage;

    iget-object v6, v6, Lim/yixin/sdk/api/YXMessage;->description:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "transcion="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 93
    iget-object v6, v1, Lim/yixin/sdk/api/SendMessageToYX$Req;->transaction:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v9

    .line 91
    invoke-virtual {p0, v3, v4}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0

    .end local v1    # "req1":Lim/yixin/sdk/api/SendMessageToYX$Req;
    :pswitch_2
    move-object v2, p1

    .line 96
    check-cast v2, Lim/yixin/sdk/api/ShowYXMessageFromYX$Req;

    .line 97
    .local v2, "req2":Lim/yixin/sdk/api/ShowYXMessageFromYX$Req;
    const-string v3, "\u56de\u8c03-ShowYXMessageFromYX.Req"

    new-array v4, v9, [Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "extend="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, v2, Lim/yixin/sdk/api/ShowYXMessageFromYX$Req;->extInfo:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v7

    .line 98
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "transcion="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, v2, Lim/yixin/sdk/api/ShowYXMessageFromYX$Req;->transaction:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v8

    .line 97
    invoke-virtual {p0, v3, v4}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    .line 99
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 100
    .local v0, "handler":Landroid/os/Handler;
    new-instance v3, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;

    invoke-direct {v3, p0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity$1;-><init>(Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;)V

    invoke-virtual {v0, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto/16 :goto_0

    .line 88
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onResp(Lim/yixin/sdk/api/BaseResp;)V
    .locals 7
    .param p1, "resp"    # Lim/yixin/sdk/api/BaseResp;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 32
    sget-object v2, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "onResp called: errCode="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v4, p1, Lim/yixin/sdk/api/BaseResp;->errCode:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ",errStr="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 33
    iget-object v4, p1, Lim/yixin/sdk/api/BaseResp;->errStr:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ",transaction="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lim/yixin/sdk/api/BaseResp;->transaction:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 32
    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 34
    invoke-virtual {p1}, Lim/yixin/sdk/api/BaseResp;->getType()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 80
    :goto_0
    return-void

    :pswitch_0
    move-object v0, p1

    .line 36
    check-cast v0, Lim/yixin/sdk/api/SendMessageToYX$Resp;

    .line 37
    .local v0, "resp1":Lim/yixin/sdk/api/SendMessageToYX$Resp;
    iget v2, v0, Lim/yixin/sdk/api/SendMessageToYX$Resp;->errCode:I

    packed-switch v2, :pswitch_data_1

    goto :goto_0

    .line 51
    :pswitch_1
    const-string v2, "\u53d1\u9001\u5931\u8d25"

    invoke-static {p0, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 52
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 39
    :pswitch_2
    const-string v2, "\u5206\u4eab\u6210\u529f"

    invoke-static {p0, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 40
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 43
    :pswitch_3
    const-string v2, "\u5206\u4eab\u5931\u8d25"

    invoke-static {p0, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 44
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 47
    :pswitch_4
    const-string v2, "\u7528\u6237\u53d6\u6d88"

    invoke-static {p0, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 48
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .end local v0    # "resp1":Lim/yixin/sdk/api/SendMessageToYX$Resp;
    :pswitch_5
    move-object v1, p1

    .line 57
    check-cast v1, Lim/yixin/sdk/api/SendAuthToYX$Resp;

    .line 58
    .local v1, "resp2":Lim/yixin/sdk/api/SendAuthToYX$Resp;
    iget v2, v1, Lim/yixin/sdk/api/SendAuthToYX$Resp;->errCode:I

    packed-switch v2, :pswitch_data_2

    :pswitch_6
    goto :goto_0

    .line 74
    :pswitch_7
    const-string v2, "\u7528\u6237\u62d2\u7edd"

    new-array v3, v5, [Ljava/lang/String;

    invoke-virtual {p0, v2, v3}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    .line 75
    invoke-virtual {p0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->finish()V

    goto :goto_0

    .line 60
    :pswitch_8
    sget-object v2, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->TAG:Ljava/lang/String;

    .line 61
    const-string v3, "YXEntryActivity YixinConstants.RESP_SEND_AUTH_TYPE ERR_OK"

    .line 60
    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 62
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u83b7\u53d6Code\u6210\u529f\uff0ccode="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v1, Lim/yixin/sdk/api/SendAuthToYX$Resp;->code:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/String;

    invoke-virtual {p0, v2, v3}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    .line 63
    iget-object v2, v1, Lim/yixin/sdk/api/SendAuthToYX$Resp;->code:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->getToken(Ljava/lang/String;)V

    goto :goto_0

    .line 66
    :pswitch_9
    const-string v2, "\u5931\u8d25"

    new-array v3, v5, [Ljava/lang/String;

    invoke-virtual {p0, v2, v3}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    .line 67
    invoke-virtual {p0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->finish()V

    goto :goto_0

    .line 70
    :pswitch_a
    const-string v2, "\u7528\u6237\u53d6\u6d88"

    new-array v3, v5, [Ljava/lang/String;

    invoke-virtual {p0, v2, v3}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->showMsg(Ljava/lang/String;[Ljava/lang/String;)V

    .line 71
    invoke-virtual {p0}, Lcom/pwrd/onesdk/demo/yixin/yxapi/YXEntryActivity;->finish()V

    goto :goto_0

    .line 34
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_5
    .end packed-switch

    .line 37
    :pswitch_data_1
    .packed-switch -0x3
        :pswitch_1
        :pswitch_4
        :pswitch_3
        :pswitch_2
    .end packed-switch

    .line 58
    :pswitch_data_2
    .packed-switch -0x4
        :pswitch_7
        :pswitch_6
        :pswitch_a
        :pswitch_9
        :pswitch_8
    .end packed-switch
.end method

.method public varargs showMsg(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 5
    .param p1, "apiName"    # Ljava/lang/String;
    .param p2, "m1"    # [Ljava/lang/String;

    .prologue
    .line 120
    new-instance v1, Ljava/lang/StringBuffer;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "------api:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-----"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 121
    .local v1, "sb":Ljava/lang/StringBuffer;
    array-length v3, p2

    const/4 v2, 0x0

    :goto_0
    if-lt v2, v3, :cond_0

    .line 125
    const-string v2, "YXEntryActivity"

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 126
    return-void

    .line 121
    :cond_0
    aget-object v0, p2, v2

    .line 122
    .local v0, "m":Ljava/lang/String;
    const-string v4, "\n"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 123
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 121
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method
