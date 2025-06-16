package MyCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TestClassComparator implements Comparator<TestClass> {
    @Override
    public int compare(TestClass o1, TestClass o2) {

        // ascending order of name
        // if two names are same then ascending order of id

        if(o1.getName().equals(o2.getName())){
            return o1.getId() - o2.getId();
        }

        return o1.getName().compareTo(o2.getName());

    }
}

class TestClass implements Comparable<TestClass> {

    private String name;
    private int id;

    TestClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(TestClass o) {
        // ascending order of id

       //return id - o.getId();

        // ascending lexicographical ordering
        // str 1 = abcd
        // str2 = abce

        //return o.getName().compareTo(name);

        // ascending order of id
        // if two ids are same, then descending lexicographical order of name

        if(id==o.getId()){

            return o.getName().compareTo(name);
        }else{
            return id - o.getId();
        }
    }
}

class ComparatorDemo {

    public static void printList(List<TestClass> al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i).getId() + ", " + al.get(i).getName());
        }
        System.out.println();
    }

    public static void main(String args[]) {

        List<TestClass> al = new ArrayList<>();

        al.add(new TestClass(1, "C"));
        al.add(new TestClass(3, "A"));
        al.add(new TestClass(2, "E"));
        al.add(new TestClass(5, "B"));
        al.add(new TestClass(4, "D"));
        al.add(new TestClass(6, "F"));
        al.add(new TestClass(7,"A"));
        al.add(new TestClass(8,"D"));

        printList(al);

        Collections.sort(al);  // this requires implementing Comparable => compareTo()

        System.out.println("Using Comparable Interface");
        printList(al);

        Collections.sort(al, new TestClassComparator());  // this requires implementing Comparator interface

        System.out.println("Using Comparator Interface");
        printList(al);
    }
}