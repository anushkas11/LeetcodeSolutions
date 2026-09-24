class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(digitsum(nums[i])==i) return i;
        }
        return -1;
    }
    public int digitsum(int k){
        int sum=0;
        while(k>0){
            sum+=k%10;
            k/=10;
        }
        return sum;
    }
}