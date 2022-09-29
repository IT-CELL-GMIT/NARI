package com.beast.nari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.beast.nari.adapter.ChatAdapter;

import com.beast.nari.databinding.ActivityChatWithBoatBinding;
import com.beast.nari.model.ChatModel;

import java.util.ArrayList;
import java.util.List;

public class ChatWithBoat extends AppCompatActivity {

    static LinearLayoutManager linearLayoutManager;
    static RecyclerView recyclerView;
    static List<ChatModel> list;
    static ChatModel model;
    static ChatAdapter adapter;
    private ActivityChatWithBoatBinding binding;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat_with_boat);
        recyclerView = findViewById(R.id.chatRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        adapter = new ChatAdapter(list, this, ChatWithBoat.this);
        recyclerView.setAdapter(adapter);

        model = new ChatModel("Rape", "boat");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();

        model = new ChatModel("Black Mailing", "boat");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();

        model = new ChatModel("Family Force", "boat");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();

        model = new ChatModel("Periods", "boat");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();

        model = new ChatModel("Gender Divide", "boat");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();

    }

    public static void setChatText(String selectedMsg, Activity activity){

        if(selectedMsg.equalsIgnoreCase("Rape")){

            setLeftMsg(selectedMsg);
            setRightMsg(activity.getResources().getString(R.string.rape));

        }else if(selectedMsg.equalsIgnoreCase("Black Mailing")){

            setLeftMsg(selectedMsg);

            setRightMsg(activity.getResources().getString(R.string.black_mail));

        }else if(selectedMsg.equalsIgnoreCase("Family Force")){

            setLeftMsg(selectedMsg);

            setRightMsg("Family Pressure Type 1");
            setRightMsg("Family Pressure Type 2");
            setRightMsg("Family Pressure Type 3");

        }else if(selectedMsg.equalsIgnoreCase("Periods")){

            setLeftMsg(selectedMsg);

            setRightMsg(activity.getResources().getString(R.string.periods));

        }else if(selectedMsg.equalsIgnoreCase("Gender Divide")){

            setLeftMsg(selectedMsg);

            setRightMsg(activity.getResources().getString(R.string.gender_divide));

        }else if(selectedMsg.equalsIgnoreCase("Family Pressure Type 1")){

            setLeftMsg(selectedMsg);

            setRightMsg(activity.getResources().getString(R.string.fp1));

        }else if(selectedMsg.equalsIgnoreCase("Family Pressure Type 2")){

            setLeftMsg(selectedMsg);

            setRightMsg(activity.getResources().getString(R.string.fp2));

        }else if(selectedMsg.equalsIgnoreCase("Family Pressure Type 3")){

           setLeftMsg(selectedMsg);

            setRightMsg(activity.getResources().getString(R.string.fp3));

        }


    }

    @SuppressLint("NotifyDataSetChanged")
    static void setLeftMsg(String msg){

        model = new ChatModel(msg, "nari");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);

    }

    @SuppressLint("NotifyDataSetChanged")
    static void setRightMsg(String msg){

        model = new ChatModel(msg, "boat");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);

    }



}