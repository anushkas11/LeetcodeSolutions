class Solution {
    public int minimumRecolors(String blocks, int k) {
        int black=0;
       for(int i=0;i<k;i++){
        if(blocks.charAt(i)=='B') black++;
       }
       int min=k-black;
       for(int i=k;i<blocks.length();i++){
        if(blocks.charAt(i)=='B') black++;
        if(blocks.charAt(i-k)=='B') black--;
        min=Math.min(min,k-black);
       }
       return min;
    }
}