package com.LaboratuvarTestSonuclari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.LaboratuvarTestSonuclari.Hasta.hastalar;


public class Kayit extends JFrame {

    private JPanel wrapper;
    private JComboBox cmbox_kulanici;
    private JLabel lbl_kayit_ol;
    private JLabel lbl_kullaniciTip;
    private JPanel hastaKayit;
    private JPanel doktorKayit;
    private JPanel laborantKayit;
    private JPasswordField field_kimlik;
    private JLabel lbl_kimlikNo;
    private JTextField field_isim;
    private JTextField field_soyisim;
    private JTextField field_yas;
    private JTextField field_sifre;
    private JLabel lbl_isim;
    private JLabel lbl_soyisim;
    private JLabel lbl_Yas;
    private JLabel lbl_sifre;
    private JPanel pnl_secim;
    private JButton btn_kayitol;
    private JTextField field_doktor_isim;
    private JTextField field_doktor_soyisim;
    private JTextField field_doktor_bolum;
    private JTextField field_doktor_sifre;
    private JLabel lbl_doktor_isim;
    private JLabel lbl_doktor_soyisim;
    private JLabel lbl_Bolum;
    private JLabel lbl_doktor_sifre;
    private JButton btn_doktor_kayitol;
    private JTextField field_lab_isim;
    private JTextField field_lab_soyisim;
    private JTextField field_lab_sifre;
    private JButton btn_lab_kaydol;
    private JLabel lbl_lab_isim;
    private JLabel lbl_lab_soyisim;
    private JLabel lbl_lab_sifre;
    private JTextField field_doktor_tel;
    private JLabel lbl_doktor_tel;
    private JTextField field_hasta_tel;
    private JLabel lbl_hasta_tel;
    private JTextField field_lab_tel;
    private JLabel lbl_lab_telefon;
    private JTextField field_doktor_kimlik;
    private JLabel lbl_doktor_kimlik;
    private JTextField field_lab_kimlik;
    private JLabel lbl_lab_kimlik;
    private JComboBox comboBox_kullanici;


    static ArrayList<Doktor> doktorlar = new ArrayList<>();
    static ArrayList<Laborant> laborantlar = new ArrayList<>();

     // Kay??t ekran?? olu??turuldu
    public Kayit () {
        this.add(wrapper);
        this.lbl_kayit_ol = new JLabel("Kay??t Ol");
        this.lbl_kullaniciTip = new JLabel("Kullan??c?? Tipi");
        setSize(500, 500);
        setTitle("Kay??t Ekran??");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x,y);
        setVisible(true);

