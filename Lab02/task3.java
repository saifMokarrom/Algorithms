import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task3 {

	public static void main(String[] args) {
		File file = new File("Lab02/Task03_input.txt");
		int totNum;
		try {
			
			int cnt = 0;
			Scanner scan = new Scanner(file);
			while (scan.hasNextInt()) {
				//manually checking how many integers I have in my file
				cnt++;
				scan.nextInt();
				
			}
			
			int[] ara = new int[cnt];
			Scanner s = new Scanner(file);
			for (int i=0;i<cnt;i++)
				ara[i] = s.nextInt();
			
			int n = ara[0]; 
			
			int[] id_ara = new int[n];
			int[] marks_ara = new int[n];
			
			
			for (int i=1;i<=n;i++) id_ara[i-1] = ara[i]; //taking id array from the main array
			for (int i=n+1;i<cnt;i++) marks_ara[i-(n+1)] = ara[i]; //taking marks array from the main array
			
			id_ara = insertionSort(id_ara, marks_ara);
			
			//write in a file
			FileWriter writer;
			try {
				writer = new FileWriter("Lab02/Task03_output.txt");
				for (int x : id_ara) writer.write(x+" ");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static int[] insertionSort(int[] id, int[] marks) {
		int len = marks.length;
        for (int i = 0; i < len-1; i++) {
        	
            int tempM = marks[i+1];
            int tempId = id[i+1];
            
            int j;
            for (j = i; j>=0; j--) {
            	if (marks[j] < tempM) {
            		marks[j+1] = marks[j];
            		id[j+1] = id[j];
            	}
            	else break;
            }
            marks[j+1] = tempM;
            id[j+1] = tempId;
        }
        return id;
		
	}

}
