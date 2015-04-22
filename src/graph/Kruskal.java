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
	 * ����ͼ�����бߵ����ȶ���
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
		double[][] tree = new double[rows][cols];	//����Ҫ���ص���С������
		
		//��ʼ��tree
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
		 * map���ڴ洢ĳ������������ڵļ��ϡ���ʼʱ��ÿ�����㶼�����Լ��ļ����У�
		 * ��ѡ����һ����ʱ����������ߵ��������㲻��ͬһ�����У���������߼������У�
		 * ����ͷ��������ߣ����⻷·���֡�
		 */
		Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
		int edgesAccepted = 0;
		//n������ֻ��Ҫn-1���߾���
		while(edgesAccepted < rows-1){
			//����ȡ��Ȩֵ��С�ı�
			Edge e = edgeList.poll();
			
			//�õ��������Ķ������ڵļ���
			Set<Integer> setU = map.get(e.u);
			Set<Integer> setV = map.get(e.v);
			
			//����������㶼�������κμ�����
			if(setU==null && setV==null){
				Set<Integer> set = new HashSet<Integer>();
				set.add(e.u);
				set.add(e.v);
				
				//����map������¼
				map.put(e.u, set);
				map.put(e.v, set);
			}//���һ��������ĳ�������У���һ���������κμ����� ,�Ѳ��ڼ������Ǹ��ڵ�ϲ���ȥ
			else if(setU==null && setV!=null){
				setV.add(e.u);
				map.put(e.u, setV);
			}
			else if(setU!=null && setV==null){
				setU.add(e.v);
				map.put(e.v, setU);
			}//����ֱ��ڲ�ͬ�ļ����У��Ǿͺϲ�����������
			else if(setU!=setV){
				setU.addAll(setV);
				for(int v:setV){
					map.put(v, setU);
				}
			}//�������������ͬһ�����У�����
			else{
				continue;
			}
			
			edgesAccepted++;
			//�γ���С������
			tree[e.u][e.v] = e.weight; 
			tree[e.v][e.u] = e.weight; 
			
		}
		
		return tree;
	}
}

class Edge implements Comparable<Edge>{

	int u;	//���
	int v;	//�յ�
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