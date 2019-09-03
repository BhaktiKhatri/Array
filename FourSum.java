package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 18. 4Sum
 * https://leetcode.com/problems/4sum/description/
 * Code from: https://www.programcreek.com/2013/02/leetcode-4sum-java/
 * http://buttercola.blogspot.com/2014/07/leetcode-4sum.html
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0. A solution set is:
 *	[
 *	  [-1,  0, 0, 1],
 *	  [-2, -1, 1, 2],
 *	  [-2,  0, 0, 2]
 *	]
 * @author NisuBhakti
 * Time Complexity: O(N), Space Complexity: O(1)
 */

public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
	    if(nums==null|| nums.length<4)
	        return result;
	 
	    System.out.println("nums: "+Arrays.toString(nums)+" target: "+target);
	    
	    Arrays.sort(nums);
	    
	    System.out.println("nums: "+Arrays.toString(nums)+" target: "+target+" nums.length: "+nums.length);
	 
	    for(int i=0; i<nums.length-3; i++) {
	    	System.out.println("i: "+i+" nums[i]: "+nums[i]);
	    	
	    	if(i!=0 && nums[i]==nums[i-1]) {
	    		System.out.println("i: "+i+" nums[i]: "+nums[i]+" nums[i-1]: "+nums[i-1]);
	            continue;
	    	}
	        
	        for(int j=i+1; j<nums.length-2; j++) {
	        	System.out.println("j: "+j+" nums[j]: "+nums[j]);
	        	
	            if(j!=i+1 && nums[j]==nums[j-1]) {
	            	System.out.println("j: "+j+" nums[j]: "+nums[j]+" nums[j-1]: "+nums[j-1]);
	                continue;
	            }
	        
	            int k=j+1;
	            int l=nums.length-1;
	            System.out.println("i: "+i+" j: "+j+" k: "+k+" l: "+l+" result: "+result);
	            
	            while(k<l) {
	            	System.out.println("k: "+k+" l: "+l+" nums[i]+nums[j]+nums[k]+nums[l]: "+(nums[i]+nums[j]+nums[k]+nums[l]));
	                
	            	if(nums[i]+nums[j]+nums[k]+nums[l]<target) {
	                    k++;
	                }
	                else if(nums[i]+nums[j]+nums[k]+nums[l]>target) {
	                    l--;
	                }
	                else {
	                    List<Integer> t = new ArrayList<Integer>();
	                    t.add(nums[i]);
	                    t.add(nums[j]);
	                    t.add(nums[k]);
	                    t.add(nums[l]);
	                    result.add(t);
	 
	                    k++;
	                    l--;
	 
	                    System.out.println("k: "+k+" l: "+l+" nums[l]: "+nums[l]+" nums[l+1]: "+nums[l+1]);
	                    
	                    while(k<l &&nums[l]==nums[l+1]) {
	                        l--;
	                    }
	 
	                    System.out.println("k: "+k+" l: "+l+" nums[k]: "+nums[k]+" nums[k-1]: "+nums[k-1]);
	                    while(k<l &&nums[k]==nums[k-1]) {
	                        k++;
	                    }
	                }
	            }
	        }
	    }
	    return result;
	} 
	
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(Arrays.toString(nums));
		System.out.println(fourSum(nums, target));
	}

}
