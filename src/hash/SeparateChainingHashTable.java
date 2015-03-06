package hash;

import java.util.LinkedList;
import java.util.List;

//分离链接法解决哈希冲突
public class SeparateChainingHashTable<E> {
	
	private static final int DEFAULT_TABLE_SIZE = 101;
	private List<E>[] theLists;
	private int currentSize;
	
	
	/**
	 * 分离链接散列表的构造函数
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
	 * 清空哈希表的函数
	 */
	public void makeEmpty(){
		for(int i=0; i<theLists.length; i++){
			theLists[i].clear();
		}
	}
	
	/**
	 * 在哈希表中找到某一项
	 * @param e
	 * @return 如果e找到，返回true
	 */
	public boolean contains(E e){
		List<E> whichList = theLists[myhash(e)];
		return whichList.contains(e);
	}
	
	/**
	 * 向哈希表中插入一项，如果该项也存在，那什么也不做
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
	 * 从哈希表中移除某项
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
	
	//测试
	public static void main(String[] args){
		SeparateChainingHashTable<Integer> hashTable = new SeparateChainingHashTable<Integer>();
		
		int e = 100;
		hashTable.insert(e);
		
	} 
	
}
