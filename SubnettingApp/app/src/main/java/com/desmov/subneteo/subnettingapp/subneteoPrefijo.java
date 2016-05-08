package com.desmov.subneteo.subnettingapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

                    System.out.println("********************************************************");
                    for(int i = 0; i < Metodos.prefijos.size(); i++)
                    {
                        System.out.println(Metodos.prefijos.get(i));
                    }
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
        builder.setMessage("Deseas agregar otro prefijo");
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



}
