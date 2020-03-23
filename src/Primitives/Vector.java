package Primitives;

import java.util.Objects;
/**
 * Class Vector is the basic class representing a vector for a geometry in Cartesian
 * Vector system.
 * @author Elisheva Aronstam and Sara Raizel Skriloff
 */
public class Vector
{
    Point3D _head;
    public Vector(Coordinate _x, Coordinate _y, Coordinate _z)
    {
        Point3D p= new Point3D(_x,_y,_z);
        if(p.equals(Point3D.ZERO))
            throw new IllegalArgumentException("Not Allowed ");
        _head= p;

    }
    public Vector(double _x, double _y,double _z) {
        Point3D p = new Point3D(_x, _y, _z);
        if (p.equals(Point3D.ZERO))
            throw new IllegalArgumentException("Not Allowed ");
        _head = p;
    }
    public Vector(Point3D p)
    {
        if(p.equals(Point3D.ZERO))
            throw new IllegalArgumentException("Not Allowed ");
        _head=p;
    }

    public Vector(Vector v)
    {
        _head=v._head;
    }
    public Vector subtract(Vector v)
    {
        return new Vector(this._head._x._coord-v._head._x._coord,this._head._y._coord-v._head._y._coord,this._head._z._coord-v._head._z._coord);
    }
    public Vector add(Vector v) {
        return new Vector(this._head._x._coord+v._head._x._coord,this._head._y._coord+v._head._y._coord,this._head._z._coord+v._head._z._coord);
    }
    public Vector scale(double s)
    {return new Vector(_head._x._coord*s,_head._y._coord*s,_head._z._coord*s);
    }
    public double dotProduct(Vector v)
    {
        return(v._head._x._coord*this._head._x._coord+v._head._y._coord*this._head._y._coord+v._head._z._coord*this._head._z._coord);
    }
public Vector crossProduct(Vector v)
{double x=this._head._y._coord*v._head._z._coord-this._head._z._coord*v._head._y._coord;
double y=this._head._z._coord*v._head._x._coord-this._head._x._coord*v._head._z._coord;
double z=this._head._x._coord*v._head._y._coord-this._head._y._coord*v._head._x._coord;
return new Vector(x,y,z);


}
public double lengthSquared()
{
    return this._head._x._coord*this._head._x._coord+this._head._y._coord*this._head._y._coord+this._head._z._coord*this._head._z._coord;

}
public double length()
{
    return Math.sqrt(this.lengthSquared());
}
public Vector normalize()
{
    double x = this._head._x._coord;
    double y = this._head._y._coord;
    double z = this._head._z._coord;

    double length = this.length();

    if (length == 0)
        throw new ArithmeticException("divide by Zero");

    this._head._x = new Coordinate(x / length);
    this._head._y = new Coordinate(y / length);
    this._head._z = new Coordinate(z / length);

    return this;

}
public Vector normalized()
{
    Vector vector = new Vector(this);
    vector.normalize();
    return vector;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_head);
    }
}
