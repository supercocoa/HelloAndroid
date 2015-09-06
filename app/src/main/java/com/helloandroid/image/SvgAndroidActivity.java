package com.helloandroid.image;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.helloandroid.app.R;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGBuilder;

/**
 * Created by scott on 15/9/6.
 */
public class SvgAndroidActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(imageView);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                makeSvg();
            }
        }, 50);
    }

    private void makeSvg() {
        SVG svg = new SVGBuilder()
                .readFromResource(getResources(), R.raw.homer_simpson)
                .build();
        Drawable drawable = svg.getDrawable();
        imageView.setImageDrawable(drawable);
        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
}
