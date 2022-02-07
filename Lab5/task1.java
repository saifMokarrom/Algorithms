import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class task1 {

	public static void main(String[] args) {
		
		File file = new File("src/input1.txt");
		int totNum;
		int counter = 0;
		TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer> result = new TreeMap<Integer,Integer>();
		Scanner scan;
		try {
			scan = new Scanner(file);
			totNum = scan.nextInt();
			
			for (int i=0;i<totNum;i++) {
				int a  = scan.nextInt();
				int b = scan.nextInt();
				treeMap.put(b,a);
				
			}
			
			
			int finish = 0;
			for (Map.Entry<Integer, Integer> pair :treeMap.entrySet()) {
				if (counter == 0) {
					result.put(pair.getValue(), pair.getKey());
					finish = pair.getKey(); 
					counter++;
				}
				else if (pair.getValue() >= finish) {
					result.put(pair.getValue(), pair.getKey());
					finish = pair.getKey();
					counter++;
				}
			}
			
			FileWriter writer;
			try {
				writer = new FileWriter("src/output1.txt");
				writer.write(counter+"\n");
				for (Map.Entry<Integer, Integer> pair :result.entrySet()) writer.write(pair.getKey() + " "+ pair.getValue()+"\n");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            //System.out.println(pair.getKey() + " "+ pair.getValue());
			//System.out.println(result);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
