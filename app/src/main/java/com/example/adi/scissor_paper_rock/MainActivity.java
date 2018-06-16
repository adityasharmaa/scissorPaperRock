package com.example.adi.scissor_paper_rock;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    ImageView userImg;
    ImageView comImg;
    TextView message,userScore,comScore,bari;
    Button scr,ppr,rk;
    Random ran=new Random();
    char u,c;
    int uScore=0,cScore=0,turns=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name=intent.getStringExtra(Main2Activity.EXTRA_MESSAGE);

        TextView user=(TextView) findViewById(R.id.textView);
        user.setText(name);

        userImg = (ImageView) findViewById(R.id.userImage);
        bari = (TextView) findViewById(R.id.turn);
        comImg = (ImageView) findViewById(R.id.comImage);
        message = (TextView) findViewById(R.id.result);
        userScore = (TextView) findViewById(R.id.userScore);
        comScore = (TextView) findViewById(R.id.comScore);
        scr = (Button) findViewById(R.id.scissor);
        ppr = (Button) findViewById(R.id.paper);
        rk = (Button) findViewById(R.id.rock);

        rk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turns>=10)
                    return;

                turns++;
                bari.setText(turns+"");
                u='r';
                userImg.setImageResource(R.drawable.rock);
                comTurn();
                endGame();
            }
        });

        ppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turns>=10)
                    return;

                turns++;
                bari.setText(turns+"");
                u='p';
                userImg.setImageResource(R.drawable.paper);
                comTurn();
                endGame();
            }
        });

        scr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(turns>=10)
                    return;

                turns++;
                bari.setText(turns+"");
                u='s';
                userImg.setImageResource(R.drawable.sciss);
                comTurn();
                endGame();
            }
        });
    }


    public void comTurn(){
        int n=ran.nextInt(3);
        switch (n){
            case 0: comImg.setImageResource(R.drawable.rock);
                    c='r';
                    break;

            case 1: comImg.setImageResource(R.drawable.scissors);
                    c='s';
                    break;

            case 2: comImg.setImageResource(R.drawable.paper);
                    c='p';
        }
        decider();
    }

    public void decider(){
        if(u==c){
            message.setText("IT'S A TIE, TRY AGAIN");
            return;
        }
        if(u=='s'){
            if(c=='p') {
                uScore+=10;
                userScore.setText(uScore+"");
                if(cScore>0) {
                    cScore -= 5;
                    comScore.setText(cScore + "");
                }
                message.setText("YOU WIN");
            }
            else if(c=='r') {
                cScore+=10;
                comScore.setText(cScore+"");
                if(uScore>0){
                    uScore-=5;
                    userScore.setText(uScore+"");
                }
                message.setText("COMPUTER WINS");
            }
            return;
        }
        if(u=='p'){
            if(c=='r') {
                uScore+=10;
                userScore.setText(uScore+"");
                if(cScore>0) {
                    cScore -= 5;
                    comScore.setText(cScore + "");
                }
                message.setText("YOU WIN");
            }
            else if(c=='s') {
                cScore+=10;
                comScore.setText(cScore+"");
                if(uScore>0){
                    uScore-=5;
                    userScore.setText(uScore+"");
                }
                message.setText("COMPUTER WINS");
            }
            return;
        }
        if(u=='r'){
            if(c=='s') {
                uScore+=10;
                userScore.setText(uScore+"");
                if(cScore>0) {
                    cScore -= 5;
                    comScore.setText(cScore + "");
                }
                message.setText("YOU WIN");
            }
            else if(c=='p') {
                cScore+=10;
                comScore.setText(cScore+"");
                if(uScore>0){
                    uScore-=5;
                    userScore.setText(uScore+"");
                }
                message.setText("COMPUTER WINS");
            }
            return;
        }
    }

    public void endGame(){
        if(turns==10){
            if(uScore>cScore)
                message.setText("YOU WIN THE GAME");
            else if(uScore==cScore)
                message.setText("OOPS! THE GAME TIES");
            else if(uScore<cScore)
                message.setText("COMPUTER WINS THE GAME");
        }
    }

    public void reset(View view){
        uScore=cScore=0;
        userScore.setText("00");
        comScore.setText("00");
        message.setText("WELCOME TO SCISSOR-PAPER-ROCK");
        turns=0;
        bari.setText("0");
    }
}
