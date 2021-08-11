package com.igexin.push.extension.distribution.basic.headsup;

import android.view.View;

public class WrapperView {

    /* renamed from: a */
    private View f2147a;

    public WrapperView(View view) {
        this.f2147a = view;
    }

    public int getHeight() {
        return this.f2147a.getLayoutParams().height;
    }

    public int getWidth() {
        return this.f2147a.getLayoutParams().width;
    }

    public void setHeight(int i) {
        this.f2147a.getLayoutParams().height = i;
        this.f2147a.requestLayout();
    }

    public void setWidth(int i) {
        this.f2147a.getLayoutParams().width = i;
        this.f2147a.requestLayout();
    }
}
