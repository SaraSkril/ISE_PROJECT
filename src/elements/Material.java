package elements;

/**
 * material class to store other information about the scene
 */
public class Material {
    /**
     * kd factor for attenuation
     */
    private final double _kD;
    /**
     * ks factor for attenuation
     */
    private final double _kS;
    /**
     * the shininess of the material
     */
    private final int _nShininess;
    /**
     * reflection factor
     */
    private final double _kr;
    /**
     * refraction factor
     */
    private final double _kt;

    /**
     * material constructor
     * @param kD
     * @param kS
     * @param nShininess
     * @param kt
     * @param kr
     */
    public Material(double kD, double kS, int nShininess, double kt, double kr) {
        this._kD = kD;
        this._kS = kS;
        this._nShininess = nShininess;
        this._kt = kt;
        this._kr = kr;
    }

    /**
     * material constructor
     * @param kD
     * @param kS
     * @param nShininess
     */
    public Material(double kD, double kS, int nShininess)
    {
        this(kD, kS, nShininess, 0, 0);
    }

    /**
     * material constructor
     * @param material
     */
    public Material(Material material) {
        this(material._kD, material._kS, material._nShininess, material._kt, material._kr);
    }

    /**
     *
     * @return shininess of the material
     */
    public int getnShininess() {
        return _nShininess;
    }

    /**
     *
     * @return kD
     */
    public double getkD() {
        return _kD;
    }

    /**
     *
     * @return kS
     */
    public double getkS() {
        return _kS;
    }

    /**
     *
     * @return kR
     */
    public double getKr() {
        return _kr;
    }

    /**
     *
     * @returnkT
     */
    public double getKt() {
        return _kt;
    }
}