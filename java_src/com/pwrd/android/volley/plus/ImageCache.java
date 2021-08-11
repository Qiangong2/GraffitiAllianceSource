package com.pwrd.android.volley.plus;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.support.p007v4.util.LruCache;
import android.text.TextUtils;
import android.util.Log;
import com.pwrd.android.volley.plus.DiskLruCache;
import com.pwrd.android.volley.toolbox.ImageLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ImageCache implements ImageLoader.ImageCache, PersistentCache {
    private static final boolean DEFAULT_CLEAR_DISK_CACHE_ON_START = false;
    private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    private static final int DEFAULT_COMPRESS_QUALITY = 70;
    private static final boolean DEFAULT_DISK_CACHE_ENABLED = true;
    private static final int DEFAULT_DISK_CACHE_SIZE = 20971520;
    private static final boolean DEFAULT_INIT_DISK_CACHE_ON_CREATE = true;
    private static final boolean DEFAULT_MEM_CACHE_ENABLED = true;
    private static final int DEFAULT_MEM_CACHE_SIZE = 5242880;
    private static final int DISK_CACHE_INDEX = 0;
    static final String TAG = "ImageCache";
    private ImageCacheParams mCacheParams;
    private final Object mDiskCacheLock = new Object();
    private boolean mDiskCacheStarting = true;
    private DiskLruCache mDiskLruCache;
    private LruCache<String, Bitmap> mMemoryCache;

    public ImageCache(ImageCacheParams cacheParams) {
        init(cacheParams);
    }

    private void init(ImageCacheParams cacheParams) {
        this.mCacheParams = cacheParams;
        if (this.mCacheParams.memoryCacheEnabled) {
            this.mMemoryCache = new LruCache<String, Bitmap>(this.mCacheParams.memCacheSize) {
                /* class com.pwrd.android.volley.plus.ImageCache.C12231 */

                /* access modifiers changed from: protected */
                public int sizeOf(String key, Bitmap bitmap) {
                    return ImageCache.getBitmapSize(bitmap);
                }
            };
        }
        if (cacheParams.initDiskCacheOnCreate) {
            initDiskCache();
        }
    }

    private void initDiskCache() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache == null || this.mDiskLruCache.isClosed()) {
                File diskCacheDir = this.mCacheParams.diskCacheDir;
                if (this.mCacheParams.diskCacheEnabled && diskCacheDir != null) {
                    if (!diskCacheDir.exists()) {
                        diskCacheDir.mkdirs();
                    }
                    if (getUsableSpace(diskCacheDir) > ((long) this.mCacheParams.diskCacheSize)) {
                        try {
                            this.mDiskLruCache = DiskLruCache.open(diskCacheDir, 1, 1, (long) this.mCacheParams.diskCacheSize);
                        } catch (IOException e) {
                            this.mCacheParams.diskCacheDir = null;
                            Log.e(TAG, "initDiskCache - " + e);
                        }
                    }
                }
            }
            this.mDiskCacheStarting = false;
            this.mDiskCacheLock.notifyAll();
        }
    }

    @Override // com.pwrd.android.volley.toolbox.ImageLoader.ImageCache
    public void addBitmapToCache(String key, Bitmap bitmap, Bitmap.CompressFormat format) {
        if (key != null && bitmap != null) {
            if (this.mMemoryCache != null && this.mMemoryCache.get(key) == null) {
                this.mMemoryCache.put(key, bitmap);
            }
            synchronized (this.mDiskCacheLock) {
                if (this.mDiskLruCache != null) {
                    OutputStream out = null;
                    try {
                        DiskLruCache.Snapshot snapshot = this.mDiskLruCache.get(key);
                        if (snapshot == null) {
                            DiskLruCache.Editor editor = this.mDiskLruCache.edit(key);
                            if (editor != null) {
                                out = editor.newOutputStream(0);
                                bitmap.compress(format, this.mCacheParams.compressQuality, out);
                                editor.commit();
                                out.close();
                            }
                        } else {
                            snapshot.getInputStream(0).close();
                        }
                        try {
                            flush();
                            if (out != null) {
                                out.close();
                            }
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        Log.e(TAG, "addBitmapToCache - " + e2);
                        try {
                            flush();
                            if (0 != 0) {
                                out.close();
                            }
                        } catch (IOException e3) {
                        }
                    } catch (Exception e4) {
                        Log.e(TAG, "addBitmapToCache - " + e4);
                        try {
                            flush();
                            if (0 != 0) {
                                out.close();
                            }
                        } catch (IOException e5) {
                        }
                    } catch (Throwable th) {
                        try {
                            flush();
                            if (0 != 0) {
                                out.close();
                            }
                        } catch (IOException e6) {
                        }
                        throw th;
                    }
                }
            }
        }
    }

    @Override // com.pwrd.android.volley.toolbox.ImageLoader.ImageCache
    public void addBitmapToMemCache(String key, Bitmap bitmap) {
        if (this.mMemoryCache != null && this.mMemoryCache.get(key) == null) {
            this.mMemoryCache.put(key, bitmap);
        }
    }

    @Override // com.pwrd.android.volley.toolbox.ImageLoader.ImageCache
    public Bitmap getBitmapFromMemCache(String url) {
        Bitmap memBitmap;
        if (this.mMemoryCache == null || url == null || url.equals("") || (memBitmap = this.mMemoryCache.get(getCacheKey(url))) == null) {
            return null;
        }
        return memBitmap;
    }

    @Override // com.pwrd.android.volley.toolbox.ImageLoader.ImageCache
    public Bitmap getBitmapFromDiskCache(String key, int width, int height) {
        synchronized (this.mDiskCacheLock) {
            while (this.mDiskCacheStarting) {
                try {
                    this.mDiskCacheLock.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.mDiskLruCache != null) {
                InputStream inputStream = null;
                try {
                    DiskLruCache.Snapshot snapshot = this.mDiskLruCache.get(key);
                    if (snapshot != null && (inputStream = snapshot.getInputStream(0)) != null) {
                        Bitmap decodeSampledBitmapFromStream = ImageReSizer.decodeSampledBitmapFromStream(inputStream, width, height);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        return decodeSampledBitmapFromStream;
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException e4) {
                    Log.e(TAG, "getBitmapFromDiskCache - " + e4);
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            }
            return null;
        }
    }

    public void clearCache() {
        if (this.mMemoryCache != null) {
            this.mMemoryCache.evictAll();
        }
        synchronized (this.mDiskCacheLock) {
            this.mDiskCacheStarting = true;
            if (this.mDiskLruCache != null && !this.mDiskLruCache.isClosed()) {
                try {
                    this.mDiskLruCache.delete();
                } catch (IOException e) {
                    Log.e(TAG, "clearCache - " + e);
                }
                this.mDiskLruCache = null;
                initDiskCache();
            }
        }
    }

    public void flush() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    this.mDiskLruCache.flush();
                } catch (IOException e) {
                    Log.e(TAG, "flush - " + e);
                }
            }
        }
    }

    public void close() {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    if (!this.mDiskLruCache.isClosed()) {
                        this.mDiskLruCache.close();
                        this.mDiskLruCache = null;
                    }
                } catch (IOException e) {
                    Log.e(TAG, "close - " + e);
                }
            }
        }
    }

    @Override // com.pwrd.android.volley.plus.PersistentCache
    public void setPersistent(String url) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    this.mDiskLruCache.setPersistent(getCacheKey(url));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.pwrd.android.volley.plus.PersistentCache
    public void setBrittle(String url) {
        synchronized (this.mDiskCacheLock) {
            if (this.mDiskLruCache != null) {
                try {
                    this.mDiskLruCache.setBrittle(getCacheKey(url));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isStorageWritable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String hashKeyForDisk(String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        try {
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            return bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(key.hashCode());
        }
    }

    @Override // com.pwrd.android.volley.toolbox.ImageLoader.ImageCache
    public String getCacheKey(String url) {
        return hashKeyForDisk(url);
    }

    public static class ImageCacheParams {
        public boolean clearDiskCacheOnStart = false;
        public Bitmap.CompressFormat compressFormat = ImageCache.DEFAULT_COMPRESS_FORMAT;
        public int compressQuality = ImageCache.DEFAULT_COMPRESS_QUALITY;
        public File diskCacheDir;
        public boolean diskCacheEnabled = true;
        public int diskCacheSize = ImageCache.DEFAULT_DISK_CACHE_SIZE;
        public boolean initDiskCacheOnCreate = true;
        public int memCacheSize = ImageCache.DEFAULT_MEM_CACHE_SIZE;
        public boolean memoryCacheEnabled = true;

        public ImageCacheParams(Context context, String uniqueName) {
            this.diskCacheDir = ImageCache.getDiskCacheDir(context, uniqueName);
        }

        public ImageCacheParams(File diskCacheDir2) {
            this.diskCacheDir = diskCacheDir2;
        }

        public void setDiskCacheSize(int diskCacheSize2) {
            if (diskCacheSize2 < 1048576) {
                throw new IllegalArgumentException("setDiskCacheSize - disk cache size must be bigger than 1MB");
            }
            this.diskCacheSize = diskCacheSize2;
        }

        public void setMemCacheSizePercent(Context context, float percent) {
            if (percent < 0.05f || percent > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
            }
            this.memCacheSize = Math.round(((float) getMemoryClass(context)) * percent * 1024.0f * 1024.0f);
        }

        private static int getMemoryClass(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }
    }

    public static File getDiskCacheDir(Context context, String uniqueName) {
        if (!isSdCardOK()) {
            return null;
        }
        return new File(String.valueOf("mounted".equals(Environment.getExternalStorageState()) ? getExternalCacheDir(context).getPath() : context.getCacheDir().getPath()) + File.separator + uniqueName);
    }

    private static boolean isSdCardOK() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(aByte & 255);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public static int getBitmapSize(Bitmap bitmap) {
        if (OsVersionUtils.hasHoneycombMR1()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static boolean isExternalStorageRemovable() {
        return !OsVersionUtils.hasGingerbread() || Environment.isExternalStorageRemovable();
    }

    public static File getExternalCacheDir(Context context) {
        File file;
        return (!OsVersionUtils.hasFroyo() || (file = context.getExternalCacheDir()) == null) ? new File(String.valueOf(Environment.getExternalStorageDirectory().getPath()) + ("/Android/data/" + context.getPackageName() + "/cache/")) : file;
    }

    public static long getUsableSpace(File path) {
        if (OsVersionUtils.hasGingerbread()) {
            return path.getUsableSpace();
        }
        StatFs stats = new StatFs(path.getPath());
        return ((long) stats.getBlockSize()) * ((long) stats.getAvailableBlocks());
    }
}
