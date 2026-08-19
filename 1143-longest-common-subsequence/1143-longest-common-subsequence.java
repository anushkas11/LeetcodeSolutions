class Solution {
    private int n1, n2;

    private int solve(String text1, int i, String text2, int j, int[][] dp) {
        if (i >= n1 || j >= n2)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int take = 0, skipI = 0, skipJ = 0;

        if (text1.charAt(i) == text2.charAt(j)) {
            take = 1 + solve(text1, i + 1, text2, j + 1, dp);
        } else {
            skipI = solve(text1, i + 1, text2, j, dp);
            skipJ = solve(text1, i, text2, j + 1, dp);
        }

        return dp[i][j] = Math.max(take, Math.max(skipI, skipJ));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();

        int[][] dp = new int[n1][n2];

        for (int i = 0; i < n1; i++)
            Arrays.fill(dp[i], -1);

        return solve(text1, 0, text2, 0, dp);
    }
}