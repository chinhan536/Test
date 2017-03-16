import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class whitelist {
	public static String removeColon(String x){
		if (x.contains(":")){
			return x.substring(0,x.indexOf(":",0));
		} else {
			return x;
		}
	}

	public static void addToList(String x, ArrayList<String> y){
		if (y.indexOf(x)==-1){
			y.add(x);
			System.out.println(x);
		}
	}

    public static void main(String[] args) {

 		try{
    		Scanner s = new Scanner(new File("C:\\Squid\\var\\log\\squid\\access.log")).useDelimiter("\n");
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNext()){
				String line = s.next();
				if (line.contains("TCP_DENIED")){
					String[] test = line.split("\\s+");
					if (test[6].startsWith("http://")){
						String url = test[6].substring(7,test[6].indexOf("/",7));
						url = removeColon(url);
						addToList(url, list);
					}else{
						test[6] = removeColon(test[6]);
						addToList(test[6], list);
					}
				}
			}
			s.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
    }
}
