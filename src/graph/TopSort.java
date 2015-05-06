package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex{
	public int topNum = 0;
	
	//�ڽӱ�
	public List<Vertex> adj = new LinkedList<Vertex>();
	
	public int indegree;
}

public class TopSort {
	
	/**
	 * ��������
	 * �������һ����vi��vj��·������ô��������vj�ͳ�����vi����
	 * @param vs
	 */
	public void topsort(List<Vertex> vs){
		Queue<Vertex> q = new LinkedList<Vertex>();
		int counter = 0;
		
		for(Vertex v : vs){
			//�Ȱ����Ϊ0�Ķ������list��
			if(v.indegree == 0){
				q.add(v);
			}
		}
		
		while(!q.isEmpty()){
			//����
			Vertex v = q.poll();
			
			v.topNum = ++counter;
			
			for(Vertex w : v.adj){
				if(--w.indegree == 0){
					//���
					q.add(w);
				}
			}
			
		}
		
		if(counter != vs.size()){
			System.out.println("ͼ����������Ȧ��");
		}
	
	}
	
	public static void main(String[] args){
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		Vertex v3 = new Vertex();
		
		v1.adj.add(v2);
		v2.indegree++;
		
		v2.adj.add(v3);
		v3.indegree++;
		
		List<Vertex> vs = new LinkedList<Vertex>();
		vs.add(v1);
		vs.add(v2);
		vs.add(v3);
		
		TopSort ts = new TopSort();
		ts.topsort(vs);
	}
	
	
	
}
