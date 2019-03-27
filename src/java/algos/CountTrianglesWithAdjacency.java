package algos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 1 1 1 1 2 3 1 0 0 1 1 0 0 1 1 1 1 1 1 4
 *
 * @author ashrinagar
 */
public class CountTrianglesWithAdjacency {

    static int Dir1, Dir2, Dir3, Dir4 = 0;

    static int x1, y1, x2, y2, x3, y3 = 0;

    static int[][] Board = new int[501][501];
    static int[][] Board2 = new int[501][501];
    static int N;

    public static void main(String[] args) throws FileNotFoundException {
        ;

        Scanner scn = new Scanner(new File("trianglesInput.txt"));
        N = scn.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Board[i][j] = scn.nextInt();
                Board2[i][j] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                checkTriangle(i, j);
            }
        }

        System.out.println(Dir1 + " " + Dir2 + " " + Dir3 + " " + Dir4);

    }

    private static boolean checkTriangle(int i, int j) {

        if (eligiblePt(i, j)) {

            int[] cordy2 = {j - 1, j + 1};

            for (int y2 : cordy2) {
                if (eligiblePt(i, y2)) {

                    int[] cordx3 = {i - 1, i + 1};

                    for (int x3 : cordx3) {

                        int[] cordy3 = {y2, j};

                        for (int y3 : cordy3) {
                            if (eligiblePt(x3, y3)) {
                                if (CountTrianglesWithAdjacency.x1 == 0) {
                                    setTemTri(i, j, i, y2, x3, y3);
                                    if (checkAllNeighbors(i, j, i, y2, x3, y3)) {
                                        fixTriangle();
                                    }
                                    emptyTriangle();
                                } else {
                                    fixNeighborTriangle(i, j, i, y2, x3, y3);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }

            int[] cordx2 = {i - 1, i + 1};

            for (int x2 : cordx2) {
                if (eligiblePt(x2, j)) {

                    int x3 = x2;

                    int[] cordy3 = {j - 1, j + 1};

                    for (int y3 : cordy3) {
                        if (eligiblePt(x3, y3)) {
                            if (CountTrianglesWithAdjacency.x1 == 0) {
                                setTemTri(i, j, x2, j, x3, y3);
                                if (checkAllNeighbors(i, j, x2, j, x3, y3)) {
                                    fixTriangle();
                                }
                                emptyTriangle();
                            } else {
                                fixNeighborTriangle(i, j, x2, j, x3, y3);
                                return true;
                            }
                        }
                    }

                }
            }

        }

        return false;
    }

    private static boolean checkAllNeighbors(int x1, int y1, int x2, int y2,
                                             int x3, int y3) {

        return emptyNeighbors(x1, y1, x2, y2, x3, y3)
                || (checkTempNeighbors(x1, y1) || checkTempNeighbors(x2, y2) || checkTempNeighbors(
                x3, y3));
    }

    private static boolean eligiblePt(int i, int j) {
        if (i == 2 && j == 3) {
            System.out.println("");
        }
        return (i >= 1 && i <= N && j >= 1 && j <= N
                && !pointOccupiedByTempTri(i, j) && Board2[i][j] == 0 && Board[i][j] == 1);

    }

    private static void emptyTriangle() {
        x1 = 0;
        x2 = 0;
        x3 = 0;
        y1 = 0;
        y2 = 0;
        y3 = 0;
    }

    private static boolean pointOccupiedByTempTri(int i, int j) {
        if (i == x1 && j == y1 || i == x2 && j == y2 || i == x3 && j == y3) {
            return true;
        }

        return false;
    }

    private static void setTemTri(int x1, int y1, int x2, int y2, int x3, int y3) {
        CountTrianglesWithAdjacency.x1 = x1;
        CountTrianglesWithAdjacency.x2 = x2;
        CountTrianglesWithAdjacency.x3 = x3;
        CountTrianglesWithAdjacency.y1 = y1;
        CountTrianglesWithAdjacency.y2 = y2;
        CountTrianglesWithAdjacency.y3 = y3;

    }

    private static boolean checkTempNeighbors(int i, int j) {
        /*
         * i-1,j i+1,j i,j-1 i,j+1
         */
        return (checkTriangle(i - 1, j) || checkTriangle(i + 1, j)
                || checkTriangle(i, j - 1) || checkTriangle(i, j + 1));

    }

    private static void fixNeighborTriangle(int x1, int y1, int x2, int y2,
                                            int x3, int y3) {

        Board2[x1][y1] = 1;
        Board2[x2][y2] = 1;
        Board2[x3][y3] = 1;

        increaseDirectionCount(x1, y1, x2, y2, x3, y3);
    }

    private static void fixTriangle() {

        Board2[x1][y1] = 1;
        Board2[x2][y2] = 1;
        Board2[x3][y3] = 1;

        increaseDirectionCount(x1, y1, x2, y2, x3, y3);
    }

    private static boolean emptyNeighbors(int x1, int y1, int x2, int y2,
                                          int x3, int y3) {
        /*
         * i-1,j i+1,j i,j-1 i,j+1
         */
        return emptyNeighbor(x1, y1) && emptyNeighbor(x2, y2)
                && emptyNeighbor(x3, y3);

    }

    private static boolean emptyNeighbor(int i, int j) {
        return (!eligiblePt(i - 1, j) && !eligiblePt(i + 1, j)
                && !eligiblePt(i, j - 1) && !eligiblePt(i, j + 1));
    }

    private static void increaseDirectionCount(int x1, int y1, int x2, int y2,
                                               int x3, int y3) {

        int rtX, rtY = 0;

        if (x1 == x2 || x1 == x3)
            rtX = x1;
        else
            rtX = x2;

        if (y1 == y2 || y1 == y3)
            rtY = y1;
        else
            rtY = y2;

        if (x1 <= rtX && x2 <= rtX && x3 <= rtX) {
            if (y1 <= rtY && y2 <= rtY && y3 <= rtY) {
                Dir4++;

            } else {
                Dir1++;
            }

        } else {
            if (y1 <= rtY && y2 <= rtY && y3 <= rtY) {
                Dir3++;
            } else {
                Dir2++;
            }

        }

    }
}
