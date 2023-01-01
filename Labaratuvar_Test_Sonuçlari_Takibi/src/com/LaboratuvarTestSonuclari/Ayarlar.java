package com.LaboratuvarTestSonuclari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ayarlar extends JFrame {

    private JPanel wrapper;
    private JPanel pnl_hasta_ayarlar;
    private JPanel pnl_doktor_ayarlar;
    private JPanel pnl_lab_ayarlar;
    private JLabel lbl_degistirmek;
    private JLabel lbl_sifre_degistir_dok;
    private JLabel lbl_tel_degistir;
    private JTextField field_yeni_sifre;
    private JTextField field_yeni_tel;
    private JButton btn_doktor_kaydet;
    private JTextField field_hasta_yeni_sifre;
    private JTextField field_hasta_yeni_tel;
    private JLabel lbl_hasta_sifre_degistir;
    private JLabel lbl_hasta_tel_degistir;
    private JLabel lbl_hasta_ayarlar;
    private JButton btn_hasta_kaydet;
    private JButton btn_lab_kaydet;
    private JTextField field_lab_yeni_sifre;
    private JTextField field_lab_yeni_tel;
    private JLabel lbl_Lab_ayarlar;
    private JLabel lbl_lab_sifre_degistir;
    private JLabel lbl_lab_tel_degisitir;
    private JTextField field_hasta_eskisifre;
    private JLabel lbl_hasta_eskisifre;
    private JTextField field_lab_eski_sifre;
    private JLabel lbl_lab_eskisifre;
    private JLabel lbl_dok_eskisifre;
    private JTextField field_eskisifre;
    private JTextField field_lab_tel;
    private JLabel lbl_lab_tel;
    private JTextField field_hasta_tel;
    private JLabel lbl_hasta_tel;
    private JTextField field_doktor_tel;
    private JLabel lbl_doktor_tel;

    //Ayarlar ekranı oluşturuldu
    public Ayarlar() throws HeadlessException {
        this.add(wrapper);
        setSize(500, 500);
        setTitle("Ayarlar Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x,y);
        setVisible(true);
        System.out.println("Ayarlar ekranı açıldı");
        if(Doktor.btn_ayarlar1){
            System.out.println("Doktor Ayarlar");
            pnl_doktor_ayarlar.setVisible(true);
            pnl_hasta_ayarlar.setVisible(false);
            pnl_lab_ayarlar.setVisible(false);
        }
        else if (Hasta.btn_ayarlar){
            System.out.println("Hasta Ayarlar");
            pnl_doktor_ayarlar.setVisible(false);
            pnl_hasta_ayarlar.setVisible(true);
            pnl_lab_ayarlar.setVisible(false);
        }
        else if(Laborant.btn_ayarlar2){
            System.out.println("Lab Ayarlar");
            pnl_doktor_ayarlar.setVisible(false);
            pnl_hasta_ayarlar.setVisible(false);
            pnl_lab_ayarlar.setVisible(true);
        }
        else{
            System.out.println("Ayarlar ekranı açılamadı");
        }

       //Doktorun yaptığı değişiiklikleri kaydetme
        btn_doktor_kaydet.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent actionEvent) {
                String yeni_sifre ;
                int yeni_tel;
                if(field_yeni_sifre.getText()!=" ")
                {
                     yeni_sifre = field_yeni_sifre.getText();
                }
                else{
                    yeni_sifre =field_eskisifre.getText();
                }
                if(field_yeni_tel.getText().equals("")){
                    yeni_tel = Integer.parseInt(field_doktor_tel.getText());
                }
                else{
                    yeni_tel = Integer.parseInt(field_yeni_tel.getText());
                }
                String eski_sifre = field_eskisifre.getText();
                System.out.println("Yeni şifre: " + yeni_sifre);
                System.out.println("Yeni tel: " + yeni_tel);
                System.out.println("Eski şifre: " + eski_sifre);
                for (int i = 0; i < Kayit.doktorlar.size(); i++) {
                    if (Kayit.doktorlar.get(i).getSifre().equals(eski_sifre)){
                        Kayit.doktorlar.get(i).setSifre(yeni_sifre);
                        if(field_yeni_tel.getText()!=""){
                            Kayit.doktorlar.get(i).setTelefon(yeni_tel);
                        }
                        else{
                            continue;
                        }
                        System.out.println("Doktor bilgileri güncellendi");
                        JOptionPane.showMessageDialog(null, "Bilgileriniz güncellendi");
                        break;
                    }
                    else{
                        System.out.println("Eski şifre yanlış");
                        JOptionPane.showMessageDialog(null, "Eski şifreniz yanlış");
                    }
                }
            }
        });
        //Hastanın yaptığı değişiklikleri kaydetme
        btn_hasta_kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String yeni_sifre ;
                int yeni_tel;
                try {
                    if(field_hasta_yeni_sifre.getText()!=" ")
                    {
                        yeni_sifre = field_hasta_yeni_sifre.getText();
                    }
                    else{
                        yeni_sifre =field_hasta_eskisifre.getText();
                    }
                    if(field_hasta_yeni_tel.getText().equals("")){
                        yeni_tel = Integer.parseInt(field_hasta_tel.getText());
                    }
                    else{
                        yeni_tel = Integer.parseInt(field_hasta_yeni_tel.getText());
                    }
                    String eski_sifre = field_hasta_eskisifre.getText();
                    System.out.println("Yeni şifre: " + yeni_sifre);
                    System.out.println("Yeni tel: " + yeni_tel);
                    System.out.println("Eski şifre: " + eski_sifre);
                    for (int i = 0; i < Hasta.hastalar.size(); i++) {
                        if (Hasta.hastalar.get(i).getSifre().equals(eski_sifre)){
                            Hasta.hastalar.get(i).setSifre(yeni_sifre);
                            Hasta.hastalar.get(i).setTelefon(yeni_tel);
                            System.out.println("Hasta bilgileri güncellendi");
                            JOptionPane.showMessageDialog(null, "Bilgileriniz güncellendi");
                            break;
                        }
                        else{
                            System.out.println("Eski şifre yanlış");
                            JOptionPane.showMessageDialog(null, "Eski şifreniz yanlış");
                        }
                    }
                }catch (Exception e){
                    System.out.println("Hata: " + e);
                }
                finally {
                    if(field_hasta_yeni_sifre.getText().equals("") && field_hasta_yeni_tel.getText()!=""){
                        yeni_sifre =field_hasta_eskisifre.getText();
                        yeni_tel = Integer.parseInt(field_hasta_yeni_tel.getText());
                        String eski_sifre = field_hasta_eskisifre.getText();
                        System.out.println("Yeni şifre: " + yeni_sifre);
                        System.out.println("Yeni tel: " + yeni_tel);
                        System.out.println("Eski şifre: " + eski_sifre);
                        for (int i = 0; i < Hasta.hastalar.size(); i++) {
                            if (Hasta.hastalar.get(i).getSifre().equals(eski_sifre)){
                                Hasta.hastalar.get(i).setSifre(yeni_sifre);
                                Hasta.hastalar.get(i).setTelefon(yeni_tel);
                                System.out.println("Hasta bilgileri güncellendi");
                                JOptionPane.showMessageDialog(null, "Bilgileriniz güncellendi");
                                break;
                            }
                            else{
                                System.out.println("Eski şifre yanlış");
                                JOptionPane.showMessageDialog(null, "Eski şifreniz yanlış");
                            }
                        }
                    }
                    else if(field_hasta_yeni_tel.getText().equals("") && field_hasta_yeni_sifre.getText()!=""){
                        yeni_sifre =field_hasta_yeni_sifre.getText();
                        yeni_tel = Integer.parseInt(field_hasta_tel.getText());
                        String eski_sifre = field_hasta_eskisifre.getText();
                        System.out.println("Yeni şifre: " + yeni_sifre);
                        System.out.println("Yeni tel: " + yeni_tel);
                        System.out.println("Eski şifre: " + eski_sifre);
                        for (int i = 0; i < Hasta.hastalar.size(); i++) {
                            if (Hasta.hastalar.get(i).getSifre().equals(eski_sifre)){
                                Hasta.hastalar.get(i).setSifre(yeni_sifre);
                                Hasta.hastalar.get(i).setTelefon(yeni_tel);
                                System.out.println("Hasta bilgileri güncellendi");
                                JOptionPane.showMessageDialog(null, "Bilgileriniz güncellendi");
                                break;
                            }
                            else{
                                System.out.println("Eski şifre yanlış");
                                JOptionPane.showMessageDialog(null, "Eski şifreniz yanlış");
                            }
                        }

                    }

                    System.out.println("Hasta bilgileri güncellendi");
                    JOptionPane.showMessageDialog(null, "Bilgileriniz güncellendi");
                }

            }
        });
        //Laborantın yaptığı değişiklikleri kaydetme
        btn_lab_kaydet.addActionListener(new ActionListener() {
            String yeni_sifre ;
            int yeni_tel;
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(field_lab_yeni_sifre.getText()!=" ")
                {
                    yeni_sifre = field_lab_yeni_sifre.getText();
                }
                else{
                    yeni_sifre =field_lab_eski_sifre.getText();
                }

                if(field_lab_yeni_tel.getText().equals("")){
                    yeni_tel = Integer.parseInt(field_lab_tel.getText());
                }
                else{
                    yeni_tel = Integer.parseInt(field_lab_yeni_tel.getText());
                }
                String eski_sifre = field_lab_eski_sifre.getText();
                System.out.println("Yeni şifre: " + yeni_sifre);
                System.out.println("Yeni tel: " + yeni_tel);
                System.out.println("Eski şifre: " + eski_sifre);
                for (int i = 0; i < Kayit.laborantlar.size(); i++) {
                    if (Kayit.laborantlar.get(i).getSifre().equals(eski_sifre)){
                        Kayit.laborantlar.get(i).setSifre(yeni_sifre);
                        Kayit.laborantlar.get(i).setTelefon(yeni_tel);
                        System.out.println("Laborant bilgileri güncellendi");
                        JOptionPane.showMessageDialog(null, "Bilgileriniz güncellendi");
                        break;
                    }
                    else{
                        System.out.println("Eski şifre yanlış");
                        JOptionPane.showMessageDialog(null, "Eski şifreniz yanlış");
                    }

                }

            }
        });
    }

    public JPanel getPnl_hasta_ayarlar() {
        return pnl_hasta_ayarlar;
    }

    public void setPnl_hasta_ayarlar(JPanel pnl_hasta_ayarlar) {
        this.pnl_hasta_ayarlar = pnl_hasta_ayarlar;
    }

    public JPanel getPnl_doktor_ayarlar() {
        System.out.println("getPnl_doktor_ayarlar");
        return pnl_doktor_ayarlar;
    }

    public void setPnl_doktor_ayarlar(JPanel pnl_doktor_ayarlar) {
        this.pnl_doktor_ayarlar = pnl_doktor_ayarlar;
    }

    public JPanel getPnl_lab_ayarlar() {
        return pnl_lab_ayarlar;
    }

    public void setPnl_lab_ayarlar(JPanel pnl_lab_ayarlar) {
        this.pnl_lab_ayarlar = pnl_lab_ayarlar;
    }
}
