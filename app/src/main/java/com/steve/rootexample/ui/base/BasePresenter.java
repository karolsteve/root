
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

package com.steve.rootexample.ui.base;


import com.steve.mvp.base.ui.RootPresenter;
import com.steve.rootexample.data.DataManager;

public class BasePresenter<V extends BaseView> extends RootPresenter<V> implements IBasePresenter<V> {

    public BasePresenter(V view) {
        super(view);
    }

    @Override
    public DataManager getDataManager() {
        return new DataManager();
    }
}
