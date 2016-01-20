package appewtc.masterung.gamepaperrockscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ImageView paperImageView, rockImageView,
            scissorImageView, playImageView, androidImageView;
    private TextView showTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //Paper Controller
        paperController();

        //Rock Controller
        rockController();

        //Scissor Controller
        scissorController();

    }   // Main Method

    private void scissorController() {
        scissorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlay(3);
            }
        });
    }

    private void rockController() {
        rockImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlay(2);
            }
        });
    }

    private void paperController() {

        paperImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlay(1);
            }
        });

    }   // paperController

    private void changePlay(int intNumber) {

        Log.d("test", "ค่าที่รับได้ = " + intNumber);

    }   // changePlay

    private void bindWidget() {
        paperImageView = (ImageView) findViewById(R.id.imvPaper);
        rockImageView = (ImageView) findViewById(R.id.imvRock);
        scissorImageView = (ImageView) findViewById(R.id.imvScissors);
        playImageView = (ImageView) findViewById(R.id.imvPlayer);
        androidImageView = (ImageView) findViewById(R.id.imvAndroid);
        showTextView = (TextView) findViewById(R.id.txtShow);
    }

}   // Main Class นี่คือคลาสหลัก
