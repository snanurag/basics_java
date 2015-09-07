import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test<T extends Number> {

    public static  void main(String[] args) throws IOException {
	Scanner scn = new Scanner(new File("trianglesInput.txt"));

	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
	System.out.println(scn.nextInt());
    }

    private void test(T i)
    {
	List<T> s = new ArrayList<>();
	s.add(i);
    }
}
