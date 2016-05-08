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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class subneteoIp extends AppCompatActivity implements View.OnClickListener
{

    Button sig;
    EditText h1;
    EditText h2;
    EditText h3;
    EditText h4;

    Metodos met = new Metodos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subneteo_ip);
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

        sig = (Button) findViewById(R.id.btnSig);

        h1 = (EditText) findViewById(R.id.etHoc1);
        h2 = (EditText) findViewById(R.id.etHoc2);
        h3 = (EditText) findViewById(R.id.etHoc3);
        h4 = (EditText) findViewById(R.id.etHoc4);

        sig.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btnSig:

                String hoc1 = h1.getText().toString();
                String hoc2 = h2.getText().toString();
                String hoc3 = h3.getText().toString();
                String hoc4 = h4.getText().toString();

                if(hoc1.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Ingresa un valor en el hocteto 1", Toast.LENGTH_SHORT).show();
                }
                else if(hoc2.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Ingresa un valor en el hocteto 2", Toast.LENGTH_SHORT).show();
                }
                else if(hoc3.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Ingresa un valor en el hocteto 3", Toast.LENGTH_SHORT).show();
                }
                else if(hoc4.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Ingresa un valor en el hocteto 4", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    int hocteto1 = Integer.parseInt(hoc1);
                    int hocteto2 = Integer.parseInt(hoc2);
                    int hocteto3 = Integer.parseInt(hoc3);
                    int hocteto4 = Integer.parseInt(hoc4);

                    if(met.validarHocteto(hocteto1))
                    {
                        if(met.validarHocteto(hocteto2))
                        {
                            if(met.validarHocteto(hocteto3))
                            {
                                if(met.validarHocteto(hocteto4))
                                {
                                    Metodos.ip.add(hocteto1);
                                    Metodos.ip.add(hocteto2);
                                    Metodos.ip.add(hocteto3);
                                    Metodos.ip.add(hocteto4);

                                    //Toast.makeText(getApplicationContext(),"Ingresa los prefijos", Toast.LENGTH_SHORT).show();
                                    Intent subPe = new Intent(subneteoIp.this,subneteoPrefijo.class);
                                    startActivity(subPe);

                                    for(int i = 0; i < met.ip.size(); i++)
                                    {
                                        System.out.println("hocteto " + (i+1) + ": " + met.ip.get(i));
                                    }

                                }
                                else
                                {
                                    ventanaDialogo("4");
                                }
                            }
                            else
                            {
                                ventanaDialogo("3");
                            }
                        }
                        else
                        {
                            ventanaDialogo("2");
                        }

                    }
                    else
                    {
                        ventanaDialogo("1");
                    }

                }

                break;
        }



    }

    public void ventanaDialogo(String numHoc)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("Valor del Hocteto " + numHoc + " no valido\nIngresa valores\nmayor a -1 y menor a 256");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //et.setText(null);
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

}
