package testing.tests;

import main.primitives.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    Point2D kuku = new Point2D(8.00000088,9.0);
    Point2D kuku2 = new Point2D(8.0000009,9.0);
    @Test
    void getXtest() {
        assertEquals(kuku.getX().getCoordinate(),kuku2.getX().getCoordinate(),0.0000001);
        System.out.println("maspik veday");
    }

    @Test
    void getYtest() {
    }
}