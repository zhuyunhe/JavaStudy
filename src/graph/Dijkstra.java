package graph;

import java.util.ArrayList;

class Edge{
	Vertex dest;  //Ŀ�궥��
	int weight;
	
	public Edge(Vertex v,int w){
		dest = v;
		weight = w;
	}
}

class DVertex{
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
	ArrayList<Edge> adjList;
	
	//���캯��
	public DVertex(int value){
		this.val = value;
	}
	
	//Ϊ�ڵ�����ڽӵ�
	public void addAdj(Edge edge){
		//����ýڵ���ڽӱ�Ϊnull�����ʼ��һ��
		if(adjList == null){
			adjList = new ArrayList<Edge>();
		}
		
		adjList.add(edge);
	}
	
	//�õ��ýڵ���ڽӱ�
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
