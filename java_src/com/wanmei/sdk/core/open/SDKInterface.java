package com.wanmei.sdk.core.open;

import com.wanmei.sdk.core.Proguard;

public interface SDKInterface extends Proguard {

    public interface CompleteCallBack {
        void onComplete();
    }

    public interface ExitCallBack {
        void onChannelHasExitView();

        void onGameHasExitView();
    }

    public interface InitCallBack {
        void initFailed(String str);

        void initSucceed(String str);
    }

    public interface LoginCallBack {
        void cancelled();

        void failed(String str);

        void succeed(String str, String str2, String str3, String str4);
    }

    public interface LogoutCallBack {
        void failed(String str);

        void succeed();
    }

    public interface PayCallBack {
        void cancelled(String str, String str2);

        void failed(String str, String str2);

        void ordered(String str, String str2);

        void succeed(String str, String str2);
    }

    public interface ReadChannelCallBack {
        void failed(String str);

        void succeed(Channel channel);
    }
}
