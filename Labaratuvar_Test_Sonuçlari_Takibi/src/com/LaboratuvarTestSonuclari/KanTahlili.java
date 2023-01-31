package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.Hasta;

import java.util.ArrayList;

public class KanTahlili extends Tahlil
{
    private  String [] Değerler = {"CRP","AlaninAminotransferaz","AspartatAminotransferaz","Glukoz","Kreatinin", "KreatininKinaz","KanGrubu","RhFaktoru"};
    private String [] DeğerlerSonuç = new String[8];
    private String [] DeğerlerReferans = {"0-5","0-35","0-40","74-106","0.5-0.9","0-170"," ",""};
    private String [] DeğerlerBirim = {"mg/L","U/L","U/L","mg/dL","mg/dL","U/L"," "," "};

    public static ArrayList<KanTahlili> kanTahlilleri = new ArrayList<KanTahlili>();

    public KanTahlili(String tahlilDurumu, String tahlilAdi, String tahlilTarihi, Hasta h, String tahlilDoktor, String tahlilLaborant){
        super(tahlilDurumu,tahlilAdi,  tahlilTarihi,h, tahlilDoktor, tahlilLaborant);
    }

    public String[] getDeğerlerSonuç() {
        return DeğerlerSonuç;
    }

    public Object setDeğerlerSonuç(String[] değerlerSonuç) {
        DeğerlerSonuç = değerlerSonuç;
        return null;
    }

    public String[] getDeğerler() {
        return Değerler;
    }

    public String[] getDeğerlerReferans() {
        return DeğerlerReferans;
    }

    public String[] getDeğerlerBirim() {
        return DeğerlerBirim;
    }
}
