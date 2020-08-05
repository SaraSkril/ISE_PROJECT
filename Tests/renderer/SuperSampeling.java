package renderer;


import elements.*;
import Geometries.*;
import Primitives.*;
import org.junit.Test;
import scene.Scene;
public class SuperSampeling {


    @Test
    public void trianglesSpherewith() {
        Scene scene = new Scene("Test scene");
        scene.set_camera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.set_distance(1000);
        scene.set_background(Color.BLACK);
        scene.set_ambientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

        scene.addGeometries( //
                new Triangle(Color.BLACK, new Material(0.3,0.3,40), //
                        new Point3D(-150, 150, 115), new Point3D(150, 150, 135), new Point3D(75, -75, 150)), //
                new Triangle(Color.BLACK, new Material(0.3, 0.3,40,0,1), //
                        new Point3D(-150, 150, 115), new Point3D(-70, -70, 140), new Point3D(75, -75, 150)), //
                new Sphere(new Color(java.awt.Color.BLUE), new Material(0.5, 0.5, 30,0,1), // )
                        30, new Point3D(0,40,115)),
                // new Sphere(new Color(java.awt.Color.GREEN), new Material(0.4, 0.3, 100, 0.3, 0), // )
                // 	9, new Point3D(0, -10, 0)),
                // new Sphere(new Color(java.awt.Color.GREEN), new Material(0.5,0.5,100), // )
                //			 	7, new Point3D(0, -30, 0)),
                new Sphere(new Color(java.awt.Color.CYAN), new Material(0.5, 0.5, 30,0.6,0), // )
                        20, new Point3D(50, 0, 100))
                ,new Sphere(new Color(java.awt.Color.RED), new Material(0.5, 0.5, 30,1,0), // )
                        18, new Point3D(-50,0,100)));
        //scene.addLights(new SpotLight(new Color(400,400,400), new Point3D(0, 500, -500), new Vector(-1, 1, 2), 1,
        //		0.0004, 0.0000006));

        //  scene.addLights(new PointLight(new Color(500, 250, 250),
        //        new Point3D(0, -40,130),
        //      1, 0.0008, 0.0008));
        scene.addLights(new SpotLight(new Color(200, 200,200),
                new Point3D(80,-30,0), new Vector(0, 0, 1), 1, 4E-5, 2E-7));

        // scene.addLights(new SpotLight(new Color(100, 100, 100),
        //		new Point3D(-80, -30,-600), new Vector(0, 0, 1), 1, 4E-5, 2E-7));
        ImageWriter imageWriter = new ImageWriter("with", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene).setOn_OFF(true);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void trianglesSpherewithChangeinAngle() {
        Scene scene = new Scene("Test scene");
        scene.set_camera(new Camera(new Point3D(0, 30, -800), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.set_distance(1000);
        scene.set_background(Color.BLACK);
        scene.set_ambientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

        scene.addGeometries( //
                new Triangle(Color.BLACK, new Material(0.3,0.3,40), //
                        new Point3D(-150, 150, 115), new Point3D(150, 150, 135), new Point3D(75, -75, 150)), //
                new Triangle(Color.BLACK, new Material(0.3, 0.3,40,0,1), //
                        new Point3D(-150, 150, 115), new Point3D(-70, -70, 140), new Point3D(75, -75, 150)), //
                new Sphere(new Color(java.awt.Color.BLUE), new Material(0.5, 0.5, 30,0,1), // )
                        30, new Point3D(0,40,115)),
                // new Sphere(new Color(java.awt.Color.GREEN), new Material(0.4, 0.3, 100, 0.3, 0), // )
                // 	9, new Point3D(0, -10, 0)),
                // new Sphere(new Color(java.awt.Color.GREEN), new Material(0.5,0.5,100), // )
                //			 	7, new Point3D(0, -30, 0)),
                new Sphere(new Color(java.awt.Color.CYAN), new Material(0.5, 0.5, 30,0.6,0), // )
                        20, new Point3D(50, 0, 100))
                ,new Sphere(new Color(java.awt.Color.RED), new Material(0.5, 0.5, 30,1,0), // )
                        18, new Point3D(-50,0,100)));
        //scene.addLights(new SpotLight(new Color(400,400,400), new Point3D(0, 500, -500), new Vector(-1, 1, 2), 1,
        //		0.0004, 0.0000006));

        //  scene.addLights(new PointLight(new Color(500, 250, 250),
        //        new Point3D(0, -40,130),
        //      1, 0.0008, 0.0008));
        scene.addLights(new SpotLight(new Color(200, 200,200),
                new Point3D(80,-30,0), new Vector(0, 0, 1), 1, 4E-5, 2E-7));

        // scene.addLights(new SpotLight(new Color(100, 100, 100),
        //		new Point3D(-80, -30,-600), new Vector(0, 0, 1), 1, 4E-5, 2E-7));
        ImageWriter imageWriter = new ImageWriter("withDiffAngle", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene).setOn_OFF(true);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void trianglesSpherewithout() {
        Scene scene = new Scene("Test scene");
        scene.set_camera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.set_distance(1000);
        scene.set_background(Color.BLACK);
        scene.set_ambientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

        scene.addGeometries( //
                new Triangle(Color.BLACK, new Material(0.3,0.3,40), //
                        new Point3D(-150, 150, 115), new Point3D(150, 150, 135), new Point3D(75, -75, 150)), //
                new Triangle(Color.BLACK, new Material(0.3, 0.3,40,0,1), //
                        new Point3D(-150, 150, 115), new Point3D(-70, -70, 140), new Point3D(75, -75, 150)), //
                new Sphere(new Color(java.awt.Color.BLUE), new Material(0.5, 0.5, 30,0,1), // )
                        30, new Point3D(0,40,115)),
                // new Sphere(new Color(java.awt.Color.GREEN), new Material(0.4, 0.3, 100, 0.3, 0), // )
                // 	9, new Point3D(0, -10, 0)),
                // new Sphere(new Color(java.awt.Color.GREEN), new Material(0.5,0.5,100), // )
                //			 	7, new Point3D(0, -30, 0)),
                new Sphere(new Color(java.awt.Color.CYAN), new Material(0.5, 0.5, 30,0.6,0), // )
                        20, new Point3D(50, 0, 100))
                ,new Sphere(new Color(java.awt.Color.RED), new Material(0.5, 0.5, 30,1,0), // )
                        18, new Point3D(-50,0,100)));
        //scene.addLights(new SpotLight(new Color(400,400,400), new Point3D(0, 500, -500), new Vector(-1, 1, 2), 1,
        //		0.0004, 0.0000006));

        //  scene.addLights(new PointLight(new Color(500, 250, 250),
        //        new Point3D(0, -40,130),
        //      1, 0.0008, 0.0008));
        scene.addLights(new SpotLight(new Color(200, 200,200),
                new Point3D(80,-30,0), new Vector(0, 0, 1), 1, 4E-5, 2E-7));

        // scene.addLights(new SpotLight(new Color(100, 100, 100),
        //		new Point3D(-80, -30,-600), new Vector(0, 0, 1), 1, 4E-5, 2E-7));
        ImageWriter imageWriter = new ImageWriter("without", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene).setOn_OFF(false);

        render.renderImage();
        render.writeToImage();
    }
}
