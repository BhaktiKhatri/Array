package Array;

/**
 * Leetcode 495. Teemo Attacking
 * https://leetcode.com/problems/teemo-attacking/description/
 * Code from https://leetcode.com/problems/teemo-attacking/discuss/97475
 * @author NisuBhakti
 * Time Complexity: O(N)
 */

public class TeemoAttacking {

	public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = duration * timeSeries.length;
        for(int i=1; i< timeSeries.length; i++) {
        	ans = ans - Math.max(0, duration - (timeSeries[i] - timeSeries[i-1]));	
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] timeSeries = {1,4};
		int duration = 2;
		System.out.println(findPoisonedDuration(timeSeries, duration));
	}

}
