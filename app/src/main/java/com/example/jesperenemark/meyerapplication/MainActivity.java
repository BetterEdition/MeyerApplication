package com.example.jesperenemark.meyerapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.stream.*;
import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String KEY_Index  = "index";

    public String dicesString;
    private Button mRollButton;
    private Button m2ndActivityButton;
    private TextView txtResult;
    private Spinner mSpinner;
    public int result;
    public ArrayList<Integer> numbersOfDie;
    final String numbersDrop[] = {"1","2","3","4","5"};
    public String numberChosen = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: called");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            dicesString = savedInstanceState.getString(KEY_Index, null);
        }

        this.numbersOfDie = new ArrayList<>();
        mSpinner = (Spinner) findViewById(R.id.spinner);
        mRollButton = (Button) findViewById(R.id.btnRoll);
        m2ndActivityButton = (Button) findViewById(R.id.btnHistory);
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
        txtResult.setText(dicesString)

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
                txtResult.setText(dicesString);




            }
        });
    }

}