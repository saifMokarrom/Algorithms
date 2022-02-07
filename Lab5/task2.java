import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class sortedOrder{
	
	public int s, fin;
    public sortedOrder(int s, int fin) {
        this.s = s;
        this.fin = fin;
    }
}

public class task2 {
	public static void main(String args[])
    {
		File file = new File("src/input2.txt");
		int totNum;
		int people;
		boolean first = true;
		int finalRes = 0;

		try {
			Scanner scan;
			scan = new Scanner(file);
			totNum = scan.nextInt();
			people = scan.nextInt();
			sortedOrder[] ara = new sortedOrder[totNum];

			for (int i=0;i<totNum;i++) {
				int a  = scan.nextInt();
				int b = scan.nextInt();
				
				ara[i] = new sortedOrder(a,b);

			}
			
			int i, j, minIdx;  

			//I have used Selection sort to sort the ara on the basis of finishing time
			for (i = 0; i < totNum-1; i++) 
			{  
				minIdx = i; 
				for (j = i+1; j < totNum; j++) { 
					if (ara[j].fin < ara[minIdx].fin)  
						minIdx = j;  
				}
				sortedOrder temp = new sortedOrder(ara[minIdx].s,ara[minIdx].fin);  
				ara[minIdx] = ara[i];  
				ara[i] = temp;  
			} 

		    finalRes = completeTask(ara,totNum,people);
		    FileWriter writer;
			try {
				writer = new FileWriter("src/output2.txt");
				writer.write(finalRes+"\n");
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

	private static int completeTask(sortedOrder[] ara, int totNum, int people) {
		int visited[] = new int[totNum];
		int finalRes = 0;
		for (int i = 0; i < people; i++) {
			int finish = 0;
            for (int j = 0; j < totNum; j++) {
                if (visited[j] == 0) {

                    // if the task is not done
                    if (ara[j].s >= finish) {
                        finish = ara[j].fin;
                        visited[j] = 1;
						finalRes++;
                    }
                }
            }
        }
		return finalRes;
		
	}
}

