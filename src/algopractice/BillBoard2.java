package algopractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BillBoard2 {

	private static int total = 4;
	private static String filePath = "BB.txt";
	private static int m = 7;
	private static int k = 2;
	private static int totalCounts = 0;
	private static int n = 19;
	
	
	public static void main(String[] args) {

		/**
		 * c = 3, e = 5, s = 3
		 * 
		 * 3 c=4, s=4 4 c=4, s=5 5 c=4, s=6
		 */

		BillBoard bb = new BillBoard();
		// int currentPos = total;
		System.out.println(totalCombinations()- withdrawalCombinations());


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
					n = Integer.valueOf(tmp[0]);
					m = Integer.valueOf(tmp[1]);
					k = Integer.valueOf(tmp[2]);
					makeArray();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	}
	
	private static int withdrawalCombinations() {
	
		int wrongCombinations = 0;	
	
		if(k>=2)
			wrongCombinations = (factorial(m-1)/(factorial(k-2)*factorial(m-1-(k-2)))) * (factorial(n-(m+1)+1)/(factorial(total-k)*factorial((n-total)-((m+1)-k))));
		
		if(m-(k-1)>1)
			wrongCombinations += (factorial(m-2)/(factorial(k-1)*factorial((m-2)-(k-1)))) * (factorial(n-m+1)/(factorial(total-(k-1))*factorial((n-total)-(m-(k-1)))));
		
		if(m-(k-1)>0)
			wrongCombinations +=  (factorial(m-1)/(factorial(k-1)*factorial((m-1)-(k-1)))) * (factorial(n-m)/(factorial(total-(k-1))*factorial((n-total)-(m-(k-1)))));
			
		return wrongCombinations;
	}
	
	private static int totalCombinations(){
		return factorial(n)/(factorial(total)*factorial(n-total));
	}
	
	private static void makeArray() {

		totalCounts = 0;
		
		int totalReqBB = (n / m)*k;
		int tmpRemainder = (n + k) % m;

		if (tmpRemainder > 0 && tmpRemainder < k) {
			totalReqBB += tmpRemainder;
		}

		total = totalReqBB;
	}

	private static int factorial(int n){
		
		if(n<=1)
			return 1;
		else
			return n*factorial(n-1);

	}


}
