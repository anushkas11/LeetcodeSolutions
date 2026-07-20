class Solution {
    public String reverseVowels(String s) {
        int left=0,right=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(left<=right){
            if((isVowel(sb.charAt(left)) && isVowel(sb.charAt(right)))){
               char temp = sb.charAt(left);
               sb.setCharAt(left, sb.charAt(right));
               sb.setCharAt(right, temp);
                left++;
                right--;
            }
            else if(isVowel(sb.charAt(left)) && !isVowel(sb.charAt(right))) right--;
            else if(!isVowel(sb.charAt(left)) && isVowel(sb.charAt(right))) left++;
            else{
                left++;
                right--;
            }
        }
        return sb.toString();
    }
    public static boolean isVowel(char ch) {
       return "aeiouAEIOU".indexOf(ch) != -1;
    }
}