package appewtc.masterung.gamepaperrockscissors;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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
                myRandomPicture(3);


            }
        });
    }

    private void rockController() {
        rockImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlay(2);
                myRandomPicture(2);
            }
        });
    }

    private void paperController() {

        paperImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePlay(1);
                myRandomPicture(1);
            }
        });

    }   // paperController

    private void myRandomPicture(int intUser) {

        int intMyRandom = 0;
        Random objRandom = new Random();
        intMyRandom = objRandom.nextInt(3) + 1;
        Log.d("Ran", "intMyRandom ==> " + intMyRandom);

        androidChange(intMyRandom);

        checkScore(intUser, intMyRandom);

    }   // myRandomPicture

    private void checkScore(int intUser, int intMyRandom) {

        String strWin = "ไชโย คุณชนะ";
        String strLost = "เสียใจด้วย คุณแพ้";
        String strDew = "เอาใหม่ คุณเสมอ";
        String strShow = null;
        int[] intSound = new int[3];
        intSound[0] = R.raw.cow;

        //1 ==> กระดาษ, 2 ==> ค้อน, 3 == กรรไกร
        switch (intUser) {

            case 1: //กระดาษ
                switch (intMyRandom) {
                    case 1:
                        strShow = strDew;
                        break;
                    case 2:
                        strShow = strWin;
                        break;
                    case 3:
                        strShow = strLost;
                        break;
                }
                break;
            case 2: //ค้อน
                switch (intMyRandom) {
                    case 1:
                        strShow = strLost;
                        break;
                    case 2:
                        strShow = strDew;
                        break;
                    case 3:
                        strShow = strWin;
                        break;
                }
                break;
            case 3: //กรรไกร
                switch (intMyRandom) {
                    case 1:
                        strShow = strWin;
                        break;
                    case 2:
                        strShow = strLost;
                        break;
                    case 3:
                        strShow = strDew;
                        break;
                }
                break;

        }   //switch

        showTextView.setText(strShow);


    }   // checkScore

    private void androidChange(int intMyRandom) {

        int[] intSourceImage = new int[4];
        intSourceImage[0] = 0;
        intSourceImage[1] = R.drawable.paper;
        intSourceImage[2] = R.drawable.rock;
        intSourceImage[3] = R.drawable.scissors;

        androidImageView.setImageResource(intSourceImage[intMyRandom]);

    }   // androidChange

    private void changePlay(int intNumber) {

        Log.d("test", "ค่าที่รับได้ = " + intNumber);

        int intSound = R.raw.mosquito;

        switch (intNumber) {
            case 1:
                playImageView.setImageResource(R.drawable.paper);
                intSound = R.raw.mosquito;
                break;
            case 2:
                playImageView.setImageResource(R.drawable.rock);
                intSound = R.raw.cow;
                break;
            case 3:
                playImageView.setImageResource(R.drawable.scissors);
                intSound = R.raw.elephant;
                break;
        }   // switch

        MediaPlayer imageMediaPlayer = MediaPlayer.create(getBaseContext(), intSound);
        imageMediaPlayer.start();

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
