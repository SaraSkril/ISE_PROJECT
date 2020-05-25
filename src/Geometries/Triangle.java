package Geometries;

import Primitives.*;

import java.util.List;

import static Primitives.Util.isZero;

/**
 * Class Triangle is the basic class representing triangle
 *Cylinder extends Radial Geometry
 * @author ELisheva Aronstam  and Sara Raizel Skriloff
 */

public class Triangle extends Polygon
{
    //constructor using polygons constructor
    public Triangle(Point3D... vertices) {
        super(vertices);
    }
    public Triangle(Color emmisionL, Point3D... vertices)
    {
        super(emmisionL,vertices);
       // _emmission=emmisionL;
    }
    public Triangle(Color emissionLight, Material material, Point3D p1, Point3D p2, Point3D p3) {
        super(emissionLight,material,p1,p2,p3);
    }


    @Override
    public List<GeoPoint> findIntsersections(Ray ray) {
        List<GeoPoint> intersections = _plane.findIntsersections(ray);
        if (intersections == null) return null;

        Point3D p0 = ray.getPoint();
        Vector v = ray.get_direction();

        Vector v1 = _vertices.get(0).subtract(p0);
        Vector v2 = _vertices.get(1).subtract(p0);
        Vector v3 = _vertices.get(2).subtract(p0);

        double s1 = v.dotProduct(v1.crossProduct(v2));
        if (isZero(s1)) return null;
        double s2 = v.dotProduct(v2.crossProduct(v3));
        if (isZero(s2)) return null;
        double s3 = v.dotProduct(v3.crossProduct(v1));
        if (isZero(s3)) return null;


        if ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) {
            for (GeoPoint geo : intersections) {
                geo.geometry = this;
            }
            return intersections;
        }

        return null;

    }
}
