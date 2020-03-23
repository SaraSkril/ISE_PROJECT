package Geometries;

import Primitives.Ray;

/**
 * Class Cylinder is the basic class representing cylinder
 *Cylinder extends Radial Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
 */


public class Cylinder extends Tube
{
    double _height;

    public Cylinder(double _radius, Ray axisRay, double _height) {
        super(_radius, axisRay);
        this._height = _height;
    }
}
