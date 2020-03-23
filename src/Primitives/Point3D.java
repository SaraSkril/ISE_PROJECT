package Primitives;

/**
 * Class Point3D is the basic class representing a 3D point for a geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Elisheva Aronstam and Sara Raizel Skriloff
 */

import java.util.Objects;

public class Point3D {
    /**
     * 3 Coordinates x,y,z
     */
    Coordinate _x;
    Coordinate _y;
    Coordinate _z;

    public final static Point3D ZERO = new Point3D(0.0,0.0,0.0);

    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {/**constructor of point 3D that receives three coordinates*/
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }
    public Point3D(double _x, double _y, double _z) {/**constructor*/
        this(new Coordinate(_x),new Coordinate(_y),new Coordinate(_z));
    }

    public Point3D(Point3D other)/**constructor*/
    {
     this(other._x,other._y,other._z);
    }
/**getters*/
    public Coordinate get_x() {
        return _x;
    }

    public Coordinate get_y() {
        return _y;
    }

    public Coordinate get_z() {
        return _z;
    }

    @Override
    public boolean equals(Object o) {/**compares between this and obj*/

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) &&
                _y.equals(point3D._y) &&
                _z.equals(point3D._z);
    }

    @Override
    public String toString()
    {
        return "Point3D{" +
                "_x=" + _x +
                ", _y=" + _y +
                ", _z=" + _z +
                '}';
    }
    public Vector subtract(Point3D p)/**subtracts p from this and creates and returns a new vector*/
    {
        return new Vector(new Point3D(
                this._x._coord - p._x._coord,
                this._y._coord - p._y._coord,
                this._z._coord - p._z._coord));
    }

    public Point3D add(Vector v)/**adds v to this vector and returns a 3D point*/
    {
        return new Point3D(v._head._x._coord+this._x._coord,v._head._y._coord+_y._coord,v._head._z._coord+_z._coord);/**creates a new point3D*/
    }
    public double distanceSquared(Point3D p)/**distance between p and this point and then squares the result*/
    {
        return (this._x._coord-p._x._coord)*(this._x._coord-p._x._coord)+(this._y._coord-p._y._coord)*(this._y._coord-p._y._coord)+(this._z._coord-p._z._coord)*(this._z._coord-p._z._coord);
    }
    public double distance(Point3D p)/** calculates distance by square root of previous function*/
    {
        return Math.sqrt(this.distanceSquared(p));
    }


}
