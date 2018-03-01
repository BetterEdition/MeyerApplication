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



        Bundle bundle = getIntent().getExtras();
        ArrayList<String> array = (ArrayList<String>) bundle.getStringArrayList("array_list");
        diceHistView = (ListView) findViewById(R.id.diceHist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, array);
       diceHistView.setAdapter(adapter);


    }
}
