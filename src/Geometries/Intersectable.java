package Geometries;
import Primitives.Point3D;
import Primitives.Ray;
import java.util.List;
import java.util.Objects;

public interface Intersectable
{
    List<GeoPoint> findIntsersections(Ray ray);

    /**
     * Class GeoPoint is a class representing a GeoPoint
     * GeoPiont has contains a geometry and Point3D
     * @author ELisheva Aronstam  and Sara Raizel Skriloff
     */
    public static class GeoPoint {
        public Geometry geometry;
        public Point3D point;

         /*Constructor */

        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return geometry.equals(geoPoint.geometry)&&point.equals(geoPoint.point);

        }

    }

}
