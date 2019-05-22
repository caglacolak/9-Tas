package DokuzTas;

/*Oyuna göre değişecek*/
public class Oyun {
    private Oyuncu oyuncular[];
    private Tahta tahta;

    public Oyun(){
        oyuncular = new Oyuncu[2];
        oyuncular[0] = new InsanOyuncu("Ilker");
        oyuncular[1] = new BilgisayarOyuncu("SkyNet", 5, DegerlendirmeFonksiyonuTipi.KARMASIK);
        tahta = new Tahta();
    }

    public void oyna(){
        int sutun, oyuncuIndeks = 0,satir;
        int[] tempreturn;
        while (true){
            if (oyuncuIndeks == 0){
                tahta.goster();
            }if (oyuncuIndeks == 1){
                tahta.goster();
            }
            tempreturn = oyuncular[oyuncuIndeks].oyna(tahta);
            satir=tempreturn[0] ;
            sutun=tempreturn[1] ;


            tahta.birak(satir,sutun, oyuncular[oyuncuIndeks].getirRenk());
            if (tahta.oyunBitti()==2){
                System.out.println(oyuncular[0].getirKazanmaCumlesi());
               
            }if (tahta.oyunBitti()==1){
                System.out.println(oyuncular[1].getirKazanmaCumlesi());
               
            }
            oyuncuIndeks = (oyuncuIndeks + 1) % 2;
        }
    }
}
