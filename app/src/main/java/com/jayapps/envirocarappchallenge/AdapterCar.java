package com.jayapps.envirocarappchallenge;




import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterCar extends RecyclerView.Adapter<AdapterCar.ViewHolder>   {
    private ArrayList<Item> mCars;
    public AdapterCar(ArrayList<Item> mCars) {
        this.mCars = mCars;
    }

    @NonNull
    @Override

    public AdapterCar.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_car, parent, false);
        AdapterCar.ViewHolder viewHolder = new AdapterCar.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCar.ViewHolder holder, int position) {
   //     holder.bindData(mCars.get(position));
    }

    @Override
    public int getItemCount() {
        return 5;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mFarmerName;



        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            //mFarmerName=itemView.findViewById(R.id.textViewmodel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // String name = mCars.get(getAdapterPosition()).getName();
                        }
            });

        }
        public void bindData(Item item) {
            //mFarmerName.setText(item.getName());

        }
    }

}
