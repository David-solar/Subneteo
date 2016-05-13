package com.desmov.subneteo.subnettingapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class subneteo extends AppCompatActivity implements View.OnClickListener
{


    Button prb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subneteo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        prb = (Button) findViewById(R.id.btnPrb);

        prb.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btnPrb:

                Metodos m = new Metodos();



                for(int i = 0; i < m.tablaSubneteo.size(); i++)
                {



                    for(int j = 0; i < 6; i++)
                    {
                        
                    }
                }

                break;
        }

    }
}
