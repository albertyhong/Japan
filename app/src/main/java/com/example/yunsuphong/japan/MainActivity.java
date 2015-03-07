package com.example.yunsuphong.japan;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//import android.support.v7.app.ActionBarActivity;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new TouchView(this));

        /*
        WindowManager manager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();

        DisplayMetrics displayMetrics = new DisplayMetrics();	//Create an empty DisplayMetrics.
        display.getMetrics(displayMetrics);			//Put values into the DisplayMetrics.

        String string = displayMetrics.widthPixels + " \u00D7 " + displayMetrics.heightPixels;
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();

        Window window = getWindow();
        if (Build.VERSION.SDK_INT < 16) {
            //Hide the status bar.
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

            //Hide the action bar (used to be called the title bar).
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        } else {
            //Hide the status bar.  Requires at least
            //minSdkVersion 16 in Gradle Scripts -> build.gradle (app).
            //import android.app.ActionBar;
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

            //Hide the action bar.
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }
        JapanView japanView = new JapanView(this);
        setContentView(japanView);
        */
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
}
