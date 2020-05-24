package elements;
import Primitives.Color;

public class AmbientLight extends Light
{


    public AmbientLight(Color _intensity, double ka)
    {
        this._intensity = _intensity.scale(ka);
    }


}


