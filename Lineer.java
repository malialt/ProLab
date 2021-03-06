import java.io.*;

public class Lineer
{
    private Student[] liste;
    private Student ogrenciK�sa;
    private char[] harfDizisi;
    
    private int islemSayaci = 0;
    private int islemSayaci2 = 0;
    private int genelSayac = 0;
    
    private FileReader txtOkuyucu;
    
    private final int GENISLIK = 500;
    
    public Lineer()
    {
        liste = new Student[GENISLIK];
        harfDizisi = new char[30000];
        
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
        int m = 0;
        
        //Karakter dizisini sonuna kadar takip ederek ��rencileri olu�turma ve ekleme
        while(m < 500 && sayac < harfDizisi.length - 2)
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
            
            liste[m] = ogrenciK�sa;
            
            //��renciyi hash fonksiyonuna g�re ekleme
            islemSayaci++;
            
            //Yeni ��renci i�in de�i�kenleri s�f�rlama
            numara = 0;
            ad = "";
            soyad = "";
            m++;
            islemSayaci++;
            
        }
    }
    public String bul(int numara)
    {
        islemSayaci2 = 0;
        for(int i = 0; i < liste.length; i++)
        {
            islemSayaci2++;
            genelSayac++;
            if(numara == liste[i].ogrNoAl())
                return liste[i].toString() + "    " + + islemSayaci + " hamlede dosya olu�turuldu, " + (islemSayaci2) + " hamlede arama i�lemi yap�ld�.";
        }
        
        return "Arad���n�z ��renci bulunmamaktad�r. " + + islemSayaci + " hamlede dosya olu�turuldu, " + (islemSayaci2) + " hamlede arama i�lemi yap�ld�.";
    }
    
    public Student[] d�n()
    {
        return liste;
    }
    
    public void hepsini()
    {
        for(Student ogrenci : liste )
        {
            bul(ogrenci.ogrNoAl());
        }
        
        System.out.println("T�m ��rencilerin Lineer yoklama ile aranmas� " + genelSayac + " arama i�lemi yap�ld�." +
                               "\nToplamda ise " + (islemSayaci+genelSayac) +" i�lem yap�ld�.");
    }
    
    //��renci Listesini s�rayla bast�rma
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