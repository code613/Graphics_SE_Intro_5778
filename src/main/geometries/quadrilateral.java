package main.geometries;

import main.primitives.Coordinate;
import main.primitives.Point3D;
import main.primitives.Ray;
import main.primitives.Vector;

import java.util.List;

public class quadrilateral extends Geometry implements FlatGeometry{
    //********************Fields*****************//
    private Triangle tri1;
    private Triangle tri2;

    // ***************** Constructors ********************** //

    public quadrilateral(Triangle tri1, Triangle tri2) {//constructor from triangles
        this.tri1 = tri1;
        this.tri2 = tri2;
    }
    public quadrilateral(Point3D p1, Point3D p2,Point3D p3,Point3D p4) {//the points have to be put in in order
        tri1 = new Triangle(p1,p4,p2);                                  //constructor from points
        tri2 = new Triangle(p3,p2,p4);
        //Triangle tri3 = tri1.getNormal(p1),tri4;
        //there is a bug that -0.0 is not equal to 0.0
        //what i did was by cross product in Vector i made -0.0 to 0.0
        //this seemed to help i am not sure why and really i should understand whay it is
        //giving different types of 0's if the vector should be the same....
        if(!tri1.getNormal(p1).compareTo2(tri2.getNormal(p2))){
            double z1 =  tri1.getNormal(p1).getHead().getZ().getCoordinate();
            double y1 =  tri1.getNormal(p1).getHead().getY().getCoordinate();
            double x1 =  tri1.getNormal(p1).getHead().getX().getCoordinate();
            if(z1 == -0.0){tri1.getNormal(p1).getHead().setZ(new Coordinate(0.0));}
            if(y1 == -0.0){tri1.getNormal(p1).getHead().setY(new Coordinate(0.0));}
            if(x1 == -0.0){tri1.getNormal(p1).getHead().setX(new Coordinate(0.0));}
            double z2 =  tri2.getNormal(p1).getHead().getZ().getCoordinate();
            double y2 =  tri2.getNormal(p1).getHead().getY().getCoordinate();
            double x2 =  tri2.getNormal(p1).getHead().getX().getCoordinate();
            if(z2 == -0.0){tri1.getNormal(p1).getHead().setZ(new Coordinate(0.0));}
            if(y2 == -0.0){tri1.getNormal(p1).getHead().setY(new Coordinate(0.0));}
            if(x2 == -0.0){tri1.getNormal(p1).getHead().setX(new Coordinate(0.0));}
        }
        if(tri1.getNormal(p1).compareTo2(tri2.getNormal(p2))){
            this.tri1 = tri1;
            this.tri2 = tri2;
        }
        else {

            throw new ExceptionInInitializerError("not all the points are on the same plane");
        }
    }
    // ***************** Getters/Setters ********************** //

    public Triangle getTri1() {
        return tri1;
    }

    public void setTri1(Triangle tri1) {
        this.tri1 = tri1;
    }

    public Triangle getTri2() {
        return tri2;
    }

    public void setTri2(Triangle tri2) {
        this.tri2 = tri2;
    }


    // ***************** Implementations   ******************** //

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> L1,L2,L3;
        L1 = tri1.FindIntersections(ray);
        L2 = tri1.FindIntersections(ray);
        L1.addAll(L2);
        return L1;
        /*boolean addAll = L3.addAll(L1);
        //right i have a problem combining the 2 list's i think
        //as the image just shows one triangle..

         L1;*/
    }

    @Override
    public Vector getNormal(Point3D point) {
        return tri1.getNormal(point);
    }
    // ***************** Operations ******************** //

    @Override
    public String toString() {
        return "quadrilateral{" +
                "tri1=" + tri1 +
                ", tri2=" + tri2 +
                '}';
    }
}
