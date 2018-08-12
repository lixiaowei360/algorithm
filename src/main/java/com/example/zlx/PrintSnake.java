package com.example.zlx;

import org.junit.jupiter.api.Test;

public class PrintSnake {

    @Test
    public  void callPrintfCircle(){
        printfCircle(4);
    }

    public void printfCircle(int N){
        int [][] twoDimension = productTwoDimension(N);
        int sum = N * N;
        int sumRecord = 0 ;
        int startX = 0, startY = 0;
        while(sumRecord != sum){

            if (startX < N && startY < N){
                System.out.println(twoDimension[startY][startX]);
            }
            sumRecord++;
            twoDimension[startY][startX] = -1;

            if (startX + 1< N && twoDimension[startY][startX+1] != -1){
                startX++;
            }else if (startY + 1< N && twoDimension[startY+1][startX] != -1){
                startY++;
            }else if(startX - 1 >= 0 && twoDimension[startY][startX-1] != -1){
                startX--;
            }else if (startY - 1 >= 0 && twoDimension[startY-1][startX] != -1){
                startY--;
            }
        }
    }

    public int [][] productTwoDimension(int N){
        int arrayInt[][] = new int[N][N];
        int record = 1;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                arrayInt[i][j] = record;
                record++;
            }
        }
        return arrayInt;
    }
}
