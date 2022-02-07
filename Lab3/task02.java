import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class task02 {

	public static void main(String[] args)  {
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
			
			int[] visited = new int[num];
			
			BFS(visited,arral,1,12);


			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	private static void BFS(int[] visited, ArrayList<ArrayList<Integer>> arral, int i, int j)  {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Queue<Integer> que = new LinkedList<Integer>();
		visited[i - 1] = 1;
		que.add(i);
		while(!que.isEmpty()) {
			int m = que.poll();
			temp.add(m);
			
			
			if (m == j) break;
			for (int x: arral.get(m)){
				if(visited[x-1] == 0) {
					visited[x-1] = 1;
					que.add(x);
				}
			}
		}
		writeFile(temp);
		
	}

	private static void writeFile(ArrayList<Integer> temp) {
		FileWriter writer;
		try {
			writer = new FileWriter("src/output2.txt");
			
			for (int x: temp) writer.write(x+" ");
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
