package algopractice.dynamicprogramming;

public class HighestBoxesWin {

	private static final int COLUMNS = 3;

	/**
	 * 1 2 3
	 * 4 5 6 
	 * 7 8 9
	 * 
	 * 0 1 2 
	 * 3 4 5 
	 * 6 7 8
	 */

	private boolean canConnect(int a, int b) {
		if (Math.abs(a - b) == COLUMNS || Math.abs(a - b) == 1) {
			return true;
		}
		return false;
	}

	private void connect(int a, int b) {
		grid[a][b] = 1;
		grid[b][a] = 1;
	}

	private boolean isConnected(int a, int b){
		if(grid[a][b]==1){
			return true;
		}
		return false;
	}
	
	private void disConnect(int a, int b){
		grid[a][b] = 0;
		grid[b][a] = 0;
	}
	
	int playerAScore;
	int playerBScore;

	boolean playerATurn;
	boolean playerBTurn;

	int[][] possibleGrid;

	int[][] grid = new int[9][9];

	
	/**
	 * 
	 * @param aTurn
	 */
	private void getMaxCount(boolean aTurn) {
//		connect(0, 1);
			// first step
		int bScore = 0;
		if(!aTurn){
			
		}
		for (int i = 0; i < grid[0].length; i++) {
			for(int j=0; j< grid[0].length; j++){
				if(canConnect(i, j)){
					if(isConnected(i, j)){
						continue;
					}
					else{
						connect(i,j);
						getMaxCount(aTurn?false:true);
						if(getNumberOfBox(i, j) > bScore)
								bScore = getNumberOfBox(i, j);
					}
					
				}
			}
		}

	}
	
	/**
	 * This function returns the number of boxes are created on connecting a and b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private int getNumberOfBox(int a, int b){
		int numOfBox = 0;
		if(Math.abs(a-b)==1){
			numOfBox += a-COLUMNS>=0 && b-COLUMNS >=0 && isConnected(a-COLUMNS, a) && isConnected(b, b-COLUMNS) && isConnected(a, b) && isConnected(a-COLUMNS, b-COLUMNS) ? 1:0;
			numOfBox += a+COLUMNS < grid[0].length && b+COLUMNS < grid[0].length && isConnected(a+COLUMNS, a) && isConnected(b, b+COLUMNS) && isConnected(a, b) && isConnected(a+COLUMNS, b+COLUMNS) ? 1:0;
		}
		else if(Math.abs(a-b) == COLUMNS){
			numOfBox += a-1>=0 && b-1 >=0 && isConnected(a-1, a) && isConnected(b, b-1) && isConnected(a, b) && isConnected(a-1, b-1) ? 1:0;
			numOfBox += a+1 < grid[0].length && b+1 < grid[0].length && isConnected(a+1, a) && isConnected(b, b+1) && isConnected(a, b) && isConnected(a+1, b+1) ? 1:0;
		}
		return numOfBox;
	}
}