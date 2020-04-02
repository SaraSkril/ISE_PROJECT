package Geometries;

import Primitives.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void getNormalTest() {
        Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals(new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)), "Bad normal for triangle");
    }
}