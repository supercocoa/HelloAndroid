package com.helloandroid.lib.language.duktape;

import android.util.Log;

import java.util.HashMap;

import static com.helloandroid.lib.language.duktape.Util.objToJson;
import static com.helloandroid.lib.language.duktape.Util.parseArgs;
import static org.joor.Reflect.on;

/**
 * Created by scott on 16/5/30.
 */

public class BridgeImpl implements Bridge {

    public static final String TAG = "Bridge";

    HashMap<Integer, Object> id2Object = new HashMap<>();

    @Override
    public String newInt(int i) {
        Integer integer = i;
        id2Object.put(System.identityHashCode(integer), integer);
        return objToJson(integer);
    }

    @Override
    public String newString(String s) {
        id2Object.put(System.identityHashCode(s), s);
        return objToJson(s);
    }

    @Override
    public String newObject(String className) {
        Object object = on(className).create().get();
        id2Object.put(System.identityHashCode(object), object);

        return objToJson(object);
    }

    @Override
    public String call(int objectId, String methodName, String argsStr) {
        Object object = id2Object.get(objectId);
        if (object != null) {
            Object[] args = parseArgs(argsStr, id2Object);
            Object ret = on(object).call(methodName, args).get();
            if (ret != null) {
                id2Object.put(System.identityHashCode(ret), ret);
                return objToJson(ret);
            }
        }
        return "";
    }

    @Override
    public String invoke(String className, String methodName, String argsStr) {
        return "";
    }

    @Override
    public void logString(String tag, String str) {
        Log.v(tag, str);
    }

    @Override
    public void logObject(String tag, String obj) {
        Object object = id2Object.get(Util.jsonToObj(obj).__obj);
        if (object != null) {
            Log.v(tag, object.toString());
        }
    }


}
