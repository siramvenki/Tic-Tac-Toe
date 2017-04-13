package bejjenki.venky.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        String r=getIntent().getExtras().getString("review");

        TextView t0=(TextView)findViewById(R.id.text0);
        if(r.charAt(0)!='_')
            t0.setText(r.charAt(0));
        TextView  t1=(TextView)findViewById(R.id.text1);
        if(r.charAt(1)!='_')
            t1.setText(r.charAt(1));
        TextView  t2=(TextView)findViewById(R.id.text2);
        if(r.charAt(2)!='_')
            t2.setText(r.charAt(2));
        TextView  t3=(TextView)findViewById(R.id.text3);
        if(r.charAt(3)!='_')
            t3.setText(r.charAt(3));
        TextView  t4=(TextView)findViewById(R.id.text4);
        if(r.charAt(4)!='_')
            t4.setText(r.charAt(4));
        TextView  t5=(TextView)findViewById(R.id.text5);
        if(r.charAt(5)!='_')
            t5.setText(r.charAt(5));
        TextView  t6=(TextView)findViewById(R.id.text6);
        if(r.charAt(6)!='_')
            t6.setText(r.charAt(6));
        TextView  t7=(TextView)findViewById(R.id.text7);
        if(r.charAt(7)!='_')
            t7.setText(r.charAt(7));
        TextView  t8=(TextView)findViewById(R.id.text8);
        if(r.charAt(8)!='_')
            t8.setText(r.charAt(0));

    }
}
