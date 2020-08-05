package elements;
import Primitives.Color;

/**
 *class ambient light represents the ambient light in the scene.
 *  @author the quad
 */
public class AmbientLight extends Light
{

    /**
     * Ambient Light constructor
     * @param _intensity
     * @param ka
     */
    public AmbientLight(Color _intensity, double ka)
    {
        this._intensity = _intensity.scale(ka);
    }


}


