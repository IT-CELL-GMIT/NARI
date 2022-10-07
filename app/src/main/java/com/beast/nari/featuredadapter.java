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

public class featuredadapter extends RecyclerView.Adapter<featuredadapter.FeaturedViewHolder> {

    ArrayList<featuredHelperClass> featuredLocation;

    public featuredadapter(ArrayList<featuredHelperClass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featuredlist,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);



        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        featuredHelperClass featuredHelperClass = featuredLocation.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.tittle.setText(featuredHelperClass.getTittle());
        holder.desc.setText(featuredHelperClass.getDesc());
    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView tittle,desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.featured_image);
            tittle = itemView.findViewById(R.id.featured_tittle);
            desc = itemView.findViewById(R.id.featured_desc);
        }
    }
}
