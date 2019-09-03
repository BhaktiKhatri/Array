package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 119. Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle. For example, given k = 3, Return [1,3,3,1]
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 * @author NisuBhakti
 * Time Complexity: O(k)
 */

public class PascalTriangle2 {

	public static List<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		 
		if (rowIndex < 0)
			return result;
	 
		result.add(1);
		for(int i=1; i<=rowIndex; i++) {
			//System.out.println("i: "+i);
			for(int j=result.size()-2; j>=0; j--) {
				//System.out.println("j: "+j);
				result.set(j + 1, result.get(j) + result.get(j + 1));
				//System.out.println("result: "+result);
			}
			result.add(1);
			//System.out.println("result after: "+result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getRow(3));
	}

}
