class Solution {
    public String reverseWords(String s) {

        String[] words = s.split(" ");

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            String reversed =
                    new StringBuilder(words[i]).reverse().toString();

            ans.append(reversed);

            if (i != words.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}