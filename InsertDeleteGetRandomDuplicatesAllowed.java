package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Leetcode 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * Design a data structure that supports all following operations in average O(1) time.
 * (1)insert(val): Inserts an item val to the collection.
 * (2)remove(val): Removes an item val from the collection if present.
 * (3)getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Time Complexity: O(1)
 * Yelp
 * Medium
 */

public class InsertDeleteGetRandomDuplicatesAllowed {

	ArrayList<Integer> numList;
	HashMap<Integer, Set<Integer>> hMap;
	Random rand;
	
	public InsertDeleteGetRandomDuplicatesAllowed() {
		numList = new ArrayList<Integer>();
		hMap = new HashMap<Integer, Set<Integer>>();
		rand = new Random();
	}
	
	/** Inserts a value to the set. Returns true if the set did not already contain the specified element */
	public boolean insert(int val) {
		System.out.println("Insert val: "+val+" hMap: "+hMap+" numList: "+numList);
		
		boolean contain = hMap.containsKey(val);
		System.out.println("contain: "+contain);
		
		if(!contain)
			hMap.put(val, new HashSet<Integer>());
		
		System.out.println("hMap: "+hMap);
		
		hMap.get(val).add(numList.size());
		numList.add(val);
		
		System.out.println("hMap: "+hMap+" numList: "+numList);
		return !contain;
	}
	
	/** Removes a value from the set. Returns true if the set contained the specified element */
	public boolean remove(int val) {						//example remove(1); hMap: {1=[0,1], 2=[2]}; numList: [1,1,2]
		System.out.println("Remove val: "+val+" hMap: "+hMap+" numList: "+numList+" numList.size(): "+numList.size());
		
		if(!hMap.containsKey(val))
			return false;
		
		System.out.println("hMap.get(val): "+hMap.get(val));
		
		int index = hMap.get(val).iterator().next();		//gets first 1 with index 0
		System.out.println("index: "+index);
		
		hMap.get(val).remove(index);						//removes 1 at index 0 so we have {1=[1], 2=[2]}
		
		if(index < numList.size() - 1) {
			
			int lastOne = numList.get(numList.size()-1);	//gets 2
			System.out.println("lastOne: "+lastOne);
			
			numList.set(index, lastOne);					//previously: [1,1,2]; sets 2 at index 0; so we have numList as [2,1,2];
			hMap.get(lastOne).remove(numList.size()-1);		//removes value of 2; so we get {1=[1], 2=[]}
			hMap.get(lastOne).add(index);					//adds value 0 to 2; so we get {1=[1], 2=[0]}
		}
		
		System.out.println("hMap: "+hMap+" numList: "+numList);
		
		numList.remove(numList.size()-1);					//removes last 2 in numList; so we get numList as [1,2]
		if(hMap.get(val).isEmpty())							//if {1=[], 2=[0]}
			hMap.remove(val);								//then 1 is removed
		
		System.out.println("hMap: "+hMap+" numList: "+numList);
		
		return true;
	}
	
	/** Get a random element from the set */
	public int getRandom() {
		return numList.get(rand.nextInt(numList.size()-1));
	}
	
	public static void main(String[] args) {
		InsertDeleteGetRandomDuplicatesAllowed op = new InsertDeleteGetRandomDuplicatesAllowed();
		
		System.out.println("Insert 1: "+op.insert(1));		// Inserts 1 to the collection. Returns true as the collection did not contain 1.
		System.out.println("Insert 1: "+op.insert(1));		// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
		System.out.println("Insert 2: "+op.insert(2));		// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
		System.out.println("Get Random: "+op.getRandom());	// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
		System.out.println("Remove 1: "+op.remove(1));		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		System.out.println("Get Random: "+op.getRandom());	// getRandom should return 1 and 2 both equally likely.
	}

}
