package Array;

/**
 * Java program to find the maximum product of 2 numbers in an array 
 * @author NisuBhakti
 * Time Complexity: O(n)
 */

public class MaximumProductOf2Numbers {

	public static int maxProduct(int[] arr) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		
		for(int n: arr) {
			if(n <= min1) {
				min2 = min1;
				min1 = n;
			}
			else if(n <= min2) {
				min2 = n;
			}
			
			if(n >= max1) {
				max2 = max1;
				max1 = n;
			}
			else if(n >= max2) {
				max2 = n;
			}
		}

		return Math.max(min1 * min2, max1 * max2);
	}
	
	public static void main(String[] args) {
		int[] arr = {-1,-2,-3,4};
		System.out.println(maxProduct(arr));
	}

}
