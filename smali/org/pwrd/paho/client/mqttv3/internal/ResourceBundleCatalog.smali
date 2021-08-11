.class public Lorg/pwrd/paho/client/mqttv3/internal/ResourceBundleCatalog;
.super Lorg/pwrd/paho/client/mqttv3/internal/MessageCatalog;
.source "ResourceBundleCatalog.java"


# instance fields
.field private bundle:Ljava/util/ResourceBundle;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Lorg/pwrd/paho/client/mqttv3/internal/MessageCatalog;-><init>()V

    .line 27
    const-string v0, "org.pwrd.paho.client.mqttv3.internal.nls.messages"

    invoke-static {v0}, Ljava/util/ResourceBundle;->getBundle(Ljava/lang/String;)Ljava/util/ResourceBundle;

    move-result-object v0

    iput-object v0, p0, Lorg/pwrd/paho/client/mqttv3/internal/ResourceBundleCatalog;->bundle:Ljava/util/ResourceBundle;

    .line 28
    return-void
.end method


# virtual methods
.method protected getLocalizedMessage(I)Ljava/lang/String;
    .locals 3
    .param p1, "id"    # I

    .prologue
    .line 32
    :try_start_0
    iget-object v1, p0, Lorg/pwrd/paho/client/mqttv3/internal/ResourceBundleCatalog;->bundle:Ljava/util/ResourceBundle;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ResourceBundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/util/MissingResourceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 34
    :goto_0
    return-object v1

    .line 33
    :catch_0
    move-exception v0

    .line 34
    .local v0, "mre":Ljava/util/MissingResourceException;
    const-string v1, "MqttException"

    goto :goto_0
.end method
