package bejjenki.venky.game;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Pop extends AppCompatActivity {

    MediaPlayer msg;
    String s;
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        s=getIntent().getExtras().getString("result");
        r=getIntent().getExtras().getString("review");
        playSound();
        TextView t=(TextView)findViewById(R.id.pop);
        t.setText(s);


    }

    private void playSound() {
        if(s.equals("You Won")){
            msg = MediaPlayer.create(getApplicationContext(), R.raw.wonhard);
            msg.start();
        }
        else if(s.equals("You Lost")){
            msg = MediaPlayer.create(getApplicationContext(), R.raw.gameover);
            msg.start();

        }
        else{
            msg = MediaPlayer.create(getApplicationContext(), R.raw.draw);
            msg.start();
        }
    }

    public void goAction(View view)
    {
        if(msg.isPlaying())
            msg.stop();
        Intent i = new Intent(Pop.this, MainActivity.class);
        startActivity(i);
    }

    public void exitAction(View view)
    {
        if(msg.isPlaying())
        msg.stop();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        System.exit(0);

    }

    @Override
    public void onBackPressed() {
        msg.stop();
        Intent i=new Intent(Pop.this,MainActivity.class);
        startActivity(i);
    }

    public void review(View view)
    {
        Intent i=new Intent(Pop.this,ReviewActivity.class);
        i.putExtra("review",r);
        startActivity(i);
    }
}
