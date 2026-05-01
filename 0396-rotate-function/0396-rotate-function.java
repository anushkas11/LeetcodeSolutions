class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        long f = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            f += (long)i * nums[i];
        }

        long max = f;

        for (int k = 1; k < n; k++) {
            f = f + totalSum - (long)n * nums[n - k];
            max = Math.max(max, f);
        }

        return (int)max;
    }
}