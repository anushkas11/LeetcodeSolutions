class Solution {
    public boolean isAnagram(String s, String t) {
        int freq[]=new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            char cs=s.charAt(i);
            char ct=t.charAt(i);

            freq[cs-'a']++;
            freq[ct-'a']--;

        }
        for(int x:freq){
            if(x!=0) return false;
        }
        return true;
    }
}