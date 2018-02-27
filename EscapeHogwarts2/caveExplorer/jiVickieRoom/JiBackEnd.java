package jiVickieRoom;

public class JiBackEnd implements VickieSupport {
	
	private int[][] magicSquares;
	
	private JiSupport frontend;

	private final static String CORNER_NUMS = "2648";
	private final static int MAGIC_SUM = 15;
	private final static int MATRIX_SIZE = 3;
	private final static int[][] ANSWER = {{2,7,6},{9,5,1},{4,3,8}};
	
	private int iStartingNum;
	private int iStartingRow = 1;
	private int iStartingCol = 1;
	
	private int iRow;  //Integer Row #
	private int iCol;  //Integer Col #
	private int iNum;  //Integer Number #

	public JiBackEnd(JiSupport frontend) {
		this.frontend = frontend;
		magicSquares = new int[3][3];
	}
	
	public int getRandomInitialIndex() {
		int num = 0;
		if (Math.random() >= .5) {
			num = 2;
		}
		
		return num;
	}
	
	public void chooseStartingPoint() {
		createInitiateNum();
		if (iStartingNum != 5) {
			if(isCornerNumber(iStartingNum)) {
				//randomize outer starting box
				// (0,0) (0,2) (2,0) (2,2)
				
				iStartingRow = getRandomInitialIndex();
				iStartingCol = getRandomInitialIndex();
			}
			else {
				//randomize inner starting box
				// (0,1) (1,0) (1,2) (2,1)
				int random = generateNumber(4); 
				if(random == 0) {
					iStartingRow = 0;
					iStartingCol = 1;
					
				}else {
					if(random == 1) {
						iStartingRow = 1;
						iStartingCol = 0;
					}
					else {
						if(random == 2) {
							iStartingRow = 1;
							iStartingCol = 2;
						}else {
							iStartingRow = 2;
							iStartingCol = 1;
						}
					}
				
				}
			}
		}
		
		magicSquares[iStartingRow][iStartingCol] = iStartingNum;
	}
	
	
	public void placeNumbers(String nums) {
		String SRow;
		String SCol;
		String SNum;
		int len = nums.length();
		 if(len > 5 || len <5) {
			frontend.error();
		 }else {
			  SRow = nums.substring(0, 1);
			  SCol = nums.substring(2, 3);
			  SNum = nums.substring(4, 5);

			if(isNumeric(SCol) && isNumeric(SRow) && isNumeric(SNum) ){
				 iRow = Integer.parseInt(SRow);
				 iCol = Integer.parseInt(SCol);
				 iNum = Integer.parseInt(SNum);
				
				frontend.doNotOverride();
				
				if(iNum<10 && iNum>0 && iRow<3 && iRow>=0 && iCol<3 && iCol>=0) {
					resetMultiples(iNum);
					magicSquares[iRow][iCol] = iNum;
					frontend.displayTheGrid();
					frontend.complete();
				}else
				{
					frontend.error();
				}
				
			}else {
				frontend.error();
			}
		 }
		
	}

	public int getiRow() {
		return iRow;
	}

	public int getiCol() {
		return iCol;
	}

	public int getiNum() {
		return iNum;
	}

	public int getInitiateNum() {
		return iStartingNum;
	}
	
	public int getRowNum() {
		return iStartingRow;
	}
	
	public int getColNum() {
		return iStartingCol;
	}
	
	public boolean isCornerNumber(int num) {
		return CORNER_NUMS.indexOf(Integer.toString(num)) > -1;
	}
	
	public void createInitiateNum() {
		iStartingNum = (int)(Math.random() * 9) + 1;
	}

	public int generateNumber(int max) {
		return (int)(Math.random() * max);
	}

	public boolean isNumeric(String str) {  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public void resetMultiples(int num) {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				int same = magicSquares[row][col];
				
				if(num == same) {
					magicSquares[row][col]= 0;
				}
			}
		}
		
	}
	
	public boolean checkTotal() {
		for(int row = 0; row < MATRIX_SIZE; row++) {
			int rowTotal = 0;
			for(int col = 0; col < MATRIX_SIZE; col++) {
				rowTotal += magicSquares[row][col];
			}
				
			if(rowTotal != MAGIC_SUM) {
				return false;
			}
		}
		
		for(int col = 0; col < MATRIX_SIZE; col++) {
			int colTotal = 0;
			for(int row = 0; row < MATRIX_SIZE; row++) {
				colTotal += magicSquares[row][col];
			}
			
			if(colTotal != MAGIC_SUM) {
				return false;
			}
		}
		
		int diagonalSum = 0;
		for(int i = 0 ; i < MATRIX_SIZE; i++) {
			diagonalSum += magicSquares[i][i];
		}
		if(diagonalSum != MAGIC_SUM) {
			return false;
		}
		
		int diagonalSum2 = 0;
		for(int i = 0 ; i < MATRIX_SIZE; i++) {
			diagonalSum2 += magicSquares[i][MATRIX_SIZE - 1 - i];
		}
		if(diagonalSum2 != MAGIC_SUM) {
			return false;
		}
		
		return true;
	}

	public void cheatCode() {
		magicSquares = ANSWER;
		frontend.displayTheGrid();
		frontend.endGame();
	}

	public int[][] getBoxes() {
		return magicSquares;
	}

}