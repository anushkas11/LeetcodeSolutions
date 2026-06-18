class Solution {
    public int myAtoi(String s) {
       int sign=1,i=0;
       s=s.trim();
       if(s.length()==0) return 0;
       if(s.charAt(i)=='-'){
        sign=-1;
        i++;
       }
       else if(s.charAt(i)=='+'){
        sign=1;
        i++;
       }
      

       long d=0;
       while(i<s.length() && Character.isDigit(s.charAt(i))){
        char c=s.charAt(i);
        d=d*10+(c-'0');
        if(sign*d>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign*d<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        i++;
       } 
       return (int)(sign*d);
    }
}