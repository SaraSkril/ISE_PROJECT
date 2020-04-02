package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Util;
import Primitives.Vector;
/**
 * Class Tube is the basic class representing tube
 *Cylinder extends Radial Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
 */
public class Tube extends RadialGeometry
{
    //the Ray Axis
    Ray axisRay;

    /*
    Constructor for tube using the radial Geometry constructor
     */
    public Tube(double _radius, Ray axisRay) {
        super(_radius);
        this.axisRay = axisRay;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        /*The vector from the point of the cylinder to the given point*/
        Point3D o = new Point3D(axisRay.get_point());
        Vector v = new Vector(axisRay.get_direction());

        Vector vector1 = p.subtract(o);

        //We need the projection to multiply the _direction unit vector
        double projection = vector1.dotProduct(v);
        if(!Util.isZero(projection))
        {
            // projection of P-O on the ray:
            o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
        Vector check = p.subtract(o);
        return check.normalize();
    }


}
