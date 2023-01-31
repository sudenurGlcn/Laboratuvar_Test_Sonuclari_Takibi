package com.LaboratuvarTestSonuclari.Model;

public abstract class Person
{
    private long tc;
    private String isim,soyisim,sifre;
    private int telefon;

    public Person(long tc, String isim, String soyisim, String sifre, int telefon) {
        this.tc = tc;
        this.isim = isim;
        this.soyisim = soyisim;
        this.sifre = sifre;
        this.telefon = telefon;
    }

    public long getTc() {
        return tc;
    }

    public void setTc(long tc) {
        this.tc = tc;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }
}
