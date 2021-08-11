.class public final Lcom/wanmei/push/db/c;
.super Lcom/j256/ormlite/android/apptools/OrmLiteConfigUtil;


# static fields
.field public static a:[Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Class;

    const/4 v1, 0x0

    const-class v2, Lcom/wanmei/push/bean/Notice;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-class v2, Lcom/wanmei/push/bean/AppState;

    aput-object v2, v0, v1

    sput-object v0, Lcom/wanmei/push/db/c;->a:[Ljava/lang/Class;

    return-void
.end method
