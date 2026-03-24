class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    public int atmost(int nums[],int k){
        int count=0;
        int ans=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2==1) count++;
            while(count>k){
                if(nums[left]%2==1) count--;
                left++;
            }
            if(count<=k) ans+=right-left+1;

        }
        return ans;
    }
}