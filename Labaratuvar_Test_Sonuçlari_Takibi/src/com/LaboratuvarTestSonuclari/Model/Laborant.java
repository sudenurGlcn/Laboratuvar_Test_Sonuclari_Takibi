package com.LaboratuvarTestSonuclari.Model;
import com.LaboratuvarTestSonuclari.*;

import java.util.ArrayList;

public class Laborant extends Person
{
    public static ArrayList<Laborant> laborantlar = new ArrayList<>();
    public static ArrayList<KanTahlili> kantahliliSonuclari = new ArrayList<>();
    public static ArrayList<IdrarTahlili> idrartahliliSonuclari = new ArrayList<>();

    public Laborant(long tc, String isim, String soyisim, String sifre, int telefon)
    {
        super(tc, isim, soyisim, sifre, telefon);
    }
}
