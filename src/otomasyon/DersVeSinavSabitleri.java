/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

public interface DersVeSinavSabitleri {
    public final static int VIZE = 0;
    public final static int MAZERET = 1;
    public final static int FINAL= 2;
    public final static int BUTUNLEME = 3;
    public final static int ODEV = 4;
    public final static int PROJE = 5;
    public final static int SINAV_SAYISI = 4;
    
    public static final String SINAV[] = {
        "Vize",
        "Mazeret",
        "Final",
        "Bütünleme"
    };
    
    public static final String NOT_ISMI[] = {
        "Vize",
        "Mazeret",
        "Final",
        "Bütünleme",
        "Ödev",
        "Proje"
    };
}