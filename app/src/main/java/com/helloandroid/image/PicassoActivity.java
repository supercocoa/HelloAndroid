package com.helloandroid.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.helloandroid.app.R;
import com.squareup.picasso.Picasso;

/**
 * Created by scott on 15/10/20.
 */
public class PicassoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(imageView);

        Picasso.with(this)
                .load(getString(R.string.test_pic1))
                .placeholder(R.drawable.abc_btn_check_material)
                .error(R.drawable.abc_btn_radio_material)
                .into(imageView);
    }
}
