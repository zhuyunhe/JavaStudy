package graph;


public class Prim {
	private static final int MAX = Integer.MAX_VALUE;
	
	private int graph[][]={	{0,1,2,4},  
							{1,0,3,5},  
							{2,3,0,6},  
							{4,5,6,0}  
	};
	
	//图中各顶点的字符
	private char[] c = {'A','B','C','d'};
	
	public static void main(String[] args){
		Prim p = new Prim();
		int sumWeight = p.prim(0);
		System.out.println(sumWeight);
	}
	
	/**
	 * 返回最小生成树的总权值
	 * @param start
	 * @return
	 */
	public int prim(int start){
		int num = c.length;  //顶点个数
		int index = 0;  //prim最小树的索引
		char[] prims = new char[num];  //prim最小树的结果数组
		int[] weights = new int[num];  //顶点间边的权值
		
		int sum = 0;;
		
		//prim生成树的第一个顶点就是第start顶点
		prims[index++] = c[start];
		
		//初始化顶点权值数组
		//每个顶点的权值为第start个顶点到该顶点的权值
		for(int i=0; i<num; i++){
			weights[i] = graph[start][i];
		}
		
		//第start个顶点到其自身的距离为0
		weights[start] = 0;
		
		for(int i=0; i<num; i++){
			// 由于从start开始的，因此不需要再对第start个顶点进行处理。
	        if(start == i){
	        	continue;
	        }
	        
	        
			int j = 0;
			int minId = 0;
			int min = MAX;
			
			//在未被加入到最小生成树的顶点中，找到权值最小的顶点
			for(j=0;j<num;j++){
				//若weight[j]=0,说明第j个节点已经加入最小生成树中
				if(weights[j]!=0 && weights[j]<min){
					min = weights[j];
					minId = j;
				}
			}
			
			//计算最小生成树的权值
			sum += min;
			
			// 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第minId个顶点。
	        // 将第minId个顶点加入到最小生成树的结果数组中
			prims[index++] = c[minId];
			
			weights[minId] = 0;
			
			// 当第minId个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
	        for (j = 0 ; j < num; j++) {
	            // 当第j个节点没有被处理，并且需要更新时才被更新。
	            if (weights[j] != 0 && graph[minId][j] < weights[j])
	                weights[j] = graph[minId][j];
	        }
		}
		
		return sum;
		
	}
	
	
}
