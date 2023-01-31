package com.LaboratuvarTestSonuclari;

import com.LaboratuvarTestSonuclari.Model.Doktor;
import com.LaboratuvarTestSonuclari.Model.Hasta;
import com.LaboratuvarTestSonuclari.Model.Laborant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Giris extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_giris;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton btn_giris;
    private JLabel lbl_kimlik;
    private JLabel field_sifre;
    private JLabel field_kullanici;
    private JButton btn_kayit;
    private JTextField textField2;

    //Giris ekranının oluşturulması
    public Giris() throws HeadlessException {
        this.add(wrapper);
        setSize(500, 500);
        setTitle("Giriş Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        String[] kullanici = {"Hasta", "Doktor","Laborant"};
        comboBox1.setModel(new DefaultComboBoxModel(kullanici));
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getWidth()) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getHeight()) / 2;
        setLocation(x,y);
        setVisible(true);

        //Giriş butonuna tıklandığında seçilen kullanıcıya göre giriş yapılması ve eğer öyle bir kullanıcı yoksa uyarı verilmesi sağlanıyor. Kullanıcı giriş yaptığında ismini sayfada görür.
        btn_giris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String kullanici = comboBox1.getSelectedItem().toString();
                String sifre = passwordField1.getText();
                 long kimlik = Long.parseLong(textField2.getText());
                Boolean flag = false;
                if (kullanici.equals("Hasta")){
                    for(Hasta hasta : Hasta.hastalar) {
                        if(hasta.getTc()==kimlik && hasta.getSifre().equals(sifre))
                        {
                            HastaGUI hasta1 = new HastaGUI(hasta);
                            hasta1.lbl_kullanici_isim.setText(hasta.getIsim()+" "+hasta.getSoyisim());
                            hasta1.lbl_kullanici_Yas.setText(String.valueOf(hasta.getYas()));
                            hasta1.setVisible(true);
                            dispose();
                            flag= true;
                            break;
                        }
                        else if ( hasta.getTc()==kimlik && hasta.getSifre()!=sifre){
                            JOptionPane.showMessageDialog(null, "Hatalı Giriş");
                        }
                    }
                    if (flag==false){
                        JOptionPane.showMessageDialog(null, "Kullanici Bulunamadi");
                    }

                }
                else if (kullanici.equals("Doktor")){
                    Boolean flag1 = false;
                    for(Doktor doktor : Doktor.doktorlar) {
                        if(doktor.getTc()==kimlik && doktor.getSifre().equals(sifre))
                        {
                            DoktorGUI doktor1 = new DoktorGUI(doktor);
                            doktor1.lbl_kullanici_isim.setText(doktor.getIsim()+" "+doktor.getSoyisim());
                            doktor1.setVisible(true);
                            dispose();
                            flag1= true;
                            break;
                        }
                        else if ( doktor.getTc()==kimlik && doktor.getSifre()!=sifre){
                            JOptionPane.showMessageDialog(null, "Hatalı Giriş");
                            flag1= true;
                        }
                    }
                    if (flag1==false){
                        JOptionPane.showMessageDialog(null, "Kullanici Bulunamadi");
                    }
                }
                else if (kullanici.equals("Laborant")){
                    Boolean flag2 = false;

                    for(Laborant laborant : Laborant.laborantlar) {
                        if(laborant.getTc()==kimlik && laborant.getSifre().equals(sifre))
                        {
                            LaborantGUI laborant1 = new LaborantGUI(laborant);
                            laborant1.lbl_hosgeldin.setText("Hosgeldiniz "+laborant.getIsim()+" "+laborant.getSoyisim());
                            laborant1.setVisible(true);
                            dispose();
                            flag2= true;
                            break;
                        }
                        else if ( laborant.getTc()==kimlik && laborant.getSifre()!=sifre){
                            JOptionPane.showMessageDialog(null, "Hatalı Giriş");
                            flag2= true;
                        }
                    }
                    if (flag2==false){
                        JOptionPane.showMessageDialog(null, "Kullanici Bulunamadi");
                    }
                }

            }
        });
        //Kayıt ol butonuna tıklandığında kayıt olma ekranı açılması
        btn_kayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Kayit kayit = new Kayit();
                kayit.setVisible(true);
                dispose();

            }
        });
    }




}
