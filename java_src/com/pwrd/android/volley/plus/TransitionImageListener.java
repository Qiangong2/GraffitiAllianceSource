package com.pwrd.android.volley.plus;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.pwrd.android.volley.VolleyError;
import com.pwrd.android.volley.toolbox.ImageLoader;

public class TransitionImageListener implements ImageLoader.ImageListener {
    private static final int FADE_IN_TIME = 200;
    private static final int MAX_POOL_SIZE = 50;
    private static TransitionImageListener sPool;
    private static int sPoolSize = 0;
    private static final Object sPoolSync = new Object();
    private int defaultImageResId;
    private int errorImageResId;
    TransitionImageListener next;
    private ImageView view;

    public static TransitionImageListener obtain(ImageView view2, int defaultImageResId2, int errorImageResId2) {
        synchronized (sPoolSync) {
            if (sPool == null) {
                return new TransitionImageListener(view2, defaultImageResId2, errorImageResId2);
            }
            TransitionImageListener listener = sPool;
            sPool = listener.next;
            listener.next = null;
            sPoolSize--;
            listener.view = view2;
            listener.defaultImageResId = defaultImageResId2;
            listener.errorImageResId = errorImageResId2;
            return listener;
        }
    }

    public void recycle() {
        clearForRecycle();
        synchronized (sPoolSync) {
            if (sPoolSize < 50) {
                this.next = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearForRecycle() {
        this.defaultImageResId = 0;
        this.errorImageResId = 0;
        this.view = null;
    }

    private TransitionImageListener(ImageView view2, int defaultImageResId2, int errorImageResId2) {
        this.view = view2;
        this.defaultImageResId = defaultImageResId2;
        this.errorImageResId = errorImageResId2;
    }

    @Override // com.pwrd.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError error) {
        if (this.errorImageResId != 0) {
            this.view.setImageResource(this.errorImageResId);
        }
    }

    @Override // com.pwrd.android.volley.toolbox.ImageLoader.ImageListener
    public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
        if (response.getBitmap() != null) {
            if (isImmediate) {
                showNow(response.getBitmap());
            } else {
                transitBitmap(response.getBitmap());
            }
            recycle();
        } else if (this.defaultImageResId != 0 && this.defaultImageResId != -1) {
            this.view.setImageResource(this.defaultImageResId);
        }
    }

    private void showNow(Bitmap bitmap) {
        this.view.setImageBitmap(bitmap);
    }

    private void transitBitmap(Bitmap bitmap) {
        TransitionDrawable td = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), new BitmapDrawable(this.view.getResources(), bitmap)});
        if (this.defaultImageResId == 0 || this.defaultImageResId == -1) {
            this.view.setImageDrawable(new ColorDrawable(-1));
        } else {
            this.view.setImageResource(this.defaultImageResId);
        }
        this.view.setImageDrawable(td);
        td.startTransition(200);
    }
}
