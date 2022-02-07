import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*; 

class pQ implements Comparator<pQ>
{
    int v;
    int w;
    pQ() {}
    pQ(int v, int w) { 
    	this.v = v; 
    	this.w = w; 
    }
    
    @Override
    public int compare(pQ obj1, pQ obj2) 
    { 
        if (obj1.w < obj2.w) 
            return 1; 
        if (obj1.w > obj2.w) 
            return -1; 
        return 0; 
    } 
}

class task4
{
	static int vertices;
	public static void main(String args[])
    {
		
		
    	File file = new File("src/input4.txt");
		Scanner scan;
		int totNum;
		int edges;
		ArrayList<ArrayList<Integer> > finalRes = new ArrayList<ArrayList<Integer> >();
		ArrayList<Integer> temp;
		try {
			scan = new Scanner(file);
			while (scan.hasNextInt()) {
				totNum = scan.nextInt();
				
				for (int i=0;i<totNum;i++) {
					temp =   new ArrayList<Integer>();
					vertices = scan.nextInt();
					edges = scan.nextInt();
					ArrayList<ArrayList<pQ> > graph = new ArrayList<ArrayList<pQ> >();
					for (int j=0;j<=vertices;j++) {
						graph.add(new ArrayList<pQ>());
					}
					int u,v,w;
					for(int j=0;j<edges;j++) {
						u = scan.nextInt();
						v = scan.nextInt();
						w = scan.nextInt();
						graph.get(u).add(new pQ(v,w));
					}
					int source = scan.nextInt();
					
					
					int[] distance = network(graph,source);
					for (int i1 = 1; i1 <=vertices; i1++)
			        {
						temp.add(distance[i1]);
			 
			        }
			     
			        finalRes.add(temp);

					
				}
				FileWriter writer;
				try {
					writer = new FileWriter("src/output4.txt");
					for (int i = 0; i < finalRes.size(); i++)
					{
					    for (int j =0; j < finalRes.get(i).size(); j++)
					    {
					    	int ans;
					    	if (i==finalRes.size()-1 && j==finalRes.get(i).size()-1) { ans = finalRes.get(i).get(j)-1;}
					    	else { ans = finalRes.get(i).get(j);}
					        writer.write(ans+" ");
					    } 
					    writer.write("\n");
					    
					}
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	
	
	static int[] network(ArrayList<ArrayList<pQ>> adj,int source)
    {
		int distance[] = new int[vertices+1];
        int prev[] = new int[vertices+1];
        
        for(int i = 0;i<=vertices;i++) distance[i] = -1;
        distance[source] = 0; 
        
        PriorityQueue<pQ> priorityQ = new PriorityQueue<pQ>(vertices+1, new pQ());
        priorityQ.add(new pQ(source,0));
        
        while(priorityQ.peek() != null) {
            pQ node = priorityQ.poll();
            
            for(pQ it: adj.get(node.v)) {
            	int temp = distance[node.v]+it.w;
            	
                if(temp > distance[it.v]) {
                    distance[it.v] = it.w;
                    prev[it.v] = node.v;
                    priorityQ.add(new pQ(it.v, distance[it.v]));
                }
            }
        }
 
		return distance; 
    }
}