package com.daa.dij;

public class Main {
	
	public static float[] intermediate_inputs = new float[3];//intermediate buffers
	public static void main(String[] args){
		int start = 1;
		int destination =12;
		Edge[] edges={
				new Edge(1, 2, 1),
				new Edge(1, 3, 4),
				new Edge(2, 4, 1),
				new Edge(2, 5, 1),
				new Edge(3, 4, 4),
				new Edge(3, 5, 2),
				new Edge(4, 6, 4),
				new Edge(4, 7, 1),
				new Edge(5, 6, 2),
				new Edge(5, 7, 3),
				new Edge(6, 8, 5),
				new Edge(6, 9, 5),
				new Edge(7, 8, 3),
				new Edge(7, 9, 5),
				new Edge(8, 10, 2),
				new Edge(8, 11, 5),
				new Edge(9, 10, 1),
				new Edge(9, 11, 1),
				new Edge(10, 12, 1),
				new Edge(11, 12, 5),
		};
		
		//mycode
		 float[][] input_edges={
				 				{1,2,5,(float) 25.000000,(float) 1.000000},
				 				{1,3,3,(float) 0.043478,(float) 10.000000},
				 				{2,4,5,(float) 30.000000,(float) 1.000000},
				 				{2,5,5,(float) 29.000000,(float) 1.000000},
				 				{3,4,2,(float) 13.000000,(float) 29.000000},
				 				{3,5,3,(float) 0.045455,(float) 5.000000},
				 				{4,6,2,(float) 14.000000,(float) 28.000000},
				 				{4,7,2,(float) 19.000000,(float) 37.000000},
				 				{5,6,3,(float) 0.050000,(float) 10.000000},
				 				{5,7,5,(float) 26.000000,(float) 1.000000},
				 				{6,8,3,(float) 0.045455,(float) 9.000000},
				 				{6,9,4,(float) 0.166667,(float) 16.000000},
				 				{7,8,3,(float) 0.050000,(float) 5.000000},
				 				{7,9,3,(float) 0.041667,(float) 9.000000},
				 				{8,10,2,(float) 23.000000,(float) 35.000000},
				 				{8,11,3,(float) 0.047619,(float) 8.000000},
				 				{9,10,2,(float) 19.000000,(float) 37.000000},
				 				{9,11,1,(float) 26.000000,(float) 37.000000},
				 				{10,12,4,(float) 0.166667,(float) 16.000000},
				 				{11,12,1,(float) 29.000000,(float) 16.000000}
		 						};
		 
		 float[][] input_intermediate= new float[input_edges.length][5];//from to u variance and c_square
		 
		 for(int i=0; i<input_edges.length;i++){
			 if(input_edges[i][2] == 1){
				 Determenstic_input(input_edges[i][3], input_edges[i][4] );
				 input_intermediate[i][0] = input_edges[i][0];
				 input_intermediate[i][1] = input_edges[i][1];
				 input_intermediate[i][2] = intermediate_inputs[0];
				 input_intermediate[i][3] = intermediate_inputs[1];
				 input_intermediate[i][4] = intermediate_inputs[2];
			 }
			 else if(input_edges[i][2] == 2){
				 uniform_input(input_edges[i][3], input_edges[i][4] );
				 input_intermediate[i][0] = input_edges[i][0];
				 input_intermediate[i][1] = input_edges[i][1];
				 input_intermediate[i][2] = intermediate_inputs[0];
				 input_intermediate[i][3] = intermediate_inputs[1];
				 input_intermediate[i][4] = intermediate_inputs[2];
			 }
			 else if(input_edges[i][2] == 3){
				 exponential_input(input_edges[i][3], input_edges[i][4] );
				 input_intermediate[i][0] = input_edges[i][0];
				 input_intermediate[i][1] = input_edges[i][1];
				 input_intermediate[i][2] = intermediate_inputs[0];
				 input_intermediate[i][3] = intermediate_inputs[1];
				 input_intermediate[i][4] = intermediate_inputs[2];
			 }
			 else if(input_edges[i][2] == 4){
				 shifted_Exponential_input(input_edges[i][3], input_edges[i][4] );
				 input_intermediate[i][0] = input_edges[i][0];
				 input_intermediate[i][1] = input_edges[i][1];
				 input_intermediate[i][2] = intermediate_inputs[0];
				 input_intermediate[i][3] = intermediate_inputs[1];
				 input_intermediate[i][4] = intermediate_inputs[2];
			 }
			 else if(input_edges[i][2] == 5){
				 normal_input(input_edges[i][3], input_edges[i][4] );
				 input_intermediate[i][0] = input_edges[i][0];
				 input_intermediate[i][1] = input_edges[i][1];
				 input_intermediate[i][2] = intermediate_inputs[0];
				 input_intermediate[i][3] = intermediate_inputs[1];
				 input_intermediate[i][4] = intermediate_inputs[2];
			 }
			 else if(input_edges[i][2] == 6){
				 general_input(input_edges[i][3], input_edges[i][4] );
				 input_intermediate[i][0] = input_edges[i][0];
				 input_intermediate[i][1] = input_edges[i][1];
				 input_intermediate[i][2] = intermediate_inputs[0];
				 input_intermediate[i][3] = intermediate_inputs[1];
				 input_intermediate[i][4] = intermediate_inputs[2];
			 }
			 else{
				 System.out.println("wrong input format. check your input format");
			 }
			// for(int j=0; j<input_edges[i].length;j++){//traversing through each value in edge
			// System.out.print(input_edges[i][j]+"_");//testing 
			// }
			// System.out.println( );
		 }
		 
		// for (int i = 0; i < input_intermediate.length; i++){
		//	 for(int j = 0; j < input_intermediate[i].length; j++){
		//		 
		//		 System.out.print(input_intermediate[i][j]+"_");//testing
		//	 }
		//	 System.out.println(' ');
		// }
		 
		                      
		//mycode
		 
		// till now creating u , sigma and c_square was done. now send all intermediate results to each criteria and create the final inputs for dijiksha algorithm
		//mean value criteria
		 Edge meanvalue_edges[] = new Edge [input_intermediate.length];//input edges array for mean value criteria
		 for(int i=0; i < input_intermediate.length ; i++){
			 meanvalue_edges[i] = new Edge((int)input_intermediate[i][0], (int)input_intermediate[i][1],meanvalue_weight(input_intermediate[i][2]) );
			 //meanvalue_edges[i].print_edge();//testing 
		 }
		 Graph mean_g = new Graph(meanvalue_edges);
		 mean_g.calculateShortestDistance(start, destination);
		 mean_g.printResult("mean_value criteria ");
		//mean value criteria 
		 
		//optimist value criteria
		 Edge optimistic_value_edges[] = new Edge [input_intermediate.length];//input edges array for mean value criteria
		 for(int i=0; i < input_intermediate.length ; i++){
			 optimistic_value_edges[i] = new Edge((int)input_intermediate[i][0], (int)input_intermediate[i][1],optimist_weight(input_intermediate[i][2], input_intermediate[i][3]) );
			// optimistic_value_edges[i].print_edge();//testing 
		 }
		 Graph optimistic_g = new Graph(optimistic_value_edges);
		 optimistic_g.calculateShortestDistance(start, destination);
		optimistic_g.printResult("Optimist_value criteria ");
		//optimist value criteria 
		 
		//pessimist value criteria
		 Edge pessimist_value_edges[] = new Edge [input_intermediate.length];//input edges array for mean value criteria
		 for(int i=0; i < input_intermediate.length ; i++){
			 pessimist_value_edges[i] = new Edge((int)input_intermediate[i][0], (int)input_intermediate[i][1],pessimist_weight(input_intermediate[i][2], input_intermediate[i][3]) );
			// pessimist_value_edges[i].print_edge();//testing 
		 }
		 Graph pessimist_g = new Graph(pessimist_value_edges);
		 pessimist_g.calculateShortestDistance(start, destination);
		 pessimist_g.printResult("Pessimistic_value criteria ");
		//pessimist value criteria 
		 
		//double pessimist value criteria
		 Edge double_pessimist_value_edges[] = new Edge [input_intermediate.length];//input edges array for mean value criteria
		 for(int i=0; i < input_intermediate.length ; i++){
			 double_pessimist_value_edges[i] = new Edge((int)input_intermediate[i][0], (int)input_intermediate[i][1],double_pessimist_weight(input_intermediate[i][2], input_intermediate[i][3]) );
			// double_pessimist_value_edges[i].print_edge();//testing 
		 }
		 Graph double_pessimist_g = new Graph(double_pessimist_value_edges);
		 double_pessimist_g.calculateShortestDistance(start, destination);
		 double_pessimist_g.printResult("Double Pessimist_value criteria ");
		//double pessimist value criteria 
		 
		//stable value criteria
		 Edge stable_value_edges[] = new Edge [input_intermediate.length];//input edges array for mean value criteria
		 for(int i=0; i < input_intermediate.length ; i++){
			 stable_value_edges[i] = new Edge((int)input_intermediate[i][0], (int)input_intermediate[i][1],stable_weight(input_intermediate[i][4]) );
			 stable_value_edges[i].print_edge();//testing 
		 }
		 Graph stable_value_g = new Graph(stable_value_edges);
		 stable_value_g.calculateShortestDistance(start, destination);
		 stable_value_g.printResult("stable_value criteria ");
		//stable value criteria 
		 
		//maincode
		Graph g = new Graph(edges);
		g.calculateShortestDistance(start, destination);
		
		g.printResult("regular ");//testing
		//main code

	}
	
