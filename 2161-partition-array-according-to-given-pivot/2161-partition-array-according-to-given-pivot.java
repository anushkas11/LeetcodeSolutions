class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int ansIdx = 0;
        
        for (int num : nums) {
            if (num < pivot) {
                ans[ansIdx++] = num;
            }
        }
        for (int num : nums) {
            if (num == pivot) {
                ans[ansIdx++] = num;
            }
        }
        for (int num : nums) {
            if (num > pivot) {
                ans[ansIdx++] = num;
            }
        }
        
        return ans;
    }
}