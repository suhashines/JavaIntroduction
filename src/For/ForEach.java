package For;

import java.util.Scanner;

public class ForEach {

    public static void main(String[] args) {

        // given a 2D array, find sum of each row


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

        // sum

        for(int[]a : arr){   // arr 2d ->  1 2 3 4 -> 1st row

            int sum = 0 ;                 // -> 1 2 3 _. 2nd row

            for(int num : a){
                sum += num ;
            }

            System.out.println(sum);

        }
    }
}
