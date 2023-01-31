package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.*;
import static com.LaboratuvarTestSonuclari.DoktorGUI.yasOrtalamaHesapla;

public class Main {
    public static void main(String[] args)
    {
        Hasta hasta1 = new Hasta(Long.parseLong("12345678910"), "Ahmet", "Yılmaz", "1234", 1234567891, 20);
        Hasta.hastalar.add(hasta1);
        Hasta hasta2 = new Hasta( 12346789, "Mehmet", "Yıl", "1", 12345, 10);
        Hasta.hastalar.add(hasta2);
        Hasta hasta3 = new Hasta( 1, "Ayşe", "Gümüş", "1", 12346, 25);
        Hasta.hastalar.add(hasta3);

        Doktor doktor1=new Doktor( 111,"Lale", "Ahmet", "1111", 1234567891, "Kardiyoloji");
        Doktor.doktorlar.add(doktor1);
        Doktor doktor2=new Doktor( 2,"Test", "Test2", "2", 1234567891, "Kardiyoloji");
        Doktor.doktorlar.add(doktor2);
        Doktor doktor3=new Doktor( 3,"Test", "Test3", "1111", 1234567891, "Kardiyoloji");
        Doktor.doktorlar.add(doktor3);

        Laborant laborant1=new Laborant( 4444,"Ali", "Fatma", "444", 1234567892);
        Laborant.laborantlar.add(laborant1);
        Laborant laborant2=new Laborant( 5555,"Veli", "Ayşe", "555", 1234598788);
        Laborant.laborantlar.add(laborant2);
        Laborant laborant3=new Laborant( 7777,"Mehmet", "Ali", "777", 1234954288);
        Laborant.laborantlar.add(laborant3);
        Laborant laborant4=new Laborant( 3,"Mehmet", "Ali", "3", 1234954288);
        Laborant.laborantlar.add(laborant4);

        System.out.println("Doktorların yaş ortalaması :\n ");
        yasOrtalamaHesapla();

        System.out.println("Hastalara ait bilgiler :\n ");
        for(int i = 0; i < Hasta.hastalar.size(); i++) {
            System.out.println("Hastanın Kimlik Numarası: "+Hasta.hastalar.get(i).getTc());
            System.out.println("Hastanın Adı: "+Hasta.hastalar.get(i).getIsim());
            System.out.println("Hastanın Soyadı:"+Hasta.hastalar.get(i).getSoyisim());
            System.out.println("Hastanın Yaşı:"+Hasta.hastalar.get(i).getYas());
            System.out.println("Hastanın Şifresi:"+Hasta.hastalar.get(i).getSifre());
            System.out.println("Hastanın Telefon Numarası: "+Hasta.hastalar.get(i).getTelefon());
            System.out.println("\n");
        }
        System.out.println("Doktorların bilgileri :\n ");
        for(int i = 0; i < Doktor.doktorlar.size(); i++) {
            System.out.println("Doktorun Kimlik Numarası: "+Doktor.doktorlar.get(i).getTc());
            System.out.println("Doktorun İsmi: "+Doktor.doktorlar.get(i).getIsim());
            System.out.println("Doktorun Soyismi: "+Doktor.doktorlar.get(i).getSoyisim());
            System.out.println("Doktorun Bölümü: "+Doktor.doktorlar.get(i).getBolum());
            System.out.println("Doktorun Şifresi: "+Doktor.doktorlar.get(i).getSifre());
            System.out.println("Doktorun Telefon Numarası: "+Doktor.doktorlar.get(i).getTelefon());
            System.out.println("\n");
        }
        System.out.println("Laborantların bilgileri :\n ");
        for(int i = 0; i < Laborant.laborantlar.size(); i++) {
            System.out.println("Laborantın Kimlik Numarası: "+Laborant.laborantlar.get(i).getTc());
            System.out.println("Laborantın İsmi: "+Laborant.laborantlar.get(i).getIsim());
            System.out.println("Laborantın Soyismi: "+Laborant.laborantlar.get(i).getSoyisim());
            System.out.println("Laborantın Şifresi: "+Laborant.laborantlar.get(i).getSifre());
            System.out.println("Laborantın Telefon Numarası: "+Laborant.laborantlar.get(i).getTelefon());
            System.out.println("\n");
        }
        Giris giris = new Giris();
    }
}
