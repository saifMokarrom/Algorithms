import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task4 {

	public static void main(String[] args) {
		File file = new File("Lab02/Task04_input.txt");
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
			totNum = ara[0]; 
			
			for (int i=1;i<cnt;i++) final_ara[i-1] = ara[i];
			//calling method
			mergeSort(final_ara,0,final_ara.length-1,totNum);
			
			//write in a file
			FileWriter writer;
			try {
				writer = new FileWriter("Lab02/Task04_output.txt");
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
	static void mergeSort(int A[], int p, int r,int s)  
	{  
		if (p < r) {
			int midVal = (p + r) / 2;  
			mergeSort(A, p, midVal,s);  
	        mergeSort(A, midVal + 1, r,s);   
	        merge(A,p,midVal,r,s);
		}
        
	    
	}  
	static void merge(int A[], int p, int q, int r, int s)    
	{  
		 
		 int[] var = new int[s];
		 
		 int i = p;
		 int j = q+1;
		 
		 //start comparing 
		 int k=p;
		 while(i<=q && j<=r) {
			 if (A[i] <= A[j]) {
				 var[k] = A[i];
		    		i++;
		    		k++;
			 }
			 else {
		    	 var[k] = A[j];
		    	 j++;
		    	 k++;
		    }
			
		 }
		 
		 while(i <= q) {  //putting rest of the elements
			 var[k] = A[i]; i++; k++;
		 }
		 while(j <= r) {  //putting rest of the elements
			 var[k] = A[j]; j++; k++;
		 }
		 
		 for (int x=p;x<=r;x++) {
			 A[x] = var[x];
			 //This is because lastly we have to transfered the var array to main array A
		 }
	     
	}   
	
	

}
