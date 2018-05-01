package com.steve.rootexample.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.steve.mvp.base.ui.RootFragment;

public abstract class BaseFragment extends RootFragment implements BaseView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }
}
