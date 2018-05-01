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
