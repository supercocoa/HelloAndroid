package com.helloandroid.lib.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.helloandroid.lib.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by scott on 15/11/1.
 */
public class AVLoadingIndicatorViewActivity extends Activity {

    AVLoadingIndicatorView avLoadingIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avlloading_indicator_view);
        avLoadingIndicatorView = (AVLoadingIndicatorView) findViewById(R.id.avloadingIndicatorView);

        startAnim();
    }


    void startAnim() {
        avLoadingIndicatorView.setVisibility(View.VISIBLE);
    }

    void stopAnim() {
        avLoadingIndicatorView.setVisibility(View.GONE);
    }
}
