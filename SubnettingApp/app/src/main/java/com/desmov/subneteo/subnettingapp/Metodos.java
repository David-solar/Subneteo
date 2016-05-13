package com.desmov.subneteo.subnettingapp;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by david on 7/05/16.
 */
public class Metodos
{

    public static ArrayList<Integer> prefijos = new ArrayList<>();
    public static ArrayList<Integer> ip = new ArrayList<>();

    public static ArrayList<String[]> tablaSubneteo = new ArrayList<>();

    //public static ArrayList<String> lineaPrefijo = new ArrayList<>();

    public static String[] lineaPrefijo = new String[6];


    public int cuartoH = -1;
    public static int ipSig = -1;
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

        String prefijo = null;
        String ipRed =  null;
        String ipInicial = null;

        for(int i = 0; i < prefijos.size(); i++)
        {

            int noHocteto = (prefijos.get(i)/8) + 1;

            if(i == 0)
            {
                prefijo = prefijos.get(i).toString();
                ipRed =  ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3);
                ipInicial = ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + (ip.get(3) + 1);

                lineaPrefijo[0] = prefijo;
                lineaPrefijo[1] = ipRed;
                lineaPrefijo[2] =ipInicial;

                sumaHocteto(noHocteto, prefijos.get(i));

            }
            else
            {
                if(ipSig == 0)
                {
                    prefijo = prefijos.get(i).toString();
                    ip.set(2, (ip.get(2)+1));
                    ip.set(3, 0);
                    ipRed =  ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3);
                    ipInicial = ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + (ip.get(3)+1);
                }
                else
                {
                    prefijo = prefijos.get(i).toString();
                    ip.set(3, ipSig);
                    ipRed =  ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + ip.get(3);
                    ipInicial = ip.get(0) + "." + ip.get(1) + "." + ip.get(2) + "." + (ip.get(3) + 1);
                }



                lineaPrefijo[0] = prefijo;
                lineaPrefijo[1] = ipRed;
                lineaPrefijo[2] =ipInicial;

                sumaHocteto(noHocteto, prefijos.get(i));
            }

            tablaSubneteo.add(lineaPrefijo);
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

            cuartoH = calcularMascaraEIpSIguiente(ip.get(3), pref);
            ipSig = cuartoH;

            String ipfinal = "";
            String breadcast = "";
            String masc = "";

            if(cuartoH == 0)
            {
                ipfinal = ip.get(0) + "." + ip.get(1) + "." + ip.get(3) + "." + 254;
                breadcast = ip.get(0) + "." + ip.get(1) + "." + ip.get(3) + "." + 255;
                masc = "255.255.255." + mascara;
            }
            else
            {
                ipfinal = ip.get(0) + "." + ip.get(1) + "." + ip.get(3) + "." + (cuartoH-2);
                breadcast = ip.get(0) + "." + ip.get(1) + "." + ip.get(3) + "." + (cuartoH-1);
                masc = "255.255.255." + mascara;
            }

            lineaPrefijo[3] = ipfinal;
            lineaPrefijo[4] = breadcast;
            lineaPrefijo[5] = masc;


        }

    }


    public int calcularMascaraEIpSIguiente(int hoct, int pref)
    {
        mascara = 0;
        int j = 0;
        int octeto = 0;

        for(int i = 0; i < pref; i++, j++)
        {
            if( (j%8)==0 && j>0 )
            {
                j = 0;
                mascara = 0;
            }
            if(i == (pref-1) )
            {
                octeto = bin[j] + hoct;


                if(octeto == 256)
                {
                    octeto = 0;
                }
            }
            mascara = mascara + bin[j];

        }

        return octeto;

    }


}