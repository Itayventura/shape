public interface Shape extends Comparable<Shape> {

    boolean isRegular();
    double area();
    double perimeter();
    Point getCenter();
    double getDistance(Shape other);

}
