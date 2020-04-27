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

    @Test
    public void constructRayThroughPixelWithSphere1() {
        //TO DO
        Sphere sph =  new Sphere(1, new Point3D(0, 0, 3));
//        Ray ray = cam1.constructRayThroughPixel(3,3,0,0,1,3,3);
//        List<Point3D> results =  sph.findIntersections(ray);
        List<Point3D> results;
        int count = 0;
        int Nx =3;
        int Ny =3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(cam1.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",2,count);
        System.out.println("count: "+count);

    }
    @Test
    public void constructRayThroughPixelWithSphere2()
    {
        Sphere sph =  new Sphere(2.5, new Point3D(0, 0, 2.5));

        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",18,count);
        System.out.println("count: "+count);
    }
    @Test
    public void constructRayThroughPixelWithSphere3()
    {
        Sphere sph= new Sphere(2,new Point3D(0,0,2));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",10,count);
        System.out.println("count: "+count);

    }

    @Test
    public void constructRayThroughPixelWithSphere4()
    {
        Sphere sph= new Sphere(4,new Point3D(0,0,1));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",9,count);
        System.out.println("count: "+count);

    }
    @Test
    public void constructRayThroughPixelWithSphere5()
    {
        Sphere sph= new Sphere(0.5,new Point3D(0,0,-1));
        List<Point3D> results;
        int count = 0;
        // TODO explanations
        int Nx =3;
        int Ny =3;

        // TODO explanations
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                results = sph.findIntersections(cam2.constructRayThroughPixel(Nx, Ny, j, i, 1, 3, 3));
                if (results != null)
                    count += results.size();
            }
        }

        assertEquals("too bad",0,count);
        System.out.println("count: "+count);

    }
}