package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.Doktor;
import com.LaboratuvarTestSonuclari.Model.Hasta;
import com.LaboratuvarTestSonuclari.Model.Laborant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class DoktorGUI extends JFrame
{
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
    private Doktor doktor;

    // Doktor ekranı açılıyor
    public DoktorGUI(Doktor doktor)
    {
        this.doktor=doktor;
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
                if (Hasta.hastalar.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Hasta Bulunamadı");
                } else {
                    Object[][] data = new Object[Hasta.hastalar.size()][5];
                    JPanel pnl_hasta_listele = new JPanel();
                    String[] columnNames = {"Kimlik No", "Ad", "Soyad", "Yaş", "Telefon"};
                    for (int i = 0; i < Hasta.hastalar.size(); i++) {
                        data[i][0] = Hasta.hastalar.get(i).getTc();
                        data[i][1] = Hasta.hastalar.get(i).getIsim();
                        data[i][2] = Hasta.hastalar.get(i).getSoyisim();
                        data[i][3] = Hasta.hastalar.get(i).getYas();
                        data[i][4] = Hasta.hastalar.get(i).getTelefon();
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
                Ayarlar ayarlar = new Ayarlar(doktor);

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
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(!pnl_tahlil_iste.isVisible())
                    pnl_tahlil_iste.setVisible(true);
                else
                    pnl_tahlil_iste.setVisible(false);
            }
        });

        // laborantın sayfasına tahlil düşürülüyor

        btn_gonder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                long TC = Long.parseLong(field_hasta_Tc.getText());
                String doktor = lbl_kullanici_isim.getText();
                String laborant = Laborant.laborantlar.get(0).getIsim();

                if (rdbtn_kan.isSelected() && rdbtn_idrar.isSelected())
                {
                    for (int i = 0; i < Hasta.hastalar.size(); i++) {
                        if (Hasta.hastalar.get(i).getTc() == TC) {
                            Hasta h = Hasta.hastalar.get(i);
                            KanTahlili kanTahlili = new KanTahlili("Bekliyor", "Kan Tahlili", "26.12.2022", h, doktor, laborant);
                            IdrarTahlili idrarTahlili = new IdrarTahlili("Bekliyor", "Idrar Tahlili", "26.12.2022", h, doktor, laborant);
                            Laborant.kantahliliSonuclari.add(kanTahlili);
                            Laborant.idrartahliliSonuclari.add(idrarTahlili);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Tahlil isteği gönderildi");
                }

                else if (rdbtn_kan.isSelected())
                {
                    for (int i = 0; i < Hasta.hastalar.size(); i++)
                    {
                        if (Hasta.hastalar.get(i).getTc() == TC)
                        {
                            Hasta h = Hasta.hastalar.get(i);
                            KanTahlili kanTahlili = new KanTahlili("Bekliyor", "Kan Tahlili", "26.12.2022", h, doktor, laborant);
                            Laborant.kantahliliSonuclari.add(kanTahlili);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Kan Tahlili istendi");
                }

                else if (rdbtn_idrar.isSelected())
                {
                    for (int i = 0; i < Hasta.hastalar.size(); i++)
                    {
                        if (Hasta.hastalar.get(i).getTc() == TC) {
                            String hastaAd = Hasta.hastalar.get(i).getIsim();
                            String hastaSoyad = Hasta.hastalar.get(i).getSoyisim();
                            Hasta h = Hasta.hastalar.get(i);
                            IdrarTahlili idrarTahlili = new IdrarTahlili("Bekliyor", "Idrar Tahlili", "26.12.2022", h, doktor, laborant);
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
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(!pnl_sonuc.isVisible())
                    pnl_sonuc.setVisible(true);
                else
                    pnl_sonuc.setVisible(false);
            }
        });

          // hastanın tahlil sonuçları listeleniyor
        btn_goruntule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                long tc = Long.parseLong(field_kimlik.getText());
                Hasta hasta = Hasta.getByTc(tc);
                System.out.println("Hastanın toplam kan tahlili : "+hasta.kanTahlili.size());
                System.out.println("Hastanın toplam idrar tahlili : "+hasta.idrarTahlili.size());
                if (hasta.kanTahlili.size() == 0 && hasta.idrarTahlili.size() == 0)
                    JOptionPane.showMessageDialog(null, "Hastaya ait tahlil sonucu yok");
                else
                {
                    hasta.getModelSonuclar();
                }
            }
        });
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
