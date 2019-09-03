package Array;

import java.util.Arrays;

/*
 * 825. Friends Of Appropriate Ages
 * https://leetcode.com/problems/friends-of-appropriate-ages/description/
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B
 * Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves. How many total friend requests are made?
 * Example 1: Input: [16,16]; Output: 2; Explanation: 2 people friend request each other
 * Example 2: Input: [16,17,18]; Output: 2; Explanation: Friend requests are made 17 -> 16, 18 -> 17
 * Example 3: Input: [20,30,100,110,120]; Output: Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100
 * Notes: 1 <= ages.length <= 20000; 1 <= ages[i] <= 120
 * Explanation and Code from: https://leetcode.com/problems/friends-of-appropriate-ages/discuss/127341/10ms-concise-Java-solution-O(n)-time-and-O(1)-space
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://zihan.me/2018/04/29/LeetCode-825-Friends-Of-Appropriate-Ages/&prev=search
 * Facebook
 * Medium
 */

public class FriendsOfAppropriateAges {

	/*
	 * Three conditions could be merged to one: The Person with age A can request person with age B if
	 * B is in range ( 0.5 * A + 7, A ]
	 */
	public static int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121];
        int[] sumInAge = new int[121];
        
        System.out.println("ages: "+Arrays.toString(ages));
        
        for(int i : ages) { 
            numInAge[i]++;
        }
        
        for(int i=1; i<=120; i++) {
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        }
        
        for(int i=15; i<=120; i++) {
            if(numInAge[i] == 0) 
            	continue;
         
            System.out.println("sumInAge[i]: "+sumInAge[i]+" sumInAge[i / 2 + 7]: "+sumInAge[i / 2 + 7]);
            
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            System.out.println("res: "+res+" count: "+count+" numInAge[i]: "+numInAge[i]);
            
            res = res + count * numInAge[i] - numInAge[i]; 	//people will not friend request themselves, so  - numInAge[i]
        }
        System.out.println("res: "+res);
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] ages = {20,30,100,110,120};
		
		System.out.println(numFriendRequests(ages));
	}

}
