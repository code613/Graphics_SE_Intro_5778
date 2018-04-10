package tests;

import org.junit.jupiter.api.Test;
import main.parser.SceneDescriptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;

public class ParserTest {

	private final String SCENE_FILE_PATH = System.getProperty("user.dir");
	String sceneXMLDesc;

	@Test
	public void parserTest(){
		
		final String SCENE_FILE_NAME = "/src/main/scenes/" + "1-01_sphere" + ".xml";
		
		File sceneFile = new File(SCENE_FILE_PATH + SCENE_FILE_NAME);
		loadSceneFromFile(sceneFile);
		
		SceneDescriptor sd = new SceneDescriptor();
		try {
			sd.fromXML(sceneXMLDesc);
		} catch (ParseException e) {
			System.out.println("Syntactical error in scene description:");
			e.printStackTrace();
		}
		
		System.out.print(sceneXMLDesc);
		
	}
	
	private boolean loadSceneFromFile(File file) {
		if (file == null) {
			return false;
		}
		try {
			byte[] buffer = new byte[(int) file.length()];
			FileInputStream fin = new FileInputStream(file);
			fin.read(buffer);
			sceneXMLDesc = (new String(buffer));
			fin.close();
			return true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
