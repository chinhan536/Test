import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

class whitelistcount {

	public static void main(String[] args) {

		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		int threshold = Integer.parseInt(args[0]);

		try{
			File[] fileArray= new File(".").listFiles();

	        for(File f: fileArray) // loop thru all files
	        {
	           if(f.getName().endsWith(".txt")) // to deal with the .txt files.
	           {
	             Scanner s = new Scanner(f); // to read the files

	             while(s.hasNext()){
	             	String url = s.next();
	             		if(dictionary.containsKey(url)){
	             			int count = dictionary.get(url);
	             			count++;
	             			dictionary.put(url, count);

	             			if(count > threshold){
	             				System.out.println(url);
	             			}
	             		}else{
	             			dictionary.put(url, 1);
	             		}
	             	}
	             s.close();
	            }


	        }
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
	}
}
