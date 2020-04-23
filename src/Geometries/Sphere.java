package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import Primitives.Util;

import java.util.List;

/**
 * Class Sphere is the basic class representing Sphere
 *Cylinder extends Radial Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
 */
public class Sphere extends RadialGeometry
{
    Point3D _center; //center of sphere

    /*
    Constructor
     */
    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        Vector normal = p.subtract(_center);
        return normal.normalize();
    }

    @Override
    public List<Point3D> findIntsersections(Ray ray) {
        Point3D p0 = ray.getPoint(0);
        Vector v = ray.get_direction();
        Vector u;
        try {
            u = _center.subtract(p0);   // p0 == _center
        } catch (IllegalArgumentException e) {
            return List.of(ray.getTargetPoint(_radius));//get target point
        }
        double tm = Util.alignZero(v.dotProduct(u));
        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
        double thSquared = Util.alignZero(_radius*_radius-dSquared);

        if (thSquared <= 0) return null;

        double th = Util.alignZero(Math.sqrt(thSquared));
        if (th == 0) return null;

        double t1 = Util.alignZero(tm - th);
        double t2 = Util.alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0) return List.of(ray.getTargetPoint(t1), ray.getTargetPoint(t2)); //P1 , P2
        if (t1 > 0)
            return List.of(ray.getTargetPoint(t1));
        else
            return List.of(ray.getTargetPoint(t2));
    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
