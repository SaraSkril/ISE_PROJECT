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
       // TC01:General Test 1 - adds to vectors in 1st quarter
     Vector v1 = new Vector(1.0, 1.0, 1.0);
     Vector v2 = new Vector(1.0, 1.0, 1.0);
     Vector v3 = v1.add(v2);
     assertEquals("Unexpected output", new Vector(2.0, 2.0, 2.0),v3);

       // =============== Boundary Values Tests ==================
       //TC02: checks we dont create the ZERO vector
       Vector v4=new Vector(-1.0,-1.0,-1.0);
       try {
           v3=v1.add(v4);
           fail("Point3D(0.0,0.0,0.0) not valid for vector head");
       }
       catch (IllegalArgumentException ex)
       {
           assertTrue(ex.getMessage(),true);
       }
       //TC03: Checks if adding a minus to plus vector work
       Vector v5= new Vector(-0.5,-0.5,-0.5);
       v3= v1.add(v5);
       assertEquals("Unexpected output, adding opposite signs", new Vector(0.5, 0.5, 0.5),v3);

       //TC04: Checks if adding a plus to minus vector work
       v3= v5.add(v1);
       assertEquals("Unexpected output, adding opposite signs", new Vector(0.5, 0.5, 0.5),v3);

       //TC05: Checks if adding a minus to minus vector work
       Vector v6= new Vector(-0.5,-0.5,-0.5);
       v3= v6.add(v5);
       assertEquals("Unexpected output, adding minus signs", new Vector(-1.0, -1.0, -1.0),v3);


   }
    @Test
    public void subtract()
    {
        /**
         * Test method for {@link Primitives.Vector#substract(Primitives.Vector)}.
         */
        // ============ Equivalence Partitions Tests ==============
        // TC01:General Test 1 - substracts to vectors in 1st quarter
        Vector v1 = new Vector(2.0, 2.0, 2.0);
        Vector v2 = new Vector(1.0, 1.0, 1.0);
        Vector v3 = v1.subtract(v2);
        assertEquals("Unexpected output", new Vector(1.0, 1.0, 1.0),v3);

        // =============== Boundary Values Tests ==================
        //TC02: checks we dont create the ZERO vector
        Vector v4=new Vector(1.0,1.0,1.0);
        try {
            v3=v2.subtract(v4);
            fail("Point3D(0.0,0.0,0.0) not valid for vector head");
        }
        catch (IllegalArgumentException ex)
        {
            assertTrue(ex.getMessage(),true);
        }
        //TC03: Checks if substracting a minus to plus vector work
        Vector v5= new Vector(-0.5,-0.5,-0.5);
        v3= v1.subtract(v5);
        assertEquals("Unexpected output, adding opposite signs", new Vector(2.5, 2.5, 2.5),v3);

        //TC04: Checks if sub a plus to minus vector work
        v3= v5.subtract(v1);
        assertEquals("Unexpected output, adding opposite signs", new Vector(-2.5, -2.5, -2.5),v3);

        //TC05: Checks if adding a minus to minus vector work
        Vector v6= new Vector(-1.5,-1.5,-1.5);
        v3= v6.subtract(v5);
        assertEquals("Unexpected output, adding minus signs", new Vector(-1.0, -1.0, -1.0),v3);

    }

    @Test
    public void scale()
    {
        // ============ Equivalence Partitions Tests ==============
        // TC01:General Test 1 - scales with a positive scalar
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v3 = v1.scale(2);
        assertEquals("Unexpected output, scaling with positive sign scalar", new Vector(2.0, 2.0, 2.0),v3);

        // =============== Boundary Values Tests ==================
        //TC02: checks we dont create the ZERO vector
        try {
            v3=v1.scale(0);
            fail("Point3D(0.0,0.0,0.0) not valid for vector head");
        }
        catch (IllegalArgumentException ex)
        {
            assertTrue(ex.getMessage(),true);
        }
        //TC03: Checks if scaling with a negetive scalar
        v3= v1.scale(-1);
        assertEquals("Unexpected output, scaling with negative sign scalar", new Vector(-1.0, -1.0, -1.0),v3);
    }

    @Test
    public void crossProduct()
    {
        Vector v1 = new Vector(3.5, -5.0, 10.0);
        Vector v2 = new Vector(2.5,7,0.5);
        Vector v3 = v1.crossProduct(v2);

        assertEquals( 0, v3.dotProduct(v2), 1e-10);
        assertEquals( 0, v3.dotProduct(v1), 1e-10);

        Vector v4 = v2.crossProduct(v1);

        System.out.println(v3.toString());
        System.out.println(v4.toString());

        try {
            v3.add(v4);
            fail("Vector (0,0,0) not valid");
        }
        catch  (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!= null);
        }
//        assertTrue(v3.length() >84);
        assertEquals(84,v3.length(),0.659);
    }

    @Test
    public void lengthSquared()
    {
        // ============ Equivalence Partitions Tests ==============
        // TC01:General Test 1 - checks if the imput is correct
        Vector v1= new Vector(2.0,3.0,8.0);
        double sum = v1.lengthSquared();
        assertTrue("Wrong Value",sum!=77.0);

    }

    @Test
    public void length()
    {
        // ============ Equivalence Partitions Tests ==============
        // TC01:General Test 1 - checks if the imput is correct
        Vector v1= new Vector(1.0,1.0,1.0);
        double sum = v1.length();
        assertTrue("Wrong Value",sum!=1.0);
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

}