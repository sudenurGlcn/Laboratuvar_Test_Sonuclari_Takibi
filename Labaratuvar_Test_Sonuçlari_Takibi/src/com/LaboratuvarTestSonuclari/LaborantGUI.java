package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LaborantGUI extends JFrame {
    private JPanel wrapper;
    private JLabel lbl_tahlil;
    private JTable tbl_bekleyen_tahlil;
    private JPanel pnl_lab1;
    private JPanel pnl_tahliller;
    protected JLabel lbl_hosgeldin;
    private JButton btn_bekleyen_tahliller;
    private JButton btn_ayarlar;
    private JButton btn_cikis;
    private JButton btn_tahlildoldur;
    private JPanel pnl_tahlildoldur;
    private JLabel lbl_hasta_Tc;
    private JTextField field_hasta_TC;
    private JLabel lbl_tahlil_tipi;
    private JComboBox cmbo_box_tip;
    private JButton btn_Doldur;
    private Laborant laborant;

    public LaborantGUI(Laborant laborant) {
        this.laborant=laborant;
        this.wrapper = wrapper;
        this.lbl_tahlil = new JLabel("Bekleyen Tahliller");
        this.tbl_bekleyen_tahlil = new JTable();
        this.add(wrapper);
        setSize(500, 500);
        setTitle("Laborant Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x,y);
        setVisible(true);

        btn_ayarlar.addActionListener(actionEvent -> {
            Ayarlar ayarlar = new Ayarlar(laborant);
        });

        btn_cikis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Giris giris = new Giris();
                dispose();
            }
        });

        //Laborantın bekleyen tahlilleri gördüğü tablo oluşturuluyor.
        btn_bekleyen_tahliller.addActionListener(new ActionListener()
        {
            int counter1 = 0;
            int counter2=0;
            int c=0;
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(KanTahlili kantahliliSonuclari: Laborant.kantahliliSonuclari){
                    if(kantahliliSonuclari.getTahlilDurumu().equals("Tamamlandı"))
                    {
                        counter1++;
                    }
                }
                for(IdrarTahlili idrartahliliSonuclari: Laborant.idrartahliliSonuclari){
                    if(idrartahliliSonuclari.getTahlilDurumu().equals("Tamamlandı"))
                    {
                        counter2++;
                    }
                }
                c=counter2+counter1;
                if(c==(Laborant.kantahliliSonuclari.size()+(Laborant.idrartahliliSonuclari.size())))
                {
                    JOptionPane.showMessageDialog(null,"Bekleyen Tahlil Yok");
                }
                else
                {
                    String[] columnNames = {"Tahlil Tipi", "Tahlil Tarihi", "Hasta Adı", "Doktor Adı", "Laborant Adı"};
                    Object[][] data = new Object[100][5];
                    int i = 0;
                    for(KanTahlili kantahliliSonuclari: Laborant.kantahliliSonuclari){
                        if(kantahliliSonuclari.getTahlilDurumu().equals("Bekliyor")){
                            data[i][0] = kantahliliSonuclari.getTahlilAdi();
                            data[i][1] = kantahliliSonuclari.getTahlilTarihi();
                            data[i][2] = kantahliliSonuclari.getTahlilHasta().getIsim()+" "+kantahliliSonuclari.getTahlilHasta().getSoyisim();
                            data[i][3] = kantahliliSonuclari.getTahlilDoktor();
                            data[i][4] = kantahliliSonuclari.getTahlilLaborant();
                            i++;
                        }
                    }
                    for(IdrarTahlili idrartahliliSonuclari: Laborant.idrartahliliSonuclari){
                        if(idrartahliliSonuclari.getTahlilDurumu().equals("Bekliyor")){
                            data[i][0] = idrartahliliSonuclari.getTahlilAdi();
                            data[i][1] = idrartahliliSonuclari.getTahlilTarihi();
                            data[i][2] = idrartahliliSonuclari.getTahlilHasta().getIsim()+" "+idrartahliliSonuclari.getTahlilHasta().getSoyisim();
                            data[i][3] = idrartahliliSonuclari.getTahlilDoktor();
                            data[i][4] = idrartahliliSonuclari.getTahlilLaborant();
                            i++;
                        }
                    }
                    JPanel pnl_bekleyen_tahliller = new JPanel();
                    JTable table_bekleyen_tahliller = new JTable(data, columnNames);
                    JScrollPane scr_pnl_tablo = new JScrollPane(table_bekleyen_tahliller);
                    scr_pnl_tablo.setPreferredSize(new Dimension(400, 200));
                    pnl_bekleyen_tahliller.add(scr_pnl_tablo);
                    JOptionPane.showMessageDialog(null, pnl_bekleyen_tahliller, "Bekleyen Tahliller", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        //Laborantın tahlil doldurması için gerekli olan alanlar açılıyor sayfada.
        btn_tahlildoldur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(!pnl_tahlildoldur.isVisible())
                {
                    pnl_tahlildoldur.setVisible(true);
                    String[] tahlilTipi1 = {" ", "Kan Tahlili", "Idrar Tahlili"};
                    cmbo_box_tip.setModel(new DefaultComboBoxModel(tahlilTipi1));
                }
                else
                    pnl_tahlildoldur.setVisible(false);
            }
        });

        btn_Doldur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                long kimlikNo = Long.parseLong(field_hasta_TC.getText());
                ArrayList<KanTahlili> yapilankantahlilleri = new ArrayList<>();
                ArrayList<IdrarTahlili> yapilanidrartahlilleri = new ArrayList<>();
                for (KanTahlili kantahliliSonuclari : Laborant.kantahliliSonuclari)
                {
                    if (kantahliliSonuclari.getTahlilHasta().getTc() == kimlikNo)
                    {
                            kantahliliSonuclari.setTahlilDurumu("Tamamlandı");
                            kantahliliSonuclari.getTahlilHasta().kanTahlili.add(kantahliliSonuclari);
                            System.out.println("Kan eklendi");
                            yapilankantahlilleri.add(kantahliliSonuclari);
                    }
                }
                for(IdrarTahlili idrartahliliSonuclari: Laborant.idrartahliliSonuclari)
                {
                    if(idrartahliliSonuclari.getTahlilHasta().getTc()==kimlikNo)
                    {
                        idrartahliliSonuclari.setTahlilDurumu("Tamamlandı");
                        idrartahliliSonuclari.getTahlilHasta().idrarTahlili.add(idrartahliliSonuclari);
                        System.out.println("İdrar eklendi");
                        yapilanidrartahlilleri.add(idrartahliliSonuclari);
                    }
                }
                for (KanTahlili kantahliliSonuclari : yapilankantahlilleri)
                {
                    Laborant.kantahliliSonuclari.remove(kantahliliSonuclari);
                }
                for(IdrarTahlili idrartahliliSonuclari: yapilanidrartahlilleri)
                {
                    Laborant.idrartahliliSonuclari.remove(idrartahliliSonuclari);
                }
            }
        });

        //Laborantın doldurduğu değerler arraylistlere ekleniyor.
        cmbo_box_tip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] değerler = new String[8];
                String[] değerler2 = new String[12];
                String tahlilTipi = cmbo_box_tip.getSelectedItem().toString();
                if(tahlilTipi.equals("Kan Tahlili")){
                    for (KanTahlili kantahliliSonuclari : Laborant.kantahliliSonuclari) {
                        for(int k=0;k<8;k++)
                        {
                            değerler[k]=JOptionPane.showInputDialog("Lütfen"+kantahliliSonuclari.getTahlilAdi()+" için "+kantahliliSonuclari.getDeğerler()[k]+" değerini giriniz");
                        }
                        for (int j=0;j<8;j++){
                            kantahliliSonuclari.setDeğerlerSonuç(değerler);
                        }
                    }
                    /*for(KanTahlili k1: Laborant.kantahliliSonuclari)
                    {
                        for(int k=0;k<8;k++)
                        {
                            k1.setDeğerlerSonuç(değerler);
                        }
                    }*/
                }

                else if(tahlilTipi.equals("Idrar Tahlili")){
                    for (IdrarTahlili idrartahliliSonuclari : Laborant.idrartahliliSonuclari) {
                        for(int k=0;k<12;k++)
                        {
                            değerler2[k]=JOptionPane.showInputDialog("Lütfen "+idrartahliliSonuclari.getTahlilAdi()+" için "+idrartahliliSonuclari.getDeğerler()[k]+" değerini giriniz");
                        }
                        for (int j=0;j<12;j++){
                            idrartahliliSonuclari.setDeğerlerSonuç(değerler2);
                        }
                    }
                    for(IdrarTahlili i1: Laborant.idrartahliliSonuclari)
                    {
                        for(int k=0;k<12;k++)
                        {
                            i1.setDeğerlerSonuç(değerler2);
                        }
                    }
                }
            }
        });
    }
}
