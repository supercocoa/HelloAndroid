package com.helloandroid.lib.animation.reboundanimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import com.helloandroid.lib.R;

/**
 * Created by scott on 15/12/7.
 */
public class OrigamiAnimationView2 extends FrameLayout {
    private final SpringSystem springSystem;
    private final Spring photoIsZoomedOutSpring;
    private final Spring popAnimationSpring;
    private final ImageView photo;
    private final View chrome;

    public OrigamiAnimationView2(Context context) {
        this(context, null);
    }

    public OrigamiAnimationView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrigamiAnimationView2(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // Hook up variables to your views here
        photo = new ImageView(context);
        photo.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        photo.setImageDrawable(context.getDrawable(R.drawable.marshmallow1));
        addView(photo);

        chrome = null;

        springSystem = SpringSystem.create();

        photoIsZoomedOutSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(5, 10))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setPhotoIsZoomedOutProgress((float) spring.getCurrentValue());
                    }
                });

        popAnimationSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(9, 20))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setPopAnimationProgress((float) spring.getCurrentValue());
                    }
                });
    }

    // photoIsZoomedOut transition

    public void photoIsZoomedOut(boolean on) {
        photoIsZoomedOutSpring.setEndValue(on ? 1 : 0);
    }

    public void setPhotoIsZoomedOutProgress(float progress) {
        float scale2 = transition(progress, 1f, 0.37f);
        photo.setScaleX(scale2);
        photo.setScaleY(scale2);

//        float opacity2 = transition(progress, 1f, 0f);
//        chrome.setOpacity(opacity2);
//        chrome.setAlpha(opacity2);
    }

    // popAnimation transition

    public void popAnimation(boolean on) {
        popAnimationSpring.setEndValue(on ? 1 : 0);
    }

    public void setPopAnimationProgress(float progress) {
        float reverse2 = transition(progress, 1f, 0f);
    }

    // Utilities

    public float transition(float progress, float startValue, float endValue) {
        return (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, startValue, endValue);
    }

}

