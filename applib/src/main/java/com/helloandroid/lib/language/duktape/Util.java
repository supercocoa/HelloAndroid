package com.helloandroid.lib.language.duktape;

import android.util.Log;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.helloandroid.lib.language.duktape.BridgeImpl.TAG;

/**
 * Created by scott on 16/5/30.
 */
public class Util {
    public static String objToJson(Object object) {
        BridgeObject bridgeObject = new BridgeObject();
        bridgeObject.__obj = System.identityHashCode(object);
        bridgeObject.__clsName = object.getClass().getName();

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<BridgeObject> jsonAdapter = moshi.adapter(BridgeObject.class);

        String json = jsonAdapter.toJson(bridgeObject);

        Log.v(TAG, json);

        return json;
    }

    public static BridgeObject jsonToObj(String json) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<SingleBridgeObject> jsonAdapter = moshi.adapter(SingleBridgeObject.class);

        SingleBridgeObject singleBridgeObject;
        try {
            singleBridgeObject = jsonAdapter.fromJson(json);
            return singleBridgeObject.bridgeObject;
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
        return null;
    }

    public static List<BridgeObject> jsonToObjs(String json) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<MultiBridgeObject> jsonAdapter = moshi.adapter(MultiBridgeObject.class);

        MultiBridgeObject multiBridgeObject;
        try {
            multiBridgeObject = jsonAdapter.fromJson(json);
            return multiBridgeObject.bridgeObjects;
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
        return null;
    }

    public static Object[] parseArgs(String argsStr, HashMap<Integer, Object> id2Object) {
        if (argsStr == null || argsStr.length() == 0) {
            return null;
        }

        List<Object> args = new ArrayList<>();

        List<BridgeObject> bridgeObjects = jsonToObjs(argsStr);
        for (BridgeObject bridgeObject : bridgeObjects) {
            args.add(id2Object.get(bridgeObject.__obj));
        }

        return args.toArray();
    }
}
