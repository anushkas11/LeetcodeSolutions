class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        // Loop as long as there is at least one remaining set bit in a, b, or c
        while (a > 0 || b > 0 || c > 0) {
            // Extract the rightmost bit of each number using bitwise AND (& 1)
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            
            // Case 1: Target bit is 0
            if (bitC == 0) {
                flips += (bitA + bitB); // Flip every 1 in a or b to 0
            } 
            // Case 2: Target bit is 1
            else {
                if (bitA == 0 && bitB == 0) {
                    flips += 1; // Flip at least one 0 to 1
                }
            }
            
            // Shift all numbers right by 1 bit to check the next position
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        
        return flips;
    }
}