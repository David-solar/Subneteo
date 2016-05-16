package com.desmov.subneteo.subnettingapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class subneteoPrefijo extends AppCompatActivity implements View.OnClickListener{

    Button iniciar;
    Button agregar;
    EditText casilla;

    Metodos met = new Metodos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subneteo_prefijo);
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

        iniciar = (Button) findViewById(R.id.btnCalcularSUbneteo);

        agregar = (Button) findViewById(R.id.btnAgregarPrefijo);

        casilla = (EditText) findViewById(R.id.etPre);

        iniciar.setOnClickListener(this);
        agregar.setOnClickListener(this);

        iniciar.setEnabled(false);

    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btnCalcularSUbneteo:

                if(!Metodos.prefijos.isEmpty())
                {
                    met.ordenarPrefijos();
                    met.calcularSubneteo();
                    Intent subPe = new Intent(subneteoPrefijo.this,subneteo.class);
                    startActivity(subPe);



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No has agregado prefijos", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnAgregarPrefijo:

                if(casilla.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"No has agregado prefijos", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int p = Integer.parseInt(casilla.getText().toString());

                    if(met.validarPrefijo(p))
                    {
                        Metodos.prefijos.add(p);
                        ventanaDialogo(casilla, agregar);
                    }
                    else
                    {
                        ventanaDialogo(casilla);
                    }

                    //System.out.println(Metodos.prefijos.size() + " ***************************");

                }

                break;
        }

    }

    public void ventanaDialogo(final EditText et, final Button btn)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("Deseas agregar otro prefijo\nPulsa NO para iniciar el subneteo");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                et.setText(null);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                et.setEnabled(false);
                btn.setEnabled(false);
                iniciar.setEnabled(true);
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

    public void ventanaDialogo(final EditText et)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("Prefijo no valido\nIngresa valores\nmayor a 0 y menor a 33");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                et.setText(null);
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }



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
