import java.io.*;
import java.util.Scanner;

public class Tester
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        RastgeleOgrenciler yeni = new RastgeleOgrenciler(500);
//        int secim;
        
//        do
//        {
//            System.out.println("1.  Rastgele bir dosya oluþtur \n" +
//                               "2.  Bölen-Kalan ve Lineer yoklama  \n" +
//                               "3.  Bölen-Kalan ve Ayrýk Taþma \n"+
//                               "4.  Katlama ve Lineer yoklama \n"+
//                               "5.  Katlama ve Ayrýk Taþma \n"+
//                               "6.  Kare ortasý ve Lineer yoklama \n"+
//                               "7.  Kare ortasý ve Ayrýk Taþma \n"+
//                               "8.  Lineer yoklama \n"+
//                               "9.  Karþýlaþtýrma \n"+
//                               "10. Çýkýþ");
//                              
//            
//            secim = scan.nextInt();
            
            
            yeni = new RastgeleOgrenciler(500);
            BKLineer deneme = new BKLineer();
            BKAyrik deneme2 = new BKAyrik();
            KTLineer deneme3 = new KTLineer();
            KTAyrik deneme4 = new KTAyrik();
            KOLineer deneme5 = new KOLineer();
            KOAyrik deneme6 = new KOAyrik();
            Lineer deneme7 = new Lineer();
            
            
            
            int aranacak;
            do{
                System.out.println("Aranacak öðrencinin numarasýný giriniz!" + 
                                   "\n (Tüm öðrencileri aramak ve kaç tane iþlem yapýldýðýný görmek için '1' e basýnýz.)");
                aranacak = Integer.parseInt(scan.next());
//                
                if(aranacak != 1)
                {
                    System.out.println( "Bölen-Kalan ve Lineer Yoklama \n " + deneme.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Bölen-Kalan ve Ayrýk Taþma \n " + deneme2.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Katlama ve Lineer Yoklama \n  " + deneme3.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Katlama ve Ayrýk Taþma \n  " + deneme4.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Kare Ortasý ve Lineer Yoklama \n  " + deneme5.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Kare Ortasý ve Ayrýk Taþma \n " + deneme6.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println(" Lineer Yoklama \n  " + deneme7.bul(aranacak));
                    System.out.println("**********************************************");
                }
            }while(aranacak != 1);
            
            System.out.println("**********************************************");
            deneme.hepsini();
            System.out.println("**********************************************");
            deneme2.hepsini();
            System.out.println("**********************************************");
            deneme3.hepsini();
            System.out.println("**********************************************");
            deneme4.hepsini();
            System.out.println("**********************************************");
            deneme5.hepsini();
            System.out.println("**********************************************");
            deneme6.hepsini();
            System.out.println("**********************************************");
            deneme7.hepsini();
            System.out.println("**********************************************");
            System.out.println();
            System.out.println();
            System.out.println("Bu programý kullandýðýnýz için teþekkürler!");
            
            
      
    }
}