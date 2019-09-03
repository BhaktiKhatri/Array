package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Leetcode 380. Insert Delete GetRandom O(1) Without Duplicates
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * Design a data structure that supports all following operations in average O(1) time.
 * (1) insert(val): Inserts an item val to the set if not already present.
 * (2) remove(val): Removes an item val from the set if present. 
 * (3) getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * @author NisuBhakti
 * Time Complexity: O(1)
 */

public class InsertDeleteGetRandom_WithoutDuplicates {

	ArrayList<Integer> numList;
	HashMap<Integer, Integer> hMap;		//key- element, value-index of element
	Random rand;
	
	public InsertDeleteGetRandom_WithoutDuplicates() {
		numList = new ArrayList<Integer>();
		hMap = new HashMap<Integer, Integer>();
		rand = new Random();
	}
	
	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		System.out.println("Insert val: "+val+" hMap: "+hMap+" numList: "+numList);
		if(hMap.containsKey(val))
			return false;
		hMap.put(val, numList.size());
		numList.add(val);
		return true;
	}
	
	/** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	System.out.println("Remove val: "+val+" hMap: "+hMap+" numList: "+numList+" numList.size(): "+numList.size());
    	if(!hMap.containsKey(val)) 
    		return false;
    	
    	int index = hMap.get(val);
    	System.out.println("index: "+index);
    	
    	if(index < numList.size() - 1) {				// not the last one than swap the last one with this val
    		int lastOne = numList.get(numList.size() - 1);
    		System.out.println("lastOne: "+lastOne);
    		
    		numList.set(index, lastOne);
    		hMap.put(lastOne, index);
    		
    		System.out.println("numList: "+numList+" hMap: "+hMap);
    	}
    	
    	hMap.remove(val);
    	numList.remove(numList.size()-1);
    	
    	System.out.println("numList: "+numList+" hMap: "+hMap);
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	System.out.println("numList: "+numList+" numList.size(): "+numList.size());
    	return numList.get(rand.nextInt(numList.size()));
    }
    
    
	public static void main(String[] args) {
		InsertDeleteGetRandom_WithoutDuplicates op = new InsertDeleteGetRandom_WithoutDuplicates();
		
		System.out.println(op.insert(1));		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		System.out.println(op.remove(2));		// Returns false as 2 does not exist in the set.
		System.out.println(op.insert(2));		// Inserts 2 to the set, returns true. Set now contains [1,2].
		System.out.println(op.getRandom());		// getRandom should return either 1 or 2 randomly.
		System.out.println(op.remove(1));		// Removes 1 from the set, returns true. Set now contains [2].
		System.out.println(op.insert(2));		// 2 was already in the set, so return false.
		System.out.println(op.getRandom()); 	// Since 2 is the only number in the set, getRandom always return 2.
		
		System.out.println(op.remove(2));	
		System.out.println(op.insert(9));
		System.out.println(op.getRandom()); 
	}

}
