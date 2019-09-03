package Array;

/**
 * Leetcode 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/solution/
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed). 
 * Once you pay the cost, you can either climb one or two steps. 
 * You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * @author NisuBhakti
 * Time Complexity: O(N) where N is the length of cost. Space Complexity: O(1), the space used by f1, f2.
 */

public class MinCostClimbingStairs {

	/**
	 * There is a clear recursion available: the final cost f[i] to climb the staircase from some step i is f[i] = cost[i] + min(f[i+1], f[i+2]). 
	 * This motivates dynamic programming. Algorithm:
	 * Let's evaluate f backwards in order. That way, when we are deciding what f[i] will be, we've already figured out f[i+1] and f[i+2].
	 * We can do even better than that. At the i-th step, let f1, f2 be the old value of f[i+1], f[i+2], and update them to be the new values f[i], f[i+1]. 
	 * We keep these updated as we iterate through i backwards. At the end, we want min(f1, f2)
	 * @param cost: cost array of steps
	 * @return: minimum cost to reach the top of the floor
	 */
	
	public static int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i=cost.length-1; i>=0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            System.out.println("f1: "+f1+" f2: "+f2+" cost[i]: "+cost[i]+" f0: "+f0);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(arr));
	}

}