        // Kullan??c?? tipi se??imi i??in combobox olu??turuldu
        String[] kullanici = {" ","Hasta", "Doktor","Laborant"};
        comboBox_kullanici.setModel(new DefaultComboBoxModel(kullanici));
        System.out.println(comboBox_kullanici.getSelectedItem().toString());
        String secim = comboBox_kullanici.getSelectedItem().toString();
        System.out.println(secim);
        //kullan??c??ya g??re kay??t ekran?? de??i??iyor
        if(secim.equals(" "))
        {
            hastaKayit.setVisible(false);
            doktorKayit.setVisible(false);
            laborantKayit.setVisible(false);
            JOptionPane.showMessageDialog(null,"L??tfen Kullan??c?? Tipi Se??iniz");
        }
        //Kullan??caya g??re arraylistlere kullan??c??lar ekleniyor
        btn_kayitol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(ishataBul(Long.parseLong(field_kimlik.getText()),field_isim.getText(),field_soyisim.getText(),field_sifre.getText(),Integer.parseInt(field_hasta_tel.getText()))==true)
                {
                    JOptionPane.showMessageDialog(null,"Kay??t Ba??ar??s??z");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Kay??t Ba??ar??l??");
                    hastalar.add(new Hasta(Long.parseLong(field_kimlik.getText()),field_isim.getText(),field_soyisim.getText(),Integer.parseInt(field_yas.getText()),field_sifre.getText(),Integer.parseInt(field_hasta_tel.getText())));
                    kayitlananKullanicigoster(Long.parseLong(field_kimlik.getText()),field_isim.getText(),field_soyisim.getText(),Integer.parseInt(field_yas.getText()),field_sifre.getText(),Integer.parseInt(field_hasta_tel.getText()));
                    Giris giris = new Giris();
                }

            }
        });
        btn_doktor_kayitol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(ishataBul(Long.parseLong(field_doktor_kimlik.getText()),field_doktor_isim.getText(),field_doktor_soyisim.getText(),field_doktor_sifre.getText(),Integer.parseInt(field_doktor_tel.getText()))==true)
                {
                    JOptionPane.showMessageDialog(null,"Kay??t Ba??ar??s??z");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Kay??t Ba??ar??l??");
                    doktorlar.add(new Doktor(Long.parseLong(field_doktor_kimlik.getText()),field_doktor_isim.getText(), field_doktor_soyisim.getText(), field_doktor_bolum.getText(), field_doktor_sifre.getText(),Integer.parseInt(field_doktor_tel.getText())));
                    kayitlananKullanicigoster(Long.parseLong(field_doktor_kimlik.getText()),field_doktor_isim.getText(), field_doktor_soyisim.getText(), field_doktor_bolum.getText(), field_doktor_sifre.getText(),Integer.parseInt(field_doktor_tel.getText()));
                    Giris giris = new Giris();
                }
            }
        });
        btn_lab_kaydol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(ishataBul(Long.parseLong(field_lab_kimlik.getText()),field_lab_isim.getText(),field_lab_soyisim.getText(),field_lab_sifre.getText(),Integer.parseInt(field_lab_tel.getText()))==true)
                {
                    JOptionPane.showMessageDialog(null,"Kay??t Ba??ar??s??z");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Kay??t Ba??ar??l??");
                    laborantlar.add(new Laborant(Long.parseLong(field_lab_kimlik.getText()),field_lab_isim.getText(), field_lab_soyisim.getText(), field_lab_sifre.getText(),Integer.parseInt(field_lab_tel.getText())));
                    kayitlananKullanicigoster(Long.parseLong(field_lab_kimlik.getText()),field_lab_isim.getText(), field_lab_soyisim.getText(), field_lab_sifre.getText(),Integer.parseInt(field_lab_tel.getText()));
                    Giris giris = new Giris();
                }
            }
        });
        comboBox_kullanici.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(comboBox_kullanici.getSelectedItem().toString().equals("Hasta")){
                    hastaKayit.setVisible(true);
                    doktorKayit.setVisible(false);
                    laborantKayit.setVisible(false);

                }
                else if(comboBox_kullanici.getSelectedItem().toString().equals("Doktor")){
                    hastaKayit.setVisible(false);
                    doktorKayit.setVisible(true);
                    laborantKayit.setVisible(false);

                }
                else if(comboBox_kullanici.getSelectedItem().toString().equals("Laborant")){
                    hastaKayit.setVisible(false);
                    doktorKayit.setVisible(false);
                    laborantKayit.setVisible(true);
                }
            }
        });

    }
    public static void kayitlananKullanicigoster(long Tc,String isim, String soyisim,int yas, String sifre, int tel){
        System.out.println("Kay??t olan kullan??c??: " + Tc + " " + isim + " " + soyisim + " " +yas+" " +sifre + " " + tel);
    }
    public static void kayitlananKullanicigoster(long Tc,String isim, String soyisim, String bolum, String sifre, int tel){
        System.out.println("Kay??t olan kullan??c??: " + Tc + " " + isim + " " + soyisim + " " + bolum + " " + sifre + " " + tel);
    }
    public static void kayitlananKullanicigoster(long Tc,String isim, String soyisim, String sifre, int tel){
        System.out.println("Kay??t olan kullan??c??: " + Tc + " " + isim + " " + soyisim + " " + sifre + " " + tel);

    }
    //Kullan??c??lar kay??t olurken olabilcek baz?? hatalar??n kontrol?? yap??l??yor.
    public Boolean ishataBul(long tc,String isim,String soyisim,String sifre, int tel)
    {
        Boolean hata = false;
        try{
            if(tc == 0)
            {
                hata=true;
                throw new Exception("Kimlik numaras?? bo?? olamaz.");

            }
            else if(tc < 10000000000L || tc> 99999999999L )
            {
                hata=true;
                throw new Exception("Kimlik numaras?? 11 haneli olmal??d??r.");
            }
            else if(isim.equals(""))
            {
                hata = true;
                throw new Exception("??sim bo?? olamaz.");

            }
            else if(soyisim.equals(""))
            {
                hata = true;
                throw new Exception("Soyisim bo?? olamaz.");

            }
            else if(sifre.equals(""))
            {
                hata = true;
                throw new Exception("??ifre bo?? olamaz.");

            }
            else if(tel == 0)
            {
                hata = true;
                throw new Exception("Telefon numaras?? bo?? olamaz.");

            }
            else
            {
                hata = false;
            }

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());

        }
        return hata;

    }


}

