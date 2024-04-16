package application;

import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] mat = new int[n][n];
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[row].length; col++){
                mat[row][col] = sc.nextInt();
            }
        }

        for(int i = 0; i < n ; i++){
            System.out.print(mat[i][i] + ", ");
        }

        System.out.println("---");
        int negativeNumbersAmount = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                if (mat[row][col] < 0){
                    negativeNumbersAmount +=1;
                }
            }
        }

        System.out.print("Negative Numbers: " + negativeNumbersAmount);

        sc.close();
    }
}