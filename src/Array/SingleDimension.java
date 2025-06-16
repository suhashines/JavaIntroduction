package Array;

import java.util.Scanner;

public class SingleDimension {

    public static void main(String[] args) {

        // take array size and its elements from the user and sort the array in ascending order

        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();

        int []arr = new int[count];

        for(int i=0;i<count;i++){
            System.out.println("enter "+(i+1)+" th number : ");
            int num = scn.nextInt();
            arr[i] = num ;
        }

        //sorting -> bubble sort

        for(int i=0;i<count;i++){

            for(int j=i+1;j<count;j++){

                if(arr[j]<arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // printing the sorted array

        for(int i=0;i<count;i++){

            System.out.print(arr[i]+ " ");
        }
    }
}
