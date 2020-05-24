package elements;
import static java.lang.Math.max;
import Primitives.Color;
import Primitives.Point3D;
import Primitives.Vector;

public class SpotLight extends PointLight
{private Vector _direction;

    public SpotLight(Color colorIntensity, Point3D position, double kC, double kL, double kQ) {
        super(colorIntensity, position, kC, kL, kQ);
        this._direction=new Vector(_direction).normalized();
    }
@Override
public Vector getL(Point3D p)
{return _direction.normalize();}

public Color getIntensity(Point3D p) {
    double _distance = p.distance(_position);
    double m = max(0, _direction.dotProduct(super.getL(p)));
    return _intensity.scale(m / (_kC + _kL * _distance + _kQ * _distance * _distance));
}
}
