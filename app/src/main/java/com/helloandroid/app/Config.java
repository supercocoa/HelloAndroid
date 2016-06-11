package com.helloandroid.app;

import com.helloandroid.db.greendao.GreenDaoActivity;
import com.helloandroid.framework.OttoActivity;
import com.helloandroid.framework.RxAndroidActivity;
import com.helloandroid.image.FrescoActivity;
import com.helloandroid.image.GlideActivity;
import com.helloandroid.image.PicassoActivity;
import com.helloandroid.image.SvgAndroidActivity;
import com.helloandroid.image.VectorCompatActivity;
import com.helloandroid.image.VectorDrawableActivity;
import com.helloandroid.image.WebpActivity;
import com.helloandroid.lib.animation.ReboundActivity;
import com.helloandroid.lib.language.duktape.DuktapeActivity;
import com.helloandroid.lib.ui.AVLoadingIndicatorViewActivity;
import com.helloandroid.net.OkHttpActivity;

/**
 * Created by scott on 15/9/6.
 */
public class Config {

    public static class Type {
        String TITLE;
        TypeItem[] TYPE_ITEMS;

        public Type(String TITLE, TypeItem[] TYPE_ITEMS) {
            this.TITLE = TITLE;
            this.TYPE_ITEMS = TYPE_ITEMS;
        }
    }

    public static class TypeItem {
        String TITLE;
        Class TARGET;

        public TypeItem(String TITLE, Class TARGET) {
            this.TITLE = TITLE;
            this.TARGET = TARGET;
        }
    }

    static final TypeItem[] TYPE_ITEMS_UI = new TypeItem[]{
            new TypeItem("AVLoadingIndicatorView", AVLoadingIndicatorViewActivity.class),
            new TypeItem("butterknife", null)
    };

    static final TypeItem[] TYPE_ITEMS_ANIMATIONS = new TypeItem[]{
            new TypeItem("rebound", ReboundActivity.class),
            new TypeItem("Backboard", null),
    };

    static final TypeItem[] TYPE_ITEMS_IMAGE = new TypeItem[]{
            new TypeItem("webp", WebpActivity.class),
            new TypeItem("svg-android", SvgAndroidActivity.class),
            new TypeItem("vector-drawable", VectorDrawableActivity.class),
            new TypeItem("vector-compat", VectorCompatActivity.class),
            new TypeItem("fresco", FrescoActivity.class),
            new TypeItem("picasso", PicassoActivity.class),
            new TypeItem("glide", GlideActivity.class)
    };

    static final TypeItem[] TYPE_ITEMS_DB = new TypeItem[]{
            new TypeItem("realm", null),
            new TypeItem("greenDAO", GreenDaoActivity.class),
            new TypeItem("ormlite", null),
    };

    static final TypeItem[] TYPE_ITEMS_NET = new TypeItem[]{
            new TypeItem("volley", null),
            new TypeItem("okHttp", OkHttpActivity.class)
    };

    static final TypeItem[] TYPE_ITEMS_FRAMEWORK = new TypeItem[]{
            new TypeItem("butterknife", null),
            new TypeItem("rxAndroid", RxAndroidActivity.class),
            new TypeItem("dagger", null),
            new TypeItem("otto", OttoActivity.class),
            new TypeItem("EventBus", null),
    };

    static final TypeItem[] TYPE_ITEMS_LANGUAGE = new TypeItem[]{
            new TypeItem("duktape", DuktapeActivity.class),
    };

    public static final Type[] TYPE_LIST = {
            new Type("UI", TYPE_ITEMS_UI),
            new Type("ANIMATIONS", TYPE_ITEMS_ANIMATIONS),
            new Type("IMAGE", TYPE_ITEMS_IMAGE),
            new Type("DB", TYPE_ITEMS_DB),
            new Type("NET", TYPE_ITEMS_NET),
            new Type("FRAMEWORK", TYPE_ITEMS_FRAMEWORK),
            new Type("LANGUAGE", TYPE_ITEMS_LANGUAGE),
    };


}
