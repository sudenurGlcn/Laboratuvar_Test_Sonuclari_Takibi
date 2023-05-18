package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.Hasta;

public class IdrarTahlili extends Tahlil {

    private String [] Değerler = {"Leukosit","Nitrit","Glukoz","Keton","Bilirubin","Urobilinogen","PH","Protein","Kan","KanHücreleri","EpitelHücreleri","Mikroorganizmalar"};
    private String [] DeğerlerSonuç = new String[12];
    private String [] DeğerlerReferans = {"0-5","Negatif","Negatif","Negatif","Negatif","Negatif","4.5-8.0","Negatif","Negatif","Negatif","Negatif","Negatif"};
    private String [] DeğerlerBirim = {"Leukosit","Nitrit","Glukoz","Keton","Bilirubin","Urobilinogen","PH","Protein","Kan","KanHücreleri","EpitelHücreleri","Mikroorganizmalar"};

    public IdrarTahlili(String tahlilDurumu, String tahlilAdi, String tahlilTarihi, Hasta h, String tahlilDoktor, String tahlilLaborant) {
        super(tahlilDurumu,tahlilAdi, tahlilTarihi, h, tahlilDoktor, tahlilLaborant);
    }

    public String[] getDeğerlerSonuç() {
        return DeğerlerSonuç;
    }

    public Object setDeğerlerSonuç(String[] değerlerSonuç)
    {
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
