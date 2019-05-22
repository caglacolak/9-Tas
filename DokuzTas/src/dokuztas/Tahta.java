package DokuzTas;

import java.util.ArrayList;

/*Oyuna göre değişecek*/
public class Tahta {
    private Tas tahta[][];
    private int satir, sutun;
    private Renk oynamaSirasiSimdiBuRenkte;
    int mavisay=0,sarisay=0;
    public Tahta(){
        this.satir = 3;
        this.sutun = 8;
        tahta = new Tas[satir][sutun];
        for (int i = 0; i < satir; i++){
            tahta[i] = new Tas[sutun];
            for (int j = 0; j < sutun; j++){
                tahta[i][j] = new Tas(Renk.BOS);
            }
        }
        oynamaSirasiSimdiBuRenkte = Renk.MAVI;

    }
    public boolean rakipTasiKaldir(int x,int y) {
        if (getTahta()[x][y].getRenk() == Renk.BOS) {
            return false;
        }
        if (getTahta()[x][y].getRenk() == oynamaSirasiSimdiBuRenkte) {
            return false;
        }
        if (!CuzMu(x,y,tahta[x][y].getRenk())) {
            return false;
        }
        tahta[x][y] = new Tas(Renk.BOS);
        
        return true;
    }
     public boolean tasKoy(int x,int y, Tas tas) throws Exception {
        if (x < 0 || x > 3|| y > 8|| x < 0) {
            throw new Exception("input not in valid region");
        }
        if (getTahta()[x][y].getRenk() != Renk.BOS) {
            return false;
        }

        tahta[x][y] = tas;

        if(CuzMu(x, y,getTahta()[x][y].getRenk())){
            rakipTasiKaldir(x,y);
        }

        return true;
    }
    public ArrayList<Hareket> olasiHareketler(Renk renk) throws Exception {
        if (renk == Renk.BOS) {
            throw new Exception("Renk BOS olamaz");
        }

        Hareket olasiHareket;
        ArrayList<Hareket> hareketler = new ArrayList<Hareket>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if (getTahta()[i][j].getRenk().equals(Renk.BOS)) {
                    continue;
                }
                if (!tahta[i][j].getRenk().equals(renk)) {
                    continue;
                }

                int[] arr = Komsular.getKomsular(i,j);
                for (int k : arr) {
                    if (!tahta[j][i].getRenk().equals(Renk.BOS)) {
                        continue;
                    }
                    olasiHareket = new Hareket(i, j);
                    hareketler.add(olasiHareket);
                }
            }
        }
        return hareketler;
    }
    

    public int getirSutun(){
        return sutun;
    }
    public int getirSatir(){
        return satir;
    }

    public boolean sutunDoluMu(int satirIndex,int sutunIndeks){
        if(getTahta()[satirIndex][sutunIndeks].getRenk() != Renk.BOS){
            return true;
        }
        return false;
    } 
    public boolean RenkDogruMu(int satirIndex,int sutunIndeks,Renk renk){
        if(getTahta()[satirIndex][sutunIndeks].getRenk() == renk){
            return true;
        }
        return false;
    }

    public boolean doluMu(){
        for (int i = 0; i < satir; i++){
            for (int j = 0; j < sutun; j++){
                if (!sutunDoluMu(i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    public void geriAl(int sutun){
        Tas yeniTas;
        for (int i = satir - 1; i >= 0; i--){
            if (getTahta()[i][sutun].getRenk() != Renk.BOS){
                yeniTas = new Tas(Renk.BOS);
                tahta[i][sutun] = yeniTas;
                break;
            }
        }
    }

    public void birak(int x,int y, Renk renk){
        Tas yeniTas;
       
        if (getTahta()[x][y].getRenk() == Renk.BOS){
            yeniTas = new Tas(renk);
            tahta[x][y] = yeniTas;
            
       }
        
    }

    private boolean dogruHucreMi(int satirNo, int sutunNo){
        return (satirNo >= 0 && satirNo < satir && sutunNo >= 0 && sutunNo < sutun);
    }

     private boolean CuzMu(int satirNo, int sutunNo, Renk renk){
        if(sutunNo==0){
            if (getTahta()[satirNo][sutunNo+1].getRenk() == renk&&getTahta()[satirNo][sutunNo+2].getRenk() == renk){
                return true;                
            }if (getTahta()[satirNo][7].getRenk() == renk&&getTahta()[satirNo][6].getRenk() == renk){
                return true;                
            }if (satirNo==0){
                if (getTahta()[satirNo+1][sutunNo].getRenk() == renk && getTahta()[satirNo+2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==1){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo+1][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==2){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo-2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }
        } if(sutunNo==2&&sutunNo==4){
            if (getTahta()[satirNo][sutunNo+1].getRenk() == renk&&getTahta()[satirNo][sutunNo+2].getRenk() == renk){
                return true;                
            }if (getTahta()[satirNo][sutunNo-1].getRenk() == renk&&getTahta()[satirNo][sutunNo-2].getRenk() == renk){
                return true;                
            }if (satirNo==0){
                if (getTahta()[satirNo+1][sutunNo].getRenk() == renk && getTahta()[satirNo+2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==1){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo+1][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==2){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo-2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }
        }if(sutunNo==6){
            if (getTahta()[satirNo][sutunNo+1].getRenk() == renk&&getTahta()[satirNo][sutunNo+2].getRenk() == renk){
                return true;                
            }if (getTahta()[satirNo][7].getRenk() == renk&&getTahta()[satirNo][0].getRenk() == renk){
                return true;                
            }if (satirNo==0){
                if (getTahta()[satirNo+1][sutunNo].getRenk() == renk && getTahta()[satirNo+2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==1){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo+1][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==2){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo-2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }
        }else{
            if (getTahta()[satirNo][sutunNo+1].getRenk() == renk&&getTahta()[satirNo][sutunNo-1].getRenk() == renk){
                return true;                
            }if (satirNo==0){
                if (getTahta()[satirNo+1][sutunNo].getRenk() == renk && getTahta()[satirNo+2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==1){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo+1][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }if (satirNo==2){
                if (getTahta()[satirNo-1][sutunNo].getRenk() == renk && getTahta()[satirNo-2][sutunNo].getRenk() == renk){
                return true;                
                }                   
            }
        }
        
        return false;
    }
     
    private int ucuAyniDizi(int satirNo, int sutunNo, Renk renk){
        int sayi, x, y, ucluSayisi = 0;
        int ekleme[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int k = 0; k < 8; k++){
            sayi = 0;
            for (int l = 1; l < 4; l++){
                x = satirNo + l * ekleme[k][0];
                y = sutunNo + l * ekleme[k][1];
                if (dogruHucreMi(x, y) && getTahta()[x][y].getRenk() == renk){
                    sayi++;
                }
            }
            if (sayi == 2){
                ucluSayisi++;
            }
        }
        return ucluSayisi;
    }

    private Renk hucreyiKontrolEt(int satirNo, int sutunNo){
        int sayi, x, y;
        int ekleme[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int k = 0; k < 8; k++){
            sayi = 0;
            for (int l = 1; l < 4; l++){
                x = satirNo + l * ekleme[k][0];
                y = sutunNo + l * ekleme[k][1];
                if (dogruHucreMi(x, y) && getTahta()[x][y].getRenk() == getTahta()[satirNo][sutunNo].getRenk()){
                    sayi++;
                }
            }
            if (sayi == 3 && getTahta()[satirNo][sutunNo].getRenk() != Renk.BOS){
                return getTahta()[satirNo][sutunNo].getRenk();
            }
        }
        return Renk.BOS;
    }

    public int ucuAyniDizi(Renk renk){
        int toplam = 0;
        for (int i = 0; i < satir; i++){
            for (int j = 0; j < sutun; j++){
                toplam += ucuAyniDizi(i, j, renk);
            }
        }
        return toplam;
    }

    public Renk dorduAyniDizi(){
        Renk sonuc;
        for (int i = 0; i < satir; i++){
            for (int j = 0; j < sutun; j++){
                sonuc = hucreyiKontrolEt(i, j);
                if (sonuc != Renk.BOS){
                    return sonuc;
                }
            }
        }
        return Renk.BOS;
    }

    public int oyunBitti(){
        
        for(int i=0;i<3;i++){
            for(int j=0;j<8;j++){
                if(tahta[i][j].getRenk()==Renk.MAVI){
                    mavisay++;
                    
                }if(tahta[i][j].getRenk()==Renk.SARI){
                    sarisay++;
                    
                }
            }
        }
        if(mavisay<3){
            return 2;

        }if(sarisay<3){
            return 1;

        }else{
            return 0;

        }
    }

    public void goster(){
        for (int i = satir - 1; i >= 0; i--){
            for (int j = 0; j < sutun; j++){
                switch (getTahta()[i][j].getRenk()){
                    case SARI:
                        System.out.print("X");
                        break;
                    case MAVI:
                        System.out.print("O");
                        break;
                    case BOS:
                        System.out.print("_");
                        break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * @return the tahta
     */
    public Tas[][] getTahta() {
        return tahta;
    }
}
