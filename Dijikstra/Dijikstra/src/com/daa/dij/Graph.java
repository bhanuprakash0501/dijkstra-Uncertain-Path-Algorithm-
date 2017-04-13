package com.daa.dij;

import java.util.ArrayList;

public class Graph {
	
	private Node[] nodes;
	private int noOfNodes;
	private Edge[] edges;
	private int noOfEdges;
	
	private int start;//added
	private int destination;//added
	
	public Graph(Edge[] edges){
		this.edges=edges;
		
		
		this.noOfNodes=calculateNoOfNodes(edges);
		this.nodes= new Node[(int) this.noOfNodes];
		
		for(int n=0; n<this.noOfNodes; n++){
			this.nodes[n]=new Node();
		}
		
		
		this.noOfEdges=edges.length;
		
		for(int edgeToAdd=0; edgeToAdd<this.noOfEdges; edgeToAdd++){
			this.nodes[(int) edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
			this.nodes[(int) edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
		}
		
	}
	
	
	private int calculateNoOfNodes(Edge[] edges) {
		
		int noOfNodes=0;
		
		for(Edge e: edges){
			if(e.getToNodeIndex()>noOfNodes)
				noOfNodes=e.getToNodeIndex();
			if(e.getFromNodeIndex()>noOfNodes)
				noOfNodes=e.getFromNodeIndex();
		}
		noOfNodes++;
		
		return noOfNodes;
	}

 public void calculateShortestDistance(int start, int destination){
	 this.nodes[start].setDistanceFromSource(0);//added to point the starting node
	 //this.nodes[0].setDistanceFromSource(0);
	 this.start = start;//added
	 this.destination = destination;//added
	 int nextNode=0;
	 
	 
	 for(int i=0;i<this.nodes.length;i++){
		 ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
		 
		 
		 for(int joinedEdge=0 ; joinedEdge < currentNodeEdges.size() ; joinedEdge++){
			 int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
			 
			 if(!this.nodes[neighbourIndex].isVisited()){
				//not needed now working good  System.out.println(this.nodes[nextNode].getDistanceFromSource());//test
				//not needed now working good  System.out.println(currentNodeEdges.get(joinedEdge).getLength());//test
				 float tentative= this.nodes[nextNode].getDistanceFromSource()+currentNodeEdges.get(joinedEdge).getLength();
				 //System.out.println(currentNodeEdges.get(joinedEdge).getLength() + "_");//testing
				 
				 if(tentative< nodes[neighbourIndex].getDistanceFromSource()){
					//not neede now working good  System.out.println(tentative);//test print
					 nodes[neighbourIndex].setDistanceFromSource(tentative);	 
				 }
				// System.out.println("->"+tentative);
				
			 }
			 
		 }
		  	nodes[(int) nextNode].setVisited(true);
		  	
		  	
		  	nextNode=getNodeShortestDistanced();
	 }
	 
 }
 
 private int getNodeShortestDistanced(){
	 int storedNodeIndex = 0;
	 float storedDist=Integer.MAX_VALUE;
	 
	 for(int i=0;i<this.nodes.length;i++){
		 float currentDist = this.nodes[i].getDistanceFromSource();
		 
		 if(!this.nodes[i].isVisited()&& currentDist<storedDist){
			 storedDist = currentDist;
			 storedNodeIndex=i;
			 
		 }
	 }
	 return storedNodeIndex;
 }
 
 	public void printResult(String criteria){//added
 		String output= "Number of nodes = "+ (this.noOfNodes -1);// this program counting from node 0 so -1 added.
 		output += "\n Number of Edges = "+ this.noOfEdges;
 		
 		//for(int i=0; i<this.nodes.length;i++){//dont need shortest distance from all nodes.
 			output += ("\n" + criteria +"shortest distance from node" + start + "to node "+ destination + " is " +nodes[destination].getDistanceFromSource());
 		//}
 		System.out.println(output);
 	}
 
	public Node[] getNodes() {
		return nodes;
	}
	public int getNoOfNodes() {
		return noOfNodes;
	}
	public Edge[] getEdges() {
		return edges;
	}
	public int getNoOfEdges() {
		return noOfEdges;
	}
	

}
