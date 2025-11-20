package Modifiers.Base;

public class Circle extends AbstractShape{

    private final double radius = 1.0 ;
    @Override
    public double area() {
        return 3.14*radius*radius;
    }
}
