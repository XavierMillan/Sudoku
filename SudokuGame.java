package February;

import java.awt.*;        
import java.awt.event.*;  
import javax.swing.*;    
import java.util.*;


public class SudokuGame extends JFrame{
	 
	
	  
	 
	   // Name-constants for UI control (sizes, colors and fonts)
	   public static final int CELL_SIZE = 70;  
	   public static final int WIDTH  = CELL_SIZE * 9;
	   public static final int HEIGHT = CELL_SIZE * 9;
	                                             
	   public static final Color FILLED_CELL_GRAY = new Color(240, 240, 240);
	  
	   public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 24);
	   
	   private static JTextField[][] textCells = new JTextField[9][9];
	
	   private static int[][] puzzle;
	   private static int[][] Solvedpuzzle;
	   private static Board gameBoard = new Board();
	   private static Integer mode;
	   static boolean dupes=false;
	   public boolean check1 = false;
	  
	  
	
	   
	public static int[][] getpuzzle()
	{
		return puzzle;
	}
	
	public static int[][] getSolvedpuzzle()
	{
		return Solvedpuzzle;
	}
	
	public static JTextField[][] gettfCell()
	{
		return textCells;
	}
	
	public static Board getBoard()
	{
		return gameBoard;
	}
	public static int getMode()
	{
		return mode;
	}
	public static int getNum(int row, int column)
	{
		return puzzle[row][column];
	}
	
	

	
	
	
	public SudokuGame()
	{

	     BoardMaker maker = new BoardMaker();
	     maker.Maker(gameBoard);
	     maker.Picker(gameBoard);
     
	     JMenu menu;
	     JMenuItem Check, Solve,Reset, NextP, Close;
	     
	    	 JMenuBar mb = new JMenuBar();
	    	 menu = new JMenu("Options");
	    	 Check = new JMenuItem("Check");
	    	 Solve = new JMenuItem("Solve");
	    	 Reset = new JMenuItem("Reset");
	    	 NextP = new JMenuItem("New");
	    	 Close = new JMenuItem("Close");
	    	
	    	 menu.add(Check);
	    	 menu.add(Solve);
	    	 menu.add(Reset);
	    	 menu.addSeparator();
	    	 menu.add(NextP);
	    	 menu.addSeparator();
	    	 menu.add(Close);
	    	 mb.add(menu);
			setJMenuBar(mb);
			
			Close.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			});
			
			NextP.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
					gameBoard = new Board();
					SudokuGame game = new SudokuGame();
					
				}
			});
			
			Reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dupes=false;
					for (int row = 0; row < 9; ++row) {
				         for (int col = 0; col < 9; ++col) {
				        	 if(!textCells[row][col].getBackground().equals(FILLED_CELL_GRAY))
				        	 {
				        		 gameBoard.setNum(row,col,0);
				        		 textCells[row][col].setText("");
				        		 textCells[row][col].setBackground(Color.WHITE);
				        		 
				        	 }
				         }
					}
					InputListener listener = new InputListener();
					for (int row = 0; row < 9; ++row) {
				         for (int col = 0; col < 9; ++col) {
				            if (puzzle[row][col]==0||textCells[row][col].getText().equals("")) {

				               textCells[row][col].addActionListener(listener);
				               textCells[row][col].setEditable(true);
				            } 
				           
				         }
				      }
					check1 = false;
				}
			});
			Check.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Checked");
					
				
				         
					if(SudokuGame.getBoard().correctSolve()||check1){
						JOptionPane.showMessageDialog(null, "Congratulations You Solved The Puzzle!");
						
						//remove 1
//						for (int row = 0; row < 9; ++row) {
//					         for (int col = 0; col < 9; ++col) {
//					        	 
//					        	 for(ActionListener al : textCells[row][col].getActionListeners()) {
//					        	  textCells[row][col].removeActionListener(al);
//					        	 }
//					        	 
//					         }
//					       }
						//remove 2
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect");
					for (int row = 0; row < 9; ++row) {
				         for (int col = 0; col < 9; ++col) {
				        	 Integer in = Solvedpuzzle[row][col];
				        	 String values = in.toString()+"";
				        	 if(textCells[row][col].getText().equals(values)&&!textCells[row][col].getBackground().equals(FILLED_CELL_GRAY)){
//				        		 textCells[row][col].setBackground(Color.GREEN);
				        		 textCells[row][col].setEditable(false);
				        	 }
				        	 if(!textCells[row][col].getText().equals(values)&&!textCells[row][col].getBackground().equals(FILLED_CELL_GRAY)){
				        		 textCells[row][col].setBackground(Color.RED);
				        		 textCells[row][col].setEditable(true);
				        	 }
				        	 if(textCells[row][col].getText().equals(values)&&textCells[row][col].getBackground().equals(Color.RED))
				        	 {
				        		 textCells[row][col].setBackground(Color.WHITE);
				        	 }
				        	 if(textCells[row][col].getText().equals(values)&&!textCells[row][col].getBackground().equals(Color.RED)&&!textCells[row][col].getBackground().equals(FILLED_CELL_GRAY)){
				        		 textCells[row][col].setBackground(Color.WHITE);//gray
				        		 textCells[row][col].setEditable(false);
				        	 }
				         }
				     }
				}
					InputListener listener = new InputListener();
					for (int row = 0; row < 9; ++row) {
				         for (int col = 0; col < 9; ++col) {
				            if (puzzle[row][col]==0) //puzzle[row][col]==0     &&!getBoard().correctSolve()
				            {
				            	
				            	textCells[row][col].addActionListener(listener);
				            }
				         }
					}
				}
				
			});
			
			
			
			Solve.addActionListener(new java.awt.event.ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Solved");
					for (int row = 0; row < 9; ++row) {
				         for (int col = 0; col < 9; ++col) {
				        	 if(!textCells[row][col].getBackground().equals(FILLED_CELL_GRAY))
				        	 {
				        		 
				        	 textCells[row][col].setText(Solvedpuzzle[row][col]+"");
				        	 textCells[row][col].setBackground(Color.WHITE);//gray
				        	 textCells[row][col].setEditable(false);
				        	 }
				         }
					 }
					JOptionPane.showMessageDialog(null, "Sudoku Solved");
					check1 = true;
				}
				
			});
	          
	     Object[] Diffoptions = { "Test","Easy","Medium","Hard", "Hardest"};
	     int Diffmode = JOptionPane.showOptionDialog(null, "Select Difficulty", "Game Difficulty",
	    		 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
	    		 null, Diffoptions, Diffoptions[4]);
	     
	     int diffLevel = (Diffmode) *25;
	     if(diffLevel ==0)diffLevel+=3;
	     
	     Object[] options = { "Normal","Assisted"};
	     mode = JOptionPane.showOptionDialog(null, "Select Game Mode", "Game Mode",
	    		 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
	    		 null, options, options[0]);
	     

	     gameBoard.diffuclty(diffLevel);
	     
	     puzzle = gameBoard.boardToint(gameBoard);
	     Solvedpuzzle = gameBoard.boardToSolvedint(gameBoard);
	     
	     gameBoard.printSolvedBoard();
	     
	     
	     
	     
	     
		Container container = getContentPane();
	      container.setLayout(new GridLayout(9, 9));
	      

	      
	      InputListener listener = new InputListener();
	      
	      // Construct 9x9 JTextFields and add to the content-pane
	      for (int row = 0; row < 9; row++) {
	         for (int col = 0; col < 9; col++) {
	            textCells[row][col] = new JTextField(); // Allocate element of array
	            container.add(textCells[row][col]);            // ContentPane adds JTextField
	            if (puzzle[row][col]==0) {
	               textCells[row][col].setText("");     // set to empty string
	               textCells[row][col].setEditable(true);
	               textCells[row][col].setBackground(Color.WHITE);
	 
	               // Add ActionEvent listener to process the input
//	               textCells[row][col].removeActionListener(listener);
	               textCells[row][col].addActionListener(listener);
	            } else {
	               textCells[row][col].setText(puzzle[row][col] + "");
	               textCells[row][col].setEditable(false);
	               textCells[row][col].setBackground(FILLED_CELL_GRAY);
	               textCells[row][col].setForeground(Color.BLACK);
	            }
	            // Beautify all the cells
	            textCells[row][col].setHorizontalAlignment(JTextField.CENTER);
	            textCells[row][col].setFont(FONT_NUMBERS);
	         }
	      }
	      
	     
	 
	    
	      container.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	      pack();
	      for (int row = 0; row < 9; ++row) {
		         for (int col = 0; col < 9; ++col) {
		        	 if(row == 0) {
		        		 if(col == 0) {
		        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(7, 7, 1, 1, Color.BLACK));
		        		 }
		        		 else if(col == 2) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(7, 1, 1, 4, Color.BLACK));
		        		 }
		        		 else if(col == 3) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(7, 1, 1, 1, Color.BLACK));
		        		 }
		        		 else if(col == 5) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(7, 1, 1, 4, Color.BLACK));
		        		 }
		        		 else if(col == 6) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(7, 1, 1, 1, Color.BLACK));
		        		 }
		        		 else if(col == 8) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(7, 1, 1, 7, Color.BLACK));
		        		 }
		        		 else
		        		 {
				        	 textCells[row][col].setBorder(BorderFactory.createMatteBorder(7, 1, 1, 1, Color.BLACK));
		        		 }
		        		 
		        	}
		        	 if(row == 1) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
		        	 }
		        	 if(row == 2) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 4, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, Color.BLACK));
			        		 }
		        	 }
		        	 if(row == 3) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
		        	 }
		        	 if(row == 4) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
		        	 }
		        	 if(row == 5) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 4, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 4, 1, Color.BLACK));
			        		 }
		        	 }
		        	 if(row == 6) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
		        	 }
		        	 if(row == 7) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			        		 }
		        	 }
		        	 if(row == 8) {
		        		 if(col == 0) {
			        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 7, 7, 1, Color.BLACK));
			        		 }
			        		 else if(col == 2) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 7, 4, Color.BLACK));
			        		 }
			        		 else if(col == 3) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 7, 1, Color.BLACK));
			        		 }
			        		 else if(col == 5) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 7, 4, Color.BLACK));
			        		 }
			        		 else if(col == 6) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 7, 1, Color.BLACK));
			        		 }
			        		 else if(col == 8) {
				        		 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 7, 7, Color.BLACK));
			        		 }
			        		 else {
			        			 textCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 7, 1, Color.BLACK));
			        		 }
		        	 }
		         }
	      }
	      
	      
	 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
	      setTitle("Sudoku");
	      setVisible(true);
		


	}
	
	public static void SetEdit(int row, int col, boolean allowed)
	{
		textCells[row][col].setEditable(allowed);
	}
	
	
	
}



