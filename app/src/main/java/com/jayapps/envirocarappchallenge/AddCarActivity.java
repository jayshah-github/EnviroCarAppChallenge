package com.jayapps.envirocarappchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.whiteelephant.monthpicker.MonthPickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class AddCarActivity extends AppCompatActivity implements ManufacturerBottomSheet.BottomSheetListener , ManufacturerBottomSheet.BottomSheetListenerCancel {

    TextInputEditText manufacturer_edittext;
    TextInputEditText model_edittext;
    TextInputEditText year_edittext;
    TextInputEditText fuel_edittext;
    TextInputEditText engine_edittext;
    Button addcar_btn;
    Button cancel_btn;
    ManufacturerBottomSheet manufacturerBottomSheet;

    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private ArrayList<Item> itemArrayListModel = new ArrayList<>();
    private ArrayList<Item> itemArrayListFuel = new ArrayList<>();
    int choosenYear = 2020;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(24);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.backgroundcolor)));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>EnviroCarrAppChallenge</font>"));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        manufacturer_edittext = findViewById(R.id.manufacturer_edit_text);
        model_edittext = findViewById(R.id.model_edit_text);
        year_edittext = findViewById(R.id.year_edit_text);
        fuel_edittext = findViewById(R.id.fuel_edit_text);
        engine_edittext = findViewById(R.id.engine_edit_text);
        addcar_btn=findViewById(R.id.addCarbtn);
        cancel_btn=findViewById(R.id.cancelbtn);

        listInit();

        fuel_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fuel_edittext.setEnabled(false);
                bottomSheetInitializer(R.id.fuel_edit_text, itemArrayListFuel, "Fuel Types");
            }
        });
        model_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                model_edittext.setEnabled(false);
                bottomSheetInitializer(R.id.model_edit_text, itemArrayListModel, "Models");
            }
        });
        manufacturer_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manufacturer_edittext.setEnabled(false);
                bottomSheetInitializer(R.id.manufacturer_edit_text, itemArrayList, "Manufactures");
            }
        });
        year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                monthPickerInitializer();
            }
        });
        addcar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addcar_btn.setEnabled(false);
                if(areFieldsValid()) {
                    Toast.makeText(AddCarActivity.this,"Car Added Successfully",Toast.LENGTH_SHORT).show();

                    addcar_btn.setEnabled(true);
                }else{
                    Toast.makeText(AddCarActivity.this,"Please Enter All Fields ",Toast.LENGTH_SHORT).show();
                addcar_btn.setEnabled(true);
                }

            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddCarActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    @Override
    public void onItemClicked(String text, int id) {
        if (id == R.id.manufacturer_edit_text) {
            manufacturer_edittext.setText(text);

            manufacturer_edittext.setEnabled(true);
            manufacturer_edittext.setError(null);
            manufacturerBottomSheet.dismiss();
        }
        if (id == R.id.model_edit_text) {
            model_edittext.setText(text);
            model_edittext.setError(null);
            model_edittext.setEnabled(true);

            manufacturerBottomSheet.dismiss();
        }
        if (id == R.id.fuel_edit_text) {
            fuel_edittext.setText(text);
            fuel_edittext.setError(null);

            fuel_edittext.setEnabled(true);
            manufacturerBottomSheet.dismiss();
        }
    }
    @Override
    public void onItemCancel(int id) {
        if (id == R.id.manufacturer_edit_text) {
            manufacturer_edittext.setEnabled(true);
        }
        if (id == R.id.model_edit_text) {
            model_edittext.setEnabled(true);
        }
        if (id == R.id.fuel_edit_text) {
            fuel_edittext.setEnabled(true);
        }
    }
    public void bottomSheetInitializer(int idd, ArrayList<Item> arrayList, String headerName) {
        id = idd;
        manufacturerBottomSheet = new ManufacturerBottomSheet(arrayList, idd, headerName);
        manufacturerBottomSheet.show(getSupportFragmentManager(), ""+headerName);



    }

    private void monthPickerInitializer() {
        MonthPickerDialog.Builder builder = new MonthPickerDialog.Builder(AddCarActivity.this, new MonthPickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(int selectedMonth, int selectedYear) {
                year_edittext.setText(Integer.toString(selectedYear));
                year_edittext.setError(null);
                choosenYear = selectedYear;
            }
        }, choosenYear, 0);

        builder.showYearOnly()
                .setYearRange(1900, 2020)
                .build()
                .show();

    }

    public void listInit() {
        itemArrayListModel.add(new Item("A1"));
        itemArrayListModel.add(new Item("A2"));
        itemArrayListModel.add(new Item("B1"));
        itemArrayListModel.add(new Item("B2"));
        itemArrayListModel.add(new Item("C1"));
        itemArrayListModel.add(new Item("C2"));
        itemArrayListModel.add(new Item("D1"));
        itemArrayListModel.add(new Item("D2"));
        itemArrayListModel.add(new Item("E1"));
        itemArrayListModel.add(new Item("E2"));
        itemArrayListModel.add(new Item("F1"));
        itemArrayListModel.add(new Item("F2"));



        itemArrayList.add(new Item("Audi"));
        itemArrayList.add(new Item("Bmw"));
        itemArrayList.add(new Item("Buick"));
        itemArrayList.add(new Item("Chevrolet"));
        itemArrayList.add(new Item("Chrysler"));
        itemArrayList.add(new Item("Citroen"));
        itemArrayList.add(new Item("Daimler"));
        itemArrayList.add(new Item("Fiat"));
        itemArrayList.add(new Item("Ford"));
        itemArrayList.add(new Item("Honda"));
        itemArrayList.add(new Item("Toyota"));
        itemArrayList.add(new Item("Volkswagen"));




        itemArrayListFuel.add(new Item("Diesel"));
        itemArrayListFuel.add(new Item("Electric"));
        itemArrayListFuel.add(new Item("Gas"));
        itemArrayListFuel.add(new Item("Gasoline"));
        itemArrayListFuel.add(new Item("Hybrid"));
        itemArrayListFuel.add(new Item("Petrol"));


    }
    private boolean areFieldsValid() {
        boolean[] check = new boolean[]{false, false, false, false,false};
        if (TextUtils.isEmpty(year_edittext.getText())) {
            year_edittext.setError("Please select a year");
        } else {
            check[0] = true;
            year_edittext.setError(null);
        }
        if (TextUtils.isEmpty(manufacturer_edittext.getText())) {
            manufacturer_edittext.setError("Please select a manufacturer");
        } else {
            check[1] = true;
            manufacturer_edittext.setError(null);
        }
        if (TextUtils.isEmpty(model_edittext.getText())) {
            model_edittext.setError("Please select a model");
        } else {
            check[2] = true;
            model_edittext.setError(null);
        }
        if (TextUtils.isEmpty(fuel_edittext.getText())) {
            fuel_edittext.setError("Please select a fuel type");
        } else {
            check[3] = true;
            fuel_edittext.setError(null);
        }
        if (TextUtils.isEmpty(engine_edittext.getText())) {
            engine_edittext.setError("Please enter engine displacement");
        } else {
            check[4] = true;
            engine_edittext.setError(null);
        }
        return check[0] && check[1] && check[2] && check[3]&&check[4];
    }


}
