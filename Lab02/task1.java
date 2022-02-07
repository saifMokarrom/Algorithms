import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task1 {

	public static void main(String[] args) {
		
		File file = new File("Lab02/Task01_input.txt");
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
			int[] final_ara = new int[cnt-1];
			Scanner s = new Scanner(file);
			
			for (int i=0;i<cnt;i++)
				ara[i] = s.nextInt();
			totNum = ara[0]; //It is because first integer number is the total size of numbers which I have to sort
			
			for (int i=1;i<cnt;i++) final_ara[i-1] = ara[i];
			//calling method
			final_ara = bubbleSort(final_ara);
			
			//write in a file
			FileWriter writer;
			try {
				writer = new FileWriter("Lab02/Task01_output.txt");
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

	private static int[] bubbleSort(int[] ara) {
		
		
		/*as I have to make the sort O(n) for the best case. I have to check a boolean value because if the boolean variable
		 * remains unchanged after one whole iteration, Then I have a sorted array already. So no need to further calculation. 
		 */
		for (int i=0; i<ara.length-1; i++) {
			boolean sorted = true; // to check the array is sorted or not
			for (int j=0; j<ara.length-i-1; j++) {
				if (ara[j] > ara[j+1]) {
					
					int temp = ara[j+1];
					ara[j+1] = ara[j];
					ara[j] = temp;
					sorted = false; 
					
					/*if array is previously sorted then this if block will not be executed. 
					Hence we don't need any further checking */
				}
				
			}
			
			if (sorted) break;
		}
		return ara;
		
	}
	
	

}
