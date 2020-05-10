package elements;
import Primitives.Color;

public class AmbientLight

{
    Color _intensity;

    public AmbientLight(Color _intensity, double ka)
    {
        this._intensity = _intensity.scale(ka);
    }

    public Color get_intensity() {
        return _intensity;
    }
}


