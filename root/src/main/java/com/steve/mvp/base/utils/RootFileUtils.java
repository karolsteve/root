package com.steve.mvp.base.utils;

import android.os.Environment;

public abstract class RootFileUtils {
    public static boolean isMemoryAvailable(int minMBSize) {
        long minSpace = (long) (minMBSize * Math.pow(1024, 2));
        return Environment.getExternalStorageDirectory().getTotalSpace() > minSpace;
    }
}
