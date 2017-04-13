package bejjenki.venky.game;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExitApplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_application);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        TextView t=(TextView)findViewById(R.id.exitText);
//        t.setText("Do you want to exitgame");
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double width=dm.widthPixels;
        double height=dm.heightPixels*0.6;
        getWindow().setLayout((int) width,(int) height);


    }

    public void ticAction(View view)
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        System.exit(0);
    }
    public void xAction(View view)
    {
        Intent i=new Intent(ExitApplication.this,MainActivity.class);
        startActivity(i);
    }

}
