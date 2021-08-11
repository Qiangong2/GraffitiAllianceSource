.class public Lcom/wanmei/sdk/core/config/PayConfig;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/wanmei/sdk/core/config/NeedValidate;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public validate()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/wanmei/sdk/core/config/ConfigFileException;
        }
    .end annotation

    return-void
.end method
