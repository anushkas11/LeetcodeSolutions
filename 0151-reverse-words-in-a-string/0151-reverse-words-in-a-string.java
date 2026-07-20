class Solution {
    public String reverseWords(String s) {
        s=s.trim().replaceAll("\\s+", " ");
        String[] words=s.split(" ");
        int i=0;
        int j=words.length-1;
        while(i<j){
            String temp=words[i];
            words[i]=words[j];
            words[j]=temp;
            i++;
            j--;
        }
        String result = String.join(" ", words);
        return result;
    }
}