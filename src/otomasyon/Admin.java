/**
 * Abdulkadir Semiz
 * 1306160041
 */
package otomasyon;

public final class Admin extends Menü implements DersVeSinavSabitleri{ 
    @Override
    public void menü() {
        while (true){
            consoluTemizle();
            
            gMenü(
                "Admin İşlemleri\n" +
                SATIR_MENU +
                " [1]  Ders Programı Hazırla\n" +
                " [2]  Sınav Programı Hazırla\n" +
                " [3]  Üye yönetim işlemleri"
            );
            String answer = input.nextLine();
            switch(answer){
                    case "1":
                        dersProgramıOluştur();
                        break;
                    case "2":
                        sınavProgramıOluştur();
                        break;
                    case "3":
                        üyeYönetimİşlemleri();
                        break;
                    case "" + GERI:
                        return;
                    case "" + CIKIS:
                       çıkış();
                    default:
                        bekletme("Hatalı tuşlama yaptınız :/");
                        break;
                }
        } 
    }
    
    private static void dersProgramıOluştur(){
        DersProgrami dersProgramı = new DersProgrami();
        dersProgramı.oluştur();
        
    }
    
    private static void sınavProgramıOluştur() {
        SinavProgrami sınavProgramı = new SinavProgrami();
        sınavProgramı.oluştur();
    }
    
    private void üyeYönetimİşlemleri(){
        while(true){
            consoluTemizle();
            
            String answer;
            
            gMenü(
                " Üye işlemleri\n" +
                SATIR_MENU +
                " [1] Öğrenci Yönetim İşlemleri\n" +
                " [2] Öğretmen Yönetim İşlemleri"
            );
        
            answer = input.nextLine();

            switch(answer){
                case "1":
                    new Ogrenci().yönetimİşlemleri();
                    break;
                case "2":              
                    new Ogretmen().yönetimİşlemleri();
                    break;
                case "" + GERI:
                    return;
                case "" + CIKIS:
                    çıkış();
            }
        }
    }  
}