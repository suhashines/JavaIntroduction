package MyCollection;

import java.util.Arrays;
import java.util.Random;

class ArraysDemo {
    static void display(int[] array) {
        for (int j : array) System.out.print(j + " ");
        System.out.println("");
    }

    public static void main(String[] args) {

        Random r = new Random();

        // allocate and initialize array
        int[] array = new int[10];
        for (int i = 0; i < 10; i++)
            array[i] = r.nextInt(0,100);

        // display, sort, display
        System.out.print("Original contents: ");
        display(array);

        Arrays.sort(array);
        System.out.print("Sorted: ");
        display(array);


        // fill and display
        Arrays.fill(array, 2, 6, -1);
        System.out.print("After fill(): ");
        display(array);


        // sort and display
        Arrays.sort(array);
        System.out.print("After sorting again: ");
        display(array);


        // binary search for -9 and 10

        System.out.print("The value -9 is at location ");
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);

        System.out.print("The value -1 is at location ");
        index = Arrays.binarySearch(array, -1);
        System.out.println(index);
    }


}
