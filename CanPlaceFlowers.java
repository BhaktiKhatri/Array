package Array;

import java.util.Arrays;

/**
 * Leetcode 605. Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/description/
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * Input: flowerbed = [1,0,0,0,1], n = 1; Output: True
 * @author NisuBhakti
 * Time complexity : O(n); A single scan of the flowerbed array of size n is done; Space complexity : O(1); Constant extra space is used.
 */

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    	int count = 0;
    	
    	for(int i=0; i<flowerbed.length && count<n; i++) {
	        if(flowerbed[i] == 0) {
	           int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
	           int prev = (i == 0) ? 0 : flowerbed[i - 1];						//get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0
	           if(next == 0 && prev == 0) {
	               flowerbed[i] = 1;
	               count++;
	           }
	        }
    	}
    	return count == n;
    }
    
    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int i = 0, count = 0;
        System.out.println("flowerbed: "+Arrays.toString(flowerbed)+" n: "+n);
        
        while(i < flowerbed.length) {
        	System.out.println("i: "+i+" flowerbed[i]: "+flowerbed[i]+" count: "+count);
            
        	if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            if(count >= n) {
                return true;
            }
            i++;
        }
        return false;
    }

	public static void main(String[] args) {
		int[] arr = {1,0,1,0,0};
		int n = 1;
		System.out.println(canPlaceFlowers1(arr, n));
	}
}
