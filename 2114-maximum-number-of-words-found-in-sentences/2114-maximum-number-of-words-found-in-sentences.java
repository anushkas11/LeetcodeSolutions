class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans=Integer.MIN_VALUE;
        for(String s:sentences){
            String words[]=s.trim().split("\\s+");
            ans=Math.max(ans,words.length);
        }
        return ans;
    }
}