package sort;

import java.util.ArrayList;
import java.util.Iterator;

class Edge{
	Vertex dest;  //目标顶点
	int weight;
	
	public Edge(Vertex v,int w){
		dest = v;
		weight = w;
	}
}

class Vertex{
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
	ArrayList<Vertex> adjList;
	
	//构造函数
	public Vertex(int value){
		this.val = value;
	}
	
	//为节点添加邻接点
	public void addAdj(Vertex ver){
		//如果该节点的邻接表为null，则初始化一个
		if(adjList == null){
			adjList = new ArrayList<Vertex>();
		}
		
		adjList.add(ver);
	}
	
	//得到该节点的邻接表
	public ArrayList<Vertex> getAdj(){
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

class AdjVertex{
	
}

class Graph{
	//默认的图中的顶点数
	private final int MAX_VERTS = 10;
	
	//保存图中顶点的数组
	private Vertex[] vertexList;
	
	//记录图中节点的个数
	private int nVerts = 0;
	
	//构造函数
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
	}
	
	public Graph(int n){
		vertexList = new Vertex[n];
	}
	
	//返回图中顶点数组
	public Vertex[] getVertexList(){
		return this.vertexList;
	}
	
	//添加顶点
	public void addVertex(Vertex vertex){
		vertex.setIndex(this.nVerts);
		
		vertexList[this.nVerts] = vertex;
		
		this.nVerts++;
	}
	
	/**
	 * 添加边
	 * @param start 开始顶点的索引
	 * @param end 结束顶点的索引
	 */
	public void addEdge(int start, int end){
		//就是把第end个节点作为第start个节点的一个邻接点
		this.vertexList[start].addAdj(this.vertexList[end]);
		
		//end顶点的入度+1
		this.vertexList[end].indegree++;
	}
	
	//返回节点个数
	public int getVertsCount(){
		return vertexList.length;
	}
}
public class TopSort {
	
	//最短路径算法
	public void dijkstra(Vertex s,Graph graph){
		s.dist = 0;
		
		while(true){
			Vertex v= s;
			
			if(v == null){
				break;
			}
			
			v.know = true;
			
			Iterator<Vertex> ite = v.adjList.iterator();
			while(ite.hasNext()){
				Vertex w = ite.next();
				
			}
			
		}
	}
	
}
