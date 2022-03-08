package com.example.ledgerbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.Myviewholder> {

    private ArrayList<transactions> tlist;


    public recycleAdapter(ArrayList<transactions> tlist) {
        this.tlist=tlist;
    }

    @NonNull
    @Override
    public recycleAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.transactions,parent,false);
        return new Myviewholder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull recycleAdapter.Myviewholder holder, int position) {
        String i1=tlist.get(position).getId();
        String p1=tlist.get(position).getPurpose();
        String a1=tlist.get(position).getAmount();
        holder.id.setText(i1);
        holder.amount.setText(a1);
        holder.purpose.setText(p1);

    }

    @Override
    public int getItemCount() {
        return tlist.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        private TextView id,purpose,amount;
        public Myviewholder(final View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.t_id_value);
            purpose=(TextView)itemView.findViewById(R.id.t_purpose_value);
            amount=(TextView)itemView.findViewById(R.id.t_amount_value);
        }
    }
}
