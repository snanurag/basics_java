package lambda;

@FunctionalInterface
interface MyInterface {
    void display();

//Compile time error disabling it.
//    void display(String s);

}