class InputListener implements ActionListener {
	 
   	private int numberIn;

//   	int counter = 0;
   	int col = 0;
	int row = 0;
      
   	
      public InputListener()
      {
    	  
      }
      
      public void actionPerformed(ActionEvent e) {
         // All the 9*9 JTextFileds invoke this handler. We need to determine
         // which JTextField (which row and column) is the source for this invocation.
         int rowSelected = -1;
         int colSelected = -1;

         // Get the source object that fired the event
         JTextField source = (JTextField)e.getSource();
         // Scan JTextFileds for all rows and columns, and match with the source object
         boolean found = false;
         
        
       
         
         for (int row = 0; row < 9 && !found; ++row) {
            for (int col = 0; col < 9 && !found; ++col) {
               if (SudokuGame.gettfCell()[row][col] == source) {
                  rowSelected = row;
                  colSelected = col;
                  found = true;  

               }
            }
         }
        
         Color GRAY = new Color(240, 240, 240);
		numberIn = Integer.parseInt(SudokuGame.gettfCell()[rowSelected][colSelected].getText());
		
		if(SudokuGame.getMode()==0) {
			SudokuGame.getBoard().setNum(rowSelected,colSelected,numberIn);
			
			if(SudokuGame.getBoard().countNonZero()==81&&!SudokuGame.dupes)
			{
				 if(SudokuGame.getBoard().correctSolve()){
					 SudokuGame.dupes=true; 
				 }
				 Object[] optionsCheck = { "No","Yes"};
			     int checkEnd = JOptionPane.showOptionDialog(null, "Do you want to check the Board", "Checker",
			    		 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
			    		 null, optionsCheck, optionsCheck[0]);
			     if(checkEnd == 1)
			     {
			    	 
			    	 
			    	 if(SudokuGame.getBoard().correctSolve()){
			    		 JOptionPane.showMessageDialog(null, "Congratulations You Solved The Puzzle!");
			    		 
			    		 for (int row = 0; row < 9; row++) {
					         for (int col = 0; col < 9; col++) {
					        	 if(!SudokuGame.gettfCell()[row][col].getBackground().equals(GRAY)&&!SudokuGame.gettfCell()[row][col].getBackground().equals(Color.WHITE))
					        	 {
					        		 SudokuGame.gettfCell()[row][col].setBackground(Color.WHITE);
//			 				SudokuGame.gettfCell()[row][col].setEditable(false);
					        	 }
					         }
			 			 }
			 			
			 			
			 		}
			    	 else
			    	 {
			    		 JOptionPane.showMessageDialog(null, "Incorrect");
			    	
			    		 for (int row = 0; row < 9; row++) {
					         for (int col = 0; col < 9; col++) {
					        	 Integer in = SudokuGame.getSolvedpuzzle()[row][col];
					        	 String values = in.toString()+"";


					        	 if(SudokuGame.gettfCell()[row][col].getText().equals(values)&&!SudokuGame.gettfCell()[row][col].getBackground().equals(GRAY)){
//					        		 textCells[row][col].setBackground(Color.GREEN);
					        		 SudokuGame.gettfCell()[row][col].setEditable(false);
					        	 }
					        	 if(!SudokuGame.gettfCell()[row][col].getText().equals(values)&&!SudokuGame.gettfCell()[row][col].getBackground().equals(GRAY)){
					        		 SudokuGame.gettfCell()[row][col].setBackground(Color.RED);
					        		 SudokuGame.gettfCell()[row][col].setEditable(true);
					        	 }
					        	 if(SudokuGame.gettfCell()[row][col].getText().equals(values)&&SudokuGame.gettfCell()[row][col].getBackground().equals(Color.RED))
					        	 {
					        		 SudokuGame.gettfCell()[row][col].setBackground(Color.WHITE);
					        	 }
					        	 if(SudokuGame.gettfCell()[row][col].getText().equals(values)&&!SudokuGame.gettfCell()[row][col].getBackground().equals(Color.RED)&&!SudokuGame.gettfCell()[row][col].getBackground().equals(GRAY)){
					        		 SudokuGame.gettfCell()[row][col].setBackground(Color.WHITE);//gray
					        		 SudokuGame.gettfCell()[row][col].setEditable(false);
					        	 }
					         }
					     
			    	 }			    	
			     }
			}
		}
		}
		if(SudokuGame.getMode()==1) {
		if (numberIn == SudokuGame.getSolvedpuzzle()[rowSelected][colSelected]) {
			SudokuGame.gettfCell()[rowSelected][colSelected].setBackground(Color.GREEN);
			SudokuGame.getBoard().setNum(rowSelected,colSelected,numberIn);
			
			SudokuGame.SetEdit(rowSelected, colSelected, false);
			}
		else {
			SudokuGame.gettfCell()[rowSelected][colSelected].setBackground(Color.RED);
		}

		
		if(SudokuGame.getBoard().correctSolve()){
			JOptionPane.showMessageDialog(null, "Congratulations You Solved The Puzzle!");
		}
		}
      }
   }

