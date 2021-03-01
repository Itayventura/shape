public class Circle extends AbstractShape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isRegular() {
        return true;
    }

    @Override
    public double area() {
        return Math.PI * radius*radius;
    }

    @Override
    public double perimeter() {
        return Math.PI*radius*2;
    }

    @Override
    public Point getCenter() {
        return center;
    }
}
