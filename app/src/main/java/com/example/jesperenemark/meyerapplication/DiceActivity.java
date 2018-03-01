package com.example.jesperenemark.meyerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DiceActivity extends AppCompatActivity {
    ListView diceHistView;
    public ArrayList<String> history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);


        Intent intent = getIntent();

/** get the bundle from intent*/
        Bundle b = intent.getExtras();
/** retrieve the string extra passed */
        String a = b.getString("name");

/** retrieve the stringarray extra passed */
        String[] arrRecd = b.getStringArray("array");

        history = new ArrayList<>();
        history.add("Hej");
        diceHistView = (ListView) findViewById(R.id.diceHist);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
      //          android.R.layout.simple_list_item_1, arr);
   //     diceHistView.setAdapter(adapter);


    }
}
