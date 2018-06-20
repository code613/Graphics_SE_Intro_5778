package testing.tests;


import main.elements.Camera;
import main.geometries.quadrilateral;
import main.geometries.quadrilateral2;
import main.primitives.*;


import java.awt.Color;


import main.elements.PointLight;
import main.elements.SpotLight;
import main.geometries.Sphere;
import main.geometries.Triangle;
import main.renderer.ImageWriter;
import main.renderer.Render;
import main.scenes.*;
import main.geometries.AshCylinderLim;
import org.junit.jupiter.api.Test;
public class quadrantTest {

    private final String IMAGES_TEST_DIR = "/src/testing/images/";


    @Test
    public void biuldTableTest(){

        Point3D p1= new Point3D(  0,  3500, -1000);
        Point3D p2= new Point3D( 0, -3500, -1000);
        Point3D p3= new Point3D(  0, -3500, -3000);
        Point3D p4 =new Point3D( 0,  3500, -3000);
        Point3D p5= new Point3D(  500,  3500, -1000);
        Point3D p6= new Point3D( 500, -3500, -1000);
        Point3D p7= new Point3D(  500, -3500, -3000);
        Point3D p8 =new Point3D( 500,  3500, -3000);

        Point3D p55= new Point3D(  -2500,  3500, -1000);
        Point3D p55right= new Point3D(  -2500,  3500, -1500);
        Point3D p55left= new Point3D(  -2500,  3000, -1000);
        Point3D p55upr= new Point3D(  500,  3500, -1500);
        Point3D p55upl= new Point3D(  500,  3000, -1000);
        //bettween p5 and p55upr and p55upl we have an unclosed triangle
        quadrilateral2 p5frontRightFacing= new quadrilateral2(p55left,p55,p5,p55upl);//this one is facing us
        quadrilateral2 p5frontRightside = new quadrilateral2(p55,p5,p55upr,p55right);
        /*quadrilateral2 p5legRight = new quadrilateral2(p55left,p55upl,p5,p55);
        quadrilateral2 p5legLeft = new quadrilateral2(p55,p5,p55upr,p55right);*/

        Point3D p66= new Point3D( -2500, -3500, -1000);
        Point3D p77= new Point3D(  -2500, 3500, -3000);
        Point3D p88 =new Point3D( -2500,  -3500, -3000);

        quadrilateral2 bottemOfTable = new quadrilateral2(p1,p2,p3,p4);
        quadrilateral2 topOfTable = new quadrilateral2(p5,p6,p7,p8);
        quadrilateral2 rightSide = new quadrilateral2(p1,p3,p7,p5);
        quadrilateral2 leftSide = new quadrilateral2(p2,p4,p8,p6);
        quadrilateral2 backSide = new quadrilateral2(p1,p2,p6,p5);
        quadrilateral2 frontSide = new quadrilateral2(p4,p3,p7,p8);

        bottemOfTable.setEmmission(new Color (50, 50, 200));
        topOfTable.setEmmission(new Color (250, 0, 0));
        backSide.setEmmission(new Color (0, 250, 0));
        rightSide.setEmmission(new Color (50, 80, 40));
        leftSide.setEmmission(new Color (50, 80, 40));
        frontSide.setEmmission(new Color (50, 80, 40));
        p5frontRightFacing.setEmmission(new Color (250, 0, 0));
        p5frontRightside.setEmmission(new Color (50, 50, 200));

        //quadrilateral2 leg1forNowsomething = new quadrilateral2(p10,p30,p20,p40);


       // AshCylinderLim(double myRadius, Point3D tp, Ray myRay, Color e, Material m)
        /*double myRadius  = 20;
        Point3D tp1,tp = p5;
        tp1 = p5;
        tp1.setX(new Coordinate(-1000));
        Ray myRay = new Ray(tp1,new Vector(1,0,0));
        Color e = Color.cyan;
        Material m = new Material(0.7,0.8,1,2,8);
        AshCylinderLim myLeg1 = new AshCylinderLim(myRadius,tp,myRay,e,m);*/


        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(bottemOfTable);
        scene.addGeometry(topOfTable);
        scene.addGeometry(rightSide);
        scene.addGeometry(leftSide);
        scene.addGeometry(backSide);
        scene.addGeometry(frontSide);

        //now to add the legs
        scene.addGeometry(p5frontRightFacing);
        scene.addGeometry(p5frontRightside);
        //scene.addGeometry(myLeg1);
        Camera c1 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));
        scene.setCamera(c1);


        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "makeATable test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

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
