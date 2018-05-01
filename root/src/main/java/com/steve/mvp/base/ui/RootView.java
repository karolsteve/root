package com.steve.mvp.base.ui;

import android.support.annotation.StringRes;
import android.widget.EditText;

public interface RootView {
    void showLoading();

    void hideLoading();

    void showError(@StringRes int resId);

    void showError(String message);

    void showSuccess(String message);

    void showSuccess(@StringRes int resId);

    void showToast(int message);

    void showToast(String message);

    void hideKeyboard();

    void showKeyboard(EditText editText);

    void callFinishAfterTransition();

    void openBrowser(String url);
}
