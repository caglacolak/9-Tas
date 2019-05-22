package DokuzTas;

import java.util.Scanner;

/*Oyuna göre değişecek*/
public class InsanOyuncu extends Oyuncu {

    public InsanOyuncu(String ad){
        super(ad, Renk.SARI, "YOU BEAT ME",9);
    }

    public int[] oyna(Tahta tahta){
        int sutun,satir,routee;
        int[] tempreturn=new int[2];
        System.out.println(" satir seç:");
        Scanner s = new Scanner(System.in);
        satir = s.nextInt();
        System.out.println("sutun seç:");
        Scanner sut = new Scanner(System.in);
        sutun = sut.nextInt();
        while (sutun > 8 ||satir > 3 ||sutun < 0 ||satir < 0 || sutun >= tahta.getirSutun() || tahta.sutunDoluMu(satir,sutun)||tahta.RenkDogruMu(satir, sutun,Renk.SARI)){
            System.out.println("Kocum yanlis oynadin. Bir daha oyna:");
            System.out.println(" satir seç:");
            s = new Scanner(System.in);
            satir = s.nextInt();
            System.out.println("sutun seç:");
            sut = new Scanner(System.in);
            sutun = sut.nextInt();
        }if(satir==0){
            if(sutun==0){
                System.out.println("rota seç:1-üst sütuna 2-alt sütuna 3-üst satıra");
                Scanner route = new Scanner(System.in);
                routee = route.nextInt();
                while (routee < 0 ||routee > 3 ){
                    System.out.println("Kocum yanlis oynadin. Bir daha oyna:");
                    System.out.println("rota seç:1-üst sütuna 2-alt sütuna 3-üst satıra");
                    route = new Scanner(System.in);
                    routee = route.nextInt();
                    if(routee==1){
                        
                    }
                }
        }if(satir==1){
            
        }if(satir==2){
            
        }
        tempreturn[0]=satir;
        tempreturn[1]=sutun;
        return tempreturn;
    }
        return tempreturn;

}
}
