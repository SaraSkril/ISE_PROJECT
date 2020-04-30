package Geometries;

import Primitives.*;
import Geometries.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest
{

    @Test
    public void getNormalTest() {
        Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = -Math.sqrt(1d / 3);
        assertEquals("Bad normal to triangle",new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }

    @Test
    public void FindIntersectionsTest() {
        Triangle triangle = new Triangle(new Point3D(0,0,4), new Point3D(4,6,4),new Point3D(8,2,4));
        // TC01:Ray must be neither orthogonal nor parallel and intersects the triangle(1 points)
        assertEquals("Meant to intersect with triangle",new Point3D(2,2,4),triangle.findIntsersections(new Ray(new Point3D(1,1,2), new Vector(1,1,2))).get(0));

        // TC02: Point is outside the triangle but on plane (0 points)
        assertEquals("Error! Intersects with plane but not triangle ",null, triangle.findIntsersections(new Ray(new Point3D(0,0,4),new Vector(2,2,0))));

        //TC03: Point is Outside against vertex but in plane (0 points)
        assertEquals("Error! Intersects with plane but not triangle ",null, triangle.findIntsersections(new Ray(new Point3D(0,0,4),new Vector(-1,-1,0))));
        // =============== Boundary Values Tests ==================
        assertEquals("intercects On edge's continuation ", null, triangle.findIntsersections(new Ray(new Point3D(5.28,0,0), new Vector(0,7.93,0))));
        Triangle t1 = new Triangle(new Point3D(2,3,2),new Point3D(4,3,2), new Point3D(4,1,2));

        assertEquals("invalid point for ray starting in polygon's vertice",null, t1.findIntsersections(new Ray( new Point3D(2,3,2),new Vector(1,2,7))));

        //TC04: Point is one of the edge of the triangle
        assertEquals("invalid point for ray intersecting with",null, t1.findIntsersections(new Ray( new Point3D(3,2,-2),new Vector(0,0,1))));

    }
}