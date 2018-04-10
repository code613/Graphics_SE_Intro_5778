package tests;

import main.primitives.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    private Coordinate ouachad = new Coordinate(8.88889);
    private Coordinate tnen = new Coordinate(8.88888);
    @Test
    void getCoordinate() {
        System.out.println(ouachad.getCoordinate());
        System.out.println(tnen.getCoordinate());
    }

    @Test
    void compareTo() {
        if (ouachad.compareTo(tnen) == 0) {
            System.out.println("nogood");
        }
        assertEquals(0, ouachad.compareTo(tnen));
    }
}