package com.beast.nari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beast.nari.R;

import java.util.ArrayList;

public class featuresAdapter extends RecyclerView.Adapter<featuresAdapter.featuresViewHolder> {

    ArrayList<featuresHelperclass>  featureslocation;

    public featuresAdapter( ArrayList<featuresHelperclass>  featureslocation){
        this.featureslocation = featureslocation;
    }

    @NonNull
    @Override
    public featuresAdapter.featuresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design,parent,false);
        featuresAdapter.featuresViewHolder featuresViewHolder = new featuresAdapter.featuresViewHolder(view);



        return featuresViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull featuresAdapter.featuresViewHolder holder, int position) {

        featuresHelperclass featuresHelperclass = featureslocation.get(position);

        holder.image.setImageResource(featuresHelperclass.getImg());
        holder.tittle.setText(featuresHelperclass.getTitle());

    }

    @Override
    public int getItemCount() {
        return featureslocation.size();
    }

    public static class featuresViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView tittle;

        public featuresViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.card_fake);
            tittle = itemView.findViewById(R.id.card_tittle);


        }
    }
}
