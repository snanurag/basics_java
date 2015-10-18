package algopractice;

public class FlipkartPrintBracketsPNC
{
	static int n = 5;

//	static Stack<String> s = new Stack<String>();

	static String[] s = new String[2*n];
	static String str = "";

	public static void main(String[] args)
	{
		for(int i=0; i< s.length; i++)
		{
			if(i%2 ==0)
				s[i] = "(";
			else
				s[i] = ")";
		}
		
		printStack(n);
	}
	
	private static void printStack(int x)
	{
		if(s[2*x-1] == ")" && s[2*x-2] == "(")
		{
			s[2*x-1] = null;
			s[2*x-2] = null;
		}
		else
			return;
		
		for(int i=0; i<x-1; i++)
		{
				s[2*i] = s[2*i]+"(";
				s[2*i+1] = s[2*i+1]+")";
				
			
			for(String t:s)
			{
				if(t!=null)
					System.out.print(t);
			}
			System.out.println();
			
			printStack(x-1);
			
			s[2*i] = s[2*i].substring(0, s[2*i].lastIndexOf("("));
			s[2*i+1] = s[2*i+1].substring(0, s[2*i+1].lastIndexOf(")"));

		}
	
		s[2*x-1] = ")";
		s[2*x-2] = "(";
		
//		for(String t:s)
//		{
//			if(t!=null)
//				System.out.print(t);
//		}
	
		
	}


}
