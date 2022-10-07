package com.beast.nari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DuoDrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

    }

    private void init() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
        DuoDrawerToggle drawerToggle = new DuoDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_close,
                R.string.navigation_drawer_open);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        View contentView = drawerLayout.getContentView();
        View menuView = drawerLayout.getMenuView();

        LinearLayout ll_Home = menuView.findViewById(R.id.ll_Home);
        LinearLayout ll_Profile = menuView.findViewById(R.id.ll_Profile);
        LinearLayout ll_sos = menuView.findViewById(R.id.ll_sos);
        LinearLayout ll_gscheme = menuView.findViewById(R.id.ll_gscheme);
        LinearLayout ll_ghelpline = menuView.findViewById(R.id.ll_ghelpline);
        LinearLayout ll_cookhelper = menuView.findViewById(R.id.ll_cookhelper);
        LinearLayout ll_Hemergency = menuView.findViewById(R.id.ll_Hemergency);
        LinearLayout ll_aguardian = menuView.findViewById(R.id.ll_aguardian);
        LinearLayout ll_ancomm = menuView.findViewById(R.id.ll_ancomm);
        LinearLayout ll_bot = menuView.findViewById(R.id.ll_bot);
        LinearLayout ll_qrcode = menuView.findViewById(R.id.ll_qrcode);
        LinearLayout ll_ptcalendar = menuView.findViewById(R.id.ll_ptcalendar);
        LinearLayout ll_Logout = menuView.findViewById(R.id.ll_Logout);


        ll_Home.setOnClickListener(this);
        ll_Profile.setOnClickListener(this);
        ll_sos.setOnClickListener(this);
        ll_gscheme.setOnClickListener(this);
        ll_ghelpline.setOnClickListener(this);
        ll_cookhelper.setOnClickListener(this);
        ll_Hemergency.setOnClickListener(this);
        ll_aguardian.setOnClickListener(this);
        ll_ancomm.setOnClickListener(this);
        ll_bot.setOnClickListener(this);
        ll_qrcode.setOnClickListener(this);
        ll_ptcalendar.setOnClickListener(this);
        ll_Logout.setOnClickListener(this);


        replace(new HomeFragment());


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_Home:
                replace(new HomeFragment(),"Home");
                break;

            case R.id.ll_Profile:
                replace(new ProfileFragment(),"Profile");
                break;

            case R.id.ll_sos:
                replace(new sosFragment(),"SOS");
                break;

            case R.id.ll_gscheme:
                replace(new gschemeFragment(),"gscheme");
                break;

            case R.id.ll_ghelpline:
                replace(new ghelplineFragment(),"ghelpline");
                break;
            case R.id.ll_cookhelper:
                replace(new cookhelperFragment(),"cookhelper");
                break;
            case R.id.ll_Hemergency:
                replace(new HemergencyFragment(),"Hemergency");
                break;

            case R.id.ll_aguardian:
                replace(new aguardianFragment(),"aguardian");
                break;

            case R.id.ll_ancomm:
                replace(new ancommFragment(),"ancomm");
                break;

            case R.id.ll_bot:
                replace(new botFragment(),"bot");
                break;

            case R.id.ll_qrcode:
                replace(new qrcodeFragment(),"qrcode");
                break;

            case R.id.ll_ptcalendar:
                replace(new ptcalendarFragment(),"ptcalendar");
                break;

            case R.id.ll_Logout:
                Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer();
    }

    private void replace(Fragment fragment, String s) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.addToBackStack(s);
        transaction.commit();
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }


}