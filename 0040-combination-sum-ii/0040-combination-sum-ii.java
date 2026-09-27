class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans=new ArrayList<>();
        solve(0,candidates,target,new ArrayList<>());
        return ans;
    }
    public void solve(int start,int []candidates,int target,List<Integer> curr){
        if(target==0) ans.add(new ArrayList<>(curr));
        if(target<0) return;
        for(int i=start;i<candidates.length;i++){
            if (candidates[i] > target) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            solve(i+1,candidates,target-candidates[i],curr);
            curr.remove(curr.size()-1);
        }
    }
}