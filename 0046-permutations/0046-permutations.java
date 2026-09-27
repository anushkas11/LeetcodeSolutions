class Solution {
    List<List<Integer>> ans;int n;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        n=nums.length;
        boolean used[]=new boolean[n];
        solve(nums,used,new ArrayList<>());
        return ans;
    }
    public void solve(int[] nums,boolean used[],List<Integer> curr){
        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++){
            if(used[i]) continue;
            used[i]=true;
            curr.add(nums[i]);
            solve(nums,used,curr);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}