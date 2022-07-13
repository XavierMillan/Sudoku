package February;

public class Client {
    public static void main(String[] args) {

    	SudokuGame game = new SudokuGame();

    	//Visual Demonstration

    	Board gameBoard = new Board();
	     BoardMaker maker = new BoardMaker();
	     maker.Maker(gameBoard);
	     maker.Picker(gameBoard);

	     BoardSolver solver = new BoardSolver();
	     solver.Solver(gameBoard);
	     
	    
	     gameBoard.setBoard(maker.getSudokuPlayer());
	     
	    	gameBoard.check();
	    	System.out.println("Board");
	    	gameBoard.printBoard();
	    	System.out.println("CheckBoard");
	    	gameBoard.printCheckedBoard();
	    	
	    	
	     
		     System.out.println("SolvedBoard");
		     gameBoard.printSolvedBoard();
		     
		     System.out.println("BackSolvedBoard");
		    	solver.BackSolver(gameBoard);
		    	gameBoard.printCheckedBoard();
	     
		     System.out.println("Unique Board: "+gameBoard.uniqueSolve());
		     System.out.println("Prefilled squares: "+ (gameBoard.countNonZero()) );
	     
		     //end
		     


    }
}
