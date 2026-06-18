class Solution {
    public int longestPalindromeSubseq(String s) {
      return lcs(s, new StringBuilder(s).reverse().toString());  
    }
    public int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char c1=s1.charAt(i-1);
                char c2=s2.charAt(j-1);
                if(c1==c2) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}