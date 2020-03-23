package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

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
    public Vector getNormal(Point3D p) {
        return null;
    }
}
