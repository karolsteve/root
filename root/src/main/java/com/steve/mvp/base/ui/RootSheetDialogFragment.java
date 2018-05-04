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

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomSheetDialogFragment;
import android.widget.EditText;

public abstract class RootSheetDialogFragment extends BottomSheetDialogFragment implements RootView{
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
