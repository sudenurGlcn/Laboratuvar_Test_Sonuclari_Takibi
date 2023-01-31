package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.*;

import javax.swing.*;
import java.awt.*;

public class Ayarlar extends JFrame {
    private JPanel wrapper;
    private JButton btn_kaydet;
    private JTextField fld_sifre;
    private JTextField fld_yenisifre;
    private JTextField fld_telefon;
    private JTextField fld_yenitelefon;

    public Ayarlar(Person p) throws HeadlessException {
        this.add(wrapper);
        setSize(400, 350);
        setTitle("Ayarlar Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x, y);
        setVisible(true);
        btn_kaydet.addActionListener(e ->
        {
            String yeni_sifre;
            int yeni_tel;
            if (fld_yenisifre.getText() != " ")
                yeni_sifre = fld_yenisifre.getText();
            else
                yeni_sifre = fld_sifre.getText();
            if (fld_yenitelefon.getText().equals(""))
                yeni_tel = p.getTelefon();
            else
                yeni_tel = Integer.parseInt(fld_yenitelefon.getText());

            String eski_sifre = fld_sifre.getText();
            System.out.println("Yeni şifre: " + yeni_sifre);
            System.out.println("Yeni tel: " + yeni_tel);
            System.out.println("Eski şifre: " + eski_sifre);
            if (p.getSifre().equals(eski_sifre)) {
                p.setSifre(yeni_sifre);
                if (fld_yenitelefon.getText() != "")
                    p.setTelefon(yeni_tel);
                JOptionPane.showMessageDialog(null, "Bilgileriniz güncellendi");
                dispose();
            } else
                JOptionPane.showMessageDialog(null, "Eski şifreniz yanlış!");
        });
    }
}
