package com.daa.dij;

import java.util.ArrayList;

public class Node {
	private float distanceFromSource=Integer.MAX_VALUE;
	
	private boolean visited;
	
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public float getDistanceFromSource(){
		//System.out.println(distanceFromSource + "_");//testing
		return distanceFromSource;
	}
	
	public void setDistanceFromSource(float distanceFromSource){
		this.distanceFromSource= distanceFromSource;
	}
	
	public boolean isVisited(){
		return visited;
	}
	public void setVisited(boolean visited){
		this.visited=visited;
	}
	
//	public ArrayList<Edge> getEdges(){
//		return edges;
//	}
	public ArrayList<Edge> getEdges() {
		
		return edges;
	}
	
	public void setEdges(ArrayList<Edge> edges){
		this.edges=edges;
	}

	
}
