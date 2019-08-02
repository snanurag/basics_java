package inheritance.innerpkg2;

import inheritance.inner.Interface4;
import inheritance.inner.ParentA;
import inheritance.inner.ParentB;

public class CallingClass {

    public static void main(String[] args) {
        Interface4 i = new ParentA();
        i.printDefault();

        ParentA a = new ParentA();
        a.printDefault();
    }

}
