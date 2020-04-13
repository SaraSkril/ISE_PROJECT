package Geometries;

import Primitives.*;
import Primitives.Vector;
import Geometries.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void getIntersectionTest()
    {
      Plane plane = new Plane(new Point3D(0,0,4),new Point3D(4,6,4),new Point3D(8,2,4));
        // ============ Equivalence Partitions Tests ==============

        // TC01:Ray must be neither orthogonal nor parallel and intersects the plane(1 points)
        List<Point3D> intersect=plane.findIntsersections(new Ray(new Point3D(2,2,3),new Vector(1,1,-1)));
        if (intersect == null || intersect.size()!=1)
            fail("invalid amount of points returned");
        //checks that points is correct
        assertEquals("Error! Function does not find ray intersection",new Point3D(3,3,2), intersect.get(0));

        // TC02: Ray must be neither orthogonal nor parallel and doesnt intersects the plane(0 points)
        assertEquals("Error! Function finds intersection when there is none",null, plane.findIntsersections(new Ray(new Point3D(0,0,10),new Vector(0,0,1))));
        // =============== Boundary Values Tests ==================
        //TCO3: ray is parallel to the plane and out of plane
        assertEquals("invalid point for ray parallel to plane",null, plane.findIntsersections(new Ray( new Point3D(1,1,1),new Vector(1,1,0))));
        //TC04:ray is parralel tp lame and in plane
        assertEquals("invalid point for ray parallel to plane",null,plane.findIntsersections(new Ray(new Point3D(4,6,4),new Vector(4,6,0))));
        //TC05: ray is orthogonal to the plane and starts in the plane(0 points)
        assertEquals("invalid point for ray orthogonal to plane",null, plane.findIntsersections(new Ray(new Point3D(1,1,0),new Vector(0,0,1))));

        //TCO6: ray is orthogonal to the plane and starts above it and hits it
        assertEquals("invalid point for ray orthogonal to plane",new Point3D(1,1,2), p1.findIntersections(new Ray(new Vector(0,0,-3), new Point3D(1,1,4))).get(0));

        //TCO6: ray is orthogonal to the plane and starts above it and doesn't hit it
        assertEquals(null, p1.findIntersections(new Ray(new Vector(0,0,2), new Point3D(1,1,4))), "invalid point for ray orthogonal to plane");

        //TCO8: ray is orthogonal to the plane and starts below the plane
        assertEquals(null, p1.findIntersections(new Ray(new Vector(0,0,-3), new Point3D(1,1,1))), "invalid point for ray orthogonal to plane");


    }

    @Test
    public void getNormal()
    {

        Plane p1=new Plane(new Point3D(0.0,0.0,1.0),new Point3D(0.0,1.0,0.0), new Point3D(1.0,0.0,0.0));
        double sqr = -Math.sqrt(1d/3);
        assertEquals("Bad normal to plane",new Vector(sqr,sqr,sqr),p1.getNormal(new Point3D(0.0,0.0,1.0)));


    }


}