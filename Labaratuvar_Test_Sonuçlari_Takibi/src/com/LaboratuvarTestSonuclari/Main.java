package com.LaboratuvarTestSonuclari;

import java.util.ArrayList;

import static com.LaboratuvarTestSonuclari.Doktor.yasOrtalamaHesapla;
import static com.LaboratuvarTestSonuclari.Hasta.hastalar;
import static com.LaboratuvarTestSonuclari.Kayit.doktorlar;
import static com.LaboratuvarTestSonuclari.Kayit.laborantlar;

public class Main {
    public static void main(String[] args) {
        Hasta hasta1 = new Hasta(Long.parseLong("12345678910"), "Ahmet", "Yılmaz", 20, "1234", 1234567891);
        hastalar.add(hasta1);
        Hasta hasta2 = new Hasta( 12346789, "Mehmet", "Yıl", 10, "12345", 1234598712);
        hastalar.add(hasta2);
        Hasta hasta3 = new Hasta( 12347, "Ayşe", "Gümüş", 25, "12346", 1234954211);
        hastalar.add(hasta3);
        Doktor doktor1=new Doktor( 111,"Lale", "Ahmet", "Kardiyoloji", "1111", 1234567891);
        doktorlar.add(doktor1);
        Doktor doktor2=new Doktor( 2222,"Ayşe", "Mehmet", "Göz", "11111", 1234598711);
        doktorlar.add(doktor2);
        Doktor doktor3=new Doktor( 3333,"Fatma", "Ayşe", "Dahiliye", "111111", 1234954222);
        doktorlar.add(doktor3);
        Laborant laborant1=new Laborant( 4444,"Ali", "Fatma", "444", 1234567892);
        laborantlar.add(laborant1);
        Laborant laborant2=new Laborant( 5555,"Veli", "Ayşe", "555", 1234598788);
        laborantlar.add(laborant2);
        Laborant laborant3=new Laborant( 7777,"Mehmet", "Ali", "777", 1234954288);
        laborantlar.add(laborant3);

        System.out.println("Doktorların yaş ortalaması :\n ");
        yasOrtalamaHesapla();

        System.out.println("Hastalara ait bilgiler :\n ");
        for(int i = 0; i < hastalar.size(); i++) {
            System.out.println("Hastanın Kimlik Numarası: "+hastalar.get(i).getKimlikNo());
            System.out.println("Hastanın Adı: "+hastalar.get(i).getAd());
            System.out.println("Hastanın Soyadı:"+hastalar.get(i).getSoyad());
            System.out.println("Hastanın Yaşı:"+hastalar.get(i).getYas());
            System.out.println("Hastanın Şifresi:"+hastalar.get(i).getSifre());
            System.out.println("Hastanın Telefon Numarası: "+hastalar.get(i).getTelefon());
            System.out.println("\n");
        }
        System.out.println("Doktorların bilgileri :\n ");
        for(int i = 0; i < doktorlar.size(); i++) {
            System.out.println("Doktorun Kimlik Numarası: "+doktorlar.get(i).getKimlikNo());
            System.out.println("Doktorun İsmi: "+doktorlar.get(i).getIsim());
            System.out.println("Doktorun Soyismi: "+doktorlar.get(i).getSoyisim());
            System.out.println("Doktorun Bölümü: "+doktorlar.get(i).getBolum());
            System.out.println("Doktorun Şifresi: "+doktorlar.get(i).getSifre());
            System.out.println("Doktorun Telefon Numarası: "+doktorlar.get(i).getTelefon());
            System.out.println("\n");
        }
        System.out.println("Laborantların bilgileri :\n ");
        for(int i = 0; i < laborantlar.size(); i++) {
            System.out.println("Laborantın Kimlik Numarası: "+laborantlar.get(i).getKimlikNo());
            System.out.println("Laborantın İsmi: "+laborantlar.get(i).getIsim());
            System.out.println("Laborantın Soyismi: "+laborantlar.get(i).getSoyisim());
            System.out.println("Laborantın Şifresi: "+laborantlar.get(i).getSifre());
            System.out.println("Laborantın Telefon Numarası: "+laborantlar.get(i).getTelefon());
            System.out.println("\n");
        }
        Giris giris = new Giris();

    }
}
