class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans=new ArrayList<>();
        solve(0,nums,new ArrayList<>());
        return ans;
    }
    public void solve(int start,int[] nums,List<Integer> curr){
        ans.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            solve(i+1,nums,curr);
            curr.remove(curr.size()-1);
        }
    }
}