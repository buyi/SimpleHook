package com.buyi.simplehook;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        //  普通方法
        String param1 = "param1";
        Log.d(TAG, "===========before hook buyi:" + this.buyi(param1));
        hook(MainActivity.class, "buyi", "(Ljava/lang/String;)Ljava/lang/String;");
        Log.d(TAG, "===========after hook buyi:" + this.buyi(param1));


        // 静态方法
        Log.d(TAG, "===========before hook staticBuyi:" + this.staticBuyi(param1));
        hook(MainActivity.class, "staticBuyi", "(Ljava/lang/String;)Ljava/lang/String;");
        Log.d(TAG, "===========after hook staticBuyi:" + this.staticBuyi(param1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // 加载so包
    static {
        System.loadLibrary("hookdemo");
    }

    public static final String TAG = "buyi";


    public static String staticBuyi(String param1) {
        return "staticBuyi";
    }

    public String buyi(String param1) {
        return "buyi";
    }


    public native void hook(Class<?> clazzToHook, String methodName, String methodSig);
}
