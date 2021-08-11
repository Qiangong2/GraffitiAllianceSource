.class public Lplugins/ClipboardPlugin;
.super Ljava/lang/Object;
.source "ClipboardPlugin.java"


# static fields
.field public static clipboardMgr:Landroid/content/ClipboardManager;


# instance fields
.field private activity:Landroid/app/Activity;

.field private context:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const/4 v0, 0x0

    sput-object v0, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public Init(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 19
    iput-object p1, p0, Lplugins/ClipboardPlugin;->context:Landroid/content/Context;

    .line 20
    iput-object p2, p0, Lplugins/ClipboardPlugin;->activity:Landroid/app/Activity;

    .line 22
    const-string v0, "clipboard"

    invoke-virtual {p2, v0}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    sput-object v0, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    .line 23
    return-void
.end method

.method public copyTextToClipboard(Ljava/lang/String;)V
    .locals 2
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 27
    sget-object v1, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    if-eqz v1, :cond_0

    .line 28
    const-string v1, "data"

    invoke-static {v1, p1}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v0

    .line 29
    .local v0, "clipData":Landroid/content/ClipData;
    sget-object v1, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    invoke-virtual {v1, v0}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 31
    .end local v0    # "clipData":Landroid/content/ClipData;
    :cond_0
    return-void
.end method

.method public getTextFromClipboard()V
    .locals 3

    .prologue
    .line 35
    const-string v0, ""

    .line 37
    .local v0, "result":Ljava/lang/String;
    sget-object v1, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    if-eqz v1, :cond_0

    sget-object v1, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    invoke-virtual {v1}, Landroid/content/ClipboardManager;->hasPrimaryClip()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    .line 38
    invoke-virtual {v1}, Landroid/content/ClipboardManager;->getPrimaryClipDescription()Landroid/content/ClipDescription;

    move-result-object v1

    const-string v2, "text/plain"

    invoke-virtual {v1, v2}, Landroid/content/ClipDescription;->hasMimeType(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 39
    sget-object v1, Lplugins/ClipboardPlugin;->clipboardMgr:Landroid/content/ClipboardManager;

    invoke-virtual {v1}, Landroid/content/ClipboardManager;->getPrimaryClip()Landroid/content/ClipData;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/content/ClipData;->getItemAt(I)Landroid/content/ClipData$Item;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/ClipData$Item;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 42
    :cond_0
    const-string v1, "UIRoot"

    const-string v2, "StartServiceResult"

    invoke-static {v1, v2, v0}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    return-void
.end method
