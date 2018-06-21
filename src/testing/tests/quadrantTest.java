package testing.tests;


import main.elements.Camera;
import main.geometries.quadrilateral;
import main.geometries.quadrilateral2;
import main.primitives.*;


import java.awt.Color;


import main.elements.SpotLight;
import main.renderer.ImageWriter;
import main.renderer.Render;
import main.scenes.*;
import org.junit.jupiter.api.Test;
public class quadrantTest {

    private final String IMAGES_TEST_DIR = "/src/testing/images/";

    @Test
    public void rightBackLegTest() {
        double X1Table = 500  ,X2Table = 0;
        double Y1Table = 3500 ,Y2Table = -3500;
        double Z1Table = -1000,Z2Table = -3000;
        double LegX1 = X2Table,LegX2 = -2500;//only these number's are correct
        double Y1RightLeg =  2700,Y2RightLeg =  3000;//really this is aY +c but for simple just make it Y same for all of them..
        double Y1leftLeg  = -3200,Y2leftLeg  = -2500;
        double Z1FrontLeg = -1200,Z2FrontLeg = -1300;
        double Z1BackLeg  = -3300,Z2BackLeg  = -3200;

        double X1BackRightLeg = LegX1, X2BackRightLeg = LegX2;
        double Y1BackRightLeg = Y1RightLeg,Y2BackRightLeg = Y2RightLeg;
        double Z1BackRightLeg = -3300,Z2BackRightLeg = -3200;


        //Back right Leg
        Point3D BRLtopRightNear = new Point3D(X1BackRightLeg, Y2BackRightLeg, Z2BackRightLeg);//
        Point3D BRLtopLeftNear = new Point3D(  X1BackRightLeg, Y1BackRightLeg, Z2BackRightLeg);//
        Point3D BRLtopLeftFar = new Point3D(X1BackRightLeg, Y1BackRightLeg, Z1BackRightLeg);
        Point3D BRLtopRightFar = new Point3D(  X1BackRightLeg,  Y2BackRightLeg, Z1BackRightLeg);//
        Point3D BRLbottomRightNear = new Point3D(X2BackRightLeg,  Y2BackRightLeg, Z2BackRightLeg);//
        Point3D BRLbottomLeftNear = new Point3D(X2BackRightLeg, Y1BackRightLeg, Z2BackRightLeg);//
        Point3D BRLbottomLeftFar = new Point3D(X2BackRightLeg, Y1BackRightLeg, Z1BackRightLeg);
        Point3D BRLbottomRightFar = new Point3D(X2BackRightLeg,  Y2BackRightLeg, Z1BackRightLeg);//

        quadrilateral2 BRLbottomOfBox = new quadrilateral2(BRLbottomLeftFar, BRLbottomRightFar, BRLbottomRightNear, BRLbottomLeftNear);
        quadrilateral2 BRLtopOfBox = new quadrilateral2(BRLtopLeftFar, BRLtopRightFar, BRLtopRightNear, BRLtopLeftNear);
        quadrilateral2 BRLrightSide = new quadrilateral2(BRLtopRightFar, BRLtopRightNear, BRLbottomRightNear, BRLbottomRightFar);
        quadrilateral2 BRLleftSide = new quadrilateral2(BRLtopLeftFar, BRLtopLeftNear, BRLbottomLeftNear, BRLbottomLeftFar);
        quadrilateral2 BRLbackSide = new quadrilateral2(BRLtopLeftFar, BRLtopRightFar, BRLbottomRightFar, BRLbottomLeftFar);
        quadrilateral2 BRLfrontSide = new quadrilateral2(BRLtopLeftNear, BRLtopRightNear, BRLbottomRightNear, BRLbottomLeftNear);

        Color BRLColor = new Color (186, 185, 124);

        //Back right Leg
        BRLbottomOfBox.setEmmission(BRLColor );
        BRLtopOfBox.setEmmission(BRLColor);
        BRLrightSide.setEmmission(BRLColor);
        BRLleftSide.setEmmission(BRLColor);
        BRLbackSide.setEmmission(BRLColor);
        BRLfrontSide.setEmmission(BRLColor);

        Scene scene = new Scene();
        scene.setScreenDistance(50);

        //Back right Leg
        scene.addGeometry(BRLbottomOfBox);
        scene.addGeometry(BRLtopOfBox);
        scene.addGeometry(BRLrightSide);
        scene.addGeometry(BRLleftSide);
        scene.addGeometry(BRLbackSide);
        scene.addGeometry(BRLfrontSide);

        Camera c1 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));
        scene.setCamera(c1);

        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "BackRightLeg test" , 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();


}
    @Test
    public void FinalbiuldTableTest() {

        // ***************** values ********************** //
        double X1Table = 500  ,X2Table = 0;
        double Y1Table = 3500 ,Y2Table = -3500;
        double Z1Table = -1000,Z2Table = -3000;

        //THESE ARE THE CRITICAL NUMBERS....BEWARE....
        double LegX1 = X2Table,LegX2 = -2500;//only these number's are correct
        double Y1RightLeg =  2700,Y2RightLeg =  3000;//really this is aY +c but for simple just make it Y same for all of them..
        double Y1leftLeg  = -3200,Y2leftLeg  = -2500;
        double Z1FrontLeg = -1200,Z2FrontLeg = -1300;
        double Z1BackLeg  = -2800,Z2BackLeg  = -2700;
        //ok now legs
        //FrontRightLeg
        double X1FrontRightLeg = LegX1      ,X2FrontRightLeg = LegX2;
        double Y1FrontRightLeg = Y1RightLeg ,Y2FrontRightLeg =  Y2RightLeg;
        double Z1FrontRightLeg = Z1FrontLeg ,Z2FrontRightLeg = Z2FrontLeg;

        //leftNearLeg
        double leftNearLegX1 = LegX1,     leftNearLegX2 = LegX2;//leftNearLegX1 - 2500;
        double leftNearLegY1 = Y1leftLeg, leftNearLegY2 = Y2leftLeg;//leftNearLegY1 + 500;
        double leftNearLegZ1 = Z1FrontLeg,leftNearLegZ2 = Z2FrontLeg;// leftNearLegZ1 - 50;
        //leftFarLeg
        double leftFarLegX1 = LegX1       ,leftFarLegX2 = LegX2;
        double leftFarLegY1 = Y1leftLeg   ,leftFarLegY2 = Y2leftLeg;
        double leftFarLegZ1 = Z1BackLeg   ,leftFarLegZ2 = Z2BackLeg;

        //BackRightLeg  um these numbers arn't right.......
        double X1BackRightLeg = LegX1,     X2BackRightLeg = LegX2;
        double Y1BackRightLeg = Y1RightLeg,Y2BackRightLeg = Y2RightLeg;
        double Z1BackRightLeg = Z1BackLeg, Z2BackRightLeg = Z2BackLeg;

        //Flore
        double FloreBottom =  LegX2-5;//so that the legs are on the flore nooo it is floor!!!  ok refacter later....
        double FloreY1 = -10000,FloreY2 =  10000;
        double FloreZ1 =  10000,FloreZ2 = -10000;

        // ***************** Point3D ********************** //
        //table
        Point3D topRightNear = new Point3D(X1Table, Y1Table, Z1Table);
        Point3D topLeftNear = new Point3D(X1Table, Y2Table, Z1Table);
        Point3D topLeftFar = new Point3D(X1Table, Y2Table, Z2Table);
        Point3D topRightFar = new Point3D(X1Table, Y1Table, Z2Table);
        Point3D bottomRightNear = new Point3D(X2Table, Y1Table, Z1Table);
        Point3D bottomLeftNear = new Point3D(X2Table, Y2Table, Z1Table);
        Point3D bottomLeftFar = new Point3D(X2Table, Y2Table, Z2Table);
        Point3D bottomRightFar = new Point3D(X2Table, Y1Table, Z2Table);

        //ok now legs
        //FrontRightLeg
        Point3D FRLtopRightNear = new Point3D(X1FrontRightLeg, Y2FrontRightLeg, Z2FrontRightLeg);//
        Point3D FRLtopLeftNear = new Point3D(  X1FrontRightLeg, Y1FrontRightLeg, Z2FrontRightLeg);//
        Point3D FRLtopLeftFar = new Point3D(X1FrontRightLeg, Y1FrontRightLeg, Z1FrontRightLeg);
        Point3D FRLtopRightFar = new Point3D(  X1FrontRightLeg,  Y2FrontRightLeg, Z1FrontRightLeg);//
        Point3D FRLbottomRightNear = new Point3D(X2FrontRightLeg,  Y2FrontRightLeg, Z2FrontRightLeg);//
        Point3D FRLbottomLeftNear = new Point3D(X2FrontRightLeg, Y1FrontRightLeg, Z2FrontRightLeg);//
        Point3D FRLbottomLeftFar = new Point3D(X2FrontRightLeg, Y1FrontRightLeg, Z1FrontRightLeg);
        Point3D FRLbottomRightFar = new Point3D(X2FrontRightLeg,  Y2FrontRightLeg, Z1FrontRightLeg);//

        //LeftNearLeg or Front Left Leg
        Point3D FLLtopRightNear = new Point3D(leftNearLegX1, leftNearLegY2, leftNearLegZ2);//
        Point3D FLLtopLeftNear = new Point3D(  leftNearLegX1,  leftNearLegY1, leftNearLegZ2);//
        Point3D FLLtopLeftFar = new Point3D(leftNearLegX1, leftNearLegY1, leftNearLegZ1);
        Point3D FLLtopRightFar = new Point3D(  leftNearLegX1,  leftNearLegY2, leftNearLegZ1);//
        Point3D FLLbottomRightNear = new Point3D(leftNearLegX2,  leftNearLegY2, leftNearLegZ2);//
        Point3D FLLbottomLeftNear = new Point3D(  leftNearLegX2,  leftNearLegY1, leftNearLegZ2);//
        Point3D FLLbottomLeftFar = new Point3D(leftNearLegX2, leftNearLegY1, leftNearLegZ1);
        Point3D FLLbottomRightFar = new Point3D(  leftNearLegX2,  leftNearLegY2, leftNearLegZ1);//

        //leftFarLeg  or Back Left Leg
        Point3D BLLtopRightNear = new Point3D(leftFarLegX1, leftFarLegY2, leftFarLegZ2);//
        Point3D BLLtopLeftNear = new Point3D(  leftFarLegX1,  leftFarLegY1, leftFarLegZ2);//
        Point3D BLLtopLeftFar = new Point3D(leftFarLegX1, leftFarLegY1, leftFarLegZ1);
        Point3D BLLtopRightFar = new Point3D(  leftFarLegX1,  leftFarLegY2, leftFarLegZ1);//
        Point3D BLLbottomRightNear = new Point3D(leftFarLegX2,  leftFarLegY2, leftFarLegZ2);//
        Point3D BLLbottomLeftNear = new Point3D(  leftFarLegX2,  leftFarLegY1, leftFarLegZ2);//
        Point3D BLLbottomLeftFar = new Point3D(leftFarLegX2, leftFarLegY1, leftFarLegZ1);
        Point3D BLLbottomRightFar = new Point3D(  leftFarLegX2,  leftFarLegY2, leftFarLegZ1);//

        //Back right Leg
        Point3D BRLtopRightNear = new Point3D(X1BackRightLeg, Y2BackRightLeg, Z2BackRightLeg);//
        Point3D BRLtopLeftNear = new Point3D(  X1BackRightLeg, Y1BackRightLeg, Z2BackRightLeg);//
        Point3D BRLtopLeftFar = new Point3D(X1BackRightLeg, Y1BackRightLeg, Z1BackRightLeg);
        Point3D BRLtopRightFar = new Point3D(  X1BackRightLeg,  Y2BackRightLeg, Z1BackRightLeg);//
        Point3D BRLbottomRightNear = new Point3D(X2BackRightLeg,  Y2BackRightLeg, Z2BackRightLeg);//
        Point3D BRLbottomLeftNear = new Point3D(X2BackRightLeg, Y1BackRightLeg, Z2BackRightLeg);//
        Point3D BRLbottomLeftFar = new Point3D(X2BackRightLeg, Y1BackRightLeg, Z1BackRightLeg);
        Point3D BRLbottomRightFar = new Point3D(X2BackRightLeg,  Y2BackRightLeg, Z1BackRightLeg);//

        // ***************** quadrilateral's ********************** //
        //table
        quadrilateral2 bottomOfBox = new quadrilateral2(bottomLeftFar, bottomRightFar, bottomRightNear, bottomLeftNear);
        quadrilateral2 topOfBox = new quadrilateral2(topLeftFar, topRightFar, topRightNear, topLeftNear);
        quadrilateral2 rightSide = new quadrilateral2(topRightFar, topRightNear, bottomRightNear, bottomRightFar);
        quadrilateral2 leftSide = new quadrilateral2(topLeftFar, topLeftNear, bottomLeftNear, bottomLeftFar);
        quadrilateral2 backSide = new quadrilateral2(topLeftFar, topRightFar, bottomRightFar, bottomLeftFar);
        quadrilateral2 frontSide = new quadrilateral2(topLeftNear, topRightNear, bottomRightNear, bottomLeftNear);

        //and now legs
        //FrontRightLeg
        quadrilateral2 FRLbottomOfBox = new quadrilateral2(FRLbottomLeftFar, FRLbottomRightFar, FRLbottomRightNear, FRLbottomLeftNear);
        quadrilateral2 FRLtopOfBox = new quadrilateral2(FRLtopLeftFar, FRLtopRightFar, FRLtopRightNear, FRLtopLeftNear);
        quadrilateral2 FRLrightSide = new quadrilateral2(FRLtopRightFar, FRLtopRightNear, FRLbottomRightNear, FRLbottomRightFar);
        quadrilateral2 FRLleftSide = new quadrilateral2(FRLtopLeftFar, FRLtopLeftNear, FRLbottomLeftNear, FRLbottomLeftFar);
        quadrilateral2 FRLbackSide = new quadrilateral2(FRLtopLeftFar, FRLtopRightFar, FRLbottomRightFar, FRLbottomLeftFar);
        quadrilateral2 FRLfrontSide = new quadrilateral2(FRLtopLeftNear, FRLtopRightNear, FRLbottomRightNear, FRLbottomLeftNear);

        //LeftNearLeg or Front Left Leg
        quadrilateral2 FLLbottomOfBox = new quadrilateral2(FLLbottomLeftFar, FLLbottomRightFar, FLLbottomRightNear, FLLbottomLeftNear);
        quadrilateral2 FLLtopOfBox = new quadrilateral2(FLLtopLeftFar, FLLtopRightFar, FLLtopRightNear, FLLtopLeftNear);
        quadrilateral2 FLLrightSide = new quadrilateral2(FLLtopRightFar, FLLtopRightNear, FLLbottomRightNear, FLLbottomRightFar);
        quadrilateral2 FLLleftSide = new quadrilateral2(FLLtopLeftFar, FLLtopLeftNear, FLLbottomLeftNear, FLLbottomLeftFar);
        quadrilateral2 FLLbackSide = new quadrilateral2(FLLtopLeftFar, FLLtopRightFar, FLLbottomRightFar, FLLbottomLeftFar);
        quadrilateral2 FLLfrontSide = new quadrilateral2(FLLtopLeftNear, FLLtopRightNear, FLLbottomRightNear, FLLbottomLeftNear);
        //leftFarLeg  or Back Left Leg
        quadrilateral2 BLLbottomOfBox = new quadrilateral2(BLLbottomLeftFar, BLLbottomRightFar, BLLbottomRightNear, BLLbottomLeftNear);
        quadrilateral2 BLLtopOfBox = new quadrilateral2(BLLtopLeftFar, BLLtopRightFar, BLLtopRightNear, BLLtopLeftNear);
        quadrilateral2 BLLrightSide = new quadrilateral2(BLLtopRightFar, BLLtopRightNear, BLLbottomRightNear, BLLbottomRightFar);
        quadrilateral2 BLLleftSide = new quadrilateral2(BLLtopLeftFar, BLLtopLeftNear, BLLbottomLeftNear, BLLbottomLeftFar);
        quadrilateral2 BLLbackSide = new quadrilateral2(BLLtopLeftFar, BLLtopRightFar, BLLbottomRightFar, BLLbottomLeftFar);
        quadrilateral2 BLLfrontSide = new quadrilateral2(BLLtopLeftNear, BLLtopRightNear, BLLbottomRightNear, BLLbottomLeftNear);
        //Back right Leg BRL
        quadrilateral2 BRLbottomOfBox = new quadrilateral2(BRLbottomLeftFar, BRLbottomRightFar, BRLbottomRightNear, BRLbottomLeftNear);
        quadrilateral2 BRLtopOfBox = new quadrilateral2(BRLtopLeftFar, BRLtopRightFar, BRLtopRightNear, BRLtopLeftNear);
        quadrilateral2 BRLrightSide = new quadrilateral2(BRLtopRightFar, BRLtopRightNear, BRLbottomRightNear, BRLbottomRightFar);
        quadrilateral2 BRLleftSide = new quadrilateral2(BRLtopLeftFar, BRLtopLeftNear, BRLbottomLeftNear, BRLbottomLeftFar);
        quadrilateral2 BRLbackSide = new quadrilateral2(BRLtopLeftFar, BRLtopRightFar, BRLbottomRightFar, BRLbottomLeftFar);
        quadrilateral2 BRLfrontSide = new quadrilateral2(BRLtopLeftNear, BRLtopRightNear, BRLbottomRightNear, BRLbottomLeftNear);


        // ***************** Color's ********************** //
        Color TableColor = new Color (186, 163, 138);
        Color TablesideColor = new Color (186, 129, 41);
        Color GrandColer =  new Color (171, 186, 54);
        Color FRLColor = GrandColer;
        Color FLLColor = GrandColer;
        Color BLLColor = GrandColer;
        Color BRLColor = GrandColer;
       /* Color FRLColor = new Color (171, 186, 54);
        Color FLLColor = new Color (0, 0, 250);
        Color BLLColor = new Color (250, 0, 0);
        Color BRLColor = new Color (186, 185, 124);*/
        Color FloreColor = new Color (170, 242, 243);
       /* Color TableColor = new Color (186, 185, 124);
        Color FRLColor = new Color (186, 185, 124);
        Color FLLColor = new Color (186, 185, 124);
        Color BLLColor = new Color (186, 185, 124);
        Color BRLColor = new Color (186, 185, 124);*/

        //table
        bottomOfBox.setEmmission(TableColor );
        topOfBox.setEmmission(TableColor);
        rightSide.setEmmission(TablesideColor);
        leftSide.setEmmission(TablesideColor);
        backSide.setEmmission(TablesideColor);
        frontSide.setEmmission(TablesideColor);

        //topOfBox.setShininess(20);
        //and now legs
        //FrontRightLeg
        FRLbottomOfBox.setEmmission(FRLColor );
        FRLtopOfBox.setEmmission(FRLColor);
        FRLrightSide.setEmmission(FRLColor);
        FRLleftSide.setEmmission(FRLColor);
        FRLbackSide.setEmmission(FRLColor);
        FRLfrontSide.setEmmission(FRLColor);

        //LeftNearLeg or Front Left Leg
        FLLbottomOfBox.setEmmission(FLLColor );
        FLLtopOfBox.setEmmission(FLLColor);
        FLLrightSide.setEmmission(FLLColor);
        FLLleftSide.setEmmission(FLLColor);
        FLLbackSide.setEmmission(FLLColor);
        FLLfrontSide.setEmmission(FLLColor);

        //leftFarLeg  or Back Left Leg
        BLLbottomOfBox.setEmmission(BLLColor );
        BLLtopOfBox.setEmmission(BLLColor);
        BLLrightSide.setEmmission(BLLColor);
        BLLleftSide.setEmmission(BLLColor);
        BLLbackSide.setEmmission(BLLColor);
        BLLfrontSide.setEmmission(BLLColor);

        //Back right Leg
        BRLbottomOfBox.setEmmission(BRLColor );
        BRLtopOfBox.setEmmission(BRLColor);
        BRLrightSide.setEmmission(BRLColor);
        BRLleftSide.setEmmission(BRLColor);
        BRLbackSide.setEmmission(BRLColor);
        BRLfrontSide.setEmmission(BRLColor);

        // ***************** Scene ********************** //

        Scene scene = new Scene();
        scene.setScreenDistance(50);

        //table
        scene.addGeometry(bottomOfBox);
        scene.addGeometry(topOfBox);
        scene.addGeometry(rightSide);
        scene.addGeometry(leftSide);
        scene.addGeometry(backSide);
        scene.addGeometry(frontSide);

        //and now legs
        //FrontRightLeg
        scene.addGeometry(FRLbottomOfBox);
        scene.addGeometry(FRLtopOfBox);
        scene.addGeometry(FRLrightSide);
        scene.addGeometry(FRLleftSide);
        scene.addGeometry(FRLbackSide);
        scene.addGeometry(FRLfrontSide);
        //LeftNearLeg or Front Left Leg
        scene.addGeometry(FLLbottomOfBox);
        scene.addGeometry(FLLtopOfBox);
        scene.addGeometry(FLLrightSide);
        scene.addGeometry(FLLleftSide);
        scene.addGeometry(FLLbackSide);
        scene.addGeometry(FLLfrontSide);
        //leftFarLeg  or Back Left Leg
        scene.addGeometry(BLLbottomOfBox);
        scene.addGeometry(BLLtopOfBox);
        scene.addGeometry(BLLrightSide);
        scene.addGeometry(BLLleftSide);
        scene.addGeometry(BLLbackSide);
        scene.addGeometry(BLLfrontSide);
        //Back right Leg
        scene.addGeometry(BRLbottomOfBox);
        scene.addGeometry(BRLtopOfBox);
        scene.addGeometry(BRLrightSide);
        scene.addGeometry(BRLleftSide);
        scene.addGeometry(BRLbackSide);
        scene.addGeometry(BRLfrontSide);

        // ***************** Camera ********************** //

        //It was from the right sight
        Camera cRight = new Camera(new Point3D(2000,4000,-1500), new Vector(1,0,0),
                new Vector(0,-1,0));
        //and now from the left sight
        Camera cLeft = new Camera(new Point3D(2000,-4000,-1500), new Vector(1,0,0),
                new Vector(0,1,0));
        //Now you will see it from the back
        Camera cBack = new Camera(new Point3D(2000,-0,-4500), new Vector(1,0,0),
                new Vector(0,0,1));
        //Now from far right coner
        Camera cfarRightConer = new Camera(new Point3D(2000,4500,-4500), new Vector(1,0,0),
                new Vector(0,-1,1));
        //ftom the far left coner
        Camera cFarLeftCorner = new Camera(new Point3D(2000,-4500,-4500), new Vector(1,0,0),
                new Vector(0,1,1));
        //from the near right coner
        Camera cNearRightCorner = new Camera(new Point3D(2000,4500,500), new Vector(1,0,0),
                new Vector(0,-1,-1));
        //from the left near coner
        Camera cNearLeftCorner = new Camera(new Point3D(2000,-4500,500), new Vector(1,0,0),
                new Vector(0,1,-1));

        Camera c1 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));
        scene.setCamera(cBack);
        String camaraName = "cBack";
        Camera c2 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));

        // ***************** Light ********************** //

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(2000, -200, 1150),
                new Vector(-2, 2, -3), 0.1, 0.00001, 0.000005));

        scene.addLight(new SpotLight(new Color(100, 255, 100), new Point3D(4200, 1000, 150),
                new Vector(-2, -2, -3), 0.1, 0.00001, 0.000005));

        scene.addLight(new SpotLight(new Color(100, 100, 255), new Point3D(1200, -200, -4000),
                new Vector(-2, 2, 3), 0, 0.00001, 0.000005));

        // ***************** Flore ********************** //
        Point3D bottomRightNearFloreConer = new Point3D(FloreBottom,  FloreY2, FloreZ2);//
        Point3D bottomLeftNearFloreConer = new Point3D(  FloreBottom,  FloreY1, FloreZ2);//
        Point3D bottomLeftFarFloreConer = new Point3D(FloreBottom, FloreY1, FloreZ1);
        Point3D bottomRightFarFloreConer = new Point3D(  FloreBottom,  FloreY2, FloreZ1);//
        quadrilateral2 flore = new quadrilateral2(bottomLeftFarFloreConer, bottomRightFarFloreConer, bottomRightNearFloreConer, bottomLeftNearFloreConer);
        flore.setEmmission(FloreColor);
        scene.addGeometry(flore);


        // ***************** ImageWriter and Render********************** //

        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "BenAndEmanualTable test"+camaraName , 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
        //table
        //and now legs
        //FrontRightLeg
        //LeftNearLeg or Front Left Leg
        //leftFarLeg  or Back Left Leg
        //Back right Leg
    }

    @Test
    public void rightLegTest() {
        //in Z 200 and in Y 500
     /*    double x1 = 0,x2 = x1 - 2500;
        double y1 = -3000,y2 = y1 + 500;
        double z1 = -1200,z2 = z1 - 50;
       double X1BackRightLeg = 0, X2FrontRightLeg = -2500;
        double Y1FrontRightLeg = 2700,Y2FrontRightLeg = 3000;
        double Z1FrontRightLeg = -1200,Z2FrontRightLeg = -1300;*/

        double X1BackRightLeg = 0, X2BackRightLeg = -2500;
        double Y1BackRightLeg = 2700,Y2BackRightLeg = 3000;
        double Z1BackRightLeg = -1200,Z2BackRightLeg = -1300;
        Point3D BRLtopRightNear = new Point3D(X1BackRightLeg, Y2BackRightLeg, Z2BackRightLeg);//
        Point3D BRLtopLeftNear = new Point3D(  X1BackRightLeg, Y1BackRightLeg, Z2BackRightLeg);//
        Point3D BRLtopLeftFar = new Point3D(X1BackRightLeg, Y1BackRightLeg, Z1BackRightLeg);
        Point3D BRLtopRightFar = new Point3D(  X1BackRightLeg,  Y2BackRightLeg, Z1BackRightLeg);//
        Point3D BRLbottomRightNear = new Point3D(X2BackRightLeg,  Y2BackRightLeg, Z2BackRightLeg);//
        Point3D BRLbottomLeftNear = new Point3D(X2BackRightLeg, Y1BackRightLeg, Z2BackRightLeg);//
        Point3D BRLbottomLeftFar = new Point3D(X2BackRightLeg, Y1BackRightLeg, Z1BackRightLeg);
        Point3D BRLbottomRightFar = new Point3D(X2BackRightLeg,  Y2BackRightLeg, Z1BackRightLeg);//


        quadrilateral2 bottomOfBox = new quadrilateral2(BRLbottomLeftFar, BRLbottomRightFar, BRLbottomRightNear, BRLbottomLeftNear);
        quadrilateral2 topOfBox = new quadrilateral2(BRLtopLeftFar, BRLtopRightFar, BRLtopRightNear, BRLtopLeftNear);
        quadrilateral2 rightSide = new quadrilateral2(BRLtopRightFar, BRLtopRightNear, BRLbottomRightNear, BRLbottomRightFar);
        quadrilateral2 leftSide = new quadrilateral2(BRLtopLeftFar, BRLtopLeftNear, BRLbottomLeftNear, BRLbottomLeftFar);
        quadrilateral2 backSide = new quadrilateral2(BRLtopLeftFar, BRLtopRightFar, BRLbottomRightFar, BRLbottomLeftFar);
        quadrilateral2 frontSide = new quadrilateral2(BRLtopLeftNear, BRLtopRightNear, BRLbottomRightNear, BRLbottomLeftNear);

        Color myColor = new Color (186, 185, 124);
        bottomOfBox.setEmmission(myColor );
        topOfBox.setEmmission(myColor);
        rightSide.setEmmission(myColor);
        leftSide.setEmmission(myColor);
        backSide.setEmmission(myColor);
        frontSide.setEmmission(myColor);

        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(bottomOfBox);
        scene.addGeometry(topOfBox);
        scene.addGeometry(rightSide);
        scene.addGeometry(leftSide);
        scene.addGeometry(backSide);
        scene.addGeometry(frontSide);

        Camera c1 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));
        scene.setCamera(c1);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "makerightLegTable test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void LeftFarLeg(){
        double leftFarLegX1 = 0,leftFarLegX2 = leftFarLegX1 - 2500;
        double leftFarLegY1 = -3000 +200,leftFarLegY2 = leftFarLegY1 + 500 +200;
        double leftFarLegZ1 = -3500 +50 +200,leftFarLegZ2 = leftFarLegZ1 - 50 +200;

        Point3D topRightNear = new Point3D(leftFarLegX1, leftFarLegY2, leftFarLegZ2);//
        Point3D topLeftNear = new Point3D(  leftFarLegX1,  leftFarLegY1, leftFarLegZ2);//
        Point3D topLeftFar = new Point3D(leftFarLegX1, leftFarLegY1, leftFarLegZ1);
        Point3D topRightFar = new Point3D(  leftFarLegX1,  leftFarLegY2, leftFarLegZ1);//
        Point3D bottomRightNear = new Point3D(leftFarLegX2,  leftFarLegY2, leftFarLegZ2);//
        Point3D bottomLeftNear = new Point3D(  leftFarLegX2,  leftFarLegY1, leftFarLegZ2);//
        Point3D bottomLeftFar = new Point3D(leftFarLegX2, leftFarLegY1, leftFarLegZ1);
        Point3D bottomRightFar = new Point3D(  leftFarLegX2,  leftFarLegY2, leftFarLegZ1);//

        quadrilateral2 bottomOfBox = new quadrilateral2(bottomLeftFar, bottomRightFar, bottomRightNear, bottomLeftNear);
        quadrilateral2 topOfBox = new quadrilateral2(topLeftFar, topRightFar, topRightNear, topLeftNear);
        quadrilateral2 rightSide = new quadrilateral2(topRightFar, topRightNear, bottomRightNear, bottomRightFar);
        quadrilateral2 leftSide = new quadrilateral2(topLeftFar, topLeftNear, bottomLeftNear, bottomLeftFar);
        quadrilateral2 backSide = new quadrilateral2(topLeftFar, topRightFar, bottomRightFar, bottomLeftFar);
        quadrilateral2 frontSide = new quadrilateral2(topLeftNear, topRightNear, bottomRightNear, bottomLeftNear);

        Color myColor = new Color (186, 185, 124);
        bottomOfBox.setEmmission(myColor );
        topOfBox.setEmmission(myColor);
        rightSide.setEmmission(myColor);
        leftSide.setEmmission(myColor);
        backSide.setEmmission(myColor);
        frontSide.setEmmission(myColor);


        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(bottomOfBox);
        scene.addGeometry(topOfBox);
        scene.addGeometry(rightSide);
        scene.addGeometry(leftSide);
        scene.addGeometry(backSide);
        scene.addGeometry(frontSide);

        Camera c1 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));
        scene.setCamera(c1);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "LeftnFarTableLeg test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void LeftNearLeg(){
        double leftNearLegX1 = 0,leftNearLegX2 = leftNearLegX1 - 2500;
        double leftNearLegY1 = -2800,leftNearLegY2 = leftNearLegY1 + 500;
        double leftNearLegZ1 = -1200,leftNearLegZ2 = leftNearLegZ1 - 50;

        Point3D topRightNear = new Point3D(leftNearLegX1, leftNearLegY2, leftNearLegZ2);//
        Point3D topLeftNear = new Point3D(  leftNearLegX1,  leftNearLegY1, leftNearLegZ2);//
        Point3D topLeftFar = new Point3D(leftNearLegX1, leftNearLegY1, leftNearLegZ1);
        Point3D topRightFar = new Point3D(  leftNearLegX1,  leftNearLegY2, leftNearLegZ1);//
        Point3D bottomRightNear = new Point3D(leftNearLegX2,  leftNearLegY2, leftNearLegZ2);//
        Point3D bottomLeftNear = new Point3D(  leftNearLegX2,  leftNearLegY1, leftNearLegZ2);//
        Point3D bottomLeftFar = new Point3D(leftNearLegX2, leftNearLegY1, leftNearLegZ1);
        Point3D bottomRightFar = new Point3D(  leftNearLegX2,  leftNearLegY2, leftNearLegZ1);//

        quadrilateral2 bottomOfBox = new quadrilateral2(bottomLeftFar, bottomRightFar, bottomRightNear, bottomLeftNear);
        quadrilateral2 topOfBox = new quadrilateral2(topLeftFar, topRightFar, topRightNear, topLeftNear);
        quadrilateral2 rightSide = new quadrilateral2(topRightFar, topRightNear, bottomRightNear, bottomRightFar);
        quadrilateral2 leftSide = new quadrilateral2(topLeftFar, topLeftNear, bottomLeftNear, bottomLeftFar);
        quadrilateral2 backSide = new quadrilateral2(topLeftFar, topRightFar, bottomRightFar, bottomLeftFar);
        quadrilateral2 frontSide = new quadrilateral2(topLeftNear, topRightNear, bottomRightNear, bottomLeftNear);

        Color myColor = new Color (186, 185, 124);
        bottomOfBox.setEmmission(myColor );
        topOfBox.setEmmission(myColor);
        rightSide.setEmmission(myColor);
        leftSide.setEmmission(myColor);
        backSide.setEmmission(myColor);
        frontSide.setEmmission(myColor);


        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(bottomOfBox);
        scene.addGeometry(topOfBox);
        scene.addGeometry(rightSide);
        scene.addGeometry(leftSide);
        scene.addGeometry(backSide);
        scene.addGeometry(frontSide);

        Camera c1 = new Camera(new Point3D(2000,0,0), new Vector(1,0,0), new Vector(0,0,-1));
        scene.setCamera(c1);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "makeleftnearLegTable test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void biuldTableTest(){
