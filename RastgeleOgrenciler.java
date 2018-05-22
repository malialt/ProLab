import java.io.*;

public class RastgeleOgrenciler
{
//    private Student[] ogrenciler;
    private Student rastgele;
    
    private File dosya;
    private FileWriter yazýcý;
    
    
    public RastgeleOgrenciler(int kacTane)
    {
        try
        {
            //Yeni txt dosyasý oluþturma
            dosya = new File("Ogrenciler.txt");
            dosya.createNewFile();
            
            //yeni writer oluþturma
            yazýcý = new FileWriter(dosya);
            
            //Rastgele öðrenciler oluþturup txt dosyasýna yazma
            for(int sayac = 0; sayac < kacTane; sayac++)
            {
                rastgele = new Student();
                yazýcý.write(rastgele.ogrNoAl() + " " + rastgele.adAl() + " " + rastgele.soyadAl() + " \r\n");
            }
            
            yazýcý.flush();
            yazýcý.close();
        }
        
        catch(IOException e)
        {
            System.out.println("hata3");
        }
    }
}
