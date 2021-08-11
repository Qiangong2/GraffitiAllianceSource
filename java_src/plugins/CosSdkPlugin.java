package plugins;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;
import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.Region;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.service.GetServiceRequest;
import com.tencent.qcloud.core.auth.BasicLifecycleCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudLifecycleCredentials;
import com.tencent.qcloud.core.auth.SessionQCloudCredentials;
import com.unity3d.player.UnityPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CosSdkPlugin {
    public static final int CODE_CROP_HEADICON = 4012;
    public static final int CODE_CROP_PHOTO = 4013;
    public static final int CODE_SELECT_HEADICON = 4010;
    public static final int CODE_SELECT_PHOTO = 4011;
    private Activity activity;
    private final String appid = "1251008858";
    private Context context;
    private CosXmlService cosXmlService;
    private final String region = Region.AP_Shanghai.getRegion();
    private final long signDuration = 600;
    private String tempImagePath;

    public void Init(Context context2, Activity activity2) {
        this.context = context2;
        this.activity = activity2;
        this.tempImagePath = activity2.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/upload.jpg";
        Log.w("cqq_log", "cos plugin init");
    }

    public void startService(String sessionJson) {
        String tmpSecretId = "";
        String tmpSecretKey = "";
        String sessionToken = "";
        long expiredTime = 0;
        try {
            JSONObject dataObj = new JSONObject(sessionJson).optJSONObject("data");
            JSONObject credObj = dataObj.optJSONObject("credentials");
            tmpSecretId = credObj.optString("tmpSecretId");
            tmpSecretKey = credObj.optString("tmpSecretKey");
            sessionToken = credObj.optString("sessionToken");
            expiredTime = dataObj.optLong("expiredTime");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.cosXmlService = new CosXmlService(this.context, new CosXmlServiceConfig.Builder().isHttps(false).setAppidAndRegion("1251008858", this.region).setDebuggable(true).builder(), new LocalSessionCredentialProvider(tmpSecretId, tmpSecretKey, sessionToken, expiredTime));
        UnityPlayer.UnitySendMessage("UIRoot", "StartServiceResult", "0");
        Log.w("cqq_log", "start cos service");
    }

    public void testCosService() {
        GetServiceRequest getServiceRequest = new GetServiceRequest();
        getServiceRequest.setSign(600, null, null);
        this.cosXmlService.getServiceAsync(getServiceRequest, new CosXmlResultListener() {
            /* class plugins.CosSdkPlugin.C21961 */

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                Log.w("cqq_log", "success = " + (cosXmlResult.printResult()));
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException qcloudClientException, CosXmlServiceException qcloudServiceException) {
                StringBuilder stringBuilder = new StringBuilder();
                if (qcloudClientException != null) {
                    stringBuilder.append(qcloudClientException.getMessage());
                } else {
                    stringBuilder.append(qcloudServiceException.toString());
                }
                Log.w("cqq_log", "failed = " + stringBuilder.toString());
            }
        });
    }

    public void uploadObject(String bucket, final String cosPath, String srcPath) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, cosPath, srcPath);
        putObjectRequest.setSign(600, null, null);
        this.cosXmlService.putObjectAsync(putObjectRequest, new CosXmlResultListener() {
            /* class plugins.CosSdkPlugin.C21972 */

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                Log.w("cqq_log", "upload success = " + (cosXmlResult.printResult()) + " " + cosPath);
                UnityPlayer.UnitySendMessage("UIRoot", "UploadResult", cosPath);
                CosSdkPlugin.this.deleteTempImage();
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException qcloudClientException, CosXmlServiceException qcloudServiceException) {
                StringBuilder stringBuilder = new StringBuilder();
                if (qcloudClientException != null) {
                    stringBuilder.append(qcloudClientException.getMessage());
                } else {
                    stringBuilder.append(qcloudServiceException.toString());
                }
                Log.w("cqq_log", "upload failed = " + stringBuilder.toString() + " " + cosPath);
                UnityPlayer.UnitySendMessage("UIRoot", "UploadResult", "");
            }
        });
    }

    public void downloadObject(String bucket, final String cosPath, String eTag, String downloadDir) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, cosPath, downloadDir);
        getObjectRequest.setSign(600, null, null);
        getObjectRequest.setIfNONEMatch(eTag);
        this.cosXmlService.getObjectAsync(getObjectRequest, new CosXmlResultListener() {
            /* class plugins.CosSdkPlugin.C21983 */

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                Log.w("cqq_log", "download success = " + (cosXmlResult.printResult()) + " " + cosPath);
                String newTag = "";
                List<String> tags = cosXmlResult.headers.get("etag");
                if (tags != null && tags.size() > 0) {
                    newTag = tags.get(0);
                }
                CosSdkPlugin.this.sendDownloadObjectResult(cosXmlResult.httpCode, cosXmlResult.httpMessage, cosPath, newTag);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException qcloudClientException, CosXmlServiceException qcloudServiceException) {
                StringBuilder stringBuilder = new StringBuilder();
                if (qcloudClientException != null) {
                    stringBuilder.append(qcloudClientException.getMessage());
                } else {
                    stringBuilder.append(qcloudServiceException.toString());
                }
                Log.w("cqq_log", "download failed = " + stringBuilder.toString() + " " + cosPath);
                CosSdkPlugin.this.sendDownloadObjectResult(qcloudServiceException.getStatusCode(), qcloudServiceException.getHttpMessage(), cosPath, "");
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendDownloadObjectResult(int httpCode, String httpMsg, String cosPath, String eTag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("httpCode", httpCode);
            jsonObj.putOpt("httpMessage", httpMsg);
            jsonObj.putOpt("cosPath", cosPath);
            jsonObj.putOpt("eTag", eTag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UnityPlayer.UnitySendMessage("UIRoot", "DownloadResult", jsonObj.toString());
    }

    public void deleteObject(String bucket, final String cosPath) {
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucket, cosPath);
        deleteObjectRequest.setSign(600, null, null);
        this.cosXmlService.deleteObjectAsync(deleteObjectRequest, new CosXmlResultListener() {
            /* class plugins.CosSdkPlugin.C21994 */

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                Log.w("cqq_log", "success = " + (cosXmlResult.printResult()));
                UnityPlayer.UnitySendMessage("UIRoot", "DeleteResult", cosPath);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException qcloudClientException, CosXmlServiceException qcloudServiceException) {
                StringBuilder stringBuilder = new StringBuilder();
                if (qcloudClientException != null) {
                    stringBuilder.append(qcloudClientException.getMessage());
                } else {
                    stringBuilder.append(qcloudServiceException.toString());
                }
                Log.w("cqq_log", "failed = " + stringBuilder.toString());
            }
        });
    }

    public void takePhoto() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "temp.jpg")));
        this.activity.startActivityForResult(intent, 100);
    }

    public void openGalleryActivity(String openType) {
        int code = -1;
        if (openType.compareToIgnoreCase("HeadIcon") == 0) {
            code = CODE_SELECT_HEADICON;
        } else if (openType.compareToIgnoreCase("Photo") == 0) {
            code = CODE_SELECT_PHOTO;
        }
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        this.activity.startActivityForResult(intent, code);
        Log.w("cqq_log", "open gallery activity | type: " + openType + " code: " + code);
    }

    public void selectImageResult(Uri uri, int code) {
        Log.w("cqq_log", "select image success | code: " + code);
        switch (code) {
            case CODE_SELECT_HEADICON /*{ENCODED_INT: 4010}*/:
                openCropImageActivity(uri, 128, 128, CODE_CROP_HEADICON);
                return;
            case CODE_SELECT_PHOTO /*{ENCODED_INT: 4011}*/:
                openCropImageActivity(uri, 512, 512, CODE_CROP_PHOTO);
                return;
            default:
                return;
        }
    }

    public void openCropImageActivity(Uri uri, int outputX, int outputY, int code) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        intent.putExtra("output", Uri.parse("file:///" + this.tempImagePath));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        this.activity.startActivityForResult(intent, code);
        Log.w("cqq_log", "open crop image activity | code: " + code);
    }

    public void cropImageResult(Bundle bundle, int code) {
        try {
            saveClipImage(BitmapFactory.decodeStream(this.context.getContentResolver().openInputStream(Uri.parse("file:///" + this.tempImagePath))));
            switch (code) {
                case CODE_CROP_HEADICON /*{ENCODED_INT: 4012}*/:
                    UnityPlayer.UnitySendMessage("UIRoot", "CropHeadIconResult", this.tempImagePath);
                    break;
                case CODE_CROP_PHOTO /*{ENCODED_INT: 4013}*/:
                    UnityPlayer.UnitySendMessage("UIRoot", "CropPhotoResult", this.tempImagePath);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.w("cqq_log", "crop image success | code: " + code);
    }

    public String saveClipImage(Bitmap bitmap) throws IOException {
        IOException e;
        String path = "";
        try {
            File cutFile = new File(this.tempImagePath);
            if (!cutFile.exists()) {
                cutFile.getParentFile().mkdirs();
                cutFile.createNewFile();
            }
            path = cutFile.getAbsolutePath();
            FileOutputStream fOut = new FileOutputStream(cutFile);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fOut);
                fOut.flush();
                fOut.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return path;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            return path;
        }
        return path;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void deleteTempImage() {
        File file = new File(this.tempImagePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public void showToastString(String str) {
        Toast.makeText(this.context, str, 1).show();
    }

    public void showLogString(String str) {
        Log.w("cqq_log", str);
    }

    private String getImagePath(Uri uri) {
        int photoColumn;
        String path = null;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null || "file".equals(scheme)) {
            path = uri.getPath();
        } else if ("content".equals(scheme)) {
            Cursor cursor = this.activity.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (!(cursor == null || (photoColumn = cursor.getColumnIndex("_data")) == -1)) {
                cursor.moveToFirst();
                path = cursor.getString(photoColumn);
            }
            cursor.close();
        }
        return path;
    }

    public class LocalSessionCredentialProvider extends BasicLifecycleCredentialProvider {
        private long expiredTime;
        private String sessionToken;
        private String tempSecretId;
        private String tempSecretKey;

        public LocalSessionCredentialProvider(String tempSecretId2, String tempSecretKey2, String sessionToken2, long expiredTime2) {
            this.tempSecretId = tempSecretId2;
            this.tempSecretKey = tempSecretKey2;
            this.sessionToken = sessionToken2;
            this.expiredTime = expiredTime2;
        }

        @Override // com.tencent.qcloud.core.auth.BasicLifecycleCredentialProvider
        public QCloudLifecycleCredentials fetchNewCredentials() throws CosXmlClientException {
            return new SessionQCloudCredentials(this.tempSecretId, this.tempSecretKey, this.sessionToken, this.expiredTime);
        }
    }
}
