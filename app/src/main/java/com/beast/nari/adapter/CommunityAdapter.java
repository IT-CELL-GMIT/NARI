package com.beast.nari.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beast.nari.R;
import com.beast.nari.model.CommunityModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityHolder> {

    List<CommunityModel> list;
    Activity activity;

    public CommunityAdapter(List<CommunityModel> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CommunityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.custom_layout_community_post, parent, false);
        return new CommunityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityHolder holder, int position) {

        holder.userID.setText(list.get(position).getUserID());
        holder.originalUserID.setText(list.get(position).getOriginalUserID());
        holder.likes.setText(list.get(position).getLikes());
        holder.disLikes.setText(list.get(position).getDisLikes());
        holder.noOfReplies.setText(list.get(position).getNoOfReplies());
        holder.noOfReposts.setText(list.get(position).getRePosts());

        if (list.get(position).getCaption().length()<=20){
            holder.moreCap.setVisibility(View.INVISIBLE);
            holder.caption.setText(list.get(position).getCaption());
        }else {
            String cap = "";
            for (int i = 0; i<=20; i++){
                cap = cap + String.valueOf(list.get(position).getCaption().charAt(i));
            }
            holder.caption.setText(cap);
        }

        Glide.with(activity).load(list.get(position).getProfilePic()).into(holder.profilePic);
        Glide.with(activity).load(list.get(position).getPostIMG()).into(holder.postImg);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class CommunityHolder extends RecyclerView.ViewHolder {

    TextView userID, originalUserID, likes, disLikes, noOfReplies, caption, noOfReposts;
    ImageView profilePic, postImg, like, dislike, reply, moreCap, rePosts;

    public CommunityHolder(@NonNull View itemView) {
        super(itemView);

        userID = itemView.findViewById(R.id.userID);
        originalUserID = itemView.findViewById(R.id.originalUserId);
        likes = itemView.findViewById(R.id.communityLikes);
        disLikes = itemView.findViewById(R.id.communityDisLikes);
        noOfReplies = itemView.findViewById(R.id.communityReplies);
        caption = itemView.findViewById(R.id.communityCaption);
        noOfReposts = itemView.findViewById(R.id.noOfReposts);

        profilePic = itemView.findViewById(R.id.communityProfilePic);
        postImg = itemView.findViewById(R.id.communityPostIMG);
        like = itemView.findViewById(R.id.likePost);
        dislike = itemView.findViewById(R.id.disLikePost);
        reply = itemView.findViewById(R.id.replyPost);
        moreCap = itemView.findViewById(R.id.moreCaptionText);
        rePosts = itemView.findViewById(R.id.communityReposts);

    }
}