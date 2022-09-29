package com.beast.nari.adapter;

import static com.beast.nari.ChatWithBoat.setChatText;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.beast.nari.ChatWithBoat;
import com.beast.nari.R;
import com.beast.nari.model.ChatModel;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatHolderClass> {

    List<ChatModel> list;
    Activity activity;
    Context context;
    final int leftChat = 1;
    final int rightChat = 2;

    public ChatAdapter(List<ChatModel> list, Activity activity, Context context) {
        this.list = list;
        this.activity = activity;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1){
            View view = LayoutInflater.from(context).inflate(R.layout.activity_chat_left, parent, false);
            return new ChatHolderClass(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_chat_right, parent, false);
            return new ChatHolderClass(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getPERSON().equalsIgnoreCase("nari")){
            return leftChat;
        }else {
            return rightChat;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolderClass holder, int position) {

        holder.smsText.setText(list.get(position).getText());
        holder.smsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(position).getPERSON().equalsIgnoreCase("boat")){
                   setChatText(list.get(position).getText());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class ChatHolderClass extends RecyclerView.ViewHolder {

    TextView smsText;

    public ChatHolderClass(@NonNull View itemView) {
        super(itemView);
        smsText = itemView.findViewById(R.id.chat_text);
    }
}