package Geometries;

/**
 * Class Radial Geometry is the abstract class representing Radial Geometry
 *Cylinder extends implements Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
 */
public abstract class RadialGeometry implements Geometry
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
}
