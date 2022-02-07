import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class task03 {

	static int num = 0;
	static int[] visited;
	static ArrayList<Integer> printed = new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> arral = null;
	public static void main(String[] args) {
		File file = new File("src/a.txt");
		
		try {
			
			Scanner scan = new Scanner(file);
			boolean first = true;
			
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
			
			
			visited = new int[num];
			
			for (int i=1;i<=num;i++) {
				if (visited[i-1] == 0)
					DFS(i,12);
			}
			
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void DFS(int i,int end) {
		
		visited[i-1] = 1;
	    printed.add(i);
	    if (i == end) return;
	    for(int x: arral.get(i))
	    {
	    	
	    	if(visited[x-1] == 0 )
	        {
	        	
	            DFS(x,end);
	           
	        }
	 
	    }
	    writeFile(printed,end);
	    
	   
	    
	}
	private static void writeFile(ArrayList<Integer> temp,int end) {
		FileWriter writer;
		try {
			writer = new FileWriter("src/output3.txt");
			
			for (int x: temp) {
				writer.write(x+" ");
				if (x==end)break;
			}
				
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	


}
