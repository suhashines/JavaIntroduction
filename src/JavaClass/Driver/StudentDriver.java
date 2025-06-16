package JavaClass.Driver;

import JavaClass.Student.Batch;
import JavaClass.Student.Student;

public class StudentDriver {

    public static void main(String[] args) {

        Student s1 = new Student("Tamim Iqbal", 1905131, 39, 3.56);
        Student s2 = new Student("Liton Das", 1905150, 39, 3.52);

        s1.addTermResult(19, 3.85);


        System.out.println("--Printing list of all students--\n");
//        s1.showInfo();
//        s2.showInfo();

        Batch b = new Batch();

        b.addStudent(s1);
        b.addStudent(s2);

        b.showAllStudents();

    }
}
