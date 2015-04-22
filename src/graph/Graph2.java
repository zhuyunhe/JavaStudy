package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
	//�ڽ�����ı���
	class ArcNode{
		int adjvex;		//������vi�ڽӵĶ�������,����һ���ߵ�β�ͽ������
		int weight;		//���ϵ�Ȩֵ
		ArcNode next;	//�ڽ������е���һ���ڽӶ���
		
		public ArcNode(int to,int _weight){
			this.adjvex = to;
			this.weight = _weight;
		}
	}
	
	//�ڽ������ͷ���
	class vNode{
		char data;			//�����ʾ�����ݣ���һ���ַ���ʾ
		ArcNode firstNode;	//ָ���һ�������ö���ıߵ���һ�����
		
		public vNode(char c){
			this.data = c;
		}
	}
	
public class Graph2 {
	
	
	private int vNum;		//ͼ�ж������Ŀ
	List<vNode> vertices;	//ͼ�еĶ��㼯��
	int[] visited;
	
	//���캯��
	public Graph2(int num,List<vNode> list){
		this.vNum = num;
		this.vertices = list;
		this.visited = new int[vNum];
	}
	
	//����һ����־λ���飬�����±�Ϊ������ţ�ֵΪ0ʱ����δ�����ʣ�ֵΪ1ʱ�����ѱ�����
	
	/**
	 * ����������أ������Ϊi�Ľ�㿪ʼ
	 * �ݹ��˼��
	 * �����������ȸ�����
	 * @param i
	 */
	public void DFS(int i){
		ArcNode arcNode;
		int j;
		System.out.println(vertices.get(i).data);	//���ʵ�i�����
		visited[i] = 1;			//���Ϊi�Ľ����ʱ�־��Ϊ1
		
		//ȡ����i�ĵ�һ���ڽӽ��
		arcNode = vertices.get(i).firstNode;	
		
		while(arcNode != null){
			j = arcNode.adjvex;		//�õ����ڽӵ�����
			
			//������Ϊj�Ķ����δ�����ʹ�
			if(visited[j] == 0){
				DFS(j);				//�ݹ���ã���j�������������������������
			}
			
			arcNode = arcNode.next;
		}
		
	}
	
	/**
	 * ������ȱ���
	 * Ҫ����һ�������������ѷ��ʹ��Ľ��
	 * @param graph
	 */
	public void BFS(Graph2 graph){
		ArcNode arcNode;
		int j;
		
		//��ʱ�������ڱ����ѷ��ʹ��Ľ��
		LinkedList<vNode> tempList = new LinkedList<vNode>();
		
		for(int i=0; i<graph.vNum; i++){
			
			//������Ϊi�Ķ���û�б����ʹ�
			if(visited[i]==0){
				vNode temp = graph.vertices.get(i);	//��ͼ�Ľ�������ȡ���ý��
				System.out.println(temp.data);
				visited[i] = 1;							//�Ѹý����Ϊ�ѷ���
				tempList.push(temp);
				while(!tempList.isEmpty()){
					
					//����ͷ�����ԣ�Ȼ����ʷ��������������δ�����ʵ��ڽӵ�
					vNode node = tempList.poll();
					arcNode = node.firstNode;
					for(;arcNode!=null;arcNode=arcNode.next){
						j = arcNode.adjvex;
						if(visited[j] == 0){
							//�������Ϊj�Ľ�㣬����������push����ʱ�б���
							System.out.println(graph.vertices.get(j).data);
							visited[j] = 1;		
							tempList.push(graph.vertices.get(j));
						}
					}
				}
			}
		}
	}
	
	
	
	public static void main(String[] args){
		vNode v0 = new vNode('a');
		vNode v1 = new vNode('b');
		vNode v2 = new vNode('c');
		vNode v3 = new vNode('d');
		
		//0��1֮����һ����
		ArcNode a01 = new ArcNode(1,1);
		
		//0��2֮����һ����
		ArcNode a02 = new ArcNode(2,2);
		
		//����v0�����ڽ�����
		a01.next = a02;
		
		//1��3֮����һ����
		ArcNode a13 = new ArcNode(3,3);
		
		//��v0���ĵ�һ����a01
		v0.firstNode = a01;
		
		//��v1���ĵ�һ����a13
		v1.firstNode = a13;

		//�Ѹ����0��n��˳����뵽һ��������
		List<vNode> list = new ArrayList<vNode>();
		list.add(v0);
		list.add(v1);
		list.add(v2);
		list.add(v3);
		
		//�γ�һ��ͼ
		Graph2 graph = new Graph2(4,list);
		
		//�����������ͼ
		graph.DFS(0);
		
		//�����������ͼ
		graph.BFS(graph);
	}
}
