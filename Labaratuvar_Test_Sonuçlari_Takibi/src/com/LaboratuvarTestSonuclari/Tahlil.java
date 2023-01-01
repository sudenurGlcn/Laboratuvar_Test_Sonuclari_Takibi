package com.LaboratuvarTestSonuclari;

public abstract class Tahlil {
    private String tahlilDurumu;
    private String tahlilAdi;
    private String tahlilTarihi;
     private long tahlilHasta;
    private String tahlilDoktor;
    private String tahlilLaborant;

    public Tahlil(String tahlilDurumu,String tahlilAdi,  String tahlilTarihi,long tahlilHasta, String tahlilDoktor, String tahlilLaborant) {
        this.tahlilDurumu = tahlilDurumu;
        this.tahlilAdi = tahlilAdi;
        this.tahlilTarihi = tahlilTarihi;
        this.tahlilHasta = tahlilHasta;
        this.tahlilDoktor = tahlilDoktor;
        this.tahlilLaborant = tahlilLaborant;
    }

    public String getTahlilAdi() {
        return tahlilAdi;
    }

    public void setTahlilAdi(String tahlilAdi) {
        this.tahlilAdi = tahlilAdi;
    }


    public String getTahlilTarihi() {
        return tahlilTarihi;
    }

    public void setTahlilTarihi(String tahlilTarihi) {
        this.tahlilTarihi = tahlilTarihi;
    }

    public long getTahlilHasta() {
        return tahlilHasta;
    }

    public void setTahlilHasta(int tahlilHasta) {
        this.tahlilHasta = tahlilHasta;
    }


    public String getTahlilDoktor() {
        return tahlilDoktor;
    }

    public void setTahlilDoktor(String tahlilDoktor) {
        this.tahlilDoktor = tahlilDoktor;
    }

    public String getTahlilLaborant() {
        return tahlilLaborant;

    }
    public void setTahlilLaborant(String tahlilLaborant) {
        this.tahlilLaborant = tahlilLaborant;
    }

    public String getTahlilDurumu() {
        return tahlilDurumu;
    }

    public void setTahlilDurumu(String tahlilDurumu) {
        this.tahlilDurumu = tahlilDurumu;
    }


}
