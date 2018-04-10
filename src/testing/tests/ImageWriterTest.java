package tests;



import main.renderer.ImageWriter;
import org.junit.jupiter.api.Test;

public class ImageWriterTest {

    private final String IMAGES_TEST_DIR = "/src/testing/images/";

	@Test
	public void writeImageTest(){
		
		ImageWriter imageWriter = new ImageWriter(IMAGES_TEST_DIR + "Image writer test", 500, 500, 500, 500);
		
		for (int i = 0; i < imageWriter.getHeight(); i++){
			for (int j = 0; j < imageWriter.getWidth(); j++){
				
				if (i % 50 == 0 || j % 50 == 0)
					imageWriter.writePixel(j, i, 255, 255, 255);
				
			}
		}
		
		imageWriter.writeToimage();

	}
	
}
