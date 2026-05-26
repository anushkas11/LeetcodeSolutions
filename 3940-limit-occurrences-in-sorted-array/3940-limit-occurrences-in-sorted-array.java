class Solution {

    public int[] limitOccurrences(int[] nums, int k) {

        ArrayList<Integer> ans = new ArrayList<>();

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i == 0 || nums[i] != nums[i - 1]) {
                count = 1;
                ans.add(nums[i]);
            }

            else if (count < k) {
                ans.add(nums[i]);
                count++;
            }
        }

        int[] arr = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }
}