package android.klien.priv.androidmonitor.services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by klien on 2017/2/20.
 */

public class MyServiceConnection implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
