class Solution {
    public boolean detectCapitalUse(String word) {
        int cap=0,c=0;
        if(Character.isUpperCase(word.charAt(0))) c++;
        for(int i=1;i<word.length();i++){
            char ch=word.charAt(i);
            if(Character.isUpperCase(ch)) cap++;
        }
        if(c==1 && cap==word.length()-1) return true;
        else if(c==1 && cap==0) return true;
        else if(c==0 && cap==0) return true;
        else return false;
    }
}