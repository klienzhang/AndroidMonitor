package android.klien.priv.androidmonitor.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by klien on 2017/2/20.
 */

public class MyService extends Service{

    private MyBinder myBinder = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return this.myBinder;
        //return this.myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v("debug", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("debug", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }
}
