package com.example.heruby.kabarin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.example.heruby.kabarin.adapter.AgendaAdapter;
import com.example.heruby.kabarin.model.Agenda;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements InputFragment.komunikasiFragment{

    RecyclerView recyclerView;
    AgendaAdapter adapter;
    LayoutInflater layoutInflater;

    List<Agenda> productList;
    String label = "",detail="",time="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView =findViewById(R.id.recyclerView);
        layoutInflater = getLayoutInflater();

        adapter = new AgendaAdapter(getApplicationContext(), productList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        cekData();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                Boolean isFirstStart = pref.getBoolean("firststart",true);
                if (isFirstStart){
                    startActivity(new Intent(MainActivity.this,IntroActivity.class));
                    SharedPreferences.Editor e = pref.edit();
                    e.putBoolean("firststart",false);
                    e.apply();
                }
            }
        });
        thread.start();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                InputFragment inputFragment = new InputFragment();
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.frame_container,inputFragment)
//                        .commit();
//                fab.hide();

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        InputActivity.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public void kirimData(String label, String detail, String date) {
        this.label = label;
        this.detail = detail;
        this.time = time;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getDetail() {
        return detail;
    }

    @Override
    public String getTime() {
        return time;
    }
    public void cekData(){
        Agenda agenda = new Agenda("Project Akhir PAPB", "coba coba", "1234");
        productList.add(agenda);
    }
}
