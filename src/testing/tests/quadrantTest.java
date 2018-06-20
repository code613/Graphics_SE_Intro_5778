package testing.tests;


import main.geometries.quadrilateral;
import main.geometries.quadrilateral2;
import main.primitives.Material;
import main.primitives.Ray;


import java.awt.Color;


import main.elements.PointLight;
import main.elements.SpotLight;
import main.geometries.Sphere;
import main.geometries.Triangle;
import main.primitives.Point3D;
import main.primitives.Vector;
import main.renderer.ImageWriter;
import main.renderer.Render;
import main.scenes.*;
import org.junit.jupiter.api.Test;
public class quadrantTest {

    private final String IMAGES_TEST_DIR = "/src/testing/images/";



    @Test
    public void squaresRealTest(){
        Point3D p10= new Point3D(  3500,  3500, -2000);
        Point3D p20= new Point3D( -3500, -3500, -1000);
        Point3D p30= new Point3D(  3500, -3500, -2000);
        Point3D p40 =new Point3D( -3500,  3500, -1000);
        quadrilateral2 square = new quadrilateral2(p10,p30,p20,p40);


        Point3D p11= new Point3D(  350,  350, -1000);
        Point3D p21= new Point3D( -350, -350, 0);
        Point3D p31= new Point3D(  350, -350, -1000);
        Point3D p41 =new Point3D( -350,  350, 0);
        quadrilateral2 square2 = new quadrilateral2(p11,p31,p21,p41);






        square.setShininess(20);
        square.setEmmission(new Color (50, 50, 200));
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(square);
        scene.addGeometry(square2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "quadrilateral's test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }


    @Test
    public void squareTest2(){
        int z1 = -100,z2 = -100;
        Point3D p1 = new Point3D(0.0,0.0,z1);
        Point3D p2 = new Point3D(200,0,z1);
        Point3D p3 = new Point3D(200,-200,z2);
        Point3D p4 = new Point3D(0,-200,z2);
        quadrilateral square = new quadrilateral(p1,p2,p3,p4);

        Point3D p10= new Point3D(  3500,  3500, -2000);
        Point3D p20= new Point3D( -3500, -3500, -1000);
        Point3D p30= new Point3D(  3500, -3500, -2000);
        Point3D p40 =new Point3D( -3500,  3500, -1000);
        quadrilateral square2 = new quadrilateral(p10,p30,p20,p40);
        quadrilateral2 square3 = new quadrilateral2(p10,p30,p20,p40);

        square.setShininess(20);
        square.setEmmission(new Color (50, 50, 200));

        square2.setShininess(20);
        square2.setEmmission(new Color (50, 50, 200));

        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(square3);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "quadrilateral test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
    @Test
    public void squareTest(){
        int z1 = -200,z2 = -200;
        Point3D p1 = new Point3D(0.0,0.0,z1);
        Point3D p2 = new Point3D(1000,0,z1);
        Point3D p3 = new Point3D(1000,1000,z2);
        Point3D p4 = new Point3D(0,1000,z2);
        //Triangle t1,t2;
        //t1 = new Triangle(p1,p2,p3);
     quadrilateral square = new quadrilateral(p1,p2,p3,p4);
     square.setShininess(20);
     //ok have problem with this line.. great i found the problem..
    // square.setMaterial(new Material(5,5,5,5,5));//no idea what the number's meen
     square.setEmmission(new Color (50, 50, 200));

        Scene scene = new Scene();
        scene.setScreenDistance(50);


        /*Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D( 100, 100, -49));

        Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
                new Point3D(  0, -100, -49),
                new Point3D( 100,-100, -49));
        triangle2.setEmmission(new Color (50, 200, 50));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D(-100, 100, -49));
        triangle3.setEmmission(new Color (50, 50, 200));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
                new Point3D(  0,  -100, -49),
                new Point3D(-100, -100, -49));
        triangle4.setEmmission(new Color (200, 50, 50));


        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);*/
        scene.addGeometry(square);

        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "square test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }
}
