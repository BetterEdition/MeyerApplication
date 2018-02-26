package com.example.jesperenemark.meyerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mRollButton;
    private TextView mDie1;
    private TextView mDie2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollDie();

    }
    public void rollDie(){
        mDie1 = (TextView) findViewById(R.id.dice1);
        mDie2 = (TextView) findViewById(R.id.dice2);
        mRollButton = (Button) findViewById(R.id.btnRoll);
        Random rand = new Random();
        final int  n = rand.nextInt(6) + 1;
        final int  m = rand.nextInt(6) + 1;
        mRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDie1.setText(String.valueOf(n));
                mDie2.setText(String.valueOf(m));
            }
        });
    }
}


