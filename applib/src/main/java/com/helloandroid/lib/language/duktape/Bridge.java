package com.helloandroid.lib.language.duktape;

/**
 * Created by scott on 16/5/30.
 */

public interface Bridge {

    String newInt(int i);

    String newString(String str);

    String newObject(String className);

    String call(int objectId, String methodName, String argsStr);

    String invoke(String className, String methodName, String argsStr);

    void logString(String tag, String str);

    void logObject(String tag, String obj);

}
