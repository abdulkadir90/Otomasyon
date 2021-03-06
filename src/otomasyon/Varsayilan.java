/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Varsayilan extends DataBase{
    protected Varsayilan(){
        
    }
    
    protected static final void varsayılanDosyalarıOluştur() throws IOException, ClassNotFoundException{
        varsayılanDersleriOluştur();
        varsayılanÖğrencileriOluştur();
        varsayılanÖğretmenleriOluştur();
        programDosyalarınıOluştur();
        kullanımKılavuzuOluştur();
    }
    
    protected static final void varsayılanDersleriOluştur() throws IOException{
        if(!(new File(DOSYA_ADI[DOSYA_DERSLER]).exists())){
            ArrayList<Ders> dersler = new ArrayList<>();

            dersler.add(Ders.kalıpOluştur("Veri Yapıları", BOLUM_BILGISAYAR));
            dersler.add(Ders.kalıpOluştur("Lojik Devre Tasarımı", BOLUM_BILGISAYAR));
            dersler.add(Ders.kalıpOluştur("Devreler ve Sistemler", BOLUM_BILGISAYAR));
            dersler.add(Ders.kalıpOluştur("Differantial Equations", BOLUM_BILGISAYAR));
            dersler.add(Ders.kalıpOluştur("Nesneye Yönelik Programlama", BOLUM_BILGISAYAR));
            dersler.add(Ders.kalıpOluştur("Olasılık Teorisi ve İstatislik", BOLUM_BILGISAYAR));

            dersler.add(Ders.kalıpOluştur("Mühendislik Mekaniği", BOLUM_ENDUSTRI));
            dersler.add(Ders.kalıpOluştur("Endüstri Mühendisliği için Muhasebe ", BOLUM_ENDUSTRI));
            dersler.add(Ders.kalıpOluştur("Olasılık Teorisi ve İstatistiğe Giriş ", BOLUM_ENDUSTRI));
            dersler.add(Ders.kalıpOluştur("Nesneye Yönelik Programlama (C#)", BOLUM_ENDUSTRI));
            dersler.add(Ders.kalıpOluştur("Ekonomi I", BOLUM_ENDUSTRI));
            dersler.add(Ders.kalıpOluştur("Multivariant Variant Funct. and App", BOLUM_ENDUSTRI));
            dersler.add(Ders.kalıpOluştur("Termodinamik", BOLUM_ENDUSTRI));
            dersler.add(Ders.kalıpOluştur("Çok Değişkenli Fonk. ve Uyg.", BOLUM_ENDUSTRI));

            objeYaz(DOSYA_DERSLER, dersler);
        }
    }
    
    protected static final void varsayılanÖğrencileriOluştur() throws IOException, ClassNotFoundException{
        if(!(new File(DOSYA_ADI[DOSYA_OGRENCILER]).exists())){
            kayıtlarDers = (ArrayList<Ders>) objeOku(DOSYA_DERSLER);
            
            if(kayıtlarDers != null){
                ArrayList<Ogrenci> öğrenciler = new ArrayList<>();

                öğrenciler.add(Ogrenci.kalıpOluştur("1", "Abdulkadir Semiz", BOLUM_BILGISAYAR, new Ders[]{kayıtlarDers.get(0), kayıtlarDers.get(1), kayıtlarDers.get(2), kayıtlarDers.get(3)}));
                öğrenciler.add(Ogrenci.kalıpOluştur("2", "Bahadir Üçyıldız", BOLUM_BILGISAYAR, new Ders[]{kayıtlarDers.get(4)}));
                öğrenciler.add(Ogrenci.kalıpOluştur("3", "Necmi Ateş", BOLUM_BILGISAYAR, new Ders[]{}));
                öğrenciler.add(Ogrenci.kalıpOluştur("4", "Hikmet Sari", BOLUM_ENDUSTRI, new Ders[]{kayıtlarDers.get(7), kayıtlarDers.get(8)}));
                öğrenciler.add(Ogrenci.kalıpOluştur("5", "Hülya Yılmaz", BOLUM_ENDUSTRI, new Ders[]{kayıtlarDers.get(9), kayıtlarDers.get(10)}));
                öğrenciler.add(Ogrenci.kalıpOluştur("6", "Elif Zobaci", BOLUM_ENDUSTRI, new Ders[]{kayıtlarDers.get(13), kayıtlarDers.get(12)}));
                öğrenciler.add(Ogrenci.kalıpOluştur("7", "Silinebilir ", BOLUM_ENDUSTRI, new Ders[]{kayıtlarDers.get(13), kayıtlarDers.get(12)}));

                objeYaz(DOSYA_OGRENCILER, öğrenciler);
                
            }
        }
    }
    
    protected static final void varsayılanÖğretmenleriOluştur() throws IOException, ClassNotFoundException{
        if(!(new File(DOSYA_ADI[DOSYA_OGRETMENLER]).exists())){
            kayıtlarÖğrenci = (ArrayList<Ogrenci>) objeOku(DOSYA_OGRENCILER);
            
            if(kayıtlarDers != null && kayıtlarÖğrenci != null){
                ArrayList<Ogretmen> öğretmenler = new ArrayList<>();

                öğretmenler.add(Ogretmen.kalıpOluştur("01", "Mustafa Semiz", new Ders[]{kayıtlarDers.get(0), kayıtlarDers.get(8)}));
                öğretmenler.add(Ogretmen.kalıpOluştur("02", "Süleyman Tütkyılmaz", new Ders[]{kayıtlarDers.get(1), kayıtlarDers.get(7)}));
                öğretmenler.add(Ogretmen.kalıpOluştur("03", "Mahmut Hoca", new Ders[]{kayıtlarDers.get(2), kayıtlarDers.get(9)}));
                öğretmenler.add(Ogretmen.kalıpOluştur("04", "Kerim Korur", new Ders[]{kayıtlarDers.get(3), kayıtlarDers.get(12)}));
                öğretmenler.add(Ogretmen.kalıpOluştur("05", "Silinebilir", new Ders[]{kayıtlarDers.get(4), kayıtlarDers.get(10)}));
                
                objeYaz(DOSYA_OGRETMENLER, öğretmenler);
                
            }
        }
    }
    
    protected static final void programDosyalarınıOluştur() throws IOException, ClassNotFoundException{
        kayıtlarDers = (ArrayList<Ders>) objeOku(DOSYA_DERSLER);
        
        if (kayıtlarDers != null){
            ArrayList<DersProgrami> dp = new ArrayList<>();
            ArrayList<SinavProgrami> sp = new ArrayList<>();
            
            dosyaOluşturAç(DOSYA_DERS_PROGRAMI);
            if(dosya.exists())
                dosya.delete();

            dosya.createNewFile();
            dp.add(DersProgrami.kalıpOluştur(BOLUM_BILGISAYAR));
            dp.add(DersProgrami.kalıpOluştur(BOLUM_ENDUSTRI));
            objeYazıcıOluştur(DOSYA_DERS_PROGRAMI);
            objeYazıcı.writeObject(dp);

            dosyaOluşturAç(DOSYA_SINAV_PROGRAMI);
            if(dosya.exists())
                dosya.delete();

            dosya.createNewFile();
            sp.add(SinavProgrami.kalıpOluştur(BOLUM_BILGISAYAR));
            sp.add(SinavProgrami.kalıpOluştur(BOLUM_ENDUSTRI));
            objeYazıcıOluştur(DOSYA_SINAV_PROGRAMI);
            objeYazıcı.writeObject(sp);
        }
    }
    
    protected static void açılışDosyasıOluştur(){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(new File("run.bat"));
            fileWriter.write("@echo off\nchcp 857\njava -jar Otomasyon.jar");
            fileWriter.close();
                    
        } catch (IOException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    protected static void kullanımKılavuzuOluştur(){
        FileWriter filewriter;
        try{
            filewriter = new FileWriter(new File("Kullanım Kılavuzu.txt"));
            filewriter.write(
                " Run.bat ile çalistirmaniz önerilir\n" +
                "\n" +
                " Birkaç ögrenci ve ögretmenler kayitları ayarladığım ve mailde gönderilen \"Kayitlar\" klasorunu \n" +
                ".jar uzantılı dosyanın veya src klasörünün yanına kopyalayarak kullanabilirsiniz. Eğer veri yoksa program\n" +
                "kendi oluşturacaktır. (dersProgramı, sınavProgramı, kullanıcı bilgileri admin panelinden oluşturabilirsiniz\n\n" +
                " Üye ekleme, silme, güncelleme için Admin menüsü bulunmakta. Menüye erisim için;\n" +
                " Öğretmen islemleri açilir ve kullanici adina '?' yazip ENTER'a basilir.\n" +
                "\n" +
                "Kullanıcı adları: \n Ogerciler icin: ogr1, ogr2, ogr3 ... Ogretmenler icin: ogrt1, ogrt2, ogrt3 ... Admin icin: ? \n" +
                "Sifreler: kullanıcı adi ile aynidir. (Sifre farki olabilmekte.)\n\n" + 
                "Abdulkadir Semiz \n1306160041\n"
            );
            filewriter.close();
        } catch (IOException e){
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}