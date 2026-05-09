class Solution {

    public int[] minCost(int[] nums, int[][] queries) {

        int n = nums.length;

        int[] closest = new int[n];

        closest[0] = 1;
        closest[n - 1] = n - 2;

        for (int i = 1; i < n - 1; i++) {

            int left = nums[i] - nums[i - 1];
            int right = nums[i + 1] - nums[i];

            if (left <= right) closest[i] = i - 1;
            else closest[i] = i + 1;
        }

        int[] pre = new int[n];
        int[] suf = new int[n];

        for (int i = 1; i < n; i++) {

            int cost = nums[i] - nums[i - 1];

            if (closest[i - 1] == i) cost = 1;

            pre[i] = pre[i - 1] + cost;
        }

        for (int i = n - 2; i >= 0; i--) {

            int cost = nums[i + 1] - nums[i];

            if (closest[i + 1] == i) cost = 1;

            suf[i] = suf[i + 1] + cost;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            if (l < r) {
                ans[i] = pre[r] - pre[l];
            } else {
                ans[i] = suf[r] - suf[l];
            }
        }

        return ans;
    }
}