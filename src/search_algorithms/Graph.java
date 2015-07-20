package search_algorithms;
import java.io.*;
import java.util.*;

public class Graph {

    protected int infinate;
    protected String[] vertexList; 
    protected int[][] costMat; 
        
    public Graph() {  
        costMat = new int[20][20];
        vertexList = new String[20];
        infinate = 999;
        vertexList[0]="Arad";
        vertexList[1]="Bucharest";
        vertexList[2]="Craiova";
        vertexList[3]="Dobreta";
        vertexList[4]="Eforie";
        vertexList[5]="Fagaras";
        vertexList[6]="Giurgiu";
        vertexList[7]="Hirsova";
        vertexList[8]="Iasi";
        vertexList[9]="Lugoj";
        vertexList[10]="Mehadia";
        vertexList[11]="Neamt";
        vertexList[12]="Oradea";
        vertexList[13]="Pitesti";
        vertexList[14]="R.Vilcea";
        vertexList[15]="Sibiu";
        vertexList[16]="Timisoara";
        vertexList[17]="Urziceni";
        vertexList[18]="Vaslui";
        vertexList[19]="Zerind";

        for(int j=0;j<20;j++) {  
            for(int k=0;k<20;k++) { 
            	if(j==k){
            		costMat[j][k] = 0; 
            	}
            	else{
            		costMat[j][k] = infinate;
            	}
            }
        }   
        addEdge(12, 19, 71);  
        addEdge(0, 19, 75);
        addEdge(12, 15, 151);
        addEdge(0, 15, 140);
        addEdge(0, 16, 118);
        addEdge(9, 16, 111);
        addEdge(9, 10, 70);
        addEdge(3, 10, 75);
        addEdge(2, 3, 120);
        addEdge(14, 15, 80);
        addEdge(5, 15, 99);
        addEdge(2, 14, 146);
        addEdge(13, 14, 97);
        addEdge(2, 13, 138);
        addEdge(1, 13, 101);
        addEdge(1, 6, 90);
        addEdge(1, 5, 211);
        addEdge(1, 17, 85);
        addEdge(17, 18, 142);
        addEdge(8, 18, 92);
        addEdge(8, 11, 87);
        addEdge(7, 17, 98);
        addEdge(4, 7, 86);
    }
    
    public void addEdge(int start,int end, int cost) {  
    	costMat[start][end] = costMat[end][start] = cost;  
    } 
    
    public void printcostMat() {  
        
    	for(int i=0;i<20;i++){
    		System.out.printf("%-10s",vertexList[i]);
    		for(int j=0;j<20;j++){
    			if(costMat[i][j]==999)
    			{
    				System.out.printf("%-10s","-");
    			}
    			else
    			{
    				System.out.printf("%-10d",costMat[i][j]);
    			}
					
    		}
    		System.out.println();	
    	}

    }  
    
    public void printvertexs() {  
         
            for(String i: vertexList) {  
                System.out.printf("%-10s", i);  
        }  
            System.out.println();
    }  
    
    class Node{
    	private String root;
		private int depth;
		private String cityName;
		private int cityNum;
		public ArrayList<String> path=new ArrayList<>();
		private int pathCost;
		public int getPathCost()
		{
			return pathCost;
		}
		public void setPathCost(int pathCost)
		{
			this.pathCost = pathCost;
		}
		
    	public String getRoot()
		{
			return root;
		}
    	public void setRoot(String root)
		{
			this.root = root;
		}
    	public int getDepth()
		{
			return depth;
		}
    	public void setDepth(int depth)
		{
			this.depth = depth;
		}
    	public String getCityName()
		{
			return cityName;
		}
    	public void setCityName(String cityName)
		{
			this.cityName = cityName;
		}
    	public int getCityNum()
		{
			return cityNum;
		}
    	public void setCityNum(int cityNum)
		{
			this.cityNum = cityNum;
		}
		
		public Node(String root,int depth,String cityName,int cityNum){
			this.root=root;
			this.depth=depth;
			this.cityName=cityName;
			this.cityNum=cityNum;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
    	
    	
    }
    
    
}