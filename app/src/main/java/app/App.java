package app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * date:2020/3/17
 * author:师浩洁(shihaojie)
 * function:
 */
public class App extends Application implements Thread.UncaughtExceptionHandler{

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }

    @Override
    public void uncaughtException(Thread thread,Throwable throwable) {
        Thread.setDefaultUncaughtExceptionHandler(this);
        Log.d(TAG, throwable.getMessage());
    }

    private static final String TAG = "App";
}
