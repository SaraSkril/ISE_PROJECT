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

    @Test
   public void getIntersectionTest()
    {
      Plane plane = new Plane(new Point3D(0,0,4),new Point3D(4,6,4),new Point3D(8,2,4));
        // ============ Equivalence Partitions Tests ==============

        // TC01:Ray must be neither orthogonal nor parallel and intersects the plane(1 points)
        List<Intersectable.GeoPoint> intersect=plane.findIntsersections(new Ray(new Point3D(2,2,3),new Vector(1,1,-1)));
       // assertEquals("Error! Function does not find ray intersection",new Point3D(3,3,2), intersect.get(0));

        // TC02: Ray must be neither orthogonal nor parallel and doesnt intersects the plane(0 points)
        assertEquals("Error! Function finds intersection when there is none",null, plane.findIntsersections(new Ray(new Point3D(0,0,10),new Vector(0,0,1))));
        // =============== Boundary Values Tests ==================
        //TC03: ray is parallel to the plane and out of plane(0 points)
        assertEquals("invalid point for ray parallel to plane",null, plane.findIntsersections(new Ray( new Point3D(1,1,1),new Vector(1,1,0))));
        //TC04:ray is parralel to plane and in plane(0 point)
        assertEquals("invalid point for ray parallel to plane",null,plane.findIntsersections(new Ray(new Point3D(4,6,4),new Vector(4,6,0))));
        //TC05: ray is orthogonal to the plane and starts in the plane(0 points)
        assertEquals("invalid point for ray orthogonal to plane",null, plane.findIntsersections(new Ray(new Point3D(2,0,0),new Vector(0,-1,0))));
        //TC06: ray is orthogonal to the plane and starts above it (1 point)
        assertEquals("invalid point for ray orthogonal to plane",new Point3D(2,1,4), plane.findIntsersections(new Ray(new Point3D(2,1,1), new Vector(0,0,1))).get(0));

        //TC07: ray is orthogonal to the plane and starts below it (0 points)
        assertEquals("invalid point for ray orthogonal to plane",null, plane.findIntsersections(new Ray(new Point3D(0,0,1), new Vector(-1,-1,-1))));

        //TCO9: ray starts in the plane and is not orthogonal or parallel
        assertEquals( "invalid point for ray starting in plane",null, plane.findIntsersections(new Ray(new Point3D(4,6,4),new Vector(1,2,3))));

        //TC10: ray begins in plane's point of reference
        assertEquals( "invalid point for ray starting in plane",null, plane.findIntsersections(new Ray(new Point3D(0,0,4),new Vector(1,2,3))));


    }






    @Test
    public void getNormal()
    {

        //tests plane's normal calculation
        Plane p1 = new Plane(new Point3D(-1,1,2), new Point3D(-4,2,2), new Point3D(-2,1,5));
        assertEquals( "Normal is not accurately calculated", (new Vector(3,9,1)).normalize(), p1.getNormal());
        /*
        Plane p1=new Plane(new Point3D(0.0,0.0,1.0),new Point3D(0.0,1.0,0.0), new Point3D(1.0,0.0,0.0));
        double sqr = -Math.sqrt(1d/3);
        assertEquals("Bad normal to plane",new Vector(sqr,sqr,sqr),p1.getNormal(new Point3D(0.0,0.0,1.0)));
*/

    }


}