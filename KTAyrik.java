import java.io.*;

public class KTAyrik
{
    private Student[] liste;
    private Student[] ayrikListe;
    private Student ogrenciK�sa;
    private char[] harfDizisi;
    private Lineer dizi;
    
    private int islemSayaci = 0;
    private int islemSayaci2 = 0;
    private int genelSayac = 0;
    
    private FileReader txtOkuyucu;
    
    private final int GENISLIK = 500;
    
    public KTAyrik()
    {
        liste = new Student[GENISLIK];
        ayrikListe = new Student[GENISLIK / 2];
        harfDizisi = new char[30000];
        dizi = new Lineer();
        
        //Text dosyas�n� belirli bir karakter dizisine okuma
        try
        {
            txtOkuyucu = new FileReader("Ogrenciler.txt");
            
            txtOkuyucu.read(harfDizisi);
            
            txtOkuyucu.close();
        }
        
        catch(IOException e)
        {
            System.out.println("hata");
        }
        
        //K�sa S�reli olu�turulacak ��renci i�in ad soyad ve numara belirleme
        int numara = 0;
        String ad = "";
        String soyad = "";
        
        //Karakter dizisinden gerekli de�i�kenleri �ekebilmek i�in saya� olu�turma
        int sayac = 0;
        int sayacIlk = 0;
        
        //Karakter dizisini sonuna kadar takip ederek ��rencileri olu�turma ve ekleme
        while(sayac < harfDizisi.length - 2)
        {
            //��rencinin numaras�n� alma
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
            
            //��rencinin ad�n� alma
            sayacIlk = sayac;
            
            while( sayac < harfDizisi.length && harfDizisi[sayac] != ' ')
                sayac++;
            
            for(int j = sayacIlk; j < sayac; j++)
            {
                ad = ad + harfDizisi[j];
            }
            sayac++;
            
            //��rencinin soyad�n� alma
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
            
            //Yeni bir k�sa s�reli ��renci olu�turma
            ogrenciK�sa = new Student(numara, ad, soyad);
            islemSayaci++;
            
            //��renciyi hash fonksiyonuna g�re ekleme
            ekle(ogrenciK�sa);
            islemSayaci++;
            
            //Yeni ��renci i�in de�i�kenleri s�f�rlama
            numara = 0;
            ad = "";
            soyad = "";
            
        }
        txtYaz();
    }
    
    //��renciyi numaras�na g�re ekleme
    public boolean ekle(Student ogrenci)
    {
        String numara = "" + ogrenci.ogrNoAl();
        
        String sonUclu = numara.substring( numara.length() - 3 );
        String ortaUclu = numara.substring( numara.length() - 6 , numara.length() - 3);
        String ilkUclu = numara.substring( 0 , numara.length() - 6);
        
        sonUclu = new StringBuffer(sonUclu).reverse().toString();
        
        int toplam = Integer.parseInt(ilkUclu) + Integer.parseInt(ortaUclu) + Integer.parseInt(sonUclu);
        String toplam2 = "" + toplam;
        
        int adres = Integer.parseInt( toplam2.substring(1) ) % GENISLIK;
        islemSayaci++;
        
        
        if(liste[adres] != null)
        {
            int j = 0;
            
            while(ayrikListe[j] != null)
            {
                islemSayaci++;
                if(j == (GENISLIK/2) - 1 )
                    return false;
                else 
                    j++;
            }
            ayrikListe[j] = ogrenci;
            return true;
        }
        
        liste[adres] = ogrenci;
        return true;
    }
    
