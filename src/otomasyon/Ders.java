/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

import java.io.Serializable;

public class Ders extends DataBase implements GunVeSaatSabitleri, DersVeSinavSabitleri, Serializable{
    public String ad = BOS_STR;
    public String gün = BOS_STR;
    public String başlangıç = BOS_STR;
    public String bitiş = BOS_STR;
    
    public int bölüm = BOS_INT;
    public int kredi = BOS_INT;
    
    public Tarih[] sınav = new Tarih[]{new Tarih(), new Tarih(), new Tarih(), new Tarih()};
    
    public int[] not = new int[]{BOS_INT, BOS_INT, BOS_INT, BOS_INT, BOS_INT, BOS_INT};
    public int[] yüzdeler = new int[]{BOS_INT, BOS_INT, BOS_INT, BOS_INT, BOS_INT, BOS_INT};
    
    public static final Ders kalıpOluştur(String ad, int bölüm){
        Ders ders = new Ders();
        ders.ad = ad;
        ders.bölüm = bölüm;
        
        return ders;
    }

    public void yüzdeKontrolü(){        
        int toplamYüzde = 0;
        
        for(int i : yüzdeler){
            toplamYüzde += i;
        }
        
        if(toplamYüzde != 100){
            System.out.println("Hata: Not yüzdeleri arasında tutarsızlık var !");
        }
    }
}