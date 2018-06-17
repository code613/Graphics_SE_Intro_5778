package testing.tests;

import main.geometries.Triangle;
import main.primitives.Point3D;
import org.junit.jupiter.api.Test;


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




public class quadratTest {
        @Test
        void testGetNormal() {
            int z1 = -10,z2 = -20;
            Point3D p1 = new Point3D(0.0,0.0,z1);
            Point3D p2 = new Point3D(200,0,z1);
            Point3D p3 = new Point3D(200,200,z2);
            Point3D p4 = new Point3D(0,200,z2);
            Triangle t1, t2,t3;
            Vector v1,v2,v3,v4;
            t1 = new Triangle(p1,p4,p2);
            t3 = new Triangle(p1,p4,p2);
            t2 = new Triangle(p3,p2,p4);
            v1 = t1.getNormal(p1);
            v2 = t2.getNormal(p2);
            v3 = t3.getNormal(p4);

            System.out.println(t1.getNormal(p1));
            System.out.println("let us see what happens here!!!");
            System.out.println(t2.getNormal(p2));
            if(v1.compareTo2(v3)){
                System.out.println("this  not very bad");
            }
            System.out.println("this  better work thank you"); //yes this does..
            if (t1.getNormal(p1).compareTo2(t2.getNormal(p2))){
                //println("doues this work as well???");  noooo lol
                System.out.println("um i hope this works thank you");
                System.out.println("THIS IS WHAT I AM LOOKING FOR!!!!!!");
            }
            if (t3.getNormal(p1).compareTo2(t1.getNormal(p1))){
                //println("doues this work as well???");  noooo lol
                System.out.println("umm this should work");
                }

        }
}

