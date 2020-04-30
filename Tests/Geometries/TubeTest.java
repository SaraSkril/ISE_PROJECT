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
        Vector expected=new Vector(0,1,0);
        //o=(0,0,5), t=5, po=(0,0,3)  po.normalize=(0,0,1)
        Tube t1 = new Tube( 5,new Ray(new Point3D(0,0,0),new Vector(0,0,1)));

        // ============ Equivalence Partitions Tests ==============
        assertEquals("normal to point on tube in inaccurate",expected , t1.getNormal(new Point3D(0,3,5)));
    }
}