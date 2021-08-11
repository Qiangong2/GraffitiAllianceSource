.class Lcom/wanmei/push/receiver/MiPushReceiver$1;
.super Lcom/pwrd/google/gson/reflect/TypeToken;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wanmei/push/receiver/MiPushReceiver;->assembleValueFromPushMessage(Ljava/lang/String;)Lcom/wanmei/push/bean/PushMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/pwrd/google/gson/reflect/TypeToken",
        "<",
        "Lcom/wanmei/push/bean/PushMessage;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/wanmei/push/receiver/MiPushReceiver;


# direct methods
.method constructor <init>(Lcom/wanmei/push/receiver/MiPushReceiver;)V
    .locals 0

    .prologue
    iput-object p1, p0, Lcom/wanmei/push/receiver/MiPushReceiver$1;->this$0:Lcom/wanmei/push/receiver/MiPushReceiver;

    invoke-direct {p0}, Lcom/pwrd/google/gson/reflect/TypeToken;-><init>()V

    return-void
.end method
