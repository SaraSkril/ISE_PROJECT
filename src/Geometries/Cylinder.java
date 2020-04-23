package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Util;
import Primitives.Vector;

/**
 * Class Cylinder is the basic class representing cylinder
 *Cylinder extends Radial Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
 */


public class Cylinder extends Tube
{
    double _height;/**cylinders height*/

    public Cylinder(double _radius, Ray axisRay, double _height) {/**constructor*/
        super(_radius, axisRay);/**calls constuctor of tube*/
        this._height = _height;
    }
    @Override
    public Vector getNormal(Point3D p)
    {
        Point3D o = axisRay.getPoint(0);
        Vector v = axisRay.get_direction();

        // projection of P-O on the ray:
        double t;
        try {
            t = Util.alignZero(p.subtract(o).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (t == 0 || Util.isZero(_height - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        o = o.add(v.scale(t));
        return p.subtract(o).normalize();
    }
}
