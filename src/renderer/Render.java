//package renderer;

//public class Render {}
package renderer;

import elements.*;
import Geometries.*;
import Primitives.*;
//import Geometries.Intersectable.GeoPoint;
import scene.Scene;

import java.util.List;

import static Primitives.Util.alignZero;
import Geometries.Intersectable.GeoPoint;
public class Render {

    private ImageWriter _imageWriter;
    private Scene _scene;

    public Render(Scene _scene) {
        this._scene = _scene;
    }

    public Render(ImageWriter imageWriter, Scene scene) {
        this._imageWriter = imageWriter;
        this._scene = scene;
    }

    public Scene get_scene() {
        return _scene;
    }

    /**
     * Filling the buffer according to the geometries that are in the scene.
     * This function does not creating the picture file, but create the buffer pf pixels
     */
    public void renderImage() {
        java.awt.Color background = _scene.get_background().getColor();
        Camera camera = _scene.get_camera();
        Intersectable geometries = _scene.get_geometries();
        double distance = _scene.get_distance();

        //width and height are the number of pixels in the rows
        //and columns of the view plane
        int width = (int) _imageWriter.getWidth();
        int height = (int) _imageWriter.getHeight();

        //Nx and Ny are the width and height of the image.
        int Nx = _imageWriter.getNx(); //columns
        int Ny = _imageWriter.getNy(); //rows
        //pixels grid
        for (int row = 0; row < Ny; ++row) {
            for (int column = 0; column < Nx; ++column) {
                Ray ray = camera.constructRayThroughPixel(Nx, Ny, column, row, distance, width, height);
                List<GeoPoint> intersectionPoints = geometries.findIntsersections(ray);
                if (intersectionPoints == null) {
                    _imageWriter.writePixel(column, row, background);
                }
                else {
                    GeoPoint closestPoint = getClosestPoint(intersectionPoints);
                    java.awt.Color pixelColor = calcColor(closestPoint).getColor();
                    _imageWriter.writePixel(column, row, pixelColor);
                }
            }
        }
    }

    /**
     * Printing the grid with a fixed interval between lines
     *
     * @param interval The interval between the lines.
     */
    public void printGrid(int interval, java.awt.Color colorsep) {
        double rows = this._imageWriter.getNy();
        double columns = _imageWriter.getNx();
        //Writing the lines.
        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {
                if (column % interval == 0 || row % interval == 0) {
                    _imageWriter.writePixel(column, row, colorsep);
                }
            }
        }
    }

    /**
     * Finding the closest point to the P0 of the camera.
     *
     * @param intersectionPoints list of points, the function should find from
     *                           this list the closet point to P0 of the camera in the scene.
     * @return the closest point to the camera
     */

    private GeoPoint getClosestPoint(List<GeoPoint> intersectionPoints) {
        GeoPoint result = null;
        double startValue = Double.MAX_VALUE;

        Point3D p0 = this._scene.get_camera().get_p0();

        for (GeoPoint point3D : intersectionPoints) {
            double distance = p0.distance(point3D.point);
            if (distance < startValue) {
                startValue = distance;
                result = point3D;
            }
        }
        return result;
    }

    public void writeToImage() {
        _imageWriter.writeToImage();
    }

    private Color calcColor(GeoPoint point)
    {
       /* Color color = this._scene.get_ambientLight().get_intensity();
        color = color.add(point.geometry.get_emmission());
        return color;*/
        Color result = _scene.get_ambientLight().getIntensity();
        result = result.add(point.getGeometry().get_emmission());
        List<LightSource> lights = _scene.get_lights();

        Vector v = point.getPoint().subtract(_scene.get_camera().get_p0()).normalize();
        Vector n = point.getGeometry().getNormal(point.getPoint());

        Material material = point.getGeometry().get_material();
        int nShininess = material.getnShininess();
        double kd = material.getKd();
        double ks = material.getKs();
        if (_scene.get_lights() != null) {
            for (LightSource lightSource : lights) {

                Vector l = lightSource.getL(point.getPoint());
                double nl = alignZero(n.dotProduct(l));
                double nv = alignZero(n.dotProduct(v));

                if (sign(nl) == sign(nv)) {
                    Color ip = lightSource.getIntensity(point.getPoint());
                    result = result.add(
                            calcDiffusive(kd, nl, ip),
                            calcSpecular(ks, l, n, nl, v, nShininess, ip)
                    );
                }
            }

        }
        return result;

    }
    private Color calcDiffusive(double kd, double nl, Color ip) {
        if (nl < 0) nl = -nl;
        return ip.scale(nl * kd);
    }

    private Color calcSpecular(double ks, Vector l, Vector n, double nl, Vector v, int nShininess, Color ip) {
        double p = nShininess;

        Vector R = l.add(n.scale(-2 * nl)); // nl must not be zero!
        double minusVR = -alignZero(R.dotProduct(v));
        if (minusVR <= 0) {
            return Color.BLACK; // view from direction opposite to r vector
        }
        return ip.scale(ks * Math.pow(minusVR, p));
    }
    private boolean sign(double val)
    {
        return (val > 0d);
    }
}

