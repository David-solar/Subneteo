package com.desmov.subneteo.subnettingapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

/**
 * Created by david on 7/05/16.
 */
public class Metodos
{

    public static ArrayList<Integer> prefijos = new ArrayList<>();

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





}