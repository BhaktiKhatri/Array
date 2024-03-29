package Array;

/**
 * Sieve of Eratosthenes: Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number
 * http://www.geeksforgeeks.org/sieve-of-eratosthenes/
 * @author NisuBhakti
 *
 */
public class PrimeNumber {

	void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
         
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }
    }
	
	public static boolean isPrime(int n) {

        if((n > 2 && n % 2 == 0) || n == 1) {
            return false;
        }

        for (int i = 3; i <= (int)Math.sqrt(n); i += 2) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

     
    // Driver Program to test above function
    public static void main(String args[])
    {
        int n = 20;
        System.out.print("Following are the prime numbers ");
        System.out.println("smaller than or equal to " + n);
        PrimeNumber g = new PrimeNumber();
        //g.sieveOfEratosthenes(n);
        isPrime(n);
    }

}
