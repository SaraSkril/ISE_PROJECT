package Geometries;

import Geometries.Cylinder;
import Geometries.Sphere;
import org.junit.Test;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import static org.junit.Assert.*;
/**
 * Unit tests for geometries.Cylinder class
 */

public class CylinderTest {

    /**
     * Test method for {@Link geometries.Cylinder#getNormal(geometries.Cylinder)}
     */
    @Test
   public  void getNormal() {
        // ============ Equivalence Partitions Tests ==============
        Ray r = new Ray(new Point3D(1,0,0), new Vector(0,1,0));
        Cylinder c = new Cylinder(1,r, 5);
        assertEquals("Cylinder.getNormal() result is wrong",new Vector(0, -1, 0), c.getNormal(new Point3D(1.5, 0, 0)));
        assertEquals("Cylinder.getNormal() result is wrong", new Vector(0, 1, 0), c.getNormal(new Point3D(1.5, 5, 0)));


        // ============ Boundary Tests ==============
        assertEquals("Cylinder.getNormal() result is wrong", new Vector(0, -1, 0), c.getNormal(new Point3D(2, 0, 0)));
        assertEquals("Cylinder.getNormal() result is wrong", new Vector(0, 1, 0), c.getNormal(new Point3D(2, 5, 0)));
    }
}