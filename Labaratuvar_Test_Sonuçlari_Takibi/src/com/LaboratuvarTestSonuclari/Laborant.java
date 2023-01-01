package com.LaboratuvarTestSonuclari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Laborant  extends JFrame {
    private long kimlikNo;
    private String isim;
    private String soyisim;
    private String sifre;

    private int telefon;
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

    public static boolean btn_ayarlar2=false;
    static ArrayList<KanTahlili> kantahliliSonuclari = new ArrayList<>();
    static ArrayList<IdrarTahlili> idrartahliliSonuclari = new ArrayList<>();

    public Laborant() {
        //Laborant giriş ekranı oluşturuldu
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

        //Laborantın ayarlar sayfası
        btn_ayarlar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn_ayarlar2=true;
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
        //Laborantın bekleyen tahlilleri gördüğü tablo oluşturuluyor.
        btn_bekleyen_tahliller.addActionListener(new ActionListener() {
            int counter1 = 0;
            int counter2=0;
            int c=0;
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(KanTahlili kantahliliSonuclari:Hasta.kanTahlili){
                    if(kantahliliSonuclari.getTahlilDurumu().equals("Tamamlandı"))
                    {
                        counter1++;
                    }
                }
                for(IdrarTahlili idrartahliliSonuclari:Hasta.idrarTahlili){
                    if(idrartahliliSonuclari.getTahlilDurumu().equals("Tamamlandı"))
                    {
                        counter2++;
                    }
                }
                c=counter2+counter1;
                if(c==(Hasta.kanTahlili.size()+(Hasta.idrarTahlili.size())))
                {
                    JOptionPane.showMessageDialog(null,"Bekleyen Tahlil Yok");
                }
                else
                {
                    String[] columnNames = {"Tahlil Tipi", "Tahlil Tarihi", "Hasta Adı", "Doktor Adı", "Laborant Adı"};
                    Object[][] data = new Object[100][5];
                    int i = 0;
                    for(KanTahlili kantahliliSonuclari:Hasta.kanTahlili){
                        if(kantahliliSonuclari.getTahlilDurumu().equals("Bekliyor")){
                            data[i][0] = kantahliliSonuclari.getTahlilAdi();
                            data[i][1] = kantahliliSonuclari.getTahlilTarihi();
                            data[i][2] = kantahliliSonuclari.getTahlilHasta();
                            data[i][3] = kantahliliSonuclari.getTahlilDoktor();
                            data[i][4] = kantahliliSonuclari.getTahlilLaborant();
                            i++;
                        }
                    }
                    for(IdrarTahlili idrartahliliSonuclari:Hasta.idrarTahlili){
                        if(idrartahliliSonuclari.getTahlilDurumu().equals("Bekliyor")){
                            data[i][0] = idrartahliliSonuclari.getTahlilAdi();
                            data[i][1] = idrartahliliSonuclari.getTahlilTarihi();
                            data[i][2] = idrartahliliSonuclari.getTahlilHasta();
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
            public void actionPerformed(ActionEvent actionEvent) {
                pnl_tahlildoldur.setVisible(true);

                String[] tahlilTipi1 = {" ","Kan Tahlili", "Idrar Tahlili"};
                cmbo_box_tip.setModel(new DefaultComboBoxModel(tahlilTipi1));
                String tahlilTipi = cmbo_box_tip.getSelectedItem().toString();
                String[] değerler=new String[8];
                String[] değerler2=new String[12];
            }
        });
        //Laborant tahlil doldurma işlemini tamamlıyor.
        btn_Doldur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                long kimlikNo = Long.parseLong(field_hasta_TC.getText());
                String tahlilTipi = cmbo_box_tip.getSelectedItem().toString();
                String[] columnNames = {"işlem adı", "Sonuc", "Sonuc Birimi", "Referans Değeri", "Tarih"};
                Object[][] data = new Object[100][5];
                int i = 0;
                if(tahlilTipi.equals("Kan Tahlili")) {
                    for (KanTahlili kantahliliSonuclari : Hasta.kanTahlili) {
                        if (kantahliliSonuclari.getTahlilHasta() == kimlikNo) {
                            data[i][0] = kantahliliSonuclari.getDeğerler()[i];
                            data[i][1] = kantahliliSonuclari.getDeğerlerSonuç()[i];
                            data[i][2] = kantahliliSonuclari.getDeğerlerBirim()[i];
                            data[i][3] = kantahliliSonuclari.getDeğerlerReferans()[i];
                            data[i][4] = kantahliliSonuclari.getTahlilTarihi();
                            i++;
                            kantahliliSonuclari.setTahlilDurumu("Tamamlandı");
                        }
                    }
                }
                else if(tahlilTipi.equals("Idrar Tahlili")){
                    for(IdrarTahlili idrartahliliSonuclari:Hasta.idrarTahlili){
                        if(idrartahliliSonuclari.getTahlilHasta()==kimlikNo){
                            data[i][0] = idrartahliliSonuclari.getDeğerler()[i];
                            data[i][1] = idrartahliliSonuclari.getDeğerlerSonuç()[i];
                            data[i][2] = idrartahliliSonuclari.getDeğerlerBirim()[i];
                            data[i][3] = idrartahliliSonuclari.getDeğerlerReferans()[i];
                            data[i][4] = idrartahliliSonuclari.getTahlilTarihi();
                            i++;
                            idrartahliliSonuclari.setTahlilDurumu("Tamamlandı");
                        }
                    }
                }
                for(KanTahlili kanTahlili1:Hasta.kanTahlili)
                {
                    System.out.println(kanTahlili1.getTahlilHasta());
                    System.out.println(kanTahlili1.getTahlilAdi());
                    System.out.println(kanTahlili1.getTahlilTarihi());
                    System.out.println(kanTahlili1.getTahlilDoktor());
                    System.out.println(kanTahlili1.getTahlilLaborant());
                    System.out.println(kanTahlili1.getTahlilDurumu());
                    for( i=0;i<8;i++)
                    {
                        System.out.println(kanTahlili1.getDeğerler()[i]);
                        System.out.println(kanTahlili1.getDeğerlerSonuç()[i]);
                        System.out.println(kanTahlili1.getDeğerlerBirim()[i]);
                        System.out.println(kanTahlili1.getDeğerlerReferans()[i]);
                    }
                }

                for(IdrarTahlili idrarTahlili:Hasta.idrarTahlili)
                {
                    System.out.println(idrarTahlili.getTahlilHasta());
                    System.out.println(idrarTahlili.getTahlilAdi());
                    System.out.println(idrarTahlili.getTahlilTarihi());
                    System.out.println(idrarTahlili.getTahlilDoktor());
                    System.out.println(idrarTahlili.getTahlilLaborant());
                    System.out.println(idrarTahlili.getTahlilDurumu());
                    for( i=0;i<12;i++)
                    {
                        System.out.println(idrarTahlili.getDeğerler()[i]);
                        System.out.println(idrarTahlili.getDeğerlerSonuç()[i]);
                        System.out.println(idrarTahlili.getDeğerlerBirim()[i]);
                        System.out.println(idrarTahlili.getDeğerlerReferans()[i]);
                    }
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
                    for (KanTahlili kantahliliSonuclari : Hasta.kanTahlili) {
                        for(int k=0;k<8;k++)
                        {
                            değerler[k]=JOptionPane.showInputDialog("Lütfen"+kantahliliSonuclari.getTahlilAdi()+" için "+kantahliliSonuclari.getDeğerler()[k]+" değerini giriniz");
                        }
                        for (int j=0;j<8;j++){
                            kantahliliSonuclari.setDeğerlerSonuç(değerler);
                        }
                    }
                    for(KanTahlili k1:Laborant.kantahliliSonuclari)
                    {
                        for(int k=0;k<8;k++)
                        {
                            k1.setDeğerlerSonuç(değerler);
                        }
                    }

                }
                else if(tahlilTipi.equals("Idrar Tahlili")){
                    for (IdrarTahlili idrartahliliSonuclari : Hasta.idrarTahlili) {
                        for(int k=0;k<12;k++)
                        {
                            değerler2[k]=JOptionPane.showInputDialog("Lütfen "+idrartahliliSonuclari.getTahlilAdi()+" için "+idrartahliliSonuclari.getDeğerler()[k]+" değerini giriniz");
                        }
                        for (int j=0;j<12;j++){
                            idrartahliliSonuclari.setDeğerlerSonuç(değerler2);
                        }
                    }
                    for(IdrarTahlili i1:Laborant.idrartahliliSonuclari)
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
    //Laborantın constractor metodu
    public Laborant(long kimlikNo,String isim, String soyisim, String sifre, int telefon) {
        this.kimlikNo = kimlikNo;
        this.isim = isim;
        this.soyisim = soyisim;
        this.sifre = sifre;
        this.telefon = telefon;
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
}
