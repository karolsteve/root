package com.steve.mvp.base;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.steve.mvp.base.utils.TypeFaceUtils;

/**
 * Created by Steve Tchatchouang
 */
public abstract class RootAppShell extends Application {
    private static final String DEFAULT_FONT_NAME = "SERIF";

    public static volatile Handler applicationHandler;

    private        LruCache<String, Bitmap> mMemoryCache;
    private static RootAppShell             sInstance;

    private static final String TAG = RootAppShell.class.getSimpleName();

    public static synchronized RootAppShell getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        applicationHandler = new Handler(Looper.getMainLooper());
        initializeLruCache();
    }

    public static synchronized void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            getInstance().mMemoryCache.put(key, bitmap);
        }
    }

    public static synchronized Bitmap getBitmapFromMemCache(String key) {
        return getInstance().mMemoryCache.get(key);
    }

    private void initializeLruCache() {
        // Get max available VM memory, exceeding this amount will throw an
        // OutOfMemory exception. Stored in kilobytes as LruCache takes an
        // int in its constructor.
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        Log.e(TAG, "initializeLruCache: Max memory : " + maxMemory + " KB");

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };
        Log.e(TAG, "initializeLruCache: lru cache initialized");
    }

    public static String getPlayStoreLink() {
        return "https://play.google.com/store/apps/details?id=" + getInstance().getPackageName();
    }

    public void swapDefaultFont(String fontPath){
        TypeFaceUtils.overrideFont(getApplicationContext(), DEFAULT_FONT_NAME, fontPath);
    }
}
