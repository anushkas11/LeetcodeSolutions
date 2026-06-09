class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
      int arrs[]=new int[26];
      int arrt[]=new int[26];
      for(int i=0;i<s.length();i++){
        char cs=s.charAt(i);
        char ct=t.charAt(i);

        arrs[cs-'a']++;
        arrt[ct-'a']++;
      }
      for(int i=0;i<26;i++){
        if(arrs[i]!=arrt[i]) return false;
      }
      return true;
    }
}