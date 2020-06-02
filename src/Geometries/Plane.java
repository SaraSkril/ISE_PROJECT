package Geometries;

import Primitives.*;
import elements.Material;

import java.util.List;

public class Plane extends Geometry
{
    Point3D _p;
    Vector _normal;

    public Plane(Point3D _p, Vector _normal) {/**constructor */
        this._p = _p;
        this._normal = new Vector(_normal);
    }
    public  Plane(Point3D p1,Point3D p2,Point3D p3)/**constructor*/
    {
        _p=p1;
        Vector U = new Vector(p1.subtract(p2));
        Vector V = new Vector(p1.subtract(p3));
        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N.scale(-1);
    }
    public Plane(Color emissionLight, Material material, Point3D p1, Point3D p2, Point3D p3) {
        super(emissionLight, material);

        _p = new Point3D(p1);

        Vector U = new Vector(p1, p2);
        Vector V = new Vector(p1, p3);

        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N;
    }


    @Override
    public Vector getNormal(Point3D p) {/**returns the normal*/

            return this.getNormal();

    }

    public Vector getNormal()
    {
        return _normal;
    }

    @Override
    public List<GeoPoint> findIntsersections(Ray ray) {
        Vector p0Q;
        try {
            p0Q = _p.subtract(ray.getPoint());
        } catch (IllegalArgumentException e) {
            return null; // ray starts from point Q - no intersections
        }

        double nv = _normal.dotProduct(ray.get_direction());
        if (Util.isZero(nv)) // ray is parallel to the plane - no intersections
            return null;

        double t = Util.alignZero(_normal.dotProduct(p0Q) / nv);

        return t <= 0 ? null : List.of(new GeoPoint(this,ray.getTargetPoint(t)));
    }
}
