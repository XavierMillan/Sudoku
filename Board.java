package February;

import java.util.ArrayList;
import java.util.Collections;

public class Board
{
    private int[][] Board= {
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
    
    private int[][] BoardCheck= {
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
    
    private int[][] SolvedBoard= {
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
   



    public Board() {
    	
    	
     
    }
    
    public void diffuclty(int num)
    {
    	int diffLevel = 100-num;
    	int preNum = countNonZero();
    	double setDiff = preNum+((81-preNum)*(diffLevel/100.0));
    	
    	num--;
    	ArrayList<int[]> locs = allIndex();
    	int i = 0;
		while(countNonZero()<=setDiff) {
			
			int add = getSolvedNum(locs.get(i)[0], locs.get(i)[1]);
			
			Board[locs.get(i)[0]][locs.get(i)[1]] = add;
			i++;
		}
    }
    
    public ArrayList<int[]> allIndex()
    {
    	ArrayList<int[]> locs = new ArrayList<int[]>();
		for(int i = 0; i<9;i++) {
			for(int j = 0; j<9;j++) {
				int[] myLoc = {i,j};
				locs.add(myLoc);
			}
		}
		Collections.shuffle(locs);
		return locs;
    }
    
    public int countNonZero()
    {
    	int count =0;
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
        		if(Board[i][j]!=0)
        		{
        			count++;
        		}
        	}
    	}
    	return count++;
    }

    public void setNum(int row, int col, int num) {

    	Board[row][col]=num;
    	
    }
    public int getNum(int row, int col) {
        return Board[row][col];
    }
    
    public void setNumCheck(int row, int col, int num) {

    	BoardCheck[row][col]=num;
    	
    }
    public int getNumCheck(int row, int col) {
        return BoardCheck[row][col];
    }
    
    public void check() {
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    		BoardCheck[i][j]=Board[i][j];
    		}
    	}
    }
    
    public void setSolvedNum(int row, int col, int num) {

    	SolvedBoard[row][col]=num;
    
    }
    public int getSolvedNum(int row, int col) {
        return SolvedBoard[row][col];
    }
    
    public boolean SolvedContains(int num)
    {
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
        		if(SolvedBoard[i][j]==num)
        		{
        			return true;
        		}
        	}
    	}
    	return false;
    		
    }
    
    
    public int[][] getBoard() {
        return Board;
    }
    
    public void setBoard(int[][] in) {
    	
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    		Board[i][j]=in[i][j];
    		}
    	}
    }
    
    public int[][] boardToint(Board board)
    {
    	int[][] make = {
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
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    		make[i][j]=board.getNum(i,j);
    		}
    	}
    	return make;
    }
    
 
    public int[][] boardToSolvedint(Board board)
    {
    	int[][] make = {
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
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    		make[i][j]=board.getSolvedNum(i,j);
    		}
    	}
    	return make;
    }
    
    public void SetSolved(int [][] in)
    {
    	SolvedBoard = in;
    }
    
    public boolean correctSolve() {
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(Board[i][j]!=SolvedBoard[i][j])
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }

    public boolean uniqueSolve() {
    	for(int i = 0; i < 9; i++) {
    		for(int j = 0; j < 9; j++) {
    			if(SolvedBoard[i][j]!=BoardCheck[i][j])
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    public void printBoard() {
    	System.out.println();
        for (int row = 0; row < 9; row++) {
          if (row % 3 == 0 && row != 0) {
            System.out.println();
          }
          for (int column = 0; column < 9; column++) {
            if (column % 3 == 0 && column != 0) {
              System.out.print("\t");
            }
            System.out.print(Board[row][column]+" ");
          }
          System.out.println();
          
        }
        System.out.println();
      }
    public void printSolvedBoard() {
    	System.out.println();
    	for (int row = 0; row < 9; row++) {
    		if (row % 3 == 0 && row != 0) {
    			System.out.println();
    		}
    		for (int column = 0; column < 9; column++) {
    			if (column % 3 == 0 && column != 0) {
    				System.out.print("\t");
    			}
    			System.out.print(SolvedBoard[row][column]+" ");
    		}
    		System.out.println();
    		
    	}
    	System.out.println();
    }
    
    public void printCheckedBoard() {
    	System.out.println();
    	for (int row = 0; row < 9; row++) {
    		if (row % 3 == 0 && row != 0) {
    			System.out.println();
    		}
    		for (int column = 0; column < 9; column++) {
    			if (column % 3 == 0 && column != 0) {
    				System.out.print("\t");
    			}
    			System.out.print(BoardCheck[row][column]+" ");
    		}
    		System.out.println();
    		
    	}
    	System.out.println();
    }

  

}
