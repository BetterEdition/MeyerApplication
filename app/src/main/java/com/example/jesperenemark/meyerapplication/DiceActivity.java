package com.example.jesperenemark.meyerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DiceActivity extends AppCompatActivity {
    ListView diceHistView;
    ArrayAdapter<String> adapter;
    ArrayList<String> array;
    Bundle bundle;
    public ArrayList<String> history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        bundle = getIntent().getExtras();
        array = (ArrayList<String>) bundle.getStringArrayList("array_list");
        diceHistView = (ListView) findViewById(R.id.diceHist);



        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, array);
        diceHistView.setAdapter(adapter);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_2Die) {
            bundle.remove("array_list");
           // bundle.getStringArrayList("array_list").clear();
            array.clear();
            adapter.notifyDataSetChanged();
            return true;
        }

        if (id == R.id.action_3Die)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
