package Array;

import java.util.Scanner;

public class MultiDimension {

    public static void main(String[] args) {

        // { {1,2,3,4}, {1,2,3} , {1,2} , {1} }

        Scanner scn = new Scanner(System.in);

        int rows = scn.nextInt();

        int [][]arr = new int[rows][] ;

        for(int i=0;i<rows;i++){

            System.out.print("enter size of "+(i+1)+" th row : ");
            int columns = scn.nextInt();

            arr[i] = new int[columns] ;

            for(int j=0;j<columns;j++){
                int num = scn.nextInt();
                arr[i][j] = num ;
            }
        }

        // printing the elements

        for(int i=0;i<rows;i++){

            int columnSize = arr[i].length ;

            for(int j=0;j<columnSize;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
