package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Sphere extends RadialGeometry
{
    Point3D _center;/***/

    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
