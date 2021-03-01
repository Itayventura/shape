public class Triangle extends AbstractShape{
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public boolean isRegular() {
        Line base = new Line(a, b);
        return Math.abs(base.length() - new Line(a, c).length()) < 0.00001 &&
                Math.abs(base.length() - new Line(b, c).length()) < 0.00001;
    }

    @Override
    public double area() {
        Line base = new Line(a, b);
        return base.length() * base.distance(c) / 2;
    }

    @Override
    public double perimeter() {
        return new Line(a, b).length() +
                new Line(a, c).length() +
                new Line(b, c).length();
    }

    @Override
    public Point getCenter() {
        Line median1 = new Line(new Line(a, b).getCenter(), c);
        Line median2 = new Line(new Line(a,c).getCenter(), b);
        return median1.getIntersection(median2);
    }
}
