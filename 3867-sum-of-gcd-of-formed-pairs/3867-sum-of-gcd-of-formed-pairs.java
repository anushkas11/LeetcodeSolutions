class Solution {
    public long gcdSum(int[] nums) {
       int n=nums.length; 
       int mxi[]=new int[n];
       mxi[0]=nums[0];
       for(int i=1;i<n;i++){
        mxi[i]=Math.max(mxi[i-1],nums[i]);
       } 

       int prefixGCD[]=new int[n];
       for(int i=0;i<n;i++){
        prefixGCD[i]=gcd(nums[i],mxi[i]);
       }
       Arrays.sort(prefixGCD);
       long sum=0;
       for(int i=0;i<n/2;i++){
        sum+=gcd(prefixGCD[i],prefixGCD[n-1-i]);
       }
       return sum;
    }
    public static int gcd(int a, int b) {
      while (b != 0) {
         int temp = b;
         b = a % b;
         a = temp;
        }
      return a;
    }
}