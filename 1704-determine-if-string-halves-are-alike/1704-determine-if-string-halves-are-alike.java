class Solution {
    public boolean halvesAreAlike(String s) {
        String a="" ,b="";
        for(int i=0;i<s.length()/2;i++) a+=s.charAt(i);
        for(int i=s.length()/2;i<s.length();i++) b+=s.charAt(i);
        a=a.toLowerCase();
        b=b.toLowerCase();

        int counta=0,countb=0;
        for(int i=0;i<s.length()/2;i++){
            char ch=a.charAt(i);
            if(ch=='a' || ch=='e'|| ch=='i'||ch=='o'||ch=='u') counta++;
        }
        for(int i=0;i<s.length()/2;i++){
            char ch=b.charAt(i);
            if(ch=='a' || ch=='e'|| ch=='i'||ch=='o'||ch=='u') countb++;
        }

        return counta==countb;
    }
}