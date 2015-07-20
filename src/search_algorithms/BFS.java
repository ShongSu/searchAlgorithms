package search_algorithms;

import java.util.*;


public class BFS extends Graph{
	
	private int[] visited;
	private ArrayList<Object> temp = new ArrayList<>();
	private Queue<Object> queue = new LinkedList<Object>();
	private int time,space;
	//private int start,end;

	public void BFS_Menu() throws Exception{
		System.out.println("------------------------------Simulation of Bread-first Search---------------------------");
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
				BFS_Search(start,end);
				//BFS_Time();
				
			}
			else 
			{
				System.out.println("Illegal city number, try again!");
			}
			
			System.out.println();
			System.out.println("----------End of Bread-first Search-----------");



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

	public void visit(int cityNum,Node root){
		visited[cityNum]=1;
		if(root==null){
			Node tempNode=new Node(null, 0, vertexList[cityNum], cityNum);
			temp.add(tempNode);
			queue.add(tempNode);
		}

		else{
			Node tempNode2=new Node(((Node)root).getRoot(),((Node)root).getDepth()+1, vertexList[cityNum], cityNum);
			temp.add(tempNode2);
			queue.add(tempNode2);
			for(int i=0;i<((Node)root).path.size();i++){
				tempNode2.path.add(((Node)root).path.get(i));
			}
			tempNode2.path.add(tempNode2.getCityName());
		}
		if(queue.size()>space){
			space=queue.size();
		}
	}

		 


		
	public void BFS_Search(int start,int end) throws Exception{
		visited=new int[20];
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
			for (int k = this.firstNode(potentialNode.getCityNum());k>=0;k=this.nextNode(potentialNode.getCityNum(), k)){
				time++;
				if(visited[k]==0){
					visited[k]=1;
					visit(k,potentialNode);
				}
			}
		}
	}


		}

