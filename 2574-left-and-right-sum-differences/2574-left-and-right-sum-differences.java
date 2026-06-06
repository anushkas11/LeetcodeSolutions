class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int leftsum[]=new int[n];
        int rightsum[]=new int[n];
        int ans[]=new int[n];

        int left=0;
        leftsum[0]=left;
        for(int i=1;i<n;i++){
            left+=nums[i-1];
            leftsum[i]=left;
        }

        int right=0;
        rightsum[n-1]=right;
        for(int i=n-2;i>=0;i--){
            right+=nums[i+1];
            rightsum[i]=right;
        }
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return ans;
        
    }
}