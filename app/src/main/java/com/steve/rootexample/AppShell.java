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
