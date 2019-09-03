package Array;

import java.util.Arrays;

/*
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1: nums1 = [1, 3] nums2 = [2]; The median is 2.0
 * Example 2: nums1 = [1, 2] nums2 = [3, 4] The median is (2 + 3)/2 = 2.5
 * Explanation from: https://www.youtube.com/watch?v=LPFhl65R7ww
 * Code from: https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
 * Microsoft, Apple, Google, Yahoo, Zenefits, Adobe, Dropbox
 * >Medium
 */

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int input1[], int input2[]) {
		System.out.println("input1: "+Arrays.toString(input1)+" input1.length: "+input1.length+" input2: "+Arrays.toString(input2)+" input2.length: "+input2.length);
		
		//if input1 length is greater than switch them so that input1 is smaller than input2.
        if(input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        
        int x = input1.length;
        int y = input2.length;
        System.out.println("x: "+x+" y: "+y);
        
        int low = 0;
        int high = x;
        System.out.println("low: "+low+" high: "+high);
        
        while(low <= high) {
        	System.out.println("low: "+low+" high: "+high);
        	
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;
            //int partitionY = (0 + y) /2;
            
            System.out.println("partitionX: "+partitionX+" partitionY: "+partitionY);
            
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            System.out.println("maxLeftX: "+maxLeftX+" minRightX: "+minRightX);
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            System.out.println("maxLeftY: "+maxLeftY+" minRightY: "+minRightY);
            
            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if((x + y) % 2 == 0) {		//even
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } 
                else {		//odd
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } 
            else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } 
            else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 18, 19, 21, 25};

        MedianOfTwoSortedArrays mm = new MedianOfTwoSortedArrays();
        double median = mm.findMedianSortedArrays(x, y);
        
        System.out.println("median: "+median);
    }
}