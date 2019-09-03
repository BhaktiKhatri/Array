package Array;

import java.util.ArrayList;
import java.util.List;

/*
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1: Input: intervals = [[1,3],[6,9]], newInterval = [2,5]; Output: [[1,5],[6,9]]
 * Example 2: Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]; Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Explanation and Code from: @peter87512 https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution
 * Google, Facebook, LinkedIn
 */

// Definition for an interval.
class Interval {
      int start;
      int end;
      
      Interval() { 
    	start = 0; 
    	end = 0; 
      }
      
      Interval(int s, int e) { 
    	 start = s; 
    	 end = e; 
      }
  }

public class InsertInterval {

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i=0;
        
        //skip the intervals whose end value is smaller than new interval start value and keep those intervals as it is
        while(i<intervals.size() && intervals.get(i).end<newInterval.start) 
        	i++;
        
        // merge all overlapping intervals to one considering newInterval
        while(i<intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        
        intervals.add(i,newInterval);
        return intervals;
	}
	
	public static void main(String[] args) {
		Interval interval1 = new Interval(1,2);
		Interval interval2 = new Interval(3,5);
		Interval interval3 = new Interval(6,7);
		Interval interval4 = new Interval(8,10);
		Interval interval5 = new Interval(12,16);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		
		Interval newInterval = new Interval(4,8);
		
		System.out.println(insert(intervals, newInterval));
	}

}
