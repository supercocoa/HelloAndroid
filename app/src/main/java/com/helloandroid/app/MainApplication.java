package com.helloandroid.app;

import android.support.multidex.MultiDexApplication;

import com.helloandroid.dagger.component.DaggerNetComponent;
import com.helloandroid.dagger.component.NetComponent;
import com.helloandroid.dagger.module.AppModule;
import com.helloandroid.dagger.module.NetModule;

/**
 * Created by scott on 16/8/31.
 */

public class MainApplication extends MultiDexApplication {
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule("https://api.github.com"))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
