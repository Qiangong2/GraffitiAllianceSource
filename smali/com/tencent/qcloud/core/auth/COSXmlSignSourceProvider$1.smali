.class Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider$1;
.super Ljava/lang/Object;
.source "COSXmlSignSourceProvider.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;->queryStringForKeys(Ljava/net/URL;Ljava/util/Set;Ljava/util/Set;)Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;


# direct methods
.method constructor <init>(Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;)V
    .locals 0
    .param p1, "this$0"    # Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    .prologue
    .line 299
    iput-object p1, p0, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider$1;->this$0:Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 299
    check-cast p1, Ljava/lang/String;

    check-cast p2, Ljava/lang/String;

    invoke-virtual {p0, p1, p2}, Lcom/tencent/qcloud/core/auth/COSXmlSignSourceProvider$1;->compare(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public compare(Ljava/lang/String;Ljava/lang/String;)I
    .locals 1
    .param p1, "o1"    # Ljava/lang/String;
    .param p2, "o2"    # Ljava/lang/String;

    .prologue
    .line 302
    invoke-virtual {p1, p2}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    return v0
.end method
