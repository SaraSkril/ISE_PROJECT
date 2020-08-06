package renderer;

import elements.*;
import Geometries.*;
import Primitives.*;
import scene.*;

import java.util.List;

import static Geometries.Intersectable.GeoPoint;
import static Primitives.Util.alignZero;
import static Primitives.Util.isZero;

/**
 * class renderer create the image and Realizing the picture
 * @author the quad
 */
public class Render {
    private static final int MAX_CALC_COLOR_LEVEL = 10;
    private static final double MIN_CALC_COLOR_K = 0.001;
    /**
     * image writer parameter
     */
    private final ImageWriter _imageWriter;
    /**
     * scene parameter
     */
    private final Scene _scene;

    private double _supersamplingDensity = 4d;
    private boolean On_OFF = false;
    /**
     * Fixed variable for moving
     * first rays for shading, transparency and reflection
     */
    private static final double DELTA = 0.1;

    /**
     * render constructor
     * @param imageWriter
     * @param scene
     */
    public Render(ImageWriter imageWriter, Scene scene) {
        this._imageWriter = imageWriter;
        this._scene = scene;

    }

    /**
     *
     * @return supersampling density
     */
    public double getSupersamplingDensity() {
        return _supersamplingDensity;
    }

    /**
     *
     * @param supersamplingDensity
     */
    public Render setSupersamplingDensity(double supersamplingDensity) {
        _supersamplingDensity = supersamplingDensity;
        return this;
    }

    /**
     * tells if supersampling is on or off
     * @return on or off
     */
    public boolean getOn_OFF() {
        return On_OFF;
    }

    /**
     *
     * @param ON_OFF
     * sets if supersampling is on or off
     */
    public Render setOn_OFF(boolean ON_OFF) {
        On_OFF = ON_OFF;
        return this;
    }

    /**
     *
     * @param interval
     * @param color
     */
    public void printGrid(int interval, java.awt.Color color) {
        int Nx = _imageWriter.getNx();
        int Ny = _imageWriter.getNy();
        for (int i = 0; i < Ny; i++) {
            for (int j = 0; j < Nx; j++) {
                if (i % interval == 0 || j % interval == 0) {
                    _imageWriter.writePixel(j, i, color);
                }
            }
        }
    }

    /**
     * writes to image
     */
    public void writeToImage() {
        _imageWriter.writeToImage();
    }

    /**
     * render image function realizing the image
     */
    public void renderImage() {
        Camera camera = _scene.get_camera();
        Intersectable geometries = _scene.get_geometries();
        java.awt.Color background = _scene.get_background().getColor();
        AmbientLight ambientLight = _scene.get_ambientLight();
        double distance = _scene.get_distance();

        int Nx = _imageWriter.getNx();
        int Ny = _imageWriter.getNy();
        double width = _imageWriter.getWidth();
        double height = _imageWriter.getHeight();

        if (On_OFF==false) {
            for (int row = 0; row < Ny; row++) {
                for (int collumn = 0; collumn < Nx; collumn++) {
                    Ray ray = camera.constructRayThroughPixel(Nx, Ny, collumn, row, distance, width, height);
                    GeoPoint closestPoint = findClosestIntersection(ray);
                    if (closestPoint == null) {
                        _imageWriter.writePixel(collumn, row, background);
                    } else {
                        _imageWriter.writePixel(collumn, row, calcColor(closestPoint, ray).getColor());
                    }
                }
            }
        }
        else
        {    //supersampling

            for (int row = 0; row < Ny; row++) {
                for (int collumn = 0; collumn < Nx; collumn++) {
                    Ray ray = camera.constructRayThroughPixel(Nx, Ny, collumn, row, distance, width, height);
                    GeoPoint centerPoint = findClosestIntersection(ray);
                    Color Bckg = new Color(background);
                    Color averageColor = Color.BLACK;
                    List<Ray> rayBeam = camera.constructRayBeamThroughPixel(Nx, Ny, collumn, row, distance, width, height, _supersamplingDensity);
                    rayBeam.add(ray);
                    _imageWriter.writePixel(collumn, row, calcColor(rayBeam).getColor());
                }
            }
        }

    }


    /**
     *
     * @param intersectionPoints
     * @return closest point
     */
    private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {

        if (intersectionPoints == null) {
            return null;
        }

        GeoPoint result = null;

        Point3D p0 = _scene.get_camera().get_p0();
        double minDist = Double.MAX_VALUE;
        double currentDistance;

        for (GeoPoint geoPoint : intersectionPoints) {
            currentDistance = p0.distance(geoPoint.getPoint());
            if (currentDistance < minDist) {
                minDist = currentDistance;
                result = geoPoint;
            }
        }
        return result;
    }

