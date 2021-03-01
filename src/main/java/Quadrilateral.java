public class Quadrilateral implements Shape{
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    //todo
    @Override
    public boolean isRegular() {
        Line base = new Line(a, b);
        return (Math.abs(base.length() - new Line(a, d).length()) < 0.00001 &&
                Math.abs(base.length() - new Line(b, c).length()) < 0.00001 &&
                Math.abs(base.length() - new Line(c, d).length()) < 0.00001) &&
                new Line(a, c).length() == new Line(b, d).length();
    }

    @Override
    public double area() {
        return new Triangle(a,b,c).area() + new Triangle(a,c,d).area();
    }

    @Override
    public double perimeter() {
        return new Line(a, b).length() +
                new Line(a, d).length() +
                new Line(b, c).length() +
                new Line(c, d).length();
    }

    @Override
    public Point getCenter() {
        Line diagonal1 = new Line(a, c);
        Line diagonal2 = new Line(b, d);
        return diagonal1.getIntersection(diagonal2);
    }
}
