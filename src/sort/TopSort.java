package sort;

import java.util.ArrayList;
import java.util.Iterator;

class Edge{
	Vertex dest;  //Ŀ�궥��
	int weight;
	
	public Edge(Vertex v,int w){
		dest = v;
		weight = w;
	}
}

class Vertex{
	public static int INF  = Integer.MAX_VALUE /100 ;
	
	//�����ֵ
	int val;
	
	//���������
	int index;
	
	//���
	int indegree;
	
	//���
	boolean know = false;
	
	int dist = INF;
	
	Vertex path;
	
	//�ڽӱ�
	ArrayList<Vertex> adjList;
	
	//���캯��
	public Vertex(int value){
		this.val = value;
	}
	
	//Ϊ�ڵ�����ڽӵ�
	public void addAdj(Vertex ver){
		//����ýڵ���ڽӱ�Ϊnull�����ʼ��һ��
		if(adjList == null){
			adjList = new ArrayList<Vertex>();
		}
		
		adjList.add(ver);
	}
	
	//�õ��ýڵ���ڽӱ�
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
	//Ĭ�ϵ�ͼ�еĶ�����
	private final int MAX_VERTS = 10;
	
	//����ͼ�ж��������
	private Vertex[] vertexList;
	
	//��¼ͼ�нڵ�ĸ���
	private int nVerts = 0;
	
	//���캯��
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
	}
	
	public Graph(int n){
		vertexList = new Vertex[n];
	}
	
	//����ͼ�ж�������
	public Vertex[] getVertexList(){
		return this.vertexList;
	}
	
	//��Ӷ���
	public void addVertex(Vertex vertex){
		vertex.setIndex(this.nVerts);
		
		vertexList[this.nVerts] = vertex;
		
		this.nVerts++;
	}
	
	/**
	 * ��ӱ�
	 * @param start ��ʼ���������
	 * @param end �������������
	 */
	public void addEdge(int start, int end){
		//���ǰѵ�end���ڵ���Ϊ��start���ڵ��һ���ڽӵ�
		this.vertexList[start].addAdj(this.vertexList[end]);
		
		//end��������+1
		this.vertexList[end].indegree++;
	}
	
	//���ؽڵ����
	public int getVertsCount(){
		return vertexList.length;
	}
}
public class TopSort {
	
	//���·���㷨
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
