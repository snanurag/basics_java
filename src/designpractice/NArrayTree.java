package designpractice;

public class NArrayTree implements INArrayTree {

    NodeValue v;
    INArrayTree[] arrayTrees;

    public NArrayTree(INArrayTree[] array, NodeValue v) {
        arrayTrees = array;
        this.v = v;
    }

    @Override
    public INArrayTree[] getChildTrees() {
        return arrayTrees;
    }

    @Override
    public NodeValue getValue() {
        return v;
    }
}
