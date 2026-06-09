class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min=0,max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[min]){
                min=i;
            }
            if(nums[i]>nums[max]){
                max=i;
            }
        }
        int diff=nums[max]-nums[min];
        return (long)diff*k;
    }
}