package graph;

import java.util.*;

class VNode{
  int from;//边的起点
  Edge_1 first;//以from为起点的第一条边
  public VNode(int from){
	  this.from=from;
	  first=null;
  }
}
class Edge_1{
   int to;//边的终点  
   Edge_1 next;//具有同一起点的下一条边
   public Edge_1(int to){
	   this.to=to;
	   next=null;
   }
}

public class Graph{
   int k;//图的顶点数
   VNode[] V;//顶点数组
   boolean[] visted;//记录某个顶点是否遍历过
   public Graph(int k,VNode[] v){
      this.k=k;
      this.V=v;
      visted = new boolean[k];
   }
   //从v0顶点出发广度优先遍历图
   private void BFS(int v0){
     Queue<Integer> que=new LinkedList<Integer>();
     que.add(v0);
     while(!que.isEmpty()){
       v0=que.poll();
       if(!visted[v0]){
          System.out.print(v0+"  ");
          visted[v0]=true;
       }
      Edge_1 e=V[v0].first;
      while(e!=null){
          if(!visted[e.to]) que.add(e.to);
          e=e.next;
      }
     }
  }
  //邻接表深度优先搜索图
   private void DFS(int v0){
     visted[v0]=true;
     //访问顶点v0
     System.out.print(v0+"  ");
   
     Edge_1 p=V[v0].first;
     while(p!=null){
       if(!visted[p.to]){
          DFS(p.to);
       }
       p=p.next;
    }
  }
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int k=sc.nextInt();//图的顶点数
	int m=sc.nextInt();//图的边数
	VNode[] V=new VNode[k];
	for(int i=0;i<k;i++){
		V[i]=new VNode(i);
	}
	Edge_1 e=null;
	Edge_1 e1=null;
	int u=0;int v=0;
	for(int i=0;i<m;i++){
		u=sc.nextInt();//起点
		v=sc.nextInt();//终点
		
		e=new Edge_1(v);
		e.next=V[u].first;//插入到链表开头
		V[u].first=e;
		
		//对于无向图作对称处理
		e1=new Edge_1(u);
		e1.next=V[v].first;
		V[v].first=e1;
	}
	Graph gra=new Graph(k,V);
	// gra.BFS(0);
	gra.DFS(0);
}
}     
