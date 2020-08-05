package elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Util;
import Primitives.Vector;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static Primitives.Util.isZero;
/**
 * camera class represents a camera in the scene.
 * @author the quad
 *
 */
public class Camera {
    private static final int k=80;
    private static final Random rnd = new Random();//we dicided to do the beam of rays in a random position (best option)
    /**
     * _p0 is the location of the camera
     */
    Point3D _p0;
    /**
     * vector to
     */
    Vector _vTo;
    /**
     * vector up
     */
    Vector _vUp;
    /**
     * vector right
     */
    Vector _vRight;

    /**
     * camera constructor
     * @param _p0
     * @param _vTo
     * @param _vUp
     */
    public Camera(Point3D _p0, Vector _vTo, Vector _vUp) {

        //if the the vectors are not orthogonal, throw exception.
        if (_vUp.dotProduct(_vTo) != 0)
            throw new IllegalArgumentException("the vectors must be orthogonal");

        this._p0 = new Point3D(_p0);
        this._vTo = _vTo.normalized();
        this._vUp = _vUp.normalized();

        _vRight = this._vTo.crossProduct(this._vUp).normalize();

    }

    /**
     *
     * @return camera location
     */
    public Point3D get_p0() {
        return new Point3D(_p0);
    }

    /**
     *
     * @return vector to
     */
    public Vector get_vTo() {
        return new Vector(_vTo);
    }

    /**
     *
     * @return vector up
     */
    public Vector get_vUp() {
        return new Vector(_vUp);
    }

    /**
     *
     * @return vector right
     */
    public Vector get_vRight() {
        return new Vector(_vRight);
    }

    /**
     * construct ray through pixel
     * @param nX
     * @param nY
     * @param j
     * @param i
     * @param screenDistance
     * @param screenWidth
     * @param screenHeight
     * @return
     */
    public Ray constructRayThroughPixel(int nX, int nY,
                                        int j, int i, double screenDistance,
                                        double screenWidth, double screenHeight) {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);

        Point3D Pij = Pc;

        if (!isZero(xj)) {
            Pij = Pij.add(_vRight.scale(xj));
        }
        if (!isZero(yi)) {
            Pij = Pij.add(_vUp.scale(-yi)); // Pij.subtract(_vUp.scale(yi))
        }

        Vector Vij = Pij.subtract(_p0);

        return new Ray(_p0, Vij);

    }


    /**
     * construct ray beam through pixel, for supersampling
     * @param nX
     * @param nY
     * @param j
     * @param i
     * @param screenDistance
     * @param screenWidth
     * @param screenHeight
     * @param density
     * @return
     */
    public List<Ray> constructRayBeamThroughPixel(int nX, int nY, int j, int i,
                                                  double screenDistance, double screenWidth, double screenHeight,
                                                  double density)
    {
        if (isZero(screenDistance)) {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        List<Ray> rays = new LinkedList<>();

        Point3D Pc = _p0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight / nY;
        double Rx = screenWidth / nX;

        double yi = ((i - nY / 2d) * Ry + Ry / 2d);
        double xj = ((j - nX / 2d) * Rx + Rx / 2d);

        Point3D Pij = Pc;

        if (!isZero(xj)) {
            Pij = Pij.add(_vRight.scale(xj));
        }
        if (!isZero(yi)) {
            Pij = Pij.subtract(_vUp.scale(yi)); // Pij.add(_vUp.scale(-yi))
        }

        //antialiasing density >= 1
        double radius = ((Rx + Ry) / 2d) * density;


        /*if (!ON_OFF) {//using dry
            rays.add(constructRayThroughPixel(nX, nY, j, i, screenDistance, screenWidth, screenHeight));
            return rays;
        }
        for(int tempI=i-(int)density;tempI<i+(int)density;tempI+=7)
        {
            for(int tempJ=j-(int)density;tempJ<j+(int)density;tempJ+=7) {
                Point3D point=new Point3D(tempI,tempJ,Pij.get_z().get());
                rays.add(new Ray(_p0, point.subtract(_p0)));
            }


        }
        /*for(int tempJ=j-7;tempJ<j+7;tempJ++)
        {
            Point3D point = new Point3D(i,tempJ,Pij.get_z().get());
            rays.add(new Ray(_p0, point.subtract(_p0)));
        }
*/

        for (int counter = 0; counter < k; counter++) {
            Point3D point = new Point3D(Pij);
            double cosTheta = 2 * rnd.nextDouble() - 1;
            double sinTheta = Math.sqrt(1d - cosTheta * cosTheta);

            double d = radius * (2 * rnd.nextDouble() - 1);
            double x = d * cosTheta;
            double y = d * sinTheta;

            if (!isZero(x)) {
                point = point.add(_vRight.scale(x));
            }
            if (!isZero(y)) {
                point = point.add(_vUp.scale(y));
            }
            rays.add(new Ray(_p0, point.subtract(_p0)));
        }
        return rays;
    }
}

