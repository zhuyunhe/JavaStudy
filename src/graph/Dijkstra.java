package graph;

import java.util.ArrayList;

class Edge{
	Vertex dest;  //目标顶点
	int weight;
	
	public Edge(Vertex v,int w){
		dest = v;
		weight = w;
	}
}

class DVertex{
	public static int INF  = Integer.MAX_VALUE /100 ;
	
	//顶点的值
	int val;
	
	//顶点的索引
	int index;
	
	//入度
	int indegree;
	
	//标记
	boolean know = false;
	
	int dist = INF;
	
	Vertex path;
	
	//邻接表
	ArrayList<Edge> adjList;
	
	//构造函数
	public DVertex(int value){
		this.val = value;
	}
	
	//为节点添加邻接点
	public void addAdj(Edge edge){
		//如果该节点的邻接表为null，则初始化一个
		if(adjList == null){
			adjList = new ArrayList<Edge>();
		}
		
		adjList.add(edge);
	}
	
	//得到该节点的邻接表
	public ArrayList<Edge> getAdj(){
		return this.adjList;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndegree() {
		return indegree;
	}

	public void setIndegree(int indegree) {
		this.indegree = indegree;
	}
	
}
public class Dijkstra {
	
}
