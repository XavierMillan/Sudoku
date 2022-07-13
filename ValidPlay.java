package February;

import java.util.Random;

public class ValidPlay {

	
	
	  public ValidPlay() {

	        

	    }
	  
	  public int playableNum(Board board, int row, int column )
	  {
		for(int i = 1; i <=10; i++)
		{
			int num = (int) (Math.random()*9)+1;
			if(validSolvedPlay(board, num, row, column))
	    	{
				return num;
	    	}
		}
		return 0;
	  }

	    public boolean validPlay(Board board, int num, int row, int column) {
	    	if(validRow(board,num,row)&&validColumn(board,num,column)&&(validBox(board,num,row,column)))
	    	{
	    		return true;
	    	}
	        return false;
	    }
	    
	    public boolean validSolvedPlay(Board board, int num, int row, int column) {
	    	if(validSolvedRow(board,num,row)&&validSolvedColumn(board,num,column)&&(validSolvedBox(board,num,row,column)))
	    	{
	    		return true;
	    	}
	        return false;
	    }
	    
	    public boolean validCheckedPlay(Board board, int num, int row, int column) {
	    	if(validCheckedRow(board,num,row)&&validCheckedColumn(board,num,column)&&(validCheckedBox(board,num,row,column)))
	    	{
	    		return true;
	    	}
	        return false;
	    }

	    public boolean validRow(Board board, int num, int row)
	    {
	    	boolean flag = true;
	    	for (int i = 0; i < 9; i++) {
	    		if(board.getNum(row,i)==num)
	    		{
	    			flag = false;
	    			break;
	    		}
	    	}
	    	
	    	return flag;
	    }
	    
	    public boolean validColumn(Board board, int num, int column)
	    {
	    	boolean flag = true;
	    	for (int j = 0; j < 9; j++) {
	    		if(board.getNum(j,column)==num)
	    		{
	    			flag = false;
	    			break;
	    		}
	    	}
	    	
	    	return flag;
	    }
	    
	    
	    private static boolean validBox(Board board, int number, int row, int column) {
	    	boolean flag = true;

	       row=(row/3)*3;
	       column=(column/3)*3;
	    	
	       	outerloop:
	        for (int i = row; i < row + 3; i++) {
	          for (int j = column; j < column + 3; j++) {
	            if (board.getNum(i, j) == number) {
	              flag = false;
	              break outerloop;
	            }
	          }
	        }
	        return flag;
	      }
	    
	    public boolean validSolvedRow(Board board, int num, int row)
	    {
	    	boolean flag = true;
	    	for (int i = 0; i < 9; i++) {
	    		if(board.getSolvedNum(row,i)==num)
	    		{
	    			 flag = false;
		             break;
	    		}
	    	}
	    	
	    	return flag;
	    }
	    
	    public boolean validSolvedColumn(Board board, int num, int column)
	    {
	    	boolean flag = true;
	    	for (int i = 0; i < 9; i++) {
	    		if(board.getSolvedNum(i,column)==num)
	    		{
	    			flag = false;
	    			break;
	    		}
	    	}
	    	
	    	return flag;
	    }
	    
	    
	    private static boolean validSolvedBox(Board board, int number, int row, int column) {

	    	row=(row/3)*3;
		       column=(column/3)*3;
	        boolean flag = true;
	        
	        outerloop:
	        for (int i = row; i < row + 3; i++) {
	          for (int j = column; j < column + 3; j++) {
	            if (board.getSolvedNum(i, j) == number) {
	            	flag = false;
	            	break outerloop;
	            }
	          }
	        }
	        return flag;
	      }
	    
	    
	    public boolean validCheckedRow(Board board, int num, int row)
	    {
	    	boolean flag = true;
	    	for (int i = 0; i < 9; i++) {
	    		if(board.getNumCheck(row,i)==num)
	    		{
	    			flag = false;
	    			break;
	    		}
	    	}
	    	
	    	return flag;
	    }
	    
	    public boolean validCheckedColumn(Board board, int num, int column)
	    {
	    	boolean flag = true;
	    	for (int j = 0; j < 9; j++) {
	    		if(board.getNumCheck(j,column)==num)
	    		{
	    			flag = false;
	    			break;
	    		}
	    	}
	    	
	    	return flag;
	    }
	    
	    
	    private static boolean validCheckedBox(Board board, int number, int row, int column) {
	    	boolean flag = true;

	       row=(row/3)*3;
	       column=(column/3)*3;
	    	
	       	outerloop:
	        for (int i = row; i < row + 3; i++) {
	          for (int j = column; j < column + 3; j++) {
	            if (board.getNumCheck(i, j) == number) {
	              flag = false;
	              break outerloop;
	            }
	          }
	        }
	        return flag;
	    }
	    
	    
//        switch (row) {
//      case 0 | 1 | 2:
//          row = 0;
//          break;
//      case 3 | 4 | 5:
//          row = 3;
//          break;
//      case 6 | 7 | 8:
//          row = 6;
//          break;
//      default:
//      	row = 0;
//          break;
//  }
//  switch (column) {
//      case 0 | 1 | 2:
//          column = 0;
//          break;
//      case 3 | 4 | 5:
//          column = 3;
//          break;
//      case 6 | 7 | 8:
//          column = 6;
//          break;
//      default:
//      	column = 0;
//          break;
//  }

//	    public boolean inBox(Board board, int num, int row, int column) {
//

//	        for (int i = row; i < row+3; i++) {
//	            for (int j = column; i < column+3; j++) {
//	                if(board.getNum(i,j)==num){
//	                    return true;
//	                }
//	            }
//	        }
//	        return false;
//	    }
	
}
