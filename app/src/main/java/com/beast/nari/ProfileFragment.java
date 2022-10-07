package com.beast.nari;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {

    }

    RecyclerView featuredrecycler,mostviewedrecycler,categoryrecycler;

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

        return inflater.inflate(R.layout.fragment_nariprofile, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//
//        featuredrecycler = view.findViewById(R.id.featured_recycler);
//        mostviewedrecycler = view.findViewById(R.id.mostviewed_recycler);
//        categoryrecycler = view.findViewById(R.id.category_recycler);
//
//        featuredrecycler();
//
//        mostviewedrecycler();
//
//        categoryrecycler();
    }

//    private void categoryrecycler() {
//
//        categoryrecycler.setHasFixedSize(true);
//        categoryrecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
//
//
//        ArrayList<categoryHelperclass> categorylocation = new ArrayList<>();
//
//        categorylocation.add(new categoryHelperclass(R.drawable.idea,"random text"));
//        categorylocation.add(new categoryHelperclass(R.drawable.appicon2,"icon"));
//        categorylocation.add(new categoryHelperclass(R.drawable.dp,"Boy"));
//
//
//        adapter = new categoryAdapter(categorylocation);
//        categoryrecycler.setAdapter(adapter);
//
//    }
//
//    private void mostviewedrecycler() {
//
//        mostviewedrecycler.setHasFixedSize(true);
//        mostviewedrecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
//
//
//        ArrayList<mostviewedHelperclass>  mostviewedlocation = new ArrayList<>();
//
//        mostviewedlocation.add(new mostviewedHelperclass(R.drawable.idea,"random text","just a random discription"));
//        mostviewedlocation.add(new mostviewedHelperclass(R.drawable.appicon2,"icon","just a random discription"));
//        mostviewedlocation.add(new mostviewedHelperclass(R.drawable.dp,"Boy","just a random discription"));
//
//
//        adapter = new MostviewedAdapter(mostviewedlocation);
//        mostviewedrecycler.setAdapter(adapter);
//
//    }
//
//    private void featuredrecycler() {
//
//        featuredrecycler.setHasFixedSize(true);
//        featuredrecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
//
//
//        ArrayList<featuredHelperClass> featuredLocation = new ArrayList<>();
//
//        featuredLocation.add(new featuredHelperClass(R.drawable.idea,"random text","just a random discription"));
//        featuredLocation.add(new featuredHelperClass(R.drawable.appicon2,"icon","just a random discription"));
//        featuredLocation.add(new featuredHelperClass(R.drawable.dp,"Boy","just a random discription"));
//
//
//        adapter = new FeaturedAdapter(featuredLocation);
//        featuredrecycler.setAdapter(adapter);
//
////        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});
//
//    }
}
