package Array;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * https://www.youtube.com/watch?v=zOyOwDEF1Rc
 * @author NisuBhakti
 * Time complexity : O(n)
 */
public class BoyerMoore_MajorityElement {

	// Boyer-Moore Vote Algorithm
	public static int majorityElement(int[] arr) {
		if(arr == null || arr.length == 0)		//base case
			return -1;
		
		// Step 1: Find max element
		int candidate = 0;
		int count = 0;
		
		for(int num: arr) {
			if(count == 0) {
				candidate = num;
				count = 1;
			}
			else {
				if(candidate == num) {
					count++;
				}
				else {
					count--;
				}
			}
		}
		
		if(count == 0)
			return -1;
		
		// Step 2: Check if candidate is majority element
		count = 0;
		for(int num: arr) {
			if(candidate == num) {
				count++;
			}
		}
		
		return (count > arr.length/2) ? candidate : -1;
	}
	
	public static void main(String[] args) 
    {
        int arr[] = new int[]{2, 1, 2, 4, 2};
        int element = majorityElement(arr);
        if(element == -1)
        	System.out.println("Majority element does not exists");
        else
        	System.out.println("Majority element is: "+element);
    }
}
