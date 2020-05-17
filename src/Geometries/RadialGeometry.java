package Geometries;

import Primitives.Color;

/**
 * Class Radial Geometry is the abstract class representing Radial Geometry
 *Cylinder extends implements Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
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

    /*
    returns radius
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
