package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 120. Triangle
 * https://leetcode.com/problems/triangle/description/
 * https://www.geeksforgeeks.org/maximum-path-sum-triangle/
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * 		[2], 
 * 	   [3,4],
 * 	  [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Explanation from: @stellari https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
 * Code from: @jianwu https://leetcode.com/problems/triangle/discuss/38730/DP-Solution-for-Triangle
 * Time Complexity: O(N^2)
 */

public class Triangle_MinPathSum {

	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() == 0)
			return 0;
		
		for(int i=triangle.size() - 2; i>=0; i--) {
			System.out.println("i: "+i+" triangle.get(i+1): "+triangle.get(i+1));
			
			List<Integer> nextRow = triangle.get(i+1);
			System.out.println("nextRow: "+nextRow);
			
			for(int j=0; j<=i; j++) {
				System.out.println("j: "+j+" nextRow.get(j): "+nextRow.get(j)+" nextRow.get(j+1): "+nextRow.get(j+1)+" triangle.get(i).get(j): "+triangle.get(i).get(j));
				
				int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);
				System.out.println("sum: "+sum+" triangle.get(i): "+triangle.get(i));

				triangle.get(i).set(j, sum);
			}
		}
		return triangle.get(0).get(0);
	}
	
	public static void main(String[] args) {
		//List<List<Integer>> list = [[2],[3,4],[6,5,7],[4,1,8,3]];
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		
		System.out.println(minimumTotal(triangle));
	}

}
