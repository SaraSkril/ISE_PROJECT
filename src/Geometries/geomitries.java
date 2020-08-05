package Geometries;
import jdk.jshell.spi.ExecutionControl;
import Primitives.Point3D;
import Primitives.Ray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * Geometries class represents list of geometries intersections
 * @author the quad
 */
public class geomitries implements Intersectable
{
    /**
     * list of the geometries intersections
     */
    private List<Intersectable> _geometries = new LinkedList<Intersectable>();

    /**
     * constructor
     * @param _geometries
     */
    public geomitries(Intersectable... _geometries) {
        add( _geometries);
    }
    /**
     * add a new geometry to the list
     * @param geometries
     */
    public void add(Intersectable... geometries) {
        for (Intersectable geo : geometries ) {
            _geometries.add(geo);
        }
    }


    /**
     *
     * @return geometries list
     */
    public List<Intersectable> get_geometries() {
        return _geometries;
    }

    /**
     *
     * @param ray
     * @return the intersection between the ray and the geometries
     */
    @Override
    public List<GeoPoint> findIntsersections(Ray ray) {
        List<GeoPoint> intersections = null;

        for (Intersectable geo : _geometries) {
            List<GeoPoint> tempIntersections = geo.findIntsersections(ray);
            if (tempIntersections != null) {
                if (intersections == null)
                    intersections = new LinkedList<GeoPoint>();
                intersections.addAll(tempIntersections);
            }
        }
        return intersections;
    }
}
