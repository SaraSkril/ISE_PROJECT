package Primitives;

import jdk.jfr.StackTrace;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {
   @Test
   public void add()
   {
       /**
        * Test method for {@link Primitives.Vector#add(Primitives.Vector)}.
        */

       // ============ Equivalence Partitions Tests ==============
       // TC01:General Test 1
     Vector v1 = new Vector(1.0, 1.0, 1.0);
     Vector v2 = new Vector(-1.0, -1.0, -1.5);
     Vector v3 = v1.add(v2);
     //TC02: General Test 2
     assertEquals(new Vector(0.0,0.0,-0.5),v3);
       v3 = v2.add(v1);
       assertEquals(new Vector(-1.0, -1.0, -2.0),v3);
       // =============== Boundary Values Tests ==================

     // TC03: checks that will not create vector 0
     Vector v4=new Vector(-1.0,-1.0,-1.0);
     try {
         v3=v1.add(v4);
         fail("Point3D(0.0,0.0,0.0) not valid for vector head");
     }
     catch (IllegalArgumentException ex)
     {
         assertEquals("Not Allowed", ex.getMessage());
     }
   }
    @Test
    public void subtract()
    {
        /**
         * Test method for {@link Primitives.Vector#substract(Primitives.Vector)}.
         */
        // ============ Equivalence Partitions Tests ==============
        // TC01:General Test 1
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.5);
        Vector v3 = v1.subtract(v2);
        //TC02: General Test 2
        assertEquals(new Vector(2.0,0.0,2.5),v3);
        v3 = v2.subtract(v1);
        assertEquals(new Vector(-2.0, -2.0, -2.5),v3);
        // =============== Boundary Values Tests ==================

        // TC03: checks that will not create vector 0
        Vector v4=v1;
        try {
            v3=v1.subtract(v4);
            fail("Point3D(0.0,0.0,0.0) not valid for vector head");
        }
        catch (IllegalArgumentException ex)
        {
            assertEquals("Not Allowed", ex.getMessage());
        }


    }

    @Test
    public void scale() {
    }

    @Test
    public void crossProduct() {
    }

    @Test
    public void lengthSquared() {
    }

    @Test
    public void length() {
    }

    @Test
    public void normalize()
    {
        Vector v = new Vector(3.5, -5, 10);
        v.normalize();
        assertEquals(1, v.length(), 1e-10);

        try {
            Vector v1 = new Vector(0, 0, 0);
            v.normalize();
            fail("Didn't throw divide by zero exception!");
        } catch (IllegalArgumentException ex) {
            assertEquals("Point3D(0.0,0.0,0.0) not valid for vector head", ex.getMessage());
        }
        assertTrue(true);
    }

    @Test
    public void normalized() {
    }
}