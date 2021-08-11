package com.wanmei.sdk.core.config;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.wanmei.sdk.core.net.C1767a;
import com.wanmei.sdk.core.open.Channel;
import com.wanmei.sdk.core.open.SDKInterface;
import com.wanmei.sdk.core.util.C1845f;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelsReader {
    private static final String CHANNEL_FILE_NAME = "OneSDKchannels.config";
    private static final String TAG = ChannelsReader.class.getName();
    private Context mContext;

    /* access modifiers changed from: private */
    public class ChannelReadTask extends AsyncTask<Integer, Integer, Channel> {
        private SDKInterface.ReadChannelCallBack mReadChannelCallBack;

        public ChannelReadTask(SDKInterface.ReadChannelCallBack readChannelCallBack) {
            this.mReadChannelCallBack = readChannelCallBack;
        }

        /* access modifiers changed from: protected */
        public Channel doInBackground(Integer... params) {
            return ChannelsReader.this.getChannel(params[0].intValue());
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Channel channel) {
            super.onPostExecute((Object) channel);
            if (channel == null) {
                this.mReadChannelCallBack.failed("channel is empty,maybe channel id is error,OneSDKchannels.config is error");
            } else {
                this.mReadChannelCallBack.succeed(channel);
            }
        }
    }

    public ChannelsReader(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Channel getChannel(int channelId) {
        try {
            String channles = readChannelFile();
            if (TextUtils.isEmpty(channles)) {
                Log.e(TAG, "readChannelFile result is null");
                return null;
            }
            try {
                String optString = new JSONObject(channles).optString(new StringBuilder().append(channelId).toString());
                if (TextUtils.isEmpty(optString)) {
                    Log.e(TAG, "jsonObject do not have the channelId");
                    return null;
                }
                Channel channel = (Channel) C1767a.m6507a(optString, Channel.class);
                if (channel != null) {
                    return channel;
                }
                Log.e(TAG, "JsonHelper parse error");
                return null;
            } catch (JSONException e) {
                Log.e(TAG, "readChannelFile result is not json");
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            Log.e(TAG, "readChannelFile failed");
            e2.printStackTrace();
            return null;
        }
    }

    private String readChannelFile() throws IOException {
        return C1845f.m6693b(this.mContext.getAssets().open(CHANNEL_FILE_NAME));
    }

    public void getChannel(int channelId, SDKInterface.ReadChannelCallBack readChannelCallBack) {
        new ChannelReadTask(readChannelCallBack).execute(Integer.valueOf(channelId));
    }
}
