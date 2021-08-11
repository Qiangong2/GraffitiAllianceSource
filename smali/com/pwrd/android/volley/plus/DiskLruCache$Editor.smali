.class public final Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;
.super Ljava/lang/Object;
.source "DiskLruCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/android/volley/plus/DiskLruCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "Editor"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;
    }
.end annotation


# instance fields
.field private final entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

.field private hasErrors:Z

.field final synthetic this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;


# direct methods
.method private constructor <init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)V
    .locals 0
    .param p2, "entry"    # Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .prologue
    .line 810
    iput-object p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 811
    iput-object p2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    .line 812
    return-void
.end method

.method synthetic constructor <init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)V
    .locals 0

    .prologue
    .line 810
    invoke-direct {p0, p1, p2}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)V

    return-void
.end method

.method static synthetic access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V
    .locals 0

    .prologue
    .line 808
    iput-boolean p1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->hasErrors:Z

    return-void
.end method

.method static synthetic access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;)Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;
    .locals 1

    .prologue
    .line 807
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    return-object v0
.end method


# virtual methods
.method public abort()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 886
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    const/4 v1, 0x0

    invoke-static {v0, p0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    .line 887
    return-void
.end method

.method public commit()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 873
    iget-boolean v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->hasErrors:Z

    if-eqz v0, :cond_0

    .line 874
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    const/4 v1, 0x0

    invoke-static {v0, p0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    .line 875
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    invoke-static {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$2(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->remove(Ljava/lang/String;)Z

    .line 879
    :goto_0
    return-void

    .line 877
    :cond_0
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    const/4 v1, 0x1

    invoke-static {v0, p0, v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$8(Lcom/pwrd/android/volley/plus/DiskLruCache;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Z)V

    goto :goto_0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 2
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 835
    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->newInputStream(I)Ljava/io/InputStream;

    move-result-object v0

    .line 836
    .local v0, "in":Ljava/io/InputStream;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$6(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public newInputStream(I)Ljava/io/InputStream;
    .locals 3
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 819
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    monitor-enter v1

    .line 820
    :try_start_0
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v0

    if-eq v0, p0, :cond_0

    .line 821
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 819
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 823
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$1(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 824
    monitor-exit v1

    const/4 v0, 0x0

    .line 826
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v2, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    invoke-virtual {v2, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getCleanFile(I)Ljava/io/File;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public newOutputStream(I)Ljava/io/OutputStream;
    .locals 4
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 847
    iget-object v1, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->this$0:Lcom/pwrd/android/volley/plus/DiskLruCache;

    monitor-enter v1

    .line 848
    :try_start_0
    iget-object v0, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->access$0(Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;)Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;

    move-result-object v0

    if-eq v0, p0, :cond_0

    .line 849
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 847
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 851
    :cond_0
    :try_start_1
    new-instance v0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;

    new-instance v2, Ljava/io/FileOutputStream;

    iget-object v3, p0, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->entry:Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;

    invoke-virtual {v3, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Entry;->getDirtyFile(I)Ljava/io/File;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    const/4 v3, 0x0

    invoke-direct {v0, p0, v2, v3}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;-><init>(Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;Ljava/io/OutputStream;Lcom/pwrd/android/volley/plus/DiskLruCache$Editor$FaultHidingOutputStream;)V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v0
.end method

.method public set(ILjava/lang/String;)V
    .locals 4
    .param p1, "index"    # I
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 859
    const/4 v0, 0x0

    .line 861
    .local v0, "writer":Ljava/io/Writer;
    :try_start_0
    new-instance v1, Ljava/io/OutputStreamWriter;

    invoke-virtual {p0, p1}, Lcom/pwrd/android/volley/plus/DiskLruCache$Editor;->newOutputStream(I)Ljava/io/OutputStream;

    move-result-object v2

    invoke-static {}, Lcom/pwrd/android/volley/plus/DiskLruCache;->access$7()Ljava/nio/charset/Charset;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 862
    .end local v0    # "writer":Ljava/io/Writer;
    .local v1, "writer":Ljava/io/Writer;
    :try_start_1
    invoke-virtual {v1, p2}, Ljava/io/Writer;->write(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 864
    invoke-static {v1}, Lcom/pwrd/android/volley/plus/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 866
    return-void

    .line 863
    .end local v1    # "writer":Ljava/io/Writer;
    .restart local v0    # "writer":Ljava/io/Writer;
    :catchall_0
    move-exception v2

    .line 864
    :goto_0
    invoke-static {v0}, Lcom/pwrd/android/volley/plus/DiskLruCache;->closeQuietly(Ljava/io/Closeable;)V

    .line 865
    throw v2

    .line 863
    .end local v0    # "writer":Ljava/io/Writer;
    .restart local v1    # "writer":Ljava/io/Writer;
    :catchall_1
    move-exception v2

    move-object v0, v1

    .end local v1    # "writer":Ljava/io/Writer;
    .restart local v0    # "writer":Ljava/io/Writer;
    goto :goto_0
.end method
