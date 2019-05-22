/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokuztas;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Komsular {
    
    public static int[][] getKomsular(int x,int y) throws Exception {
        if (x < 0 || x > 2|| y> 9|| y > 0) {
            throw new Exception("input not in valid region");
        }

        switch (x) {
            case 0:
                switch (y) {
                    case 0:
                        return new int[][]{{0, 1},{1, 0},{0, 7}};
                    case 1:
                        return new int[][]{{0, 0},{1, 1},{0, 2}};
                    case 2:
                        return new int[][]{{0, 1},{1, 2},{0, 3}};
                    case 3:
                        return new int[][]{{0, 2},{1,3},{0, 4}};
                    case 4:
                        return new int[][]{{0, 3},{1, 4},{0, 5}};
                    case 5:
                        return new int[][]{{0, 4},{1, 5},{0, 6}};
                    case 6:
                        return new int[][]{{0, 5},{1, 6},{0, 7}};
                    case 7:
                        return new int[][]{{0, 6},{1, 7},{0, 0}};
                    default:
                        return new int[][]{};
                }    
            case 1:
                switch (y) {
                    case 0:
                        return new int[][]{{0, 0},{2, 0},{1, 7},{1, 1}};
                    case 1:
                        return new int[][]{{0, 1},{2, 1},{1, 0},{1, 2}};
                    case 2:
                        return new int[][]{{0, 2},{2, 2},{1, 1},{1, 3}};
                    case 3:
                        return new int[][]{{0, 3},{2, 3},{1, 2},{1, 4}};
                    case 4:
                        return new int[][]{{0, 4},{2, 4},{1, 3},{1, 5}};
                    case 5:
                        return new int[][]{{0, 5},{2, 5},{1, 4},{1, 6}};
                    case 6:
                        return new int[][]{{0, 6},{2, 6},{1, 5},{1, 7}};
                    case 7:
                        return new int[][]{{0, 7},{2, 7},{1, 6},{1, 0}};
                    default:
                        return new int[][]{};
                }   
                
            case 2:
                switch (y) {
                    case 0:
                        return new int[][]{{1, 0},{2, 1},{2, 7}};
                    case 1:
                        return new int[][]{{1, 1},{2, 2},{2, 0}};
                    case 2:
                        return new int[][]{{1, 2},{2, 3},{2, 1}};
                    case 3:
                        return new int[][]{{1, 3},{2, 4},{2, 2}};
                    case 4:
                        return new int[][]{{1, 4},{2, 5},{2, 3}};
                    case 5:
                        return new int[][]{{1, 5},{2, 6},{2, 4}};
                    case 6:
                        return new int[][]{{1, 6},{2, 7},{2, 5}};
                    case 7:
                        return new int[][]{{1, 7},{2, 1},{2, 6}};
                    default:
                        return new int[][]{};
                }    
           
            default:
                return new int[][]{};
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] arr = Komsular.getKomsular(5,2);

        for (int i=0 ;i<3;i++) {
            for (int y=0 ;y<5;y++) {
                 System.out.println(arr[i][y]);
            }
           
        }

//        int[] arr = new int[]{1,2,3};
    }
}
