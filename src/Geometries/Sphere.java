package Geometries;

import Primitives.*;
import elements.Material;

import java.util.List;

import static Primitives.Util.alignZero;

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

    public Sphere(Color _emmission, double _radius, Point3D _center) {
        super(_emmission, _radius);
        this._center = _center;
    }
    public Sphere(Color emissionLight, Material material, double radius, Point3D center) {
        super(emissionLight, radius, material);
        this._center = new Point3D(center);
    }
    @Override
    public Vector getNormal(Point3D p)
    {
        return p.subtract(_center).normalize();
    }

    @Override
    public List<GeoPoint> findIntsersections(Ray ray) {
        Point3D p0 = ray.getPoint();
        Vector v = ray.get_direction();
        Vector u;
        try {
            u = _center.subtract(p0);   // p0 == _center
        } catch (IllegalArgumentException e) {
            return List.of(new GeoPoint(this,ray.getTargetPoint(_radius)));
        }
        double tm = alignZero(v.dotProduct(u));
        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
        double thSquared = alignZero(_radius * _radius - dSquared);

        if (thSquared <= 0) return null;

        double th = alignZero(Math.sqrt(thSquared));
        if (th == 0) return null;

        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0) return List.of(new GeoPoint(this,ray.getTargetPoint(t1)),new GeoPoint(this, ray.getTargetPoint(t2))); //P1 , P2
        if (t1 > 0)
            return List.of(new GeoPoint(this,ray.getTargetPoint(t1)));
        else
            return List.of(new GeoPoint(this,ray.getTargetPoint(t2)));
    }


}
