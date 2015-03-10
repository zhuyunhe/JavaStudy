package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		
		ArrayList<HashMap<Integer,Integer>> row_list_map = new ArrayList<HashMap<Integer,Integer>>();
		ArrayList<HashMap<Integer,Integer>> col_list_map = new ArrayList<HashMap<Integer,Integer>>();
		ArrayList<HashMap<Integer,Integer>> grid_list_map = new ArrayList<HashMap<Integer,Integer>>();
		
		for(int i=0; i<9; i++){
			HashMap<Integer, Integer> tem = new HashMap<Integer,Integer>();
			row_list_map.add(tem);
			tem = new HashMap<Integer,Integer>();
			col_list_map.add(tem);
			tem = new HashMap<Integer,Integer>();
			grid_list_map.add(tem);
		}
		
		for(int i=0; i<9; i++){
			for(int j=0;j<9;j++){
				if(board[i][j] == '.'){
					continue;
				}
				if(row_list_map.get(i).containsKey(board[i][j]-'0')){
                    return false;
                }else{
                    row_list_map.get(i).put(board[i][j]-'0', 1);
                }
               
                if(col_list_map.get(j).containsKey(board[i][j]-'0')){
                    return false;
                }else{
                    col_list_map.get(j).put(board[i][j]-'0', 1);
                }
               
                int index = ((i/3) * 3) + (j/3);
                if(grid_list_map.get(index).containsKey(board[i][j]-'0')){
                    return false;
                }else{
                    grid_list_map.get(index).put(board[i][j]-'0', 1);
                }
			}
		}
        return true;
    }
	public static boolean isValidSudoku_1(char[][] board) {
		
		ArrayList<HashSet<Integer>> row_list_map = new ArrayList<HashSet<Integer>>();
		ArrayList<HashSet<Integer>> col_list_map = new ArrayList<HashSet<Integer>>();
		ArrayList<HashSet<Integer>> grid_list_map = new ArrayList<HashSet<Integer>>();
		
		for(int i=0; i<9; i++){
			HashSet<Integer> tem = new HashSet<Integer>();
			row_list_map.add(tem);
			tem = new HashSet<Integer>();
			col_list_map.add(tem);
			tem = new HashSet<Integer>();
			grid_list_map.add(tem);
		}
		
		for(int i=0; i<9; i++){
			for(int j=0;j<9;j++){
				if(board[i][j] == '.'){
					continue;
				}
				if(row_list_map.get(i).contains(board[i][j]-'0')){
					return false;
				}else{
					row_list_map.get(i).add(board[i][j]-'0');
				}
				
				if(col_list_map.get(j).contains(board[i][j]-'0')){
					return false;
				}else{
					col_list_map.get(j).add(board[i][j]-'0');
				}
				
				int index = ((i/3) * 3) + (j/3);
				if(grid_list_map.get(index).contains(board[i][j]-'0')){
					return false;
				}else{
					grid_list_map.get(index).add(board[i][j]-'0');
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		char[][] board ={
				{1,2,3,4,5,6,7,8,9},
				{2,1,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
				{1,2,3,4,5,6,7,8,9},
		};
		
		/**
		 * 两种方法都可以
		 */
		if(!isValidSudoku_1(board)){
			System.out.println("no");
		}
	}
}
