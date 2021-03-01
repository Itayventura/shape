public abstract class AbstractShape implements Shape{

    @Override
    public int compareTo(Shape other){
        double diff = this.area() - other.area();
        if (diff == 0){
            return 0;
        } else{
            return diff>0? 1:-1;
        }
    }

    @Override
    public double getDistance(Shape other){
        return new Line(this.getCenter(), other.getCenter()).length();
    }
}
