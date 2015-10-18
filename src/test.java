public class test
{
	static int n;
	static int[] s = { 0,0,1,1};

	static int pointer = 0;
	static
	{
		n = s.length;
		pointer = n - 1;
	}

	// static String str = "";

	public static void main(String[] args)
	{
		int temp = n - 1;
		iteration(temp);

		while (pointer > -1)
		{
			if (pointer > n - 1)
			{
				System.out.println("no position");
				break;
			}
			else if (s[pointer] == 1)
			{
				if (pointer == 0)
				{
					System.out.println(pointer);
					break;

				}
				else if (s[pointer - 1] == 0)
				{
					System.out.println(pointer);
					break;
				}
				else
					pointer--;
			}
			else if (s[pointer] == 0)
			{
				if(pointer == n-1)
				{
					System.out.println("no position");
					break;
				}
				if (s[pointer + 1] == 1)
				{
					System.out.println(pointer + 1);
					break;
				}
				else
					pointer++;
			}
		}
	}

	private static void iteration(int temp)
	{
		if (pointer > n - 1 || temp - temp / 2 <= 1)
		{
			// System.out.println(n-1);
			return;
		}

		if (s[pointer] == 1)
		{
			pointer = pointer - temp / 2;
		}
		else if (s[pointer] == 0)
		{
			pointer = pointer + temp / 2;
		}

		iteration(temp / 2);
	}

}
