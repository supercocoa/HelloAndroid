package com.helloandroid.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.helloandroid.app.R;

/**
 * Created by scott on 16/1/14.
 */
public class GlideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(imageView);

        Glide.with(this)
                .load(getString(R.string.test_pic1))
                .placeholder(R.drawable.abc_btn_check_material)
                .error(R.drawable.abc_btn_radio_material)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }
}
