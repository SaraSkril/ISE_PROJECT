package Geometries;

import Primitives.Point3D;
import org.junit.Test;

import static org.junit.Assert.*;

public class SphereTest {


   /** @Test
    public void get_radius() {
    }*/

    @Test
    public void getNormal() {
        Sphere sp=new Sphere(1,new Point3D(0,0,1));
        assertEquals(new Vector(0,0,1),sp.getNormal(new Point3D(0,0,2)));


    }
}