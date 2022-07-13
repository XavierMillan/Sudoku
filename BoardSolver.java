package February;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardSolver {
	
	private ArrayList<int[]> locs = new ArrayList<int[]>();
	
	public BoardSolver()
	{
		for(int i = 0; i<9;i++) {
			for(int j = 0; j<9;j++) {
				int[] myLoc = {i,j};
				locs.add(myLoc);
			}
		}
//		Collections.shuffle(locs);
	}
	
//	public boolean Solver(Board board)
//	{
//		ValidPlay next = new ValidPlay();
//		    for (int row = 0; row < 9; row++) {
//		      for (int column = 0; column < 9; column++) {
//		        if (board.getNum(row, column) == 0) {
//		          for (int nextNum = 1; nextNum <= 9; nextNum++) {
//		            if (next.validPlay(board, nextNum, row, column)) {
//		              board.setNum(row, column,nextNum);
//		              
//		              if (Solver(board)) {
//		                return true;
//		              }
//		              else {
//		            	  board.setNum(row, column,0);
//		              }
//		            }
//		          }
//		          return false;
//		        }
//		      }
//		    }
//		    return true;
//		    
//	}
	
	
	public boolean Solver(Board board)
	{
		
		ValidPlay next = new ValidPlay();
		for(int i = 0; i<locs.size(); i++)
		{
			int row = locs.get(i)[0];
			int column = locs.get(i)[1];
		        if (board.getNum(row, column) == 0) {
		          for (int playNum = 1; playNum <= 9; playNum++) {
		            if (next.validPlay(board, playNum, row, column)) {
		              board.setNum(row, column,playNum);
		              
		              if (Solver(board)) return true;
		              else board.setNum(row, column,0);
		            }
		          }
		          return false;
		        }
		}
		    return true;
		    
	}
	
	public boolean BackSolver(Board board)
	{
		
		ValidPlay next = new ValidPlay();
		for(int i = 0; i<locs.size(); i++)
		{
			int row = locs.get(i)[0];
			int column = locs.get(i)[1];
		        if (board.getNumCheck(row, column) == 0) {
		          for (int playNum = 9; playNum >= 1; playNum--) {
		            if (next.validCheckedPlay(board, playNum, row, column)) {
		              board.setNumCheck(row, column,playNum);
		              
		              if (BackSolver(board)) return true;
		              else board.setNumCheck(row, column,0);
		            }
		          }
		          return false;
		        }
		}
		    return true;
		    
	}
	
//	public ArrayList<Integer> numsPattern()
//	{
//		Integer[] a = {1,2,3,4,5,6,7,8,9};
//		Integer[] b = {1,2,3,4,5,6,7,8,9};
//	  	  List<Integer> c = Arrays.asList(a);
//	  	  List<Integer> d = Arrays.asList(b);
//	  	  Collections.shuffle(c);
//	  	  ArrayList<Integer> nextNum = new ArrayList<Integer>();
//	  	  nextNum.addAll(c);
//	  	nextNum.addAll(d);
//	  	
//	  	return nextNum;
//	}
//	
//	public boolean Solver2(Board board)
//	{
//		
//	  	  ArrayList<Integer> nextNum = numsPattern();
//	  	  
//	  	
//		ValidPlay next = new ValidPlay();
//		for(int i = 0; i<locs.size(); i++)
//		{
//			int row = locs.get(i)[0];
//			int column = locs.get(i)[1];
//		        if (board.getNum(row, column) == 0) {
//		        	for (int j = 0; j < 18; j++) {
//				           int playNum = nextNum.get(j);
//		            if (next.validPlay(board, playNum, row, column)) {
//		              board.setNum(row, column,playNum);
//		              
//		              if (Solver2(board)) {
//		                return true;
//		              }
//		              else {
//		            	  board.setNum(row, column,0);
//		              }
//		            }
//		          }
//		          return false;
//		        }
//		}
//		    return true;
//		    
//	}
	
	/*
	 * public boolean Solver(Board board)
	{
		ValidPlay next = new ValidPlay();
		    for (int row = 0; row < 9; row++) {
		      for (int column = 0; column < 9; column++) {
		        if (board.getNum(row, column) == 0) {
		          for (int nextNum = 1; nextNum <= 9; nextNum++) {
		            if (next.validPlay(board, nextNum, row, column)) {
		              board.setNum(row, column,nextNum);
		              
		              if (Solver(board)) {
		                return true;
		              }
		              else {
		            	  board.setNum(row, column,0);
		              }
		            }
		          }
		          return false;
		        }
		      }
		    }
		    return true;
		    
	}
	 */
	
}
