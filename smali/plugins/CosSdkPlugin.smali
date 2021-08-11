.class public Lplugins/CosSdkPlugin;
.super Ljava/lang/Object;
.source "CosSdkPlugin.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;
    }
.end annotation


# static fields
.field public static final CODE_CROP_HEADICON:I = 0xfac

.field public static final CODE_CROP_PHOTO:I = 0xfad

.field public static final CODE_SELECT_HEADICON:I = 0xfaa

.field public static final CODE_SELECT_PHOTO:I = 0xfab


# instance fields
.field private activity:Landroid/app/Activity;

.field private final appid:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

.field private final region:Ljava/lang/String;

.field private final signDuration:J

.field private tempImagePath:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    const-string v0, "1251008858"

    iput-object v0, p0, Lplugins/CosSdkPlugin;->appid:Ljava/lang/String;

    .line 51
    sget-object v0, Lcom/tencent/cos/xml/common/Region;->AP_Shanghai:Lcom/tencent/cos/xml/common/Region;

    invoke-virtual {v0}, Lcom/tencent/cos/xml/common/Region;->getRegion()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lplugins/CosSdkPlugin;->region:Ljava/lang/String;

    .line 52
    const-wide/16 v0, 0x258

    iput-wide v0, p0, Lplugins/CosSdkPlugin;->signDuration:J

    return-void
.end method

.method static synthetic access$000(Lplugins/CosSdkPlugin;)V
    .locals 0
    .param p0, "x0"    # Lplugins/CosSdkPlugin;

    .prologue
    .line 44
    invoke-direct {p0}, Lplugins/CosSdkPlugin;->deleteTempImage()V

    return-void
.end method

