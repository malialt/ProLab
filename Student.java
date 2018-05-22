public class Student
{
    private String ad = "";
    private String soyad = "";
    private int ogrNo = 140;
    
    private final String ALFABE = "abcçdefgðhýijklmnoöprsþtuüvyz";
    
    public Student()
    {
        //Rastgele isim oluþturma
        for(int sayac = 0; sayac < 7; sayac++)
        {
            ad = ad + ALFABE.charAt( (int)(Math.random() * ALFABE.length()) );
        }
       
        //Rastgele soyisim oluþturma
        for(int sayac = 0; sayac < 10; sayac++)
        {
            soyad = soyad + ALFABE.charAt( (int)(Math.random() * ALFABE.length()) );
        }
        
        //Rastgele öðrenci numarasý oluþturma
        for(int sayac = 0; sayac < 6; sayac++)
        {
            ogrNo = (10 * ogrNo) + ((int)(Math.random() * 10));
        }
        
        //Mutlak deðer alma
        ogrNo = Math.abs(ogrNo);
    }
    
    public Student(int ogrNo, String ad, String soyad)
    {
        this.ogrNo = ogrNo;
        this.ad = ad;
        this.soyad = soyad;
    }
    
    //Numarayý döndürme
    public int ogrNoAl()
    {
        return ogrNo;
    }
    
    //Adý döndürme
    public String adAl()
    {
        return ad;
    }
    
    //Soyadý döndürme
    public String soyadAl()
    {
        return soyad;
    }
    
    //Öðrencinin  özeliklerini yazý halinde döndürme
    public String toString()
    {
        return "Ogrenci No : " + ogrNo + "   Ad : " + adAl() + "   Soyad : " + soyadAl() + "\n";
    }
}