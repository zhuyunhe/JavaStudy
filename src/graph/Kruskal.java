package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Kruskal {
	
	public static void main(String[] args){
		double graph[][]={	{0,1,4,4,5},  
			                {1,0,3,7,5},  
			                {4,3,0,6,Double.MAX_VALUE},  
			                {4,7,6,0,2},  
			                {5,5,Double.MAX_VALUE,2,0}
			             };  
		double tree[][]=minSpanningTree(graph);  
		if(tree==null)  
		{  
			System.out.println("no spanning tree");  
			System.exit(0);  
		}  
		PriorityQueue<Edge> edgeList=generateEdgeList(tree);  
		for(Edge e:edgeList)  
		{  
		  System.out.println(e);  
		}  
	}
	
	/**
	 * 生成图的所有边的优先队列
	 * @param graph
	 * @return
	 */
	private static PriorityQueue<Edge> generateEdgeList(double[][] graph){
		PriorityQueue<Edge> edgeList = new PriorityQueue<Edge>();
		int rows = graph.length;
		int cols = graph[0].length;
		
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(graph[i][j]>0 && graph[i][j]<Double.MAX_VALUE){
					edgeList.add(new Edge(i,j,graph[i][j]));
				}
			}
		}
		
		return edgeList;
	}
	
	public static double[][] minSpanningTree(double[][] graph){
		int rows = graph.length;
		int cols = graph[0].length;
		PriorityQueue<Edge> edgeList = generateEdgeList(graph);
		double[][] tree = new double[rows][cols];	//定义要返回的最小生成树
		
		//初始化tree
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++){
				if(i == j){
					tree[i][j] = 0;
				} else{
					tree[i][j] = Double.MAX_VALUE;
				}
			}
		}
		
		/**
		 * map用于存储某个顶点和它所在的集合。初始时，每个顶点都在它自己的集合中，
		 * 当选择了一条边时，如果这条边的两个顶点不在同一集合中，则把这条边加入树中，
		 * 否则就放弃这条边，以免环路出现。
		 */
		Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
		int edgesAccepted = 0;
		//n个顶点只需要n-1条边就行
		while(edgesAccepted < rows-1){
			//连续取出权值最小的边
			Edge e = edgeList.poll();
			
			//得到这两条的顶点所在的集合
			Set<Integer> setU = map.get(e.u);
			Set<Integer> setV = map.get(e.v);
			
			//如果这两个点都还不在任何集合中
			if(setU==null && setV==null){
				Set<Integer> set = new HashSet<Integer>();
				set.add(e.u);
				set.add(e.v);
				
				//放入map中作记录
				map.put(e.u, set);
				map.put(e.v, set);
			}//如果一个顶点在某个集合中，另一个还不在任何集合中 ,把不在集合中那个节点合并进去
			else if(setU==null && setV!=null){
				setV.add(e.u);
				map.put(e.u, setV);
			}
			else if(setU!=null && setV==null){
				setU.add(e.v);
				map.put(e.v, setU);
			}//如果分别在不同的集合中，那就合并这两个集合
			else if(setU!=setV){
				setU.addAll(setV);
				for(int v:setV){
					map.put(v, setU);
				}
			}//如果两个顶点在同一集合中，舍弃
			else{
				continue;
			}
			
			edgesAccepted++;
			//形成最小生成树
			tree[e.u][e.v] = e.weight; 
			tree[e.v][e.u] = e.weight; 
			
		}
		
		return tree;
	}
}

class Edge implements Comparable<Edge>{

	int u;	//起点
	int v;	//终点
	double weight;
	
	public Edge(int u,int v,double weight){
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge e) {
		if(e.weight == this.weight){
			return 0;
		} else if(this.weight < e.weight){
			return -1;
		} else{
			return 1;
		}
	}
	
	public String toString(){
		return u+"--"+v+":"+weight;
	}
	
}