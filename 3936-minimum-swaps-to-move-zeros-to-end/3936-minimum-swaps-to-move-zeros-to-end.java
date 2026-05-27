class Solution {
    public int minimumSwaps(int[] nums) {
        int left=0,right=nums.length-1;
        int swap=0;

        while(left<=right){
            if( nums[left]==0 && nums[right]!=0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                swap++;
                left++;
                right--;
            }
            else if(nums[left]==0 && nums[right]==0) right--;
            else left++;
        } 
        return swap;
    }
}