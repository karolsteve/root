package com.steve.rootexample;

import com.steve.mvp.base.RootAppShell;

/**
 * Created by Steve Tchatchouang on 14/12/2017
 */

public class AppShell extends RootAppShell {
    private static final String CUSTOM_FONT_PATH  = "fonts/Roboto-Regular.ttf";


    private static AppShell mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppShell getInstance() {
        return mInstance;
    }
}
