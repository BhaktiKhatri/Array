package Array;

/**
 * Leetcode 717. 1-bit and 2-bit Characters
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * Input: bits = [1, 0, 0]; Output: True; The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * @author NisuBhakti
 * Time Complexity: O(N), where N is the length of bits; Space Complexity: O(1), the space used by i.
 */
public class Bit1_2Characters {

	/**
	 * When reading from the i-th position, if bits[i] == 0, the next character must have 1 bit; else if bits[i] == 1, the next character must have 2 bits. 
	 * We increment our read-pointer i to the start of the next character appropriately. At the end, if our pointer is at bits.length - 1, 
	 * then the last character must have a size of 1 bit.
	 * @param bits: binary array
	 * @return whether the last character must be a one-bit character or not
	 */
	public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while(i < bits.length - 1) {
            i = i + bits[i] + 1;
        }
        return i == bits.length - 1;
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 0};
		System.out.println(isOneBitCharacter(arr));
	}

}
