import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task2 {
	
	public static void main(String[] args) {
		File file = new File("Lab02/Task02_input.txt");
		int totNum,preferSize;
		try {
			
			int cnt = 0;
			Scanner scan = new Scanner(file);
			while (scan.hasNextInt()) {
				//manually checking how many integers I have in my file
				cnt++;
				scan.nextInt();
				
			}
			
			int[] ara = new int[cnt];
			int[] final_ara = new int[cnt-2];
			Scanner s = new Scanner(file);
			
			for (int i=0;i<cnt;i++)
				ara[i] = s.nextInt();
			totNum = ara[0]; 
			preferSize = ara[1];
			
			for (int i=2;i<cnt;i++) final_ara[i-2] = ara[i];
			
			final_ara = selectionSort(final_ara,preferSize);
			
			//write in a file
			FileWriter writer;
			try {
				writer = new FileWriter("Lab02/Task02_output.txt");
				for (int x : final_ara) writer.write(x+" ");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int[] selectionSort(int[] ara, int preferSize) {
		int[] sorted_ara = new int[preferSize];
	
        for (int i = 0; i < ara.length-1; i++)
        {
            int min = i;
            for (int j = i+1; j < ara.length; j++) {
                if (ara[j] < ara[min])
                    min = j;
            }
 
            if (min != i) {
            	 int temp = ara[min];
                 ara[min] = ara[i];
                 ara[i] = temp;
            }
           
        }
        
        for (int i=0; i<preferSize; i++)
        	sorted_ara[i] = ara[i];
        
        return sorted_ara;
		
	}
}
