.class public final Lcom/wanmei/sdk/core/net/DownloadParams;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/wanmei/sdk/core/net/DownloadParams$1;,
        Lcom/wanmei/sdk/core/net/DownloadParams$Mode;
    }
.end annotation


# static fields
.field protected static a:Ljava/lang/String;

.field protected static b:Ljava/lang/String;

.field protected static c:Ljava/lang/String;

.field private static d:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

.field private static e:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->online:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->d:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    return-void
.end method

.method public static a()V
    .locals 2

    sget-object v0, Lcom/wanmei/sdk/core/net/DownloadParams$1;->a:[I

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams;->d:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    invoke-virtual {v1}, Lcom/wanmei/sdk/core/net/DownloadParams$Mode;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    const-string v0, "https://apidev.laohu.com/sdkapi"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->e:Ljava/lang/String;

    const-string v0, "http://faq.csh.laohu.com/faq"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->a:Ljava/lang/String;

    const-string v0, "queue.csh.laohu.com"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->b:Ljava/lang/String;

    const-string v0, "36101"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->c:Ljava/lang/String;

    goto :goto_0

    :pswitch_1
    const-string v0, "http://testapidev.laohu.com/sdkapi"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->e:Ljava/lang/String;

    const-string v0, "http://faq.csh.laohu.com/faq"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->a:Ljava/lang/String;

    const-string v0, "queue.csh.laohu.com"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->b:Ljava/lang/String;

    const-string v0, "36101"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->c:Ljava/lang/String;

    goto :goto_0

    :pswitch_2
    const-string v0, "http://apidev.laohu.com/sdkapi/test"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->e:Ljava/lang/String;

    const-string v0, "http://faq.csh.laohu.com/faq"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->a:Ljava/lang/String;

    const-string v0, "queue.csh.laohu.com"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->b:Ljava/lang/String;

    const-string v0, "36101"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->c:Ljava/lang/String;

    goto :goto_0

    :pswitch_3
    const-string v0, "http://testapidev.laohu.com/sdkapi/test"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->e:Ljava/lang/String;

    const-string v0, "http://faq.csh.laohu.com/faq"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->a:Ljava/lang/String;

    const-string v0, "queue.csh.laohu.com"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->b:Ljava/lang/String;

    const-string v0, "36101"

    sput-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->c:Ljava/lang/String;

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static a(Lcom/wanmei/sdk/core/net/DownloadParams$Mode;)V
    .locals 0

    sput-object p0, Lcom/wanmei/sdk/core/net/DownloadParams;->d:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    return-void
.end method

.method public static b()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/user/login"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static c()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/wanmei/sdk/core/net/DownloadParams;->e:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/bill/preBilling"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static d()Lcom/wanmei/sdk/core/net/DownloadParams$Mode;
    .locals 1

    sget-object v0, Lcom/wanmei/sdk/core/net/DownloadParams;->d:Lcom/wanmei/sdk/core/net/DownloadParams$Mode;

    return-object v0
.end method
