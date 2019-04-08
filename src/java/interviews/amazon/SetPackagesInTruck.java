package interviews.amazon;

/**
 * There is a truck space and a number of packages. Exactly 2 packages need to be put in truck.
 * After setting the packages, 30 space units should be left in truck.
 * If there are multiple sets of packages then always choose the set which contains biggest package.
 */

import java.util.ArrayList;

public class SetPackagesInTruck {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    ArrayList<Integer> IDsOfPackages(int truckSpace,
                                     ArrayList<Integer> packagesSpace) {
        ArrayList<Integer> finalList = new ArrayList<>();

        int frontCounter = 0;
        int lastCounter = packagesSpace.size() - 1;

        int requiredSize = truckSpace - 30;
        while (frontCounter < lastCounter) {
            if (packagesSpace.get(frontCounter) + packagesSpace.get(lastCounter) == requiredSize) {
                finalList.add(frontCounter);
                finalList.add(lastCounter);
                return finalList;
            } else if (packagesSpace.get(frontCounter) + packagesSpace.get(lastCounter) > requiredSize) lastCounter--;
            else frontCounter++;
        }
        return finalList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(20);
        a.add(70);
        a.add(90);
        a.add(30);
        a.add(60);
        a.add(110);
        System.out.println(new SetPackagesInTruck().IDsOfPackages(110, a));
        ;
    }
    // METHOD SIGNATURE ENDS
}