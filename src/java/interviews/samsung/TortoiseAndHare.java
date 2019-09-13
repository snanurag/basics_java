package interviews.samsung;

import java.util.*;

public class TortoiseAndHare {

    static int N = 0;
    static int minRoads = 0;
    static Map<Integer, List<Integer>> roadNetwork = new HashMap<>();
    static int[][][] netwithVal = null;
    static int finalNetLen = 0;
    static int finalMargin = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  line1 = scanner.nextLine();
         N = Integer.parseInt(line1.split(" ")[0]);
         int M = Integer.parseInt(line1.split(" ")[1]);
        int tmpRoads = M;

        netwithVal = new int[N+1][N+1][2];
        finalNetLen = M;

        StringBuffer buff = new StringBuffer();
        while(tmpRoads-- > 0){
            String tmpLine = scanner.nextLine();
            String[] tmpstrArr = tmpLine.split(" ");
            int roadStart = Integer.parseInt(tmpstrArr[0]);
            int roadEnd = Integer.parseInt(tmpstrArr[1]);
            int tSpeed = Integer.parseInt(tmpstrArr[2]);
            int hSpeed = Integer.parseInt(tmpstrArr[3]);
            netwithVal[roadStart][roadEnd][0] = tSpeed;
            netwithVal[roadStart][roadEnd][1] = hSpeed;
            if(!roadNetwork.containsKey(roadStart))
                roadNetwork.put(roadStart, new ArrayList<>());
            roadNetwork.get(roadStart).add(roadEnd);
        }
        scanner.close();
        m();
        System.out.println(finalNetLen-1 +" "+finalMargin);
    }

    private static void m() {
        for (int i = 1; i <= N; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(i);
            m2(i, i, l);
        }
    }

    private static void m2(int start, int end, List<Integer> tmpNetwork) {
        if (tmpNetwork.size() == finalNetLen) return;

        if (!roadNetwork.containsKey(start)) return;

        for (int l : roadNetwork.get(start)) {
            if (netwithVal[start][l][0] < netwithVal[start][l][1]) {
                if(l != end && tmpNetwork.contains(l)) return;
                tmpNetwork.add(l);
                if (l == end) {
                    if (finalNetLen > tmpNetwork.size() ) {
                        finalNetLen = tmpNetwork.size();
                        finalMargin = getMargin(tmpNetwork);
                    } else if (finalNetLen == tmpNetwork.size()) {
                        int tmpMargin = getMargin(tmpNetwork);
                        if (finalMargin < tmpMargin) {
                            finalNetLen = tmpNetwork.size();
                            finalMargin = tmpMargin;
                        }
                    }
                }
                else {
                    m2(l, end, tmpNetwork);
                    tmpNetwork.remove(new Integer(l));
                }
            }
            else return;
        }

    }

    private static int getMargin(List<Integer> tmpNetwork) {
        int val = 0;
        for(int i=0; i< tmpNetwork.size()-1; i++){
            val += netwithVal[tmpNetwork.get(i)][tmpNetwork.get(i+1)][1] - netwithVal[tmpNetwork.get(i)][tmpNetwork.get(i+1)][0];
        }
        return val;
    }
}
