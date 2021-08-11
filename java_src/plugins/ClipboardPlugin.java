package plugins;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.unity3d.player.UnityPlayer;

public class ClipboardPlugin {
    public static ClipboardManager clipboardMgr = null;
    private Activity activity;
    private Context context;

    public void Init(Context context2, Activity activity2) {
        this.context = context2;
        this.activity = activity2;
        clipboardMgr = (ClipboardManager) activity2.getSystemService("clipboard");
    }

    public void copyTextToClipboard(String text) {
        if (clipboardMgr != null) {
            clipboardMgr.setPrimaryClip(ClipData.newPlainText("data", text));
        }
    }

    public void getTextFromClipboard() {
        String result = "";
        if (clipboardMgr != null && clipboardMgr.hasPrimaryClip() && clipboardMgr.getPrimaryClipDescription().hasMimeType("text/plain")) {
            result = clipboardMgr.getPrimaryClip().getItemAt(0).getText().toString();
        }
        UnityPlayer.UnitySendMessage("UIRoot", "StartServiceResult", result);
    }
}
