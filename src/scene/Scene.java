package scene;
import Primitives.*;
import elements.*;
import Geometries.*;

import java.util.LinkedList;
import java.util.List;


public class Scene {
    String _name;
    Color _background;
    AmbientLight _ambientLight;
    geomitries _geometries;
    Camera _camera;
    double _distance;
    List<LightSource> _lights=null;

    /**
     * *constructor for scene -recieves the name of the scene
     * @param _name
     */
    public Scene(String _name) {
        this._name = _name;
        _geometries=new geomitries();
        _lights=new LinkedList<LightSource>();
    }

    public String get_name() {
        return _name;
    }

    public Color get_background() {
        return _background;
    }

    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    public geomitries get_geometries() {
        return _geometries;
    }

    public Camera get_camera() {
        return _camera;
    }

    public double get_distance() {
        return _distance;
    }

    public void set_background(Color _background) {
        this._background = _background;
    }

    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    public void set_distance(double _distance) {
        this._distance = _distance;
    }
    public void addGeometries(Intersectable... Geometries)
    {
        for (Intersectable i : Geometries)
            _geometries.add(i);
    }
    public void addLights(LightSource... lights) {
        for (LightSource light:lights) {
            _lights.add(light);
        }

}

    /**
     * *get list of light sources in scene
     * @return list of light in scene
     */

    public List<LightSource> get_lights() {
        return _lights;
    }
}
