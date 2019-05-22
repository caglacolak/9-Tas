package DokuzTas;

/*Oyunun bittiğini anlayacak*/
public class BasitDegerlendirmeFonksiyonu implements DegerlendirmeFonksiyonu {
    private Tahta tahta;
    private Tas taht[][];
    int mavisay=0,sarisay=0;
    public BasitDegerlendirmeFonksiyonu(Tahta tahta){
        this.tahta = tahta;
    }
    public double degerlendir() {
        switch (tahta.dorduAyniDizi()){
            case SARI:return 0;
            case MAVI:return 1;
            case BOS:return 0.5;
            default:return 0.5;
        }
    }
    public double oyunbitti(){
        taht=tahta.getTahta();
        for(int i=0;i<3;i++){
            for(int j=0;j<8;j++){
                if(taht[i][j].getRenk()==Renk.MAVI){
                    mavisay++;
                    
                }if(taht[i][j].getRenk()==Renk.SARI){
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
}
