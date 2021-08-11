.class final Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
.super Ljava/lang/Object;
.source "DiskLruCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/plus/DiskLruCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "Entry"
.end annotation


# instance fields
.field private currentEditor:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

.field private final key:Ljava/lang/String;

.field private final lengths:[J

.field private persistent:Z

.field private readable:Z

.field private sequenceNumber:J

.field final synthetic this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;


# direct methods
.method private constructor <init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Ljava/lang/String;)V
    .locals 1
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 957
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 958
    iput-object p2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->key:Ljava/lang/String;

    .line 959
    invoke-static {p1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$9(Lcom/pwrd/android/volley/plus/DiskLruCache;)I

    move-result v0

    new-array v0, v0, [J

    iput-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->lengths:[J

    .line 960
    return-void
.end method

.method synthetic constructor <init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Ljava/lang/String;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)V
    .locals 0

    .prologue
    .line 957
    invoke-direct {p0, p1, p2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
    .locals 1

    .prologue
    .line 948
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->currentEditor:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    return-object v0
.end method

.method static synthetic access$1(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z
    .locals 1

    .prologue
    .line 943
    iget-boolean v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->readable:Z

    return v0
.end method

.method static synthetic access$10(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)J
    .locals 2

    .prologue
    .line 955
    iget-wide v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->sequenceNumber:J

    return-wide v0
.end method

.method static synthetic access$11(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;J)V
    .locals 1

    .prologue
    .line 955
    iput-wide p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->sequenceNumber:J

    return-void
.end method

.method static synthetic access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 933
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->key:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V
    .locals 0

    .prologue
    .line 943
    iput-boolean p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->readable:Z

    return-void
.end method

.method static synthetic access$5(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V
    .locals 0

    .prologue
    .line 948
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->currentEditor:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    return-void
.end method

.method static synthetic access$6(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Z)V
    .locals 0

    .prologue
    .line 950
    iput-boolean p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->persistent:Z

    return-void
.end method

.method static synthetic access$7(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;[Ljava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 973
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->setLengths([Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$8(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z
    .locals 1

    .prologue
    .line 950
    iget-boolean v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->persistent:Z

    return v0
.end method

.method static synthetic access$9(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)[J
    .locals 1

    .prologue
    .line 938
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->lengths:[J

    return-object v0
.end method

.method private invalidLengths([Ljava/lang/String;)Ljava/io/IOException;
    .locals 3
    .param p1, "strings"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 988
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "unexpected journal line: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private setLengths([Ljava/lang/String;)V
    .locals 6
    .param p1, "strings"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 974
    array-length v2, p1

    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-static {v3}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$9(Lcom/pwrd/android/volley/plus/DiskLruCache;)I

    move-result v3

    if-eq v2, v3, :cond_0

    .line 975
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->invalidLengths([Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v2

    throw v2

    .line 979
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    :try_start_0
    array-length v2, p1

    if-lt v1, v2, :cond_1

    .line 985
    return-void

    .line 980
    :cond_1
    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->lengths:[J

    aget-object v3, p1, v1

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    aput-wide v4, v2, v1
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 979
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 982
    :catch_0
    move-exception v0

    .line 983
    .local v0, "e":Ljava/lang/NumberFormatException;
    invoke-direct {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->invalidLengths([Ljava/lang/String;)Ljava/io/IOException;

    move-result-object v2

    throw v2
.end method


# virtual methods
.method public getCleanFile(I)Ljava/io/File;
    .locals 4
    .param p1, "i"    # I

    .prologue
    .line 992
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-static {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$10(Lcom/pwrd/android/volley/plus/DiskLruCache;)Ljava/io/File;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->key:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v0
.end method

.method public getDirtyFile(I)Ljava/io/File;
    .locals 4
    .param p1, "i"    # I

    .prologue
    .line 996
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-static {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$10(Lcom/pwrd/android/volley/plus/DiskLruCache;)Ljava/io/File;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->key:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".tmp"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    return-object v0
.end method

.method public getLengths()Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 963
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 964
    .local v0, "result":Ljava/lang/StringBuilder;
    iget-object v4, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->lengths:[J

    array-length v5, v4

    const/4 v1, 0x0

    :goto_0
    if-lt v1, v5, :cond_0

    .line 967
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 964
    :cond_0
    aget-wide v2, v4, v1

    .line 965
    .local v2, "size":J
    const/16 v6, 0x20

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 964
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method
