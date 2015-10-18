package interviews.progress;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CountingCellSolution1 {
	
	private int currentSectorSize;
	
	private int maxSectorSize;
	
	private static final String FILE_PATH = "/home/anurag/Desktop/Email Programming IndexAt1Starts/input.txt";
	
	private void setCurrentSectorSize(int currentSectorSize) {
		this.currentSectorSize = currentSectorSize;
	}


	private void setMaxSectorSize(int maxSectorSize) {
		this.maxSectorSize = maxSectorSize;
	}


	private int getMaxSectorSize() {
		return maxSectorSize;
	}


	/**
     * Core logic for finding out the number of connected cells recursively
     *
     * @param n 2-D Array
     * @param bool boolean array for back tracking
     * @param i
     * @param j
     * @return
     */
    private void findMaxSectorSize(char[][] n, boolean[][] bool, int i, int j) {
        // Check if i, j (indexes) are within the size of array
        // Check if the cell is already traversed or not using bool array
        // Check if the cell value is 1 before counting it as part of a sector
        if(i >= 0 && i < n.length && 
                j >=0 && n[i]!=null && j < n[0].length
                && bool[i][j] != true && n[i][j] != '0') {
        	currentSectorSize++;
            // Mark the status of the cell for backtracking purpose
            bool[i][j] = true;

            // top traversal
            	findMaxSectorSize(n, bool, i-1, j);
            // bottom traversal
            	findMaxSectorSize(n, bool, i+1, j);

            // left traversal
            	findMaxSectorSize(n, bool, i, j-1);
            // right traversal
            findMaxSectorSize(n, bool, i, j+1);

            // Top-Bottom diagnol
            // diagnol-down traversal
            findMaxSectorSize(n, bool, i+1, j+1);
            // diagnol-up traversal
            findMaxSectorSize(n, bool, i-1, j-1);

            // Bottom-Top diagnol
            // diagnol-down traversal
            findMaxSectorSize(n, bool, i+1, j-1);
            // diagnol-up traversal
            findMaxSectorSize(n, bool, i-1, j+1);
        }
        
        if(maxSectorSize<currentSectorSize){
        	maxSectorSize = currentSectorSize;
        }
    }
    
    
    public static void main(String[] args) {
    	
    	String firstLine;
    	Integer totalGrids;
    	char[][] grid = new char[25][];
    	int gridCounter = 0;
    	String currentLine;
    	CountingCellSolution1 countingCellsol = new CountingCellSolution1();
    	
    	try {
			Reader fr = new FileReader(FILE_PATH);
			BufferedReader bfr = new BufferedReader(fr);
			firstLine = bfr.readLine();
			totalGrids = new Integer(firstLine.trim());
			currentLine = bfr.readLine();
			
			//Iteration over number of grids.
			while(gridCounter<totalGrids){
				int i = 0;
				countingCellsol.setMaxSectorSize(0);
				grid = new char[25][];
				currentLine = bfr.readLine();
				gridCounter++;
				
				//Initializing a each grid.
				while(currentLine!=null && !currentLine.equalsIgnoreCase("")){
					if(currentLine!=null){
						grid[i]=currentLine.toCharArray();
					}
					currentLine = bfr.readLine();
					i++;
				}
			
				//Calculating maximum
				if(grid[0]!=null){
					boolean[][] bool = new boolean[25][grid[0].length];
					for(int j=0; j<i; j++){
						for(int k=0; k<grid[0].length; k++){
							countingCellsol.setCurrentSectorSize(0);
							countingCellsol.findMaxSectorSize(grid, bool, j, k);
						}
					}
					System.out.println(countingCellsol.getMaxSectorSize());
				}
			}
			bfr.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
