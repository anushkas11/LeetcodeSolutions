class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        for(int i=0;i<s.length()-1;i++){
            int x=s.charAt(i)-'0';
            int y=s.charAt(i+1)-'0';
            int diff=Math.abs(x-y);
            if(diff>2) return false;

        }
        return true;
    }
}