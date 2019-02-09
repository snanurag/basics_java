package designpractice;

public class  NodeValue<T> {

    public NodeValue(T t){
        this.t = t;
    }
    private T t;

    public T getValue(){
        return t;
    }

    public void setValue(T t){
        this.t = t;
    }

    @Override
    public String toString() {
        return t.toString();
    }
}
