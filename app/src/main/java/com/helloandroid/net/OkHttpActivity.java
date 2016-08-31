package com.helloandroid.net;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.helloandroid.app.MainApplication;
import com.helloandroid.app.R;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by scott on 15/10/25.
 */
public class OkHttpActivity extends AppCompatActivity {
    @Inject OkHttpClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getApplication()).getNetComponent().inject(this);

        String url = getString(R.string.test_pic2);
        Observable.just(url)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        Request request = new Request.Builder()
                                .url(s)
                                .build();

                        Response response = null;
                        try {
                            response = client.newCall(request).execute();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (response != null)
                            return response.headers().toString();
                        else
                            return null;
                    }
                })
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
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG)
                                .show();
                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG)
                                .show();
                    }
                });

    }
}
