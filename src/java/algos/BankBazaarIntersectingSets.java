package algos;

public class BankBazaarIntersectingSets {

    // sorted set of Input tuples
    private static final Tuple[] sortedInputSets = {new Tuple(1, 10), new Tuple(5, 15), new Tuple(11, 20), new Tuple(11, 35),
            new Tuple(11, 12), new Tuple(11, 15), new Tuple(11, 11), new Tuple(13, 20)};

    // Number of sets
    private static int N;
    /**
     * value : 11 --> 12 --> 16 --> 21 --> 36
     * count : 6 --> 5 --> 4 --> 2 --> 0
     */

    private static int highestRank = 0;

    static {
        N = sortedInputSets.length;
    }

    public static void main(String[] args) {
        NodeTuple holder = new NodeTuple(null, null, sortedInputSets[0].x);

        for (int j = 0; j < N; j++) {
            // Operations on x

            // This while loop will move the holder ahead and find the correct position to insert new node.
            while (holder.next != null && holder.next.value <= sortedInputSets[j].x) {
                if (holder.next.count == 0) {
                    removeNodeFromList(holder.next);
                } else {
                    holder = holder.next;
                }
            }

            if (holder.value != sortedInputSets[j].x) {
                holder = insertNewNodeAftern(holder, sortedInputSets[j].x, holder.count + 1);
            } else {
                holder.count++;
                holder = mergePreOrNextOfSameRank(holder);
            }

            // Operations on y
            // Till y it is included in the previous holder that is why we are doing operations on y+1.
            if (sortedInputSets[j].y + 1 > holder.value) {
                NodeTuple temp = holder;
                while (temp.next != null && temp.next.value <= sortedInputSets[j].y + 1) {
                    temp = temp.next;
                    if (temp.value <= sortedInputSets[j].y)
                        temp.count++;
                }

                if (temp.value != sortedInputSets[j].y + 1) {
                    insertNewNodeAftern(temp, sortedInputSets[j].y + 1, temp.count - 1);
                }
            }

            // Modify highest rank if required
            if (holder.count > highestRank) {
                highestRank = holder.count;
            }

            deletePreviousNodesThanHolderOfCountLowerThanHighestRank(holder);

        }
        printFinalAnswer(holder);

    }

    /**
     * Merge left and right nodes of the provided nodes if they have the same count as of this.
     *
     * @param node
     * @return
     */
    private static NodeTuple mergePreOrNextOfSameRank(NodeTuple node) {
        if (node.previous != null && node.previous.count == node.count) {
            NodeTuple temp = node.previous;
            removeNodeFromList(node);
            return temp;
        }
        if (node.next != null && node.count == node.next.count) {
            removeNodeFromList(node.next);
        }
        return node;
    }

    /**
     * This function will remove node n from its linkedlist.
     *
     * @param n
     */
    private static void removeNodeFromList(NodeTuple n) {
        if (n != null) {
            NodeTuple prevNode = n.previous;
            if (prevNode != null) {
                prevNode.next = n.next;
                if (n.next != null)
                    n.next.previous = prevNode;
            } else {
                n.next.previous = null;
            }
        }
    }

    /**
     * Inserts a new node of value and count after node n.
     *
     * @param n
     * @param value
     * @param count
     * @return
     */
    private static NodeTuple insertNewNodeAftern(NodeTuple n, int value, int count) {
        NodeTuple newNode = new NodeTuple(n, n.next, value);
        NodeTuple temp = n.next;
        n.next = newNode;

        if (temp != null)
            temp.previous = newNode;
        newNode.previous = n;
        newNode.next = temp;
        newNode.count = count;
        return newNode;
    }

    /**
     * Deletes all previous nodes of temp node having lesser rank than Highest rank.
     *
     * @param temp
     */
    private static void deletePreviousNodesThanHolderOfCountLowerThanHighestRank(NodeTuple temp) {
        while (temp.previous != null) {
            temp = temp.previous;
            if (temp.count < highestRank) {
                NodeTuple temp2 = temp.previous;
                removeNodeFromList(temp);
                temp = temp2;
                if (temp == null)
                    break;
            }
        }

    }

    /**
     * This function would find the start node of the LinkedList first then would do the traversal and print the tuple of
     * highest rank
     *
     * @param holder
     */
    private static void printFinalAnswer(NodeTuple holder) {
        NodeTuple startNode = null;

        while (holder.previous != null) {
            holder = holder.previous;
        }

        startNode = holder;

        while (holder.next != null) {
            if (holder.count == highestRank) {
                System.out.println("Tuple would be " + holder.value + "," + (holder.next.value - 1));
                break;
            }

            holder = holder.next;
        }

        System.out.println("Highest Rank is : " + highestRank);

    }

    // Input type of class
    static class Tuple {
        int x;
        int y;

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // My working class

    /**
     * This class would be used to make a LinkedList. previous and next are the pointers to previous and next nodes
     * respectively. value will store the values of x and y. count is the occurance of every integer from this value to the
     * value of next node.
     *
     * @author ashrinagar
     */
    static class NodeTuple {
        NodeTuple previous;
        NodeTuple next;
        int value;
        int count = 0;

        public NodeTuple(NodeTuple previous, NodeTuple next, int pointer) {
            this.previous = previous;
            this.next = next;
            this.value = pointer;
        }

    }
}
