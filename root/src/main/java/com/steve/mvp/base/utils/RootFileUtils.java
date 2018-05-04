/*
 * Copyright 2018 Steve Tchatchouang
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.steve.mvp.base.utils;

import android.os.Environment;

public abstract class RootFileUtils {
    public static boolean isMemoryAvailable(int minMBSize) {
        long minSpace = (long) (minMBSize * Math.pow(1024, 2));
        return Environment.getExternalStorageDirectory().getTotalSpace() > minSpace;
    }
}
