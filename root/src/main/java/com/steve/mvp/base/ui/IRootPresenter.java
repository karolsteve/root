package com.steve.mvp.base.ui;

import com.steve.mvp.base.data.RootDataManager;

public interface IRootPresenter<V extends RootView> {
    V getView();

    RootDataManager getDataManager();
}
