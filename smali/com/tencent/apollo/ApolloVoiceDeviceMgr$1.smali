.class final Lcom/tencent/apollo/ApolloVoiceDeviceMgr$1;
.super Landroid/content/BroadcastReceiver;
.source "ApolloVoiceDeviceMgr.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/apollo/ApolloVoiceDeviceMgr;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 271
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 276
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 278
    const-string v0, "android.bluetooth.profile.extra.STATE"

    invoke-virtual {p2, v0, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 280
    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 282
    invoke-static {v5}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$002(Z)Z

    .line 283
    const-string v1, "GCloudVoiceTag"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "bluetooth connect ,cur state is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 388
    :cond_0
    :goto_0
    return-void

    .line 285
    :cond_1
    if-nez v0, :cond_0

    .line 287
    invoke-static {v4}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$002(Z)Z

    .line 288
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$100()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 290
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/media/AudioManager;->stopBluetoothSco()V

    .line 291
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/media/AudioManager;->setBluetoothScoOn(Z)V

    .line 292
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceEngine;->StopBlueTooth()I

    .line 293
    invoke-static {v4}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$102(Z)Z

    .line 295
    :cond_2
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v1

    sget-boolean v2, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    .line 302
    const-string v1, "GCloudVoiceTag"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "bluetooth disconnect,cur state is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 305
    :cond_3
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.intent.action.HEADSET_PLUG"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 310
    const-string v0, "state"

    invoke-virtual {p2, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 312
    const-string v0, "state"

    const/4 v1, -0x1

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 313
    packed-switch v0, :pswitch_data_0

    .line 353
    :cond_4
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "BroadcastReceiver ACTION_HEADSET_PLUG onReceive bSetValue="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-boolean v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 354
    const-string v1, "framework"

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 317
    :pswitch_0
    const-string v0, "HeadSet Callback"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ACTION_HEADSET_PLUG Out! Mode  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$300()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 318
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$300()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 320
    invoke-static {v5}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->ApolloVoiceDeviceEnterVoipMode(I)V

    goto :goto_1

    .line 324
    :cond_5
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    if-ne v0, v5, :cond_4

    .line 326
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v0

    sget-boolean v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_1

    .line 333
    :pswitch_1
    const-string v0, "HeadSet Callback"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ACTION_HEADSET_PLUG In! The currVoip Mode is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$300()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 334
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$300()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 336
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->ApolloVoiceDeviceExitVoipMode()V

    goto :goto_1

    .line 340
    :cond_6
    sget-boolean v0, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    if-ne v0, v5, :cond_4

    .line 342
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    goto :goto_1

    .line 357
    :cond_7
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "android.media.ACTION_SCO_AUDIO_STATE_UPDATED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 359
    const-string v0, "android.media.extra.SCO_AUDIO_STATE"

    invoke-virtual {p2, v0, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 361
    const-string v1, "GCloudVoiceTag"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ApolloVoiceDeviceManager ::SCO cur state is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 363
    if-ne v0, v5, :cond_8

    .line 365
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/media/AudioManager;->setBluetoothScoOn(Z)V

    .line 366
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceEngine;->StartBlueTooth()I

    .line 367
    invoke-static {v5}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$102(Z)Z

    goto/16 :goto_0

    .line 369
    :cond_8
    if-nez v0, :cond_0

    .line 371
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/AudioManager;->stopBluetoothSco()V

    .line 372
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/media/AudioManager;->setBluetoothScoOn(Z)V

    .line 373
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$400()Z

    move-result v0

    if-nez v0, :cond_9

    .line 375
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$200()Landroid/media/AudioManager;

    move-result-object v0

    sget-boolean v1, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->mSpeakerphoneOn:Z

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->setSpeakerphoneOn(Z)V

    .line 378
    :cond_9
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$100()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 380
    invoke-static {v4}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$102(Z)Z

    .line 381
    invoke-static {v4}, Lcom/tencent/apollo/ApolloVoiceDeviceMgr;->access$002(Z)Z

    .line 382
    invoke-static {}, Lcom/tencent/apollo/ApolloVoiceEngine;->StopBlueTooth()I

    goto/16 :goto_0

    .line 313
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
