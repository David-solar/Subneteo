package com.desmov.subneteo.subnettingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class Bienvenido extends AppCompatActivity implements View.OnClickListener{


    Button subneteo;
    Button sobreDesarrollador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);
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

        subneteo = (Button) findViewById(R.id.btnSubneteo);
        sobreDesarrollador = (Button) findViewById(R.id.btnSobreDesarrollador);

        subneteo.setOnClickListener(this);
        sobreDesarrollador.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bienvenido, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        switch (id)
        {

            case R.id.inicio:
                Intent mov1 = new Intent(this,subneteoIp.class);
                startActivity(mov1);

                Metodos.ip.clear();
                Metodos.prefijos.clear();
                Metodos.tablaSubneteo.clear();

                break;

            case R.id.acercaDe:
                Intent mov2 = new Intent(Bienvenido.this,acercaDe.class);
                startActivity(mov2);
                break;

            case R.id.conceptosBasicos:
                Intent mov3 = new Intent(Bienvenido.this, conceptosBasicos.class);
                startActivity(mov3);
                break;

            case R.id.info:
                Intent mov4 = new Intent(Bienvenido.this, informacion.class);
                startActivity(mov4);
                break;

            case R.id.ayuda:
                Intent mov5 = new Intent(this, Ayuda.class);
                startActivity(mov5);
                break;

            case R.id.contactanos:
                Intent mov7 = new Intent(Bienvenido.this, contactanos.class);
                startActivity(mov7);
                break;

            case R.id.opiniones:
                Intent mov8 = new Intent(Bienvenido.this, Opiniones.class);
                startActivity(mov8);
                break;

        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btnSobreDesarrollador:
                Toast.makeText(getApplicationContext(),"Datos sobre el desarrollador", Toast.LENGTH_SHORT).show();
                Intent in_acceso = new Intent(Bienvenido.this,sobreDesarrollador.class);
                startActivity(in_acceso);
                break;

            case R.id.btnSubneteo:
                Toast.makeText(getApplicationContext(),"Iniciaste el Subneteo", Toast.LENGTH_SHORT).show();
                Intent subIp = new Intent(Bienvenido.this,subneteoIp.class);
                startActivity(subIp);
                break;
        }

    }
}
