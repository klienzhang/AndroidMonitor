package android.klien.priv.androidmonitor.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.klien.priv.androidmonitor.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.v("debug","onCreate of SecondActivity");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("debug","onStart of SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("debug","onResume of SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("debug","onPause of SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("debug","onStop of SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("debug","onDestory of SecondActivity");
    }

}
