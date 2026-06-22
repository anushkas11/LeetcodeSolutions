class Solution {
    public int rearrangeCharacters(String s, String target) {
        int freq[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        for(int j=0;j<target.length();j++){
            char cj=target.charAt(j);
            freq2[cj-'a']++;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq2[i]!=0){
                ans = Math.min(ans, freq[i]/freq2[i]);
            }
        }
      return ans;
        
    }
}