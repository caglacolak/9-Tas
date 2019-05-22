package DokuzTas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*Alfa beta pruning eklenecek*/
public class BilgisayarOyuncu extends Oyuncu {
    private int maksimumDerinlik;
    private DegerlendirmeFonksiyonuTipi degerlendirmeFonksiyonuTipi;

    public BilgisayarOyuncu(String ad, int maksimumDerinlik, DegerlendirmeFonksiyonuTipi degerlendirmeFonksiyonuTipi){
        super(ad, Renk.MAVI, "I WIN!!! HA HA HA HA!!!",9);
        this.maksimumDerinlik = maksimumDerinlik;
        this.degerlendirmeFonksiyonuTipi = degerlendirmeFonksiyonuTipi;
    }

    private boolean bitisKontrolu(Durum durum){
        return (durum.derinlikGetir() >= maksimumDerinlik);
    }

    private double degerlendirDurum(Durum durum){
        DegerlendirmeFonksiyonu degerlendirmeFonksiyonu;
        switch (degerlendirmeFonksiyonuTipi){
            case BASIT:
                degerlendirmeFonksiyonu = new BasitDegerlendirmeFonksiyonu(durum.getirTahta());
                break;
            case KARMASIK:
                degerlendirmeFonksiyonu = new KarmasikDegerlendirmeFonksiyonu(durum.getirTahta());
                break;
            default:
                degerlendirmeFonksiyonu = new BasitDegerlendirmeFonksiyonu(durum.getirTahta());
                break;
        }
        return degerlendirmeFonksiyonu.degerlendir();
    }

    private double maksimumDeger(Durum durum) throws Exception{
        double v;
        ArrayList<Hareket> mumkunHareketler;
        if (bitisKontrolu(durum)){
            return degerlendirDurum(durum);
        }
        v = Integer.MIN_VALUE;
        mumkunHareketler = durum.getirTahta().olasiHareketler(Renk.MAVI);
        for (Hareket hareket : mumkunHareketler){
            durum.hareketEt(hareket, Renk.MAVI);
            v = Math.max(v, minimumDeger(durum));
            durum.hareketiGeriAl(hareket);
        }
        return v;
    }

    private double minimumDeger(Durum durum) throws Exception{
        double v;
        ArrayList<Hareket> mumkunHareketler;
        if (bitisKontrolu(durum)){
            return degerlendirDurum(durum);
        }
        v = Integer.MAX_VALUE;
        mumkunHareketler = durum.getirTahta().olasiHareketler(Renk.MAVI);
        for (Hareket hareket : mumkunHareketler){
            durum.hareketEt(hareket, Renk.SARI);
            v = Math.min(v, maksimumDeger(durum));
            durum.hareketiGeriAl(hareket);
        }
        return v;
    }
    private double AlfaBetaBudamasi(Durum durum, double alfa, double beta,  boolean minmax) throws Exception {
        if (bitisKontrolu(durum)) {
            return degerlendirDurum(durum);
        }
        if (minmax == true) { //max seç
            double a = Integer.MIN_VALUE;
            ArrayList<Hareket> olasiHareketler = durum.getirTahta().olasiHareketler(Renk.MAVI);
            for (Hareket hareket : olasiHareketler) {
                Durum klonDurum = new Durum(durum.getirTahta(), durum.derinlikGetir());
                klonDurum.hareketEt(hareket, Renk.MAVI);
                double x = AlfaBetaBudamasi(klonDurum, alfa, beta, false);
                if (a < x) {
                    a = x;
                    alfa = x;
                }
                if (a > beta) {
                    break;
                }
            }
            return a;
        } else { // min seç
            double a = Integer.MAX_VALUE;
            ArrayList<Hareket> olasiHareketler = durum.getirTahta().olasiHareketler(Renk.MAVI);
            for (Hareket hareket : olasiHareketler) {
                Durum klonDurum = new Durum(durum.getirTahta(), durum.derinlikGetir());
                klonDurum.hareketEt(hareket, Renk.SARI);
                double x = AlfaBetaBudamasi(klonDurum, alfa, beta , false);
                if(a > x){
                    a = x;
                    beta = x;
                }
                if (a < alfa) {
                    break;
                }
            }
            return a;
        }
    }
    private int[] minMakKarar(Durum durum) throws Exception{
        Random rastgele = new Random();
        int[] tempreturn=new int[2];

        ArrayList<Hareket> enIyiHareketListesi = new ArrayList<Hareket>();
        double deger, maksimum = Integer.MIN_VALUE;
        ArrayList<Hareket> mumkunHareketler;
        mumkunHareketler = durum.getirTahta().olasiHareketler(Renk.MAVI);
        for (Hareket hareket : mumkunHareketler){
            durum.hareketEt(hareket, Renk.MAVI);
            deger = AlfaBetaBudamasi(new Durum(durum.getirTahta(), durum.derinlikGetir()),Integer.MIN_VALUE, Integer.MAX_VALUE, false);//minimumDeger(durum);
            if (deger > maksimum){
                maksimum = deger;
                enIyiHareketListesi = new ArrayList<Hareket>();
                enIyiHareketListesi.add(hareket);
            } else {
                if (deger == maksimum){
                    enIyiHareketListesi.add(hareket);
                }
            }
            durum.hareketiGeriAl(hareket);
        }
        if (enIyiHareketListesi.size() > 0){
            int enIyilerArasindaRastgele = rastgele.nextInt(enIyiHareketListesi.size());
            tempreturn[0]=enIyiHareketListesi.get(enIyilerArasindaRastgele).getirSatir();
            tempreturn[1]=enIyiHareketListesi.get(enIyilerArasindaRastgele).getirSutun();

            return tempreturn;
        } else {
            return tempreturn;
        }
    }

    public int[] oyna(Tahta tahta){

        Date baslangic, son;
        int[] enIyiKarar = new int[2];
        Durum durum;
        durum = new Durum(tahta, 0);
        baslangic = new Date();
        try {
            enIyiKarar = minMakKarar(durum);
        } catch (Exception ex) {
            Logger.getLogger(BilgisayarOyuncu.class.getName()).log(Level.SEVERE, null, ex);
        }
        son = new Date();
        System.out.println((son.getTime() - baslangic.getTime()) / 1000.0 + " saniye düşündüm!");
        return enIyiKarar;
    }

}
