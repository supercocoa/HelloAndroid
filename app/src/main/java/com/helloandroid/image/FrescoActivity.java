package com.helloandroid.image;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.helloandroid.app.R;

/**
 * Created by scott on 15/9/9.
 */
public class FrescoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this);
        simpleDraweeView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(simpleDraweeView);

        Uri uri = Uri.parse(getString(R.string.test_pic1));
        simpleDraweeView.setImageURI(uri);
    }
}
