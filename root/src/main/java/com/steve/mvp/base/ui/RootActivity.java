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

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.steve.mvp.base.R;
import com.steve.mvp.base.utils.RootKeyboardUtils;
import com.steve.mvp.base.utils.RootUtils;

public abstract class RootActivity extends AppCompatActivity implements RootView{
    private String TAG = RootActivity.class.getSimpleName();
    private ProgressDialog mProgressDialog;

    @Override
    public void showLoading() {
        hideLoading();
        hideKeyboard();
        mProgressDialog = RootUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    private void showSnackBar(String message, int color) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
        Log.e(TAG, "ShowSnackBar: " + message);
    }

    @Override
    public void showToast(int message) {
        showToast(getString(message));
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        hideLoading();
        if (message != null) {
            showSnackBar(message, Color.RED);
        } else {
            showSnackBar(getString(R.string.error_occur), Color.RED);
        }
    }

    protected void enableSlideInTransition() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    protected void enableSlideOutTransition() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override
    public void showError(@StringRes int resId) {
        showError(getString(resId));
    }

    @Override
    public void showSuccess(@StringRes int resId) {
        showSuccess(getString(resId));
    }

    @Override
    public void showSuccess(String message) {
        hideLoading();
        if (message != null) {
            showSnackBar(message, Color.GREEN);
        } else {
            showSnackBar(getString(R.string.error_occur), Color.GREEN);
        }
    }

    @Override
    public void hideKeyboard() {
        RootKeyboardUtils.hideSoftInput(this);
    }

    @Override
    public void showKeyboard(EditText editText) {
        RootKeyboardUtils.showSoftInput(editText, this);
    }

    protected void navigateActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    protected abstract void setUp();

    protected void onPreCreate() {
    }

    @Override
    public void callFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Override
    public void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
