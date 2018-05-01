
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
