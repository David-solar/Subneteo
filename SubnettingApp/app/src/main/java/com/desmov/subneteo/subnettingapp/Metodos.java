package com.desmov.subneteo.subnettingapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by david on 7/05/16.
 */
public class Metodos
{

    public static ArrayList<Integer> prefijos = new ArrayList<>();
    public static ArrayList<Integer> ip = new ArrayList<>();

    public static ArrayList<String> tablaSubneteo = new ArrayList<>();

    public static ArrayList<String> lineaPrefijo = new ArrayList<>();

    public int ipSig = 0;
    public int mascara = 0;

    int[] bin = {128, 64, 32, 16, 8, 4, 2, 1};

    public void ordenarPrefijos()
    {
        for(int i = 0; i < prefijos.size()-1; i++)
        {
            for(int j = 0; j < prefijos.size()-1-i; j++)
            {
                if(prefijos.get(j) > prefijos.get(j+1))
                {
                    int aux = prefijos.get(j);
                    prefijos.set(j,prefijos.get(j + 1));
                    prefijos.set((j+1),aux);

                }
            }
        }
    }


    public boolean validarPrefijo(int numero)
    {

        boolean band = false;

        if(validarNumero(numero))
        {
            if((numero > 0) && (numero < 33))
            {
                band = true;
            }
        }

        return band;

    }

    public boolean validarHocteto(int numero)
    {
        boolean band = false;

        if(validarNumero(numero))
        {
            if((numero > -1) && (numero < 256))
            {
                band = true;
            }
        }

        return band;
    }

    public boolean validarNumero(int numero)
    {
        String n = String.valueOf(numero);

        Pattern pat = Pattern.compile("[1-9]+");

        Matcher mat = pat.matcher(n);

        if (mat.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    public void calcularSubneteo()
    {

        for(int i = 0; i < prefijos.size(); i++)
        {

            int noHocteto = (prefijos.get(i)/8) + 1;

            if(i == 0)
            {
                String ipCompleta =  ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3);


                lineaPrefijo.add(prefijos.get(0).toString());
                lineaPrefijo.add(ipCompleta);
                lineaPrefijo.add( ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + (ip.get(3) + 1) );

                sumaHocteto(noHocteto, prefijos.get(0));

            }
        }
    }

    public void sumaHocteto(int noHocteto, int pref)
    {
        if(noHocteto == 1)
        {

        }
        else if(noHocteto == 2)
        {

        }
        else if(noHocteto == 3)
        {

        }
        else if(noHocteto == 4)
        {

            ipSig = calcularMascaraYAumento(ip.get(3), pref);
            String ipfinal = "";
            String breadcast = "";
            String masc = "";

            if(ipSig == 0)
            {

            }
            else
            {
                ipfinal = ip.get(0) + "." + ip.get(1) + "." + ip.get(3) + "." + (ipSig-2);
                breadcast = ip.get(0) + "." + ip.get(1) + "." + ip.get(3) + "." + (ipSig-1);
                masc = "255.255.255." + mascara;
            }




        }

    }


    public int calcularMascaraYAumento(int hoct, int pref)
    {
        mascara = 0;
        int j = 0;
        int no = 0;

        for(int i = 0; i < pref; i++, j++)
        {
            if( (j%8)==0 && j>0 )
            {
                j = 0;
                mascara = 0;
            }
            if(i == (pref-1) )
            {
                no = bin[j];
            }
            mascara = mascara + bin[j];

        }

        return (no + hoct);

    }


}