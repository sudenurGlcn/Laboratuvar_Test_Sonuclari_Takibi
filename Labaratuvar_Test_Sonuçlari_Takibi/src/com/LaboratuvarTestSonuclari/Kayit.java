package com.LaboratuvarTestSonuclari;

import javax.swing.*;
import java.awt.*;

import com.LaboratuvarTestSonuclari.Model.*;


public class Kayit extends JFrame {

    private JPanel wrapper;
    private JTextField fld_tc;
    private JTextField fld_isim;
    private JTextField fld_soyisim;
    private JPasswordField fld_sifre;
    private JTextField fld_tel;
    private JTextField fld_bolum;
    private JComboBox cmb_kullanici;
    private JButton btn_kayit;
    private JTextField fld_yas;

    public Kayit () {
        this.add(wrapper);
        setSize(400, 400);
        setTitle("Kayıt Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x, y);
        setVisible(true);

        cmb_kullanici.addActionListener(e->
        {
            int v = cmb_kullanici.getSelectedIndex();

            if(v!=0)
                btn_kayit.setEnabled(true);
            else
                btn_kayit.setEnabled(false);

            if(v==1)
                fld_yas.setEnabled(true);
            else
            {
                fld_yas.setText(null);
                fld_yas.setEnabled(false);
            }

            if(v==2)
                fld_bolum.setEnabled(true);
            else
            {
                fld_bolum.setText(null);
                fld_bolum.setEnabled(false);
            }
        });

        btn_kayit.addActionListener(e ->
        {
            if (ishataBul(Long.parseLong(fld_tc.getText()), fld_isim.getText(), fld_soyisim.getText(), fld_sifre.getText(), Integer.parseInt(fld_tel.getText())))
            {
                JOptionPane.showMessageDialog(null, "Kayıt Başarısız");
            }
            else
            {
                Person p = null;
                switch(cmb_kullanici.getSelectedItem().toString())
                {
                    case "Hasta":
                        p = new Hasta(Long.parseLong(fld_tc.getText()),fld_isim.getText(),fld_soyisim.getText(),fld_sifre.getText(),Integer.parseInt(fld_tel.getText()),Integer.parseInt(fld_yas.getText()));
                        Hasta.hastalar.add((Hasta)p);
                        break;
                    case "Doktor":
                        p = new Doktor(Long.parseLong(fld_tc.getText()),fld_isim.getText(),fld_soyisim.getText(),fld_sifre.getText(),Integer.parseInt(fld_tel.getText()),fld_bolum.getText());
                        Doktor.doktorlar.add((Doktor)p);
                        break;
                    case "Laborant":
                        p = new Laborant(Long.parseLong(fld_tc.getText()),fld_isim.getText(),fld_soyisim.getText(),fld_sifre.getText(),Integer.parseInt(fld_tel.getText()));
                        Laborant.laborantlar.add((Laborant)p);
                        break;
                }
                JOptionPane.showMessageDialog(null, "Kayıt Başarılı");
                kayitlananKullanicigoster(p);
                Giris giris = new Giris();
                dispose();
            }
        });
    }

    public static void kayitlananKullanicigoster(Person p)
    {
        System.out.print("Kayıt olan kullanıcı: "
                + p.getTc() + " "
                + p.getIsim() + " "
                + p.getSoyisim() + " "
                + p.getSifre() + " "
                + p.getTelefon());
    }

    public boolean ishataBul(long tc,String isim,String soyisim,String sifre, int tel)
    {
        boolean hata = true;
        try{
            if(tc == 0)
                throw new Exception("Kimlik numarası boş olamaz.");
            else if(tc < 10000000000L || tc> 99999999999L )
                throw new Exception("Kimlik numarası 11 haneli olmalıdır.");
            else if(isim.equals(""))
                throw new Exception("İsim boş olamaz.");
            else if(soyisim.equals(""))
                throw new Exception("Soyisim boş olamaz.");
            else if(sifre.equals(""))
                throw new Exception("Şifre boş olamaz.");
            else if(tel == 0)
                throw new Exception("Telefon numarası boş olamaz.");
            else
                hata = false;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return hata;
    }
}

