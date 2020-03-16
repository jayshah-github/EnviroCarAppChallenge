package com.jayapps.envirocarappchallenge;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapterrrrrrrrrr extends RecyclerView.Adapter<Adapterrrrrrrrrr.ViewHolder>   {
    private ArrayList<Item> mItems;
    private onItemClickedRecycler mlistener;
private int id;
    public Adapterrrrrrrrrr(ArrayList<Item> mItems,onItemClickedRecycler mlistener,int id) {
        this.mItems = mItems;
        this.mlistener=mlistener;
        this.id=id;
    }

    @NonNull
    @Override

    public Adapterrrrrrrrrr.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_manufacturers, parent, false);
        Adapterrrrrrrrrr.ViewHolder viewHolder = new Adapterrrrrrrrrr.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterrrrrrrrrr.ViewHolder holder, int position) {
        holder.bindData(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mFarmerName;



        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            mFarmerName=itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = mItems.get(getAdapterPosition()).getName();
mlistener.onItemSelected(name,id);
                }
            });

        }
        public void bindData(Item item) {
            mFarmerName.setText(item.getName());

        }
    }
    public interface onItemClickedRecycler {
        void onItemSelected(String nametext,int id);
    }
    public void filterlist(ArrayList<Item> filteredlist)
    {
        mItems=filteredlist;
        notifyDataSetChanged();
    }

}
