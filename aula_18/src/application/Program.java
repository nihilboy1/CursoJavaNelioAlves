package application;

import java.util.Locale;
import java.util.Scanner;

public class Program{
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o número de linhas: ");
        int rowsNumber = sc.nextInt();
        System.out.print("Informe o número de colunas: ");
        int colsNumber = sc.nextInt();

        int[][] matrix = new int[rowsNumber][colsNumber];

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.printf("ROW #%d, COL #%d: ", row, col);
                matrix[row][col] = sc.nextInt();
            }
        }

        int pointNumber = sc.nextInt();

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                if (matrix[row][col] == pointNumber){
                    System.out.println("--------------------------------------");
                    System.out.printf("POSITION: ROW #%d, COL #%d: \n", row, col);

                    if(col-1 >= 0){
                        System.out.println("LEFT: " + matrix[row][col -1]);
                    }else {
                        System.out.println("LEFT: INVALID");
                    }

                    if(col+ 1 <= (matrix[row].length -1)){
                        System.out.println("RIGHT: " + matrix[row][col +1]);
                    }else {
                        System.out.println("RIGHT: INVALID");
                    }

                    if(row - 1 >= 0){
                        System.out.println("UP: " + matrix[row - 1][col]);
                    }else {
                        System.out.println("UP: INVALID");
                    }

                    if(row + 1 <= (matrix.length +1)){
                        System.out.println("DOWN: " + matrix[row + 1][col]);
                    }else {
                        System.out.println("DOWN: INVALID");
                    }


                }
            }
        }





        sc.close();
    }
}