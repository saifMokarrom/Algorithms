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
        if (obj1.w > obj2.w) 
            return 1; 
        if (obj1.w < obj2.w) 
            return -1; 
        return 0; 
    } 
}

class task1
{
	static int vertices;
	public static void main(String args[])
    {
    	File file = new File("src/input1.txt");
		Scanner scan;
		int totNum;
		int edges;
		int[] finalRes;
		try {
			scan = new Scanner(file);
			while (scan.hasNextInt()) {
				totNum = scan.nextInt();
				finalRes = new int[totNum];
				
				for (int i=0;i<totNum;i++) {
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
					
					
					
					int[] distance = shortestPath(graph,1);
					/*for (int i1 = 1; i1 <=vertices; i1++)
			        {
			            System.out.print( distance[i1] + " ");
			        }
			        System.out.println();*/


					finalRes[i] = distance[vertices];
					
				}
				FileWriter writer;
				try {
					writer = new FileWriter("src/output1.txt");
					for (int x : finalRes) writer.write(x+"\n");
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
    static int[] shortestPath(ArrayList<ArrayList<pQ>> li,int s)
    {
        int distance[] = new int[vertices+1];
        int prev[] = new int[vertices+1];
        
        for(int i = 0;i<=vertices;i++) distance[i] = Integer.MAX_VALUE;
        distance[s] = 0; 
        
        PriorityQueue<pQ> priorityQ = new PriorityQueue<pQ>(vertices+1, new pQ());
        priorityQ.add(new pQ(s, 0));
        
        while(priorityQ.peek() != null) {
            pQ node = priorityQ.poll();
            
            for(pQ it: li.get(node.v)) {
            	int temp = distance[node.v] + it.w;
                if(temp < distance[it.v]) {
                    distance[it.v] = temp; 
                    prev[it.v] = node.v;
                    priorityQ.add(new pQ(it.v, distance[it.v]));
                }
            }
        }
        
        
		return distance;  /*For task 1, no need to return prev because we need the shortest path for Eren to reach home,
		neither I need to compute prev to get shortest path ans but if we need the nodes to reach home, then we have to 
		keep a track of prev(parent)*/

    }

}

