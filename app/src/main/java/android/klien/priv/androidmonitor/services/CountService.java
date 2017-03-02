package android.klien.priv.androidmonitor.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by klien on 2017/2/19.
 */

public class CountService extends Service {

    int count = 0 ;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.v("CountService", "kkkkkkkkkkkkkkkkkkk");
        int i = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    try{
                        Log.v("CountService", Integer.toString(count++));
                        Thread.sleep(2000);
                    }catch (Exception e){

                    }
                }
            }
        }).start();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
