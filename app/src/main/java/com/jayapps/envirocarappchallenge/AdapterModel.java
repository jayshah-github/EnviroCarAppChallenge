package com.jayapps.envirocarappchallenge;




import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterModel extends RecyclerView.Adapter<AdapterModel.ViewHolder>   {
    private ArrayList<Item> mCars;
    public AdapterModel(ArrayList<Item> mCars) {
        this.mCars = mCars;
    }

    @NonNull
    @Override

    public AdapterModel.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_car, parent, false);
        AdapterModel.ViewHolder viewHolder = new AdapterModel.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterModel.ViewHolder holder, int position) {
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
