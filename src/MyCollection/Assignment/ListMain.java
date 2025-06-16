package MyCollection.Assignment;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ListMain {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        ArrayList<Integer> uniqueArrayList = removeDuplicates(arrayList);
        System.out.println("ArrayList without duplicates: " + uniqueArrayList);

        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6,7));
        int middleElement = findMiddleElement(linkedList);
        System.out.println("Middle element of LinkedList: " + middleElement);
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        // Implement this method

        Integer []ia = new Integer[list.size()];

        list.toArray(ia);

        list = new ArrayList<>();

        for(Integer i:ia){

            if(!list.contains(i)){
                list.add(i);
            }
        }

        return list ;

    }

    public static int findMiddleElement(LinkedList<Integer> list) {
        // Implement this method
        // if the list has even number of elements, for instance
        // 1 2 3 4  then there will be two middle elements 2,3 . In
        // that case return the second one.

       // list.size() = 4 , 4/2 = 2 => 3
        // list.size() = 5 , 5/2 = int( 2.5) = 2 =>3

        int size = list.size();

        int middleIndex = size/2 ;

        return list.get(middleIndex);

    }
}
