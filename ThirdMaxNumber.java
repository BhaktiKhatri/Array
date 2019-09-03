package Array;

/**
 * Leetcode 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/discuss/
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. 
 * @author NisuBhakti
 * Time Complexity: O(N); Space Complexity: O(1)
 */

public class ThirdMaxNumber {

	public static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
	
	public static int findThirdMaxNumber(int[] nums) {
		Integer max1 = null, max2 = null, max3 = null;

		for(Integer n: nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
			
			if( max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			}
			else if(max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			}
			else if(max3 == null || n > max3) {
				max3 = n;
			}
			System.out.println("max1: "+max1+" max2: "+max2+" max3: "+max3);
		}
		return (max3 == null) ? max1 : max3;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,2,3,1};
		System.out.println(findThirdMaxNumber(arr));
		//System.out.println(thirdMax(arr));
	}

}
