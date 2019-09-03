package Array;

import java.util.Arrays;

public class BitArraySort {

	public static int[] sortBitArray(int arr[])  
    { 
        /* Initialize left and right indexes */
        int left = 0;
        int right = arr.length - 1; 
  
        System.out.println(Arrays.toString(arr));
        System.out.println("left: "+left+" right: "+right);
        
        while (left < right)  
        { 
        	System.out.println("left: "+left+" right: "+right+" arr[left]: "+arr[left]+" arr[right]: "+arr[right]);
        	
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right) { 
               left++; 
            }
            System.out.println("left: "+left+" right: "+right+" arr[left]: "+arr[left]+" arr[right]: "+arr[right]);
  
            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right) { 
                right--; 
            }
            System.out.println("left: "+left+" right: "+right+" arr[left]: "+arr[left]+" arr[right]: "+arr[right]);
  
            /* If left is smaller than right then there is a 1 at left and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right)  
            { 
                arr[left] = 0; 
                arr[right] = 1; 
                left++; 
                right--; 
            }
        } 
        return arr;
    } 

	//Outco program
	public static int[] bitArraySort(int[] arr) {
		int mid = 0;
		int temp = 0;
		
		System.out.println(Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("i: "+i+" mid: "+mid+" arr[i]: "+arr[i]+" arr[mid]: "+arr[mid]+" Arrays.toString(arr): "+Arrays.toString(arr));
			if(arr[i] == 0) {
				temp = arr[i];
				arr[i] = arr[mid];
				arr[mid] = temp;
				mid++;
			}
		}
		return arr;
	}
	
	public static int[] sortBitArray1(int arr[])  
    { 
        /* Initialize left and right indexes */
        System.out.println(Arrays.toString(arr));
        int j = arr.length-1;
        
        for(int i=0; i<arr.length-1;) {
        	
        	while (arr[i] == 0 && i < j) { 
                i++; 
            }
        	
        	while (arr[j] == 1 && i < j) { 
                j--; 
            }
        	
        	if (i < j)  
            { 
                arr[i] = 0; 
                arr[j] = 1; 
                i++; 
                j--; 
            }
        }
                      
        return arr;
    } 

	
	public static void main(String[] args) {
		int[] arr = {0,1,1,0,1,0};
		//int[] result = sortBitArray1(arr);
		int[] result = bitArraySort(arr);
		System.out.println(Arrays.toString(result));

	}

}
