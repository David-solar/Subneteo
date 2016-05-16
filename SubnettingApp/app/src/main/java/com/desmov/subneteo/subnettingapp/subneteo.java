package com.desmov.subneteo.subnettingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
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

        Metodos.ip.clear();
        Metodos.prefijos.clear();
        Metodos.tablaSubneteo.clear();

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        switch (id)
        {

            case R.id.inicio:
                Intent mov1 = new Intent(this, Bienvenido.class);
                startActivity(mov1);

                Metodos.ip.clear();
                Metodos.prefijos.clear();
                Metodos.tablaSubneteo.clear();



                break;

            case R.id.acercaDe:
                Intent mov2 = new Intent(this,acercaDe.class);
                startActivity(mov2);
                break;

            case R.id.conceptosBasicos:
                Intent mov3 = new Intent(this, conceptosBasicos.class);
                startActivity(mov3);
                break;

            case R.id.info:
                Intent mov4 = new Intent(this, informacion.class);
                startActivity(mov4);
                break;

            case R.id.ayuda:
                Intent mov5 = new Intent(this, Ayuda.class);
                startActivity(mov5);
                break;

            case R.id.contactanos:
                Intent mov7 = new Intent(this, contactanos.class);
                startActivity(mov7);
                break;

            case R.id.opiniones:
                Intent mov8 = new Intent(this, Opiniones.class);
                startActivity(mov8);
                break;

        }

        return super.onOptionsItemSelected(item);

    }


}
