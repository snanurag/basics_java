package interviews.paypal;

import java.util.*;

public class FindTargetSum {

    //1,3,4,5,6,8,12

    // 1 -> 12
    // 1, 3, 4, ->5
    public static List<List<Integer>> allPossibleSum(List<Integer> arr, int target) {
        Collections.sort(arr);
        Set<Integer> set = new HashSet<>();
        arr.forEach(a -> set.add(a));
        List<List<Integer>> finalList = new ArrayList<>();
        calculate(arr, new ArrayList<>(), 0, 0, target, set, finalList);
        return finalList;
    }

    /**
     * This method considers the selected elements coming in selectedList and takes next pointer and next +1 pointer and does the recursion.
     * <p>
     * e.g. In 1,3,4,5,6,8,12, if 1 is coming as already chosen numbers and pointer is at 4. Then it will take sum of 1+4 = 5 and search for 8 (13-5) in set.
     * After that it will do recursion with 1,4 as chosen and pointer at 5 and also 1 as chosen and pointer at 5. This way it covers all possible combinations.
     *
     * @param originalList
     * @param selectedList The elements we have already selected and looking for new ones.
     * @param pointer
     * @param sum
     * @param target
     * @param set
     * @param finalList
     */
    private static void calculate(List<Integer> originalList, List<Integer> selectedList, int pointer, int sum, int target, Set<Integer> set, List<List<Integer>> finalList) {
        if (pointer < originalList.size()) {
            sum += originalList.get(pointer);
            selectedList.add(originalList.get(pointer));
            int newNum = target - sum;
            if (++pointer >= originalList.size() || newNum < originalList.get(pointer))
                return;
            if (set.contains(newNum)) {
                List<Integer> tmpList = new ArrayList<>();
                tmpList.addAll(selectedList);
                tmpList.add(newNum);
                finalList.add(tmpList);
            }
            calculate(originalList, new ArrayList<>(selectedList), pointer, sum, target, set, finalList);
            sum -= selectedList.remove(selectedList.size() - 1);
            calculate(originalList, new ArrayList<>(selectedList), pointer, sum, target, set, finalList);
        }
    }

    public static void main(String[] args) {
        System.out.println(allPossibleSum(Arrays.asList(4, 5, 6, 3, 12, 8, 1), 13));
    }
}
