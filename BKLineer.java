import java.io.*;

public class BKLineer
{
    private Student[] liste;
    private Student ogrenciKýsa;
    private char[] harfDizisi;
    private Lineer dizi;
    
    private int islemSayaci = 0;
    private int islemSayaci2 = 0;
    private int genelSayac = 0;
    
    private FileReader txtOkuyucu;
    
    private final int GENISLIK = 500;
    
    public BKLineer()
    {
        liste = new Student[GENISLIK];
        harfDizisi = new char[90000];
        dizi = new Lineer();
        
        //Text dosyasýný belirli bir karakter dizisine okuma
        try
        {
            txtOkuyucu = new FileReader("Ogrenciler.txt");
            
            txtOkuyucu.read(harfDizisi);
            
            txtOkuyucu.close();
            islemSayaci++;
        }
        
        catch(IOException e)
        {
            System.out.println("hata");
        }
        
        //Kýsa Süreli oluþturulacak öðrenci için ad soyad ve numara belirleme
        int numara = 0;
        String ad = "";
        String soyad = "";
        
        //Karakter dizisinden gerekli deðiþkenleri çekebilmek için sayaç oluþturma
        int sayac = 0;
        int sayacIlk = 0;
        
        //Karakter dizisini sonuna kadar takip ederek öðrencileri oluþturma ve ekleme
        while(sayac < harfDizisi.length - 2)
        {
            //Öðrencinin numarasýný alma
            sayacIlk = sayac;
            
            while( sayac < harfDizisi.length && harfDizisi[sayac] != ' ')
            {
                sayac++;
                islemSayaci++;
            }
            for(int i = sayacIlk; i < sayac; i++)
            {
                numara = (numara * 10) + Character.getNumericValue(harfDizisi[i]);
                islemSayaci++;
            }
            sayac++;
            
            //Öðrencinin adýný alma
            sayacIlk = sayac;
            
            while( sayac < harfDizisi.length && harfDizisi[sayac] != ' ')
                sayac++;
            
            for(int j = sayacIlk; j < sayac; j++)
            {
                ad = ad + harfDizisi[j];
            }
            sayac++;
            
            //Öðrencinin soyadýný alma
            sayacIlk = sayac;
            
            
            while( sayac < harfDizisi.length && harfDizisi[sayac] != ' ')
            {
                sayac++;
                islemSayaci++;
            }
            sayac = sayac+2;
            
            for(int k = sayacIlk; k < sayac; k++)
            {
                if(k < harfDizisi.length)
                    soyad = soyad + harfDizisi[k];
                islemSayaci++;
            }
            sayac++;
            
            //Yeni bir kýsa süreli öðrenci oluþturma
            ogrenciKýsa = new Student(numara, ad, soyad);
            islemSayaci++;
            
            //Öðrenciyi hash fonksiyonuna göre ekleme
            ekle(ogrenciKýsa);
            islemSayaci++;
            
            //Yeni öðrenci için deðiþkenleri sýfýrlama
            numara = 0;
            ad = "";
            soyad = "";
            
        }
        txtYaz();
    }
    
    //Öðrenciyi numarasýna göre ekleme
    public boolean ekle(Student ogrenci)
    {
        int mod = ogrenci.ogrNoAl() % GENISLIK;
        int i = mod;
        islemSayaci++;
        
        while(liste[i] != null)
        {
            islemSayaci++;
            if(i == GENISLIK - 1)
                i = 0;
            else 
                i++;
            if(i == mod)
                return false;
        }
        
        liste[i] = ogrenci;
        islemSayaci++;
        return true;
    }
    
    
    
    
    public void txtYaz()
    {
        try
        {
            File dosya = new File("BKLineer.txt");
            islemSayaci++;
            
            FileWriter yazici = new FileWriter(dosya);
            islemSayaci++;
            
            int i = 0;
            for(Student ogr : liste)
            {
                yazici.write( ogr.ogrNoAl() + " " + ogr.adAl() + " " + ogr.soyadAl() + "\r\n" );
                i++;
                islemSayaci++;
            }
        }
        catch(IOException e)
        {
            System.out.println("hata");
        }
    }
    
    
    
//    
//    Öðrenciyi numarasýndan arama
    public String bul(int numara)
    {
        islemSayaci2 = 0;
        //Hash yapma
        int mod = numara % GENISLIK;
        int i = mod;
        islemSayaci2++;
        genelSayac++;
        
        //Aranan nokta boþsa hata verme
        if(liste[i] == null)
            return "Aradýðýnýz öðrenci bulunmamaktadýr.";
        
        //Doluysa sýrasýyla listeyi kontrol etme
        else
        {
            while(liste[i].ogrNoAl() != numara)
            {
                islemSayaci2++;
                genelSayac++;
                if(i == GENISLIK - 1)
                    i = 0;
                else 
                    i++;
                //Liste baþa dönerse hata verme
                if(i == mod)
                    return "Aradýðýnýz öðrenci bulunmamaktadýr. " + (islemSayaci) + " hamlede dosya oluþturuldu, " + (islemSayaci2) + " hamlede arama iþlemi yapýldý.";
            }
        }
        //Bulunan noktada öðrenciyi ad soyad olarak döndürme
        return liste[i].toString() + "     " + islemSayaci + " hamlede dosya oluþturuldu, " + (islemSayaci2) + " hamlede arama iþlemi yapýldý.";
    }
    
    public void hepsini()
    {
        for(Student ogrenci : dizi.dön() )
        {
            bul(ogrenci.ogrNoAl());
        }
        
        System.out.println("Tüm öðrencilerin Bölen-Kalan Lineer yoklama ile aranmasý " + genelSayac + " arama iþlemi yapýldý." +
                               "\nToplamda ise " + (islemSayaci+genelSayac) +" iþlem yapýldý.");
    }
    
    
    
    
    
    
    
    
    
    //Öðrenci Listesini sýralý halde döndürme
    public String toString()
    {
        String toReturn = "";
        
        for(int i = 0; i < liste.length; i++)
        {
            toReturn = toReturn + " " + liste[i] + "\n";
        }
        return toReturn;
    }
    public int sayac()
    {
        return islemSayaci2;
    }
    
}