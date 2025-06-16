package JavaClass.Student;

public class Batch {

    Student[]students ;  //only a reference
    private static int TOTAL_STUDENTS = 1200 ;

    int count ;

    public Batch(){
        students = new Student[TOTAL_STUDENTS];
        count = 0 ;
    }

    private void allocate(){


        //previous students must be stored in a temporary location

        students = new Student[TOTAL_STUDENTS*2];
        // this is strongly prohibited

        TOTAL_STUDENTS *= 2;
    }

    public void addStudent(Student student){

        if(count==TOTAL_STUDENTS){
            System.out.println("Cannot add any more students");
            allocate();
            return;
        }

        students[count++] = student;


    }

    public void showAllStudents(){

        for(int i=0;i<count;i++){
            Student student = students[i] ;
            student.showInfo();
        }
    }


}
