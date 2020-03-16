package com.jayapps.envirocarappchallenge;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class ManufacturerBottomSheet extends BottomSheetDialogFragment implements AdapterBottomSheet.onItemClickedRecycler {

    AdapterBottomSheet.onItemClickedRecycler onItemClickedRecycler = ManufacturerBottomSheet.this;
    private BottomSheetListener mbottomSheetListener;
    private BottomSheetListenerCancel bottomSheetListenerCancel;
    private int id;
    private RecyclerView recyclerView;
    private AdapterBottomSheet mAdapter;
    private ArrayList<Item> itemArrayList;
    private String headingName = "";
    TextView name;
    androidx.appcompat.widget.SearchView searchView;

    public ManufacturerBottomSheet(ArrayList<Item> itemArrayList, int id, String headingName) {
        this.itemArrayList = itemArrayList;
        this.id = id;
        this.headingName = headingName;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottomsheet_manufacturer, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);

        searchView = v.findViewById(R.id.filteredittext);

        name = v.findViewById(R.id.textView);
        name.setText(headingName);
        mAdapter = new AdapterBottomSheet(itemArrayList, onItemClickedRecycler, id);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setAdapter(mAdapter);


        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                ArrayList<Item> temp = new ArrayList();
                for (Item d : itemArrayList) {
                    //or use .equal(text) with you want equal match
                    //use .toLowerCase() for better matches
                    if (d.getName().contains(s)) {
                        temp.add(d);
                    }
                }

                mAdapter.filterlist(temp);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Item> temp = new ArrayList();
                for (Item d : itemArrayList) {
                    //or use .equal(text) with you want equal match
                    //use .toLowerCase() for better matches
                    if (d.getName().contains(s)) {
                        temp.add(d);
                    }
                }

                mAdapter.filterlist(temp);

                return false;
            }
        });


        return v;


    }

    void filter(String text) {
        ArrayList<Item> temp = new ArrayList();
        for (Item d : itemArrayList) {
            //or use .equal(text) with you want equal match
            //use .toLowerCase() for better matches
            if (d.getName().contains(text)) {
                temp.add(d);
            }
        }
        //update recyclerview


    }

    private void prepareList() {

        itemArrayList.add(new Item("11"));
        itemArrayList.add(new Item("12"));
        itemArrayList.add(new Item("13"));
        itemArrayList.add(new Item("14"));
        itemArrayList.add(new Item("15"));
        itemArrayList.add(new Item("16"));

    }

    @Override
    public void onItemSelected(String nametext, int id) {
        mbottomSheetListener.onItemClicked(nametext, id);
    }


    public interface BottomSheetListener {
        void onItemClicked(String text, int id);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mbottomSheetListener = (BottomSheetListener) context;
        bottomSheetListenerCancel=(BottomSheetListenerCancel)context;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
    bottomSheetListenerCancel.onItemCancel(id);

    }
    public interface BottomSheetListenerCancel {
        void onItemCancel(int id);

    }
}

