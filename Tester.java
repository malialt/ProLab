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
//            System.out.println("1.  Rastgele bir dosya olu�tur \n" +
//                               "2.  B�len-Kalan ve Lineer yoklama  \n" +
//                               "3.  B�len-Kalan ve Ayr�k Ta�ma \n"+
//                               "4.  Katlama ve Lineer yoklama \n"+
//                               "5.  Katlama ve Ayr�k Ta�ma \n"+
//                               "6.  Kare ortas� ve Lineer yoklama \n"+
//                               "7.  Kare ortas� ve Ayr�k Ta�ma \n"+
//                               "8.  Lineer yoklama \n"+
//                               "9.  Kar��la�t�rma \n"+
//                               "10. ��k��");
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
                System.out.println("Aranacak ��rencinin numaras�n� giriniz!" + 
                                   "\n (T�m ��rencileri aramak ve ka� tane i�lem yap�ld���n� g�rmek i�in '1' e bas�n�z.)");
                aranacak = Integer.parseInt(scan.next());
//                
                if(aranacak != 1)
                {
                    System.out.println( "B�len-Kalan ve Lineer Yoklama \n " + deneme.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("B�len-Kalan ve Ayr�k Ta�ma \n " + deneme2.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Katlama ve Lineer Yoklama \n  " + deneme3.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Katlama ve Ayr�k Ta�ma \n  " + deneme4.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Kare Ortas� ve Lineer Yoklama \n  " + deneme5.bul(aranacak));
                    System.out.println("**********************************************");
                    System.out.println("Kare Ortas� ve Ayr�k Ta�ma \n " + deneme6.bul(aranacak));
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
            System.out.println("Bu program� kulland���n�z i�in te�ekk�rler!");
            
            
      
    }
}