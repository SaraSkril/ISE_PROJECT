package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
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
    public Vector getNormal(Point3D p) {
        return null;
    }


}
