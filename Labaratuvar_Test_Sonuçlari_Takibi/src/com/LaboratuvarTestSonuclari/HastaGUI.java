package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.Hasta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HastaGUI extends JFrame
{
    private long KimlikNo;
    private String Ad;
    private String Soyad;
    private int Yas;
    private String Sifre;
    private int telefon;

    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_hasta;
    protected JLabel lbl_kullanici;
    private JLabel lbl_ad_soyad;
    protected JLabel lbl_kullanici_isim;
    private JLabel lbl_Yas;
    protected JLabel lbl_kullanici_Yas;
    private JButton btn_Sonuc;
    private JButton btn_ayarlar;
    private JButton btn_cikis;
    private JButton btn_kayit_sil;
    private JPanel pnl_tahlil_sonuclari;
    private Hasta hasta;


    public HastaGUI(Hasta hasta) throws HeadlessException
    {
        this.hasta=hasta;
        this.wrapper = wrapper;
        this.pnl_top = new JPanel();
        this.pnl_bottom = new JPanel();
        this.lbl_kullanici = new JLabel();
        lbl_kullanici.setText("Kullanıcı :");
        this.lbl_ad_soyad = new JLabel();
        lbl_ad_soyad.setText("Ad Soyad :");

        this.add(wrapper);
        setSize(500, 500);
        setTitle("Hasta Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x,y);
        setVisible(true);

        //Hastanın ayarlar sayfası
        btn_ayarlar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Ayarlar a = new Ayarlar(hasta);
            }
        });

        //Hasta çıkış yapar
        btn_cikis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Giris giris = new Giris();
                dispose();
            }
        });

        //Hastanın kayıt silme işlemi
        btn_kayit_sil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(Hasta.hastalar.size() == 0){
                    JOptionPane.showMessageDialog(null, "Hasta Bulunamadı");
                }else{
                    System.out.println("Hasta Silme");
                    for (Hasta hasta : Hasta.hastalar) {
                        String isim= hasta.getIsim() + " " + hasta.getSoyisim();
                        if(isim.equals(lbl_kullanici_isim.getText())){
                            if(JOptionPane.showConfirmDialog(null, "Kaydınızı Silmek İstediğinize Emin Misiniz ?") == 0){
                                Hasta.hastalar.remove(hasta);
                                JOptionPane.showMessageDialog(null, "Kaydınız Silindi");
                                dispose();
                                Giris giris = new Giris();
                                break;
                            }
                        }
                    }
                }
            }
        });
       //Hastanın tahlil sonuçlarını görebilmesi
        btn_Sonuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                System.out.println(" Tahlil Sonuçları");
                if(hasta.kanTahlili.size() == 0 && hasta.idrarTahlili.size() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Tahlil Sonucu Bulunamadı");
                }
                else
                {
                    hasta.getModelSonuclar();
                }
            }
        });
    }
}
