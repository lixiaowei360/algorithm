package com.example.zlx;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class ConnectPoint {

    private int [][] direction= {{0,1},{0,-1},{1,0},{-1,0}}; //分别对应下,上,右,左
    @Test
    public void productPoint(){
      //  int [][] twoDimension = productTwoDimension(4);  这个是随机生成的二维数组,特征不明显,看不出效果,使用下边的特征明显
        int [][] twoDimension = productFiexdTwoDimension();//固定222的数据特征明显

        findConnected(twoDimension,4,2,2);

    }
    void findConnected(int[][] array, int n, int x, int y) {
        int tempInt = array[y][x];
        System.out.println("("+x+","+y+")");
        array[y][x] = -1;

        for(int i = 0; i < 4; i++){
            if (x+direction[i][0] < n && x+direction[i][0] >= 0){
                if (y+direction[i][1] >= 0&& y+direction[i][1] < n){
                    if(array[y+direction[i][1]][x+direction[i][0]] == tempInt){
                        findConnected(array,n,x+direction[i][0],y+direction[i][1]);
                    }
                }
            }
        }
            return ;
    }
    public int [][] productTwoDimension(int N){
        Random rand = new Random();
       int arrayInt[][] = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                arrayInt[i][j] = rand.nextInt(10);
                System.out.print(arrayInt[i][j] + " ");
            }
            System.out.println("");
        }

        return arrayInt;
    }

    public int[][]productFiexdTwoDimension(){
        int arrayInt[][] = {{1,5,2,1},{3,5,5,6},{7,5,1,1},{2,5,1,1}};
        return  arrayInt;
    }
}
