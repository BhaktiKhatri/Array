package Array;

/**
 * Leetcode 277. Find the Celebrity
 * https://leetcode.com/problems/find-the-celebrity/description/
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * Time Complexity: O(N); Space complexity: O(1)
 */

public class FindTheCelebrity {

	public static boolean knows(int a, int b)
	{
		if(b == 3)
			return true;
		else
			return false;
	}
	
	/**
	 * The first loop is to find the candidate as the author explains. In detail, suppose the candidate after the first for loop is person k, 
	 * it means 0 to k-1 cannot be the celebrity, because they know a previous or current candidate. Also, since k knows no one between k+1 and n-1, 
	 * k+1 to n-1 can not be the celebrity either. Therefore, k is the only possible celebrity, if there exists one. 
	 * The remaining job is to check if k indeed does not know any other persons and all other persons know k. 
	 * To this point, I actually realize that we can further shrink the calling of knows method. For example, we don’t need to check if k knows
	 * k+1 to n-1 in the second loop, because the first loop has already done that.
	 * @param n number of people
	 * @return: the celebrity if it exits, otherwise -1
	 */
	public static int findCelebrity(int n) {
        int candidate = 0;
        System.out.println("n: "+n);
        
        for(int i=1; i<n; i++) {
        	System.out.println("i: "+i+" candidate: "+candidate);
        	
        	if(knows(candidate,i)) {
        		candidate = i;
        	}
        }
        
        for(int i=0; i<n; i++) {
        	System.out.println("i: "+i+" candidate: "+candidate);
        	
        	if(i != candidate && (knows(candidate,i) || !knows(i,candidate))) {
        		return -1;
        	}
        }
        return candidate;
    }
	
	public static void main(String[] args) {
		int n = 6;	//1,2,3,4,5,6
		System.out.println(findCelebrity(n));
	}

}
