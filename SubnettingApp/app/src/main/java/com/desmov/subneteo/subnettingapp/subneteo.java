package com.desmov.subneteo.subnettingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class subneteo extends AppCompatActivity /*implements View.OnClickListener*/
{

    //TableLayout tab = (TableLayout) findViewById(R.id.tabla);
    Button bt;


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


        //bt = (Button) findViewById(R.id.btna);

        //bt.setOnClickListener(this);


        TableLayout tt = (TableLayout) findViewById(R.id.tabla);

        Tabla tab = new Tabla(this, tt);

        //se le manda el array de la cabecera
        tab.agregarCabecera(R.array.cabecera_tabla);


        for(int i = 0; i < Metodos.tablaSubneteo.size(); i++)
        {
            /*ArrayList<String> elementos = new ArrayList<String>();
            elementos.add(Integer.toString(i));
            elementos.add("Casilla [" + i + ", 0]");
            elementos.add("Casilla [" + i + ", 1]");
            elementos.add("Casilla [" + i + ", 2]");
            elementos.add("Casilla [" + i + ", 3]");
            tab.agregarFilaTabla(elementos);*/

            tab.agregarFilaTabla(Metodos.tablaSubneteo.get(i));

        }

    }


    /*@Override
    public void onClick(View v)
    {
        Metodos m = new Metodos();
        switch (v.getId())
        {

            case R.id.btna:

                for(int i = 0; i < m.tablaSubneteo.size(); i++)
                {
                    String[] ma = m.tablaSubneteo.get(i);
                    for(int j = 0; j < 6; j++)
                    {
                        System.out.print(ma[j] + " ");
                    }
                    System.out.println();
                }

                break;
        }

    }*/
}
