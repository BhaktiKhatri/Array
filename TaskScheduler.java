package Array;

import java.util.Arrays;

/**
 * Leetcode 621. Task Scheduler
 * https://leetcode.com/problems/task-scheduler/description/
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle. You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * Explanation and Code from: Approach #3 https://leetcode.com/problems/task-scheduler/solution/
 * @author NisuBhakti
 * Time complexity : O(n), We iterate over tasks array only once. (O(n)).Sorting tasks array of length n takes O(26log(26))=O(1) time. After this, only one iteration over 26 elements of map is done O(1).
 * Space complexity : O(1), map array of constant size(26) is used.
 *
 */

public class TaskScheduler {

	public static int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c: tasks) {
        	System.out.println("c: "+c);
        	map[c - 'A']++;
        }
        
        Arrays.sort(map);
        
        
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
	
	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));
	}
}
