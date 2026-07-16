class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans="";
        int i=0,j=0;
        int m=word1.length() ,n=word2.length();
        boolean flag=true;
        while(i<m && j<n){
            if(flag) ans+=word1.charAt(i++);
            else ans+=word2.charAt(j++);
            flag=!flag;
        } 
        if(i<m){
            while(i<m) ans+=word1.charAt(i++);
        }
        if(j<n){
            while(j<n) ans+=word2.charAt(j++);
        }
        return ans.trim();
    }
}