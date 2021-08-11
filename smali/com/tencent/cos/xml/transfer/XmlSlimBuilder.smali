.class public Lcom/tencent/cos/xml/transfer/XmlSlimBuilder;
.super Ljava/lang/Object;
.source "XmlSlimBuilder.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static addElement(Lorg/xmlpull/v1/XmlSerializer;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "xmlSerializer"    # Lorg/xmlpull/v1/XmlSerializer;
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 46
    if-eqz p2, :cond_0

    .line 47
    const-string v0, ""

    invoke-interface {p0, v0, p1}, Lorg/xmlpull/v1/XmlSerializer;->startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 48
    invoke-interface {p0, p2}, Lorg/xmlpull/v1/XmlSerializer;->text(Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 49
    const-string v0, ""

    invoke-interface {p0, v0, p1}, Lorg/xmlpull/v1/XmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 51
    :cond_0
    return-void
.end method

.method public static buildCompleteMultipartUpload(Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;)Ljava/lang/String;
    .locals 7
    .param p0, "completeMultipartUpload"    # Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/xmlpull/v1/XmlPullParserException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 20
    if-nez p0, :cond_0

    .line 42
    :goto_0
    return-object v4

    .line 22
    :cond_0
    new-instance v1, Ljava/io/StringWriter;

    invoke-direct {v1}, Ljava/io/StringWriter;-><init>()V

    .line 23
    .local v1, "xmlContent":Ljava/io/StringWriter;
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v2

    .line 24
    .local v2, "xmlPullParserFactory":Lorg/xmlpull/v1/XmlPullParserFactory;
    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserFactory;->newSerializer()Lorg/xmlpull/v1/XmlSerializer;

    move-result-object v3

    .line 25
    .local v3, "xmlSerializer":Lorg/xmlpull/v1/XmlSerializer;
    invoke-interface {v3, v1}, Lorg/xmlpull/v1/XmlSerializer;->setOutput(Ljava/io/Writer;)V

    .line 26
    const-string v5, "http://xmlpull.org/v1/doc/features.html#indent-output"

    const/4 v6, 0x1

    invoke-interface {v3, v5, v6}, Lorg/xmlpull/v1/XmlSerializer;->setFeature(Ljava/lang/String;Z)V

    .line 27
    const-string v5, "UTF-8"

    invoke-interface {v3, v5, v4}, Lorg/xmlpull/v1/XmlSerializer;->startDocument(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 29
    const-string v4, ""

    const-string v5, "CompleteMultipartUpload"

    invoke-interface {v3, v4, v5}, Lorg/xmlpull/v1/XmlSerializer;->startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 30
    iget-object v4, p0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;->parts:Ljava/util/List;

    if-eqz v4, :cond_2

    .line 31
    iget-object v4, p0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload;->parts:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_1
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;

    .line 32
    .local v0, "part":Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;
    if-eqz v0, :cond_1

    .line 33
    const-string v5, ""

    const-string v6, "Part"

    invoke-interface {v3, v5, v6}, Lorg/xmlpull/v1/XmlSerializer;->startTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 34
    const-string v5, "PartNumber"

    iget v6, v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;->partNumber:I

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v3, v5, v6}, Lcom/tencent/cos/xml/transfer/XmlSlimBuilder;->addElement(Lorg/xmlpull/v1/XmlSerializer;Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    const-string v5, "ETag"

    iget-object v6, v0, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;->eTag:Ljava/lang/String;

    invoke-static {v3, v5, v6}, Lcom/tencent/cos/xml/transfer/XmlSlimBuilder;->addElement(Lorg/xmlpull/v1/XmlSerializer;Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    const-string v5, ""

    const-string v6, "Part"

    invoke-interface {v3, v5, v6}, Lorg/xmlpull/v1/XmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    goto :goto_1

    .line 39
    .end local v0    # "part":Lcom/tencent/cos/xml/model/tag/CompleteMultipartUpload$Part;
    :cond_2
    const-string v4, ""

    const-string v5, "CompleteMultipartUpload"

    invoke-interface {v3, v4, v5}, Lorg/xmlpull/v1/XmlSerializer;->endTag(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;

    .line 41
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlSerializer;->endDocument()V

    .line 42
    invoke-virtual {v1}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/tencent/cos/xml/transfer/XmlSlimBuilder;->removeXMLHeader(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method private static removeXMLHeader(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "xmlContent"    # Ljava/lang/String;

    .prologue
    .line 54
    if-eqz p0, :cond_0

    .line 55
    const-string v1, "<?xml"

    invoke-virtual {p0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 56
    const-string v1, "?>"

    invoke-virtual {p0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 57
    .local v0, "index":I
    add-int/lit8 v1, v0, 0x2

    invoke-virtual {p0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .line 60
    .end local v0    # "index":I
    :cond_0
    return-object p0
.end method
