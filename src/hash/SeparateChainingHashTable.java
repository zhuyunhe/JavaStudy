package hash;

import java.util.LinkedList;
import java.util.List;

//�������ӷ������ϣ��ͻ
public class SeparateChainingHashTable<E> {
	
	private static final int DEFAULT_TABLE_SIZE = 101;
	private List<E>[] theLists;
	private int currentSize;
	
	
	/**
	 * ��������ɢ�б�Ĺ��캯��
	 */
	public SeparateChainingHashTable(){
		this(DEFAULT_TABLE_SIZE);
	}
	
	public SeparateChainingHashTable(int size){
		theLists = new LinkedList[size];
		
		for(int i=0; i<theLists.length; i++){
			theLists[i] = new LinkedList<E>();
		}
		//theSize = 0;
	}
	
	/**
	 * ��չ�ϣ��ĺ���
	 */
	public void makeEmpty(){
		for(int i=0; i<theLists.length; i++){
			theLists[i].clear();
		}
	}
	
	/**
	 * �ڹ�ϣ�����ҵ�ĳһ��
	 * @param e
	 * @return ���e�ҵ�������true
	 */
	public boolean contains(E e){
		List<E> whichList = theLists[myhash(e)];
		return whichList.contains(e);
	}
	
	/**
	 * ���ϣ���в���һ��������Ҳ���ڣ���ʲôҲ����
	 * @param e
	 */
	public void insert(E e){
		List<E> whichList = theLists[myhash(e)];
		if(!whichList.contains(e)){
			whichList.add(e);
			currentSize++;
		}
	}
	
	/**
	 * �ӹ�ϣ�����Ƴ�ĳ��
	 * @param e
	 */
	public void remove(E e){
		List<E> whichList = theLists[myhash(e)];
		if(whichList.contains(e)){
			whichList.remove(e);
			currentSize--;
		}
	}
	
	private int myhash(E e){
		int hashVal = e.hashCode();
		
		hashVal %= theLists.length;
		
		if(hashVal < 0){
			hashVal += theLists.length;
		}
		return hashVal;
	}
	
	//����
	public static void main(String[] args){
		SeparateChainingHashTable<Integer> hashTable = new SeparateChainingHashTable<Integer>();
		
		int e = 100;
		hashTable.insert(e);
		
	} 
	
}
