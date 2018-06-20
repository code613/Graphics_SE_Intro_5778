package main.geometries;

/*import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;*/
import main.primitives.Point3D;
import main.primitives.Ray;
import main.primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class quadrilateral2 extends Geometry implements FlatGeometry{



        private Triangle _tri2;
        private Triangle _tri1;

        //********************* constructors *******************

        /**
         * default constructor
         */
        public quadrilateral2(){
            _tri1 = new Triangle();
            _tri2 = new Triangle();
        }

        public quadrilateral2( quadrilateral2 quadrangle){//@NotNull
            _tri1=new Triangle(quadrangle.get_tri1());
            _tri2=new Triangle(quadrangle.get_tri2());
        }


      /*  public quadrilateral2 (Point3D P1, Point3D P2, Point3D P3, Point3D P4)
        {
            _tri1 = new Triangle(P1, P2, P4);
            _tri2 = new Triangle(P4, P3, P1);
        }*/
    public quadrilateral2 (Point3D frontRight, Point3D frontLeft, Point3D backLeft, Point3D backRight)
    {//must put in point's in order od a circle think code Gray?? where only change one number
        _tri1 = new Triangle(frontRight, frontLeft, backLeft);//(1,1,1),(1,-1,1),(1,-1,-1) or (1,1,0),(1,-1,0),(-1,-1,0) for x,y on ground
        _tri2 = new Triangle(backLeft,backRight , frontRight);
    }


        //****************** getters & setters ****************
        public Triangle get_tri1() {
            return new Triangle(_tri1);
        }

        public Triangle get_tri2() {
            return new Triangle(_tri2);
        }

        public void set_tri2(Triangle _tri2) {
            this._tri2 = new Triangle(_tri2);
        }

        public void set_tri1(Triangle _tri1) {
            this._tri1 = new Triangle(_tri1);
        }

        //********************** operation *********************

        @Override
        public List<Point3D> FindIntersections(Ray ray){// throws Exception {
            List<Point3D> intersection1=_tri1.FindIntersections(ray);
            List<Point3D> intersection2=_tri2.FindIntersections(ray);
            intersection1.addAll(intersection2);
            return intersection1;
        }

        @Override
        public Vector getNormal( Point3D point){// throws Exception {  @Nullable
            return _tri2.getNormal(null);
        }
}

