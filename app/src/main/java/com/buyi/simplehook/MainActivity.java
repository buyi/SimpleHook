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


        String param1 = "param1";
        Log.d(TAG, "===========before hook test:" + this.test(param1));
        hook(MainActivity.class, "test", "(Ljava/lang/String;)Ljava/lang/String;");
        Log.d(TAG, "===========after hook test:" + this.test(param1));
        Log.d(TAG, "===========before hook staticTest:" + this.staticTest(param1));
        hook(MainActivity.class, "staticTest", "(Ljava/lang/String;)Ljava/lang/String;");
        Log.d(TAG, "===========after hook staticTest:" + this.staticTest(param1));
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

    static {
        System.loadLibrary("hookdemo");
    }
    public static final String TAG = "===[hookdemo]===";
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//    }
    public static String staticTest(String param1)
    {
        return "staticTest";
    }
    public String test(String param1)
    {
        return "11111";
    }


    public native void hook(Class<?> clazzToHook, String methodName, String methodSig);
}
