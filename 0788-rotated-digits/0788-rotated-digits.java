class Solution {
    public int rotatedDigits(int n) {
        if(n<=1) return 0;
        int count=0;
        for(int i=1;i<=n;i++){
            int num=i;
            boolean hasGoodDigit = false;
            boolean isInvalid = false;
            
            while (num > 0) {
                int d = num % 10;
                if (d == 3 || d == 4 || d == 7) {
                    isInvalid = true; 
                    break; 
                }
                if (d == 2 || d == 5 || d == 6 || d == 9) {
                    hasGoodDigit = true;
                }
                num /= 10;
            }
            if (!isInvalid && hasGoodDigit)   count++;
        }    
        return count;
    }
}