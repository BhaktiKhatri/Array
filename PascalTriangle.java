package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/description/
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5; Return
 * [
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
 * @author NisuBhakti
 * Time complexity: O(numRows^2); Space complexity: O(numRows^2); Because we need to store each number that we update in triangle, space requirement is the same as the time complexity.
 */

public class PascalTriangle {

	public static List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		
		System.out.println("numRows: "+numRows);
		
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			System.out.println("i: "+i+" row: "+row);
			
			for(int j=1; j<row.size()-1; j++) {
				System.out.println("j: "+j);
				row.set(j, row.get(j) + row.get(j+1));
			}
			System.out.println("row: "+row);
			allrows.add(new ArrayList<Integer>(row));
			System.out.println("allrows: "+allrows);
		}
		return allrows;
	}
	
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

}