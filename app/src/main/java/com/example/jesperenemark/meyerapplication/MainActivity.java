package com.example.jesperenemark.meyerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mRollButton;
    private Button m2ndActivityButton;
    private TextView mDie1;
    private TextView mDie2;
    private TextView mResult;
    private Spinner mSpinner;
    final String numbers[] = {"1","2","3","4","5"};
    public String numberChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mDie1 = (TextView) findViewById(R.id.txtdice1);
        mDie2 = (TextView) findViewById(R.id.txtdice2);
        mResult = (TextView) findViewById(R.id.txtResult);
        mRollButton = (Button) findViewById(R.id.btnRoll);
        m2ndActivityButton = (Button) findViewById(R.id.btnHistory);
        rollDie();
        numberOfDie();
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                numberChosen = mSpinner.getSelectedItem().toString();
                Log.d("CheckOnSelect", "onItemSelected: "+numberChosen);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

    }


    public void numberOfDie() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this,   android.R.layout.simple_spinner_item, numbers);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerArrayAdapter);

    }
    public void rollDie(){

        mRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (numberChosen) {
                    case "1":
                        Log.d("State", ""+numberChosen);
                        break;
                    case "2":
                        Log.d("State", ""+numberChosen);
                        break;
                    case "3":
                        Log.d("State", ""+numberChosen);
                        break;
                    case "4":
                        Log.d("State", ""+numberChosen);
                        break;
                    case "5":
                        Log.d("State", ""+numberChosen);
                        break;
                }
                Random rand = new Random();
                final int  n = rand.nextInt(6) + 1;
                final int  m = rand.nextInt(6) + 1;
                mDie1.setText(String.valueOf(n));
                mDie2.setText(String.valueOf(m));
                mResult.setText(String.valueOf(n+m));
            }
        });
    }
}



