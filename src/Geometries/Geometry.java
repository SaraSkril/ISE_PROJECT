package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public interface Geometry {
   public Vector getNormal(Point3D p);/**returns normal to p*/
}
