package com.steve.mvp.base.ui;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.widget.EditText;

public abstract class RootFragment extends Fragment implements RootView{
    private RootActivity mActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof RootActivity) {
            this.mActivity = (RootActivity) context;
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        if (mActivity != null) mActivity.showLoading();
    }

    protected void enableSlideInTransition() {
        if (mActivity != null) mActivity.enableSlideInTransition();
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) mActivity.hideLoading();
    }

    @Override
    public void showError(String message) {
        if (mActivity != null) {
            mActivity.showError(message);
        }
    }

    @Override
    public void showToast(String message) {
        if (mActivity != null) {
            mActivity.showToast(message);
        }
    }

    @Override
    public void showToast(int message) {
        if (mActivity != null) {
            mActivity.showToast(message);
        }
    }

    @Override
    public void showError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showError(resId);
        }
    }

    @Override
    public void showSuccess(String message) {
        if (mActivity != null) {
            mActivity.showSuccess(message);
        }
    }

    @Override
    public void showSuccess(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showSuccess(resId);
        }
    }

    @Override
    public void callFinishAfterTransition() {
        if (mActivity != null) mActivity.callFinishAfterTransition();
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void showKeyboard(EditText editText) {
        if (mActivity != null) mActivity.showKeyboard(editText);
    }

    @Override
    public void openBrowser(String url) {
        if(mActivity != null) mActivity.openBrowser(url);
    }
}
