package main.geometries;
import main.primitives.*;
//import main.primitives.Color;
import java.awt.Color;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * class Cylinder for cylinder in space.
 * a cylinder have direction and points => Ray orientation.
 * we decided to implement infinite cylinder.
 */
public class CylinderA extends RadialGeometry {

    Ray orientation;

    // ***************** Constructors ********************** //

    /**
     * constructor
     *
     * @param myRadius //@param length
     * @param myRay
     * @param e
     * @param m
     */
    public CylinderA(double myRadius, Ray myRay, Color e, Material m) {
        super(myRadius);//(double radius, Point3D axisPoint, Vector axisDirection)
        _radius = myRadius;
        orientation = myRay;
        setEmmission(e);
        setMaterial(m);
    }

    /**
     * constructor with no color uses the default color.
     *
     * @param myRadius //@param length
     * @param myRay
     */
   /* public CylinderA(double myRadius*//*, double length*//*, Ray myRay) {
        super(myRadius);
        _radius = myRadius;
        orientation = myRay;
    }*/

    /**
     * constructor with no length uses the default of 1.
     *
     * @param myRadius
     * @param myRay
     */

    // ***************** Getters/Setters ********************** //

    /**
     * getter
     *
     * @return
     */
    public Ray getOrientation() {
        return orientation;
    }

    /**
     * getter
     *
     * @return
     */
    public Color getEmission() {
        return super.getEmmission();
    }

    /**
     * getter
     *
     * @return
     */
    @Override
    public double getRadius() {
        return super.getRadius();
    }

    // ***************** Operations ******************** //

    /**
     * calculate the vector from somePoint to the point that defines the Cylinder orientation.
     * full explanation in the code.
     *
     * @param somePoint
     * @return
     */
    @Override
    public Vector getNormal(Point3D somePoint) {

        // first, we need to have all components for Pythgore theorem.
        // we already have the radius - which is one of the bases,
        // and the reminder will be the vector from the point that defines the orientation to somePoint.
        Vector reminder = new Vector(somePoint, orientation.getPOO());
        double sizeOfBaseOnCylinderSurface = Math.sqrt(Math.pow(reminder.length(), 2) - Math.pow(getRadius(), 2));

        //second, define new point: the point on the Cylinder surface which the vector from the orientation point to this point
        //will be orthogonal to the orientation vector.
        //since we squerd the reminder the new point is p0 + tv or po -tv,
        //where p0 is the orientation point, v is the orientation vector, and t is the sizeOfBaseOnCylinderSurface.
        Vector tv = orientation.getDirection().multiplyByScalar(sizeOfBaseOnCylinderSurface);
        Point3D pointBehind = Point3D.add(somePoint, tv.getHead());
        Point3D pointInFront = Point3D.substract(somePoint, tv.getHead());

        // finally, one of the vectors from the orientation point to those point is the one we look for.
        // to determine which one is it, we check which vector is orthogonal to the orientation vector.
        Vector toPointBehind = new Vector(orientation.getPOO(), pointBehind);
        Vector toPointInFront = new Vector(orientation.getPOO(), pointInFront);

        if (Vector.dotProduct(orientation.getDirection(), toPointBehind) == 0) {
            toPointBehind.normalize();
            return toPointBehind;
        } else {
            toPointInFront.normalize();
            return toPointInFront;
        }
    }
        //we return something else..... we just return a List
   /* @Override
    public Map<Geometry, List<Point3D>> FindIntersections(Ray myRay) {*/

   /**
     * return map of the Ray intersection points with the Cylinder.
     *
     * @param myRay
     * @return
     */
        @Override
        public List<Point3D> FindIntersections(Ray myRay) {
        // creating the map and list for returning
        Map<Geometry, List<Point3D>> geometryListMap = new HashMap<>();
        List<Point3D> listOfIntersections = new ArrayList<Point3D>();

        // we get the vector from the light source  V
        // and the orientation of the cylinder  Va
        Vector rayDirection = new Vector(myRay.getDirection().getHead()); // V
        Vector cylinderDirection = new Vector(getOrientation().getDirection().getHead()); // Va
        Point3D rayPoint = new Point3D(myRay.getPOO());//.getPoint());

        // calculating the delta of the point
        Vector delta = new Vector(Point3D.substract(orientation.getPOO(),rayPoint));//getPoint(), rayPoint));

        // calculating the A component
        // A = (V - (V * Va) Va)^2
        Vector temp = new Vector(Point3D.substract(cylinderDirection.multiplyByScalar(Vector.dotProduct(rayDirection, cylinderDirection)).getHead(), rayDirection.getHead()));
        double A = Vector.dotProduct(temp, temp);

        // calculating the B component
        // 2( (V - ( V * Va)Va) *( delta - (delta * Va)Va))
        Vector temp1 = new Vector(Point3D.substract(
                (cylinderDirection.multiplyByScalar(Vector.dotProduct(delta,
                        cylinderDirection)).getHead()), delta.getHead()));

        double scaleB = Vector.dotProduct(rayDirection, cylinderDirection);
        Vector vecB = new Vector(Point3D.substract(rayDirection.getHead(),
                cylinderDirection.multiplyByScalar(scaleB).getHead()));

        double B = 2 * Vector.dotProduct(vecB, temp1);

        // calculating the C component
        // (delta - (delta * Va)Va)^2 - r^2
        double C = Vector.dotProduct(temp1, temp1) - Math.pow(_radius, 2);

        double sqrtCom = Math.pow(B, 2) - (4 * A * C);

        double t1 = (-B + Math.sqrt(sqrtCom)) / (2 * A);

        double t2 = (-B - Math.sqrt(sqrtCom)) / (2 * A);

        // there is no real solution
        if (sqrtCom < 0)
            return listOfIntersections;
        // one intersection
        if (sqrtCom == 0) {
            if (t1 < 0) {
                return listOfIntersections; // the intersection is not visible.
            }
            Point3D p = Point3D.add(rayPoint, rayDirection.multiplyByScalar(t1).getHead());
            listOfIntersections.add(p);
            geometryListMap.put(this, listOfIntersections);
            return listOfIntersections;
        }

        // two intersections
        if (t1 < 0 && t2 < 0) {
            return listOfIntersections;
        } else if (t1 < 0 && t2 > 0) {
            listOfIntersections.add(new Point3D(Point3D.add(rayPoint, rayDirection.multiplyByScalar(t2).getHead())));
        } else if (t1 > 0 && t2 < 0) {
            listOfIntersections.add(new Point3D(Point3D.add(rayPoint, rayDirection.multiplyByScalar(t1).getHead())));
        } else {
            listOfIntersections.add(new Point3D(Point3D.add(rayPoint, rayDirection.multiplyByScalar(t1).getHead())));
            listOfIntersections.add(new Point3D(Point3D.add(rayPoint, rayDirection.multiplyByScalar(t2).getHead())));//.getVector())));
        }

        geometryListMap.put(this, listOfIntersections);
        return listOfIntersections;
    }
}
