package February;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardMaker {
	
	private int[][] defaultBoard = {
			{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},

	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},

	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    									};
	
	private int[][] playerBoard = {
			{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},

	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},

	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    	{0, 0, 0,   0, 0, 0,    0, 0, 0},
	    									}; 


    public BoardMaker() {


    }
  
    
 
    
    public boolean Picker(Board board)
    {
    	defaultBoard = board.boardToSolvedint(board);
    	playerBoard = board.boardToSolvedint(board);
    	BoardSolver solver = new BoardSolver();

    	ArrayList<int[]> locs = new ArrayList<int[]>();
    		for(int i = 0; i<9;i++) {
    			for(int j = 0; j<9;j++) {
    				int[] myLoc = {i,j};
    				locs.add(myLoc);
    			}
			}
    		Collections.shuffle(locs);
    		
    		for(int i = 0; i<locs.size(); i++)
    		{
    	    			setDefaultBoard(playerBoard);
    	    			int row = locs.get(i)[0];
    	    			int column = locs.get(i)[1];
    	    			int temp = defaultBoard[row][column];
    	    	    	defaultBoard[row][column]=0;
    	    	
    	    	    	board.setBoard(defaultBoard);
    	    	    	
    	    	    	//here
    	    	    	board.check();
    	    	    	solver.Solver(board);
    	    	    	solver.BackSolver(board);
    	    	    	
    	    	    	//to here
 
    								if(board.correctSolve()&&board.uniqueSolve())
    								{
    									playerBoard[row][column] = 0;
    								}
    								else
    								{
    									defaultBoard[row][column] = temp;	
    								}
    						
    		}
    	board.setBoard(playerBoard);
    	
    	
    	return true;
    }
    
    public void printArrayBoard(int[][] in) {
    	for (int row = 0; row < 9; row++) {
    		if (row % 3 == 0 && row != 0) {
    			System.out.println();
    		}
    		for (int column = 0; column < 9; column++) {
    			if (column % 3 == 0 && column != 0) {
    				System.out.print("\t");
    			}
    			System.out.print(in[row][column]+" ");
    		}
    		System.out.println();
    		
    	}
    	System.out.println();
    }
    
    public void setDefaultBoard(int[][] in)
    {
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    		defaultBoard[i][j]=in[i][j];
    		
    		}
    		
    		}
    }
    
    //makes new random baord
    public boolean Maker(Board board)
	{
   Integer[] a = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
  	  List<Integer> b = Arrays.asList(a);
  	  ArrayList<Integer> nextNum = new ArrayList<Integer>();
  	  nextNum.addAll(b);
		ValidPlay next = new ValidPlay();
		    for (int row = 0; row < 9; row++) {
		      for (int column = 0; column < 9; column++) {
		    	  
		    	  
		    	  Collections.shuffle(nextNum);
		        if (board.getSolvedNum(row, column) == 0) {
		          for (int i = 1; i < 18; i++) {
		           int playNum = nextNum.get(i);
		        	if (next.validSolvedPlay(board, playNum, row, column)) {
		              board.setSolvedNum(row, column,playNum);
		              
		              if (Maker(board)) {
		                return true;
		              }
		              else {
		            	  board.setSolvedNum(row, column,0);
		              }
		            }
		          }
		          return false;
		        }
		      }
		    }
		    return true;
		    
		    
	}
    
    public boolean Maker2(Board board)
	{

    	ValidPlay next = new ValidPlay();

    	ArrayList<int[]> locs = new ArrayList<int[]>();
    		for(int i = 0; i<9;i++) {
    			for(int j = 0; j<9;j++) {
    				int[] myLoc = {i,j};
    				locs.add(myLoc);
    			}
			}
    		Collections.shuffle(locs);
    		
    		for(int i = 0; i<locs.size(); i++)
    		{
		    	  
		    	  int row = locs.get(i)[0];
		    	  int column = locs.get(i)[1];
		        if (board.getSolvedNum(row, column) == 0) {
		          for (int j = 1; j < 9; i++) {
		          
		        	if (next.validSolvedPlay(board, j, row, column)) {
		              board.setSolvedNum(row, column,j);
		              
		              if (Maker2(board)) {
		                return true;
		              }
		              else {
		            	  board.setSolvedNum(row, column,0);
		              }
		            }
		          }
		        }
		          return false;
		        }
		 
		    return true;
		    
		    
	}
    
    
    public int[][] getSudokuPlayer()
    {
    	return playerBoard;
    }
    

    


}
