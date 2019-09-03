package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 * Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * Explanation and code https://leetcode.com/problems/merge-intervals/solution/ https://leetcode.com/problems/merge-intervals/discuss/21222
 * @author NisuBhakti
 * Time complexity : O(nlgn), Other than the sort invocation, we do a simple linear scan of the list, so the runtime is dominated by the O(nlgn) complexity of sorting.
 * Space complexity : O(1) or O(n), If we can sort intervals in place, we do not need more than constant additional space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 */

public class MergeIntervalsCopy {

	private class IntervalComparator implements Comparator<Interval> {
		 @Override   
		 public int compare(Interval a, Interval b) {
	            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
	     }
	}
	
	public List<Interval> merge1(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
	
	public List<Interval> merge(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
	
	public static List<Intervall> mergeIntervals(List<Intervall> intervals) {
		int i = 0;
		
		while(i < intervals.size()-1 && intervals.get(i).start <= intervals.get(i+1).end && intervals.get(i).end >= intervals.get(i+1).start) {
			Intervall newInterval = new Intervall(Math.min(intervals.get(i).start, intervals.get(i+1).start), Math.max(intervals.get(i).end, intervals.get(i+1).end));
			intervals.set(i, newInterval);
			intervals.remove(i+1);
			i++;
		}
		
		int n = intervals.size()-1;
		if(intervals.get(n-1).end >= intervals.get(n).start) {
			Intervall newInterval = new Intervall(Math.min(intervals.get(n-1).start, intervals.get(n).start), Math.max(intervals.get(n-1).end, intervals.get(n).end));
			intervals.set(n, newInterval);
			intervals.remove(n-1);
		}
		
		return intervals;
	}
	
	public static void main(String[] args) {
		Intervall interval1 = new Intervall(1,4);
		Intervall interval2 = new Intervall(0,2);
		Intervall interval3 = new Intervall(3,5);
		
		List<Intervall> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		
//		intervals.add(interval1);
//		intervals.add(interval2);
//		intervals.add(interval3);
//		intervals.add(interval4);

		System.out.println(mergeIntervals(intervals));
		
	}

}
