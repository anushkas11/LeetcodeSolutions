class Solution {
    static final int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
         int n = s.length();

        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digits.add(d);
                pos.add(i);
            }
        }

        int m = digits.size();

        long[] prefNum = new long[m + 1];
        long[] pow10 = new long[m + 1];
        int[] prefSum = new int[m + 1];

        pow10[0] = 1;

        for (int i = 0; i < m; i++) {
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            prefNum[i + 1] = (prefNum[i] * 10 + digits.get(i)) % MOD;
            prefSum[i + 1] = prefSum[i] + digits.get(i);
        }

        int[] next = new int[n];
        int[] prev = new int[n];

        Arrays.fill(next, -1);
        Arrays.fill(prev, -1);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            while (idx < m && pos.get(idx) < i)
                idx++;
            if (idx < m)
                next[i] = idx;
        }

        idx = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (idx >= 0 && pos.get(idx) > i)
                idx--;
            if (idx >= 0)
                prev[i] = idx;
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];

            int L = next[l];
            int R = prev[r];

            if (L == -1 || R == -1 || L > R) {
                ans[k] = 0;
                continue;
            }

            int len = R - L + 1;

            long num = (prefNum[R + 1]
                    - prefNum[L] * pow10[len] % MOD
                    + MOD) % MOD;

            long sum = prefSum[R + 1] - prefSum[L];

            ans[k] = (int) (num * sum % MOD);
        }

        return ans;
    }
}