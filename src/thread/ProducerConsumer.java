package thread;

class Depot{
	private int capacity;	//仓库的容量
	private int size;		//仓库的实际数量
	
	public Depot(int capacity){
		this.capacity = capacity;
		this.size = 0;
	}
	
	public synchronized void produce(int val){
		try{
			//left表示想要生产的数量，有可能生产很多，因此需要 循环多次生产
			int left = val;
			while(left > 0){
				
				//当库存已满时，等待消费者消费产品
				while(size >= capacity){
					wait();
				}
				
				//计算实际要生产的数量
				//如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
				//否则“实际增量”=“想要生产的数量”
				int inc = (size+left)>capacity ? (capacity-size) : left;
				
				size += inc;	//更新库存
				left -= inc;	//更新还要生产的量
				
				System.out.printf("生产者 %s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
						Thread.currentThread().getName(), val, left, inc, size);
				
				//通知消费者可以来进行消费了
				notifyAll();
			}
		} catch(InterruptedException  ie){
			
		}
	}
	
	public synchronized void consume(int val){
		try{
			//left表示客户要消费的数量，有可能要消费的量很大，库存不够，因此要多次消费
			int left = val;
			while(left > 0){
				//库存为0时，等待生产者生产产品
				while(size <= 0){
					wait();
				}
					
					//获取“实际消费的数量”(即库存中实际减少的数量)
					//如果“库存”<“客户要消费的数量”，则“实际消费了”=“库存”。例如，库存100，客户要消费500，那这一次实际消费量就是100。
					//否则，“实际消费了”=“客户要消费的量”。例如，库存100，客户要消费50，那实际消费量就是50。
					
					int dec = (size<left) ? size : left;
					
					//更新数据
					size -= dec;
					left -= dec;
					System.out.printf("消费者 %s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
							Thread.currentThread().getName(), val, left, dec, size);
					
					//通知生产者可以生产
					notifyAll();
			}
		} catch(InterruptedException ie){
			
		}
	}
	
	public String toString(){
		return "仓库容量capacity:"+capacity+",实际库存actual size:"+size;
	}
}

//生产者
class Producer{
	private Depot depot;
	
	public Producer(Depot depot){
		this.depot = depot;
	}
	
	//生产产品：新建一个线程向仓库中生产产品
	public void produce(final int val){
		new Thread(){
			public void run(){
				depot.produce(val);		//注意，局部类（在一个类的某个方法中定义的类）可以访问用final修饰的局部变量val
			}
		}.start();
	} 
}

//消费者
class Customer{
	private Depot depot;
	
	public Customer(Depot depot){
		this.depot = depot;
	}
	
	//消费产品：新建一个线程从仓库中消费产品
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
		Depot depot = new Depot(100);	//新建一个容量100的工厂
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
