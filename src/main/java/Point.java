public class Point {
    private double x;
    private double y;

    public Point(double x, double y)
    {
    this.x = x;
    this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Point)){
            return  false;
        }
        Point otherPoint = (Point) other;
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}
