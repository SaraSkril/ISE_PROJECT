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
    public Vector(Coordinate _x, Coordinate _y, Coordinate _z)/**constructor that receives three coordinates */
    {
        Point3D p= new Point3D(_x,_y,_z);
        if(p.equals(Point3D.ZERO))
            throw new IllegalArgumentException("Not Allowed ");
        _head= p;

    }
    public Vector(double _x, double _y,double _z) {/**constructor of vector that receives three values*/
        Point3D p = new Point3D(_x, _y, _z);/**creates a 3D point*/
        if (p.equals(Point3D.ZERO))/*if the constucted 3D point is a zero point 3D throw an exeption*/
            throw new IllegalArgumentException("Not Allowed ");
        _head = p;/**otherwise p is the head of vector*/
    }
    public Vector(Point3D p)/**constructor of vector that receives a Point3D*/
    {
        if(p.equals(Point3D.ZERO))/**if the point is equal to zero throw an exception*/
            throw new IllegalArgumentException("Not Allowed ");
        _head=p;/**otherwise p is the head of vector*/
    }

    public Vector(Vector v)/**constructor of vector that receives a vector*/
    {
        _head=v._head;
    }


    public Vector(Point3D p1, Point3D p2) {
        this(p1.subtract(p2));
    }

    public Vector subtract(Vector v)/**subtracts between this and v and returns the subtracted vector*/
    {
        return new Vector(this._head._x._coord-v._head._x._coord,this._head._y._coord-v._head._y._coord,this._head._z._coord-v._head._z._coord);
    }
    public Vector add(Vector v)
    {/**adds this to v and returns the vector*/
    try {
        return new Vector(this._head._x._coord + v._head._x._coord, this._head._y._coord + v._head._y._coord, this._head._z._coord + v._head._z._coord);
    }
    //throws exception if the addition created (0,0,0)
    catch (IllegalArgumentException ex) {
        throw ex;
    }
    }
    public Vector scale(double s)
    {
        return new Vector(_head._x._coord*s,_head._y._coord*s,_head._z._coord*s);
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
public double lengthSquared()/** the length squared*/
{
    return this._head._x._coord*this._head._x._coord+this._head._y._coord*this._head._y._coord+this._head._z._coord*this._head._z._coord;

}
public double length()/**the length of the vector*/
{
    return Math.sqrt(this.lengthSquared());
}
public Vector normalize()/**normalizes the vector by dividing each coord by the length*/
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

    return this;/**returns the vector after normalizing it*/

}
public Vector normalized()/**returns a vector normalized in the same direction as the orig vector*/
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

    public Point3D get_head() {
        return _head;
    }
}
