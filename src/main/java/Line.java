public class Line {
    Point a;
    Point b;

    public Line(Point a, Point b){
        this.a = a;
        this.b = b;
    }

    public double length(){
        double x = Math.abs(a.getX() - b.getX());
        double y = Math.abs(a.getY() - b.getY());
        return Math.sqrt(x*x + y*y);
    }

    public double distance(Point point){
        Point closest = getClosest(point);
        return getSlope() == Double.POSITIVE_INFINITY? Math.abs(point.getX()-a.getX()):
                new Line(point, closest).length();
//                Math.abs(getSlope()*point.getX()-point.getY()+getCross())/(getSlope()*getSlope()+1);
    }

    public Point getClosest(Point point){
        if(getSlope() == Double.POSITIVE_INFINITY){
            return new Point(a.getX(), point.getY());
        }
        double x = ((point.getX() +getSlope()*point.getY()) - getSlope()*getCross())/(getSlope()*getSlope() + 1);
        double y = (getSlope()*(point.getX() + getSlope()*point.getY()) +getCross())/(getSlope()*getSlope() + 1);
        return new Point(x, y);
    }

    public double getSlope(){
        return (b.getX()-a.getX()) != 0? (b.getY() - a.getY())/(b.getX()-a.getX()):Double.POSITIVE_INFINITY;
    }

    public double getCross(){
         return getSlope() == Double.POSITIVE_INFINITY? 0:-getSlope()*a.getX() + a.getY();
    }

    public Point getCenter(){
        return new Point((a.getX() + b.getX())/2, (a.getY() +b.getY())/2);
    }

    public Point getIntersection(Line other){
        double x;
        double y;
        if(this.getSlope() == Double.POSITIVE_INFINITY){
            x = a.getX();
            y = other.getSlope()*x + other.getCross();
        } else if (other.getSlope() == Double.POSITIVE_INFINITY) {
            x = other.a.getX();
            y = this.getSlope()*x + this.getCross();
        } else {
            x = (-this.getCross() + other.getCross()) / (this.getSlope() - other.getSlope());
            y = this.getSlope() * x + this.getCross();
        }
        return new Point(x, y);
    }

    @Override
    public String toString(){
        return a +"->" + b;
    }
}