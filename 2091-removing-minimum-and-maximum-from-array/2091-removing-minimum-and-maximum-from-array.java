class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=0,max=0;
        for(int i=0;i<n;i++){
            if(nums[min]>nums[i]) min=i;
            if(nums[max]<nums[i]) max=i;
        }
       
     int left = Math.min(min, max);
        int right = Math.max(min, max);

        int option1 = right + 1;

        int option2 = n - left;

        int option3 = (left + 1) + (n - right);

        return Math.min(option1, Math.min(option2, option3));
    }
}