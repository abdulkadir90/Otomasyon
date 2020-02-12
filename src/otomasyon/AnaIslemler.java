/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

public interface AnaIslemler {
    public void oluştur();
    public void sil();
    public void güncelle();
    
    public static final int OLUSTUR = 0;
    public static final int SIL = 1;
    public static final int GUNCELLE = 2;
}