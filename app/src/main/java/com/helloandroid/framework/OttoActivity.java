package com.helloandroid.framework;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

/**
 * Created by scott on 16/1/15.
 */
public class OttoActivity extends AppCompatActivity {

    Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        setContentView(view);

        bus = new Bus();
        bus.register(this);

        bus.post(new SomeEvent("SomeEvent"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        bus.unregister(this);
    }

    @Subscribe
    public void handleEvent(SomeEvent someEvent) {
        if (someEvent != null) {
            Handler handler = new Handler();
            handler.postDelayed(() -> Toast.makeText(getApplicationContext(), someEvent.some, Toast.LENGTH_SHORT)
                    .show(), 2000);

        }
    }


    public static class SomeEvent {
        public final String some;

        public SomeEvent(String some) {
            this.some = some;
        }
    }

}
