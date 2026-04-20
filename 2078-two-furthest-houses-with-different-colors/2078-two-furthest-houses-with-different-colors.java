class Solution {
    public int maxDistance(int[] colors) {
        int maxValue=0;
        for(int i=0;i<colors.length;i++){
            for(int j=i;j<colors.length;j++){
                if(colors[j]!=colors[i]) maxValue=Math.max(Math.abs(j-i),maxValue);
            }
        }
        
        return maxValue;
    }
}