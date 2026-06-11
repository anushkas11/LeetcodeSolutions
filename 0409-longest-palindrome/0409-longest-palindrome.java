class Solution {
    public int longestPalindrome(String s) {
        int freq[]=new int[128];
        for(char ch:s.toCharArray()){
            freq[ch]++;
        }
        int len=0;
        boolean odd=false;
        for(int f:freq){
            len+=(f/2)*2;
            if(f%2==1) odd=true;
        }
        if(odd) len+=1;
        return len;
    }
}