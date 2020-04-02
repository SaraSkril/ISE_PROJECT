package Geometries;

import Geometries.*;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class TubeTest {

    @Test
    public void getNormalTest()
    {
        Tube t= new Tube(1,new Ray(new Point3D(1.0,0.0,0.0),new Vector(0.0,0.0,1.0)));
        assertEquals("Wrong Normal",);
    }
}