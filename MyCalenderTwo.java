package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Leetcode 731. My Calendar II
 * https://leetcode.com/problems/my-calendar-ii/description/
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking. For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 * Explanation and Code from: Approach #2 https://leetcode.com/problems/my-calendar-ii/solution/
 * @author NisuBhakti
 * Time Complexity: O(N^2), where N is the number of events booked. For each new event, we traverse delta in O(N) time. 
 * Space Complexity: O(N), the size of delta.
 */

public class MyCalenderTwo {

//    public MyCalenderTwo() {
//        delta = new TreeMap<Integer, Integer>();
//    }
	
	/*
     Intuition and Algorithm:
	 When booking a new event [start, end), count delta[start]++ and delta[end]--. When processing the values of delta in sorted order of their keys, 
	 the running sum active is the number of events open at that time. If the sum is 3 or more, that time is (at least) triple booked.
    
     public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: delta.values()) {
            active = active + d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }
	 */
	
		private List<int[]> bookings;
	    private List<int[]> overlaps;
	    
	    public MyCalenderTwo() {
	        bookings = new ArrayList<>();
	        overlaps = new ArrayList<>();
	    }
        
        public boolean book(int start, int end) {
        	System.out.println("start: "+start+" end: "+end+" bookings: "+bookings+" overlaps: "+overlaps);
            
        	for(int[] bo: bookings) {
        		System.out.println("bo: "+Arrays.toString(bo));
                
        		int overlapStart = Math.max(bo[0], start);
        		int overlapEnd = Math.min(bo[1], end);
                
        		System.out.println("overlapStart: "+overlapStart+" overlapEnd: "+overlapEnd);
        		
        		if(overlapStart < overlapEnd) {
                    for(int[] ov: overlaps) {
                    	System.out.println("ov: "+Arrays.toString(ov)+" overlaps: "+overlaps);
                       
                    	if(Math.max(ov[0], overlapStart) < Math.min(ov[1], overlapEnd)) {
                            overlaps.clear();
                            return false;
                        }
                    }
                    overlaps.add(new int[] {overlapStart, overlapEnd});
                }
            }
            bookings.add(new int[] {start, end});
            return true;
        }

	
	public static void main(String[] args) {
		MyCalenderTwo MyCalenderTwo = new MyCalenderTwo();
		System.out.println(MyCalenderTwo.book(10, 20)); // returns true
		System.out.println(MyCalenderTwo.book(50, 60)); // returns true
		System.out.println(MyCalenderTwo.book(10, 40)); // returns true
		System.out.println(MyCalenderTwo.book(5, 15)); 	// returns false
		System.out.println(MyCalenderTwo.book(5, 10)); 	// returns true
		System.out.println(MyCalenderTwo.book(25, 55)); // returns true
	}
}