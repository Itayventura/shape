import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    private static Line line;
    private static Line other;
    private static Point point;

    @BeforeAll
    static void setUp() {
        line = new Line(new Point(0, 0), new Point(1, 0));
        other = new Line(new Point(0.5, 0.5), new Point(0.5, -0.5));
        point = new Point(0,1);
    }

    @Test
    void length() {
        assertEquals(1, line.length());
    }

    @Test
    void distance() {
        assertEquals(1, line.distance(point));
    }

    @Test
    void getClosest() {
        assertEquals(new Point(0,0), line.getClosest(point));
    }

    @Test
    void getSlope() {
        assertEquals(0, line.getSlope());
    }

    @Test
    void getCross() {
        assertEquals(0, line.getCross());
    }

    @Test
    void getCenter() {
        assertEquals(new Point(0.5, 0), line.getCenter());
        assertEquals(new Point(0.5, 0), other.getCenter());
    }

    @Test
    void getIntersection() {
        assertEquals(new Point(0.5, 0), line.getIntersection(other));

    }
}