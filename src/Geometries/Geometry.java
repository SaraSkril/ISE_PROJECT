package Geometries;

import Primitives.Color;
import elements.Material;
import Primitives.Point3D;
import Primitives.Vector;


/*Class Geometry is the abstract class representing a Geometry and implements intersectable
* @author ELisheva Aronstam  and Sara Raizel Skriloff and sara teigman and esther aviva burack
*/
public abstract class Geometry implements Intersectable{
   /**
    * the color emmission of the geometry
    */
   protected Color _emmission;
   /**
    * the material of the geometry
    */
   protected Material _material;


   /**
    * constructor that recieves both parameters of Geometry
    * @param emmission
    * @param _material
    */
   public Geometry(Color emmission, Material _material) {
      _emmission = new Color(emmission);
      this._material = new Material(_material);
   }
   /**
    * @return material geometry is made of
    */
   public Material get_material() {
      return _material;
   }


   public abstract Vector getNormal(Point3D p);/**returns normal to p*/
   /*returns emmission*/
   public Color get_emmission() {
      return _emmission;
   }

   /**
    * constructor that recieves only emission light
    * @param emmission
    */
   public Geometry(Color emmission) {
      this(emmission, new Material(0,0,0));
   }

   /**
    * default constructor creates a balck geometry with no emission light
    */
   public Geometry(){
      this(Color.BLACK, new Material(0,0,0));
   }
}