	public static void Determenstic_input(float alpha,float bheta){
		float mean,variance,C_square = 0;
		intermediate_inputs[0] = 0;
		intermediate_inputs[1] = 0;
		intermediate_inputs[2] = 0;
		
		mean = alpha;
		variance = 0;
		C_square = 0;
		
		intermediate_inputs[0] = mean;
		intermediate_inputs[1] = (float) Math.sqrt(variance);
		intermediate_inputs[2] = C_square;
		
		return;
		
	}
	
	public static void uniform_input(float alpha,float bheta){
		float mean,variance,C_square = 0;
		intermediate_inputs[0] = 0;
		intermediate_inputs[1] = 0;
		intermediate_inputs[2] = 0;
		
		mean = (alpha + bheta) / 2;
		variance = ((bheta-alpha)*(bheta-alpha)) / 12;
		C_square = (((bheta - alpha)/(bheta - alpha)) * ((bheta - alpha)/(bheta - alpha))) /2;
		
		intermediate_inputs[0] = mean;
		intermediate_inputs[1] = (float) Math.sqrt(variance);;
		intermediate_inputs[2] = C_square;
		
		return;
	}
	
	public static void exponential_input(float alpha,float bheta){
		float mean,variance,C_square = 0;
		intermediate_inputs[0] = 0;
		intermediate_inputs[1] = 0;
		intermediate_inputs[2] = 0;
		
		mean = 1 /alpha;
		variance = 1 / (alpha * alpha);
		C_square = 1;
		
		intermediate_inputs[0] = mean;
		intermediate_inputs[1] = (float) Math.sqrt(variance);;
		intermediate_inputs[2] = C_square;
		
		return;
	}
	
