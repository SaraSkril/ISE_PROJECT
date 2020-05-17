package Geometries;
import Primitives.*;

import java.util.List;

import static Primitives.Util.isZero;

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

    public Tube(Color _emmission, double _radius, Ray axisRay) {
        super(_emmission, _radius);
        this.axisRay = axisRay;
    }

    @Override
    public Vector getNormal(Point3D p)
    {
        double t = axisRay.get_direction().dotProduct(p.subtract(axisRay.getPoint()));
        Point3D O=axisRay.getPoint();
        if(!isZero(t));
        O = O.add( axisRay.get_direction().scale(t));
        return p.subtract(O).normalize();
    }


    @Override
    public List<GeoPoint> findIntsersections(Ray ray) {

        return null;
    }
}
