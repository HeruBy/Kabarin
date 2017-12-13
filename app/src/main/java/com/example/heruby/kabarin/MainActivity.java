package com.example.heruby.kabarin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.example.heruby.kabarin.adapter.AgendaAdapter;
import com.example.heruby.kabarin.model.Agenda;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AgendaAdapter adapter;
    LayoutInflater layoutInflater;

    List<Agenda> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView =findViewById(R.id.recyclerView);
        layoutInflater = getLayoutInflater();

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
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
