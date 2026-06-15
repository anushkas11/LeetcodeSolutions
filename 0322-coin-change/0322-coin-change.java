class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;

        for(int t=1;t<=amount;t++){
            for(int coin:coins){
                if(coin<=t){
                    dp[t]=Math.min(dp[t],1+dp[t-coin]);
                }
            }
        }
        return dp[amount]>amount ?-1:dp[amount];
    }
}