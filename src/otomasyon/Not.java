/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

public final class Not extends DataBase{
    public int[] notlar = {BOS_INT, BOS_INT, BOS_INT, BOS_INT, BOS_INT, BOS_INT};

    public Not(int vize, int mazeret, int Final, int bütünleme, int ödev, int proje) {
        notlar = new int[]{vize, mazeret, Final, bütünleme, ödev, proje};
    }
    
    public Not(){
        
    }
    
    public int al(int notTürü){
        if(notTürü < 6)
            return notlar[notTürü];
        else
            return HATA_INT;
    }
    
    public void ayarla(int not, int notTürü){
        if(notTürü < 6 && not < 101 && not > -1)
            notlar[notTürü] = not;
    }
    
    public int[] hepsiniAl(){
        return notlar;
    } 
}