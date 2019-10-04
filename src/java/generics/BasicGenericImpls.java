package generics;

public class BasicGenericImpls {

    public static <T extends String> T max(T t) {
        return t;
    }

    public static void main(String[] args) {
        max(""); // works
//        max(1); // Doesn't work

        Number i = Generic2.get(1);
        System.out.println(i);

        Generic3.setT(1);
//        Generic3.setT(new Object());// doesn't work

        Generic4.setT(0); // <String> is used as generic not class type.
    }

}

// At interface level
interface Generic1<T, U>{
    T get(U u);
    <X> X getX(X x);
}

class Gen1Impl implements Generic1<Integer, String>{
    public Integer get(String s){
        return 0;
    }

    // Since X is not defined anywhere in interface definition, we will have to implement it like this.
    @Override
    public <X> X getX(X x) {
        return null;
    }

    //This implementation won't work for interface generic method getX.
    public Integer getX(Integer i){
        return i;
    }
}

class Generic2{
    static <T, U> T get(U u){

        return (T)u;
    }
}

class Generic3{
    static <T extends Number> void setT(T t) {    //Ensuring that the input is of type Number.
    }
}

class Generic4 {
    static <String> void setT(String t){

    }
}