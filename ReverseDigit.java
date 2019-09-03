package Array;

public class ReverseDigit {

	public static int reverse(int x) {
        int rev = 0;
        System.out.println("x: "+x);
        
        while(x != 0) {
            int pop = x % 10;
            x = x / 10;
            
            System.out.println("pop: "+pop+" x: "+x+" rev: "+rev);
            
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) { 
            	return 0;
            }
            
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) { 
            	return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
	
	public static int hammingWeight(int n) {
		int ones = 0;
	    	while(n!=0) {
	    		System.out.println("n: "+n+" n&1: "+(n & 1));
	    		ones = ones + (n & 1);
	    		System.out.println("ones: "+ones+" n: "+n+" n >>> 1: "+(n>>>1));
	    		n = n>>>1;
	    	}
	    	System.out.println("ones: "+ones);
	    	return ones;
	}

	
	public static void main(String[] args) {
		//System.out.println(reverse(-123));
		System.out.println(hammingWeight(0110));
	}

}