.method static synthetic access$100(Lplugins/CosSdkPlugin;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lplugins/CosSdkPlugin;
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # Ljava/lang/String;

    .prologue
    .line 44
    invoke-direct {p0, p1, p2, p3, p4}, Lplugins/CosSdkPlugin;->sendDownloadObjectResult(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private deleteTempImage()V
    .locals 2

    .prologue
    .line 369
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lplugins/CosSdkPlugin;->tempImagePath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 370
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 371
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 373
    :cond_0
    return-void
.end method

.method private getImagePath(Landroid/net/Uri;)Ljava/lang/String;
    .locals 11
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v3, 0x0

    .line 384
    const/4 v7, 0x0

    .line 386
    .local v7, "path":Ljava/lang/String;
    if-nez p1, :cond_0

    move-object v8, v7

    .line 406
    .end local v7    # "path":Ljava/lang/String;
    .local v8, "path":Ljava/lang/String;
    :goto_0
    return-object v8

    .line 390
    .end local v8    # "path":Ljava/lang/String;
    .restart local v7    # "path":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v10

    .line 391
    .local v10, "scheme":Ljava/lang/String;
    if-eqz v10, :cond_1

    const-string v0, "file"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 392
    :cond_1
    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v7

    :cond_2
    :goto_1
    move-object v8, v7

    .line 406
    .end local v7    # "path":Ljava/lang/String;
    .restart local v8    # "path":Ljava/lang/String;
    goto :goto_0

    .line 394
    .end local v8    # "path":Ljava/lang/String;
    .restart local v7    # "path":Ljava/lang/String;
    :cond_3
    const-string v0, "content"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 395
    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "_data"

    aput-object v1, v2, v0

    .line 396
    .local v2, "projection":[Ljava/lang/String;
    iget-object v0, p0, Lplugins/CosSdkPlugin;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    move-object v1, p1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 397
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_4

    .line 398
    const-string v0, "_data"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 399
    .local v9, "photoColumn":I
    const/4 v0, -0x1

    if-eq v9, v0, :cond_4

    .line 400
    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    .line 401
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 404
    .end local v9    # "photoColumn":I
    :cond_4
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_1
.end method

.method private sendDownloadObjectResult(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "httpCode"    # I
    .param p2, "httpMsg"    # Ljava/lang/String;
    .param p3, "cosPath"    # Ljava/lang/String;
    .param p4, "eTag"    # Ljava/lang/String;

    .prologue
    .line 208
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 210
    .local v1, "jsonObj":Lorg/json/JSONObject;
    :try_start_0
    const-string v2, "httpCode"

    invoke-virtual {v1, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 211
    const-string v2, "httpMessage"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 212
    const-string v2, "cosPath"

    invoke-virtual {v1, v2, p3}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 213
    const-string v2, "eTag"

    invoke-virtual {v1, v2, p4}, Lorg/json/JSONObject;->putOpt(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 217
    :goto_0
    const-string v2, "UIRoot"

    const-string v3, "DownloadResult"

    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    return-void

    .line 214
    :catch_0
    move-exception v0

    .line 215
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public Init(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 62
    iput-object p1, p0, Lplugins/CosSdkPlugin;->context:Landroid/content/Context;

    .line 63
    iput-object p2, p0, Lplugins/CosSdkPlugin;->activity:Landroid/app/Activity;

    .line 65
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Landroid/os/Environment;->DIRECTORY_PICTURES:Ljava/lang/String;

    invoke-virtual {p2, v1}, Landroid/app/Activity;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/upload.jpg"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lplugins/CosSdkPlugin;->tempImagePath:Ljava/lang/String;

    .line 67
    const-string v0, "cqq_log"

    const-string v1, "cos plugin init"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    return-void
.end method

.method public cropImageResult(Landroid/os/Bundle;I)V
    .locals 6
    .param p1, "bundle"    # Landroid/os/Bundle;
    .param p2, "code"    # I

    .prologue
    .line 324
    :try_start_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "file:///"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lplugins/CosSdkPlugin;->tempImagePath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 325
    .local v2, "uriTemp":Landroid/net/Uri;
    iget-object v3, p0, Lplugins/CosSdkPlugin;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v3

    invoke-static {v3}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 326
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    invoke-virtual {p0, v0}, Lplugins/CosSdkPlugin;->saveClipImage(Landroid/graphics/Bitmap;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 328
    packed-switch p2, :pswitch_data_0

    .line 341
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "uriTemp":Landroid/net/Uri;
    :goto_0
    const-string v3, "cqq_log"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "crop image success | code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 342
    return-void

    .line 330
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    .restart local v2    # "uriTemp":Landroid/net/Uri;
    :pswitch_0
    :try_start_1
    const-string v3, "UIRoot"

    const-string v4, "CropHeadIconResult"

    iget-object v5, p0, Lplugins/CosSdkPlugin;->tempImagePath:Ljava/lang/String;

    invoke-static {v3, v4, v5}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 337
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "uriTemp":Landroid/net/Uri;
    :catch_0
    move-exception v1

    .line 338
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 333
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v0    # "bitmap":Landroid/graphics/Bitmap;
    .restart local v2    # "uriTemp":Landroid/net/Uri;
    :pswitch_1
    :try_start_2
    const-string v3, "UIRoot"

    const-string v4, "CropPhotoResult"

    iget-object v5, p0, Lplugins/CosSdkPlugin;->tempImagePath:Ljava/lang/String;

    invoke-static {v3, v4, v5}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 328
    nop

    :pswitch_data_0
    .packed-switch 0xfac
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public deleteObject(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 222
    new-instance v0, Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;

    invoke-direct {v0, p1, p2}, Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    .local v0, "deleteObjectRequest":Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;
    const-wide/16 v2, 0x258

    invoke-virtual {v0, v2, v3, v1, v1}, Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;->setSign(JLjava/util/Set;Ljava/util/Set;)V

    .line 225
    iget-object v1, p0, Lplugins/CosSdkPlugin;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    new-instance v2, Lplugins/CosSdkPlugin$4;

    invoke-direct {v2, p0, p2}, Lplugins/CosSdkPlugin$4;-><init>(Lplugins/CosSdkPlugin;Ljava/lang/String;)V

    invoke-virtual {v1, v0, v2}, Lcom/tencent/cos/xml/CosXmlService;->deleteObjectAsync(Lcom/tencent/cos/xml/model/object/DeleteObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 249
    return-void
.end method

.method public downloadObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "eTag"    # Ljava/lang/String;
    .param p4, "downloadDir"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 165
    new-instance v0, Lcom/tencent/cos/xml/model/object/GetObjectRequest;

    invoke-direct {v0, p1, p2, p4}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    .local v0, "getObjectRequest":Lcom/tencent/cos/xml/model/object/GetObjectRequest;
    const-wide/16 v2, 0x258

    invoke-virtual {v0, v2, v3, v1, v1}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->setSign(JLjava/util/Set;Ljava/util/Set;)V

    .line 167
    invoke-virtual {v0, p3}, Lcom/tencent/cos/xml/model/object/GetObjectRequest;->setIfNONEMatch(Ljava/lang/String;)V

    .line 169
    iget-object v1, p0, Lplugins/CosSdkPlugin;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    new-instance v2, Lplugins/CosSdkPlugin$3;

    invoke-direct {v2, p0, p2}, Lplugins/CosSdkPlugin$3;-><init>(Lplugins/CosSdkPlugin;Ljava/lang/String;)V

    invoke-virtual {v1, v0, v2}, Lcom/tencent/cos/xml/CosXmlService;->getObjectAsync(Lcom/tencent/cos/xml/model/object/GetObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 205
    return-void
.end method

.method public openCropImageActivity(Landroid/net/Uri;III)V
    .locals 5
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "outputX"    # I
    .param p3, "outputY"    # I
    .param p4, "code"    # I

    .prologue
    const/4 v4, 0x1

    .line 291
    new-instance v0, Landroid/content/Intent;

    const-string v2, "com.android.camera.action.CROP"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 292
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "image/*"

    invoke-virtual {v0, p1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 293
    const-string v2, "crop"

    const-string v3, "true"

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 295
    const-string v2, "aspectX"

    invoke-virtual {v0, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 296
    const-string v2, "aspectY"

    invoke-virtual {v0, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 298
    const-string v2, "outputX"

    invoke-virtual {v0, v2, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 299
    const-string v2, "outputY"

    invoke-virtual {v0, v2, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 302
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "file:///"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lplugins/CosSdkPlugin;->tempImagePath:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 303
    .local v1, "uriTemp":Landroid/net/Uri;
    const-string v2, "output"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 304
    const-string v2, "outputFormat"

    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    invoke-virtual {v3}, Landroid/graphics/Bitmap$CompressFormat;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 305
    iget-object v2, p0, Lplugins/CosSdkPlugin;->activity:Landroid/app/Activity;

    invoke-virtual {v2, v0, p4}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 307
    const-string v2, "cqq_log"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "open crop image activity | code: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 308
    return-void
.end method

.method public openGalleryActivity(Ljava/lang/String;)V
    .locals 5
    .param p1, "openType"    # Ljava/lang/String;

    .prologue
    .line 262
    const/4 v0, -0x1

    .line 263
    .local v0, "code":I
    const-string v2, "HeadIcon"

    invoke-virtual {p1, v2}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_1

    .line 264
    const/16 v0, 0xfaa

    .line 269
    :cond_0
    :goto_0
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.PICK"

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 270
    .local v1, "intent":Landroid/content/Intent;
    sget-object v2, Landroid/provider/MediaStore$Images$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const-string v3, "image/*"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 271
    iget-object v2, p0, Lplugins/CosSdkPlugin;->activity:Landroid/app/Activity;

    invoke-virtual {v2, v1, v0}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 273
    const-string v2, "cqq_log"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "open gallery activity | type: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " code: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 275
    return-void

    .line 265
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    const-string v2, "Photo"

    invoke-virtual {p1, v2}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_0

    .line 266
    const/16 v0, 0xfab

    goto :goto_0
.end method

.method public saveClipImage(Landroid/graphics/Bitmap;)Ljava/lang/String;
    .locals 7
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 345
    const/4 v2, 0x0

    .line 346
    .local v2, "fOut":Ljava/io/FileOutputStream;
    const-string v4, ""

    .line 348
    .local v4, "path":Ljava/lang/String;
    :try_start_0
    new-instance v0, Ljava/io/File;

    iget-object v5, p0, Lplugins/CosSdkPlugin;->tempImagePath:Ljava/lang/String;

    invoke-direct {v0, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 349
    .local v0, "cutFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_0

    .line 350
    invoke-virtual {v0}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v5

    invoke-virtual {v5}, Ljava/io/File;->mkdirs()Z

    .line 351
    invoke-virtual {v0}, Ljava/io/File;->createNewFile()Z

    .line 353
    :cond_0
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    .line 356
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v0}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 357
    .end local v2    # "fOut":Ljava/io/FileOutputStream;
    .local v3, "fOut":Ljava/io/FileOutputStream;
    :try_start_1
    sget-object v5, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v6, 0x50

    invoke-virtual {p1, v5, v6, v3}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 358
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->flush()V

    .line 359
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v2, v3

    .line 365
    .end local v0    # "cutFile":Ljava/io/File;
    .end local v3    # "fOut":Ljava/io/FileOutputStream;
    .restart local v2    # "fOut":Ljava/io/FileOutputStream;
    :goto_0
    return-object v4

    .line 361
    :catch_0
    move-exception v1

    .line 362
    .local v1, "e":Ljava/io/IOException;
    :goto_1
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 361
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "fOut":Ljava/io/FileOutputStream;
    .restart local v0    # "cutFile":Ljava/io/File;
    .restart local v3    # "fOut":Ljava/io/FileOutputStream;
    :catch_1
    move-exception v1

    move-object v2, v3

    .end local v3    # "fOut":Ljava/io/FileOutputStream;
    .restart local v2    # "fOut":Ljava/io/FileOutputStream;
    goto :goto_1
.end method

.method public selectImageResult(Landroid/net/Uri;I)V
    .locals 5
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "code"    # I

    .prologue
    const/16 v4, 0x200

    const/16 v3, 0x80

    .line 278
    const-string v0, "cqq_log"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "select image success | code: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 280
    packed-switch p2, :pswitch_data_0

    .line 288
    :goto_0
    return-void

    .line 282
    :pswitch_0
    const/16 v0, 0xfac

    invoke-virtual {p0, p1, v3, v3, v0}, Lplugins/CosSdkPlugin;->openCropImageActivity(Landroid/net/Uri;III)V

    goto :goto_0

    .line 285
    :pswitch_1
    const/16 v0, 0xfad

    invoke-virtual {p0, p1, v4, v4, v0}, Lplugins/CosSdkPlugin;->openCropImageActivity(Landroid/net/Uri;III)V

    goto :goto_0

    .line 280
    :pswitch_data_0
    .packed-switch 0xfaa
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public showLogString(Ljava/lang/String;)V
    .locals 1
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 380
    const-string v0, "cqq_log"

    invoke-static {v0, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 381
    return-void
.end method

.method public showToastString(Ljava/lang/String;)V
    .locals 2
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 376
    iget-object v0, p0, Lplugins/CosSdkPlugin;->context:Landroid/content/Context;

    const/4 v1, 0x1

    invoke-static {v0, p1, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 377
    return-void
.end method

.method public startService(Ljava/lang/String;)V
    .locals 14
    .param p1, "sessionJson"    # Ljava/lang/String;

    .prologue
    .line 71
    const-string v3, ""

    .line 72
    .local v3, "tmpSecretId":Ljava/lang/String;
    const-string v4, ""

    .line 73
    .local v4, "tmpSecretKey":Ljava/lang/String;
    const-string v5, ""

    .line 74
    .local v5, "sessionToken":Ljava/lang/String;
    const-wide/16 v6, 0x0

    .line 76
    .local v6, "expiredTime":J
    :try_start_0
    new-instance v11, Lorg/json/JSONObject;

    invoke-direct {v11, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 77
    .local v11, "jsObj":Lorg/json/JSONObject;
    const-string v2, "data"

    invoke-virtual {v11, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 78
    .local v9, "dataObj":Lorg/json/JSONObject;
    const-string v2, "credentials"

    invoke-virtual {v9, v2}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 79
    .local v8, "credObj":Lorg/json/JSONObject;
    const-string v2, "tmpSecretId"

    invoke-virtual {v8, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 80
    const-string v2, "tmpSecretKey"

    invoke-virtual {v8, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 81
    const-string v2, "sessionToken"

    invoke-virtual {v8, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 82
    const-string v2, "expiredTime"

    invoke-virtual {v9, v2}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v6

    .line 88
    .end local v8    # "credObj":Lorg/json/JSONObject;
    .end local v9    # "dataObj":Lorg/json/JSONObject;
    .end local v11    # "jsObj":Lorg/json/JSONObject;
    :goto_0
    new-instance v2, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    invoke-direct {v2}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;-><init>()V

    const/4 v12, 0x0

    .line 89
    invoke-virtual {v2, v12}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->isHttps(Z)Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    move-result-object v2

    const-string v12, "1251008858"

    iget-object v13, p0, Lplugins/CosSdkPlugin;->region:Ljava/lang/String;

    .line 90
    invoke-virtual {v2, v12, v13}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->setAppidAndRegion(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    move-result-object v2

    const/4 v12, 0x1

    .line 91
    invoke-virtual {v2, v12}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->setDebuggable(Z)Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;

    move-result-object v2

    .line 92
    invoke-virtual {v2}, Lcom/tencent/cos/xml/CosXmlServiceConfig$Builder;->builder()Lcom/tencent/cos/xml/CosXmlServiceConfig;

    move-result-object v0

    .line 94
    .local v0, "cosXmlServiceConfig":Lcom/tencent/cos/xml/CosXmlServiceConfig;
    new-instance v1, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;

    move-object v2, p0

    invoke-direct/range {v1 .. v7}, Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;-><init>(Lplugins/CosSdkPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 97
    .local v1, "provider":Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;
    new-instance v2, Lcom/tencent/cos/xml/CosXmlService;

    iget-object v12, p0, Lplugins/CosSdkPlugin;->context:Landroid/content/Context;

    invoke-direct {v2, v12, v0, v1}, Lcom/tencent/cos/xml/CosXmlService;-><init>(Landroid/content/Context;Lcom/tencent/cos/xml/CosXmlServiceConfig;Lcom/tencent/qcloud/core/auth/QCloudCredentialProvider;)V

    iput-object v2, p0, Lplugins/CosSdkPlugin;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    .line 99
    const-string v2, "UIRoot"

    const-string v12, "StartServiceResult"

    const-string v13, "0"

    invoke-static {v2, v12, v13}, Lcom/unity3d/player/UnityPlayer;->UnitySendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string v2, "cqq_log"

    const-string v12, "start cos service"

    invoke-static {v2, v12}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 104
    return-void

    .line 84
    .end local v0    # "cosXmlServiceConfig":Lcom/tencent/cos/xml/CosXmlServiceConfig;
    .end local v1    # "provider":Lplugins/CosSdkPlugin$LocalSessionCredentialProvider;
    :catch_0
    move-exception v10

    .line 85
    .local v10, "e":Lorg/json/JSONException;
    invoke-virtual {v10}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public takePhoto()V
    .locals 6

    .prologue
    .line 253
    const/16 v1, 0x64

    .line 254
    .local v1, "requestCode":I
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.media.action.IMAGE_CAPTURE"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 255
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "output"

    new-instance v3, Ljava/io/File;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    const-string v5, "temp.jpg"

    invoke-direct {v3, v4, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-static {v3}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 256
    iget-object v2, p0, Lplugins/CosSdkPlugin;->activity:Landroid/app/Activity;

    invoke-virtual {v2, v0, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 259
    return-void
.end method

.method public testCosService()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 107
    new-instance v0, Lcom/tencent/cos/xml/model/service/GetServiceRequest;

    invoke-direct {v0}, Lcom/tencent/cos/xml/model/service/GetServiceRequest;-><init>()V

    .line 108
    .local v0, "getServiceRequest":Lcom/tencent/cos/xml/model/service/GetServiceRequest;
    const-wide/16 v2, 0x258

    invoke-virtual {v0, v2, v3, v1, v1}, Lcom/tencent/cos/xml/model/service/GetServiceRequest;->setSign(JLjava/util/Set;Ljava/util/Set;)V

    .line 109
    iget-object v1, p0, Lplugins/CosSdkPlugin;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    new-instance v2, Lplugins/CosSdkPlugin$1;

    invoke-direct {v2, p0}, Lplugins/CosSdkPlugin$1;-><init>(Lplugins/CosSdkPlugin;)V

    invoke-virtual {v1, v0, v2}, Lcom/tencent/cos/xml/CosXmlService;->getServiceAsync(Lcom/tencent/cos/xml/model/service/GetServiceRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 130
    return-void
.end method

.method public uploadObject(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "bucket"    # Ljava/lang/String;
    .param p2, "cosPath"    # Ljava/lang/String;
    .param p3, "srcPath"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 133
    new-instance v0, Lcom/tencent/cos/xml/model/object/PutObjectRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    .local v0, "putObjectRequest":Lcom/tencent/cos/xml/model/object/PutObjectRequest;
    const-wide/16 v2, 0x258

    invoke-virtual {v0, v2, v3, v1, v1}, Lcom/tencent/cos/xml/model/object/PutObjectRequest;->setSign(JLjava/util/Set;Ljava/util/Set;)V

    .line 136
    iget-object v1, p0, Lplugins/CosSdkPlugin;->cosXmlService:Lcom/tencent/cos/xml/CosXmlService;

    new-instance v2, Lplugins/CosSdkPlugin$2;

    invoke-direct {v2, p0, p2}, Lplugins/CosSdkPlugin$2;-><init>(Lplugins/CosSdkPlugin;Ljava/lang/String;)V

    invoke-virtual {v1, v0, v2}, Lcom/tencent/cos/xml/CosXmlService;->putObjectAsync(Lcom/tencent/cos/xml/model/object/PutObjectRequest;Lcom/tencent/cos/xml/listener/CosXmlResultListener;)V

    .line 162
    return-void
.end method
