package com.steve.mvp.base.utils;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.steve.mvp.base.R;

public abstract class RootAnimUtils {
    public static void shakeView(Context context, View view,int duration) {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) vibrator.vibrate(duration);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.shake);
        view.startAnimation(animation);
    }

    public static void blink(final View view, int duration, int repeatCount,int... colors ) {
        ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), colors);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color = (int) animation.getAnimatedValue();
                view.setBackgroundColor(color);
            }
        });
        animator.setRepeatCount(repeatCount);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setDuration(duration);
        animator.start();
    }

    public static void animateOut(final @NonNull View view, final @NonNull Animation animation, final int visibility) {
        if (view.getVisibility() != visibility) {
            view.clearAnimation();
            animation.reset();
            animation.setStartTime(0);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(visibility);
                }
            });
            view.startAnimation(animation);
        }
    }

    public static void animateIn(final @NonNull View view, final @NonNull Animation animation) {
        if (view.getVisibility() == View.VISIBLE) return;
        view.clearAnimation();
        animation.reset();
        animation.setStartTime(0);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(animation);
    }
}
