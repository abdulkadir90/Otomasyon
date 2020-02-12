/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Otomasyon extends Menü{
    public int üyeTipi;
    
    public static boolean girişYapıldı;
    
    public static final int TIP_OGRENCI = 0;
    public static final int TIP_OGRETMEN = 1;
    public static final int TIP_ADMIN = 2;
    
    public static final String UYE[] ={
        "Öğrenci",
        "Öğretmen"
    };
        

    public static void main(String[] args) {        
        Otomasyon.dataBaseİşlemleri();
        
        Otomasyon otomasyon = new Otomasyon();
        
        while(true){
            try{
                otomasyon.menü();
            } catch(Exception e){
                System.out.println(e);
                bekletme(
                        "Kritik bir hata meydana geldi, sayı girilmesi gereken yerde \"\" (ENTER'a basmış) olabilirsiniz. :( \n" +
                        "Program sıfırlandı ancak veriler kaydedildi."
                );
                verileriYenile();
            }
        }
    }
    
    @Override
    public void menü() {
        girişYapıldı = false;
        
        String answer;
        
        while(true) {
            System.out.println("Görsel dizaynı görebilmek için lütfen komut isteminden / terminalden çalıştırınız.");
            consoluTemizle();
            
            çMenü(
                "Öğrenci İşleri Otomasyonu\n" +
                SATIR_MENU +
                " [1]  Öğrenci İşlemleri\n" +
                " [2]  Öğretim Üyesi İşlemleri" 
            );
            answer = input.nextLine();
            
            switch(answer){
                case "1":
                    üyeTipi = TIP_OGRENCI;
                    üyeGirişi();
                    break;
                case "2":
                    üyeTipi = TIP_OGRETMEN;
                    üyeGirişi();
                    break;
                case "" + CIKIS:
                    çıkış();
                default:
                    bekletme("Hatalı tuşlama yaptınız.");
            }
            
        }
        
    }
    
    private void üyeGirişi(){
        if(!girişYapıldı){
            while(true){
                consoluTemizle();
                
                if(üyeTipi == TIP_ADMIN)
                    üyeTipi = TIP_OGRETMEN;
                
                String answer;

                gMenü(
                    UYE[üyeTipi] + " girişi\n" + 
                    SATIR_MENU +
                    "Lütfen kullanıcı adınızı giriniz"
                );
                
                answer = input.nextLine();
                
                switch(answer){
                    case "" + GERI:
                        return;
                    case "" + CIKIS:
                        çıkış();
                    default:
                       kullanıcıKontrolü(answer);
                }
                
            }
        }
    }

    private void kullanıcıKontrolü(String kullanıcıAdı){
        switch(üyeTipi){
            case TIP_OGRETMEN:
                adminKontrolü(kullanıcıAdı);
                if (üyeTipi != TIP_ADMIN)
                    öğretmenKontrolü(kullanıcıAdı);
                break;
            case TIP_OGRENCI:
                öğrenciKontrolü(kullanıcıAdı);
                break;
            
        }
    }
    
    private void adminKontrolü(String kullanıcıAdı){
        if(kullanıcıAdı.equals(BOS_STR)){
            üyeTipi = TIP_ADMIN;
            new Admin().menü();
        }
    }
    
    private void öğrenciKontrolü(String kullanıcıAdı){
        boolean bulunduMu = false;
        for (Ogrenci öğrenci : kayıtlarÖğrenci){
            if (öğrenci.bilgiler[Uye.KULLANICI_ADI].equals(kullanıcıAdı)){
                bulunduMu = true;
                consoluTemizle();
                System.out.print(
                    SATIR_MENU +
                    "Şifrenizi giriniz:\n" +
                    SATIR_MENU +
                    INPUT_MENU 
               );
                String şifre = input.nextLine();
                if (öğrenci.bilgiler[Uye.SIFRE].equals(şifre)){
                    öğrenci.menü();
                    return;
                }
            }
        }
        if(!bulunduMu)
            bekletme("Kullanıcı adı mevcut değil.");
    }
    
    private void öğretmenKontrolü(String kullanıcıAdı){
        boolean bulunduMu = false;
        for (Ogretmen öğretmen : kayıtlarÖğretmen){
            if (öğretmen.bilgiler[Uye.KULLANICI_ADI].equals(kullanıcıAdı)){
                bulunduMu = true;
                consoluTemizle();
                System.out.print(
                    "Şifrenizi giriniz:\n" +
                    SATIR_MENU +
                    INPUT_MENU 
               );
                String şifre = input.nextLine();
                if (öğretmen.bilgiler[Uye.SIFRE].equals(şifre)){
                    öğretmen.menü();
                    return;
                }
            }
        }
        if(!bulunduMu)
            bekletme("Kullanıcı adı mevcut değil.");
    }

    @Override
    public void iMenüİşlemi(String girdi, int tip) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    protected static final void dataBaseİşlemleri(){
        if(yeni){
            try{
                açılışDosyasıOluştur();
                
                new File(KLASOR_ADI).mkdir();
                
                varsayılanDosyalarıOluştur();
                verileriAl();
                
            
            } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            yeni = false;
        }
    }   
}