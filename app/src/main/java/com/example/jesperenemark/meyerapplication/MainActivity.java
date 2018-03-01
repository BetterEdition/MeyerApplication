package com.example.jesperenemark.meyerapplication;

import android.nfc.Tag;
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

    private static final String TAG = "MainActivity";
    private static final String KEYINDEX_1 = "index1";
    private static final String KEYINDEX_2 = "index2";

    int  dice_1 = 0;
    int  dice_2 = 0;


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
        Log.i(TAG , "onSavedInstanceState");
        setContentView(R.layout.activity_main);
        referenceViewObjects();
        if (savedInstanceState !=null){
            dice_1 = savedInstanceState.getInt(KEYINDEX_1, 0);
            dice_2 = savedInstanceState.getInt(KEYINDEX_2, 0);

        }
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
                diceRandomizer();

            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: called");

;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: called");
        mDie1.setText(String.valueOf(dice_1));
        mDie2.setText(String.valueOf(dice_2));
        mResult.setText(String.valueOf(dice_1 + dice_2));



    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSavedInstanceState: ");
        savedInstanceState.putInt(KEYINDEX_2,dice_2);
        savedInstanceState.putInt(KEYINDEX_1,dice_1);
    }


    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: called");
    }
    public  void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: called");
    }


    public void referenceViewObjects(){
        setContentView(R.layout.activity_main);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mDie1 = (TextView) findViewById(R.id.txtdice1);
        mDie2 = (TextView) findViewById(R.id.txtdice2);
        mResult = (TextView) findViewById(R.id.txtResult);
        mRollButton = (Button) findViewById(R.id.btnRoll);
        m2ndActivityButton = (Button) findViewById(R.id.btnHistory);
    }

    public void numberOfDie() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this,   android.R.layout.simple_spinner_item, numbers);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerArrayAdapter);

    }


        public void diceRandomizer(){
            Log.i(TAG, "diceRandomizer:was called");
        Random rand = new Random();
        dice_1 = rand.nextInt(6) + 1;
        dice_2 = rand.nextInt(6) + 1;
        mDie1.setText(String.valueOf(dice_1));
        mDie2.setText(String.valueOf(dice_2));
        mResult.setText(String.valueOf(dice_1 + dice_2));

    }
}



