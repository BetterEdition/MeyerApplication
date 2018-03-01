package com.example.jesperenemark.meyerapplication;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Save instances
    private static final String TAG = "MainActivity";
    private static final String KEY_Index  = "index";

    public SimpleDateFormat timeStamp;
    public String dicesString;
    private Button mRollButton;
    private Button mHistButton;
    private TextView txtResult;
    private Spinner mSpinner;
    public int result;
    // ArrayLists
    public ArrayList<Integer> numbersOfDie;
    public ArrayList<String> historyList;
    final String numbersDrop[] = {"1","2","3","4","5"};
    public String numberChosen = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: called");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            dicesString = savedInstanceState.getString(KEY_Index, null);
        }


        setButtons ();
        mHistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DiceActivity.class);

/** passing string array*/
               // b.putStringArray("array", arr);
                intent.putExtras(b);

/** start Activity2 */
                startActivity(intent);


            }
        });



        this.numbersOfDie = new ArrayList<>();
        this.historyList = new ArrayList<>();
        this.timeStamp = new SimpleDateFormat("hh:mm:ss");
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mRollButton = (Button) findViewById(R.id.btnRoll);
        mHistButton = (Button) findViewById(R.id.btnHistory);
        txtResult = (TextView) findViewById(R.id.txtResult);

        populateSpinner();
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                numberChosen = mSpinner.getSelectedItem().toString();
                Log.d("CheckOnSelect", "onItemSelected: "+numberChosen);
            }




            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                numberChosen = "1";
            }
        });




        rollDie();

    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: called");
        txtResult.setText(dicesString);

    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putString(KEY_Index,dicesString);

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


    public void onNothingSelected(AdapterView<?> parentView) {
        numberChosen = "1";
    }

    public void populateSpinner() {
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this,   android.R.layout.simple_spinner_item, numbersDrop);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerArrayAdapter);

    }
    public void setButtons (){
        this.numbersOfDie = new ArrayList<>();
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mRollButton = (Button) findViewById(R.id.btnRoll);
        mHistButton = (Button) findViewById(R.id.btnHistory);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    public void rollDie(){

        mRollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                txtResult.setText("");
                result = 0;
                numbersOfDie.clear();
                Log.d("dsa", ""+numberChosen);
                int intNumberChosen = Integer.parseInt(numberChosen);
                int i;
                for (i=0; i < intNumberChosen; i++) {
                    Random rand = new Random();
                    int randomDice = rand.nextInt(6) + 1;
                    numbersOfDie.add(randomDice);
                    Log.d("labels", "numberoflabels:"+i);
                    String addToText = txtResult.getText().toString();

                    if(i == intNumberChosen-1) {
                        txtResult.setText(addToText+numbersOfDie.get(i)+"=");
                    }
                    else {
                        txtResult.setText(addToText+numbersOfDie.get(i)+"+");
                    }

                }
                for (i=0; i < numbersOfDie.size(); i++) {
                    result += numbersOfDie.get(i);
                }

                dicesString = (txtResult.getText().toString() + result);
                String timeAndCalc = timeStamp.format(new Date())+": "+dicesString;
                Log.d("timeandCalc", timeAndCalc);
                historyList.add(timeAndCalc);
                txtResult.setText(dicesString);

            }
        });
    }

}