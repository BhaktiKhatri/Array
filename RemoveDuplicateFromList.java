package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Write a program to remove duplicates numbers from the list and display the duplicates  
 * https://beginnersbook.com/2014/10/how-to-remove-repeated-elements-from-arraylist/
 * http://www.techiedelight.com/remove-duplicates-list-java/
 * https://www.dotnetperls.com/duplicates-java
 * @author NisuBhakti
 *
 */

public class RemoveDuplicateFromList {

	/**
	 * 1) Copying all the elements of ArrayList to LinkedHashSet. Why we choose LinkedHashSet? Because it removes duplicates and maintains the insertion order.
	 * 2) Emptying the ArrayList
	 * 3) Copying all the elements of LinkedHashSet(non-duplicate elements) to the ArrayList. Please find below the complete code.
	 */
	public static void removeDuplicates(List<Integer> list) {
		LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();	//Creating LinkedHashSet
		lhs.addAll(list);	//Adding ArrayList elements to the LinkedHashSet in order to remove the duplicate elements and to preserve the insertion order
		list.clear();		//Removing ArrayList elements
		list.addAll(lhs);	//Adding LinkedHashSet elements to the ArrayList
		System.out.println(list);
	}
	
	static ArrayList<String> removeDuplicatesUsingSet(ArrayList<String> list) {

        // Store unique items in result.
        ArrayList<String> result = new ArrayList<>();

        // Record encountered Strings in HashSet.
        HashSet<String> set = new HashSet<>();

        // Loop over argument list.
        for (String item : list) {

            // If String is not in set, add it to the list and the set.
            if (!set.contains(item)) {
                result.add(item);
                set.add(item);
            }
        }
        System.out.println(result);
        return result;
    }

	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(5,5,1,2,3,2,4,4,6,1,7,8));
		removeDuplicates(list);
		ArrayList<String> llist = new ArrayList<>();
        llist.add("dog");
        llist.add("cat");
        llist.add("dog");
        llist.add("dog");
        llist.add("cat");
        llist.add("bird");
		removeDuplicatesUsingSet(llist);
	}

}
