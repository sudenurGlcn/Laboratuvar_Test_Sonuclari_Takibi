package com.LaboratuvarTestSonuclari.Model;
import com.LaboratuvarTestSonuclari.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Hasta extends Person
{
    private int yas;
    public static ArrayList<Hasta> hastalar = new ArrayList<>();
    public ArrayList<KanTahlili> kanTahlili = new ArrayList<>();
    public ArrayList<IdrarTahlili> idrarTahlili = new ArrayList<>();

    public Hasta(long tc, String isim, String soyisim, String sifre, int telefon, int yas)
    {
        super(tc, isim, soyisim, sifre, telefon);
        this.yas=yas;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public static Hasta getByTc(long tc)
    {
        for(Hasta h : hastalar)
            if(h.getTc()==tc)
                return h;
        return null;
    }

    public void getModelSonuclar()
    {
        String[] columnNames = {"Tahlil Adı", "islem Adı", "Sonuç", "Birim", "Referans Aralığı", "Tarih"};
        String[][][] kantahlilleri = new String[kanTahlili.size()][8][columnNames.length];
        String[][][] idrartahlilleri = new String[idrarTahlili.size()][12][columnNames.length];
        for (int i = 0; i < kantahlilleri.length; i++)
        {
            for (int j=0 ; j < 8; j++)
            {
                kantahlilleri[i][j][0] = kanTahlili.get(i).getTahlilAdi()+" "+(i+1);
                kantahlilleri[i][j][1] = kanTahlili.get(i).getDeğerler()[j];
                kantahlilleri[i][j][2] = kanTahlili.get(i).getDeğerlerSonuç()[j];
                kantahlilleri[i][j][3] = kanTahlili.get(i).getDeğerlerBirim()[j];
                kantahlilleri[i][j][4] = kanTahlili.get(i).getDeğerlerReferans()[j];
                kantahlilleri[i][j][5] = kanTahlili.get(i).getTahlilTarihi();
            }
        }

        for (int i = 0; i < idrartahlilleri.length; i++)
        {
            for (int j=0 ; j < 12; j++)
            {
                idrartahlilleri[i][j][0] = idrarTahlili.get(i).getTahlilAdi()+" "+(i+1);
                idrartahlilleri[i][j][1] = idrarTahlili.get(i).getDeğerler()[j];
                idrartahlilleri[i][j][2] = idrarTahlili.get(i).getDeğerlerSonuç()[j];
                idrartahlilleri[i][j][3] = idrarTahlili.get(i).getDeğerlerBirim()[j];
                idrartahlilleri[i][j][4] = idrarTahlili.get(i).getDeğerlerReferans()[j];
                idrartahlilleri[i][j][5] = idrarTahlili.get(i).getTahlilTarihi();
            }
        }

        ArrayList<String[][]> tumtahliller = new ArrayList<>();
        tumtahliller.addAll(Arrays.asList(kantahlilleri));
        tumtahliller.addAll(Arrays.asList(idrartahlilleri));
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        for (String[][] d : tumtahliller)
            for (String[] dt : d)
                model.addRow(dt);

        JTable table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 250));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane);
    }
}
