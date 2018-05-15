package com.example.ka.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.ka.recyclerview.ImagePlayer.decodeSampledBitmapFromResource;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    ArrayList<DataShop> dataShops;
    Context context;

    private int previousPosition = 0;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(dataShops.get(position).getTen());
        holder.imgHinh.setImageResource(dataShops.get(position).getHinhAnh());
        holder.imgHinh.setImageBitmap(decodeSampledBitmapFromResource(context.getResources(),dataShops.get(position).getHinhAnh(),200,100));

    }


    @Override
    public int getItemCount() {
        return dataShops.size();
    }


    public void RemoveItem(int position){
        dataShops.remove(position);
        notifyItemRemoved(position);
    }






    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgHinh;

        public ViewHolder(final View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imgHinh = itemView.findViewById(R.id.imgHinh);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemoveItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(),"Remove" + txtName.getText(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }


}