    //��renciyi numaras�ndan arama
    public String bul(int no)
    {
        islemSayaci2 = 0;
        //Hash yaparak numaran�n olmas� gereken yeri bulma
        String numara = "" + no;
        
        String sonUclu = numara.substring( numara.length() - 3 );
        String ortaUclu = numara.substring( numara.length() - 6 , numara.length() - 3);
        String ilkUclu = numara.substring( 0 , numara.length() - 6);
        
        sonUclu = new StringBuffer(sonUclu).reverse().toString();
        
        int toplam = Integer.parseInt(ilkUclu) + Integer.parseInt(ortaUclu) + Integer.parseInt(sonUclu);
        String toplam2 = "" + toplam;
        
        int adres = Integer.parseInt( toplam2.substring(1) ) % GENISLIK;
        islemSayaci2++;
        genelSayac++;
        
        
        //Aranan nokta bo�sa hata verme
        if(liste[adres] == null)
            return "Arad���n�z ��renci bulunmamaktad�r. " + islemSayaci + " hamlede dosya olu�turuldu, " + (islemSayaci2) + " hamlede arama i�lemi yap�ld�.";
        
        //Doluysa s�ras�yla listeyi kontrol etme
        else if(liste[adres].ogrNoAl() != no)
        {
            int j = 0;
            
            while(ayrikListe[j] != null && ayrikListe[j].ogrNoAl() != no)
            {
                islemSayaci2++;
                genelSayac++;
                if(j == (GENISLIK/2) - 1)
                    return "Arad���n�z ��renci bulunmamaktad�r. " + islemSayaci + " hamlede dosya olu�turuldu, " + (islemSayaci2) + " hamlede arama i�lemi yap�ld�.";
                else 
                    j++;
            }
            if(ayrikListe[j] != null)
                return "Ayr�k Liste : " + ayrikListe[j].toString() + "   " + islemSayaci + " hamlede dosya olu�turuldu, " + (islemSayaci2) + " hamlede arama i�lemi yap�ld�.";
            return "Arad���n�z ��renci bulunmamaktad�r. " + islemSayaci + " hamlede dosya olu�turuldu, " + (islemSayaci2) + " hamlede arama i�lemi yap�ld�.";
        }
        //Bulunan noktada ��renciyi ad soyad olarak d�nd�rme
        return liste[adres].toString() + "   " + islemSayaci + " hamlede dosya olu�turuldu, " + (islemSayaci2) + " hamlede arama i�lemi yap�ld�.";
    }
    
    public void txtYaz()
    {
        try
        {
            File dosya = new File("KTAyrik.txt");
            
            FileWriter yazici = new FileWriter(dosya);
            
            for(Student ogr : liste)
            {
                if(ogr != null)
                {
                    yazici.write( ogr.ogrNoAl() + " " + ogr.adAl() + " " + ogr.soyadAl() + "\r\n" );
                    islemSayaci++;
                }
            }
            
            yazici.write("\r\n Ayr�k Liste \r\n");
            
            for(Student ogr2: ayrikListe)
            {
                if(ogr2 != null)
                {
                    yazici.write( ogr2.ogrNoAl() + " " + ogr2.adAl() + " " + ogr2.soyadAl() + "\r\n" );
                    islemSayaci++;
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("hata");
        }
    }
    
    public void hepsini()
    {
        for(Student ogrenci : dizi.d�n() )
        {
            bul(ogrenci.ogrNoAl());
        }
        
        System.out.println("T�m ��rencilerin Katlama Tekni�i Ayr�k Ta�ma ile aranmas� " + genelSayac + " arama i�lemi yap�ld�." +
                               "\nToplamda ise " + (islemSayaci+genelSayac) +" i�lem yap�ld�.");
    }
    
    
    //��renci Listesini s�ral� halde d�nd�rme
    public String toString()
    {
        String toReturn = " Liste \n";
        
        for(int i = 0; i < liste.length; i++)
            toReturn = toReturn + " " + liste[i] + "\n";
        
        toReturn = toReturn + "\n Ayr�k Liste \n";
        
        for(int i = 0; i < ayrikListe.length; i++)
            toReturn = toReturn + " " + ayrikListe[i] + "\n";
        
        return toReturn;
    }
    
    public int sayac()
    {
        return islemSayaci2;
    }
}