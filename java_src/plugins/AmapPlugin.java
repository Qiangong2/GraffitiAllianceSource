package plugins;

import android.app.Activity;
import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.unity3d.player.UnityPlayer;

public class AmapPlugin implements AMapLocationListener {
    AMapLocationClient mLocationClient = null;
    AMapLocationClientOption mLocationOption = null;

    public void LocationInit(Context context, Activity activity) {
        this.mLocationClient = new AMapLocationClient(context);
        this.mLocationClient.setLocationListener(this);
        this.mLocationOption = new AMapLocationClientOption();
        this.mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        this.mLocationOption.setInterval(60000);
        this.mLocationOption.setWifiActiveScan(false);
        this.mLocationOption.setMockEnable(true);
        this.mLocationClient.setLocationOption(this.mLocationOption);
    }

    public void StartLocation() {
        if (!this.mLocationClient.isStarted()) {
            this.mLocationClient.startLocation();
        }
    }

    public void StopLocation() {
        this.mLocationClient.stopLocation();
    }

    public void Destroy() {
        this.mLocationClient.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public void CallUnityMethod(String arg2, String arg3) {
        UnityPlayer.UnitySendMessage("MainRoot", arg2, arg3);
    }

    @Override // com.amap.api.location.AMapLocationListener
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 0) {
            CallUnityMethod("Android_OnLocationUpdate", String.format("%s,%s,%s", Double.valueOf(aMapLocation.getLatitude()), Double.valueOf(aMapLocation.getLongitude()), aMapLocation.getAdCode()));
            return;
        }
        CallUnityMethod("Android_OnLocationError", String.format("%s,%s", Integer.toString(aMapLocation.getErrorCode()), aMapLocation.getErrorInfo()));
    }
}
