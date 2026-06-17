class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int x:nums) sum+=x;
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
            return 0;
        }

        int k=(sum+target)/2;
        return helper(nums,k);
    }
    public int helper(int nums[],int target){
        int dp[][]=new int[nums.length][target+1];
        if(nums[0]==0) dp[0][0]=2;
        else dp[0][0]=1;

        if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1;

        for(int i=1;i<nums.length;i++){
            for(int t=0;t<=target;t++){
                int notpick=dp[i-1][t];
                int pick=0;
                if(t-nums[i]>=0) pick=dp[i-1][t-nums[i]];
                dp[i][t]=pick+notpick;
            }
        }
        return dp[nums.length-1][target];
    }
}