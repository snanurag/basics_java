package designpractice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The problem is that you are given a tree. Like this
 * A
 * B      C
 * D    E      F
 * <p>
 * Now you are supposed to do a zigzag traversal and print elements. The output should be
 * <p>
 * A
 * CB
 * DEF
 */

public class TerracottaZigZagTreeTraversasl {
    List<List<NodeValue>> traversalList = new LinkedList<>();

    public static void main(String[] args) {
        INArrayTree n = new INArrayTree() {
            @Override
            public INArrayTree[] getChildTrees() {
                return new INArrayTree[0];
            }

            @Override
            public NodeValue getValue() {
                return null;
            }
        };
        NodeValue<String> A = new NodeValue<>("A");
        NodeValue<String> B = new NodeValue<>("B");
        NodeValue<String> C = new NodeValue<>("C");
        NodeValue<String> D = new NodeValue<>("D");
        NodeValue<String> E = new NodeValue<>("E");
        NodeValue<String> F = new NodeValue<>("F");
        NArrayTree _F = new NArrayTree(null, F);
        NArrayTree _E = new NArrayTree(null, E);
        NArrayTree _D = new NArrayTree(null, D);
        NArrayTree _C = new NArrayTree(new INArrayTree[]{_F}, C);
        NArrayTree _B = new NArrayTree(new INArrayTree[]{_D, _E}, B);
        NArrayTree _A = new NArrayTree(new INArrayTree[]{_B, _C}, A);
        new TerracottaZigZagTreeTraversasl().treeTraversalZigZag(_A);
    }

    public void treeTraversalZigZag(INArrayTree n) {
        visitNode(n, 0);

        for (int i = 0; i < traversalList.size(); i++) {
            List<NodeValue> l = traversalList.get(i);
            if (i % 2 == 1) Collections.reverse(l);
            l.forEach(System.out::print);
            System.out.println();

        }
    }

    void visitNode(INArrayTree n, int depth) {

        if (n == null) return;

        List<NodeValue> l;

        if (traversalList.size() < depth + 1) {
            l = new LinkedList();
            traversalList.add(l);
        } else l = traversalList.get(depth);

        l.add(n.getValue());

        INArrayTree[] treechildren = n.getChildTrees();
        if (treechildren == null) return;
        for (INArrayTree e : treechildren) {
            visitNode(e, depth + 1);
        }
    }

}
