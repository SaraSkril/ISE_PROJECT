package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import java.util.List;
import java.util.Objects;
/**
 * interface Intersectable represents findIntersections function
 * @author the quad
 */
public interface Intersectable
{
    List<GeoPoint> findIntsersections(Ray ray);

    /**
     * Class GeoPoint is a class representing a GeoPoint
     * GeoPiont has contains a geometry and Point3D
     * @author the quad
     */
    public static class GeoPoint {
        /**
         * the geometry
         */
        public Geometry geometry;
        /**
         * the point
         */
        public Point3D point;


        /**
         * constructor
         * @param geometry
         * @param point
         */
        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }

        /**
         *
         * @return geometry
         */
        public Geometry getGeometry() {
            return geometry;
        }

        /**
         *
         * @return point
         */
        public Point3D getPoint() {
            return point;
        }

        /**
         * equals function
         * @param o
         * @return boolean true or false if equality or not
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return geometry.equals(geoPoint.geometry)&&point.equals(geoPoint.point);

        }

    }

}
