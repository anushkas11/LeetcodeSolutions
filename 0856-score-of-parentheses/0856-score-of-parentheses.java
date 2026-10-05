class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0); 

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(0); 
            } else {
                int innerScore = st.pop();
                int outerScore = st.pop();
                st.push(outerScore + Math.max(2 * innerScore, 1));
            }
        }

        return st.pop();
    }
}