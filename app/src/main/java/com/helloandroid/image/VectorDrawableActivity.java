package com.helloandroid.image;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.helloandroid.app.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by scott on 16/6/1.
 */
public class VectorDrawableActivity extends AppCompatActivity {

    @Bind(R.id.imageView) ImageView imageView;
    @Bind(R.id.view) View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vectordrawable);
        ButterKnife.bind(this);

//        imageView.setImageResource(R.drawable.ic_homer_simpson);
//        imageView.setBackground(getResources().getDrawable(R.drawable.ic_homer_simpson));
    }
}
