class Solution {
    public String largestOddNumber(String num) {
        int ans=-1;
        for(int i=num.length()-1;i>=0;i--){
            if((num.charAt(i)-'0')%2==1){
                ans=i;
                break;
            }
        }
        return (ans==-1)?"":num.substring(0,ans+1);
    }
}