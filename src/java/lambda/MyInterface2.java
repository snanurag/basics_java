package lambda;

@FunctionalInterface
interface MyInterface2 {
    public int i = 0;
    void display(String say);
}

class Hello {
    public Hello(String say) {
        System.out.println("This is from constructor");
        System.out.print(say);
    }
}
