package com.steve.rootexample.ui.base;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.EditText;

import com.steve.mvp.base.ui.RootSheetDialogFragment;

public abstract class BaseSheetDialogFragment extends RootSheetDialogFragment implements BaseView {
    private BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (BaseActivity) context;
        } else
            throw new IllegalArgumentException("Activity must be child of BaseActivity");
    }

    @Override
    public void showError(String message) {
        if (mActivity != null) mActivity.showError(message);
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
    public void showError(@StringRes int res) {
        if (mActivity != null) mActivity.showError(res);
    }

    @Override
    public void showSuccess(String message) {
        if (mActivity != null) mActivity.showSuccess(message);
    }

    @Override
    public void showSuccess(@StringRes int res) {
        if (mActivity != null) mActivity.showSuccess(res);
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) mActivity.hideKeyboard();
    }

    @Override
    public void callFinishAfterTransition() {
        if(mActivity != null) mActivity.callFinishAfterTransition();
    }

    @Override
    public void showLoading() {
        if (mActivity != null) mActivity.showLoading();
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) mActivity.hideLoading();
    }

    @Override
    public void showKeyboard(EditText editText) {
        if(mActivity != null) mActivity.showKeyboard(editText);
    }

    @Override
    public void openBrowser(String url) {
        if(mActivity != null) mActivity.openBrowser(url);
    }
}
