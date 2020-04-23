package Primitives;

public class Ray {
    //The point from which the ray starts.
    private final Point3D _point;
    //The direction of the ray.
    private final Vector _direction;
    /*
            * Constructor for creating a new instance of this class
     * @param point the start of the ray.
            * @param direction the direction of the ray.
    */

    public Ray(Point3D point, Vector direction) {
        _point = new Point3D(point);
        _direction = new Vector(direction).normalized();
    }

    /* Copy constructor for a deep copy of an Ray object.
     * @param other the object that being copied
     */
    public Ray(Ray other) {
        this._point = new Point3D(other._point);
        this._direction = other._direction.normalized();
    }

    public Point3D getPoint(double t)
    {
        return new Point3D(_point.add(_direction.scale(t)));
    }
    public Point3D getTargetPoint(double length) {
        return Util.isZero(length) ? _point : _point.add(_direction.scale(length));


    }

    public Vector get_direction() {
        return _direction;
    }
}