	public static void shifted_Exponential_input(float alpha,float bheta){
		float mean,variance,C_square = 0;
		intermediate_inputs[0] = 0;
		intermediate_inputs[1] = 0;
		intermediate_inputs[2] = 0;
		
		mean = bheta + (1 / alpha);
		variance = 1 / (alpha * alpha);
		C_square = 1/ ((1 + bheta * alpha) * (1 + bheta * alpha));
		
		intermediate_inputs[0] = mean;
		intermediate_inputs[1] = (float) Math.sqrt(variance);;
		intermediate_inputs[2] = C_square;
		
		return;
	}
	
	public static void normal_input(float alpha,float bheta){
		float mean,variance,C_square = 0;
		intermediate_inputs[0] = 0;
		intermediate_inputs[1] = 0;
		intermediate_inputs[2] = 0;
		
		mean = alpha;
		variance = bheta;
		C_square = bheta / (alpha * alpha);
		
		intermediate_inputs[0] = mean;
		intermediate_inputs[1] = (float) Math.sqrt(variance);;
		intermediate_inputs[2] = C_square;
		
		return;
	}
	
	public static void general_input(float alpha,float bheta){
		float mean,variance,C_square = 0;
		intermediate_inputs[0] = 0;
		intermediate_inputs[1] = 0;
		intermediate_inputs[2] = 0;
		
		mean = alpha;
		variance = alpha * alpha * bheta;
		C_square = bheta ;
		
		intermediate_inputs[0] = mean;
		intermediate_inputs[1] = (float) Math.sqrt(variance);;
		intermediate_inputs[2] = C_square;
		
		return;
	}
	
	public static float meanvalue_weight(float mean){
		return mean;
	}
	
	public static float optimist_weight(float mean, float standard_deviation){
		float edge_weight = mean - standard_deviation;
		if (edge_weight > 0)
			return edge_weight;
		else 
			return mean;
		
	}
	
	public static float pessimist_weight(float mean, float standard_deviation){
		
		return mean + standard_deviation;
		
	}
	
	public static float double_pessimist_weight(float mean, float standard_deviation){
		
		return (mean + (2 * standard_deviation));
		
	}
	
	public static float stable_weight(float C_square){
		
		return C_square;
		
	}
}
