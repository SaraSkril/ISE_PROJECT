package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

public class Plane implements Geometry
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


    @Override
    public Vector getNormal(Point3D p) {/**returns the normal*/

            return this.getNormal();

    }

    public Vector getNormal()
    {
        return _normal;
    }

    @Override
    public List<Point3D> findIntsersections(Ray ray) {
        return null;
    }
}
