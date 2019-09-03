package Array;

import java.util.Arrays;

/**
 * Leetcode 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 * http://www.ideserve.co.in/learn/merge-two-sorted-arrays-without-extra-space
 * https://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
 * @author NisuBhakti
 *
 */

public class MergeTwoSortedArrays {

	// Merge arr1[0..n1-1] and arr2[0..n2-1] into arr3[0..n1+n2-1]
    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3)	//Time complexity and Auxiliary Space: O(n1+n2)
    {
        int i = 0, j = 0, k = 0;
        System.out.println("arr1: "+Arrays.toString(arr1)+" arr2: "+Arrays.toString(arr2));
     
        // Traverse both array
        while(i<n1 && j <n2) {
        	System.out.println("i: "+i+" j: "+j+" k: "+k);
        	
            // Check if current element of first array is smaller than current element of second array. If yes, store first array element and increment first array index. Otherwise do same with second array
            if(arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;
            }
            else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
     
        // Store remaining elements of first array
        while(i < n1) {
            arr3[k] = arr1[i];
            k++;
            i++;
        }
     
        // Store remaining elements of second array
        while(j < n2) {
            arr3[k] = arr2[j];
            k++;
            j++;
        }
    }
    
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m-1;
		int j = n-1;
		int k = m+n-1;
		
		System.out.println("arr1: "+Arrays.toString(arr1)+" arr2: "+Arrays.toString(arr2));
		System.out.println("i: "+i+" j: "+j+" k: "+k);
		
		while(i >=0 && j>=0)
		{
			System.out.println("i: "+i+" j: "+j+" k: "+k+" arr1[i]: "+arr1[i]+" arr2[j]: "+arr2[j]+" arr1: "+Arrays.toString(arr1));
			if(arr1[i] > arr2[j]) {
				arr1[k] = arr1[i];
				k--;
				i--;
			}
			else {
				arr1[k] = arr2[j];
				k--;
				j--;
			}
		}
        
		System.out.println("i: "+i+" j: "+j+" k: "+k);
		
		while(j >= 0) {
			System.out.println("in while");
			arr1[k] = arr2[j];
			k--;
			j--;
		}
		
		System.out.println("arr1: "+Arrays.toString(arr1)+" arr2: "+Arrays.toString(arr2));
    }
     
    public static void main (String[] args) 
    {
        int[] arr1 = {3,5,7,0,0,0};
        int n1 = 3;
     
        int[] arr2 = {1,2,4};
        int n2 = 3;
     
        int[] arr3 = new int[arr1.length+arr2.length];
         
        merge(arr1,n1,arr2,n2);
        
        //mergeArrays(arr1, arr2, arr1.length, arr2.length, arr3);
     
        System.out.println("Array after merging: "+Arrays.toString(arr3));
        //for (int i=0; i < n1+n2; i++)
            //System.out.print(arr3[i] + " ");
    }
}
