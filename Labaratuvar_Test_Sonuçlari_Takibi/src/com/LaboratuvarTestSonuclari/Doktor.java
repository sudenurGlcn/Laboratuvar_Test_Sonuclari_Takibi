package com.LaboratuvarTestSonuclari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Doktor extends JFrame {
    public static boolean btn_ayarlar1 = false;
    private long kimlikNo;
    private String isim;
    private String soyisim;
    private String Bolum;
    private String sifre;
    private int telefon;


    ArrayList<Hasta> hastalar = Hasta.hastalar;

    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_kullanici;
    private JLabel lbl_giris;
    private JButton btn_Listele;
    private JButton btn_ayarlar;
    private JLabel lbl_isim;
    protected JLabel lbl_kullanici_isim;
    private JButton btn_cikis;
    private JPanel pnl_tablo_listele;
    private JButton sonuçlarButton;
    private JButton btn_tahlil_iste;
    private JPanel pnl_tahlil_iste;
    private JLabel lbl_hasta_TC;
    private JTextField field_hasta_Tc;
    private JLabel lbl_tahlil_tipi;
    private JRadioButton rdbtn_kan;
    private JRadioButton rdbtn_idrar;
    private JButton btn_gonder;
    private JPanel pnl_sonuc;
    private JLabel lbl_hasta_Tc;
    private JTextField field_kimlik;
    private JButton btn_goruntule;

    // Doktor ekranı açılıyor
    public Doktor() {

        //Doktor ekranı oluşturuldu
        this.wrapper = wrapper;
        JScrollPane scrollPane = new JScrollPane(wrapper);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        add(scrollPane);
        this.pnl_top = new JPanel();
        this.pnl_bottom = new JPanel();

        setSize(500, 500);
        setTitle("Doktor Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x, y);
        setVisible(true);

        // Hasta listeleme butonu
        btn_Listele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (hastalar.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Hasta Bulunamadı");
                } else {
                    Object[][] data = new Object[hastalar.size()][5];
                    JPanel pnl_hasta_listele = new JPanel();
                    String[] columnNames = {"Kimlik No", "Ad", "Soyad", "Yaş", "Telefon"};
                    for (int i = 0; i < hastalar.size(); i++) {
                        data[i][0] = hastalar.get(i).getKimlikNo();
                        data[i][1] = hastalar.get(i).getAd();
                        data[i][2] = hastalar.get(i).getSoyad();
                        data[i][3] = hastalar.get(i).getYas();
                        data[i][4] = hastalar.get(i).getTelefon();
                    }
                    JTable table_hasta_listele = new JTable(data, columnNames);
                    table_hasta_listele.setVisible(true);
                    JScrollPane scr_hasta_listele = new JScrollPane(table_hasta_listele);
                    scr_hasta_listele.setVisible(true);
                    pnl_hasta_listele.add(scr_hasta_listele);
                    pnl_hasta_listele.setVisible(true);
                    JOptionPane.showMessageDialog(null, pnl_hasta_listele);
                    System.out.println("Hasta Listeleme Butonuna Basıldı");
                    System.out.println("Hasta Listesi");
                    for (int i = 0; i < data.length; i++) {
                        for (int j = 0; j < data[i].length; j++) {
                            System.out.print(data[i][j] + " ");
                        }
                        System.out.println();
                    }

                }

            }
        });
        // Ayarlar butonuna tıklandığında ayarlar ekranı açılıyor

        btn_ayarlar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn_ayarlar1 = true;
                Ayarlar ayarlar = new Ayarlar();

            }
        });
        btn_cikis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Giris giris = new Giris();
                dispose();
            }
        });
        // Tahlil iste butonuna tıklandığında tahlil olusturuluyor
        btn_tahlil_iste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pnl_tahlil_iste.setVisible(true);
            }
        });
        // laborantın sayfasına tahlil düşürülüyor
        btn_gonder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                long hasta;
                long TC = Long.parseLong(field_hasta_Tc.getText());
                String doktor = lbl_kullanici_isim.getText();
                String laborant = Kayit.laborantlar.get(0).getIsim();

                //radio butondan seçilen tahlil tipine göre tahliller  oluşturuluyor
                if (rdbtn_kan.isSelected() && rdbtn_idrar.isSelected()) {
                    for (int i = 0; i < hastalar.size(); i++) {
                        if (hastalar.get(i).getKimlikNo() == TC) {
                            hasta = hastalar.get(i).getKimlikNo();
                            KanTahlili kanTahlili = new KanTahlili("Bekliyor", "Kan Tahlili", "26.12.2022", hasta, doktor, laborant);
                            IdrarTahlili idrarTahlili = new IdrarTahlili("Bekliyor", "Idrar Tahlili", "26.12.2022", hasta, doktor, laborant);
                            Hasta.kanTahlili.add(kanTahlili);
                            Hasta.idrarTahlili.add(idrarTahlili);
                            Laborant.kantahliliSonuclari.add(kanTahlili);
                            Laborant.idrartahliliSonuclari.add(idrarTahlili);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Tahlil isteği gönderildi");
                } else if (rdbtn_kan.isSelected()) {
                    for (int i = 0; i < hastalar.size(); i++) {
                        if (hastalar.get(i).getKimlikNo() == TC) {
                            String hastaAd = hastalar.get(i).getAd();
                            String hastaSoyad = hastalar.get(i).getSoyad();
                            hasta = hastalar.get(i).getKimlikNo();
                            KanTahlili kanTahlili = new KanTahlili("Bekliyor", "Kan Tahlili", "26.12.2022", hasta, doktor, laborant);
                            Hasta.kanTahlili.add(kanTahlili);
                            Laborant.kantahliliSonuclari.add(kanTahlili);
                        }

                    }
                    JOptionPane.showMessageDialog(null, "Kan Tahlili istendi");
                } else if (rdbtn_idrar.isSelected()) {
                    for (int i = 0; i < hastalar.size(); i++) {
                        if (hastalar.get(i).getKimlikNo() == TC) {
                            String hastaAd = hastalar.get(i).getAd();
                            String hastaSoyad = hastalar.get(i).getSoyad();
                            hasta = hastalar.get(i).getKimlikNo();
                            IdrarTahlili idrarTahlili = new IdrarTahlili("Bekliyor", "Idrar Tahlili", "26.12.2022", hasta, doktor, laborant);
                            Hasta.idrarTahlili.add(idrarTahlili);
                            Laborant.idrartahliliSonuclari.add(idrarTahlili);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Idrar Tahlili istendi");
                }

            }
        });
        // hastanın tahlil sonuçları için panel açılıyor.
        sonuçlarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pnl_sonuc.setVisible(true);
            }
        });

          // hastanın tahlil sonuçları listeleniyor
        btn_goruntule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                long kimlikNo = Long.parseLong(field_kimlik.getText());
                for (Hasta hasta1 : Hasta.hastalar) {
                    if (hasta1.getKimlikNo() == kimlikNo) {
                        if (Hasta.kanTahlili.size() == 0 && Hasta.idrarTahlili.size() == 0) {
                            JOptionPane.showMessageDialog(null, " Hastaya ait  tahlil sonucu yok");
                        } else if (Hasta.kanTahlili.size() != 0 && Hasta.idrarTahlili.size() != 0) {
                            String[] columnNames = {"Tahlil Adı", "islem Adı", "Sonuç", "Birim", "Referans Aralığı", "Tarih"};
                            String[][] data = new String[(Hasta.kanTahlili.size() * 8) + (Hasta.idrarTahlili.size() * 13)][6];
                            for (int i = 0; i < (Hasta.kanTahlili.size()); i++) {
                                for (KanTahlili kt1 : Hasta.kanTahlili) {
                                    for (int j = 0; j < 8; j++) {
                                        data[j][0] = Hasta.kanTahlili.get(i).getTahlilAdi();
                                        data[j][1] = Hasta.kanTahlili.get(i).getDeğerler()[j];
                                        data[j][2] = Hasta.kanTahlili.get(i).getDeğerlerSonuç()[j];
                                        data[j][3] = Hasta.kanTahlili.get(i).getDeğerlerBirim()[j];
                                        data[j][4] = Hasta.kanTahlili.get(i).getDeğerlerReferans()[j];
                                        data[j][5] = Hasta.kanTahlili.get(i).getTahlilTarihi();
                                    }
                                }
                            }
                            for (int i = (Hasta.kanTahlili.size() + 1); i < (Hasta.idrarTahlili.size()); i++) {
                                for (IdrarTahlili i1 : Hasta.idrarTahlili) {
                                    for (int j = 0; j < 13; j++) {
                                        data[j][0] = Hasta.idrarTahlili.get(j).getTahlilAdi();
                                        data[j][1] = Hasta.idrarTahlili.get(j).getDeğerler()[j];
                                        data[j][2] = Hasta.idrarTahlili.get(j).getDeğerlerSonuç()[j];
                                        data[j][3] = Hasta.idrarTahlili.get(j).getDeğerlerBirim()[j];
                                        data[j][4] = Hasta.idrarTahlili.get(j).getDeğerlerReferans()[j];
                                        data[j][5] = Hasta.idrarTahlili.get(j).getTahlilTarihi();
                                    }
                                }

                            }
                            JTable table = new JTable(data, columnNames);
                            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                            table.setFillsViewportHeight(true);
                            JScrollPane scrollPane = new JScrollPane(table);
                            JOptionPane.showMessageDialog(null, scrollPane);
                        } else if (Hasta.kanTahlili.size() != 0 && Hasta.idrarTahlili.size() == 0) {
                            String[] columnNames = {"Tahlil Adı", "islem Adı", "Sonuç", "Birim", "Referans Aralığı", "Tarih"};
                            String[][] data = new String[100][6];
                            for (int i = 0; i < (Hasta.kanTahlili.size()); i++) {
                                for (KanTahlili kt : Hasta.kanTahlili) {
                                    for (int j = 0; j < kt.getDeğerler().length; j++) {
                                        data[j][0] = kt.getDeğerler()[j];
                                        data[j][1] = kt.getDeğerlerSonuç()[j];
                                        data[j][2] = kt.getDeğerlerBirim()[j];
                                        data[j][3] = kt.getDeğerlerReferans()[j];
                                        data[j][4] = kt.getTahlilTarihi();
                                    }

                                }
                            }
                            JTable table = new JTable(data, columnNames);
                            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                            table.setFillsViewportHeight(true);
                            JScrollPane scrollPane = new JScrollPane(table);
                            JOptionPane.showMessageDialog(null, scrollPane);
                        } else {
                            String[] columnNames = {"Tahlil Adı", "islem Adı", "Sonuç", "Birim", "Referans Aralığı", "Tarih"};
                            String[][] data = new String[100][6];
                            for (int i = 0; i < (Hasta.idrarTahlili.size()); i++) {
                                for (IdrarTahlili i1 : Hasta.idrarTahlili) {
                                    for (int j = 0; j < i1.getDeğerler().length; j++) {
                                        data[j][0] = i1.getDeğerler()[j];
                                        data[j][1] = i1.getDeğerlerSonuç()[j];
                                        data[j][2] = i1.getDeğerlerBirim()[j];
                                        data[j][3] = i1.getDeğerlerReferans()[j];
                                        data[j][4] = i1.getTahlilTarihi();
                                    }

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
        });
    }

    //Doktor sayfasının constructor metodu
    public Doktor(long kimlikNo, String isim, String soyisim, String bolum, String sifre, int telefon) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.Bolum = bolum;
        this.sifre = sifre;
        this.telefon = telefon;
        this.kimlikNo = kimlikNo;
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

    public String getBolum() {
        return Bolum;
    }

    public void setBolum(String bolum) {
        Bolum = bolum;
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

    public long getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(long kimlikNo) {
        this.kimlikNo = kimlikNo;
    }


    //Hastaların yaş ortalaması bulunuyor.
    public static void yasOrtalamaHesapla() {
        float toplam = 0;
        for (int i = 0; i < Hasta.hastalar.size(); i++) {
            toplam += Hasta.hastalar.get(i).getYas();
        }
        float ortalama = toplam / Hasta.hastalar.size();
        System.out.println("Hastaların Ortalama Yaşı: " + ortalama);
    }


}
