package main.geometries;

import main.primitives.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class Limited Cylinder for a cylinder with an end in space.
 * a cylinder have direction and points => Ray orientation.
 * and a top point.
 */
public class AshCylinderLim extends CylinderA {

    private Point3D top;

    // ***************** Constructors ********************** //

    /**
     * constructor
     *
     * @param myRadius
     * @param tp
     * @param myRay
     * @param e
     * @param m
     */
    public AshCylinderLim(double myRadius, Point3D tp, Ray myRay, Color e, Material m) {
        super(myRadius, myRay, e, m);
        top = tp;

    }

    // ***************** Getters/Setters ********************** //

    /**
     * getter
     *
     * @return
     */
    @Override
    public double getRadius() {
        return super.getRadius();
    }

    /**
     * getter
     *
     * @return
     */
    @Override
    public Ray getOrientation() {
        return super.getOrientation();
    }

    /**
     * getter
     *
     * @return
     */
    public Point3D getTop() {
        return top;
    }

    /**
     * getter
     *
     * @return
     */
    @Override
    public Material getMaterial() {
        return super.getMaterial();
    }

    /**
     * setter
     */
    public void setTop(Point3D top) {
        this.top = top;
    }

    /**
     * setter
     */
    @Override
    public void setMaterial(Material material) {
        super.setMaterial(material);
    }


    // ***************** Operations ******************** //

    /**
     * a function that checks if a given point is on the cylinder
     *
     * @param point
     * @return
     */
    private boolean isOnCylinder(Point3D point) {
        // the vector from bottom to the point
        Vector vec1 = new Vector(Point3D.substract(orientation.getPOO(), point));

        // the vector from the top to point
        Vector vec2 = new Vector(Point3D.substract(top, point));

        // the vectors to the edges of cylinder
        Vector vec3 = new Vector(Point3D.substract(orientation.getPOO(), point));

        Vector vec4 = new Vector(Point3D.substract(top, point));

        double Vec3dot = Vector.dotProduct(vec3, orientation.getDirection());

        double Vec4dot = Vector.dotProduct(vec4, orientation.getDirection());
        if (Vec3dot == 0)
            if (_radius - vec3.length() >= 0)
                return true;
        if (Vec4dot == 0)
            if (_radius - vec4.length() >= 0)
                return true;

        if (Vector.dotProduct(vec1, orientation.getDirection()) > 0
                && Vector.dotProduct(vec2, orientation.getDirection()) < 0)
            return true;
        return false;
    }

    /**
     * getter
     *
     * @return
     */
    @Override
    public Vector getNormal(Point3D somePoint) {
        if (!isOnCylinder(somePoint))
            return null;
        return super.getNormal(somePoint);
    }

    /**
     * return map of the Ray intersection points with the Cylinder.
     *
     * @param myRay
     * @return
     */
    @Override
   // public Map<Geometry, List<Point3D>> findIntersections(Ray myRay) {
        public List<Point3D> FindIntersections(Ray myRay) {

        List<Point3D> geometryListMap = new ArrayList<>();
        List<Point3D> listOfIntersections = new ArrayList<Point3D>();

        // the bottom base of the cylinder
        Plane plane1 = new Plane(orientation.getPOO(), orientation.getDirection());

        // the top base of the cylinder
        Plane plane2 = new Plane(top, orientation.getDirection());

        List<Point3D> temp1 = plane1.FindIntersections(myRay);

        List<Point3D> temp2 = plane2.FindIntersections(myRay);

        // removing all points that beyond the radius
        if (temp1 != null)
                for (Point3D p1 : temp1) {
                    if (new Vector(Point3D.substract(orientation.getPOO(), p1)).length() <= _radius && p1 != null)
                        listOfIntersections.add(p1);

            }

        if (temp2 != null)
                for (Point3D p2 : temp2) {
                    if (new Vector(Point3D.substract(orientation.getPOO(), p2)).length() <= _radius && p2 != null)
                        listOfIntersections.add(p2);

            }

        // using the infinity cylinder to find all the intersections in the body of the limited cylinder
        geometryListMap = super.FindIntersections(myRay);

            for (Point3D p : geometryListMap) {
                if (isOnCylinder(p))
                    listOfIntersections.add(p);

        }
        if (listOfIntersections.isEmpty())
            return null;
        //geometryListMap.put(this, listOfIntersections);
        return geometryListMap;
    }
}
