package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Find a triplet that sum to a given value
 * @author NisuBhakti
 * Time Complexity: O(N^2)
 */

public class ThreeSumToNumber {

	public static List<List<Integer>> threeSum(int[] nums, int sum) {
		List<List<Integer>> result = new LinkedList<>();
		
		for(int i=0; i<nums.length-1; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int low = i+1;
				int high = nums.length-1;
				
				while(low < high) {
					if(nums[i] + nums[low] + nums[high] == sum) {
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while(low < high && nums[low] == nums[low+1])
							low++;
						while(low < high && nums[high] == nums[high-1])
							high--;
						low++;
						high--;
					}
					else if(nums[i] + nums[low] + nums[high] < sum)
						low++;
					else
						high--;
				}
			}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4, 5, 6};
		System.out.println(threeSum(arr,9));
	}

}
