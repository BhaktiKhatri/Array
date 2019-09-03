package Array;

import java.util.Arrays;
import java.util.Random;

/*
 * 384. Shuffle an Array also known as Shuffle deck of cards
 * https://leetcode.com/problems/shuffle-an-array/description/
 * Shuffle a set of numbers without duplicates.
 * Example: 
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * Explanation and Code from: https://leetcode.com/problems/shuffle-an-array/discuss/85958/First-Accepted-Solution-Java
 * Refer Fisher–Yates shuffle randomize() https://www.geeksforgeeks.org/shuffle-a-given-array/
 * Fisher–Yates shuffle Algorithm works in O(n) time complexity. The assumption here is, we are given a function rand() that generates random number in O(1) time. 
 */

public class ShuffleAnArray {

	public int[] nums;
	public Random random;
	
	public ShuffleAnArray(int[] nums) {
		this.nums = nums;
		random = new Random();
	}
	
    /** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}
	
	public int[] shuffle() {
        if(nums == null)
        	return null;
		
		int[] arr = nums.clone();
        
		for(int i = arr.length - 1; i > 0; i--) {
			
			int j = random.nextInt(i);
			
			swap(arr, i, j);
		}
		return arr;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// A Function to generate a random permutation of arr[]
    public static void randomize( int arr[])
    {
    	System.out.println("arr: "+Arrays.toString(arr));
    	
        // Creating a object for Random class
        Random r = new Random();
         
        // Start from the last element and swap one by one. We don't need to run for the first element that's why i > 0
        for(int i=arr.length - 1; i > 0; i--) {
             
        	System.out.println("i: "+i+" arr[i]: "+arr[i]);
            
        	// Pick a random index from 0 to i
            int j = r.nextInt(i);
            System.out.println("j: "+j+" arr[j]: "+arr[j]);
             
            // Swap arr[i] with the element at random index
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        
            System.out.println(Arrays.toString(arr));
        }
        // Prints the random array
        System.out.println(Arrays.toString(arr));
    }
    
    // Driver Program to test above function
    public static void main(String[] args) 
    {
         int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
         //randomize(arr);
         //shuffle(arr);
         
         System.out.println("original array: "+Arrays.toString(arr));
         
         ShuffleAnArray solution = new ShuffleAnArray(arr);
         
         System.out.println("shuffle array: "+Arrays.toString(solution.shuffle()));
         System.out.println("reset array: "+Arrays.toString(solution.reset()));
         System.out.println("shuffle array: "+Arrays.toString(solution.shuffle()));
    }
}