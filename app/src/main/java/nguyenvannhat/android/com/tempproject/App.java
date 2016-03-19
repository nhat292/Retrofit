package nguyenvannhat.android.com.tempproject;

import android.app.Application;
import android.content.Context;

/**
 * Created by nhat2 on 03/17/2016.
 */
public class App extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    public static Context getAppContext(){
        return appContext;
    }
}
