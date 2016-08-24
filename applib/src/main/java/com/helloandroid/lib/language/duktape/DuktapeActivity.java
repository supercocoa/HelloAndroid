package com.helloandroid.lib.language.duktape;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.duktape.Duktape;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by scott on 16/5/23.
 */

public class DuktapeActivity extends Activity {
    public static final String TAG = "DuktapeActivity";

    interface Utf8 {
        String fromHex(String hex);
    }

    Utf8 utf8 = new Utf8() {
        @Override
        public String fromHex(String hex) {
            return okio.ByteString.decodeHex(hex).utf8();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(view);


    }

    @Override
    protected void onResume() {
        super.onResume();

        Observable.create(subscriber -> {
            evaluateHelloWorld();
            evaluateUtf8();
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    private void evaluateHelloWorld() {
        Duktape duktape = Duktape.create();
        try {
            Log.d(TAG, duktape.evaluate("'hello world'.toUpperCase();"));
        } finally {
            duktape.close();
        }
    }

    private void evaluateUtf8() {
        Duktape duktape = Duktape.create();
        try {
            // Bind our interface to a JavaScript object called Utf8.
            duktape.bind("Utf8", Utf8.class, utf8);

            String greeting = duktape.evaluate("" +
                    // Here we have a hex encoded string.
                    "var hexEnc = 'EC9588EB8595ED9598EC84B8EC9A9421';\n" +
                    // Call out to Java to decode it!
                    "var message = Utf8.fromHex(hexEnc);\n" +
                    "message;");

            Log.d(TAG, greeting);
        } finally {
            duktape.close();
        }
    }
}
