package main.geometries;

import main.primitives.Material;
import main.primitives.Point3D;
import main.primitives.Ray;
import main.primitives.Vector;

import java.awt.*;
import java.util.List;

public class Box extends Geometry implements FlatGeometry{

    //fields
    private quadrilateral2 bottomOfBox;
    private quadrilateral2 topOfBox;
    private quadrilateral2 rightSide;
    private quadrilateral2 leftSide;
    private quadrilateral2 backSide;
    private quadrilateral2 frontSide;

    //constructor's

    public Box(quadrilateral2 bottemOfBox, quadrilateral2 topOfBox, quadrilateral2 rightSide,
               quadrilateral2 leftSide, quadrilateral2 backSide, quadrilateral2 frontSide) {
        this.bottomOfBox = bottemOfBox;
        this.topOfBox = topOfBox;
        this.rightSide = rightSide;
        this.leftSide = leftSide;
        this.backSide = backSide;
        this.frontSide = frontSide;
    }
    //it is all according to code gray (I think) which means ony changing one variable at each move
    public Box(Point3D topLeftFar,
               Point3D topRightFar,
               Point3D topRightNear,
               Point3D topLeftNear,
               Point3D bottomLeftFar,
               Point3D bottomRightFar,
               Point3D bottomRightNear,
               Point3D bottomLeftNear ) {
        this.bottomOfBox = new quadrilateral2(bottomLeftFar,bottomRightFar,bottomRightNear,bottomLeftNear);
        this.topOfBox = new quadrilateral2(topLeftFar,topRightFar,topRightNear,topLeftNear);
        this.rightSide = new quadrilateral2(topRightFar,topRightNear,bottomRightNear,bottomRightFar);
        this.leftSide = new quadrilateral2(topLeftFar,topLeftNear,bottomLeftNear,bottomLeftFar);
        this.backSide = new quadrilateral2(topLeftFar,topRightFar,bottomRightFar,bottomLeftFar);
        this.frontSide = new quadrilateral2(topLeftNear,topRightNear,bottomRightNear,bottomLeftNear);
    }

    public Box(Box box) { //copy constructor
        this.bottomOfBox = box.bottomOfBox;
        this.topOfBox =box.topOfBox;
        this.rightSide = box.rightSide;
        this.leftSide = box.leftSide;
        this.backSide =box.backSide;
        this.frontSide =box.frontSide;
    }

    //getters/setters


    public quadrilateral2 getBottomOfBox() { return bottomOfBox; }

    public void setBottomOfBox(quadrilateral2 bottomOfBox) { this.bottomOfBox = bottomOfBox; }
    public void setTopOfBox(quadrilateral2 topOfBox) { this.topOfBox = topOfBox; }
    public void setRightSide(quadrilateral2 rightSide) { this.rightSide = rightSide; }
    public void setLeftSide(quadrilateral2 leftSide) { this.leftSide = leftSide; }
    public void setBackSide(quadrilateral2 backSide) { this.backSide = backSide; }
    public void setFrontSide(quadrilateral2 frontSide) { this.frontSide = frontSide; }
    public quadrilateral2 getTopOfBox() { return topOfBox; }
    public quadrilateral2 getRightSide() { return rightSide; }
    public quadrilateral2 getLeftSide() { return leftSide; }
    public quadrilateral2 getBackSide() { return backSide; }
    public quadrilateral2 getFrontSide() { return frontSide; }

    //implementations
    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionA = bottomOfBox.FindIntersections(ray);
        List<Point3D> intersectionB = topOfBox.FindIntersections(ray);
        List<Point3D> intersectionC = rightSide.FindIntersections(ray);
        List<Point3D> intersectionD = leftSide.FindIntersections(ray);
        List<Point3D> intersectionE = backSide.FindIntersections(ray);
        List<Point3D> intersectionF = frontSide.FindIntersections(ray);
        intersectionA.addAll(intersectionB);
        intersectionA.addAll(intersectionC);
        intersectionA.addAll(intersectionD);
        intersectionA.addAll(intersectionE);
        intersectionA.addAll(intersectionF);
        return intersectionA;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }

    @Override
    public String toString() {
        return "Box{" +
                "bottomOfBox=" + bottomOfBox +
                ", topOfBox=" + topOfBox +
                ", rightSide=" + rightSide +
                ", leftSide=" + leftSide +
                ", backSide=" + backSide +
                ", frontSide=" + frontSide +
                '}';
    }


    //i have no idea if these implementations really work BEWARE!!!
    @Override
    public double getShininess() {
        return super.getShininess();
    }

    @Override
    public Material getMaterial() {
        return super.getMaterial();
    }

    @Override
    public Color getEmmission() {
        return super.getEmmission();
    }

    @Override
    public void setShininess(double n) {
        super.setShininess(n);
    }

    @Override
    public void setMaterial(Material _material) {
        super.setMaterial(_material);
    }

    @Override
    public void setEmmission(Color emmission) {
        super.setEmmission(emmission);
    }

    @Override
    public void setKs(double ks) {
        super.setKs(ks);
    }

    @Override
    public void setKd(double kd) {
        super.setKd(kd);
    }

    @Override
    public void setKr(double Kr) {
        super.setKr(Kr);
    }

    @Override
    public void setKt(double Kt) {
        super.setKt(Kt);
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }



    /* Point3D p1= new Point3D(  0,  3500, -1000);
    Point3D p2= new Point3D( 0, -3500, -1000);
    Point3D p3= new Point3D(  0, -3500, -3000);
    Point3D p4 =new Point3D( 0,  3500, -3000);
    Point3D p5= new Point3D(  500,  3500, -1000);
    Point3D p6= new Point3D( 500, -3500, -1000);
    Point3D p7= new Point3D(  500, -3500, -3000);
    Point3D p8 =new Point3D( 500,  3500, -3000);*/


   /* quadrilateral2 bottemOfTable = new quadrilateral2(p1,p2,p3,p4);
    quadrilateral2 topOfTable = new quadrilateral2(p5,p6,p7,p8);
    quadrilateral2 rightSide = new quadrilateral2(p1,p3,p7,p5);
    quadrilateral2 leftSide = new quadrilateral2(p2,p4,p8,p6);
    quadrilateral2 backSide = new quadrilateral2(p1,p2,p6,p5);
    quadrilateral2 frontSide = new quadrilateral2(p4,p3,p7,p8);*/
}
