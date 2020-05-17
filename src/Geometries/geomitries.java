package Geometries;
import jdk.jshell.spi.ExecutionControl;
import Primitives.Point3D;
import Primitives.Ray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class geomitries implements Intersectable
{
    private List<Intersectable> _geometries = new LinkedList<Intersectable>();

    public geomitries(Intersectable... _geometries) {
        add( _geometries);
    }

    public void add(Intersectable... geometries) {
        for (Intersectable geo : geometries ) {
            _geometries.add(geo);
        }
    }



    public List<Intersectable> get_geometries() {
        return _geometries;
    }

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
