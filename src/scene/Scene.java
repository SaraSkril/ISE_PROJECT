package scene;
import Primitives.*;
import elements.*;
import Geometries.*;

import java.util.LinkedList;
import java.util.List;

/**
 * class scene hold all the parameters of the scene
 * @author the quad
 *
 */
public class Scene {
    /**
     * name of the scene
     */
    String _name;
    /**
     * background color of the scene
     */
    Color _background;
    /**
     * the ambient light of the scene
     */
    AmbientLight _ambientLight;
    /**
     * list of the geometries in the scene
     */
    geomitries _geometries;
    /**
     * the camera in the scene
     */
    Camera _camera;
    /**
     * the distance between the view plane and the camera
     */
    double _distance;
    /**
     * list of lights in the scene
     */
    List<LightSource> _lights=null;

    /**
     * *constructor for scene -receives the name of the scene
     * @param _name
     */
    public Scene(String _name) {
        this._name = _name;
        _geometries=new geomitries();
        _lights=new LinkedList<LightSource>();
    }

    /**
     *
     * @return name of the scene
     */
    public String get_name() {
        return _name;
    }

    /**
     *
     * @return background of the scene
     */
    public Color get_background() {
        return _background;
    }

    /**
     *
     * @return ambient light of the scene
     */
    public AmbientLight get_ambientLight() {
        return _ambientLight;
    }

    /**
     *
     * @return list of the geometries in the scene
     */
    public geomitries get_geometries() {
        return _geometries;
    }

    /**
     *
     * @return camera in the scene
     */
    public Camera get_camera() {
        return _camera;
    }

    /**
     *
     * @return the distance between the view plane and the camera
     */
    public double get_distance() {
        return _distance;
    }

    /**
     *
     * @param _background - background color of the scene
     */
    public void set_background(Color _background) {
        this._background = _background;
    }

    /**
     *
     * @param _ambientLight - the ambient light of the scene
     */
    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    /**
     *
     * @param _camera - the camera in the scene
     */
    public void set_camera(Camera _camera) {
        this._camera = _camera;
    }

    /**
     *
     * @param _distance  - the distance between the view plane and the camera
     */
    public void set_distance(double _distance) {
        this._distance = _distance;
    }

    /**
     * the function to add new geometry to the scene
     * @param Geometries
     */
    public void addGeometries(Intersectable... Geometries)
    {
        for (Intersectable i : Geometries)
            _geometries.add(i);
    }

    /**
     * the function to add new lights to the scene
     * @param lights
     */
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

    /**
     * inner scene builder class
     */
    public static class SceneBuilder {
        private String name;
        private Color background;
        private Camera camera;
        private double distance;
        private AmbientLight ambientLight;

        /**
         * constructor for scene builder
         * @param name
         */
        public SceneBuilder(String name) {
            this.name = name;
        }

        /**
         * the function to add a background to the scene
         * @param background
         */
        public SceneBuilder addBackground(Color background) {
            this.background = background;
            return this;
        }

        /**
         * the function to add a camera to the scene
         * @param camera
         */
        public SceneBuilder addCamera(Camera camera) {
            this.camera = camera;
            return this;
        }

        /**
         * the function to add the distance to the scene
         * @param distance
         */
        public SceneBuilder addDistance(double distance) {
            this.distance = distance;
            return this;
        }

        /**
         * the function to add the ambient light to the scene
         * @param ambientLight
         */
        public SceneBuilder addAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }

        /**
         * build the scene
         * @return the scene
         */
        public Scene build() {
            Scene scene = new Scene(this.name);
            scene._camera = this.camera;
            scene._distance = this.distance;
            scene._background = this.background;
            scene._ambientLight = this.ambientLight;
            validateUserObject(scene);
            return scene;
        }

        private void validateUserObject(Scene scene) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}

