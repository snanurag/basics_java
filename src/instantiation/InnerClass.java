package instantiation;

public class InnerClass
{
	 int t = 0;
	 
	 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		B b = new B();
		C c = new InnerClass().new C();
		c.printClassName();
	}
	
	static class B
	{
		void test()
		{
			//Can't refer instance variable in static class
			System.out.println(t);
		}
	}
	
	class C
	{
		public void printClassName()
		{
			System.out.println("c");
		}
		
	}
	
	class D
	{
		void test()
		{
			B b = new B();
		}
	}
}
