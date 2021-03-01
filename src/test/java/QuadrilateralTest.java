import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadrilateralTest {

    private static Quadrilateral square;
    private static Quadrilateral rectangle;
    private static Quadrilateral trapezoid;
    private static Quadrilateral parallelogram;
    private static Quadrilateral quadrilateral;


    @BeforeAll
    static void setUp() {
        square = new Quadrilateral(new Point(0,0), new Point(1,0), new Point(1,1), new Point(0,1));
        rectangle = new Quadrilateral(new Point(0,0), new Point(2,0), new Point(2,1), new Point(0,1));
        trapezoid = new Quadrilateral(new Point(0,0), new Point(2,0), new Point(2,1), new Point(1,1));
        parallelogram = new Quadrilateral(new Point(0,0), new Point(2,0), new Point(3,1), new Point(1,1));
        quadrilateral = new Quadrilateral(new Point(0,0), new Point(1,1), new Point(0,4), new Point(-1,1));
    }

    @Test
    void isRegular() {
        assertTrue(square.isRegular());
        assertFalse(rectangle.isRegular());
        assertFalse(trapezoid.isRegular());
        assertFalse(parallelogram.isRegular());
        assertFalse(quadrilateral.isRegular());
    }

    @Test
    void area() {
        assertEquals(1, square.area());
        assertEquals(2, rectangle.area());
        assertEquals(1.5, trapezoid.area());
        assertEquals(2, parallelogram.area());
        assertEquals(4, quadrilateral.area());
    }

    @Test
    void perimeter() {
        assertEquals(4, square.perimeter());
        assertEquals(6, rectangle.perimeter());
        assertEquals(4+Math.sqrt(2), trapezoid.perimeter());
        assertEquals(4 + 2*Math.sqrt(2), parallelogram.perimeter());
        assertEquals(2*Math.sqrt(2)+2*Math.sqrt(10), quadrilateral.perimeter());
    }

    @Test
    void getCenter() {
        Point expected = new Point(0.5, 0.5);
        assertTrue(Math.abs(square.getCenter().getX()-expected.getX()) < 0.000001) ;
        assertTrue(Math.abs(square.getCenter().getY()-expected.getY()) < 0.000001) ;

        expected = new Point(1, 0.5);
        assertTrue(Math.abs(rectangle.getCenter().getX()-expected.getX()) < 0.000001) ;
        assertTrue(Math.abs(rectangle.getCenter().getY()-expected.getY()) < 0.000001) ;

        expected = new Point(1.5, 0.5);
        assertTrue(Math.abs(parallelogram.getCenter().getX()-expected.getX()) < 0.000001) ;
        assertTrue(Math.abs(parallelogram.getCenter().getY()-expected.getY()) < 0.000001) ;

        expected = new Point(0, 1);
        assertTrue(Math.abs(quadrilateral.getCenter().getX()-expected.getX()) < 0.000001) ;
        assertTrue(Math.abs(quadrilateral.getCenter().getY()-expected.getY()) < 0.000001) ;



    }
}