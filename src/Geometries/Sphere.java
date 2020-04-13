package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

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
        return null;
    }

    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
