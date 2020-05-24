package Geometries;

import Primitives.Color;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;


/*Class Geometry is the abstract class representing a Geometry and implements intercectible
         * @author ELisheva Aronstam  and Sara Raizel Skriloff
        */
public abstract class Geometry implements Intersectable{
   protected Color _emmission;
   protected Material _material;

   public Geometry(Material _material,Color _emmission) {
      this._material = _material;
      this._emmission=_emmission
   }

   public Material get_material() {
      return _material;
   }


   public abstract Vector getNormal(Point3D p);/**returns normal to p*/
   /*returns emmission*/
   public Color get_emmission() {
      return _emmission;
   }

   public Geometry(Color _emmission) {
      this._emmission = new Color(_emmission);
   }
   public Geometry() {
      this._emmission = Color.BLACK;
   }
}
