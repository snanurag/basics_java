package algopractice;

public class StealingMangos {

    static int stealMangoes(int[] num) {
	
	if(num.length == 0)
	    return 0;
	
	if(num.length == 1)
	    return num[0];
	
	if(num.length == 2)
	    return num[0] > num[1] ? num[0]:num[1];
	
	int[] sum = new int[num.length];
	
	
	for(int i=0; i<num.length; i++)
	{
	    if(i>2)
	    {
		    if(sum[i-2]> sum[i-3])
			sum[i] = sum[i-2] + num[i];
		    else
			sum[i] = sum[i-3] + num[i];
	    }
	    else
	    {
		sum[0] = num[0];
		sum[1] = num[1];
		sum[2] = num[0] + num[2];
	    }
	    
	}
	
	return sum[num.length-1] > sum[num.length - 2] ? sum[num.length-1] :sum[num.length-2]; 

    }
}
