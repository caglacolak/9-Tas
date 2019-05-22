package DokuzTas;

/*Oyuna göre değişecek*/
public class Hareket {
    private int satir,sutun;

    public Hareket(int satir,int sutun){
        this.satir=satir;
        this.sutun = sutun;
    }
    public int getirSatir(){
        return satir;
    }
    
    public int getirSutun(){
        return sutun;
    }
    
}
