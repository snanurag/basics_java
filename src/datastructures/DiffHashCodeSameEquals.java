package datastructures;

import java.util.HashSet;

public class DiffHashCodeSameEquals {

    public static void main(String[] args) {
	A a = new A();
	B b = new B();
	HashSet set = new HashSet();
	set.add(a);
	set.add(b);
	System.out.println(set.size());
    }
    
}

class A
{
    public int hashCode() 
    {
	return 15;
    }
    
    public boolean equals(Object o)
    {
	return true;
    }

}

class B
{
    public int hashCode()
    {
	return 31;
    }
    
    public boolean equals(Object o)
    {
	return true;
    }
}