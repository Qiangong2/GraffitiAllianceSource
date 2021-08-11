.class Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;
.super Ljava/io/FilterOutputStream;
.source "DiskLruCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FaultHidingOutputStream"
.end annotation


# instance fields
.field final synthetic this$1:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;


# direct methods
.method private constructor <init>(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Ljava/io/OutputStream;)V
    .locals 0
    .param p2, "out"    # Ljava/io/OutputStream;

    .prologue
    .line 890
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    .line 891
    invoke-direct {p0, p2}, Ljava/io/FilterOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 892
    return-void
.end method

.method synthetic constructor <init>(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Ljava/io/OutputStream;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;)V
    .locals 0

    .prologue
    .line 890
    invoke-direct {p0, p1, p2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Ljava/io/OutputStream;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 3

    .prologue
    .line 915
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 919
    :goto_0
    return-void

    .line 916
    :catch_0
    move-exception v0

    .line 917
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    goto :goto_0
.end method

.method public flush()V
    .locals 3

    .prologue
    .line 924
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 928
    :goto_0
    return-void

    .line 925
    :catch_0
    move-exception v0

    .line 926
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    goto :goto_0
.end method

.method public write(I)V
    .locals 3
    .param p1, "oneByte"    # I

    .prologue
    .line 897
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1}, Ljava/io/OutputStream;->write(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 901
    :goto_0
    return-void

    .line 898
    :catch_0
    move-exception v0

    .line 899
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    goto :goto_0
.end method

.method public write([BII)V
    .locals 3
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 906
    :try_start_0
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->out:Ljava/io/OutputStream;

    invoke-virtual {v1, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 910
    :goto_0
    return-void

    .line 907
    :catch_0
    move-exception v0

    .line 908
    .local v0, "e":Ljava/io/IOException;
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;->this$1:Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    goto :goto_0
.end method
