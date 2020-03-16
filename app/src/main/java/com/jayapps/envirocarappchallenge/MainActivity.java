package com.jayapps.envirocarappchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewCarList;
    FloatingActionButton fabAddCar;
    AdapterCar mAdapter;

    private ArrayList<Item> carArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(24);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.backgroundcolor)));
        recyclerViewCarList=findViewById(R.id.car_list);
        fabAddCar=findViewById(R.id.btn_fab_addcar);

        fabAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAddCar.setEnabled(false);
                intentAddCarActivity();
            }
        });

        mAdapter = new AdapterCar(carArrayList);
        recyclerViewCarList.setLayoutManager(new LinearLayoutManager(this) );
        recyclerViewCarList.setAdapter(mAdapter);

    }
    public void intentAddCarActivity(){
        Intent intent=new Intent(MainActivity.this,AddCarActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!fabAddCar.isEnabled()){
            fabAddCar.setEnabled(true);
        }
    }
}
