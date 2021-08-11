.class public Lcom/tencent/cos/xml/transfer/XmlParser;
.super Lcom/tencent/cos/xml/transfer/XmlSlimParser;
.source "XmlParser.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/tencent/cos/xml/transfer/XmlSlimParser;-><init>()V

    return-void
.end method

.method public static parseAccessControlPolicy(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/AccessControlPolicy;)V
    .locals 8
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/AccessControlPolicy;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 175
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v5

    .line 176
    .local v5, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v6, "UTF-8"

    invoke-interface {v5, p0, v6}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 177
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 179
    .local v0, "eventType":I
    const/4 v3, 0x0

    .line 180
    .local v3, "owner":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;
    new-instance v6, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$AccessControlList;

    invoke-direct {v6}, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$AccessControlList;-><init>()V

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy;->accessControlList:Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$AccessControlList;

    .line 181
    iget-object v6, p1, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy;->accessControlList:Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$AccessControlList;

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    iput-object v7, v6, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$AccessControlList;->grants:Ljava/util/List;

    .line 182
    const/4 v1, 0x0

    .line 183
    .local v1, "grant":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grant;
    const/4 v2, 0x0

    .line 184
    .local v2, "grantee":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;
    :goto_0
    const/4 v6, 0x1

    if-eq v0, v6, :cond_a

    .line 185
    packed-switch v0, :pswitch_data_0

    .line 227
    :cond_0
    :goto_1
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 187
    :pswitch_0
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 188
    .local v4, "tagName":Ljava/lang/String;
    const-string v6, "Owner"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 189
    new-instance v3, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;

    .end local v3    # "owner":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;
    invoke-direct {v3}, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;-><init>()V

    .restart local v3    # "owner":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;
    goto :goto_1

    .line 190
    :cond_1
    const-string v6, "ID"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 191
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 192
    if-eqz v3, :cond_2

    .line 193
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;->id:Ljava/lang/String;

    goto :goto_1

    .line 194
    :cond_2
    if-eqz v2, :cond_0

    .line 195
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v2, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;->id:Ljava/lang/String;

    goto :goto_1

    .line 197
    :cond_3
    const-string v6, "DisplayName"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 198
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 199
    if-eqz v3, :cond_4

    .line 200
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;->displayName:Ljava/lang/String;

    goto :goto_1

    .line 201
    :cond_4
    if-eqz v2, :cond_0

    .line 202
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v2, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;->displayName:Ljava/lang/String;

    goto :goto_1

    .line 204
    :cond_5
    const-string v6, "Grant"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 205
    new-instance v1, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grant;

    .end local v1    # "grant":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grant;
    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grant;-><init>()V

    .restart local v1    # "grant":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grant;
    goto :goto_1

    .line 206
    :cond_6
    const-string v6, "Grantee"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 207
    new-instance v2, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;

    .end local v2    # "grantee":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;
    invoke-direct {v2}, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;-><init>()V

    .restart local v2    # "grantee":Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;
    goto :goto_1

    .line 208
    :cond_7
    const-string v6, "Permission"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 209
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 210
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grant;->permission:Ljava/lang/String;

    goto :goto_1

    .line 214
    .end local v4    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 215
    .restart local v4    # "tagName":Ljava/lang/String;
    const-string v6, "Owner"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 216
    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy;->owner:Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Owner;

    .line 217
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 218
    :cond_8
    const-string v6, "Grant"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 219
    iget-object v6, p1, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy;->accessControlList:Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$AccessControlList;

    iget-object v6, v6, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$AccessControlList;->grants:Ljava/util/List;

    invoke-interface {v6, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 220
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 221
    :cond_9
    const-string v6, "Grantee"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 222
    iput-object v2, v1, Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grant;->grantee:Lcom/tencent/cos/xml/model/tag/AccessControlPolicy$Grantee;

    .line 223
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 229
    .end local v4    # "tagName":Ljava/lang/String;
    :cond_a
    return-void

    .line 185
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseCORSConfiguration(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/CORSConfiguration;)V
    .locals 6
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/CORSConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 232
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v3

    .line 233
    .local v3, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v4, "UTF-8"

    invoke-interface {v3, p0, v4}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 234
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 236
    .local v1, "eventType":I
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p1, Lcom/tencent/cos/xml/model/tag/CORSConfiguration;->corsRules:Ljava/util/List;

    .line 237
    const/4 v0, 0x0

    .line 238
    .local v0, "corsRule":Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;
    :goto_0
    const/4 v4, 0x1

    if-eq v1, v4, :cond_a

    .line 239
    packed-switch v1, :pswitch_data_0

    .line 281
    :cond_0
    :goto_1
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 241
    :pswitch_0
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 242
    .local v2, "tagName":Ljava/lang/String;
    const-string v4, "CORSRule"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 243
    new-instance v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;

    .end local v0    # "corsRule":Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;
    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;-><init>()V

    .restart local v0    # "corsRule":Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;
    goto :goto_1

    .line 244
    :cond_1
    const-string v4, "ID"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 245
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 246
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->id:Ljava/lang/String;

    goto :goto_1

    .line 247
    :cond_2
    const-string v4, "AllowedOrigin"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 248
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 249
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->allowedOrigin:Ljava/lang/String;

    goto :goto_1

    .line 250
    :cond_3
    const-string v4, "AllowedMethod"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 251
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 252
    iget-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->allowedMethod:Ljava/util/List;

    if-nez v4, :cond_4

    .line 253
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->allowedMethod:Ljava/util/List;

    .line 255
    :cond_4
    iget-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->allowedMethod:Ljava/util/List;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 256
    :cond_5
    const-string v4, "AllowedHeader"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 257
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 258
    iget-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->allowedHeader:Ljava/util/List;

    if-nez v4, :cond_6

    .line 259
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->allowedHeader:Ljava/util/List;

    .line 261
    :cond_6
    iget-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->allowedHeader:Ljava/util/List;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 262
    :cond_7
    const-string v4, "ExposeHeader"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 263
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 264
    iget-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->exposeHeader:Ljava/util/List;

    if-nez v4, :cond_8

    .line 265
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->exposeHeader:Ljava/util/List;

    .line 267
    :cond_8
    iget-object v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->exposeHeader:Ljava/util/List;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_1

    .line 268
    :cond_9
    const-string v4, "MaxAgeSeconds"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 269
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 270
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    iput v4, v0, Lcom/tencent/cos/xml/model/tag/CORSConfiguration$CORSRule;->maxAgeSeconds:I

    goto/16 :goto_1

    .line 274
    .end local v2    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 275
    .restart local v2    # "tagName":Ljava/lang/String;
    const-string v4, "CORSRule"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 276
    iget-object v4, p1, Lcom/tencent/cos/xml/model/tag/CORSConfiguration;->corsRules:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 277
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 283
    .end local v2    # "tagName":Ljava/lang/String;
    :cond_a
    return-void

    .line 239
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseCopyObjectResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/CopyObject;)V
    .locals 4
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/CopyObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 654
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 655
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v3, "UTF-8"

    invoke-interface {v2, p0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 656
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 658
    .local v0, "eventType":I
    :goto_0
    const/4 v3, 0x1

    if-eq v0, v3, :cond_2

    .line 659
    packed-switch v0, :pswitch_data_0

    .line 671
    :cond_0
    :goto_1
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 661
    :pswitch_0
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 662
    .local v1, "tagName":Ljava/lang/String;
    const-string v3, "ETag"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 663
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 664
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CopyObject;->eTag:Ljava/lang/String;

    goto :goto_1

    .line 665
    :cond_1
    const-string v3, "LastModified"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 666
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 667
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CopyObject;->lastModified:Ljava/lang/String;

    goto :goto_1

    .line 673
    .end local v1    # "tagName":Ljava/lang/String;
    :cond_2
    return-void

    .line 659
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public static parseCopyPartResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/CopyPart;)V
    .locals 4
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/CopyPart;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 676
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 677
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v3, "UTF-8"

    invoke-interface {v2, p0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 678
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 680
    .local v0, "eventType":I
    :goto_0
    const/4 v3, 0x1

    if-eq v0, v3, :cond_2

    .line 681
    packed-switch v0, :pswitch_data_0

    .line 693
    :cond_0
    :goto_1
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 683
    :pswitch_0
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 684
    .local v1, "tagName":Ljava/lang/String;
    const-string v3, "ETag"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 685
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 686
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CopyPart;->eTag:Ljava/lang/String;

    goto :goto_1

    .line 687
    :cond_1
    const-string v3, "LastModified"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 688
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 689
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/CopyPart;->lastModified:Ljava/lang/String;

    goto :goto_1

    .line 695
    .end local v1    # "tagName":Ljava/lang/String;
    :cond_2
    return-void

    .line 681
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public static parseDeleteResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/DeleteResult;)V
    .locals 6
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/DeleteResult;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 597
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v4

    .line 598
    .local v4, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v5, "UTF-8"

    invoke-interface {v4, p0, v5}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 599
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2

    .line 601
    .local v2, "eventType":I
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/DeleteResult;->errorList:Ljava/util/List;

    .line 602
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/DeleteResult;->deletedList:Ljava/util/List;

    .line 603
    const/4 v0, 0x0

    .line 604
    .local v0, "deleted":Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;
    const/4 v1, 0x0

    .line 605
    .local v1, "error":Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;
    :goto_0
    const/4 v5, 0x1

    if-eq v2, v5, :cond_a

    .line 606
    packed-switch v2, :pswitch_data_0

    .line 649
    :cond_0
    :goto_1
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    goto :goto_0

    .line 608
    :pswitch_0
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 609
    .local v3, "tagName":Ljava/lang/String;
    const-string v5, "Deleted"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 610
    new-instance v0, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;

    .end local v0    # "deleted":Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;
    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;-><init>()V

    .restart local v0    # "deleted":Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;
    goto :goto_1

    .line 611
    :cond_1
    const-string v5, "Error"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 612
    new-instance v1, Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;

    .end local v1    # "error":Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;
    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;-><init>()V

    .restart local v1    # "error":Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;
    goto :goto_1

    .line 613
    :cond_2
    const-string v5, "Key"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 614
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 615
    if-eqz v0, :cond_3

    .line 616
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v0, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;->key:Ljava/lang/String;

    goto :goto_1

    .line 617
    :cond_3
    if-eqz v1, :cond_0

    .line 618
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;->key:Ljava/lang/String;

    goto :goto_1

    .line 620
    :cond_4
    const-string v5, "VersionId"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 621
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 622
    if-eqz v0, :cond_5

    .line 623
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v0, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;->versionId:Ljava/lang/String;

    goto :goto_1

    .line 624
    :cond_5
    if-eqz v1, :cond_0

    .line 625
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;->versionId:Ljava/lang/String;

    goto :goto_1

    .line 627
    :cond_6
    const-string v5, "DeleteMarker"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 628
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 629
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v5

    iput-boolean v5, v0, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;->deleteMarker:Z

    goto :goto_1

    .line 630
    :cond_7
    const-string v5, "DeleteMarkerVersionId"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 631
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 632
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v0, Lcom/tencent/cos/xml/model/tag/DeleteResult$Deleted;->deleteMarkerVersionId:Ljava/lang/String;

    goto/16 :goto_1

    .line 633
    :cond_8
    const-string v5, "Message"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 634
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 635
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/tencent/cos/xml/model/tag/DeleteResult$Error;->message:Ljava/lang/String;

    goto/16 :goto_1

    .line 639
    .end local v3    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 640
    .restart local v3    # "tagName":Ljava/lang/String;
    const-string v5, "Deleted"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 641
    iget-object v5, p1, Lcom/tencent/cos/xml/model/tag/DeleteResult;->deletedList:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 642
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 643
    :cond_9
    const-string v5, "CosError"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 644
    iget-object v5, p1, Lcom/tencent/cos/xml/model/tag/DeleteResult;->errorList:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 645
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 651
    .end local v3    # "tagName":Ljava/lang/String;
    :cond_a
    return-void

    .line 606
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseLifecycleConfiguration(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;)V
    .locals 11
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 356
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v9

    .line 357
    .local v9, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v10, "UTF-8"

    invoke-interface {v9, p0, v10}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 358
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 360
    .local v1, "eventType":I
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    iput-object v10, p1, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;->rules:Ljava/util/List;

    .line 361
    const/4 v6, 0x0

    .line 362
    .local v6, "rule":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;
    const/4 v3, 0x0

    .line 363
    .local v3, "filter":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter;
    const/4 v8, 0x0

    .line 364
    .local v8, "transition":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;
    const/4 v2, 0x0

    .line 365
    .local v2, "expiration":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;
    const/4 v0, 0x0

    .line 366
    .local v0, "abortIncompleteMultiUpload":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload;
    const/4 v4, 0x0

    .line 367
    .local v4, "noncurrentVersionExpiration":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration;
    const/4 v5, 0x0

    .line 368
    .local v5, "noncurrentVersionTransition":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;
    :goto_0
    const/4 v10, 0x1

    if-eq v1, v10, :cond_1a

    .line 369
    packed-switch v1, :pswitch_data_0

    .line 457
    :cond_0
    :goto_1
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 371
    :pswitch_0
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v7

    .line 372
    .local v7, "tagName":Ljava/lang/String;
    const-string v10, "Rule"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_1

    .line 373
    new-instance v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;

    .end local v6    # "rule":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;
    invoke-direct {v6}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;-><init>()V

    .restart local v6    # "rule":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;
    goto :goto_1

    .line 374
    :cond_1
    const-string v10, "ID"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 375
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 376
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->id:Ljava/lang/String;

    goto :goto_1

    .line 377
    :cond_2
    const-string v10, "Filter"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 378
    new-instance v3, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter;

    .end local v3    # "filter":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter;
    invoke-direct {v3}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter;-><init>()V

    .restart local v3    # "filter":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter;
    goto :goto_1

    .line 379
    :cond_3
    const-string v10, "Prefix"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 380
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 381
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v3, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter;->prefix:Ljava/lang/String;

    goto :goto_1

    .line 382
    :cond_4
    const-string v10, "Status"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_5

    .line 383
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 384
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->status:Ljava/lang/String;

    goto :goto_1

    .line 385
    :cond_5
    const-string v10, "Transition"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 386
    new-instance v8, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;

    .end local v8    # "transition":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;
    invoke-direct {v8}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;-><init>()V

    .restart local v8    # "transition":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;
    goto :goto_1

    .line 387
    :cond_6
    const-string v10, "Expiration"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_7

    .line 388
    new-instance v2, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;

    .end local v2    # "expiration":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;
    invoke-direct {v2}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;-><init>()V

    .restart local v2    # "expiration":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;
    goto :goto_1

    .line 389
    :cond_7
    const-string v10, "Days"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_9

    .line 390
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 391
    if-eqz v8, :cond_8

    .line 392
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    iput v10, v8, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;->days:I

    goto/16 :goto_1

    .line 393
    :cond_8
    iget-object v10, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->expiration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;

    if-eqz v10, :cond_0

    .line 394
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    iput v10, v2, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;->days:I

    goto/16 :goto_1

    .line 396
    :cond_9
    const-string v10, "Date"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_b

    .line 397
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 398
    if-eqz v8, :cond_a

    .line 399
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v8, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;->date:Ljava/lang/String;

    goto/16 :goto_1

    .line 400
    :cond_a
    if-eqz v2, :cond_0

    .line 401
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v2, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;->date:Ljava/lang/String;

    goto/16 :goto_1

    .line 403
    :cond_b
    const-string v10, "ExpiredObjectDeleteMarker"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_c

    .line 404
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 405
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v2, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;->expiredObjectDeleteMarker:Ljava/lang/String;

    goto/16 :goto_1

    .line 406
    :cond_c
    const-string v10, "AbortIncompleteMultipartUpload"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_d

    .line 407
    new-instance v0, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload;

    .end local v0    # "abortIncompleteMultiUpload":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload;
    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload;-><init>()V

    .restart local v0    # "abortIncompleteMultiUpload":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload;
    goto/16 :goto_1

    .line 408
    :cond_d
    const-string v10, "DaysAfterInitiation"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_e

    .line 409
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 410
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    iput v10, v0, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload;->daysAfterInitiation:I

    goto/16 :goto_1

    .line 411
    :cond_e
    const-string v10, "NoncurrentVersionExpiration"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_f

    .line 412
    new-instance v4, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration;

    .end local v4    # "noncurrentVersionExpiration":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration;
    invoke-direct {v4}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration;-><init>()V

    .restart local v4    # "noncurrentVersionExpiration":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration;
    goto/16 :goto_1

    .line 413
    :cond_f
    const-string v10, "NoncurrentVersionTransition"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_10

    .line 414
    new-instance v5, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;

    .end local v5    # "noncurrentVersionTransition":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;
    invoke-direct {v5}, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;-><init>()V

    .restart local v5    # "noncurrentVersionTransition":Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;
    goto/16 :goto_1

    .line 415
    :cond_10
    const-string v10, "NoncurrentDays"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_12

    .line 416
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 417
    if-eqz v4, :cond_11

    .line 418
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    iput v10, v4, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration;->noncurrentDays:I

    goto/16 :goto_1

    .line 419
    :cond_11
    if-eqz v5, :cond_0

    .line 420
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v10

    iput v10, v5, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;->noncurrentDays:I

    goto/16 :goto_1

    .line 422
    :cond_12
    const-string v10, "StorageClass"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 423
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 424
    if-eqz v8, :cond_13

    .line 425
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v8, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;->storageClass:Ljava/lang/String;

    goto/16 :goto_1

    .line 426
    :cond_13
    if-eqz v5, :cond_0

    .line 427
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v10

    iput-object v10, v5, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;->storageClass:Ljava/lang/String;

    goto/16 :goto_1

    .line 432
    .end local v7    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v9}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v7

    .line 433
    .restart local v7    # "tagName":Ljava/lang/String;
    const-string v10, "Rule"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_14

    .line 434
    iget-object v10, p1, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration;->rules:Ljava/util/List;

    invoke-interface {v10, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 435
    const/4 v6, 0x0

    goto/16 :goto_1

    .line 436
    :cond_14
    const-string v10, "Filter"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_15

    .line 437
    iput-object v3, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->filter:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Filter;

    .line 438
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 439
    :cond_15
    const-string v10, "Transition"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_16

    .line 440
    iput-object v8, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->transition:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Transition;

    .line 441
    const/4 v8, 0x0

    goto/16 :goto_1

    .line 442
    :cond_16
    const-string v10, "NoncurrentVersionExpiration"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_17

    .line 443
    iput-object v4, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->noncurrentVersionExpiration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionExpiration;

    .line 444
    const/4 v4, 0x0

    goto/16 :goto_1

    .line 445
    :cond_17
    const-string v10, "NoncurrentVersionTransition"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_18

    .line 446
    iput-object v5, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->noncurrentVersionTransition:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$NoncurrentVersionTransition;

    .line 447
    const/4 v5, 0x0

    goto/16 :goto_1

    .line 448
    :cond_18
    const-string v10, "Expiration"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_19

    .line 449
    iput-object v2, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->expiration:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Expiration;

    .line 450
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 451
    :cond_19
    const-string v10, "AbortIncompleteMultipartUpload"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 452
    iput-object v0, v6, Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$Rule;->abortIncompleteMultiUpload:Lcom/tencent/cos/xml/model/tag/LifecycleConfiguration$AbortIncompleteMultiUpload;

    .line 453
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 459
    .end local v7    # "tagName":Ljava/lang/String;
    :cond_1a
    return-void

    .line 369
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseListAllMyBucketsResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;)V
    .locals 6
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 38
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v3

    .line 39
    .local v3, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v4, "UTF-8"

    invoke-interface {v3, p0, v4}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 40
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 42
    .local v1, "eventType":I
    const/4 v0, 0x0

    .line 43
    .local v0, "bucket":Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;
    :goto_0
    const/4 v4, 0x1

    if-eq v1, v4, :cond_8

    .line 44
    packed-switch v1, :pswitch_data_0

    .line 83
    :cond_0
    :goto_1
    :pswitch_0
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 50
    :pswitch_1
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 51
    .local v2, "tagName":Ljava/lang/String;
    const-string v4, "Owner"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 52
    new-instance v4, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;

    invoke-direct {v4}, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;-><init>()V

    iput-object v4, p1, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->owner:Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;

    goto :goto_1

    .line 53
    :cond_1
    const-string v4, "ID"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 54
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 55
    iget-object v4, p1, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->owner:Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;->id:Ljava/lang/String;

    goto :goto_1

    .line 56
    :cond_2
    const-string v4, "DisplayName"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 57
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 58
    iget-object v4, p1, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->owner:Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Owner;->disPlayName:Ljava/lang/String;

    goto :goto_1

    .line 59
    :cond_3
    const-string v4, "Buckets"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 60
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p1, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->buckets:Ljava/util/List;

    goto :goto_1

    .line 61
    :cond_4
    const-string v4, "Bucket"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 62
    new-instance v0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;

    .end local v0    # "bucket":Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;
    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;-><init>()V

    .restart local v0    # "bucket":Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;
    goto :goto_1

    .line 63
    :cond_5
    const-string v4, "Name"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 64
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 65
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;->name:Ljava/lang/String;

    goto :goto_1

    .line 66
    :cond_6
    const-string v4, "Location"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 67
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 68
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;->location:Ljava/lang/String;

    goto/16 :goto_1

    .line 69
    :cond_7
    const-string v4, "CreationDate"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 70
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 71
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v4

    iput-object v4, v0, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets$Bucket;->createDate:Ljava/lang/String;

    goto/16 :goto_1

    .line 76
    .end local v2    # "tagName":Ljava/lang/String;
    :pswitch_2
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 77
    .restart local v2    # "tagName":Ljava/lang/String;
    const-string v4, "Bucket"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 78
    iget-object v4, p1, Lcom/tencent/cos/xml/model/tag/ListAllMyBuckets;->buckets:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 79
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 85
    .end local v2    # "tagName":Ljava/lang/String;
    :cond_8
    return-void

    .line 44
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static parseListBucketResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/ListBucket;)V
    .locals 8
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/ListBucket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 89
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v5

    .line 90
    .local v5, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v6, "UTF-8"

    invoke-interface {v5, p0, v6}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 91
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v2

    .line 93
    .local v2, "eventType":I
    const/4 v1, 0x0

    .line 94
    .local v1, "contents":Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;
    const/4 v0, 0x0

    .line 95
    .local v0, "commonPrefixes":Lcom/tencent/cos/xml/model/tag/ListBucket$CommonPrefixes;
    const/4 v3, 0x0

    .line 96
    .local v3, "owner":Lcom/tencent/cos/xml/model/tag/ListBucket$Owner;
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->contentsList:Ljava/util/List;

    .line 97
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->commonPrefixesList:Ljava/util/List;

    .line 98
    :goto_0
    const/4 v6, 0x1

    if-eq v2, v6, :cond_14

    .line 99
    packed-switch v2, :pswitch_data_0

    .line 170
    :cond_0
    :goto_1
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    goto :goto_0

    .line 101
    :pswitch_0
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 102
    .local v4, "tagName":Ljava/lang/String;
    const-string v6, "Name"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 103
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 104
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->name:Ljava/lang/String;

    goto :goto_1

    .line 105
    :cond_1
    const-string v6, "Encoding-Type"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 106
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 107
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->encodingType:Ljava/lang/String;

    goto :goto_1

    .line 108
    :cond_2
    const-string v6, "Marker"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 109
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 110
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->marker:Ljava/lang/String;

    goto :goto_1

    .line 111
    :cond_3
    const-string v6, "MaxKeys"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 112
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 113
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    iput v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->maxKeys:I

    goto :goto_1

    .line 114
    :cond_4
    const-string v6, "Delimiter"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 115
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 116
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->delimiter:Ljava/lang/String;

    goto :goto_1

    .line 117
    :cond_5
    const-string v6, "NextMarker"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 118
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 119
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->nextMarker:Ljava/lang/String;

    goto :goto_1

    .line 120
    :cond_6
    const-string v6, "IsTruncated"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 121
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 122
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v6

    iput-boolean v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->isTruncated:Z

    goto/16 :goto_1

    .line 123
    :cond_7
    const-string v6, "Prefix"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 124
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 125
    if-nez v0, :cond_8

    .line 126
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->prefix:Ljava/lang/String;

    goto/16 :goto_1

    .line 128
    :cond_8
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v0, Lcom/tencent/cos/xml/model/tag/ListBucket$CommonPrefixes;->prefix:Ljava/lang/String;

    goto/16 :goto_1

    .line 130
    :cond_9
    const-string v6, "Contents"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_a

    .line 131
    new-instance v1, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;

    .end local v1    # "contents":Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;
    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;-><init>()V

    .restart local v1    # "contents":Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;
    goto/16 :goto_1

    .line 132
    :cond_a
    const-string v6, "Key"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_b

    .line 133
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 134
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;->key:Ljava/lang/String;

    goto/16 :goto_1

    .line 135
    :cond_b
    const-string v6, "LastModified"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_c

    .line 136
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 137
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;->lastModified:Ljava/lang/String;

    goto/16 :goto_1

    .line 138
    :cond_c
    const-string v6, "ETag"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_d

    .line 139
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 140
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;->eTag:Ljava/lang/String;

    goto/16 :goto_1

    .line 141
    :cond_d
    const-string v6, "Size"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_e

    .line 142
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 143
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    iput-wide v6, v1, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;->size:J

    goto/16 :goto_1

    .line 144
    :cond_e
    const-string v6, "StorageClass"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_f

    .line 145
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 146
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v1, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;->storageClass:Ljava/lang/String;

    goto/16 :goto_1

    .line 147
    :cond_f
    const-string v6, "Owner"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_10

    .line 148
    new-instance v3, Lcom/tencent/cos/xml/model/tag/ListBucket$Owner;

    .end local v3    # "owner":Lcom/tencent/cos/xml/model/tag/ListBucket$Owner;
    invoke-direct {v3}, Lcom/tencent/cos/xml/model/tag/ListBucket$Owner;-><init>()V

    .restart local v3    # "owner":Lcom/tencent/cos/xml/model/tag/ListBucket$Owner;
    goto/16 :goto_1

    .line 149
    :cond_10
    const-string v6, "ID"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_11

    .line 150
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 151
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v3, Lcom/tencent/cos/xml/model/tag/ListBucket$Owner;->id:Ljava/lang/String;

    goto/16 :goto_1

    .line 152
    :cond_11
    const-string v6, "CommonPrefixes"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 153
    new-instance v0, Lcom/tencent/cos/xml/model/tag/ListBucket$CommonPrefixes;

    .end local v0    # "commonPrefixes":Lcom/tencent/cos/xml/model/tag/ListBucket$CommonPrefixes;
    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/ListBucket$CommonPrefixes;-><init>()V

    .restart local v0    # "commonPrefixes":Lcom/tencent/cos/xml/model/tag/ListBucket$CommonPrefixes;
    goto/16 :goto_1

    .line 157
    .end local v4    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v5}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 158
    .restart local v4    # "tagName":Ljava/lang/String;
    const-string v6, "Contents"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_12

    .line 159
    iget-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->contentsList:Ljava/util/List;

    invoke-interface {v6, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 160
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 161
    :cond_12
    const-string v6, "Owner"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_13

    .line 162
    iput-object v3, v1, Lcom/tencent/cos/xml/model/tag/ListBucket$Contents;->owner:Lcom/tencent/cos/xml/model/tag/ListBucket$Owner;

    .line 163
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 164
    :cond_13
    const-string v6, "CommonPrefixes"

    invoke-virtual {v4, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 165
    iget-object v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucket;->commonPrefixesList:Ljava/util/List;

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 166
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 172
    .end local v4    # "tagName":Ljava/lang/String;
    :cond_14
    return-void

    .line 99
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseListBucketVersions(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/ListBucketVersions;)V
    .locals 8
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/ListBucketVersions;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 698
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v4

    .line 699
    .local v4, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v5, "UTF-8"

    invoke-interface {v4, p0, v5}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 700
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 702
    .local v0, "eventType":I
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->objectVersionList:Ljava/util/List;

    .line 703
    const/4 v1, 0x0

    .line 704
    .local v1, "objectVersion":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;
    const/4 v2, 0x0

    .line 705
    .local v2, "owner":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Owner;
    :goto_0
    const/4 v5, 0x1

    if-eq v0, v5, :cond_15

    .line 706
    packed-switch v0, :pswitch_data_0

    .line 778
    :cond_0
    :goto_1
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 708
    :pswitch_0
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 709
    .local v3, "tagName":Ljava/lang/String;
    const-string v5, "Name"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 710
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 711
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->name:Ljava/lang/String;

    goto :goto_1

    .line 712
    :cond_1
    const-string v5, "Prefix"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 713
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 714
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->prefix:Ljava/lang/String;

    goto :goto_1

    .line 715
    :cond_2
    const-string v5, "KeyMarker"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 716
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 717
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->keyMarker:Ljava/lang/String;

    goto :goto_1

    .line 718
    :cond_3
    const-string v5, "VersionIdMarker"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 719
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 720
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->versionIdMarker:Ljava/lang/String;

    goto :goto_1

    .line 721
    :cond_4
    const-string v5, "MaxKeys"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 722
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 723
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    iput-wide v6, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->maxKeys:J

    goto :goto_1

    .line 724
    :cond_5
    const-string v5, "IsTruncated"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 725
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 726
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v5

    iput-boolean v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->isTruncated:Z

    goto :goto_1

    .line 727
    :cond_6
    const-string v5, "NextKeyMarker"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 728
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 729
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->nextKeyMarker:Ljava/lang/String;

    goto/16 :goto_1

    .line 730
    :cond_7
    const-string v5, "NextVersionIdMarker"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 731
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 732
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->nextVersionIdMarker:Ljava/lang/String;

    goto/16 :goto_1

    .line 733
    :cond_8
    const-string v5, "DeleteMarker"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 734
    new-instance v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$DeleteMarker;

    .end local v1    # "objectVersion":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;
    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$DeleteMarker;-><init>()V

    .restart local v1    # "objectVersion":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;
    goto/16 :goto_1

    .line 735
    :cond_9
    const-string v5, "Version"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 736
    new-instance v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;

    .end local v1    # "objectVersion":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;
    invoke-direct {v1}, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;-><init>()V

    .restart local v1    # "objectVersion":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;
    goto/16 :goto_1

    .line 737
    :cond_a
    const-string v5, "Key"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_b

    .line 738
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 739
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;->key:Ljava/lang/String;

    goto/16 :goto_1

    .line 740
    :cond_b
    const-string v5, "VersionId"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_c

    .line 741
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 742
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;->versionId:Ljava/lang/String;

    goto/16 :goto_1

    .line 743
    :cond_c
    const-string v5, "IsLatest"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_d

    .line 744
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 745
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v5

    iput-boolean v5, v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;->isLatest:Z

    goto/16 :goto_1

    .line 746
    :cond_d
    const-string v5, "LastModified"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_e

    .line 747
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 748
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;->lastModified:Ljava/lang/String;

    goto/16 :goto_1

    .line 749
    :cond_e
    const-string v5, "Owner"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_f

    .line 750
    new-instance v2, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Owner;

    .end local v2    # "owner":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Owner;
    invoke-direct {v2}, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Owner;-><init>()V

    .restart local v2    # "owner":Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Owner;
    goto/16 :goto_1

    .line 751
    :cond_f
    const-string v5, "UID"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_10

    .line 752
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 753
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v2, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Owner;->uid:Ljava/lang/String;

    goto/16 :goto_1

    .line 754
    :cond_10
    const-string v5, "ETag"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_11

    .line 755
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-object v5, v1

    .line 756
    check-cast v5, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;->eTag:Ljava/lang/String;

    goto/16 :goto_1

    .line 757
    :cond_11
    const-string v5, "Size"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_12

    .line 758
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-object v5, v1

    .line 759
    check-cast v5, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    iput-wide v6, v5, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;->size:J

    goto/16 :goto_1

    .line 760
    :cond_12
    const-string v5, "StorageClass"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 761
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-object v5, v1

    .line 762
    check-cast v5, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;

    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Version;->storageClass:Ljava/lang/String;

    goto/16 :goto_1

    .line 766
    .end local v3    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 767
    .restart local v3    # "tagName":Ljava/lang/String;
    const-string v5, "Owner"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_13

    .line 768
    iput-object v2, v1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions$ObjectVersion;->owner:Lcom/tencent/cos/xml/model/tag/ListBucketVersions$Owner;

    .line 769
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 770
    :cond_13
    const-string v5, "DeleteMarker"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_14

    .line 771
    iget-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->objectVersionList:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 772
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 773
    :cond_14
    const-string v5, "Version"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 774
    iget-object v5, p1, Lcom/tencent/cos/xml/model/tag/ListBucketVersions;->objectVersionList:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 775
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 780
    .end local v3    # "tagName":Ljava/lang/String;
    :cond_15
    return-void

    .line 706
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseListMultipartUploadsResult(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;)V
    .locals 8
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 481
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v6

    .line 482
    .local v6, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v7, "UTF-8"

    invoke-interface {v6, p0, v7}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 483
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 485
    .local v1, "eventType":I
    const/4 v0, 0x0

    .line 486
    .local v0, "commonPrefixes":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$CommonPrefixes;
    const/4 v5, 0x0

    .line 487
    .local v5, "upload":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->uploads:Ljava/util/List;

    .line 488
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->commonPrefixes:Ljava/util/List;

    .line 489
    const/4 v2, 0x0

    .line 490
    .local v2, "initiator":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;
    const/4 v3, 0x0

    .line 491
    .local v3, "owner":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;
    :goto_0
    const/4 v7, 0x1

    if-eq v1, v7, :cond_1c

    .line 492
    packed-switch v1, :pswitch_data_0

    .line 592
    :cond_0
    :goto_1
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 494
    :pswitch_0
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 495
    .local v4, "tagName":Ljava/lang/String;
    const-string v7, "Bucket"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 496
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 497
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->bucket:Ljava/lang/String;

    goto :goto_1

    .line 498
    :cond_1
    const-string v7, "Encoding-Type"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 499
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 500
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->encodingType:Ljava/lang/String;

    goto :goto_1

    .line 501
    :cond_2
    const-string v7, "KeyMarker"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 502
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 503
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->keyMarker:Ljava/lang/String;

    goto :goto_1

    .line 504
    :cond_3
    const-string v7, "UploadIdMarker"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 505
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 506
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->uploadIdMarker:Ljava/lang/String;

    goto :goto_1

    .line 507
    :cond_4
    const-string v7, "NextKeyMarker"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 508
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 509
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->nextKeyMarker:Ljava/lang/String;

    goto :goto_1

    .line 510
    :cond_5
    const-string v7, "NextUploadIdMarker"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_6

    .line 511
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 512
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->nextUploadIdMarker:Ljava/lang/String;

    goto :goto_1

    .line 513
    :cond_6
    const-string v7, "MaxUploads"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 514
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 515
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->maxUploads:Ljava/lang/String;

    goto/16 :goto_1

    .line 516
    :cond_7
    const-string v7, "IsTruncated"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_8

    .line 517
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 518
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v7

    iput-boolean v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->isTruncated:Z

    goto/16 :goto_1

    .line 519
    :cond_8
    const-string v7, "Prefix"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_a

    .line 520
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 521
    if-nez v0, :cond_9

    .line 522
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->prefix:Ljava/lang/String;

    goto/16 :goto_1

    .line 524
    :cond_9
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v0, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$CommonPrefixes;->prefix:Ljava/lang/String;

    goto/16 :goto_1

    .line 526
    :cond_a
    const-string v7, "Delimiter"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_b

    .line 527
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 528
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->delimiter:Ljava/lang/String;

    goto/16 :goto_1

    .line 529
    :cond_b
    const-string v7, "Upload"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_c

    .line 530
    new-instance v5, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;

    .end local v5    # "upload":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;
    invoke-direct {v5}, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;-><init>()V

    .restart local v5    # "upload":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;
    goto/16 :goto_1

    .line 531
    :cond_c
    const-string v7, "Key"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_d

    .line 532
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 533
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v5, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;->key:Ljava/lang/String;

    goto/16 :goto_1

    .line 534
    :cond_d
    const-string v7, "UploadID"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_e

    .line 535
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 536
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v5, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;->uploadID:Ljava/lang/String;

    goto/16 :goto_1

    .line 537
    :cond_e
    const-string v7, "StorageClass"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_f

    .line 538
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 539
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v5, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;->storageClass:Ljava/lang/String;

    goto/16 :goto_1

    .line 540
    :cond_f
    const-string v7, "Initiator"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_10

    .line 541
    new-instance v2, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;

    .end local v2    # "initiator":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;
    invoke-direct {v2}, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;-><init>()V

    .restart local v2    # "initiator":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;
    goto/16 :goto_1

    .line 542
    :cond_10
    const-string v7, "UIN"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_11

    .line 543
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 544
    if-eqz v2, :cond_0

    .line 545
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v2, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;->uin:Ljava/lang/String;

    goto/16 :goto_1

    .line 547
    :cond_11
    const-string v7, "Owner"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_12

    .line 548
    new-instance v3, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;

    .end local v3    # "owner":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;
    invoke-direct {v3}, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;-><init>()V

    .restart local v3    # "owner":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;
    goto/16 :goto_1

    .line 549
    :cond_12
    const-string v7, "UID"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_13

    .line 550
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 551
    if-eqz v3, :cond_0

    .line 552
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v3, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;->uid:Ljava/lang/String;

    goto/16 :goto_1

    .line 554
    :cond_13
    const-string v7, "ID"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_15

    .line 555
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 556
    if-eqz v3, :cond_14

    .line 557
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v3, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;->id:Ljava/lang/String;

    goto/16 :goto_1

    .line 558
    :cond_14
    if-eqz v2, :cond_0

    .line 559
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v2, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;->id:Ljava/lang/String;

    goto/16 :goto_1

    .line 561
    :cond_15
    const-string v7, "DisplayName"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_17

    .line 562
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 563
    if-eqz v3, :cond_16

    .line 564
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v3, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;->displayName:Ljava/lang/String;

    goto/16 :goto_1

    .line 565
    :cond_16
    if-eqz v2, :cond_0

    .line 566
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v2, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;->displayName:Ljava/lang/String;

    goto/16 :goto_1

    .line 568
    :cond_17
    const-string v7, "Initiated"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_18

    .line 569
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 570
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v5, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;->initiated:Ljava/lang/String;

    goto/16 :goto_1

    .line 571
    :cond_18
    const-string v7, "CommonPrefixs"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 572
    new-instance v0, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$CommonPrefixes;

    .end local v0    # "commonPrefixes":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$CommonPrefixes;
    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$CommonPrefixes;-><init>()V

    .restart local v0    # "commonPrefixes":Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$CommonPrefixes;
    goto/16 :goto_1

    .line 576
    .end local v4    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v6}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v4

    .line 577
    .restart local v4    # "tagName":Ljava/lang/String;
    const-string v7, "Upload"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_19

    .line 578
    iget-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->uploads:Ljava/util/List;

    invoke-interface {v7, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 579
    const/4 v5, 0x0

    goto/16 :goto_1

    .line 580
    :cond_19
    const-string v7, "CommonPrefixs"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1a

    .line 581
    iget-object v7, p1, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads;->commonPrefixes:Ljava/util/List;

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 582
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 583
    :cond_1a
    const-string v7, "Owner"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1b

    .line 584
    iput-object v3, v5, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;->owner:Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Owner;

    .line 585
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 586
    :cond_1b
    const-string v7, "Initiator"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 587
    iput-object v2, v5, Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Upload;->initiator:Lcom/tencent/cos/xml/model/tag/ListMultipartUploads$Initiator;

    .line 588
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 594
    .end local v4    # "tagName":Ljava/lang/String;
    :cond_1c
    return-void

    .line 492
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseLocationConstraint(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/LocationConstraint;)V
    .locals 4
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/LocationConstraint;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 462
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 463
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v3, "UTF-8"

    invoke-interface {v2, p0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 464
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 466
    .local v0, "eventType":I
    :goto_0
    const/4 v3, 0x1

    if-eq v0, v3, :cond_1

    .line 467
    packed-switch v0, :pswitch_data_0

    .line 476
    :cond_0
    :goto_1
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 469
    :pswitch_0
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 470
    .local v1, "tagName":Ljava/lang/String;
    const-string v3, "LocationConstraint"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 471
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 472
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/LocationConstraint;->location:Ljava/lang/String;

    goto :goto_1

    .line 478
    .end local v1    # "tagName":Ljava/lang/String;
    :cond_1
    return-void

    .line 467
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method

.method public static parseReplicationConfiguration(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;)V
    .locals 6
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 286
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v4

    .line 287
    .local v4, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v5, "UTF-8"

    invoke-interface {v4, p0, v5}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 288
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    .line 290
    .local v1, "eventType":I
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;->rules:Ljava/util/List;

    .line 291
    const/4 v2, 0x0

    .line 292
    .local v2, "rule":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;
    const/4 v0, 0x0

    .line 293
    .local v0, "destination":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;
    :goto_0
    const/4 v5, 0x1

    if-eq v1, v5, :cond_9

    .line 294
    packed-switch v1, :pswitch_data_0

    .line 332
    :cond_0
    :goto_1
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    goto :goto_0

    .line 296
    :pswitch_0
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 297
    .local v3, "tagName":Ljava/lang/String;
    const-string v5, "Role"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 298
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 299
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p1, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;->role:Ljava/lang/String;

    goto :goto_1

    .line 300
    :cond_1
    const-string v5, "Rule"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 301
    new-instance v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;

    .end local v2    # "rule":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;
    invoke-direct {v2}, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;-><init>()V

    .restart local v2    # "rule":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;
    goto :goto_1

    .line 302
    :cond_2
    const-string v5, "Status"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 303
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 304
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->status:Ljava/lang/String;

    goto :goto_1

    .line 305
    :cond_3
    const-string v5, "ID"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 306
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 307
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->id:Ljava/lang/String;

    goto :goto_1

    .line 308
    :cond_4
    const-string v5, "Prefix"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 309
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 310
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->prefix:Ljava/lang/String;

    goto :goto_1

    .line 311
    :cond_5
    const-string v5, "Destination"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 312
    new-instance v0, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;

    .end local v0    # "destination":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;
    invoke-direct {v0}, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;-><init>()V

    .restart local v0    # "destination":Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;
    goto :goto_1

    .line 313
    :cond_6
    const-string v5, "Bucket"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 314
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 315
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v0, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;->bucket:Ljava/lang/String;

    goto :goto_1

    .line 316
    :cond_7
    const-string v5, "StorageClass"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 317
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 318
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v0, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;->storageClass:Ljava/lang/String;

    goto/16 :goto_1

    .line 322
    .end local v3    # "tagName":Ljava/lang/String;
    :pswitch_1
    invoke-interface {v4}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 323
    .restart local v3    # "tagName":Ljava/lang/String;
    const-string v5, "Rule"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 324
    iget-object v5, p1, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration;->rules:Ljava/util/List;

    invoke-interface {v5, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 325
    const/4 v2, 0x0

    goto/16 :goto_1

    .line 326
    :cond_8
    const-string v5, "Destination"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 327
    iput-object v0, v2, Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Rule;->destination:Lcom/tencent/cos/xml/model/tag/ReplicationConfiguration$Destination;

    .line 328
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 334
    .end local v3    # "tagName":Ljava/lang/String;
    :cond_9
    return-void

    .line 294
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static parseVersioningConfiguration(Ljava/io/InputStream;Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;)V
    .locals 4
    .param p0, "inputStream"    # Ljava/io/InputStream;
    .param p1, "result"    # Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xmlpull/v1/XmlPullParserException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 337
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v2

    .line 338
    .local v2, "xmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    const-string v3, "UTF-8"

    invoke-interface {v2, p0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 339
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 341
    .local v0, "eventType":I
    :goto_0
    const/4 v3, 0x1

    if-eq v0, v3, :cond_1

    .line 342
    packed-switch v0, :pswitch_data_0

    .line 351
    :cond_0
    :goto_1
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 344
    :pswitch_0
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 345
    .local v1, "tagName":Ljava/lang/String;
    const-string v3, "Status"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 346
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    .line 347
    invoke-interface {v2}, Lorg/xmlpull/v1/XmlPullParser;->getText()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p1, Lcom/tencent/cos/xml/model/tag/VersioningConfiguration;->status:Ljava/lang/String;

    goto :goto_1

    .line 353
    .end local v1    # "tagName":Ljava/lang/String;
    :cond_1
    return-void

    .line 342
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
    .end packed-switch
.end method
