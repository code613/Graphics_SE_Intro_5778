package tests;

import main.scenes.Scene;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import main.geometries.Sphere;
import main.geometries.Triangle;
import main.primitives.Point3D;
import main.renderer.ImageWriter;
import main.renderer.Render;


public class RenderTest {

	final String IMAGES_TEST_DIR = "/src/testing/images/";

	@Test
	public void basicRendering(){
		
		Scene scene = new Scene();
		
		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));
		
		Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
				 						 new Point3D(  0, 100, -49),
				 						 new Point3D( 100, 100, -49));
		
		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
				 			 			  new Point3D(  0, -100, -49),
				 			 			  new Point3D( 100,-100, -49));
		
		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
				 						  new Point3D(  0, 100, -49),
				 						  new Point3D(-100, 100, -49));
		
		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
				 			 			  new Point3D(  0,  -100, -49),
				 			 			  new Point3D(-100, -100, -49));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "Render test 2", 500, 500, 500, 500);
		
		Render render = new Render(imageWriter, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToImage();
		
	}

}
