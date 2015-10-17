package com.helloandroid.framework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by scott on 15/10/17.
 */
public class RxAndroidActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.just("1", "2", "3")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(getApplicationContext(), "finish", Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }


}
