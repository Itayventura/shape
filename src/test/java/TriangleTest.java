import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private static Triangle t1;
    private static Triangle t2;
    private static Triangle t3;
    private static Triangle t4;
    private static Triangle t5;

    @BeforeEach
    void setUp() {

        t1 = new Triangle(new Point(0,0),
                new Point(1, 0),
                new Point(0,1));
        t2 = new Triangle(new Point(0,0), new Point(1, 0), new Point(0.5, Math.sqrt(0.75)));
        t3 = new Triangle(new Point(0,0), new Point(1, 0), new Point(1,1));
        t4 = new Triangle(new Point(1,0), new Point(1, 1), new Point(0,1));
        t5 = new Triangle(new Point(0,0), new Point(1, 1), new Point(0,1));
    }

    @Test
    void isRegular() {
        assertFalse(t1.isRegular());
        assertTrue(t2.isRegular());
    }

    @Test
    void area() {
        assertEquals(0.5, t1.area());
        assertEquals(0.5, t3.area());
        assertEquals(0.5, t4.area());
        assertTrue(Math.abs(t5.area()-0.5) < 0.000001);
        assertEquals(0.5*Math.sqrt(0.75), t2.area());
    }

    @Test
    void perimeter() {
        assertEquals(1+1+Math.sqrt(2), t1.perimeter());
        assertEquals(3, t2.perimeter());
    }

    @Test
    void getCenter() {
        Point expected = getExpected(t1);
        assertTrue(Math.abs(expected.getX() - t1.getCenter().getX()) < 0.000001);
        assertTrue(Math.abs(expected.getY() - t1.getCenter().getY()) < 0.000001);


        expected = getExpected(t2);
        assertTrue(Math.abs(expected.getX() - t2.getCenter().getX()) < 0.000001);
        assertTrue(Math.abs(expected.getY() - t2.getCenter().getY()) < 0.000001);


        expected = getExpected(t3);
        assertTrue(Math.abs(expected.getX() - t3.getCenter().getX()) < 0.000001);
        assertTrue(Math.abs(expected.getY() - t3.getCenter().getY()) < 0.000001);


        expected = getExpected(t4);
        assertTrue(Math.abs(expected.getX() - t4.getCenter().getX()) < 0.000001);
        assertTrue(Math.abs(expected.getY() - t4.getCenter().getY()) < 0.000001);


        expected = getExpected(t5);
        assertTrue(Math.abs(expected.getX() - t5.getCenter().getX()) < 0.000001);
        assertTrue(Math.abs(expected.getY() - t5.getCenter().getY()) < 0.000001);

    }

    private Point getExpected(Triangle triangle){
        return new Point((triangle.getA().getX()+ triangle.getB().getX() + triangle.getC().getX())/3,
                (triangle.getA().getY()+ triangle.getB().getY() + triangle.getC().getY())/3);
    }
}