.class public Lcom/tencent/cos/xml/transfer/XmlSlimParser;
.super Ljava/lang/Object;
.source "XmlSlimParser.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseCompleteMultipartUploadResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;)V
    .locals 4
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 24
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 25
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v3, "UTF-8"

    invoke-interface {v2, p0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 26
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 28
    .local v0, "eventType":I
    :goto_0
    const/4 v3, 0x1

    if-eq v0, v3, :cond_4

    .line 29
    packed-switch v0, :pswitch_data_0

    .line 47
    :cond_0
    :goto_1
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 31
    :pswitch_0
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 32
    .local v1, "tagName":Ljava/lang/String;
    const-string v3, "Location"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 33
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 34
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;->location:Ljava/lang/String;

    goto :goto_1

    .line 35
    :cond_1
    const-string v3, "Bucket"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 36
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 37
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;->bucket:Ljava/lang/String;

    goto :goto_1

    .line 38
    :cond_2
    const-string v3, "Key"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 39
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 40
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;->key:Ljava/lang/String;

    goto :goto_1

    .line 41
    :cond_3
    const-string v3, "ETag"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 42
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 43
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CompleteMultipartUploadResult;->eTag:Ljava/lang/String;

    goto :goto_1

    .line 49
    .end local v1    # "tagName":Ljava/lang/String;
    :cond_4
    return-void

    .line 29
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public static parseError(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/CosError;)V
    .locals 4
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "error"    # Lcom/tencent/cos/xml/model/tag/CosError;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 169
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 170
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v3, "UTF-8"

    invoke-interface {v2, p0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 171
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 173
    .local v0, "eventType":I
    :goto_0
    const/4 v3, 0x1

    if-eq v0, v3, :cond_5

    .line 174
    packed-switch v0, :pswitch_data_0

    .line 195
    :cond_0
    :goto_1
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 176
    :pswitch_0
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 177
    .local v1, "tagName":Ljava/lang/String;
    const-string v3, "Code"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 178
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 179
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CosError;->code:Ljava/lang/String;

    goto :goto_1

    .line 180
    :cond_1
    const-string v3, "Message"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 181
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 182
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CosError;->message:Ljava/lang/String;

    goto :goto_1

    .line 183
    :cond_2
    const-string v3, "Resource"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 184
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 185
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CosError;->resource:Ljava/lang/String;

    goto :goto_1

    .line 186
    :cond_3
    const-string v3, "RequestId"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 187
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 188
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CosError;->requestId:Ljava/lang/String;

    goto :goto_1

    .line 189
    :cond_4
    const-string v3, "TraceId"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 190
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 191
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CosError;->traceId:Ljava/lang/String;

    goto :goto_1

    .line 197
    .end local v1    # "tagName":Ljava/lang/String;
    :cond_5
    return-void

    .line 174
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public static parseInitiateMultipartUploadResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;)V
    .locals 4
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 52
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 53
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v3, "UTF-8"

    invoke-interface {v2, p0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 54
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 56
    .local v0, "eventType":I
    :goto_0
    const/4 v3, 0x1

    if-eq v0, v3, :cond_3

    .line 57
    packed-switch v0, :pswitch_data_0

    .line 72
    :cond_0
    :goto_1
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 59
    :pswitch_0
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 60
    .local v1, "tagName":Ljava/lang/String;
    const-string v3, "Bucket"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 61
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 62
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;->bucket:Ljava/lang/String;

    goto :goto_1

    .line 63
    :cond_1
    const-string v3, "Key"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 64
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 65
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;->key:Ljava/lang/String;

    goto :goto_1

    .line 66
    :cond_2
    const-string v3, "UploadId"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 67
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 68
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/InitiateMultipartUpload;->uploadId:Ljava/lang/String;

    goto :goto_1

    .line 74
    .end local v1    # "tagName":Ljava/lang/String;
    :cond_3
    return-void

    .line 57
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public static parseListPartsResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/ListParts;)V
    .locals 7
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/ListParts;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 77
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v5

    .line 78
    .local v5, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v6, "UTF-8"

    invoke-interface {v5, p0, v6}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 79
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 81
    .local v0, "eventType":I
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->parts:Ljava/util/List;

    .line 82
    const/4 v2, 0x0

    .line 83
    .local v2, "owner":Lcom/tencent/cos/xml/model/tag/ListParts$Owner;
    const/4 v1, 0x0

    .line 84
    .local v1, "initiator":Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;
    const/4 v3, 0x0

    .line 85
    .local v3, "part":Lcom/tencent/cos/xml/model/tag/ListParts$Part;
    :goto_0
    const/4 v6, 0x1

    if-eq v0, v6, :cond_16

    .line 86
    packed-switch v0, :pswitch_data_0

    .line 164
    :cond_0
    :goto_1
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 88
    :pswitch_0
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 89
    .local v4, "tagName":Ljava/lang/String;
    const-string v6, "Bucket"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 90
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 91
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->bucket:Ljava/lang/String;

    goto :goto_1

    .line 92
    :cond_1
    const-string v6, "Encoding-type"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 93
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 94
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->encodingType:Ljava/lang/String;

    goto :goto_1

    .line 95
    :cond_2
    const-string v6, "Key"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 96
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 97
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->key:Ljava/lang/String;

    goto :goto_1

    .line 98
    :cond_3
    const-string v6, "UploadId"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 99
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 100
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->uploadId:Ljava/lang/String;

    goto :goto_1

    .line 101
    :cond_4
    const-string v6, "Owner"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 102
    new-instance v2, Lcom/tencent/cos/xml/model/tag/ListParts$Owner;

    .end local v2    # "owner":Lcom/tencent/cos/xml/model/tag/ListParts$Owner;
    invoke-direct {v2}, Lcom/tencent/cos/xml/model/tag/ListParts$Owner;-><init>()V

    .restart local v2    # "owner":Lcom/tencent/cos/xml/model/tag/ListParts$Owner;
    goto :goto_1

    .line 103
    :cond_5
    const-string v6, "Initiator"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 104
    new-instance v1, Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;

    .end local v1    # "initiator":Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;
    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;-><init>()V

    .restart local v1    # "initiator":Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;
    goto :goto_1

    .line 105
    :cond_6
    const-string v6, "ID"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 106
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 107
    if-eqz v2, :cond_7

    .line 108
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v2, Lcom/tencent/cos/xml/model/tag/ListParts$Owner;->id:Ljava/lang/String;

    goto :goto_1

    .line 109
    :cond_7
    if-eqz v1, :cond_0

    .line 110
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;->id:Ljava/lang/String;

    goto/16 :goto_1

    .line 112
    :cond_8
    const-string v6, "DisplayName"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_a

    .line 113
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 114
    if-eqz v2, :cond_9

    .line 115
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v2, Lcom/tencent/cos/xml/model/tag/ListParts$Owner;->disPlayName:Ljava/lang/String;

    goto/16 :goto_1

    .line 116
    :cond_9
    if-eqz v1, :cond_0

    .line 117
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;->disPlayName:Ljava/lang/String;

    goto/16 :goto_1

    .line 119
    :cond_a
    const-string v6, "PartNumberMarker"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_b

    .line 120
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 121
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->partNumberMarker:Ljava/lang/String;

    goto/16 :goto_1

    .line 122
    :cond_b
    const-string v6, "StorageClass"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_c

    .line 123
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 124
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->storageClass:Ljava/lang/String;

    goto/16 :goto_1

    .line 125
    :cond_c
    const-string v6, "NextPartNumberMarker"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_d

    .line 126
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 127
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->nextPartNumberMarker:Ljava/lang/String;

    goto/16 :goto_1

    .line 128
    :cond_d
    const-string v6, "MaxParts"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_e

    .line 129
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 130
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->maxParts:Ljava/lang/String;

    goto/16 :goto_1

    .line 131
    :cond_e
    const-string v6, "IsTruncated"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_f

    .line 132
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 133
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v6

    iput-boolean v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->isTruncated:Z

    goto/16 :goto_1

    .line 134
    :cond_f
    const-string v6, "Part"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_10

    .line 135
    new-instance v3, Lcom/tencent/cos/xml/model/tag/ListParts$Part;

    .end local v3    # "part":Lcom/tencent/cos/xml/model/tag/ListParts$Part;
    invoke-direct {v3}, Lcom/tencent/cos/xml/model/tag/ListParts$Part;-><init>()V

    .restart local v3    # "part":Lcom/tencent/cos/xml/model/tag/ListParts$Part;
    goto/16 :goto_1

    .line 136
    :cond_10
    const-string v6, "PartNumber"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_11

    .line 137
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 138
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->partNumber:Ljava/lang/String;

    goto/16 :goto_1

    .line 139
    :cond_11
    const-string v6, "LastModified"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_12

    .line 140
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 141
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->lastModified:Ljava/lang/String;

    goto/16 :goto_1

    .line 142
    :cond_12
    const-string v6, "ETag"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_13

    .line 143
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 144
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->eTag:Ljava/lang/String;

    goto/16 :goto_1

    .line 145
    :cond_13
    const-string v6, "Size"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 146
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 147
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lcom/tencent/cos/xml/model/tag/ListParts$Part;->size:Ljava/lang/String;

    goto/16 :goto_1

    .line 151
    .end local v4    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 152
    .restart local v4    # "tagName":Ljava/lang/String;
    const-string v6, "Owner"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_14

    .line 153
    iput-object v2, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->owner:Lcom/tencent/cos/xml/model/tag/ListParts$Owner;

    .line 154
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 155
    :cond_14
    const-string v6, "Initiator"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_15

    .line 156
    iput-object v1, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->initiator:Lcom/tencent/cos/xml/model/tag/ListParts$Initiator;

    .line 157
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 158
    :cond_15
    const-string v6, "Part"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 159
    iget-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListParts;->parts:Ljava/util/List;

    invoke-interface {v6, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 160
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 166
    .end local v4    # "tagName":Ljava/lang/String;
    :cond_16
    return-void

    .line 86
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
