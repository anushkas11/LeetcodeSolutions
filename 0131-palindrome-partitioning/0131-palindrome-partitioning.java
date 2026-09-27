class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        solve(0,s,new ArrayList<>());
        return ans;
    }
    public void solve(int start,String s,List<String> curr){
        if(start==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(start,i,s)){
                curr.add(s.substring(start,i+1));
                solve(i+1,s,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(int left,int right,String s){
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}