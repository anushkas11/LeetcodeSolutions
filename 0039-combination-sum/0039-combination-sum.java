class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        solve(0,candidates,target,new ArrayList<>());
        return ans;
    }
    public void solve(int start,int []candidates,int target,List<Integer> curr){
        if(target==0) ans.add(new ArrayList<>(curr));
        if(target<0) return;
        for(int i=start;i<candidates.length;i++){
            curr.add(candidates[i]);
            solve(i,candidates,target-candidates[i],curr);
            curr.remove(curr.size()-1);
        }
    }
}