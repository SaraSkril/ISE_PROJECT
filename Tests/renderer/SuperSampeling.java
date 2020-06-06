package renderer;


import elements.*;
import Geometries.*;
import Primitives.*;
import org.junit.Test;
import scene.Scene;
public class SuperSampeling {
    @Test
    public void trianglesSphereBeam() {
        Scene scene;
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                new Triangle(
                        Color.BLACK,
                        new Material(0, 0.8, 60,0.5,0.5), //
                        new Point3D(-150, 150, 115),
                        new Point3D(150, 150, 135),
                        new Point3D(75, -75, 150)), //
                new Triangle(
                        Color.BLACK, new Material(0, 0.8, 60), //
                        new Point3D(-150, 150, 115),
                        new Point3D(-70, -70, 140),
                        new Point3D(75, -75, 150)), //
                new Sphere(
                        new Color(java.awt.Color.BLUE),
                        new Material(0.5, 0.5, 30), // )
                        30,
                        new Point3D(0, 0, 115)));

        scene.addLights(
                new SpotLight(
                        new Color(700, 400, 400), //
                        new Point3D(40, -40, -115),
                        new Vector(-1, 1, 4),
                        1, 4E-4, 2E-5));

        ImageWriter imageWriter = new ImageWriter("trianglesSphereBeam2", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene)
                .setSupersamplingDensity(0)
                .setRayCounter(1);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void BaemTest() {
        Scene scene;
        Color c = new Color(255,255,255);
        scene = new Scene.SceneBuilder("Test scene")
                .addAmbientLight(new AmbientLight(Color.BLACK, 0))
                .addCamera(
                        new Camera(
                                new Point3D(0, 0, -1000),
                                new Vector(0, 0, 1),
                                new Vector(0, -1, 0)))
                .addDistance(1000)
                .addBackground(Color.BLACK)
                .build();

        scene.addGeometries( //
                new Plane(new Color(java.awt.Color.red),new Material(0.5,0.5,50,0.1,0.4),new Point3D(0,0,4),new Point3D(0,3,0),new Point3D(4,0,0)),
                new Sphere(
                        new Color(java.awt.Color.green),
                        new Material(0.4, 0.5, 0,0.9,0.1), // )
                        20,
                        new Point3D(-20, 40, 20)),
                new Sphere(
                        new Color(java.awt.Color.BLUE),
                        new Material(0.5, 0.5, 30,0.9,0.1), // )
                        20,
                        new Point3D(-50, -50, 20)),
                new Sphere(
                        new Color(java.awt.Color.magenta),
                        new Material(0.5, 0.5, 30,0.4,0.8), // )
                        10,
                        new Point3D(-30, -35, 20))

                );



        scene.addLights(
                new SpotLight(
                        new Color(700, 400, 400), //
                        new Point3D(40, -40, -115),
                        new Vector(-1, 1, 4),
                        1, 4E-4, 2E-5));

        ImageWriter imageWriter = new ImageWriter("Beam", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene)
                .setSupersamplingDensity(0)
                .setRayCounter(1);

        render.renderImage();
        render.writeToImage();
    }
}
