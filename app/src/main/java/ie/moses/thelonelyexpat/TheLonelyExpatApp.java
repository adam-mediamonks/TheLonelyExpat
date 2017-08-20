package ie.moses.thelonelyexpat;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

public class TheLonelyExpatApp extends Application {

    @Override public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
