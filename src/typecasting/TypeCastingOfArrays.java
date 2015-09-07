package typecasting;

import java.util.ArrayList;
import java.util.List;

public class TypeCastingOfArrays {

    static Number[] n = new Integer[3]; // This is covarience. It is present in
					// arrays only.

    Number[] m = new Object[5];

    Object[] o = new String[9];

    public static void main(String[] args) {
	if (n instanceof Number[]) {

	}

	TypeCastingOfArrays t = new TypeCastingOfArrays();
	
	t.method1(new ArrayList<String>());
    }

    public <E> E method1(List<E> l) {
	E[] e = (E[]) l.toArray();
	return e[0];
    }
}
