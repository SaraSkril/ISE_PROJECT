package Geometries;

import Primitives.Color;
import elements.Material;

import static Primitives.Util.isZero;

/**
 * Class Radial Geometry is the abstract class representing Radial Geometry
 *Cylinder extends implements Geometry
 * @author the quad
 */
public abstract class RadialGeometry extends Geometry
{
    /*
    Radios for geometry
     */
    double _radius;

    /*
    Constructor that gets a radious
     */
    public RadialGeometry(double _radius) {
        this._radius = _radius;
    }
    /*
        Constructor that gets a geometry
         */
    public RadialGeometry(RadialGeometry r)
    {
        _radius=r._radius;
    }

    /**
     *
     * @param emissionLight
     * @param radius
     * @param material
     */
    public RadialGeometry(Color emissionLight, double radius, Material material) {
        super(emissionLight, material);
        setRadius(radius);
    }

    /**
     *
     * @param radius
     */
    public void setRadius(double radius) {
        if (isZero(radius) || (radius < 0.0))
            throw new IllegalArgumentException("radius " + radius + " is not valid");
        this._radius = radius;
    }

    /**
     *
     * @return radius
     */
    public double get_radius() {
        return _radius;
    }

    /*onstructor that gets a radious and emmission*/
    public RadialGeometry(Color _emmission, double _radius) {
        super(_emmission);
        this._radius = _radius;
    }
}
