import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class problem4 {

	public static void main(String[] args) {
		
		File file1 = new File("src/Input_matrix1_problem4.txt");
		File file2 = new File("src/Input_matrix2_problem4.txt");
		int n = 2;
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];
		int[][] c = new int[n][n];
		
		try {
			// taking matrix input
			Scanner scan = new Scanner(file1);
			while (scan.hasNextLine()) {
				for (int i=0;i<a.length;i++) {
					String[] str = scan.nextLine().trim().split(" ");
					for (int j=0;j<str.length;j++) {
						a[i][j] = Integer.parseInt(str[j]);
					}
				}
				
			}
			Scanner scan2 = new Scanner(file2);
			while (scan2.hasNextLine()) {
				for (int i=0;i<a.length;i++) {
					String[] str = scan2.nextLine().trim().split(" ");
					for (int j=0;j<str.length;j++) {
						b[i][j] = Integer.parseInt(str[j]);
					}
				}
				
			}
			
			//storing the product of two matrices
			c = Multiply_matrix(a, b);
			
			
			//writing the matrix in another file
			String output ="";
			for(int i=0; i<n;i++)
	        {            
	           for(int j=0; j<n;j++)
	           {
	              // System.out.print(c[i][j]+" ");
	        	   output += String.valueOf(c[i][j])+" "; 
	           }
	           output+="\n";
	        }
			FileWriter writer;
			try {
				writer = new FileWriter("src/output_problem4.txt");
				writer.write(output);
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

	

	private static int[][] Multiply_matrix(int[][]a, int[][] b) {
		int n = 2;
		int[][] c = new int[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					c[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		return c;
	}

}
