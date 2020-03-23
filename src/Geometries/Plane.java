package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Plane implements Geometry
{
    Point3D _p;
    Vector _normal;

    public Plane(Point3D _p, Vector _normal) {/**constructor */
        this._p = _p;
        this._normal = _normal;
    }
    public  Plane(Point3D p1,Point3D p2,Point3D p3)/**constructor*/
    {
        _p=p1;
        _normal=null;
    }


    @Override
    public Vector getNormal(Point3D p) {/**returns the normal*/

            /*Vector U = new Vector (_p1, _p2);
            Vector V = new Vector (_p1, _p3);
            Vector N = new Vector (U.crossProduct(V));

            N.normalize();
            N.scale(-1);
            return N;*/
            return null;


    }

    public Vector getNormal()
    {
        return getNormal(null);
    }
}