    /**
     * Find intersections of a ray with the scene geometries and get the
     * intersection point that is closest to the ray head. If there are no
     * intersections, null will be returned.
     *
     * @param ray intersecting the scene
     * @return the closest point
     */
    private GeoPoint findClosestIntersection(Ray ray) {

        if (ray == null) {
            return null;
        }

        GeoPoint closestPoint = null;
        double closestDistance = Double.MAX_VALUE;
        Point3D ray_p0 = ray.getPoint();

        List<GeoPoint> intersections = _scene.get_geometries().findIntsersections(ray);
        if (intersections == null)
            return null;

        for (GeoPoint geoPoint : intersections) {
            double distance = ray_p0.distance(geoPoint.getPoint());
            if (distance < closestDistance) {
                closestPoint = geoPoint;
                closestDistance = distance;
            }
        }
        return closestPoint;
    }

    /**
     * Calculate the specific color
     * @param inRay
     * @return the Calculation of the specific color
     */
    private Color calcColor(List<Ray> inRay) {
        Color bkg = _scene.get_background();
        Color color = Color.BLACK;
        for (Ray ray : inRay) {
            GeoPoint gp = findClosestIntersection(ray);
            color = color.add(gp == null ? bkg : calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, 1d));
        }
        color = color.add(_scene.get_ambientLight().getIntensity());
        int size = inRay.size();
        return (size == 1) ? color : color.reduce(size);
    }

    /**
     *  Calculate the specific color
     * @param geoPoint
     * @param inRay
     * @return the Calculation of the specific color
     */
    private Color calcColor(GeoPoint geoPoint, Ray inRay) {
        Color color = calcColor(geoPoint, inRay, MAX_CALC_COLOR_LEVEL, 1.0);
        color = color.add(_scene.get_ambientLight().getIntensity());
        return color;
    }

    /**
     * Calculate the specific color
     * @param geoPoint
     * @param inRay
     * @param level
     * @param k
     * @return the Calculation of the specific color
     */
    private Color calcColor(GeoPoint geoPoint, Ray inRay, int level, double k) {
        if (level == 1 || k < MIN_CALC_COLOR_K) {
            return Color.BLACK;
        }

        Color result = geoPoint.getGeometry().get_emmission();
        Point3D pointGeo = geoPoint.getPoint();

        Vector v = pointGeo.subtract(_scene.get_camera().get_p0()).normalize();
        Vector n = geoPoint.getGeometry().getNormal(pointGeo);

        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) {
            //ray parallel to geometry surface ??
            //and orthogonal to normal
            return result;
        }

        Material material = geoPoint.getGeometry().get_material();
        int nShininess = material.getnShininess();
        double kd = material.getkD();
        double ks = material.getkS();
        double kr = geoPoint.getGeometry().get_material().getKr();///////
        double kt = geoPoint.getGeometry().get_material().getKt();
        double kkr = k * kr;
        double kkt = k * kt;

        result = result.add(getLightSourcesColors(geoPoint, k, result, v, n, nv, nShininess, kd, ks));

        if (kkr > MIN_CALC_COLOR_K) {
            Ray reflectedRay = constructReflectedRay(pointGeo, inRay, n);
            GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
            if (reflectedPoint != null) {
                result = result.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kr));
            }
        }
        if (kkt > MIN_CALC_COLOR_K) {
            Ray refractedRay = constructRefractedRay(pointGeo, inRay, n);
            GeoPoint refractedPoint = findClosestIntersection(refractedRay);
            if (refractedPoint != null) {
                result = result.add(calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kt));
            }
        }
        return result;
    }

    /**
     *
     * @param geoPoint
     * @param k
     * @param result
     * @param v
     * @param n
     * @param nv
     * @param nShininess
     * @param kd
     * @param ks
     * @return light source color
     */
    private Color getLightSourcesColors(GeoPoint geoPoint, double k, Color result, Vector v, Vector n, double nv, int nShininess, double kd, double ks) {
        Point3D pointGeo = geoPoint.getPoint();
        List<LightSource> lightSources = _scene.get_lights();
        if (lightSources != null) {
            for (LightSource lightSource : lightSources) {
                Vector l = lightSource.getL(pointGeo);
                double nl = alignZero(n.dotProduct(l));
                if (nl * nv > 0) {
//                if (sign(nl) == sign(nv) && nl != 0 && nv != 0) {
//                    if (unshaded(lightSource, l, n, geoPoint)) {
                    double ktr = transparency(lightSource, l, n, geoPoint);
                    if (ktr * k > MIN_CALC_COLOR_K) {
                        Color ip = lightSource.getIntensity(pointGeo).scale(ktr);
                        result = result.add(
                                calcDiffusive(kd, nl, ip),
                                calcSpecular(ks, l, n, nl, v, nShininess, ip));
                    }
                }
            }
        }
        return result;
    }

    /**
     * construct a refracted ray
     * @param pointGeo
     * @param inRay
     * @param n
     * @return refracted ray
     */
    private Ray constructRefractedRay(Point3D pointGeo, Ray inRay, Vector n) {
        return new Ray(pointGeo, inRay.get_direction(), n);
    }

    /**
     * construct a Reflected Ray
     * @param pointGeo
     * @param inRay
     * @param n
     * @return reflected ray
     */
    private Ray constructReflectedRay(Point3D pointGeo, Ray inRay, Vector n) {

        Vector v = inRay.get_direction();
        double vn = v.dotProduct(n);

        if (vn == 0) {
            return null;
        }

        Vector r = v.subtract(n.scale(2 * vn));
        return new Ray(pointGeo, r, n);
    }

    /**
     * Calculate Specular component of light reflection.
     *
     * @param ks         specular component coef
     * @param l          direction from light to point
     * @param n          normal to surface at the point
     * @param nl         dot-product n*l
     * @param V          direction from point of view to point
     * @param nShininess shininess level
     * @param ip         light intensity at the point
     * @return specular component light effect at the point
     * @author Dan Zilberstein (slightly modified by me)
     * <p>
     * Finally, the Phong model has a provision for a highlight, or specular, component, which reflects light in a
     * shiny way. This is defined by [rs,gs,bs](-V.R)^p, where R is the mirror reflection direction vector we discussed
     * in class (and also used for ray tracing), and where p is a specular power. The higher the value of p, the shinier
     * the surface.
     * </p>
     */
    private Color calcSpecular(double ks, Vector l, Vector n, double nl, Vector V, int nShininess, Color ip) {
        double p = nShininess;
        if (isZero(nl)) {
            throw new IllegalArgumentException("nl cannot be Zero for scaling the normal vector");
        }
        Vector R = l.add(n.scale(-2 * nl)); // nl must not be zero!
        double VR = alignZero(V.dotProduct(R));
        if (VR >= 0) {
            return Color.BLACK; // view from direction opposite to r vector
        }
        // [rs,gs,bs]ks(-V.R)^p
        return ip.scale(ks * Math.pow(-1d * VR, p));
    }

    /**
     * Calculate Diffusive component of light reflection.
     *
     * @param kd diffusive component coef
     * @param nl dot-product n*l
     * @param ip light intensity at the point
     * @return diffusive component of light reflection
     * @author Dan Zilberstein
     * <p>
     * The diffuse component is that dot product n•L. It approximates light, originally from light source L,
     * reflecting from a surface which is diffuse, or non-glossy. One example of a non-glossysurface is paper.
     * In general, you'll also want this to have a non-gray color value,
     * so this term would in general be a color defined as: [rd,gd,bd](n•L)
     * </p>
     */
    private Color calcDiffusive(double kd, double nl, Color ip) {
        return ip.scale(Math.abs(nl) * kd);
    }

    /**
     * Returns false  for negative number and true for positive number
     * @param val
     * @return true or false
     */
    private boolean sign(double val) {
        return (val > 0d);
    }

    /**
     *
     * @param light
     * @param l
     * @param n
     * @param geopoint
     * @return close intersection point
     */
    private double transparency(LightSource light, Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Ray lightRay = new Ray(geopoint.getPoint(), lightDirection, n);
        Point3D pointGeo = geopoint.getPoint();

        List<GeoPoint> intersections = _scene.get_geometries().findIntsersections(lightRay);
        if (intersections == null) {
            return 1d;
        }
        double lightDistance = light.getDistance(pointGeo);
        double ktr = 1d;
        for (GeoPoint gp : intersections) {
            if (alignZero(gp.getPoint().distance(pointGeo) - lightDistance) <= 0) {
                ktr *= gp.getGeometry().get_material().getKt();
                if (ktr < MIN_CALC_COLOR_K) {
                    return 0.0;
                }
            }
        }
        return ktr;
    }

    /**
     * checks if the point is shaded
     * @param light
     * @param l
     * @param n
     * @param geopoint
     * @return true or false
     */
    private boolean unshaded(LightSource light, Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        Ray lightRay = new Ray(geopoint.getPoint(), lightDirection, n);
        Point3D pointGeo = geopoint.getPoint();

        List<GeoPoint> intersections = _scene.get_geometries().findIntsersections(lightRay);
        if (intersections == null) {
            return true;
        }
        double lightDistance = light.getDistance(pointGeo);
        for (GeoPoint gp : intersections) {
            if (alignZero(gp.getPoint().distance(pointGeo) - lightDistance) <= 0
                    && gp.getGeometry().get_material().getKt() == 0) {
                return false;
            }
        }
        return true;
    }


}