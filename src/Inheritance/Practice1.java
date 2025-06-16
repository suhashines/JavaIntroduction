package Inheritance;

class Figure {
    private double d1, d2;
	
    Figure(double a, double b) {
        this.d1 = a;
        this.d2 = b;
    }

    public String area() {
        return "Area for the figure is undefined 0.0" ;
    }

    // your code

    // getter method

    protected double getHeight(){
        return d1 ;
    }

    protected double getWidth(){
        return d2 ;
    }

}

class Rectangle extends Figure{

    Rectangle(double d1,double d2){
        super(d1,d2);
    }

    public String area(){
        // this method is being overridden
        double a = getHeight()*getWidth() ;
        return "Area for Rectangle: "+a ;
    }
}

class Triangle extends Figure{

    Triangle(double d1,double d2){
        super(d1,d2);
    }

    public String area(){
        // this method is being overridden
        double a = 0.5*getHeight()*getWidth() ;
        return "Area for Triangle: "+a ;
    }
}

// your code

class FindAreas {
    public static void main(String[] args) {
        Figure f = new Figure(10, 10);

        Rectangle r = new Rectangle(9, 5);  // rectangle class
        Triangle t = new Triangle(10, 8);   // triangle class

        Figure ref;
        ref = f;
        System.out.println(ref.area()); // f.area() -> figure class - area method call

        ref = r;   // Figure ref -> Rectangle r , Triangle t -> dynamic method dispatch

        System.out.println(ref.area());  // r.area()

        ref = t;
        System.out.println(ref.area()); // t.area()
    }
}

/* main output
Area for Figure is undefined: 0.0
Area for Rectangle: 45.0
Area for Triangle: 40.0
 */