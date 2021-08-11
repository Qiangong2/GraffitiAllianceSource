package com.wanmei.sdk.core.p106ui.floatview;

import com.wanmei.sdk.core.Proguard;

/* renamed from: com.wanmei.sdk.core.ui.floatview.FloatViewItem */
public class FloatViewItem implements Proguard {
    private String iconName;
    private Runnable runnable;
    private String text;

    public String getIconName() {
        return this.iconName;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public String getText() {
        return this.text;
    }

    public void run() {
        if (this.runnable != null) {
            this.runnable.run();
        }
    }

    public void setIconName(String iconName2) {
        this.iconName = iconName2;
    }

    public void setRunnable(Runnable runnable2) {
        this.runnable = runnable2;
    }

    public void setText(String text2) {
        this.text = text2;
    }
}
