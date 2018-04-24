package com.example.a16022596.po2demolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList <Food> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)this.findViewById(R.id.lvFood);

        //Create a few food objects in food array
        foods = new ArrayList<Food>();
        foods.add(new Food("Ah lat Coffee",false));
        foods.add(new Food("Rocky Choc",true));
        foods.add(new Food("Kid Cat Choc",false));

        aa = new FoodAdapter(this,R.layout.row,foods);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food selectedFood = foods.get(position);

                Toast.makeText(MainActivity.this, selectedFood.getName()
                                + " Star: " + selectedFood.isStar(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}
