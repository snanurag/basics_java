package interview_skeletons;

import java.util.ArrayList;
import java.util.List;

/**
 *  save the entries in file and read them in tree format.
 */
class Tree{
    List<Tree> list;
    String val;

    Tree(String val){
        this.val = val;
    }
}
public class StoringTreeInFile {
    /**
     *                           Wo
     *       US                    IN                       PAK EN
     *     NY    CA   TX     KA        MP DEL
     * BR QU LI             BLR MY
     *
     */

    public static void main(String[] args) {

        Tree t = new Tree("Wo");
        List<Tree> l = new ArrayList<>();
        l.add(new Tree("US"));
        l.add(new Tree("PAK"));
        l.add(new Tree("EN"));
        l.add(new Tree("IN"));
        t.list = l;

        Tree tUS = l.get(0);
        Tree tIN = l.get(3);
        l = new ArrayList<>();
        l.add(new Tree("NY"));
        l.add(new Tree("CA"));
        l.add(new Tree("TX"));
        l.add(new Tree("CO"));
        tUS.list = l;

        l = new ArrayList<>();
        l.add(new Tree("KA"));
        l.add(new Tree("DEL"));
        l.add(new Tree("MP"));
        tIN.list = l;

        System.out.println(getTree(t));
    }

    private static String getTree(Tree t){
        return null;
    }
}


