package inheritance.isarelationship;

public class ISARelationship {

    public static void main(String[] args) {

        // IS-A relation satisfies between interface and class and two classes too.
        // Therefore pefect inheritance.
        Child c = null;
        System.out.println(c instanceof Parent); // false
        System.out.println(c instanceof Child); // false

        Child c2 = new Child();
        System.out.println(c2 instanceof Parent); // true
        System.out.println(c2 instanceof Child); // true

        acceptsParent(c); // No compilation issues
        acceptsParent(c2); // No compilation issues

        acceptsChild(new Child2()); // No compilation issue
    }

    private static void acceptsParent(Parent p){

    }

    private static void acceptsChild(Child c){

    }

}

interface Parent {

}

class Child implements Parent {

}

class Child2 extends Child{

}