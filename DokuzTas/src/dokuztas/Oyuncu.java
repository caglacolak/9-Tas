package DokuzTas;

/*Aynen kalacak*/
public abstract class Oyuncu {
    private String ad;
    private String kazanmaCumlesi;
    private Renk renk;
    private int tasCount;

    public Oyuncu(){

    }

    public Oyuncu(String ad, Renk renk, String kazanmaCumlesi,int tasCount){
        this.ad = ad;
        this.renk = renk;
        this.kazanmaCumlesi = kazanmaCumlesi;
        this.tasCount=tasCount;
    }

    public Renk getirRenk(){
        return renk;
    }

    public String getirKazanmaCumlesi(){
        return kazanmaCumlesi;
    }
    public int getirtasCount(){
        return tasCount;
    }
    public abstract int[] oyna(Tahta tahta);

}
