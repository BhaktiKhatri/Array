package Array;

import java.util.TreeMap;

/**
 * Leetcode 729. My Calendar I
 * https://leetcode.com/problems/my-calendar-i/description/
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking. 
 * Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.
 * A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.) For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 * Explanation and Code from: Approach #2 https://leetcode.com/problems/my-calendar-i/solution/
 * Time Complexity: O(NlogN), where N is the number of events booked. For each new event, we search that the event is legal in O(logN) time, then insert it in O(1) time.
 * Space Complexity: O(N), the size of the data structures used.
 */

public class MyCalendar {

	TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap<Integer, Integer>();
    }

    /*
       We will have a TreeMap where the keys are the start of each interval, and the values are the ends of those intervals. 
       When inserting the interval [start, end), we check if there is a conflict on each side with neighboring intervals: 
       We would like calendar.get(prev)) <= start <= end <= next for the booking to be valid (or for prev or next to be null respectively.)
     */
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		MyCalendar cal = new MyCalendar();
		System.out.println(cal.book(10, 20)); // returns true
		System.out.println(cal.book(15, 25)); // returns false
		System.out.println(cal.book(20, 30)); // returns true
	}
}
