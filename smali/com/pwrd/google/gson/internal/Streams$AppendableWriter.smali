.class final Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;
.super Ljava/io/Writer;
.source "Streams.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/pwrd/google/gson/internal/Streams;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "AppendableWriter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;
    }
.end annotation


# instance fields
.field private final appendable:Ljava/lang/Appendable;

.field private final currentWrite:Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;


# direct methods
.method private constructor <init>(Ljava/lang/Appendable;)V
    .locals 1
    .param p1, "appendable"    # Ljava/lang/Appendable;

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/io/Writer;-><init>()V

    .line 87
    new-instance v0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;

    invoke-direct {v0}, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;-><init>()V

    iput-object v0, p0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;->currentWrite:Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;

    .line 90
    iput-object p1, p0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;->appendable:Ljava/lang/Appendable;

    .line 91
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Appendable;Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;)V
    .locals 0

    .prologue
    .line 89
    invoke-direct {p0, p1}, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;-><init>(Ljava/lang/Appendable;)V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 0

    .prologue
    .line 103
    return-void
.end method

.method public flush()V
    .locals 0

    .prologue
    .line 102
    return-void
.end method

.method public write(I)V
    .locals 2
    .param p1, "i"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 99
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;->appendable:Ljava/lang/Appendable;

    int-to-char v1, p1

    invoke-interface {v0, v1}, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;

    .line 100
    return-void
.end method

.method public write([CII)V
    .locals 3
    .param p1, "chars"    # [C
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 94
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;->currentWrite:Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;

    iput-object p1, v0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;->chars:[C

    .line 95
    iget-object v0, p0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;->appendable:Ljava/lang/Appendable;

    iget-object v1, p0, Lcom/pwrd/google/gson/internal/Streams$AppendableWriter;->currentWrite:Lcom/pwrd/google/gson/internal/Streams$AppendableWriter$CurrentWrite;

    add-int v2, p2, p3

    invoke-interface {v0, v1, p2, v2}, Ljava/lang/Appendable;->append(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;

    .line 96
    return-void
.end method