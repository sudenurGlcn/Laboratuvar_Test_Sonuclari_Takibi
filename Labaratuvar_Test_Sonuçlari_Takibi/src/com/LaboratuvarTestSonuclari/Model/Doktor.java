package com.LaboratuvarTestSonuclari.Model;

import java.util.ArrayList;

public class Doktor extends Person
{
    private String bolum;
    public static ArrayList<Hasta> hastalar = Hasta.hastalar;
    public static ArrayList<Doktor> doktorlar = new ArrayList<>();

    public Doktor(long tc, String isim, String soyisim, String sifre, int telefon,String bolum)
    {
        super(tc, isim, soyisim, sifre, telefon);
        this.bolum=bolum;
    }

    public String getBolum() {
        return bolum;
    }
}
