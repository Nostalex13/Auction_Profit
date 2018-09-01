import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class InputHandler {
	
	public static final InputHandler Instance = new InputHandler();

	private Map<String, String> data = new HashMap<String, String>();
	private final File configFile = new File("../config/name.lua");
	
	public InputHandler() {
		GetDataFromFile();
	}
	
	private void SaveDataToFile() {
		try {
			if (configFile.exists()) {
				FileOutputStream fos = new FileOutputStream(configFile, false); // with rewriting
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(data);
				oos.flush();
				oos.close();			
			} else 
				System.out.println("File with data doesn`t exists");	
		}
		catch (IOException ex) {
			System.out.println("You fucked up in saving");
		}
	}
	
	private void GetDataFromFile() {
		try {
			FileInputStream fis = new FileInputStream(configFile);
			ObjectInputStream oin = new ObjectInputStream(fis);
			data = (HashMap<String, String>) oin.readObject();
			oin.close();
			System.out.println(GetPath());
			System.out.println(GetName());
		}
		catch (IOException ex) {
			System.out.println("You fucked up in reading");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("You fucked up in saving");
		}
	}
	
	public void SetPath(String path) {
		if (data.containsKey("Path")) {
			data.remove("Path");
			data.put("Path", path);
		} else {
			data.put("Path", path);
		}
		
		SaveDataToFile();
	}
	
	public void SetName(String name) {
		if (data.containsKey("Name")) {
			data.remove("Name");
			data.put("Name", name);
		} else {
			data.put("Name", name);
		}
		
		SaveDataToFile();
	}
	
	public String GetName() {
		return data.containsKey("Name") ? data.get("Name") : null;
	}
	
	public String GetPath() {
		return data.containsKey("Path") ? data.get("Path") : null;
	}
}
