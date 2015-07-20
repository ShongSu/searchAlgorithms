package search_algorithms;
import java.io.*;
import java.util.*;  


public class RomaniaSearch {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("-------Test for Romania Problem-------");
		
		while(true) {
			System.out.println("\nWhich uniformed search algorithm do you perfer?");
			System.out.println("A. Bread-first Search");
			System.out.println("B. Depth-first Search");
			System.out.println("C. Uniform-cost Search");
			System.out.println("V. See World");
			System.out.println("E. Exit");
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String option= br.readLine();
			option = option.toUpperCase();
			//System.out.println("This is "+ option);
			if(option.equals("A")){
				BFS bfs = new BFS();
				bfs.BFS_Menu();
				
			}
			else if(option.equals("B")){
				DFS dfs = new DFS();
				dfs.DFS_Menu();
			}
			else if(option.equals("C")){
				UCS ucs = new UCS();
				ucs.UCS_Menu();
				
			}
			else if(option.equals("V")){
				
				Graph graph = new Graph();
		        System.out.println("Adjacency Matrix of the Graph:");  
		        System.out.print("          ");
		        graph.printvertexs();
		        graph.printcostMat(); 
			}
			else if(option.equals("E")){
				break;
				
			}
			else{
				System.out.println("Illegal input, try again.");
			}
			

		}

		
		
		
		
		


	}
	

}
