package lambda;

@FunctionalInterface
interface MyInterface2{
    Hello display(String say);
}
class Hello{
    public Hello(String say){
        System.out.print(say);
    }
}
