package interviews.goldmansachs;

/* Mar 2019 */

/* Problem Name is &&& Optimal Path &&& PLEASE DO NOT REMOVE THIS LINE. */

/*
 ** Instructions to candidate.
 **  1) You are an avid rock collector who lives in southern California. Some rare
 **     and desirable rocks just became available in New York, so you are planning
 **     a cross-country road trip. There are several other rare rocks that you could
 **     pick up along the way.
 **
 **     You have been given a grid filled with numbers, representing the number of
 **     rare rocks available in various cities across the country.  Your objective
 **     is to find the optimal path from So_Cal to New_York that would allow you to
 **     accumulate the most rocks along the way.
 **
 **     Note: You can only travel either north (up) or east (right).
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement optimalPath() correctly.
 **  4) Here is an example:
 **                                                           ^
 **                 {{0,0,0,0,5}, New_York (finish)           N
 **                  {0,1,1,1,0},                         < W   E >
 **   So_Cal (start) {2,0,0,0,0}}                             S
 **                                                           v
 **   The total for this example would be 10 (2+0+1+1+1+0+5).
 */

class MaxRockCollection
{
    private static Integer max = 0;
    /*
     **  Find the optimal path.
     */
    public static Integer optimalPath(Integer[][] grid)
    {
        if(grid == null)
            return 0;
        if(grid[0] == null)
            return 0;

        int rows = grid.length-1;
        move(grid,true, rows, 0, 0);
        move(grid,false, rows, 0, 0);
        return max + grid[rows][0];
    }

    private static Integer move(Integer[][] grid, boolean up, int r, int h, int total){
        if(up)
            r--;

        else h++;
        int temp = max;
        if(r >=0 && h < grid[0].length){
            total += grid[r][h];

            temp = move(grid, true, r, h, total);
            if( temp > max) max = temp;

            temp = move(grid, false, r, h, total);
            if( temp > max) max = temp;
            return temp;
        }
        else
            return total;
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass()
    {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]{{0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}}) == 10;
        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}
