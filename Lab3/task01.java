import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class task01 {
	public static void main(String[] args) {
		
		File file = new File("src/a.txt");
		try {
			ArrayList<ArrayList<Integer>> arral = null;
			Scanner scan = new Scanner(file);
			boolean first = true;
			int num = 0;
			while(scan.hasNextInt()) {
				if (first) {
					num = scan.nextInt();
					arral = new ArrayList<ArrayList<Integer>>();
					for (int i=1;i<=num;i++) {
						arral.add(new ArrayList<Integer>());
					}
					int totConnection = scan.nextInt();
					first = false;
				}
				else {
					int a = scan.nextInt();
					int b = scan.nextInt();
					arral.get(a).add(b);
				}
			}
			//write in a file
			FileWriter writer;
			try {
				writer = new FileWriter("src/output1.txt");
				for (int i=1;i<num;i++) {
					writer.write(i+" ");
					for (int x: arral.get(i)) writer.write(" -> "+x); writer.write("\n");
				}
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}


}
