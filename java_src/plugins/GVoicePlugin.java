package plugins;

import android.app.Activity;
import android.content.Context;
import com.tencent.gcloud.voice.GCloudVoiceEngine;

public class GVoicePlugin {
    public void VoiceInit(Context context, Activity activity) {
        GCloudVoiceEngine.getInstance().init(context, activity);
    }
}
