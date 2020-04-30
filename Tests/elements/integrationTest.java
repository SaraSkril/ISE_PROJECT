package elements;

import static org.junit.Assert.*;
import Primitives.*;
import Geometries.*;
import org.junit.Test;
import org.junit.Test;
import java.util.List;

public class integrationTest
{
    Camera cam1 = new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0));
    Camera cam2 = new Camera(new Point3D(0, 0, -0.5), new Vector(0, 0, 1), new Vector(0, -1, 0));
    /**
     * tests sphere and camera ray intersection
     */
    @Test
    public void constructRayThroughPixelWithSphere1() {
        //sphere has 2 intersection points
        Sphere sph =  new Sphere(1, new Point3D(0, 0, 3));//builds a sphere which contains a radius and pint3D
//        Ray ray = cam1.constructRayThroughPixel(3,3,0,0,1,3,3);
//        List<Point3D> results =  sph.findIntersections(ray);
        List<Point3D> results;
        int count = 0;//number of intersections ray has with sphere
        int Nx =3;
        int Ny =3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {//loop over places
                results = sph.findIntsersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",2,count);
        System.out.println("count: "+count);

    }
    @Test
    public void constructRayThroughPixelWithSphere2()
    {//sphere has 18 intersection points
        Sphere sph =  new Sphere(2.5, new Point3D(0, 0, 2.5));

        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {//loop over places
                results = sph.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",18,count);
        System.out.println("count: "+count);
    }
    @Test
    public void constructRayThroughPixelWithSphere3()
    {//sphere has 10 intersection points
        Sphere sph= new Sphere(2,new Point3D(0,0,2));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",10,count);
        System.out.println("count: "+count);

    }

    @Test
    public void constructRayThroughPixelWithSphere4()
    {//sphere has 9 intersection pints
        Sphere sph= new Sphere(4,new Point3D(0,0,1));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {//loop over places
                results = sph.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",9,count);
        System.out.println("count: "+count);

    }
    @Test
    public void constructRayThroughPixelWithSphere5()
    {//sphere has 0 intersection points
        Sphere sph= new Sphere(0.5,new Point3D(0,0,-1));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {//looop over places
                results = sph.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",0,count);
        System.out.println("count: "+count);

    }

    @Test
    public void constructRayThroughPixelWithPlane1()
    {
        // TC01: plane parallels to camera (9 points)
        Plane pl= new Plane(new Point3D(0,-10,0), new Point3D(0,0,3), new Point3D(-10,0,0));
        List<Point3D> results;
        int count = 0;
        int Nx =3;
        int Ny =3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = pl.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }
        assertEquals("too bad",9,count);
        System.out.println("count: "+count);

    }

    @Test
    public void constructRayThroughPixelWithPlane2()
    {
        // TC02: small angle with view plane (9 points)
        Plane pl= new Plane(new Point3D(3,-3,0), new Point3D(-2,-3,0), new Point3D(0,-1,1.5));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = pl.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",9,count);
        System.out.println("count: "+count);

    }
    @Test
    public void constructRayThroughPixelWithPlane3()
    { //TC03: plane has 6 intersection points view plane rays.
        Plane pl= new Plane(new Point3D(0,2,3),new Vector(0,5,5));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = pl.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",6,count);
        System.out.println("count: "+count);

    }
    /**
     * tests triangle and camera ray intersection
     */

    @Test
    public void constructRayThroughPixelWithTriangle1()
    {
        Triangle tr=new Triangle(new Point3D(0,-1,2),new Point3D(1,1,2),new Point3D(-1,1,2));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = tr.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",1,count);
        System.out.println("count: "+count);

    }
    @Test
    public void constructRayThroughPixelWithTriangle2()
    {    //TCO2: bigger triangle parallels to plane (2 intersection points)
        Triangle tr=new Triangle(new Point3D(0,-20,2),new Point3D(1,1,2),new Point3D(-1,1,2));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = tr.findIntsersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",2,count);
        System.out.println("count: "+count);

    }
}