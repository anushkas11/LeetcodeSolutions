class Solution {
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans=new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(0,digits,mapping,new StringBuilder());
        return ans;
    }
    public void solve(int start,String digits,String[] mapping,StringBuilder curr){
        if(start==digits.length()){
            ans.add(curr.toString());
            return;
        }
        String letters=mapping[digits.charAt(start)-'0'];
        for(int i=0;i<letters.length();i++){
            curr.append(letters.charAt(i));
            solve(start+1,digits,mapping,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}