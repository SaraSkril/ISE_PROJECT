package Geometries;

import Primitives.*;

import java.util.List;

/**
 * Class Cylinder is the basic class representing cylinder
 *Cylinder extends Radial Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
 */


public class Cylinder extends Tube
{
    double height;

    public Cylinder(double _radius, Ray ray, double h)
    {
        super(_radius, ray);
        height=h;
    }

    public Cylinder(Color _emmission, double _radius, Ray axisRay, double height) {
        super(_emmission, _radius, axisRay);
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "Cylinder{" +
                "ray=" + axisRay +
                ", _radius=" + _radius +
                '}';
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Vector getNormal(Point3D point)
    {
        Plane plane = new Plane(axisRay.getPoint(), axisRay.get_direction());
        Vector v1 = axisRay.getPoint().subtract(point);
        if((v1.dotProduct(axisRay.get_direction()))==0) //the vectors are orthogonal
        {
            return (axisRay.get_direction().scale(-1)).normalize();
        }
        Point3D p1 = axisRay.getPoint().add(axisRay.get_direction().normalized().scale(height));
        v1 = p1.subtract(point);
        if((v1.dotProduct(axisRay.get_direction()))==0) //the vectors are orthogonal
        {
            return (axisRay.get_direction()).normalize();
        }
        Vector v = new Vector(point);
        Point3D p = new Point3D(point);
        double t = v.dotProduct(new Vector(p));
        Point3D o = new Point3D(v.scale(t).get_head());
        Vector n = (p.subtract(o)).normalize();
        return n;
    }


    public List<GeoPoint> findIntersections(Ray ray) {
        return super.findIntsersections(ray);
    }
}
