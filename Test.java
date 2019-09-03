package Array;

import java.util.ArrayList;
import java.util.List;

//https://stackoverflow.com/questions/17379020/how-to-find-the-largest-power-of-2-less-than-the-given-number

public class Test {

	public static long largestRepackaged(List<Integer> arrivingPackets) {
        int size = arrivingPackets.size()-1;
        int remainder = 0;
        
        for(int i=0; i<=size; i++) {

            remainder = getPowerOfTwo(arrivingPackets.get(i));
            
            if(remainder != 0 || (i == size && remainder == 0)) {
                if(i == size) {
                    remainder = arrivingPackets.get(i);
                } 
                else {
                    arrivingPackets.set(i+1,remainder + arrivingPackets.get(i+1));
                }
            }
        
        }
        return remainder;
    }
	
	public static int getPowerOfTwo(int n) {
		int num = n;
		
		while((n & n-1) != 0) { 
	         n = n & n-1; 
	      }
	      return num - n;
    }
	
	public static void main(String[] args) {
		List<Integer> arrivingPackets = new ArrayList<Integer>();
		
		arrivingPackets.add(1);
		arrivingPackets.add(2);
		arrivingPackets.add(4);
		arrivingPackets.add(7);
		arrivingPackets.add(5);
		
		System.out.println(largestRepackaged(arrivingPackets));
	}

}
