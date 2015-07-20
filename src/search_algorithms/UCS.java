package search_algorithms;

import java.util.*;


public class UCS extends Graph{
	private int[] visited;
	ArrayList<Node>  sort = new ArrayList<Node>();
	private ArrayList<Object> temp = new ArrayList<>();
	private Queue<Object> queue = new LinkedList<Object>();
	private int time,space;
	
	
	public void UCS_Menu() throws Exception{
		System.out.println("------------------------------Simulation of Uniform-cost Search---------------------------");
		System.out.println("----------------------------------City Number--------------------------------------------");
		for(int i=0;i<20;i++)
		{
			System.out.printf("%2d. %-15s", i,vertexList[i]);
			if(i%5==4)
				System.out.println();
		}
		System.out.println("-----------------------------------------------------------------------------------------");

			int start,end;
			System.out.println("Please input your start city:");
			Scanner input=new Scanner(System.in);
			start=input.nextInt();
			System.out.println("Please input your destination:");
			end = input.nextInt();
			if(start >= 0 && start < 20 && end >= 0 && end < 20 && start != end)
			{
				time = space = 0;
				UCSearch(start,end);
				//BFS_Time();
				
			}
			else 
			{
				System.out.println("Illegal city number, try again!");
			}
			
			System.out.println();
			System.out.println("----------End of Uniform-cost Search-----------");

	}
	public int firstNode(int i) {
		for (int j = 0; j < 20; j++) {
		if (costMat[i][j] > 0 && costMat[i][j]< infinate)
			return j;
		}
		return -1;
	}
	
	public int nextNode(int i, int k) {
		for (int j = k + 1; j < 20; j++) {
			if (costMat[i][j] > 0 && costMat[i][j]<infinate) 
				return j;
			}
		return -1;
		}
	
	
	public void UCSearch(int start,int end) throws Exception{
		visited=new int[20];
		sort=new ArrayList<>();
		queue = new LinkedList<Object>();
		for(int i=0;i<20;i++){
			visited[i]=0;
		}

		visit(start,null);
		while(!queue.isEmpty()){
			Node potentialNode=(Node)queue.remove();
			if(potentialNode.getCityName().equals(vertexList[end])){
				System.out.println("The Path from " + vertexList[start] + " to " + vertexList[end] + " is:");
				ArrayList<String> tempPath=potentialNode.path;
				System.out.print(vertexList[start]);
				for(int i=0;i<tempPath.size();i++){
					System.out.print(" -> ");
					System.out.print(tempPath.get(i));
				}
				System.out.println();
				
				time = time + 1;
				System.out.println("The total number of nodes generated is " + time);
				System.out.println("The maximum number of nodes that existed in memory is " + space);
				

				break;
			}
			

					
			if(visited[potentialNode.getCityNum()]==0){
				
			for (int k = this.firstNode(potentialNode.getCityNum());k>=0;k=this.nextNode(potentialNode.getCityNum(), k)){
				time++;
				visit(k,potentialNode);

			}
			for(int i=0;i<sort.size();i++)
		    {
		    System.out.println("sort1: "+sort.get(i).getPathCost());
		    }
			sort=nodeSort(sort);
			for(int i=0;i<sort.size();i++)
		    {
		    System.out.println("sort2: "+sort.get(i).getPathCost());
		    }
			insertSortedNode();
			for(int i=0;i<queue.size();i++)
		    {
				//queue.add(sort);
		    System.out.println("queue: "+queue.size());
		    }
			
			sort.clear();
			}
			visited[potentialNode.getCityNum()]=1;

		}
	}
	
	public void visit(int cityNum,Node root){
		//visited[cityNum]=1;
		if(root==null){
			Node tempNode=new Node(null, 0, vertexList[cityNum], cityNum);
			tempNode.setPathCost(0);
			temp.add(tempNode);
			queue.add(tempNode);
		}
	
		else{
			Node tempNode2=new Node(((Node)root).getRoot(),((Node)root).getDepth()+1, vertexList[cityNum], cityNum);
			tempNode2.setPathCost(((Node)root).getPathCost()+costMat[cityNum][root.getCityNum()]);
			temp.add(tempNode2);
			sort.add(tempNode2);
			//queue.add(tempNode2);
			for(int i=0;i<((Node)root).path.size();i++){
				tempNode2.path.add(((Node)root).path.get(i));
			}
			tempNode2.path.add(tempNode2.getCityName());
		}
		if(queue.size()>space){
			space=queue.size();
		}
	
}
	
	public ArrayList<Node> nodeSort(ArrayList<Node> nodeSet){
		if(nodeSet.size()==1){
			return nodeSet;
		}
		else{
			ArrayList<Node> array=new ArrayList<Node>();
			Node temp=new Node();
			for(int i=0;i<nodeSet.size();i++){
				array.add(nodeSet.get(i));
			}
		   /* for(int i=0;i<array.size();i++)
		    {
		    System.out.println("array1: "+array.get(i).getPathCost());
		    }

			
		   /* for(int i=0;i<array.size()-1;i++){  
		        for(int j=0;j<array.size()-1-i;j++){  
		        if(array.get(i).getPathCost()<array.get(j).getPathCost()){  
		        	System.out.println("array: "+ j +" " + array.get(j).getPathCost());
		         	System.out.println("array: "+ j+1 +" " + array.get(j+1).getPathCost());
		            temp=array.get(j); 
		            array.set(j, array.get(j+1));
		            array.set(j+1, temp);
		        }  
		        }  
		    }  */
		    
		    for (int i = 0; i < array.size() - 1; i++) {  
		        for (int j = 1; j < array.size() - i; j++) {  
		            if ((array.get(j - 1).getPathCost()) > (array.get(j).getPathCost())) {  
		            	temp = array.get(j - 1);  
		              array.set((j - 1), array.get(j));  
		              array.set(j, temp);  
		            }  
		            }  
		    }  
		    
		    /*for(int i=0;i<array.size();i++)
		    {
		    System.out.println("array2: "+array.get(i).getPathCost());
		    }*/
		    
		    
		    return array;

		}
	}

	public void insertSortedNode(){
		for(int i=0;i<sort.size();i++){
			System.out.println("I add "+sort.get(i).getCityName());
			System.out.println(sort.get(i).getPathCost() );
			queue.add(sort.get(i));
			}
		}
}