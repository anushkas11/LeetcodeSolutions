class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        solve(0,0,new String(),n);
        return ans;
    }
    public void solve(int open,int close,String curr,int n){
        if(curr.length()==2*n) ans.add(curr);
        if(open<n) solve(open+1,close,curr+"(",n);
        if(close<open) solve(open,close+1,curr+")",n);
    }
}