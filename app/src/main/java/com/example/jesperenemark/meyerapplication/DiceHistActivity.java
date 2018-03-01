package com.example.jesperenemark.meyerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DiceHistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_hist);
        displayListView();
    }

    private void displayListView() {

        //Array list of countries
        List<String> countryList = new ArrayList<String>();
        countryList.add("Aruba");
        countryList.add("Anguilla");
        countryList.add("Netherlands Antilles");
        countryList.add("Antigua and Barbuda");
        countryList.add("Bahamas");
        countryList.add("Belize");
        countryList.add("Bermuda");
        countryList.add("Barbados");
        countryList.add("Canada");
        countryList.add("Costa Rica");
        countryList.add("Cuba");
        countryList.add("Cayman Islands");
        countryList.add("Dominica");
        countryList.add("Dominican Republic");
        countryList.add("Guadeloupe");
        countryList.add("Grenada");
        countryList.add("Greenland");
        countryList.add("Guatemala");
        countryList.add("Honduras");
        countryList.add("Haiti");
        countryList.add("Jamaica");

        //create an ArrayAdaptar from the String Array
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.activity_dice_hist, countryList);
        ListView listView = (ListView) findViewById(R.id.list1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);
    }
}