package com.helloandroid.image;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.helloandroid.app.R;
import com.wnafee.vector.compat.ResourcesCompat;

/**
 * Created by scott on 15/11/14.
 */
public class VectorCompatActivity extends AppCompatActivity {
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
//        imageView.setBackground(getDrawable(R.drawable.homer_simpson));
//        imageView.setBackground(ResourcesCompat.getDrawable(this, R.drawable.homer_simpson));
        Drawable vectorDrawable = ResourcesCompat.getDrawable(this, R.drawable.homer_simpson);
        vectorDrawable.setAlpha(50);
        imageView.setImageDrawable(vectorDrawable);
    }
}
