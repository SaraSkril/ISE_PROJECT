package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

/**
 * Geometry Interface, All geometry will implement
 */

public interface Geometry extends Intersectable{
   public Vector getNormal(Point3D p);/**returns normal to p*/
}
