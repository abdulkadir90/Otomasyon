/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

import java.io.Serializable;

public final class Tarih extends DataBase implements GunVeSaatSabitleri, Serializable{
    public String başlangıç = BOS_STR;
    public String bitiş = BOS_STR;
    
    public int gün = BOS_INT;
    public int ay = BOS_INT;
    public int yıl = BOS_INT;
    
    public static final int G = 0;
    public static final int A = 1;
    public static final int Y = 2;
    public static final int MAX_GUN = 31;
    public static final int MAX_AY = 12;
    public static final int MAX_YIL = 2023;
    public static final int SUAN_YIL = 2017;
    
    public void arttır(int gün){
        if (this.gün == BOS_INT || this.ay == BOS_INT || this.yıl == BOS_INT){
            System.out.println("Tarih tanımlı değil !");
        } else{
            if (this.gün + gün <= MAX_GUN){
                this.gün += gün;
            } else{
                this.gün += gün - MAX_GUN;
                if (ay <= MAX_AY){
                    this.ay++;
                } else {
                   this.ay = 1;
                   this.yıl++;
                }
                
            }
        }
    }
    
    public Tarih ertesi(int gün){
        if (tarihVarMı()){
            Tarih tarih = new Tarih();
            tarih.yıl = this.yıl;
            tarih.ay = this.ay;
            
            if (this.gün + gün < MAX_GUN){
                tarih.gün = this.gün + gün;
            } else{
                tarih.gün = this.gün + gün - MAX_GUN + 1;
                if (this.ay < MAX_AY){
                    tarih.ay = this.ay + 1;
                } else {
                   tarih.ay = 1;
                   tarih.yıl = this.yıl + 1;
                }       
            }
            return tarih;
        }
        System.out.println("Tarih tanımlı değil");
        return null;
    }
    
    public final boolean tarihVarMı(){
        return !(this.gün == BOS_INT || this.ay == BOS_INT || this.yıl == BOS_INT);
    }
}