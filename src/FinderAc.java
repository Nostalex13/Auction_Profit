import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FinderAc {
	
	private String characterName;
	
	public FinderAc(String name) {
		characterName = name;
	}
	
	public String GetPath() {
		return FindFile();
	}
	
	private String FindFile() {
		List<File> fls = new ArrayList<File>();
		File foundFile = null;
		File initialLocation = new File(InputHandler.Instance.GetPath() + "/WTF/Account/");
		
		listf(initialLocation.getPath(), fls);
		
		try {
			for (File file : fls) {
				if (file.getPath().contains(characterName)) {
					foundFile = file;
					break;
				}
			}
			if (foundFile == null) throw new FileNotFoundException();			
		}
		catch (FileNotFoundException ex) {
			System.out.println("Character doesn`t exist");	
			
			return null;
		}
		
		
		String str = foundFile.getParentFile().getParentFile().getParentFile() + "\\SavedVariables\\Auctionator.lua";
		if (new File(str).exists()) {
			return str;
		}
			
		return null;
	}
	
	private void listf(String directoryName, List<File> files) {
	    File directory = new File(directoryName);

	    // Get all the files from a directory.
	    File[] fList = directory.listFiles();
	    if(fList != null){
	        for (File file : fList) {
	            if (file.isFile()) {
	                files.add(file);
	            } else if (file.isDirectory()) {
	                listf(file.getAbsolutePath(), files);
	            }
	        }
	    }
	}
}
