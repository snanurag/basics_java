package algopractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BillBoard {

	private static int[] a = { 1, 1, 1, 1, 0, 0 };
	private static int total = 4;
	private static String filePath = "BB.txt";
	private static int consecutivePos = 3;
	private static int reqBillBoards = 2;
	private static int totalCounts = 0;
	private static int totalBBs = 0;

	public static void main(String[] args) {

		/**
		 * c = 3, e = 5, s = 3
		 * 
		 * 3 c=4, s=4 4 c=4, s=5 5 c=4, s=6
		 */

		BillBoard bb = new BillBoard();
		// int currentPos = total;
//		bb.combination(1, 1, 3);


		File file = new File(filePath);
		Reader fr = null;
		try {
			fr = new FileReader(file);
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(fr!=null){
			BufferedReader bfr = new BufferedReader(fr);
		
			try {
				String nextLine;
				bfr.readLine();
				while((nextLine = bfr.readLine())!=null){
					String[] tmp = nextLine.split(" ");
					totalBBs = Integer.valueOf(tmp[0]);
					consecutivePos = Integer.valueOf(tmp[1]);
					reqBillBoards = Integer.valueOf(tmp[2]);
					bb.makeArray();
					bb.combination(1, 1, totalBBs-bb.getTotal()+1);
					System.out.println(totalCounts);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	}

	/**
	 * This function prints all the possible combinations of the array. On every
	 * new combination it calls the notify method.
	 * 
	 * @param currentPos
	 * @param start
	 * @param end
	 */
	private void combination(int currentPos, int start, int end) {
		for (int i = start; i <= end; i++) {

			// if condition is for the movement of all the positions but the
			// last position in the array.
			if (end != a.length) {
				if (i != currentPos) {
					a[i - 1] += 1;
					a[currentPos - 1] -= 1;
					currentPos = i;
				}
				combination(currentPos + 1, i + 1, end + 1);
			}
			// else condition is for the movement of the last value in the
			// array.
			else {
				if (i != currentPos) {
					a[i - 1] += 1;
					a[currentPos - 1] -= 1;
					currentPos = i;
				}

				// for(int j =0; j<a.length; j++){
				// System.out.print(a[j]+" ");
				// }
				// System.out.println();
				notify(a);
			}
			// This condition rearranges the array when it is required only.
			if (i == end && start < end) {
				for (int j = start; j < a.length; j++, currentPos++) {
					if (j < a.length && currentPos <= a.length) {
						a[j - 1 + 1] += 1;
						a[currentPos - 1] -= 1;
					}
				}
			}
		}
	}

	
	private void notify(int[] a) {
		checkMinBillBoardInConsecutiveArray(a);
	}

	
	private void checkMinBillBoardInConsecutiveArray(int[] a) {
		int counter = 0;
		for (int i = 1, j = consecutivePos; j <= a.length; i++, j++) {
			counter = 0;
			for (int k = i; k <= j; k++) {
				if (a[k - 1] == 1)
					counter++;
				if (counter == reqBillBoards) {
					break;
				}
			}
			if (counter < reqBillBoards) {
				return;
			}
		}
		totalCounts++;

	}

	private void makeArray() {

		totalCounts = 0;
		
		int totalReqBB = (totalBBs / consecutivePos)*reqBillBoards;
		int tmpRemainder = (totalBBs + reqBillBoards) % consecutivePos;

		if (tmpRemainder > 0 && tmpRemainder < reqBillBoards) {
			totalReqBB += tmpRemainder;
		}
		int[] a = new int[totalBBs];
		for (int i = 0; i < totalReqBB; i++) {
			a[i] = 1;
		}
		BillBoard.a = a; 
		total = totalReqBB;
	}

	
	
	private int getTotal(){
		return total;
	}
}
