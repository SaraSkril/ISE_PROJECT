package elements;

import Primitives.Color;
import Primitives.Point3D;
/**
 *  abstract class Light represent a class in the scene
 * @author the quad
 */
public abstract class Light {
    /**
     * _intensity value, set to protected
     */
    protected Color _intensity;
    /**
     * @return the intensity of the light
     */
    public Color getIntensity() {
        return new Color(_intensity);
    }
}
