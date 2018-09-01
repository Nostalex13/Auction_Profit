import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InputHandler {
	
	public static final InputHandler Instance = new InputHandler();

	private Map<String, String> data = new HashMap<String, String>();
	private final File configFile = new File("./config/name.lua");
	
	public InputHandler() {
		//FindSavedName();
	}
	
	private void FindSavedName() {
		String str;
		//System.out.println(file.exists());
		if(configFile.exists()) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(configFile.getPath()),"UTF-8"))){
				str = br.readLine();
				System.out.println("Read from file: " + str);
			}
			catch(IOException ex){
				System.out.println("Error! Couldn`t read from file");
			}
		}
	}
	
	public void SetPath(String path) {
		if (data.containsKey("Path")) {
			data.remove("Path");
			data.put("Path", path);
		} else {
			data.put("Path", path);
		}
	}
	
	public void SetName(String name) {
		if (data.containsKey("Name")) {
			data.remove("Name");
			data.put("Name", name);
		} else {
			data.put("Name", name);
		}
	}
	
	public String GetName() {
		return data.containsKey("Name") ? data.get("Name") : null;
	}
	
	public String GetPath() {
		return data.containsKey("Path") ? data.get("Path") : null;
	}
}
