package com.helloandroid.lib.language.duktape;

import android.content.Context;
import com.squareup.duktape.Duktape;
import okio.BufferedSource;
import okio.Okio;

import java.io.IOException;

/**
 * Created by scott on 16/5/30.
 */
public class BridgeEngine {

    BridgeImpl bridge;
    Duktape duktape;

    static String _regexStr = "(?<!\\\\)\\.\\s*(\\w+)\\s*\\(";
    static String _replaceStr = ".__c(\"$1\")(";

    Context context;

    public BridgeEngine(Context context) {
        this.context = context;
    }

    public void start() {
        duktape = Duktape.create();
        bridge = new BridgeImpl();

        try {
            duktape.bind("Bridge", Bridge.class, bridge);
            evaluateFile("jsbridge.js", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void evaluateScript(String script) {
        try {
            duktape.evaluate(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void evaluateFile(String file, boolean replace) {
        BufferedSource source = null;
        String script = null;
        try {
            source = Okio.buffer(Okio.source(context.getAssets().open(file)));
            script = source.readUtf8();
            source.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (replace) {
            script = script.replaceAll(_regexStr, _replaceStr);
        }

        try {
            duktape.evaluate(script, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        duktape.close();
    }

    public static String replaceLine(String line) {
        return line.replaceAll(_regexStr, _replaceStr);
    }
}
