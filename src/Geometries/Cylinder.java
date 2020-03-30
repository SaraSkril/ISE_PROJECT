package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
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
    public Vector getNormal(Point3D p) {
        return null;
    }
}
