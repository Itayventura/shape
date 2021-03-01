import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AbstractShapeTest {
    private static Shape square;
    private static Shape rectangle;
    private static Shape trapezoid;
    private static Shape parallelogram;
    private static Shape quadrilateral;
    private static Shape t1;
    private static Shape t2;
    private static Shape t3;
    private static Shape t4;
    private static Shape t5;
    private static Shape[] shapes;


    @BeforeAll
    static void setUp() {
        square = new Quadrilateral(new Point(0,0), new Point(1,0), new Point(1,1), new Point(0,1));
        rectangle = new Quadrilateral(new Point(0,0), new Point(2,0), new Point(2,1), new Point(0,1));
        trapezoid = new Quadrilateral(new Point(0,0), new Point(2,0), new Point(2,1), new Point(1,1));
        parallelogram = new Quadrilateral(new Point(0,0), new Point(2,0), new Point(3,1), new Point(1,1));
        quadrilateral = new Quadrilateral(new Point(0,0), new Point(1,1), new Point(0,4), new Point(-1,1));
        t1 = new Triangle(new Point(0,0),
                new Point(1, 0),
                new Point(0,1));
        t2 = new Triangle(new Point(0,0), new Point(1, 0), new Point(0.5, Math.sqrt(0.75)));
        t3 = new Triangle(new Point(0,0), new Point(1, 0), new Point(1,1));
        t4 = new Triangle(new Point(1,0), new Point(1, 1), new Point(0,1));
        t5 = new Triangle(new Point(0,0), new Point(1, 1), new Point(0,1));
        shapes = new Shape[]{square, rectangle, trapezoid, parallelogram, quadrilateral, t1, t2, t3, t4, t5};
    }

    @Test
    void compareTo() {
        Arrays.sort(shapes);
        Shape first = shapes[0];
        Shape second;
        for(int i = 1; i < shapes.length; i++){
            second = shapes[i];
            assertTrue(first.compareTo(second) <= 0);
            assertTrue(first.area() <= second.area());
            first= second;

        }

    }
}