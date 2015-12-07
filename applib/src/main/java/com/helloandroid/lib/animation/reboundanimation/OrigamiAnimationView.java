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
public class OrigamiAnimationView extends FrameLayout {

    private final SpringSystem springSystem;
    //    private final Spring popAnimationSpring;
    private final Spring composerIsVisibleSpring;
    private final Spring feedSlidingSpring;
    private final Spring postScalingSpring;
    private final Spring popAnimationSpring;
    private final View layer;

    public OrigamiAnimationView(Context context) {
        this(context, null);
    }

    public OrigamiAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OrigamiAnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // Hook up variables to your views here
        layer = new ImageView(context);
        layer.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layer.setBackground(context.getDrawable(R.drawable.marshmallow1));
        addView(layer);

        springSystem = SpringSystem.create();

//        popAnimationSpring = springSystem.createSpring()
//                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(10, 10))
//                .addListener(new SimpleSpringListener() {
//                    @Override
//                    public void onSpringUpdate(Spring spring) {
//                        setPopAnimationProgress((float) spring.getCurrentValue());
//                    }
//                });

        composerIsVisibleSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(1, 5))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setComposerIsVisibleProgress((float) spring.getCurrentValue());
                    }
                });

        feedSlidingSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(5, 10))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setFeedSlidingProgress((float) spring.getCurrentValue());
                    }
                });

        postScalingSpring = springSystem.createSpring()
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(5, 10))
                .addListener(new SimpleSpringListener() {
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        setPostScalingProgress((float) spring.getCurrentValue());
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

    // popAnimation transition

//    public void popAnimation(boolean on) {
//        popAnimationSpring.setEndValue(on ? 1 : 0);
//    }
//
//    public void setPopAnimationProgress(float progress) {
//        float transition2 = transition(progress, 1f, 0.8f);
//        layer.setScaleX(transition2);
//        layer.setScaleY(transition2);
//    }

    // composerIsVisible transition

    public void composerIsVisible(boolean on) {
        composerIsVisibleSpring.setEndValue(on ? 1 : 0);
    }

    public void setComposerIsVisibleProgress(float progress) {
//        float yPosition2 = transition(progress, -1, 341f, 0f);
        float yPosition2 = transition(progress, -1, 0f);
        layer.setTranslationY(yPosition2);
    }

    // feedSliding transition

    public void feedSliding(boolean on) {
        feedSlidingSpring.setEndValue(on ? 1 : 0);
    }

    public void setFeedSlidingProgress(float progress) {
        float pixelsHigh2 = transition(progress, 2, 000f);
//        float pixelsHigh2 = transition(progress, 2, 100f, 3, 000f);


        float transition2 = transition(progress, 0f, 14.0625f);
    }

    // postScaling transition

    public void postScaling(boolean on) {
        postScalingSpring.setEndValue(on ? 1 : 0);
    }

    public void setPostScalingProgress(float progress) {
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

