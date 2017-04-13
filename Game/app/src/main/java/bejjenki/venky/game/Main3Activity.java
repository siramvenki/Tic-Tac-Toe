package bejjenki.venky.game;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends AppCompatActivity {
    CountDownTimer count;
    Button startButton;
    TextView won;
    int userComputer = 1;
    TicTacToeMedium h;
    MediaPlayer mp;
//    MediaPlayer msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        play();
        String title="TIc Tac Toe";
        setTitle(title);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        startButton=(Button)findViewById(R.id.startSystem);
        Intent myintent= getIntent();
        String modeSelected=myintent.getStringExtra("mode");
        won=(TextView)findViewById(R.id.won);
        won.setText("");
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        h = new TicTacToeMedium();
        System.out.println("entered  here");
        h.startGame();
        System.out.println("out  here");
    }
    private void play() {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.gamebg);
        mp.setLooping(true);

        mp.start();
    }

    public void popUp(String s)
    {
        mp.stop();

        Intent i=new Intent(Main3Activity.this,Pop.class);


        i.putExtra("result",s);
        startActivity(i);
    }

    public void startSystem(View view)
    {
        h.initSystem();
        String sys=h.systemMove;
        setSystemValue(sys);
        timer();
        startButton.setEnabled(false);
    }

//    @Override
//    public void onStop()
//    {
//        super.onStop();
//        if(count!=null)
//        {
//            count.cancel();
//        }
//        System.exit(0);
//
//    }

    public void game(View view){
        startButton.setEnabled(false);
        int visited=0;
        TextView text;
        switch (view.getId()) {
            case R.id.text0:
                text = (TextView) findViewById(R.id.text0);
                visited=h.insert("00");
//                text.setText("X");
                break;
            case R.id.text1:
                text = (TextView) findViewById(R.id.text1);
                visited=h.insert("01");
//                text.setText("X");
                break;
            case R.id.text2:
                text = (TextView) findViewById(R.id.text2);
                visited=h.insert("02");
//                text.setText("X");
                break;
            case R.id.text3:
                text = (TextView) findViewById(R.id.text3);
                visited=h.insert("10");
//                text.setText("X");
                break;
            case R.id.text4:
                text = (TextView) findViewById(R.id.text4);
                visited=h.insert("11");
//                text.setText("X");
                break;
            case R.id.text5:
                text = (TextView) findViewById(R.id.text5);
                visited=h.insert("12");
//                text.setText("X");
                break;
            case R.id.text6:
                text = (TextView) findViewById(R.id.text6);
                visited=h.insert("20");
//                text.setText("X");
                break;

            case R.id.text7:
                text = (TextView) findViewById(R.id.text7);
                visited=h.insert("21");
//                text.setText("X");
                break;
            default:
                text = (TextView) findViewById(R.id.text8);
                visited=h.insert("22");
//                text.setText("X");
        }

        if(visited==0)
        {
            won.setText("");
            if(count!=null)
            {
                count.cancel();
                timer();
            }
            else
            {
                timer();
            }
            text.setText("X");
            String result=h.move();

            String sys=h.systemMove;

            setSystemValue(sys);
            if(result.equals("p1"))
            {
//                won.setText("U lost");
                count.cancel();
                popUp("You Lost");
            }
            else if(result.equals("p2"))
            {
//                won.setText("U won");
                count.cancel();
                popUp("You Won");
            }
            else if(result.equals("draw"))
            {
//                won.setText("Game Draw");
                count.cancel();
                popUp("Game Draw");
            }
        }
        else
        {
            won.setText("already selected");
        }

    }

    public void setSystemValue(String sys)
    {
        if(sys.equals("00"))
        {
            TextView  t=(TextView)findViewById(R.id.text0);
            t.setText("O");
        }
        else if(sys.equals("01"))
        {
            TextView  t=(TextView)findViewById(R.id.text1);
            t.setText("O");
        }
        else if(sys.equals("02"))
        {
            TextView  t=(TextView)findViewById(R.id.text2);
            t.setText("O");
        }
        else if(sys.equals("10"))
        {
            TextView  t=(TextView)findViewById(R.id.text3);
            t.setText("O");
        }
        else if(sys.equals("11"))
        {
            TextView  t=(TextView)findViewById(R.id.text4);
            t.setText("O");
        }
        else if(sys.equals("12"))
        {
            TextView  t=(TextView)findViewById(R.id.text5);
            t.setText("O");
        }else if(sys.equals("20"))
        {
            TextView  t=(TextView)findViewById(R.id.text6);
            t.setText("O");
        }
        else if(sys.equals("21"))
        {
            TextView  t=(TextView)findViewById(R.id.text7);
            t.setText("O");
        }
        else if(sys.equals("22"))
        {
            TextView  t=(TextView)findViewById(R.id.text8);
            t.setText("O");
        }

    }

    public void timer()
    {
        count=new CountDownTimer(15000, 1000) {
            TextView t=(TextView)findViewById(R.id.timer);
            public void onTick(long millisUntilFinished) {
                long time=(millisUntilFinished / 1000);
                t.setText(time+"");
                if(time==1)
                {
//                    won.setText("U lost");
                    count.cancel();
                    popUp("You Lost");
                }

            }

            public void onFinish() {
                t.setText("0:00");
            }
        }.start();
    }

    @Override
    public void onStop(){

        mp.stop();
        if(count!=null)
            count.cancel();
        onPause();

        Intent i = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(i);
    }
    @Override
    public void onPause(){
        System.exit(0);
        super.onPause();
    }

    @Override
    public void onBackPressed()
    {
        mp.stop();

//        if(msg.isPlaying()==true){
//            msg.stop();
//        }
        if(count!=null)
            count.cancel();
        Intent i = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(i);
    }
}
