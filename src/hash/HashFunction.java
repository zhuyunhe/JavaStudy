package hash;

public class HashFunction {
	public static int simpleHash(String key, int tablesize){
		int hashVal = 0;
		
		//���ַ������ַ���ASCII��(��Unicode��)ֵ������
		for(int i=0; i<key.length(); i++){
			hashVal += key.charAt(i);
		}
		return hashVal%tablesize;
		
	}
	
	//Horner���ɷ���
	public static int hash(String key, int tableSize){
		int hashVal = 0;
		
		for(int i=0; i<key.length(); i++){
			hashVal = 37*hashVal + key.charAt(i);
		}
		
		hashVal %= tableSize;
		
		if(hashVal < 0){
			hashVal += tableSize;
		}
		return hashVal;
		
	}
}
