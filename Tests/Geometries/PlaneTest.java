package Geometries;

import Primitives.*;
import Primitives.Vector;
import Geometries.*;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PlaneTest
{

   /* public void getIntersectionTest()
    {
      Plane plane = new Plane(new Point3D(0,0,4),new Point3D(4,6,4),new Point3D(8,2,4));
        // ============ Equivalence Partitions Tests ==============

        // TC01:Ray must be neither orthogonal nor parallel and intersects the plane(1 points)
        List<Point3D> intersect=plane.findIntsersections(new Ray(new Point3D(2,2,3),new Vector(1,1,-1)));
         if(intersect == null || intersect.size()!=1)
            fail("invalid amount of points returned");
        //checks that points is correct
        assertEquals("Error! Function does not find ray intersection",new Point3D(3,3,2), intersect.get(0));

        // TC02: Ray must be neither orthogonal nor parallel and doesnt intersects the plane(0 points)
        assertEquals("Error! Function finds intersection when there is none",null, plane.findIntsersections(new Ray(new Point3D(0,0,10),new Vector(0,0,1))));
        // =============== Boundary Values Tests ==================
        //TC03: ray is parallel to the plane and out of plane(0 points)
        assertEquals("invalid point for ray parallel to plane",null, plane.findIntsersections(new Ray( new Point3D(1,1,1),new Vector(1,1,0))));
        //TC04:ray is parralel to plane and in plane(0 point)
        assertEquals("invalid point for ray parallel to plane",null,plane.findIntsersections(new Ray(new Point3D(4,6,4),new Vector(4,6,0))));
        //TC05: ray is orthogonal to the plane and starts in the plane(0 points)
        assertEquals("invalid point for ray orthogonal to plane",null, plane.findIntsersections(new Ray(new Point3D(1,1,0),new Vector(0,0,1))));
        //TC06: ray is orthogonal to the plane and starts above it (1 point)
        assertEquals("invalid point for ray orthogonal to plane",new Point3D(2,1,-2), plane.findIntsersections(new Ray(new Point3D(2,1,1), new Vector(0,0,1))).get(0));

        //TC07: ray is orthogonal to the plane and starts below it (0 points)
        assertEquals("invalid point for ray orthogonal to plane",null, plane.findIntsersections(new Ray(new Point3D(0,0,1), new Vector(-1,-1,-1))));

        //TCO9: ray starts in the plane and is not orthogonal or parallel
        assertEquals( "invalid point for ray starting in plane",null, plane.findIntsersections(new Ray(new Point3D(4,6,4),new Vector(1,2,3))));

        //TC10: ray begins in plane's point of reference
        assertEquals( "invalid point for ray starting in plane",null, plane.findIntsersections(new Ray(new Point3D(0,0,4),new Vector(1,2,3))));


    }*/

    @Test
    public void testFindIntersections()
    {
        //create plane: Z=2
        Plane p1 = new Plane(new Point3D(0,0,2), new Point3D(2,3,2), new Point3D(4,1,2));
        // ============ Equivalence Partitions Tests ==============
        //TCO1: ray intersects with plane
        //checks amoutn of points returned
        LinkedList<Point3D> intersect= new LinkedList( p1.findIntsersections(new Ray( new Point3D(0,2,1),new Vector(0,0,2))));
        if (intersect == null || intersect.size()!=1)
            fail("invalid amount of points returned");
        //checks that points are correct
        assertEquals("Error! Function does not find ray intersection",new Point3D(0,2,2), intersect.get(0));

        //TCO2: ray doesn't intersect with plane
        assertEquals("Error! Function finds intersection when there is none",null, p1.findIntsersections(new Ray( new Point3D(0,0,10),new Vector(0,0,1))));

       /* // ============ Boundary Value Tests ==============
        //TCO3: ray is parallel to the plane and in plane
        assertEquals(null, p1.findIntsersections(new Ray( new Point3D(1,1,2),new Vector(1,2,0))), "invalid point for ray parallel to plane");

        //TCO4: ray is parallel to the plane and out of the plane
        assertEquals(null, p1.findIntsersections(new Ray( new Point3D(1,1,-2),new Vector(1,5,0))), "invalid point for ray parallel to plane");

        //TCO5: ray is orthogonal to the plane and starts in the plane
        assertEquals(null, p1.findIntsersections(new Ray( new Point3D(1,1,2),new Vector(0,1,0))), "invalid point for ray orthogonal to plane");

        //TCO6: ray is orthogonal to the plane and starts above it and hits it
        assertEquals("invalid point for ray orthogonal to plane",new Point3D(1,1,2), p1.findIntsersections(new Ray( new Point3D(1,1,4),new Vector(0,0,-3))).get(0));

        //TCO7: ray is orthogonal to the plane and starts above it and doesn't hit it
        assertEquals(null, p1.findIntsersections(new Ray( new Point3D(1,1,4),new Vector(0,0,2))), "invalid point for ray orthogonal to plane");

        //TCO8: ray is orthogonal to the plane and starts below the plane
        assertEquals(null, p1.findIntsersections(new Ray( new Point3D(1,1,1),new Vector(0,0,-3))), "invalid point for ray orthogonal to plane");

        //TCO9: ray starts in the plane and is not orthogonal or parallel
        assertEquals(null, p1.findIntsersections(new Ray( new Point3D(1,1,2),new Vector(1,2,3))), "invalid point for ray starting in plane");

        //TC10: ray begins in plane's point of reference
        assertEquals(null, p1.findIntsersections(new Ray( new Point3D(0,0,2),new Vector(1,2,3))), "invalid point for ray starting in plane's point of reference");
*/

    }




    @Test
    public void getNormal()
    {

        Plane p1=new Plane(new Point3D(0.0,0.0,1.0),new Point3D(0.0,1.0,0.0), new Point3D(1.0,0.0,0.0));
        double sqr = -Math.sqrt(1d/3);
        assertEquals("Bad normal to plane",new Vector(sqr,sqr,sqr),p1.getNormal(new Point3D(0.0,0.0,1.0)));


    }


}