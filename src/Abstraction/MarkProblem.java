package Abstraction;
/*
 */

class Pair{
    String subject ;
    double marks ;

    Pair(String subject,double marks){
        this.subject = subject ;
        this.marks = marks ;
    }
}


abstract class Curriculum {

    protected Pair[]subjectMarks ;


    public void addSubject(String subject,int index){

        subjectMarks[index] = new Pair(subject,0);
    }


    abstract double getPercentage();

    // you are not allowed make any changes to Pair and Curriculum Class


}


class PrimaryCurriculum extends Curriculum{

    private static final int SIZE = 3 ;

    PrimaryCurriculum(String sub1,String sub2,String sub3){

        subjectMarks = new Pair[SIZE];

        addSubject(sub1,0);
        addSubject(sub2,1);
        addSubject(sub3,2);

    }


    public void setMark(int i, int i1, int i2) {

        subjectMarks[0].marks = i ;
        subjectMarks[1].marks = i1 ;
        subjectMarks[2].marks = i2 ;
    }

    @Override
    double getPercentage() {

        double sum =0 ;

        for(Pair p:subjectMarks){
            sum += p.marks;
        }

        return sum/SIZE ;
    }
}


class SecondaryCurriculum extends Curriculum{

    private static final int SIZE = 4 ;

    SecondaryCurriculum(String sub1,String sub2,String sub3,String sub4){

        subjectMarks = new Pair[SIZE];

        addSubject(sub1,0);
        addSubject(sub2,1);
        addSubject(sub3,2);
        addSubject(sub4,3);

    }


    public void setMark(int i, int i1, int i2,int i3) {

        subjectMarks[0].marks = i ;
        subjectMarks[1].marks = i1 ;
        subjectMarks[2].marks = i2 ;
        subjectMarks[3].marks = i2 ;
    }

    @Override
    double getPercentage() {

        double sum =0 ;

        for(Pair p:subjectMarks){
            sum += p.marks;
        }

        return sum/SIZE ;
    }
}


public class MarkProblem {

    public static void main(String[] args) {

        Curriculum c = new PrimaryCurriculum("Bangla","Science","Mathematics");

        ((PrimaryCurriculum)c).setMark(100,90,80) ;

        System.out.println("Percentage obtained in Primary: " +  c.getPercentage());


        c = new SecondaryCurriculum("Bangla","Science","Mathematics","English");


        ((SecondaryCurriculum)c).setMark(100,90,80,70) ;


        System.out.println("Percentage obtained in Secondary: " +  c.getPercentage());


    }
}
