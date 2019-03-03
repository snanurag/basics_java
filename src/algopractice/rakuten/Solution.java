package algopractice.rakuten;


class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{4, 5, 2, 5, 4}));
        System.out.println(s.solution(new int[]{4, 5, 2, 3, 4}));
        System.out.println(s.solution(new int[]{4, 5, 4, 3}));
        System.out.println(s.solution(new int[]{3, 4, 5, 4, 4, 4}));
        System.out.println(s.solution(new int[]{4, 6, 5, 5, 6}));
        System.out.println(s.solution(new int[]{3, 4, 5, 4}));
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5}));

    }

    /**
     * There is a series of trees for different height e.g. {3,4,5,4}.
     * You have to cut exactly one tree and create a non-decreasing series.
     * Return the total number of ways.
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int tree_1 = 0;
        int tree_2 = 0;
        int tree_3 = 0;

        if (A.length == 1) return 1;
        if (A.length == 2) return 2;

        boolean cut_3 = false;
        boolean cut_2 = false;
        boolean treeCutReq = false;
        int tree_2_H = 0;
        int tree_3_H = 0;
        for (int newTree : A) {
            tree_1 = tree_2;
            tree_2 = tree_3;
            tree_3 = newTree;

            if (!treeCutReq && tree_3 < tree_2) {
                treeCutReq = true;
                //3rd tree is cut
                tree_2_H = tree_2;
                cut_3 = true;
                if (tree_3 >= tree_1) {
                    //2nd tree is cut
                    tree_3_H = tree_3;
                    cut_2 = true;
                }
                continue;
            }

            if (newTree < tree_3_H) return 0;
            if (newTree < tree_2_H) cut_3 = false;
        }
        if (cut_2 && cut_3) return 2;
        if (cut_2) return 1;

        if (treeCutReq) return 0;
        else return A.length;
    }
}
