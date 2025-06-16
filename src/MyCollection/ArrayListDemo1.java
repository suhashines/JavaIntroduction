package MyCollection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo1 {

    public static void main(String[] args) {
        // create an array list
        List<String> al = new ArrayList<>();
        System.out.println("Initial size of al: " + al.size());

        // add elements to the array list
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        al.remove(1);

        System.out.println("after removing A "+al);
        al.add(1, "X");

        System.out.println("Size of al after additions: " + al.size());

        // display the array list
        System.out.println("Contents of al: " + al);

        for(String str:al){
            System.out.println(str);
        }

        System.out.println("");

        // Remove elements from the array list
        al.remove("F");
        al.remove(2);

        System.out.println("Size of al after deletions: " + al.size());

        System.out.println("Contents of al: " + al);
    }
}