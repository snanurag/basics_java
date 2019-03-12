package designpractice;

public class NodeValue<T> {

    private T t;

    public NodeValue(T t) {
        this.t = t;
    }

    public T getValue() {
        return t;
    }

    public void setValue(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return t.toString();
    }
}
