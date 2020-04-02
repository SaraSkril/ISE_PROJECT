package Geometries;

import Primitives.Point3D;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void getNormal()
    {

        Plane p1=new Plane(new Point3D(0.0,0.0,1.0),new Point3D(0.0,1.0,0.0), new Point3D(1.0,0.0,0.0));
        double sqr = -Math.sqrt(1d/3);
        assertEquals("Bad normal to plane",new Vector(sqr,sqr,sqr),p1.getNormal(new Point3D(0.0,0.0,1.0)));


    }


}