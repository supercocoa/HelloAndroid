package com.helloandroid.lib.language;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.duktape.Duktape;

import org.joor.Reflect;

import rx.Observable;
import rx.Subscriber;
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

    interface Bridge {
        Object newObject(String className);


        Object call(Object object, String methodName, Object... args);
    }

    Bridge bridge = new Bridge() {
        @Override
        public Object newObject(String className) {
            return Reflect.on(className).create().get();
        }


        @Override
        public Object call(Object object, String methodName, Object... args) {
            return Reflect.on(object).call(methodName, args).get();
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

        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
//                evaluateHelloWorld();
//                evaluateUtf8();
                evaluateBridge();
            }
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

    private void evaluateBridge() {
        Duktape duktape = Duktape.create();
        try {
            duktape.bind("Bridge", Bridge.class, bridge);

            String ret = duktape.evaluate("" +
                    "var arrayList = Bridge.newObject(\"java.util.ArrayList\");\n" +
                    "Bridge.call(arrayList, \"add\", 1);\n" +
                    "Bridge.call(arrayList, \"add\", 2);\n" +
                    "var ret = Bridge.call(arrayList, \"get\", 0);\n"
            );

            Log.d(TAG, ret);
        } finally {
            duktape.close();
        }
    }
}
