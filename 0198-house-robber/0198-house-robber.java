class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        if(n==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int max=0;
        for(int i=2;i<nums.length;i++){
            int take=dp[i-2]+nums[i];
            int nottake=dp[i-1];
            dp[i]=Math.max(take,nottake);
        }
        return dp[n-1];
    }
}