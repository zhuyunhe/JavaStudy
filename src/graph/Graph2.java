package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
	//邻接链表的表结点
	class ArcNode{
		int adjvex;		//就是与vi邻接的顶点的序号,就是一条边的尾巴结点的序号
		int weight;		//边上的权值
		ArcNode next;	//邻接链表中的下一个邻接顶点
		
		public ArcNode(int to,int _weight){
			this.adjvex = to;
			this.weight = _weight;
		}
	}
	
	//邻接链表的头结点
	class vNode{
		char data;			//顶点表示的数据，以一个字符表示
		ArcNode firstNode;	//指向第一条依附该顶点的边的另一个结点
		
		public vNode(char c){
			this.data = c;
		}
	}
	
public class Graph2 {
	
	
	private int vNum;		//图中顶点的数目
	List<vNode> vertices;	//图中的顶点集合
	int[] visited;
	
	//构造函数
	public Graph2(int num,List<vNode> list){
		this.vNum = num;
		this.vertices = list;
		this.visited = new int[vNum];
	}
	
	//建立一个标志位数组，数组下标为结点的序号，值为0时代表未被访问，值为1时代表已被访问
	
	/**
	 * 深度优先搜素，从序号为i的结点开始
	 * 递归的思想
	 * 类似于树的先根遍历
	 * @param i
	 */
	public void DFS(int i){
		ArcNode arcNode;
		int j;
		System.out.println(vertices.get(i).data);	//访问第i个结点
		visited[i] = 1;			//序号为i的结点访问标志置为1
		
		//取顶点i的第一个邻接结点
		arcNode = vertices.get(i).firstNode;	
		
		while(arcNode != null){
			j = arcNode.adjvex;		//拿到该邻接点的序号
			
			//如果序号为j的顶点从未被访问过
			if(visited[j] == 0){
				DFS(j);				//递归调用，从j结点出发继续进行深度优先搜素
			}
			
			arcNode = arcNode.next;
		}
		
	}
	
	/**
	 * 广度优先遍历
	 * 要引入一个队列来保存已访问过的结点
	 * @param graph
	 */
	public void BFS(Graph2 graph){
		ArcNode arcNode;
		int j;
		
		//临时队列用于保存已访问过的结点
		LinkedList<vNode> tempList = new LinkedList<vNode>();
		
		for(int i=0; i<graph.vNum; i++){
			
			//如果序号为i的顶点没有被访问过
			if(visited[i]==0){
				vNode temp = graph.vertices.get(i);	//从图的结点队列中取出该结点
				System.out.println(temp.data);
				visited[i] = 1;							//把该结点置为已访问
				tempList.push(temp);
				while(!tempList.isEmpty()){
					
					//队列头结点出对，然后访问访问这个结点的所有未被访问的邻接点
					vNode node = tempList.poll();
					arcNode = node.firstNode;
					for(;arcNode!=null;arcNode=arcNode.next){
						j = arcNode.adjvex;
						if(visited[j] == 0){
							//访问序号为j的结点，并把这个结点push到临时中保存
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
		
		//0到1之间有一条边
		ArcNode a01 = new ArcNode(1,1);
		
		//0到2之间有一条边
		ArcNode a02 = new ArcNode(2,2);
		
		//构造v0结点的邻接链表
		a01.next = a02;
		
		//1到3之间有一条边
		ArcNode a13 = new ArcNode(3,3);
		
		//设v0结点的第一条边a01
		v0.firstNode = a01;
		
		//设v1结点的第一条边a13
		v1.firstNode = a13;

		//把个结点0到n的顺序加入到一个链表中
		List<vNode> list = new ArrayList<vNode>();
		list.add(v0);
		list.add(v1);
		list.add(v2);
		list.add(v3);
		
		//形成一个图
		Graph2 graph = new Graph2(4,list);
		
		//深度优先搜素图
		graph.DFS(0);
		
		//深度优先搜素图
		graph.BFS(graph);
	}
}
