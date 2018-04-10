package tests;

import main.scenes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import main.renderer.*;


public class SceneFactoryTest {
	private final String IMAGES_TEST_DIR =  "/src/testing/images/";

	@Test
	public void sceneFactoryTest(){
		
		SceneBuilder sceneFactory = new SceneBuilder("1-01_sphere" + ".xml",IMAGES_TEST_DIR);
		
		ImageWriter IW = sceneFactory.getImageWriter();
		Scene scene = sceneFactory.getScene();
		
		Render render = new Render(IW, scene);
		
		render.renderImage();
		render.printGrid(50);
		render.writeToImage();
		
	}
	
}
