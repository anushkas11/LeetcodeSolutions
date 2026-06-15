class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums) sum+=n;
        if(sum%2!=0) return false;
        int target=sum/2;

        boolean dp[][]=new boolean[nums.length][target+1];
        for(int i=0;i<nums.length;i++) dp[i][0]=true;
        if(nums[0]<=target) dp[0][nums[0]]=true;

        for(int i=1;i<nums.length;i++){
            for(int t=1;t<=target;t++){
                boolean notpick=dp[i-1][t];
                boolean pick=false;
                if(nums[i]<=t) pick=dp[i-1][t-nums[i]];

                dp[i][t]=pick||notpick;
            }
        }
        return dp[nums.length-1][target];
    }
}