/*     topRightNearp5
                topLeftNearp6
        topLeftFarp7
                topRightFarp8
        bottomRightNearp1
                bottomLeftFarp2
        bottomLeftFarp3
                bottomLeftNearp4 */
        Point3D p1= new Point3D(  0,  3500, -1000);
        Point3D p2= new Point3D( 0, -3500, -1000);
        Point3D p3= new Point3D(  0, -3500, -3000);
        Point3D p4 =new Point3D( 0,  3500, -3000);
        Point3D p5= new Point3D(  500,  3500, -1000);
        Point3D p6= new Point3D( 500, -3500, -1000);
        Point3D p7= new Point3D(  500, -3500, -3000);
        Point3D p8 =new Point3D( 500,  3500, -3000);

        Point3D p55= new Point3D(  -2500,  3500, -1100);
        Point3D p55right= new Point3D(  -2500,  3500, -1400);
        Point3D p55left= new Point3D(  -2500,  3000, -1100);
        Point3D p55upr= new Point3D(  500,  3500, -1400);
        Point3D p55upl= new Point3D(  500,  3000, -1100);
        //bettween p5 and p55upr and p55upl we have an unclosed triangle

        quadrilateral2 p5frontRightFacing= new quadrilateral2(p55left,p55,p5,p55upl);//this one is facing us
        quadrilateral2 p5frontRightside = new quadrilateral2(p55,p5,p55upr,p55right);
/*        quadrilateral2 p5legRight = new quadrilateral2(p55left,p55upl,p5,p55);
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


     //AshCylinderLim(double myRadius, Point3D tp, Ray myRay, Color e, Material m)
/*        double myRadius  = 20;
        Point3D tp1,tp = p5;
        tp1 = p5;
        tp1.setX(new Coordinate(-1000));
        Ray myRay = new Ray(tp1,new Vector(1,0,0));
        Color e = new Color (0, 250, 0);
        Material m = new Material();//0.7,0.8,1,2,8);
        AshCylinderLim myLeg1 = new AshCylinderLim(myRadius,tp,myRay,e,m);*/

//gee i hope the below works.. krosed fingers..
        rightLegTest();//let see if i can just do this then we can have each part it's own function

        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(bottemOfTable);
        scene.addGeometry(topOfTable);
        scene.addGeometry(rightSide);
        scene.addGeometry(leftSide);
        scene.addGeometry(backSide);
        scene.addGeometry(frontSide);
       // scene.addGeometry(myLeg1);

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
