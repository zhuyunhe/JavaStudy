package thread;

class Depot{
	private int capacity;	//�ֿ������
	private int size;		//�ֿ��ʵ������
	
	public Depot(int capacity){
		this.capacity = capacity;
		this.size = 0;
	}
	
	public synchronized void produce(int val){
		try{
			//left��ʾ��Ҫ�������������п��������ܶ࣬�����Ҫ ѭ���������
			int left = val;
			while(left > 0){
				
				//���������ʱ���ȴ����������Ѳ�Ʒ
				while(size >= capacity){
					wait();
				}
				
				//����ʵ��Ҫ����������
				//�������桱+����Ҫ������������>���ܵ�����������ʵ��������=���ܵ�������-����ǰ��������(��ʱ�����ֿ�)
				//����ʵ��������=����Ҫ������������
				int inc = (size+left)>capacity ? (capacity-size) : left;
				
				size += inc;	//���¿��
				left -= inc;	//���»�Ҫ��������
				
				System.out.printf("������ %s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
						Thread.currentThread().getName(), val, left, inc, size);
				
				//֪ͨ�����߿���������������
				notifyAll();
			}
		} catch(InterruptedException  ie){
			
		}
	}
	
	public synchronized void consume(int val){
		try{
			//left��ʾ�ͻ�Ҫ���ѵ��������п���Ҫ���ѵ����ܴ󣬿�治�������Ҫ�������
			int left = val;
			while(left > 0){
				//���Ϊ0ʱ���ȴ�������������Ʒ
				while(size <= 0){
					wait();
				}
					
					//��ȡ��ʵ�����ѵ�������(�������ʵ�ʼ��ٵ�����)
					//�������桱<���ͻ�Ҫ���ѵ�����������ʵ�������ˡ�=����桱�����磬���100���ͻ�Ҫ����500������һ��ʵ������������100��
					//���򣬡�ʵ�������ˡ�=���ͻ�Ҫ���ѵ����������磬���100���ͻ�Ҫ����50����ʵ������������50��
					
					int dec = (size<left) ? size : left;
					
					//��������
					size -= dec;
					left -= dec;
					System.out.printf("������ %s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
							Thread.currentThread().getName(), val, left, dec, size);
					
					//֪ͨ�����߿�������
					notifyAll();
			}
		} catch(InterruptedException ie){
			
		}
	}
	
	public String toString(){
		return "�ֿ�����capacity:"+capacity+",ʵ�ʿ��actual size:"+size;
	}
}

//������
class Producer{
	private Depot depot;
	
	public Producer(Depot depot){
		this.depot = depot;
	}
	
	//������Ʒ���½�һ���߳���ֿ���������Ʒ
	public void produce(final int val){
		new Thread(){
			public void run(){
				depot.produce(val);		//ע�⣬�ֲ��ࣨ��һ�����ĳ�������ж�����ࣩ���Է�����final���εľֲ�����val
			}
		}.start();
	} 
}

//������
class Customer{
	private Depot depot;
	
	public Customer(Depot depot){
		this.depot = depot;
	}
	
	//���Ѳ�Ʒ���½�һ���̴߳Ӳֿ������Ѳ�Ʒ
	public void consume(final int val){
		new Thread(){
			public void run(){
				depot.consume(val);
			}
		}.start();
	}
}

public class ProducerConsumer {
	public static void main(String[] args){
		Depot depot = new Depot(100);	//�½�һ������100�Ĺ���
		Producer pro = new Producer(depot);
		Customer cus = new Customer(depot);
		
		cus.consume(100);
		pro.produce(60);
		//pro.produce(100);
		/*pro.produce(120);
		cus.consume(90);
		cus.consume(150);
		pro.produce(110);*/
	}
}
