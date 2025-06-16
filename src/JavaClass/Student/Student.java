package JavaClass.Student;

public class Student {
    // no modifier
    private String name ;
    private int id ;
    private double credit ;
    private double cgpa ;

    public Student(String name,int id,double credit,double cgpa){

        // this pointer 
        this.name = name ;
        this.id = id ;
        this.credit = credit ;
        this.cgpa = cgpa ;
    }

    public void showInfo(){
        System.out.println("Name : " + name);
        System.out.println("id : " +id);
        System.out.println("credit earned so far : " + credit);
        System.out.println("cgpa : " + cgpa);
        System.out.println("-------------------");
    }

    public void change(String name){
        this.name = name ;
    }

    public void change(int id){
        this.id = id ;
    }

    private double cgpaCalculator(double credit,double cgpa){
           // summation fixi/n 
           
          double finalCGPA = (this.credit*this.cgpa + credit*cgpa)/(this.credit+credit);
          return finalCGPA;

    }

    public void addTermResult(double credit,double cgpa){

        this.cgpa = cgpaCalculator(credit,cgpa);

        // credit update where????
        this.credit += credit ;
    }
}
