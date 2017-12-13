package com.example.heruby.kabarin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heruby.kabarin.R;
import com.example.heruby.kabarin.model.Agenda;

import java.util.List;

/**
 * Created by Andri Ginting on 12/13/2017.
 */

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ProductViewHolder>{


    private Context mCtx;
    private List<Agenda> agendaList;

    public AgendaAdapter(Context mCtx, List<Agenda> agendaList) {
        this.mCtx = mCtx;
        this.agendaList = agendaList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        ProductViewHolder holder = new ProductViewHolder(view);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Agenda product = agendaList.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        holder.textViewDate.setText(product.getDate());

        //holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage(), null));
    }

    @Override
    public int getItemCount() {
        return agendaList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle, textViewDesc, textViewDate;

        public ProductViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewDate = itemView.findViewById(R.id.textViewDate);

        }
    }
}

