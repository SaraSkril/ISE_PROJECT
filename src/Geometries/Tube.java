package Geometries;
import Primitives.*;
import elements.Material;

import java.util.List;

import static Primitives.Util.isZero;

/**
 * Class Tube is the basic class representing tube
 *Cylinder extends Radial Geometry
 * @author the quad
 */
public class Tube extends RadialGeometry
{
    /**
     * the ray axis of the tube
     */
    Ray axisRay;

    /*
    Constructor for tube using the radial Geometry constructor
     */
    public Tube(double _radius, Ray axisRay) {
        super(_radius);
        this.axisRay = axisRay;
    }

    /**
     * constructor
     * @param _emmission
     * @param _radius
     * @param axisRay
     */
    public Tube(Color _emmission, double _radius, Ray axisRay) {
        super(_emmission, _radius);
        this.axisRay = axisRay;
    }
    /**
     * constructor for a new Cylinder object
     *
     * @param _radius       the radius of the tube
     * @param _ray          the direction of the tube from the referenced point
     * @param _material     the material of the tube
     * @param emissionLight the emission light of the tube

     */
    public Tube(Color emissionLight, Material _material, double _radius, Ray _ray) {
        super(Color.BLACK, _radius);
        this._material = _material;
        this.axisRay = new Ray(_ray);

    }

    /**
     *
     * @param p
     * @return the normal vector of the tube
     */
    @Override
    public Vector getNormal(Point3D p)
    {
        double t = axisRay.get_direction().dotProduct(p.subtract(axisRay.getPoint()));
        Point3D O=axisRay.getPoint();
        if(!isZero(t));
        O = O.add( axisRay.get_direction().scale(t));
        return p.subtract(O).normalize();
    }

    /**
     *
     * @param ray
     * @return intersections
     */
    @Override
    public List<GeoPoint> findIntsersections(Ray ray) {

        return null;
    }
}
