package Geometries;

import Primitives.*;
import elements.Material;

import java.util.List;
/**
 * plane class represents plane
 *
 */
public class Plane extends Geometry
{
    /**
     * point3D on the plane
     */
    Point3D _p;
    /**
     * normal vector of the plane
     */
    Vector _normal;

    /**
     * plane constructor
     * @param _p
     * @param _normal
     */
    public Plane(Point3D _p, Vector _normal) {/**constructor */
        this._p = _p;
        this._normal = new Vector(_normal);
    }

    /**
     * plane constructor
     * @param p1
     * @param p2
     * @param p3
     */
    public  Plane(Point3D p1,Point3D p2,Point3D p3)/**constructor*/
    {
        _p=p1;
        Vector U = new Vector(p1.subtract(p2));
        Vector V = new Vector(p1.subtract(p3));
        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N.scale(-1);
    }

    /**
     * plane constructor
     * @param emissionLight
     * @param material
     * @param p1
     * @param p2
     * @param p3
     */
    public Plane(Color emissionLight, Material material, Point3D p1, Point3D p2, Point3D p3) {
        super(emissionLight, material);

        _p = new Point3D(p1);

        Vector U = new Vector(p1, p2);
        Vector V = new Vector(p1, p3);

        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N;
    }

    /**
     *
     * @param p
     * @return the a normal vector to the plane - vector
     */
    @Override
    public Vector getNormal(Point3D p) {/**returns the normal*/

            return this.getNormal();

    }

    /**
     *
     * @return the a normal vector to the plane - vector
     */
    public Vector getNormal()
    {
        return _normal;
    }

    /**
     *
     * @param ray
     * @return the intersection between the ray and the plane
     */
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
