package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Tube extends RadialGeometry
{
    Ray axisRay;

    public Tube(double _radius, Ray axisRay) {
        super(_radius);
        this.axisRay = axisRay;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }


}
