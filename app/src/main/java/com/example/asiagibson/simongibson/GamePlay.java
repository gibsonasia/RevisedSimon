package com.example.asiagibson.simongibson;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlay extends AppCompatActivity {

    private Button green;
    private Button blue;
    private Button red;
    private Button yellow;
    List<Integer> userInput = new ArrayList<>();  //saves user inout
    List<Integer> shownColor = new ArrayList<>();  //saves what color was animated/ shown

    public int i;
    Random random = new Random();
    public int colorShuff = random.nextInt(4)+1;
    public int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        shownColor.add(colorShuff);

    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_game_play);
        Handler handler = new Handler();
        green = (Button) findViewById(R.id.green);
        blue = (Button) findViewById(R.id.blue);
        red = (Button) findViewById(R.id.red);
        yellow = (Button) findViewById(R.id.yellow);

    }
    public void buttonOnClick(View view){

        //Animation info should go here


        userInput.add(temp);

        if(userInput.get(i) != shownColor.get(i)) {
            //Player lost
           // startActivity();
        } else {
            i++;
            if (userInput.size() == shownColor.size()) {
               win();
                //Win round
            }
        }
    }

    public void win() {
        userInput.clear();
        i = 0;
        shownColor.add(random.nextInt(4) + 1);
    }

    public void nextRound(){

        List<Animator> list = new ArrayList<Animator>();

        AnimatorSet colorSet = new AnimatorSet();

        for(int x = 0; x < shownColor.size(); x++){

            switch(shownColor.get(x)){

                case 1:
                 //case blue
                    break;
                case 2:
                    //case red

                    break;
                case 3:
                    //case yellow

                    break;

                case 4:
                    //case green

                    break;
                default:
                    break;
            }
        }
        colorSet.playSequentially(list);
        colorSet.setInterpolator(new LinearInterpolator());
        colorSet.start();
    }
}
