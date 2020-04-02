package Geometries;

import Geometries.*;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TubeTest {

    @Test
    public void getNormalTest()
    {
        Tube t= new Tube(1.0,new Ray(new Point3D(1.0,0.0,0.0),new Vector(0.0,1.0,0.0)));
        Vector v = new Vector(new Point3D(1.0,1.0,1.0)).normalize();
        assertTrue(t.getNormal(new Point3D(2.0,0.0,0.0)).equals(new Vector(new Point3D(1.0,0.0,0.0))));
        assertTrue(t.getNormal(new Point3D(2.0,1.0,1.0)).equals(v));
    }
}