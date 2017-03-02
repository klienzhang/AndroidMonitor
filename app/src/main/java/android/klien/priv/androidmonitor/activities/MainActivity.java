package android.klien.priv.androidmonitor.activities;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.klien.priv.androidmonitor.R;
import android.klien.priv.androidmonitor.services.CountService;
import android.klien.priv.androidmonitor.services.MyService;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.testng.reporters.jq.Main;

import java.util.List;

public class MainActivity extends Activity {

    private Intent intent;

    private Button bindService;
    private Button unbindService;
    private Button systemButton;
    private Button notificationButton;

    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("debug","onCreate of MainActivity");

        bindService = (Button) findViewById(R.id.bindSerivce);
        unbindService = (Button) findViewById(R.id.unbindService);
        systemButton = (Button) findViewById(R.id.systemButton);
        notificationButton = (Button) findViewById(R.id.notification1);

        bindService.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bind Service
                connection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        Log.v("hui", "-----------onServiceConnected-------------");
                        MyService.MyBinder myBinder = (MyService.MyBinder) service;
                        MyService service1 = myBinder.getService()        ;
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        Log.v("hui", "-----------onServiceDisconnected-------------");
                    }
                };

                Intent intent2 = new Intent(MainActivity.this, MyService.class);
                bindService(intent2, connection, Context.BIND_AUTO_CREATE);
            }
        });

        unbindService.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(connection != null)
                    unbindService(connection);
            }
        });

        systemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SystemTryActivity.class);
                startActivity(intent);
                Log.v("goto", "Go to System Page");
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

                Intent mainIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent mainPendingIntent = PendingIntent.getActivity(MainActivity.this, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification.Builder builder = new Notification.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.__leak_canary_icon)
                        .setContentTitle("title oasd")
                        .setContentText("Content oasdsf")
                        .setContentIntent(mainPendingIntent);

                manager.notify(3, builder.build());



//                Notification notification = new Notification();
//                notification.iconLevel = R.drawable.__leak_canary_icon;
//                notification.tickerText = "Hello world";
//
//                notification.defaults = Notification.DEFAULT_SOUND;
//                notification.audioStreamType= android.media.AudioManager.ADJUST_LOWER;
//
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//                notification.(this, "内容提示：", "我就是一个测试文件", pendingIntent);
//                manager.notify(1, notification);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("debug","onStart of MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("debug","onResume of MainActivity");
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
        for(ActivityManager.RunningAppProcessInfo info : list){
            Log.v("activity", info.processName);
            Log.v("activity", Integer.toString(activityManager.getProcessMemoryInfo(new int[]{info.pid})[0].getTotalPrivateClean()));
        }

        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(info);

        Log.v("1", Long.toString(info.availMem));
        Log.v("12", Long.toString(info.threshold));
        Log.v("123", Long.toString(info.totalMem));


    }

    @Override
    protected void onPause() {
        super.onPause();
        //stopService(intent);
        Log.v("debug","onPause of MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("debug","onStop of MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("debug","onDestory of MainActivity");
    }

    public void onClick1(View v){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
        Log.v("debug","12313213131");
    }
}
