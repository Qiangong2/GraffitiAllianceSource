.class public final Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;
.super Ljava/lang/Object;
.source "DiskLruCache.java"

# interfaces
.implements Ljava/io/Closeable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/toolbox/DiskLruCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "Snapshot"
.end annotation


# instance fields
.field private final ins:[Ljava/io/InputStream;

.field private final key:Ljava/lang/String;

.field private final sequenceNumber:J

.field final synthetic this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;


# direct methods
.method private constructor <init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;)V
    .locals 1
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "sequenceNumber"    # J
    .param p5, "ins"    # [Ljava/io/InputStream;

    .prologue
    .line 710
    iput-object p1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 711
    iput-object p2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->key:Ljava/lang/String;

    .line 712
    iput-wide p3, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->sequenceNumber:J

    .line 713
    iput-object p5, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    .line 714
    return-void
.end method

.method synthetic constructor <init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;)V
    .locals 1

    .prologue
    .line 710
    invoke-direct/range {p0 .. p5}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;-><init>(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;J[Ljava/io/InputStream;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 4

    .prologue
    .line 740
    iget-object v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-lt v1, v3, :cond_0

    .line 743
    return-void

    .line 740
    :cond_0
    aget-object v0, v2, v1

    .line 741
    .local v0, "in":Ljava/io/InputStream;
    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 740
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public edit()Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 722
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->this$0:Lcom/pwrd/android/volley/toolbox/DiskLruCache;

    iget-object v1, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->key:Ljava/lang/String;

    iget-wide v2, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->sequenceNumber:J

    invoke-static {v0, v1, v2, v3}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->access$5(Lcom/pwrd/android/volley/toolbox/DiskLruCache;Ljava/lang/String;J)Lcom/pwrd/android/volley/toolbox/DiskLruCache$Editor;

    move-result-object v0

    return-object v0
.end method

.method public getInputStream(I)Ljava/io/InputStream;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 729
    iget-object v0, p0, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->ins:[Ljava/io/InputStream;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 736
    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/toolbox/DiskLruCache$Snapshot;->getInputStream(I)Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lcom/pwrd/android/volley/toolbox/DiskLruCache;->access$6(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method