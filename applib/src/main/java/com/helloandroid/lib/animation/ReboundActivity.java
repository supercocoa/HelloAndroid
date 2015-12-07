package com.helloandroid.lib.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.helloandroid.lib.R;
import com.helloandroid.lib.animation.reboundanimation.OrigamiAnimationView;

/**
 * Created by scott on 15/12/7.
 */
public class ReboundActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebound);

        final OrigamiAnimationView origamiAnimationView = (OrigamiAnimationView) findViewById(R.id.origamiAnimationView);
//        final OrigamiAnimationView2 origamiAnimationView2 = (OrigamiAnimationView2) findViewById(R.id.origamiAnimationView2);


        origamiAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                origamiAnimationView.feedSliding(true);
//                origamiAnimationView.postScaling(true);
//                origamiAnimationView.photoIsZoomedOut(true);
//                origamiAnimationView.popAnimation(true);
            }
        });
    }
}
