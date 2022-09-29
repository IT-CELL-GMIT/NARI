package com.beast.nari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

    public static void setChatText(String selectedMsg){

        model = new ChatModel(selectedMsg, "nari");
        list.add(list.size(), model);
        adapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);

    }

}