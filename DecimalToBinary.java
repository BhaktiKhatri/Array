package Array;

public class DecimalToBinary {

	/*
	 * number >> 1 means number/2
	 * If you keep dividing the number by 2 and save the remainder onto a stack and then pop off the series of 0's and 1's you get the value that represents the number in binary
	 * 
	 */
	private static void decimaltoBinaryRecursive(int number) {
        int remainder;
        
        if (number <= 1) {
            System.out.print(number);
            return; // KICK OUT OF THE RECURSION
        }

        remainder = number % 2;
        decimaltoBinaryRecursive(number / 2);
        System.out.print(remainder);
    }
	
	private static void decimaltoBinary(int n) {
		int[] binaryNum = new int[10]; 
		   
        // counter for binary array 
        int i = 0; 
        while(n > 0)  
        { 
        	System.out.println("n: "+n+" n%2: "+(n % 2));
            // storing remainder in binary array 
            binaryNum[i] = n % 2; 
            n = n / 2; 
            System.out.println("n: "+n);
            i++; 
            System.out.println("i: "+i);
        } 
   
        // printing binary array in reverse order 
        for(int j = i - 1; j >= 0; j--) {
            System.out.print(binaryNum[j]);
        }
    }
	
	/*
	 * 1 % 2 = 1
	 * 1 / 2 = 0
	 */
	public static void decimalToBinary(int n) {
		String bin = "";
		System.out.println("n: "+n);
		
		while(n > 0) {
			System.out.println("n: "+n+" n % 2: "+(n % 2));
			
			int rem = n % 2;
			
			System.out.println("rem: "+rem+" bin: "+bin);
			
			bin = bin + rem;
			
			System.out.println("n: "+n+" bin: "+bin);
			
			n = n/2;
		}
		
		bin = new StringBuilder(bin).reverse().toString(); 
		System.out.println("bin: "+bin);
	}
	
	public static void main(String[] args) {
		decimalToBinary(4);
	}

}
