package com.LaboratuvarTestSonuclari;

import javax.management.ObjectName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Hasta extends JFrame {

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
    private JButton btn_ayarlqar;
    private JButton btn_cikis;
    private JButton btn_kayit_sil;
    private JPanel pnl_tahlil_sonuclari;

    public static boolean btn_ayarlar=false;
    private long KimlikNo;
    private String Ad;
    private String Soyad;
    private int Yas;
    private String Sifre;

    private int telefon;

      static ArrayList<Hasta> hastalar = new ArrayList<Hasta>();
      static ArrayList<KanTahlili>kanTahlili = new ArrayList<KanTahlili>();
      static ArrayList<IdrarTahlili>idrarTahlili = new ArrayList<IdrarTahlili>();

    // Hasta giriş ekranı oluşturuldu
    public Hasta() throws HeadlessException {
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
        btn_ayarlqar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn_ayarlar=true;
                Ayarlar ayarlar = new Ayarlar();

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

                if(hastalar.size() == 0){
                    JOptionPane.showMessageDialog(null, "Hasta Bulunamadı");
                }else{
                    System.out.println("Hasta Silme");
                    for (Hasta hasta : hastalar) {
                        String isim= hasta.getAd() + " " + hasta.getSoyad();
                        if(isim.equals(lbl_kullanici_isim.getText())){
                            if(JOptionPane.showConfirmDialog(null, "Kaydınızı Silmek İstediğinize Emin Misiniz ?") == 0){
                                hastalar.remove(hasta);
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
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(" Tahlil Sonuçları");
                if(Hasta.kanTahlili.size() == 0 && Hasta.idrarTahlili.size() == 0){
                    JOptionPane.showMessageDialog(null, "Tahlil Sonucu Bulunamadı");
                }
                else {
                    String[] columnNames = {"Değerler", "Sonuç", "Birim", "Referans", "Tahlil Tarihi"};

                    if(Hasta.kanTahlili.size() !=0 && Hasta.idrarTahlili.size()==0)
                    {

                        Object[][] data = new Object[100][5];
                        for (int i = 0; i < (Hasta.kanTahlili.size()); i++) {
                            for(KanTahlili kt: Hasta.kanTahlili){
                                for(int j=0; j<kt.getDeğerler().length;j++)
                                {
                                    data[j][0]=kt.getDeğerler()[j];
                                    data[j][1]=kt.getDeğerlerSonuç()[j];
                                    data[j][2]=kt.getDeğerlerBirim()[j];
                                    data[j][3]=kt.getDeğerlerReferans()[j];
                                    data[j][4]=kt.getTahlilTarihi();
                                }

                            }
                        }


                        for(int i=0; data.length>i; i++)
                        {
                            for (int j = 0; j < data[i].length; j++) {
                                System.out.println(data[i][j]);
                            }
                        }
                        JTable table = new JTable(data, columnNames);
                        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                        table.setFillsViewportHeight(true);
                        JScrollPane scrollPane = new JScrollPane(table);
                        JOptionPane.showMessageDialog(null, scrollPane);
                    }
                    else if(Hasta.idrarTahlili.size() !=0 && Hasta.kanTahlili.size()==0 )
                    {
                        for(IdrarTahlili idrartahliliSonuclari : Hasta.idrarTahlili){
                            System.out.println("Idrar Tahlili Sonuçları");
                            System.out.println("Kan Tahlili Sonuçları");
                            if(Hasta.idrarTahlili.size() == 0) {
                                JOptionPane.showMessageDialog(null, "Hasta Bulunamadı");
                            }
                            else {
                                Object[][] data = new Object[100][5];
                                for (int i = 0; i < (Hasta.idrarTahlili.size()); i++) {
                                    for(IdrarTahlili it: Hasta.idrarTahlili){
                                        for(int j=0; j<it.getDeğerler().length;j++)
                                        {
                                            data[j][0]=it.getDeğerler()[j];
                                            data[j][1]=it.getDeğerlerSonuç()[j];
                                            data[j][2]=it.getDeğerlerBirim()[j];
                                            data[j][3]=it.getDeğerlerReferans()[j];
                                            data[j][4]=it.getTahlilTarihi();
                                        }

                                    }
                                }
                                for(int i=0; data.length>i; i++)
                                {
                                    for (int j = 0; j < data[i].length; j++) {
                                        System.out.println(data[i][j]);
                                    }
                                }
                                JTable table = new JTable(data, columnNames);
                                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                                table.setFillsViewportHeight(true);
                                JScrollPane scrollPane = new JScrollPane(table);
                                JOptionPane.showMessageDialog(null, scrollPane);
                            }
                        }
                    }

                }
                /*
                hastaTahlilSonucuYazdir(kanTahlili);*/
            }
        });
    }
    //Hasta sınıfın constructor metodu
    public Hasta(long KimlikNo, String Ad, String Soyad, int Yas, String Sifre, int telefon) {
        this.KimlikNo = KimlikNo;
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.Yas = Yas;
        this.Sifre = Sifre;
        this.telefon = telefon;
    }

    public long getKimlikNo() {
        return KimlikNo;
    }

    public void setKimlikNo(long kimlikNo) {
        KimlikNo = kimlikNo;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String soyad) {
        Soyad = soyad;
    }

    public int getYas() {
        return Yas;
    }

    public void setYas(int yas) {
        Yas = yas;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    //Hasta tahlil sonuçlarını yazdıran metot
    /*
    public static void hastaTahlilSonucuYazdir(ArrayList<KanTahlili>kanTahlili){
        System.out.println(" Tahlil Sonuçları");
        if(Hasta.kanTahlili.size() == 0 && Hasta.idrarTahlili.size() == 0){
            JOptionPane.showMessageDialog(null, "Tahlil Sonucu Bulunamadı");
        }
        else {
            String[] columnNames = {"Değerler", "Sonuç", "Birim", "Referans", "Tahlil Tarihi"};

            if(Hasta.kanTahlili.size() !=0 && Hasta.idrarTahlili.size()==0)
            {

                Object[][] data = new Object[100][5];
                for (int i = 0; i < (Hasta.kanTahlili.size()); i++) {
                    for(KanTahlili kt: Hasta.kanTahlili){
                        for(int j=0; j<kt.getDeğerler().length;j++)
                        {
                            data[j][0]=kt.getDeğerler()[j];
                            data[j][1]=kt.getDeğerlerSonuç()[j];
                            data[j][2]=kt.getDeğerlerBirim()[j];
                            data[j][3]=kt.getDeğerlerReferans()[j];
                            data[j][4]=kt.getTahlilTarihi();
                        }

                    }
                }


                for(int i=0; data.length>i; i++)
                {
                    for (int j = 0; j < data[i].length; j++) {
                        System.out.println(data[i][j]);
                    }
                }
                JTable table = new JTable(data, columnNames);
                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                table.setFillsViewportHeight(true);
                JScrollPane scrollPane = new JScrollPane(table);
                JOptionPane.showMessageDialog(null, scrollPane);
            }
            else if(Hasta.idrarTahlili.size() !=0 && Hasta.kanTahlili.size()==0 )
            {
                for(IdrarTahlili idrartahliliSonuclari : Hasta.idrarTahlili){
                    System.out.println("Idrar Tahlili Sonuçları");
                    System.out.println("Kan Tahlili Sonuçları");
                    if(Hasta.idrarTahlili.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Hasta Bulunamadı");
                    }
                    else {
                        Object[][] data = new Object[100][5];
                        for (int i = 0; i < (Hasta.idrarTahlili.size()); i++) {
                            for(IdrarTahlili it: Hasta.idrarTahlili){
                                for(int j=0; j<it.getDeğerler().length;j++)
                                {
                                    data[j][0]=it.getDeğerler()[j];
                                    data[j][1]=it.getDeğerlerSonuç()[j];
                                    data[j][2]=it.getDeğerlerBirim()[j];
                                    data[j][3]=it.getDeğerlerReferans()[j];
                                    data[j][4]=it.getTahlilTarihi();
                                }

                            }
                        }
                        for(int i=0; data.length>i; i++)
                        {
                            for (int j = 0; j < data[i].length; j++) {
                                System.out.println(data[i][j]);
                            }
                        }
                        JTable table = new JTable(data, columnNames);
                        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                        table.setFillsViewportHeight(true);
                        JScrollPane scrollPane = new JScrollPane(table);
                        JOptionPane.showMessageDialog(null, scrollPane);
                    }
                }
            }

        }

    }*/
}
