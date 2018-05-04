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

package com.steve.mvp.base.ui;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class RootPresenter<V extends RootView> implements IRootPresenter<V>{
    protected static final Executor executor = new ThreadPoolExecutor(
            1,
            3,
            1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>()
    );

    private V mView;

    public RootPresenter(V view) {
        this.mView = view;
    }

    @Override
    public V getView() {
        return mView;
    }
}
