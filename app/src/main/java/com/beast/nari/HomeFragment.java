package com.beast.nari;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {

    }

    RecyclerView featuredrecycler,featuresrecycler;

    RecyclerView.Adapter adapter;

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_narihome, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        featuredrecycler = view.findViewById(R.id.featured_recycler);
        featuresrecycler = view.findViewById(R.id.mostviewed_recycler);


        featuredrecycler();

        featuresrecycler();

    }


    private void featuresrecycler() {

        featuresrecycler.setHasFixedSize(true);
        featuresrecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));


        ArrayList<featuresHelperclass>  featureslocation = new ArrayList<>();

        featureslocation.add(new featuresHelperclass(R.drawable.qrcode,"QR Scan"));
        featureslocation.add(new featuresHelperclass(R.drawable.pro,"professional \n" +
                "helper"));
        featureslocation.add(new featuresHelperclass(R.drawable.adduser,"Add Guardian"));
        featureslocation.add(new featuresHelperclass(R.drawable.group,"Anonymous Nari Communication"));
        featureslocation.add(new featuresHelperclass(R.drawable.bot,"24/7 Helpline Bot"));
        featureslocation.add(new featuresHelperclass(R.drawable.menstruation,"Period \n" + "Tracking \n" + "calendar"));


        adapter = new featuresAdapter(featureslocation);
        featuresrecycler.setAdapter(adapter);

    }

    private void featuredrecycler() {

        featuredrecycler.setHasFixedSize(true);
        featuredrecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));


        ArrayList<featuredHelperClass> featuredLocation = new ArrayList<>();

        featuredLocation.add(new featuredHelperClass(R.drawable.protection,"Self Defence","Here You can learn Self Defence"));
        featuredLocation.add(new featuredHelperClass(R.drawable.womenpower,"Government Scheme","All Government Scheme will be visible here"));
        featuredLocation.add(new featuredHelperClass(R.drawable.helpline1,"Government Helpline","All Government Helpline will be visible here"));
        featuredLocation.add(new featuredHelperClass(R.drawable.emergency,"Emergency Contact","You can call to your close one"));
        featuredLocation.add(new featuredHelperClass(R.drawable.voice,"voice Recognition","Voice Recognition by which you can send message"));


        adapter = new featuredadapter(featuredLocation);
        featuredrecycler.setAdapter(adapter);



    }
}
