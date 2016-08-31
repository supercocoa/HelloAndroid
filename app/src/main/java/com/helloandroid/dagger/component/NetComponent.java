package com.helloandroid.dagger.component;

import android.app.Activity;

import com.helloandroid.dagger.module.AppModule;
import com.helloandroid.dagger.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by scott on 16/8/31.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(Activity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}

