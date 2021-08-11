package com.pwrd.android.volley.plus;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public class ImageReSizer {
    private static final String TAG = "ImageResizer";

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        if (!widthHeightCheck(reqWidth, reqHeight)) {
            return BitmapFactory.decodeResource(res, resId);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static Bitmap decodeSampledBitmapFromFile(String filename, int reqWidth, int reqHeight) {
        if (!widthHeightCheck(reqWidth, reqHeight)) {
            return BitmapFactory.decodeFile(filename);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filename, options);
    }

    public static Bitmap decodeSampledBitmapFromStream(InputStream inputStream, int reqWidth, int reqHeight) throws IOException {
        if (!widthHeightCheck(reqWidth, reqHeight)) {
            return BitmapFactory.decodeStream(inputStream);
        }
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Rect rect = new Rect(-1, -1, -1, -1);
        BitmapFactory.decodeStream(inputStream, rect, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        inputStream.reset();
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor fileDescriptor, int reqWidth, int reqHeight) {
        if (!widthHeightCheck(reqWidth, reqHeight)) {
            return BitmapFactory.decodeFileDescriptor(fileDescriptor);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    private static boolean widthHeightCheck(int reqWidth, int reqHeight) {
        return reqWidth > 0 && reqHeight > 0;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (reqWidth <= 0 || reqHeight <= 0) {
            return 1;
        }
        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round(((float) height) / ((float) reqHeight));
            } else {
                inSampleSize = Math.round(((float) width) / ((float) reqWidth));
            }
            while (((float) (width * height)) / ((float) (inSampleSize * inSampleSize)) > ((float) (reqWidth * reqHeight * 2))) {
                inSampleSize++;
            }
        }
        return inSampleSize;
    }
}
