
package testing.tests;
import main.geometries.Box;
import org.junit.jupiter.api.Test;
import main.elements.Camera;
import main.primitives.*;
import java.awt.Color;
import main.elements.PointLight;
import main.elements.SpotLight;
import main.renderer.ImageWriter;
import main.renderer.Render;
import main.scenes.*;
class BoxTest {
    private final String IMAGES_TEST_DIR = "/src/testing/images/";

    Point3D point1= new Point3D(  0,  3500, -1000);
    Point3D point2 =new Point3D( 0,  3500, -3000);
    Point3D point3= new Point3D(  0, -3500, -3000);
    Point3D point4= new Point3D( 0, -3500, -1000);
    Point3D point5= new Point3D(  500,  3500, -1000);
    Point3D point6 =new Point3D( 500,  3500, -3000);
    Point3D point7= new Point3D(  500, -3500, -3000);
    Point3D point8= new Point3D( 500, -3500, -1000);

    Box theBox = new Box(point1,point2,point3,point4,point5,point6,point7,point8);


    @Test
    public void buildBoxTest(){


       // newBox.setEmmission(new Color (0, 250, 0));


        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(theBox);

        //scene.addGeometry(myLeg1);
        Camera c1 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));
        scene.setCamera(c1);


        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "newBox test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    @Test
    void testGetBottomOfBox() {
        //theBox.FindIntersections()
    }

    void testSetBottomOfBox() {
    }

    void testSetTopOfBox() {
    }

    void testSetRightSide() {
    }

    void testSetLeftSide() {
    }

    void testSetBackSide() {
    }

    void testSetFrontSide() {
    }

    void testFindIntersections() {
    }

    void testGetNormal() {
    }

    void testToString() {
    }

    void testGetShininess() {
    }

    void testGetMaterial() {
    }

    void testGetEmmission() {
    }
}

}
