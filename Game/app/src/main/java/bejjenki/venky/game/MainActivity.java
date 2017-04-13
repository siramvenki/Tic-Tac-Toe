package bejjenki.venky.game;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    MediaPlayer mp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

//    @Override
    public void method1(View view)
    {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.click);
        mp.start();
        Intent myintent = new Intent(MainActivity.this,Main4Activity.class);
        startActivity(myintent);
    }

//    @Override
    public void method2(View view)
    {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.click);
        mp.start();
        Intent myintent = new Intent(MainActivity.this,Main3Activity.class);
        mp.stop();
        startActivity(myintent);
    }

//    @Override
    public void method3(View view)
    {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.click);
        mp.start();
        Intent myintent = new Intent(MainActivity.this,Main2Activity.class);
        mp.stop();
        startActivity(myintent);

    }

//    @Override
    public void method4(View v)
    {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.click);
        mp.start();
        Intent i = new Intent(MainActivity.this, ExitApplication.class);
        mp.stop();
        startActivity(i);
    }
    @Override
    public void onBackPressed()
    {
        Intent i = new Intent(MainActivity.this, ExitApplication.class);
        startActivity(i);
    }
}
