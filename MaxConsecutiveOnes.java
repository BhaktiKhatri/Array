package Array;

/**
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/discuss/
 * Given a binary array, find the maximum number of consecutive 1s in this array. The input array will only contain 0 and 1.
 * @author NisuBhakti
 *
 */
public class MaxConsecutiveOnes {

	//The idea is to reset maxHere to 0 if we see 0, otherwise increase maxHere by 1. The max of all maxHere is the solution
	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxHere = 0, max = 0;
		for(int n: nums) {
			max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = {1,1,0,1,1,1};
		System.out.println("ans: "+MaxConsecutiveOnes.findMaxConsecutiveOnes(arr));
	}

}
