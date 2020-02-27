package inheritance.isarelationship;

public class ISARelationship {

    public static void main(String[] args) {
        Child c = null;
        System.out.println(c instanceof Parent); // false
        System.out.println(c instanceof Child); // false

        Child c2 = new Child();
        System.out.println(c2 instanceof Parent); // true
        System.out.println(c2 instanceof Child); // true

        acceptsParent(c); // No compilation issues
        acceptsParent(c2); // No compilation issues

    }

    private static void acceptsParent(Parent p){

    }
}

interface Parent {

}

class Child implements Parent {

}

