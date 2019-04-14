package interviews.amazon;

import java.util.*;

// Apr 2019

/**
 * There are many cities in the network  and all should be connected at minimum possible cost. Following details are given
 * numTotalAvailableCities : Total Cities available
 * numTotalAvailableRoads : Total roads available.
 * roadsAvailable : [1,2] [4,5] i.e. Roads available between 1 -> 2 and 4 -> 5.
 * numNewRoadsConstruct : Maximum no. of roads allowed to construct.
 * costNewRoadsConstruct : [1,3,10] i.e. cost of constructing road between 1 and 3 is 10.
 */
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class ConnectCities {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int getMinimumCostToConstruct(int numTotalAvailableCities,
                                  int numTotalAvailableRoads,
                                  List<List<Integer>> roadsAvailable,
                                  int numNewRoadsConstruct,
                                  List<List<Integer>> costNewRoadsConstruct) {
        int finalCost = 0;
        Set<Integer> totalIsolatedCities = new HashSet<>();
        for (int i = 1; i <= numTotalAvailableCities; i++) {
            totalIsolatedCities.add(i);
        }

        List<Set<Integer>> totalIsolatedNetworks = new ArrayList<>();

        for (List<Integer> l : roadsAvailable) {
            totalIsolatedCities.remove(l.get(0));
            totalIsolatedCities.remove(l.get(1));
            boolean inNetwork = false;
            List<Set<Integer>> commonNetworks = new ArrayList<>();
            for (Set<Integer> network : totalIsolatedNetworks) {
                if (network.contains(l.get(0)) || network.contains(l.get(1))) {
                    commonNetworks.add(network);
                    inNetwork = true;
                }
            }
            if(inNetwork){
                Set<Integer> finalSet = null;
                if(commonNetworks.size() > 1){
                    finalSet = new HashSet<>();
                    commonNetworks.forEach(finalSet::addAll);
                    totalIsolatedNetworks.add(finalSet);
                    totalIsolatedNetworks.removeAll(commonNetworks);
                }
                else{
                    finalSet = commonNetworks.get(0);
                }
                finalSet.add(l.get(0));
                finalSet.add(l.get(1));
            }
            else{
                Set<Integer> tmpH = new HashSet<>();
                tmpH.add(l.get(0));
                tmpH.add(l.get(1));
                totalIsolatedNetworks.add(tmpH);
            }
        }

        totalIsolatedCities.stream().forEach(n -> {
            Set<Integer> t = new HashSet<>();
            t.add(n);
            totalIsolatedNetworks.add(t);
        });

        int tmpNewRoads = 0;

        Set<Integer> s1 = totalIsolatedNetworks.get(0);
        while (totalIsolatedNetworks.size() > 1) {

            boolean constructionPossible = false;
            int tmpCost = Integer.MAX_VALUE;
            Set<Integer> tmpSet = null;
            for (Set<Integer> s2 : totalIsolatedNetworks) {
                if (s1 == s2) continue;
                for (Integer a : s1) {
                    for (Integer b : s2) {
                        for (List<Integer> costList : costNewRoadsConstruct) {
                            if ((costList.get(0) == a && costList.get(1) == b) || (costList.get(0) == b && costList.get(1) == a)) {
                                constructionPossible = true;
                                if (costList.get(2) < tmpCost) {
                                    tmpCost = costList.get(2);
                                    tmpSet = s2;
                                }
                            }
                        }
                    }
                }

            }
            if (constructionPossible) {
                tmpNewRoads++;
                finalCost += tmpCost;
                s1.addAll(tmpSet);
                totalIsolatedNetworks.remove(tmpSet);
            } else return -1;
            constructionPossible = false;
            tmpCost = Integer.MAX_VALUE;
        }

        if (tmpNewRoads > numNewRoadsConstruct) return -1;
        if (finalCost == 0) return -1;
        return finalCost;

    }

    public static void main(String[] args) {
        case1();
        case2();
    }

    private static void case1() {
        List<List<Integer>> roadsAvailable = new ArrayList<>();
        roadsAvailable.add(Arrays.asList(1, 2));
        roadsAvailable.add(Arrays.asList(2, 3));
        roadsAvailable.add(Arrays.asList(4, 5));
        roadsAvailable.add(Arrays.asList(5, 6));

        List<List<Integer>> costNewRoadConstruct = new ArrayList<>();
        costNewRoadConstruct.add(Arrays.asList(1, 5, 110));
        costNewRoadConstruct.add(Arrays.asList(2, 4, 84));
        costNewRoadConstruct.add(Arrays.asList(3, 5, 79));


        System.out.println(new ConnectCities().getMinimumCostToConstruct(6, 4, roadsAvailable, 4, costNewRoadConstruct) == 79);

    }

    private static void case2() {
        List<List<Integer>> roadsAvailable = new ArrayList<>();
        roadsAvailable.add(Arrays.asList(1, 2));
        roadsAvailable.add(Arrays.asList(3, 4));
        roadsAvailable.add(Arrays.asList(1, 4));
        roadsAvailable.add(Arrays.asList(5, 6));

        List<List<Integer>> costNewRoadConstruct = new ArrayList<>();
        costNewRoadConstruct.add(Arrays.asList(1, 5, 110));
        costNewRoadConstruct.add(Arrays.asList(2, 4, 84));
        costNewRoadConstruct.add(Arrays.asList(3, 5, 79));


        System.out.println(new ConnectCities().getMinimumCostToConstruct(6, 4, roadsAvailable, 4, costNewRoadConstruct) == 79);

    }


    //   METHOD SIGNATURE ENDS
}