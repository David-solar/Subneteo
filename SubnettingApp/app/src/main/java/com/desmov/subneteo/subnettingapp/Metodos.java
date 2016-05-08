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





}