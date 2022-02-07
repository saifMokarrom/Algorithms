import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class task3 {

	public static void main(String[] args) {
		File file = new File("src/input3.txt");
		int totNum;
		String str = null;
		try {
			Scanner scan;
			scan = new Scanner(file);
			totNum = scan.nextInt();
			int[] ara = new int[totNum];
			for (int i=0;i<totNum;i++) {
				int a  = scan.nextInt();
				ara[i] = a;
				
			}
			while(scan.hasNext()) {
				str = scan.next();
			}
			System.out.println(str);
			
			work(ara,str);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void work(int[] ara, String str) {
		Arrays.sort(ara);
		ArrayList<Integer> qu = new ArrayList<Integer>();
		ArrayList<Integer> seq = new ArrayList<Integer>();
		int idx =0;
		int jack = 0;
		int jill = 0;

	
		
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i) == 'J') {

				qu.add(ara[idx]);
				seq.add(ara[idx]);
				jack += ara[idx];
				idx++;
			}
			else if (str.charAt(i) == 'j') {
				int index = qu.size() - 1;
		        int removed = qu.remove(index);
				
				seq.add(removed);
				jill += removed;
				
			}
		}
		
	    System.out.println("Jack will work for " + jack + " hours");
	    System.out.println("Jill will work for " + jill + " hours");
	    FileWriter writer;
		try {
			writer = new FileWriter("src/output3.txt");
			int cnt = 0;
		    for(int i : seq) {
		        writer.write(seq.get(cnt)+" ");
		        cnt++;
		    }
			writer.write("\nJack will work for " + jack + " hours"+"\n");
			writer.write("Jill will work for " + jill + " hours");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
		
	}

}
