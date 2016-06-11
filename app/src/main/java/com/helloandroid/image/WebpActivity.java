package com.helloandroid.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.helloandroid.app.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by scott on 16/6/3.
 */

public class WebpActivity extends AppCompatActivity {

    @Bind(R.id.imageView1) ImageView imageView1;
    @Bind(R.id.imageView2) ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webp);
        ButterKnife.bind(this);
    }
}
