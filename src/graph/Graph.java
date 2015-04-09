package graph;

import java.util.*;

class VNode{
  int from;//�ߵ����
  Edge_1 first;//��fromΪ���ĵ�һ����
  public VNode(int from){
	  this.from=from;
	  first=null;
  }
}
class Edge_1{
   int to;//�ߵ��յ�  
   Edge_1 next;//����ͬһ������һ����
   public Edge_1(int to){
	   this.to=to;
	   next=null;
   }
}

public class Graph{
   int k;//ͼ�Ķ�����
   VNode[] V;//��������
   boolean[] visted;//��¼ĳ�������Ƿ������
   public Graph(int k,VNode[] v){
      this.k=k;
      this.V=v;
      visted = new boolean[k];
   }
   //��v0�������������ȱ���ͼ
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
  //�ڽӱ������������ͼ
   private void DFS(int v0){
     visted[v0]=true;
     //���ʶ���v0
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
	int k=sc.nextInt();//ͼ�Ķ�����
	int m=sc.nextInt();//ͼ�ı���
	VNode[] V=new VNode[k];
	for(int i=0;i<k;i++){
		V[i]=new VNode(i);
	}
	Edge_1 e=null;
	Edge_1 e1=null;
	int u=0;int v=0;
	for(int i=0;i<m;i++){
		u=sc.nextInt();//���
		v=sc.nextInt();//�յ�
		
		e=new Edge_1(v);
		e.next=V[u].first;//���뵽����ͷ
		V[u].first=e;
		
		//��������ͼ���Գƴ���
		e1=new Edge_1(u);
		e1.next=V[v].first;
		V[v].first=e1;
	}
	Graph gra=new Graph(k,V);
	// gra.BFS(0);
	gra.DFS(0);
}
}     
