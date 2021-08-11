.class public Lcom/tencent/cos/xml/model/tag/Delete;
.super Ljava/lang/Object;
.source "Delete.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;
    }
.end annotation


# instance fields
.field public deleteObjects:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/tencent/cos/xml/model/tag/Delete$DeleteObject;",
            ">;"
        }
    .end annotation
.end field

.field public quiet:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
