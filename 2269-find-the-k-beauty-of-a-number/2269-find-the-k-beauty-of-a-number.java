class Solution {
    public int divisorSubstrings(int num, int k) {
        String n=String.valueOf(num);
        int count=0;
        for(int i=0;i<=n.length()-k;i++){
           String sub=n.substring(i,i+k);
           int num1=Integer.parseInt(sub);
           if(num1!=0 && num%num1==0) count++;
        }
        return count;
    }
}