class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }

        suffix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }

        for(int i=0;i<n;i++){
           int leftsum = (i > 0) ? prefix[i - 1] : 0;
            int rightsum = (i < n - 1) ? suffix[i + 1] : 0;

            if(rightsum==leftsum) return i;
        }
        return -1;
    }
}