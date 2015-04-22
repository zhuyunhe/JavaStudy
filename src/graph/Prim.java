package graph;


public class Prim {
	private static final int MAX = Integer.MAX_VALUE;
	
	private int graph[][]={	{0,1,2,4},  
							{1,0,3,5},  
							{2,3,0,6},  
							{4,5,6,0}  
	};
	
	//ͼ�и�������ַ�
	private char[] c = {'A','B','C','d'};
	
	public static void main(String[] args){
		Prim p = new Prim();
		int sumWeight = p.prim(0);
		System.out.println(sumWeight);
	}
	
	/**
	 * ������С����������Ȩֵ
	 * @param start
	 * @return
	 */
	public int prim(int start){
		int num = c.length;  //�������
		int index = 0;  //prim��С��������
		char[] prims = new char[num];  //prim��С���Ľ������
		int[] weights = new int[num];  //�����ߵ�Ȩֵ
		
		int sum = 0;;
		
		//prim�������ĵ�һ��������ǵ�start����
		prims[index++] = c[start];
		
		//��ʼ������Ȩֵ����
		//ÿ�������ȨֵΪ��start�����㵽�ö����Ȩֵ
		for(int i=0; i<num; i++){
			weights[i] = graph[start][i];
		}
		
		//��start�����㵽������ľ���Ϊ0
		weights[start] = 0;
		
		for(int i=0; i<num; i++){
			// ���ڴ�start��ʼ�ģ���˲���Ҫ�ٶԵ�start��������д���
	        if(start == i){
	        	continue;
	        }
	        
	        
			int j = 0;
			int minId = 0;
			int min = MAX;
			
			//��δ�����뵽��С�������Ķ����У��ҵ�Ȩֵ��С�Ķ���
			for(j=0;j<num;j++){
				//��weight[j]=0,˵����j���ڵ��Ѿ�������С��������
				if(weights[j]!=0 && weights[j]<min){
					min = weights[j];
					minId = j;
				}
			}
			
			//������С��������Ȩֵ
			sum += min;
			
			// ��������Ĵ������δ�����뵽��С�������Ķ����У�Ȩֵ��С�Ķ����ǵ�minId�����㡣
	        // ����minId��������뵽��С�������Ľ��������
			prims[index++] = c[minId];
			
			weights[minId] = 0;
			
			// ����minId�����㱻���뵽��С�������Ľ��������֮�󣬸������������Ȩֵ��
	        for (j = 0 ; j < num; j++) {
	            // ����j���ڵ�û�б�����������Ҫ����ʱ�ű����¡�
	            if (weights[j] != 0 && graph[minId][j] < weights[j])
	                weights[j] = graph[minId][j];
	        }
		}
		
		return sum;
		
	}
	
	
}
