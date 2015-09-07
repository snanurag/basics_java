package interviews.nextag;

import java.io.File;
import java.io.FileWriter;

public class ExampleRevisited2ndTime {

	private int[] a1;
	private int[] pos;	
	public void shuffle(int n, int cut) {
		int totalDivisors = (n*20)/100 ;
		pos = new int[totalDivisors];
		
		if(n<=cut){
			throw new IllegalArgumentException("Deck size should be more than the cut size.");
		}
		initialize(n);
		rearrange(n, cut);
	}
	
	private void initialize(int n){
		
		for(int i=0;i<pos.length;i++){
				pos[i] =i;
		}
		a1 = pos.clone();
	}
	
	private void rearrange(int n, int cut){
		double counter = 0;
		long time = System.currentTimeMillis();
		outer: while(true){
			counter++;
			for(int m = 0; m<a1.length; m++){
				if(a1[m]<cut){
					a1[m] =  n + 2*a1[m] + 1 - 2*cut;	//n - (2*(cut - m) -1)
				}
				else if(n-cut-1 < a1[m]  && a1[m] < n){
					a1[m] = 2*a1[m] - n;	//n - 2*(n-m) 
				}
				else{
					a1[m] = a1[m] - cut;
				}
			}
			
			for(int i=0; i<a1.length; i++){
				if(a1[i] != pos[i]){
					break;
				}
				if(i == a1.length-1){
					try {
						File f = new File("output3.txt");
						FileWriter fw = new FileWriter(f);
						fw.write("\n");
						fw.write("No of times " + counter);
						time = System.currentTimeMillis() - time;
						fw.write("\n");
						fw.write("Total time "+time);
						fw.flush();
						fw.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					System.out.println("Total no. of counts "+counter);
					break outer;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		ExampleRevisited2ndTime er = new ExampleRevisited2ndTime();
		
		er.shuffle(500, 250);
	}
}
